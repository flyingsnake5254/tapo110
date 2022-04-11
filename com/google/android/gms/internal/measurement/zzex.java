package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzex
  extends zzkd<zzex, zzet>
  implements zzlj
{
  private static final zzex zzi;
  private int zza;
  private int zze;
  private String zzf = "";
  private boolean zzg;
  private zzkk<String> zzh = zzkd.zzbE();
  
  static
  {
    zzex localzzex = new zzex();
    zzi = localzzex;
    zzkd.zzby(zzex.class, localzzex);
  }
  
  public static zzex zzi()
  {
    return zzi;
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final zzew zzb()
  {
    zzew localzzew1 = zzew.zza(this.zze);
    zzew localzzew2 = localzzew1;
    if (localzzew1 == null) {
      localzzew2 = zzew.zza;
    }
    return localzzew2;
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
  
  public final boolean zzf()
  {
    return this.zzg;
  }
  
  public final List<String> zzg()
  {
    return this.zzh;
  }
  
  public final int zzh()
  {
    return this.zzh.size();
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
            return zzi;
          }
          return new zzet(null);
        }
        return new zzex();
      }
      paramObject1 = zzew.zzb();
      return zzkd.zzbz(zzi, "\001\004\000\001\001\004\004\000\001\000\001ဌ\000\002ဈ\001\003ဇ\002\004\032", new Object[] { "zza", "zze", paramObject1, "zzf", "zzg", "zzh" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */