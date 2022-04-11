package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgm
  extends zzkd<zzgm, zzgl>
  implements zzlj
{
  private static final zzgm zzg;
  private int zza;
  private String zze = "";
  private zzkk<zzgt> zzf = zzkd.zzbE();
  
  static
  {
    zzgm localzzgm = new zzgm();
    zzg = localzzgm;
    zzkd.zzby(zzgm.class, localzzgm);
  }
  
  public final String zza()
  {
    return this.zze;
  }
  
  public final List<zzgt> zzb()
  {
    return this.zzf;
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
            return zzg;
          }
          return new zzgl(null);
        }
        return new zzgm();
      }
      return zzkd.zzbz(zzg, "\001\002\000\001\001\002\002\000\001\000\001ဈ\000\002\033", new Object[] { "zza", "zze", "zzf", zzgt.class });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */