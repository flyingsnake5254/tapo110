package com.google.android.gms.internal.measurement;

public final class zzpd
  implements zzpc
{
  public static final zzht<Long> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Boolean> zzc;
  public static final zzht<Boolean> zzd;
  public static final zzht<Long> zze;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
    zzb = localzzhr.zzb("measurement.lifecycle.app_backgrounded_engagement", false);
    zzc = localzzhr.zzb("measurement.lifecycle.app_backgrounded_tracking", true);
    zzd = localzzhr.zzb("measurement.lifecycle.app_in_background_parameter", false);
    zze = localzzhr.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zzb.zze()).booleanValue();
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zzd.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */