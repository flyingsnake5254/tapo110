package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgo
  extends zzkd<zzgo, zzgn>
  implements zzlj
{
  private static final zzgo zzg;
  private int zza;
  private zzkk<zzgt> zze = zzkd.zzbE();
  private zzgk zzf;
  
  static
  {
    zzgo localzzgo = new zzgo();
    zzg = localzzgo;
    zzkd.zzby(zzgo.class, localzzgo);
  }
  
  public final List<zzgt> zza()
  {
    return this.zze;
  }
  
  public final zzgk zzb()
  {
    zzgk localzzgk1 = this.zzf;
    zzgk localzzgk2 = localzzgk1;
    if (localzzgk1 == null) {
      localzzgk2 = zzgk.zzc();
    }
    return localzzgk2;
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
          return new zzgn(null);
        }
        return new zzgo();
      }
      return zzkd.zzbz(zzg, "\001\002\000\001\001\002\002\000\001\000\001\033\002ဉ\000", new Object[] { "zza", "zze", zzgt.class, "zzf" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */