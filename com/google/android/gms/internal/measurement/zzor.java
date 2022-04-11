package com.google.android.gms.internal.measurement;

public final class zzor
  implements zzoq
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Long> zzc;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.collection.efficient_engagement_reporting_enabled_2", true);
    zzb = localzzhr.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
    zzc = localzzhr.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zzb.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */