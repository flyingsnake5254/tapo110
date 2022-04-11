package com.google.android.gms.internal.measurement;

public final class zzpm
  implements zzpl
{
  public static final zzht<Boolean> zza;
  public static final zzht<Long> zzb;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.validation.internal_limits_internal_event_params", false);
    zzb = localzzhr.zza("measurement.id.validation.internal_limits_internal_event_params", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzpm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */