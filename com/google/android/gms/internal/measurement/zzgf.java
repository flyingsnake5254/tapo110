package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgf
  extends zzkd<zzgf, zzge>
  implements zzlj
{
  private static final zzgf zzg;
  private int zza;
  private int zze;
  private zzkj zzf = zzkd.zzbC();
  
  static
  {
    zzgf localzzgf = new zzgf();
    zzg = localzzgf;
    zzkd.zzby(zzgf.class, localzzgf);
  }
  
  public static zzge zzf()
  {
    return (zzge)zzg.zzbt();
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final int zzb()
  {
    return this.zze;
  }
  
  public final List<Long> zzc()
  {
    return this.zzf;
  }
  
  public final int zzd()
  {
    return this.zzf.size();
  }
  
  public final long zze(int paramInt)
  {
    return this.zzf.zzc(paramInt);
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
          return new zzge(null);
        }
        return new zzgf();
      }
      return zzkd.zzbz(zzg, "\001\002\000\001\001\002\002\000\001\000\001င\000\002\024", new Object[] { "zza", "zze", "zzf" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */