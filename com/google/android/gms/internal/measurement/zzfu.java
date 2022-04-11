package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfu
  extends zzkd<zzfu, zzft>
  implements zzlj
{
  private static final zzfu zze;
  private zzkk<zzfw> zza = zzkd.zzbE();
  
  static
  {
    zzfu localzzfu = new zzfu();
    zze = localzzfu;
    zzkd.zzby(zzfu.class, localzzfu);
  }
  
  public static zzft zzc()
  {
    return (zzft)zze.zzbt();
  }
  
  public final List<zzfw> zza()
  {
    return this.zza;
  }
  
  public final zzfw zzb(int paramInt)
  {
    return (zzfw)this.zza.get(0);
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
          return new zzft(null);
        }
        return new zzfu();
      }
      return zzkd.zzbz(zze, "\001\001\000\000\001\001\001\000\001\000\001\033", new Object[] { "zza", zzfw.class });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */