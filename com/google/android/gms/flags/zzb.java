package com.google.android.gms.flags;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;

public final class zzb
{
  private boolean zzj = false;
  private zzc zzk = null;
  
  public final void initialize(Context paramContext)
  {
    try
    {
      if (this.zzj) {
        return;
      }
      try
      {
        zzc localzzc = zzd.asInterface(DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.flags").instantiate("com.google.android.gms.flags.impl.FlagProviderImpl"));
        this.zzk = localzzc;
        localzzc.init(ObjectWrapper.wrap(paramContext));
        this.zzj = true;
      }
      catch (RemoteException paramContext) {}catch (DynamiteModule.LoadingException paramContext) {}
      Log.w("FlagValueProvider", "Failed to initialize flags module.", paramContext);
      return;
    }
    finally {}
  }
  
  public final <T> T zzb(Flag<T> paramFlag)
  {
    try
    {
      if (!this.zzj)
      {
        paramFlag = paramFlag.zzb();
        return paramFlag;
      }
      return (T)paramFlag.zza(this.zzk);
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */