package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzka
{
  private final Clock zza;
  private long zzb;
  
  public zzka(Clock paramClock)
  {
    Preconditions.checkNotNull(paramClock);
    this.zza = paramClock;
  }
  
  public final void zza()
  {
    this.zzb = this.zza.elapsedRealtime();
  }
  
  public final void zzb()
  {
    this.zzb = 0L;
  }
  
  public final boolean zzc(long paramLong)
  {
    if (this.zzb == 0L) {
      return true;
    }
    return this.zza.elapsedRealtime() - this.zzb >= 3600000L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */