package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfo
  extends zzkd<zzfo, zzfn>
  implements zzlj
{
  private static final zzfo zzj;
  private int zza;
  private zzkk<zzfs> zze = zzkd.zzbE();
  private String zzf = "";
  private long zzg;
  private long zzh;
  private int zzi;
  
  static
  {
    zzfo localzzfo = new zzfo();
    zzj = localzzfo;
    zzkd.zzby(zzfo.class, localzzfo);
  }
  
  public static zzfn zzk()
  {
    return (zzfn)zzj.zzbt();
  }
  
  private final void zzv()
  {
    zzkk localzzkk = this.zze;
    if (!localzzkk.zza()) {
      this.zze = zzkd.zzbF(localzzkk);
    }
  }
  
  public final List<zzfs> zza()
  {
    return this.zze;
  }
  
  public final int zzb()
  {
    return this.zze.size();
  }
  
  public final zzfs zzc(int paramInt)
  {
    return (zzfs)this.zze.get(paramInt);
  }
  
  public final String zzd()
  {
    return this.zzf;
  }
  
  public final boolean zze()
  {
    return (this.zza & 0x2) != 0;
  }
  
  public final long zzf()
  {
    return this.zzg;
  }
  
  public final boolean zzg()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final long zzh()
  {
    return this.zzh;
  }
  
  public final boolean zzi()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final int zzj()
  {
    return this.zzi;
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
            return zzj;
          }
          return new zzfn(null);
        }
        return new zzfo();
      }
      return zzkd.zzbz(zzj, "\001\005\000\001\001\005\005\000\001\000\001\033\002ဈ\000\003ဂ\001\004ဂ\002\005င\003", new Object[] { "zza", "zze", zzfs.class, "zzf", "zzg", "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */