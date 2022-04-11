package com.google.android.gms.internal.measurement;

public enum zzfi
  implements zzkf
{
  private static final zzkg<zzfi> zzg = new zzfg();
  private final int zzh;
  
  static
  {
    zzfi localzzfi1 = new zzfi("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN", 0, 0);
    zza = localzzfi1;
    zzfi localzzfi2 = new zzfi("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED", 1, 1);
    zzb = localzzfi2;
    zzfi localzzfi3 = new zzfi("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED", 2, 2);
    zzc = localzzfi3;
    zzfi localzzfi4 = new zzfi("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED", 3, 3);
    zzd = localzzfi4;
    zzfi localzzfi5 = new zzfi("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED", 4, 4);
    zze = localzzfi5;
    zzfi localzzfi6 = new zzfi("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED", 5, 5);
    zzf = localzzfi6;
    zzi = new zzfi[] { localzzfi1, localzzfi2, localzzfi3, localzzfi4, localzzfi5, localzzfi6 };
  }
  
  private zzfi(int paramInt)
  {
    this.zzh = paramInt;
  }
  
  public static zzfi zza(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
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
              return zzf;
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
    return zzfh.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzfi.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzh);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */