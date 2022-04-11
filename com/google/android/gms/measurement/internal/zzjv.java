package com.google.android.gms.measurement.internal;

import android.os.Handler;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;

final class zzjv
{
  private zzju zzb;
  
  zzjv(zzjz paramzzjz) {}
  
  @WorkerThread
  final void zza()
  {
    this.zza.zzg();
    if (this.zzb != null) {
      zzjz.zzk(this.zza).removeCallbacks(this.zzb);
    }
    if (this.zza.zzs.zzc().zzn(null, zzea.zzar)) {
      this.zza.zzs.zzd().zzl.zzb(false);
    }
  }
  
  @WorkerThread
  final void zzb(long paramLong)
  {
    this.zzb = new zzju(this, this.zza.zzs.zzay().currentTimeMillis(), paramLong);
    zzjz.zzk(this.zza).postDelayed(this.zzb, 2000L);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */