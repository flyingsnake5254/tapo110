package com.google.android.gms.internal.measurement;

public final class zzgb
  extends zzkd<zzgb, zzfx>
  implements zzlj
{
  private static final zzgb zzg;
  private int zza;
  private int zze = 1;
  private zzkk<zzfq> zzf = zzkd.zzbE();
  
  static
  {
    zzgb localzzgb = new zzgb();
    zzg = localzzgb;
    zzkd.zzby(zzgb.class, localzzgb);
  }
  
  public static zzfx zza()
  {
    return (zzfx)zzg.zzbt();
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
          return new zzfx(null);
        }
        return new zzgb();
      }
      paramObject1 = zzga.zzb();
      return zzkd.zzbz(zzg, "\001\002\000\001\001\002\002\000\001\000\001ဌ\000\002\033", new Object[] { "zza", "zze", paramObject1, "zzf", zzfq.class });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */