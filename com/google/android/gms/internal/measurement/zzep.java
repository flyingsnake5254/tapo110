package com.google.android.gms.internal.measurement;

public enum zzep
  implements zzkf
{
  private static final zzkg<zzep> zzf = new zzen();
  private final int zzg;
  
  static
  {
    zzep localzzep1 = new zzep("UNKNOWN_COMPARISON_TYPE", 0, 0);
    zza = localzzep1;
    zzep localzzep2 = new zzep("LESS_THAN", 1, 1);
    zzb = localzzep2;
    zzep localzzep3 = new zzep("GREATER_THAN", 2, 2);
    zzc = localzzep3;
    zzep localzzep4 = new zzep("EQUAL", 3, 3);
    zzd = localzzep4;
    zzep localzzep5 = new zzep("BETWEEN", 4, 4);
    zze = localzzep5;
    zzh = new zzep[] { localzzep1, localzzep2, localzzep3, localzzep4, localzzep5 };
  }
  
  private zzep(int paramInt)
  {
    this.zzg = paramInt;
  }
  
  public static zzep zza(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return zze;
          }
          return zzd;
        }
        return zzc;
      }
      return zzb;
    }
    return zza;
  }
  
  public static zzkh zzb()
  {
    return zzeo.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzep.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzg);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */