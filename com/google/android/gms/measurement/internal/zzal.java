package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzby;

abstract class zzal
{
  private static volatile Handler zzb;
  private final zzgp zza;
  private final Runnable zzc;
  private volatile long zzd;
  
  zzal(zzgp paramzzgp)
  {
    Preconditions.checkNotNull(paramzzgp);
    this.zza = paramzzgp;
    this.zzc = new zzak(this, paramzzgp);
  }
  
  private final Handler zzf()
  {
    if (zzb != null) {
      return zzb;
    }
    try
    {
      if (zzb == null)
      {
        localObject1 = new com/google/android/gms/internal/measurement/zzby;
        ((zzby)localObject1).<init>(this.zza.zzax().getMainLooper());
        zzb = (Handler)localObject1;
      }
      Object localObject1 = zzb;
      return (Handler)localObject1;
    }
    finally {}
  }
  
  public abstract void zza();
  
  public final void zzb(long paramLong)
  {
    zzd();
    if (paramLong >= 0L)
    {
      this.zzd = this.zza.zzay().currentTimeMillis();
      if (!zzf().postDelayed(this.zzc, paramLong)) {
        this.zza.zzau().zzb().zzb("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public final boolean zzc()
  {
    return this.zzd != 0L;
  }
  
  final void zzd()
  {
    this.zzd = 0L;
    zzf().removeCallbacks(this.zzc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */