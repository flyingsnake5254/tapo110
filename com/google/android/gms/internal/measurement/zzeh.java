package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzeh
  extends zzkd<zzeh, zzeg>
  implements zzlj
{
  private static final zzeh zzj;
  private int zza;
  private int zze;
  private zzkk<zzes> zzf = zzkd.zzbE();
  private zzkk<zzej> zzg = zzkd.zzbE();
  private boolean zzh;
  private boolean zzi;
  
  static
  {
    zzeh localzzeh = new zzeh();
    zzj = localzzeh;
    zzkd.zzby(zzeh.class, localzzeh);
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final int zzb()
  {
    return this.zze;
  }
  
  public final List<zzes> zzc()
  {
    return this.zzf;
  }
  
  public final int zzd()
  {
    return this.zzf.size();
  }
  
  public final zzes zze(int paramInt)
  {
    return (zzes)this.zzf.get(paramInt);
  }
  
  public final List<zzej> zzf()
  {
    return this.zzg;
  }
  
  public final int zzg()
  {
    return this.zzg.size();
  }
  
  public final zzej zzh(int paramInt)
  {
    return (zzej)this.zzg.get(paramInt);
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
          return new zzeg(null);
        }
        return new zzeh();
      }
      return zzkd.zzbz(zzj, "\001\005\000\001\001\005\005\000\002\000\001င\000\002\033\003\033\004ဇ\001\005ဇ\002", new Object[] { "zza", "zze", "zzf", zzes.class, "zzg", zzej.class, "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */