package com.google.android.gms.internal.measurement;

public final class zzes
  extends zzkd<zzes, zzer>
  implements zzlj
{
  private static final zzes zzk;
  private int zza;
  private int zze;
  private String zzf = "";
  private zzel zzg;
  private boolean zzh;
  private boolean zzi;
  private boolean zzj;
  
  static
  {
    zzes localzzes = new zzes();
    zzk = localzzes;
    zzkd.zzby(zzes.class, localzzes);
  }
  
  public static zzer zzi()
  {
    return (zzer)zzk.zzbt();
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final int zzb()
  {
    return this.zze;
  }
  
  public final String zzc()
  {
    return this.zzf;
  }
  
  public final zzel zzd()
  {
    zzel localzzel1 = this.zzg;
    zzel localzzel2 = localzzel1;
    if (localzzel1 == null) {
      localzzel2 = zzel.zzi();
    }
    return localzzel2;
  }
  
  public final boolean zze()
  {
    return this.zzh;
  }
  
  public final boolean zzf()
  {
    return this.zzi;
  }
  
  public final boolean zzg()
  {
    return (this.zza & 0x20) != 0;
  }
  
  public final boolean zzh()
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
          return new zzer(null);
        }
        return new zzes();
      }
      return zzkd.zzbz(zzk, "\001\006\000\001\001\006\006\000\000\000\001င\000\002ဈ\001\003ဉ\002\004ဇ\003\005ဇ\004\006ဇ\005", new Object[] { "zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */