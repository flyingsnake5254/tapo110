package com.google.android.gms.internal.measurement;

public final class zzne
  implements zznd
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.androidId.delete_feature", true);
    zzb = localzzhr.zzb("measurement.log_androidId_enabled", false);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */