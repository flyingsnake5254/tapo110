package com.google.android.gms.internal.measurement;

public final class zzel
  extends zzkd<zzel, zzek>
  implements zzlj
{
  private static final zzel zzi;
  private int zza;
  private zzex zze;
  private zzeq zzf;
  private boolean zzg;
  private String zzh = "";
  
  static
  {
    zzel localzzel = new zzel();
    zzi = localzzel;
    zzkd.zzby(zzel.class, localzzel);
  }
  
  public static zzel zzi()
  {
    return zzi;
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final zzex zzb()
  {
    zzex localzzex1 = this.zze;
    zzex localzzex2 = localzzex1;
    if (localzzex1 == null) {
      localzzex2 = zzex.zzi();
    }
    return localzzex2;
  }
  
  public final boolean zzc()
  {
    return (this.zza & 0x2) != 0;
  }
  
  public final zzeq zzd()
  {
    zzeq localzzeq1 = this.zzf;
    zzeq localzzeq2 = localzzeq1;
    if (localzzeq1 == null) {
      localzzeq2 = zzeq.zzk();
    }
    return localzzeq2;
  }
  
  public final boolean zze()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final boolean zzf()
  {
    return this.zzg;
  }
  
  public final boolean zzg()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final String zzh()
  {
    return this.zzh;
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
          return new zzek(null);
        }
        return new zzel();
      }
      return zzkd.zzbz(zzi, "\001\004\000\001\001\004\004\000\000\000\001ဉ\000\002ဉ\001\003ဇ\002\004ဈ\003", new Object[] { "zza", "zze", "zzf", "zzg", "zzh" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */