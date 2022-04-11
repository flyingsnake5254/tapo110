package com.google.android.gms.internal.measurement;

public final class zzgh
  extends zzkd<zzgh, zzgg>
  implements zzlj
{
  private static final zzgh zzk;
  private int zza;
  private long zze;
  private String zzf = "";
  private String zzg = "";
  private long zzh;
  private float zzi;
  private double zzj;
  
  static
  {
    zzgh localzzgh = new zzgh();
    zzk = localzzgh;
    zzkd.zzby(zzgh.class, localzzgh);
  }
  
  public static zzgg zzj()
  {
    return (zzgg)zzk.zzbt();
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final long zzb()
  {
    return this.zze;
  }
  
  public final String zzc()
  {
    return this.zzf;
  }
  
  public final boolean zzd()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final String zze()
  {
    return this.zzg;
  }
  
  public final boolean zzf()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final long zzg()
  {
    return this.zzh;
  }
  
  public final boolean zzh()
  {
    return (this.zza & 0x20) != 0;
  }
  
  public final double zzi()
  {
    return this.zzj;
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
            return zzk;
          }
          return new zzgg(null);
        }
        return new zzgh();
      }
      return zzkd.zzbz(zzk, "\001\006\000\001\001\006\006\000\000\000\001ဂ\000\002ဈ\001\003ဈ\002\004ဂ\003\005ခ\004\006က\005", new Object[] { "zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */