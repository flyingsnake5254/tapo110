package com.google.android.gms.internal.measurement;

public final class zzoi
  implements zzoh
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Boolean> zzc;
  public static final zzht<Boolean> zzd;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
    zzb = localzzhr.zzb("measurement.audience.refresh_event_count_filters_timestamp", false);
    zzc = localzzhr.zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
    zzd = localzzhr.zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
  }
  
  public final boolean zza()
  {
    return true;
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zzb.zze()).booleanValue();
  }
  
  public final boolean zzc()
  {
    return ((Boolean)zzc.zze()).booleanValue();
  }
  
  public final boolean zzd()
  {
    return ((Boolean)zzd.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */