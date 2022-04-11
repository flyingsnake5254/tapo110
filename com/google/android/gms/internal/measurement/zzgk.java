package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgk
  extends zzkd<zzgk, zzgj>
  implements zzlj
{
  private static final zzgk zze;
  private zzkk<zzgm> zza = zzkd.zzbE();
  
  static
  {
    zzgk localzzgk = new zzgk();
    zze = localzzgk;
    zzkd.zzby(zzgk.class, localzzgk);
  }
  
  public static zzgk zzc()
  {
    return zze;
  }
  
  public final List<zzgm> zza()
  {
    return this.zza;
  }
  
  public final int zzb()
  {
    return this.zza.size();
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
            return zze;
          }
          return new zzgj(null);
        }
        return new zzgk();
      }
      return zzkd.zzbz(zze, "\001\001\000\000\001\001\001\000\001\000\001\033", new Object[] { "zza", zzgm.class });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */