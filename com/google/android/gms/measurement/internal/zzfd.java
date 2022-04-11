package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzbq;

public final class zzfd
  implements ServiceConnection
{
  private final String zzb;
  
  zzfd(zzfe paramzzfe, String paramString)
  {
    this.zzb = paramString;
  }
  
  @MainThread
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      try
      {
        paramComponentName = zzbq.zzb(paramIBinder);
        if (paramComponentName == null)
        {
          this.zza.zza.zzau().zze().zza("Install Referrer Service implementation was not found");
          return;
        }
        this.zza.zza.zzau().zzk().zza("Install Referrer Service connected");
        paramIBinder = this.zza.zza.zzav();
        zzfc localzzfc = new com/google/android/gms/measurement/internal/zzfc;
        localzzfc.<init>(this, paramComponentName, this);
        paramIBinder.zzh(localzzfc);
        return;
      }
      catch (RuntimeException paramComponentName)
      {
        this.zza.zza.zzau().zze().zzb("Exception occurred while calling Install Referrer API", paramComponentName);
        return;
      }
    }
    this.zza.zza.zzau().zze().zza("Install Referrer connection returned with null binder");
  }
  
  @MainThread
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.zza.zza.zzau().zzk().zza("Install Referrer Service disconnected");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */