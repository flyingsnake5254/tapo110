package com.google.android.gms.internal.measurement;

public final class zznh
  implements zzng
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Long> zzc;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.frontend.directly_maybe_log_error_events", false);
    zzb = localzzhr.zzb("measurement.upload.directly_maybe_log_error_events", true);
    zzc = localzzhr.zza("measurement.id.frontend.directly_maybe_log_error_events", 0L);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zznh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */