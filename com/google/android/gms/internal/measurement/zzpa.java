package com.google.android.gms.internal.measurement;

public final class zzpa
  implements zzoz
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Boolean> zzc;
  public static final zzht<Boolean> zzd;
  public static final zzht<Long> zze;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.sdk.collection.enable_extend_user_property_size", true);
    zzb = localzzhr.zzb("measurement.sdk.collection.last_deep_link_referrer2", true);
    zzc = localzzhr.zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
    zzd = localzzhr.zzb("measurement.sdk.collection.last_gclid_from_referrer2", false);
    zze = localzzhr.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zze()).booleanValue();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */