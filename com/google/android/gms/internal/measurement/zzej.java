package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzej
  extends zzkd<zzej, zzei>
  implements zzlj
{
  private static final zzej zzm;
  private int zza;
  private int zze;
  private String zzf = "";
  private zzkk<zzel> zzg = zzkd.zzbE();
  private boolean zzh;
  private zzeq zzi;
  private boolean zzj;
  private boolean zzk;
  private boolean zzl;
  
  static
  {
    zzej localzzej = new zzej();
    zzm = localzzej;
    zzkd.zzby(zzej.class, localzzej);
  }
  
  public static zzei zzn()
  {
    return (zzei)zzm.zzbt();
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final int zzb()
  {
    return this.zze;
  }
  
  public final String zzc()
  {
    return this.zzf;
  }
  
  public final List<zzel> zzd()
  {
    return this.zzg;
  }
  
  public final int zze()
  {
    return this.zzg.size();
  }
  
  public final zzel zzf(int paramInt)
  {
    return (zzel)this.zzg.get(paramInt);
  }
  
  public final boolean zzg()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final zzeq zzh()
  {
    zzeq localzzeq1 = this.zzi;
    zzeq localzzeq2 = localzzeq1;
    if (localzzeq1 == null) {
      localzzeq2 = zzeq.zzk();
    }
    return localzzeq2;
  }
  
  public final boolean zzi()
  {
    return this.zzj;
  }
  
  public final boolean zzj()
  {
    return this.zzk;
  }
  
  public final boolean zzk()
  {
    return (this.zza & 0x40) != 0;
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
            return zzm;
          }
          return new zzei(null);
        }
        return new zzej();
      }
      return zzkd.zzbz(zzm, "\001\b\000\001\001\b\b\000\001\000\001င\000\002ဈ\001\003\033\004ဇ\002\005ဉ\003\006ဇ\004\007ဇ\005\bဇ\006", new Object[] { "zza", "zze", "zzf", "zzg", zzel.class, "zzh", "zzi", "zzj", "zzk", "zzl" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean zzm()
  {
    return this.zzl;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */