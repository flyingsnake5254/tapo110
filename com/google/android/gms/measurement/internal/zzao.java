package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzao
{
  final String zza;
  final String zzb;
  final long zzc;
  final long zzd;
  final long zze;
  final long zzf;
  final long zzg;
  final Long zzh;
  final Long zzi;
  final Long zzj;
  final Boolean zzk;
  
  zzao(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, Long paramLong6, Long paramLong7, Long paramLong8, Boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    boolean bool1 = true;
    boolean bool2;
    if (paramLong1 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    if (paramLong2 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    if (paramLong3 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    if (paramLong5 >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramLong1;
    this.zzd = paramLong2;
    this.zze = paramLong3;
    this.zzf = paramLong4;
    this.zzg = paramLong5;
    this.zzh = paramLong6;
    this.zzi = paramLong7;
    this.zzj = paramLong8;
    this.zzk = paramBoolean;
  }
  
  final zzao zza(long paramLong)
  {
    return new zzao(this.zza, this.zzb, this.zzc, this.zzd, this.zze, paramLong, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
  }
  
  final zzao zzb(long paramLong1, long paramLong2)
  {
    return new zzao(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, paramLong1, Long.valueOf(paramLong2), this.zzi, this.zzj, this.zzk);
  }
  
  final zzao zzc(Long paramLong1, Long paramLong2, Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (!paramBoolean.booleanValue())) {
      paramBoolean = null;
    }
    return new zzao(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, paramLong1, paramLong2, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */