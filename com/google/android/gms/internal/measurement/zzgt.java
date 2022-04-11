package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgt
  extends zzkd<zzgt, zzgp>
  implements zzlj
{
  private static final zzgt zzk;
  private int zza;
  private int zze;
  private zzkk<zzgt> zzf = zzkd.zzbE();
  private String zzg = "";
  private String zzh = "";
  private boolean zzi;
  private double zzj;
  
  static
  {
    zzgt localzzgt = new zzgt();
    zzk = localzzgt;
    zzkd.zzby(zzgt.class, localzzgt);
  }
  
  public final zzgs zza()
  {
    zzgs localzzgs1 = zzgs.zza(this.zze);
    zzgs localzzgs2 = localzzgs1;
    if (localzzgs1 == null) {
      localzzgs2 = zzgs.zza;
    }
    return localzzgs2;
  }
  
  public final List<zzgt> zzb()
  {
    return this.zzf;
  }
  
  public final String zzc()
  {
    return this.zzg;
  }
  
  public final boolean zzd()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final String zze()
  {
    return this.zzh;
  }
  
  public final boolean zzf()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final boolean zzg()
  {
    return this.zzi;
  }
  
  public final boolean zzh()
  {
    return (this.zza & 0x10) != 0;
  }
  
  public final double zzi()
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
          return new zzgp(null);
        }
        return new zzgt();
      }
      paramObject1 = zzgs.zzb();
      return zzkd.zzbz(zzk, "\001\006\000\001\001\006\006\000\001\000\001ဌ\000\002\033\003ဈ\001\004ဈ\002\005ဇ\003\006က\004", new Object[] { "zza", "zze", paramObject1, "zzf", zzgt.class, "zzg", "zzh", "zzi", "zzj" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */