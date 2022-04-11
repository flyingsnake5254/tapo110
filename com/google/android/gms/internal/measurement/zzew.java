package com.google.android.gms.internal.measurement;

public enum zzew
  implements zzkf
{
  private static final zzkg<zzew> zzh = new zzeu();
  private final int zzi;
  
  static
  {
    zzew localzzew1 = new zzew("UNKNOWN_MATCH_TYPE", 0, 0);
    zza = localzzew1;
    zzew localzzew2 = new zzew("REGEXP", 1, 1);
    zzb = localzzew2;
    zzew localzzew3 = new zzew("BEGINS_WITH", 2, 2);
    zzc = localzzew3;
    zzew localzzew4 = new zzew("ENDS_WITH", 3, 3);
    zzd = localzzew4;
    zzew localzzew5 = new zzew("PARTIAL", 4, 4);
    zze = localzzew5;
    zzew localzzew6 = new zzew("EXACT", 5, 5);
    zzf = localzzew6;
    zzew localzzew7 = new zzew("IN_LIST", 6, 6);
    zzg = localzzew7;
    zzj = new zzew[] { localzzew1, localzzew2, localzzew3, localzzew4, localzzew5, localzzew6, localzzew7 };
  }
  
  private zzew(int paramInt)
  {
    this.zzi = paramInt;
  }
  
  public static zzew zza(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return zzg;
    case 5: 
      return zzf;
    case 4: 
      return zze;
    case 3: 
      return zzd;
    case 2: 
      return zzc;
    case 1: 
      return zzb;
    }
    return zza;
  }
  
  public static zzkh zzb()
  {
    return zzev.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzew.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzi);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */