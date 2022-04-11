package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzkd;
import java.util.ArrayList;
import java.util.List;

final class zzkm
{
  zzfw zza;
  List<Long> zzb;
  List<zzfo> zzc;
  long zzd;
  
  private static final long zzb(zzfo paramzzfo)
  {
    return paramzzfo.zzf() / 1000L / 60L / 60L;
  }
  
  public final boolean zza(long paramLong, zzfo paramzzfo)
  {
    Preconditions.checkNotNull(paramzzfo);
    if (this.zzc == null) {
      this.zzc = new ArrayList();
    }
    if (this.zzb == null) {
      this.zzb = new ArrayList();
    }
    if ((this.zzc.size() > 0) && (zzb((zzfo)this.zzc.get(0)) != zzb(paramzzfo))) {
      return false;
    }
    long l = this.zzd + paramzzfo.zzbw();
    this.zze.zzd();
    if (l >= Math.max(0, ((Integer)zzea.zzh.zzb(null)).intValue())) {
      return false;
    }
    this.zzd = l;
    this.zzc.add(paramzzfo);
    this.zzb.add(Long.valueOf(paramLong));
    int i = this.zzc.size();
    this.zze.zzd();
    return i < Math.max(1, ((Integer)zzea.zzi.zzb(null)).intValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */