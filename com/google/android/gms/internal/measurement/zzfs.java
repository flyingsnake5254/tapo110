package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfs
  extends zzkd<zzfs, zzfr>
  implements zzlj
{
  private static final zzfs zzk;
  private int zza;
  private String zze = "";
  private String zzf = "";
  private long zzg;
  private float zzh;
  private double zzi;
  private zzkk<zzfs> zzj = zzkd.zzbE();
  
  static
  {
    zzfs localzzfs = new zzfs();
    zzk = localzzfs;
    zzkd.zzby(zzfs.class, localzzfs);
  }
  
  public static zzfr zzn()
  {
    return (zzfr)zzk.zzbt();
  }
  
  private final void zzz()
  {
    zzkk localzzkk = this.zzj;
    if (!localzzkk.zza()) {
      this.zzj = zzkd.zzbF(localzzkk);
    }
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final String zzb()
  {
    return this.zze;
  }
  
  public final boolean zzc()
  {
    return (this.zza & 0x2) != 0;
  }
  
  public final String zzd()
  {
    return this.zzf;
  }
  
  public final boolean zze()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final long zzf()
  {
    return this.zzg;
  }
  
  public final boolean zzg()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final float zzh()
  {
    return this.zzh;
  }
  
  public final boolean zzi()
  {
    return (this.zza & 0x10) != 0;
  }
  
  public final double zzj()
  {
    return this.zzi;
  }
  
  public final List<zzfs> zzk()
  {
    return this.zzj;
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
            return zzk;
          }
          return new zzfr(null);
        }
        return new zzfs();
      }
      return zzkd.zzbz(zzk, "\001\006\000\001\001\006\006\000\001\000\001ဈ\000\002ဈ\001\003ဂ\002\004ခ\003\005က\004\006\033", new Object[] { "zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfs.class });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final int zzm()
  {
    return this.zzj.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */