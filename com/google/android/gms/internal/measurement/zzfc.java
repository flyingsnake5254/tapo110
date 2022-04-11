package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfc
  extends zzkd<zzfc, zzfb>
  implements zzlj
{
  private static final zzfc zzn;
  private int zza;
  private long zze;
  private String zzf = "";
  private int zzg;
  private zzkk<zzfe> zzh = zzkd.zzbE();
  private zzkk<zzfa> zzi = zzkd.zzbE();
  private zzkk<zzeh> zzj = zzkd.zzbE();
  private String zzk = "";
  private boolean zzl;
  private zzkk<zzgo> zzm = zzkd.zzbE();
  
  static
  {
    zzfc localzzfc = new zzfc();
    zzn = localzzfc;
    zzkd.zzby(zzfc.class, localzzfc);
  }
  
  public static zzfb zzm()
  {
    return (zzfb)zzn.zzbt();
  }
  
  public static zzfc zzn()
  {
    return zzn;
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final long zzb()
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
  
  public final List<zzfe> zze()
  {
    return this.zzh;
  }
  
  public final int zzf()
  {
    return this.zzi.size();
  }
  
  public final zzfa zzg(int paramInt)
  {
    return (zzfa)this.zzi.get(paramInt);
  }
  
  public final List<zzeh> zzh()
  {
    return this.zzj;
  }
  
  public final boolean zzi()
  {
    return this.zzl;
  }
  
  public final List<zzgo> zzj()
  {
    return this.zzm;
  }
  
  public final int zzk()
  {
    return this.zzm.size();
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
            return zzn;
          }
          return new zzfb(null);
        }
        return new zzfc();
      }
      return zzkd.zzbz(zzn, "\001\t\000\001\001\t\t\000\004\000\001ဂ\000\002ဈ\001\003င\002\004\033\005\033\006\033\007ဈ\003\bဇ\004\t\033", new Object[] { "zza", "zze", "zzf", "zzg", "zzh", zzfe.class, "zzi", zzfa.class, "zzj", zzeh.class, "zzk", "zzl", "zzm", zzgo.class });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */