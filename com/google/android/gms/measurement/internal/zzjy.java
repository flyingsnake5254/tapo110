package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoa;

final class zzjy
{
  zzjy(zzjz paramzzjz) {}
  
  @WorkerThread
  final void zza()
  {
    this.zza.zzg();
    if (this.zza.zzs.zzd().zzl(this.zza.zzs.zzay().currentTimeMillis()))
    {
      this.zza.zzs.zzd().zzg.zzb(true);
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if (localRunningAppProcessInfo.importance == 100)
      {
        this.zza.zzs.zzau().zzk().zza("Detected application was in foreground");
        zzc(this.zza.zzs.zzay().currentTimeMillis(), false);
      }
    }
  }
  
  @WorkerThread
  final void zzb(long paramLong, boolean paramBoolean)
  {
    this.zza.zzg();
    zzjz.zzj(this.zza);
    if (this.zza.zzs.zzd().zzl(paramLong)) {
      this.zza.zzs.zzd().zzg.zzb(true);
    }
    this.zza.zzs.zzd().zzj.zzb(paramLong);
    if (this.zza.zzs.zzd().zzg.zza()) {
      zzc(paramLong, paramBoolean);
    }
  }
  
  @WorkerThread
  @VisibleForTesting
  final void zzc(long paramLong, boolean paramBoolean)
  {
    this.zza.zzg();
    if (!this.zza.zzs.zzF()) {
      return;
    }
    this.zza.zzs.zzd().zzj.zzb(paramLong);
    long l = this.zza.zzs.zzay().elapsedRealtime();
    this.zza.zzs.zzau().zzk().zzb("Session started, time", Long.valueOf(l));
    Object localObject1 = Long.valueOf(paramLong / 1000L);
    this.zza.zzs.zzk().zzB("auto", "_sid", localObject1, paramLong);
    this.zza.zzs.zzd().zzg.zzb(false);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putLong("_sid", ((Long)localObject1).longValue());
    if ((this.zza.zzs.zzc().zzn(null, zzea.zzah)) && (paramBoolean)) {
      ((Bundle)localObject2).putLong("_aib", 1L);
    }
    this.zza.zzs.zzk().zzt("auto", "_s", paramLong, (Bundle)localObject2);
    zzoa.zzb();
    if (this.zza.zzs.zzc().zzn(null, zzea.zzam))
    {
      localObject2 = this.zza.zzs.zzd().zzo.zza();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("_ffr", (String)localObject2);
        this.zza.zzs.zzk().zzt("auto", "_ssr", paramLong, (Bundle)localObject1);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */