package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzs<T>
{
  private static String PREFIX = "com.google.android.gms.vision.dynamite";
  private final Object lock = new Object();
  private final String tag;
  private final String zzdm;
  private final String zzdn;
  private final boolean zzdo;
  private boolean zzdp;
  private boolean zzdq;
  @GuardedBy("lock")
  private T zzdr;
  private final Context zzg;
  
  public zzs(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool1 = false;
    this.zzdp = false;
    this.zzdq = false;
    this.zzg = paramContext;
    this.tag = paramString1;
    String str = PREFIX;
    paramString1 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(paramString2).length());
    paramString1.append(str);
    paramString1.append(".");
    paramString1.append(paramString2);
    this.zzdm = paramString1.toString();
    this.zzdn = paramString2;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      zzbj.maybeInit(paramContext);
      bool2 = zzla.zzjq();
      paramContext = Boolean.TRUE;
      paramContext = zzdl.zza("barcode", Boolean.valueOf(bool2), "face", paramContext, "ica", Boolean.valueOf(zzla.zzjr()), "ocr", paramContext);
      int i;
      if ((paramContext.containsKey(paramString2)) && (((Boolean)paramContext.get(paramString2)).booleanValue())) {
        i = 1;
      } else {
        i = 0;
      }
      bool2 = bool1;
      if (i != 0) {
        bool2 = true;
      }
    }
    this.zzdo = bool2;
  }
  
  public final boolean isOperational()
  {
    return zzq() != null;
  }
  
  protected abstract T zza(DynamiteModule paramDynamiteModule, Context paramContext)
    throws RemoteException, DynamiteModule.LoadingException;
  
  protected abstract void zzo()
    throws RemoteException;
  
  public final void zzp()
  {
    synchronized (this.lock)
    {
      if (this.zzdr == null) {
        return;
      }
      try
      {
        zzo();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e(this.tag, "Could not finalize native handle", localRemoteException);
      }
      return;
    }
  }
  
  protected final T zzq()
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.zzdr;
      if (localObject2 != null) {
        return (T)localObject2;
      }
      Object localObject3;
      try
      {
        localObject2 = DynamiteModule.load(this.zzg, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, this.zzdm);
      }
      catch (DynamiteModule.LoadingException localLoadingException1)
      {
        Log.d(this.tag, "Cannot load feature, fall back to load dynamite module.");
        DynamiteModule localDynamiteModule = zzw.zza(this.zzg, this.zzdn, this.zzdo);
        localObject3 = localDynamiteModule;
        if (localDynamiteModule == null)
        {
          localObject3 = localDynamiteModule;
          if (this.zzdo)
          {
            localObject3 = localDynamiteModule;
            if (!this.zzdp)
            {
              String str = this.tag;
              localObject3 = String.valueOf(this.zzdn);
              if (((String)localObject3).length() != 0) {
                localObject3 = "Broadcasting download intent for dependency ".concat((String)localObject3);
              } else {
                localObject3 = new String("Broadcasting download intent for dependency ");
              }
              Log.d(str, (String)localObject3);
              str = this.zzdn;
              localObject3 = new android/content/Intent;
              ((Intent)localObject3).<init>();
              ((Intent)localObject3).setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
              ((Intent)localObject3).putExtra("com.google.android.gms.vision.DEPENDENCIES", str);
              ((Intent)localObject3).setAction("com.google.android.gms.vision.DEPENDENCY");
              this.zzg.sendBroadcast((Intent)localObject3);
              this.zzdp = true;
              localObject3 = localDynamiteModule;
            }
          }
        }
      }
      if (localObject3 != null)
      {
        try
        {
          this.zzdr = zza((DynamiteModule)localObject3, this.zzg);
        }
        catch (RemoteException localRemoteException) {}catch (DynamiteModule.LoadingException localLoadingException2) {}
        Log.e(this.tag, "Error creating remote native handle", localLoadingException2);
      }
      boolean bool = this.zzdq;
      if ((!bool) && (this.zzdr == null))
      {
        Log.w(this.tag, "Native handle not yet available. Reverting to no-op handle.");
        this.zzdq = true;
      }
      else if ((bool) && (this.zzdr != null))
      {
        Log.w(this.tag, "Native handle is now available.");
      }
      Object localObject4 = this.zzdr;
      return (T)localObject4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */