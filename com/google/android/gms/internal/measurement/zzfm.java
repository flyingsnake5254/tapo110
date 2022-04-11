package com.google.android.gms.internal.measurement;

public final class zzfm
  extends zzkd<zzfm, zzfl>
  implements zzlj
{
  private static final zzfm zzg;
  private int zza;
  private int zze;
  private long zzf;
  
  static
  {
    zzfm localzzfm = new zzfm();
    zzg = localzzfm;
    zzkd.zzby(zzfm.class, localzzfm);
  }
  
  public static zzfl zze()
  {
    return (zzfl)zzg.zzbt();
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final int zzb()
  {
    return this.zze;
  }
  
  public final boolean zzc()
  {
    return (this.zza & 0x2) != 0;
  }
  
  public final long zzd()
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
          return new zzfl(null);
        }
        return new zzfm();
      }
      return zzkd.zzbz(zzg, "\001\002\000\001\001\002\002\000\000\000\001င\000\002ဂ\001", new Object[] { "zza", "zze", "zzf" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */