package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;

public final class AppMeasurementService
  extends Service
  implements zzjp
{
  private zzjq<AppMeasurementService> zza;
  
  private final zzjq<AppMeasurementService> zzd()
  {
    if (this.zza == null) {
      this.zza = new zzjq(this);
    }
    return this.zza;
  }
  
  @MainThread
  @NonNull
  public IBinder onBind(@NonNull Intent paramIntent)
  {
    return zzd().zze(paramIntent);
  }
  
  @MainThread
  public void onCreate()
  {
    super.onCreate();
    zzd().zza();
  }
  
  @MainThread
  public void onDestroy()
  {
    zzd().zzb();
    super.onDestroy();
  }
  
  @MainThread
  public void onRebind(@NonNull Intent paramIntent)
  {
    zzd().zzh(paramIntent);
  }
  
  @MainThread
  public int onStartCommand(@NonNull Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzd().zzc(paramIntent, paramInt1, paramInt2);
    return 2;
  }
  
  @MainThread
  public boolean onUnbind(@NonNull Intent paramIntent)
  {
    zzd().zzf(paramIntent);
    return true;
  }
  
  public final boolean zza(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  public final void zzb(@NonNull JobParameters paramJobParameters, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void zzc(@NonNull Intent paramIntent)
  {
    WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\AppMeasurementService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */