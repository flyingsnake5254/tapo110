package com.google.android.gms.internal.measurement;

public final class zznt
  implements zzns
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Boolean> zzc;
  public static final zzht<Long> zzd;
  public static final zzht<Long> zze;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.client.consent_state_v1", true);
    zzb = localzzhr.zzb("measurement.client.3p_consent_state_v1", true);
    zzc = localzzhr.zzb("measurement.service.consent_state_v1_W36", true);
    zzd = localzzhr.zza("measurement.id.service.consent_state_v1_W36", 0L);
    zze = localzzhr.zza("measurement.service.storage_consent_support_version", 203590L);
  }
  
  public final long zza()
  {
    return ((Long)zze.zze()).longValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zznt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */