package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzom;

final class zzjx
{
  @VisibleForTesting
  protected long zza;
  @VisibleForTesting
  protected long zzb;
  private final zzal zzd;
  
  public zzjx(zzjz paramzzjz)
  {
    this.zzd = new zzjw(this, paramzzjz.zzs);
    long l = paramzzjz.zzs.zzay().elapsedRealtime();
    this.zza = l;
    this.zzb = l;
  }
  
  @WorkerThread
  final void zza(long paramLong)
  {
    this.zzc.zzg();
    this.zzd.zzd();
    this.zza = paramLong;
    this.zzb = paramLong;
  }
  
  @WorkerThread
  final void zzb(long paramLong)
  {
    this.zzd.zzd();
  }
  
  final void zzc()
  {
    this.zzd.zzd();
    this.zza = 0L;
    this.zzb = 0L;
  }
  
  @WorkerThread
  public final boolean zzd(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.zzc.zzg();
    this.zzc.zzb();
    zzom.zzb();
    if (this.zzc.zzs.zzc().zzn(null, zzea.zzan))
    {
      if (this.zzc.zzs.zzF()) {
        this.zzc.zzs.zzd().zzj.zzb(this.zzc.zzs.zzay().currentTimeMillis());
      }
    }
    else {
      this.zzc.zzs.zzd().zzj.zzb(this.zzc.zzs.zzay().currentTimeMillis());
    }
    long l = paramLong - this.zza;
    if ((!paramBoolean1) && (l < 1000L))
    {
      this.zzc.zzs.zzau().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l));
      return false;
    }
    if (!paramBoolean2)
    {
      l = paramLong - this.zzb;
      this.zzb = paramLong;
    }
    this.zzc.zzs.zzau().zzk().zzb("Recording user engagement, ms", Long.valueOf(l));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l);
    paramBoolean1 = this.zzc.zzs.zzc().zzt();
    zzik.zzm(this.zzc.zzs.zzx().zzh(paramBoolean1 ^ true), localBundle, true);
    zzae localzzae = this.zzc.zzs.zzc();
    zzdz localzzdz = zzea.zzT;
    if ((!localzzae.zzn(null, localzzdz)) && (paramBoolean2)) {
      localBundle.putLong("_fr", 1L);
    }
    if ((!this.zzc.zzs.zzc().zzn(null, localzzdz)) || (!paramBoolean2)) {
      this.zzc.zzs.zzk().zzs("auto", "_e", localBundle);
    }
    this.zza = paramLong;
    this.zzd.zzd();
    this.zzd.zzb(3600000L);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */