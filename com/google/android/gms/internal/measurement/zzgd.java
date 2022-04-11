package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgd
  extends zzkd<zzgd, zzgc>
  implements zzlj
{
  private static final zzgd zzh;
  private zzkj zza = zzkd.zzbC();
  private zzkj zze = zzkd.zzbC();
  private zzkk<zzfm> zzf = zzkd.zzbE();
  private zzkk<zzgf> zzg = zzkd.zzbE();
  
  static
  {
    zzgd localzzgd = new zzgd();
    zzh = localzzgd;
    zzkd.zzby(zzgd.class, localzzgd);
  }
  
  public static zzgc zzk()
  {
    return (zzgc)zzh.zzbt();
  }
  
  public static zzgd zzm()
  {
    return zzh;
  }
  
  private final void zzw()
  {
    zzkk localzzkk = this.zzf;
    if (!localzzkk.zza()) {
      this.zzf = zzkd.zzbF(localzzkk);
    }
  }
  
  private final void zzx()
  {
    zzkk localzzkk = this.zzg;
    if (!localzzkk.zza()) {
      this.zzg = zzkd.zzbF(localzzkk);
    }
  }
  
  public final List<Long> zza()
  {
    return this.zza;
  }
  
  public final int zzb()
  {
    return this.zza.size();
  }
  
  public final List<Long> zzc()
  {
    return this.zze;
  }
  
  public final int zzd()
  {
    return this.zze.size();
  }
  
  public final List<zzfm> zze()
  {
    return this.zzf;
  }
  
  public final int zzf()
  {
    return this.zzf.size();
  }
  
  public final zzfm zzg(int paramInt)
  {
    return (zzfm)this.zzf.get(paramInt);
  }
  
  public final List<zzgf> zzh()
  {
    return this.zzg;
  }
  
  public final int zzi()
  {
    return this.zzg.size();
  }
  
  public final zzgf zzj(int paramInt)
  {
    return (zzgf)this.zzg.get(paramInt);
  }
  
  protected final Object zzl(int paramInt, Object paramObject1, Object paramObject2)
  {
    
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return zzh;
          }
          return new zzgc(null);
        }
        return new zzgd();
      }
      return zzkd.zzbz(zzh, "\001\004\000\000\001\004\004\000\004\000\001\025\002\025\003\033\004\033", new Object[] { "zza", "zze", "zzf", zzfm.class, "zzg", zzgf.class });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */