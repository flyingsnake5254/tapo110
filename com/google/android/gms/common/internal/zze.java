package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class zze
  extends GmsClientSupervisor
  implements Handler.Callback
{
  private final Handler mHandler;
  @GuardedBy("mConnectionStatus")
  private final HashMap<GmsClientSupervisor.zza, zzf> zzdu = new HashMap();
  private final Context zzdv;
  private final ConnectionTracker zzdw;
  private final long zzdx;
  private final long zzdy;
  
  zze(Context paramContext)
  {
    this.zzdv = paramContext.getApplicationContext();
    this.mHandler = new com.google.android.gms.internal.common.zze(paramContext.getMainLooper(), this);
    this.zzdw = ConnectionTracker.getInstance();
    this.zzdx = 5000L;
    this.zzdy = 300000L;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      synchronized (this.zzdu)
      {
        GmsClientSupervisor.zza localzza = (GmsClientSupervisor.zza)paramMessage.obj;
        zzf localzzf = (zzf)this.zzdu.get(localzza);
        if ((localzzf != null) && (localzzf.getState() == 3))
        {
          paramMessage = String.valueOf(localzza);
          i = paramMessage.length();
          ??? = new java/lang/StringBuilder;
          ((StringBuilder)???).<init>(i + 47);
          ((StringBuilder)???).append("Timeout waiting for ServiceConnection callback ");
          ((StringBuilder)???).append(paramMessage);
          ??? = ((StringBuilder)???).toString();
          paramMessage = new java/lang/Exception;
          paramMessage.<init>();
          Log.e("GmsClientSupervisor", (String)???, paramMessage);
          ??? = localzzf.getComponentName();
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = localzza.getComponentName();
          }
          ??? = paramMessage;
          if (paramMessage == null)
          {
            ??? = new android/content/ComponentName;
            ((ComponentName)???).<init>(localzza.getPackage(), "unknown");
          }
          localzzf.onServiceDisconnected((ComponentName)???);
        }
        return true;
      }
    }
    synchronized (this.zzdu)
    {
      ??? = (GmsClientSupervisor.zza)paramMessage.obj;
      paramMessage = (zzf)this.zzdu.get(???);
      if ((paramMessage != null) && (paramMessage.zzr()))
      {
        if (paramMessage.isBound()) {
          paramMessage.zzf("GmsClientSupervisor");
        }
        this.zzdu.remove(???);
      }
      return true;
    }
  }
  
  protected final boolean zza(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzdu)
    {
      zzf localzzf = (zzf)this.zzdu.get(paramzza);
      if (localzzf == null)
      {
        localzzf = new com/google/android/gms/common/internal/zzf;
        localzzf.<init>(this, paramzza);
        localzzf.zza(paramServiceConnection, paramString);
        localzzf.zze(paramString);
        this.zzdu.put(paramzza, localzzf);
        paramzza = localzzf;
      }
      else
      {
        this.mHandler.removeMessages(0, paramzza);
        if (localzzf.zza(paramServiceConnection)) {
          break label169;
        }
        localzzf.zza(paramServiceConnection, paramString);
        i = localzzf.getState();
        if (i != 1)
        {
          if (i != 2)
          {
            paramzza = localzzf;
          }
          else
          {
            localzzf.zze(paramString);
            paramzza = localzzf;
          }
        }
        else
        {
          paramServiceConnection.onServiceConnected(localzzf.getComponentName(), localzzf.getBinder());
          paramzza = localzzf;
        }
      }
      boolean bool = paramzza.isBound();
      return bool;
      label169:
      paramServiceConnection = new java/lang/IllegalStateException;
      paramzza = String.valueOf(paramzza);
      int i = paramzza.length();
      paramString = new java/lang/StringBuilder;
      paramString.<init>(i + 81);
      paramString.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
      paramString.append(paramzza);
      paramServiceConnection.<init>(paramString.toString());
      throw paramServiceConnection;
    }
  }
  
  protected final void zzb(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzdu)
    {
      zzf localzzf = (zzf)this.zzdu.get(paramzza);
      if (localzzf != null)
      {
        if (localzzf.zza(paramServiceConnection))
        {
          localzzf.zzb(paramServiceConnection, paramString);
          if (localzzf.zzr())
          {
            paramzza = this.mHandler.obtainMessage(0, paramzza);
            this.mHandler.sendMessageDelayed(paramzza, this.zzdx);
          }
          return;
        }
        paramServiceConnection = new java/lang/IllegalStateException;
        paramString = String.valueOf(paramzza);
        i = paramString.length();
        paramzza = new java/lang/StringBuilder;
        paramzza.<init>(i + 76);
        paramzza.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        paramzza.append(paramString);
        paramServiceConnection.<init>(paramzza.toString());
        throw paramServiceConnection;
      }
      paramServiceConnection = new java/lang/IllegalStateException;
      paramzza = String.valueOf(paramzza);
      int i = paramzza.length();
      paramString = new java/lang/StringBuilder;
      paramString.<init>(i + 50);
      paramString.append("Nonexistent connection status for service config: ");
      paramString.append(paramzza);
      paramServiceConnection.<init>(paramString.toString());
      throw paramServiceConnection;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */