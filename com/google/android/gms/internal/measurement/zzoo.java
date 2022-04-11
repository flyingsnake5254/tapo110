package com.google.android.gms.internal.measurement;

public final class zzoo
  implements zzon
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  public static final zzht<Boolean> zzc;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.client.sessions.check_on_reset_and_enable2", true);
    zzb = localzzhr.zzb("measurement.client.sessions.check_on_startup", true);
    zzc = localzzhr.zzb("measurement.client.sessions.start_session_before_view_screen", true);
  }
  
  public final boolean zza()
  {
    return true;
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zza.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzoo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */