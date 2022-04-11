package com.google.android.gms.internal.measurement;

public final class zznw
  implements zznv
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.euid.client.dev", false);
    zzb = localzzhr.zzb("measurement.euid.service", false);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zze()).booleanValue();
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zzb.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zznw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */