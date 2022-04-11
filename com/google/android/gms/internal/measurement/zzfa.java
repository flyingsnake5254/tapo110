package com.google.android.gms.internal.measurement;

public final class zzfa
  extends zzkd<zzfa, zzez>
  implements zzlj
{
  private static final zzfa zzi;
  private int zza;
  private String zze = "";
  private boolean zzf;
  private boolean zzg;
  private int zzh;
  
  static
  {
    zzfa localzzfa = new zzfa();
    zzi = localzzfa;
    zzkd.zzby(zzfa.class, localzzfa);
  }
  
  public final String zza()
  {
    return this.zze;
  }
  
  public final boolean zzb()
  {
    return this.zzf;
  }
  
  public final boolean zzc()
  {
    return this.zzg;
  }
  
  public final boolean zzd()
  {
    return (this.zza & 0x8) != 0;
  }
  
  public final int zze()
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
          return new zzez(null);
        }
        return new zzfa();
      }
      return zzkd.zzbz(zzi, "\001\004\000\001\001\004\004\000\000\000\001ဈ\000\002ဇ\001\003ဇ\002\004င\003", new Object[] { "zza", "zze", "zzf", "zzg", "zzh" });
    }
    return Byte.valueOf((byte)1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */