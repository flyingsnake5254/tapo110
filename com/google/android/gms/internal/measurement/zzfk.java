package com.google.android.gms.internal.measurement;

public final class zzfk
  extends zzkd<zzfk, zzfj>
  implements zzlj
{
  private static final zzfk zzi;
  private int zza;
  private int zze;
  private zzgd zzf;
  private zzgd zzg;
  private boolean zzh;
  
  static
  {
    zzfk localzzfk = new zzfk();
    zzi = localzzfk;
    zzkd.zzby(zzfk.class, localzzfk);
  }
  
  public static zzfj zzh()
  {
    return (zzfj)zzi.zzbt();
  }
  
  public final boolean zza()
  {
    return (this.zza & 0x1) != 0;
  }
  
  public final int zzb()
  {
    return this.zze;
  }
  
  public final zzgd zzc()
  {
    zzgd localzzgd1 = this.zzf;
    zzgd localzzgd2 = localzzgd1;
    if (localzzgd1 == null) {
      localzzgd2 = zzgd.zzm();
    }
    return localzzgd2;
  }
  
  public final boolean zzd()
  {
    return (this.zza & 0x4) != 0;
  }
  
  public final zzgd zze()
  {
    zzgd localzzgd1 = this.zzg;
    zzgd localzzgd2 = localzzgd1;
    if (localzzgd1 == null) {
      localzzgd2 = zzgd.zzm();
    }
    return localzzgd2;
  }
  
  public final boolean zzf()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final boolean zzg()
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
          return new zzfj(null);
        }
        return new zzfk();
      }
      return zzkd.zzbz(zzi, "\001\004\000\001\001\004\004\000\000\000\001င\000\002ဉ\001\003ဉ\002\004ဇ\003", new Object[] { "zza", "zze", "zzf", "zzg", "zzh" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */