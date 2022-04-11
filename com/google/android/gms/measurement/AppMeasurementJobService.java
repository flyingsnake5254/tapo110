package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;

@TargetApi(24)
public final class AppMeasurementJobService
  extends JobService
  implements zzjp
{
  private zzjq<AppMeasurementJobService> zza;
  
  private final zzjq<AppMeasurementJobService> zzd()
  {
    if (this.zza == null) {
      this.zza = new zzjq(this);
    }
    return this.zza;
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
  
  public boolean onStartJob(@NonNull JobParameters paramJobParameters)
  {
    zzd().zzg(paramJobParameters);
    return true;
  }
  
  public boolean onStopJob(@NonNull JobParameters paramJobParameters)
  {
    return false;
  }
  
  @MainThread
  public boolean onUnbind(@NonNull Intent paramIntent)
  {
    zzd().zzf(paramIntent);
    return true;
  }
  
  public final boolean zza(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @TargetApi(24)
  public final void zzb(@NonNull JobParameters paramJobParameters, boolean paramBoolean)
  {
    jobFinished(paramJobParameters, false);
  }
  
  public final void zzc(@NonNull Intent paramIntent) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\AppMeasurementJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */