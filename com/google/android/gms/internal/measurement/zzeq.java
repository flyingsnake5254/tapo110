package com.google.android.gms.internal.measurement;

public final class zzeq
  extends zzkd<zzeq, zzem>
  implements zzlj
{
  private static final zzeq zzj;
  private int zza;
  private int zze;
  private boolean zzf;
  private String zzg = "";
  private String zzh = "";
  private String zzi = "";
  
  static
  {
    zzeq localzzeq = new zzeq();
    zzj = localzzeq;
    zzkd.zzby(zzeq.class, localzzeq);
  }
  
  public static zzeq zzk()
  {
    return zzj;
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final zzep zzb()
  {
    zzep localzzep1 = zzep.zza(this.zze);
    zzep localzzep2 = localzzep1;
    if (localzzep1 == null) {
      localzzep2 = zzep.zza;
    }
    return localzzep2;
  }
  
  public final boolean zzc()
  {
    return (this.zza & 0x2) != 0;
  }
  
  public final boolean zzd()
  {
    return this.zzf;
  }
  
  public final boolean zze()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final String zzf()
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
  
  public final boolean zzi()
  {
    return (this.zza & 0x10) != 0;
  }
  
  public final String zzj()
  {
    return this.zzi;
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
            return zzj;
          }
          return new zzem(null);
        }
        return new zzeq();
      }
      paramObject1 = zzep.zzb();
      return zzkd.zzbz(zzj, "\001\005\000\001\001\005\005\000\000\000\001ဌ\000\002ဇ\001\003ဈ\002\004ဈ\003\005ဈ\004", new Object[] { "zza", "zze", paramObject1, "zzf", "zzg", "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */