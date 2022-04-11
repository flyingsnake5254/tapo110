package com.google.android.gms.internal.measurement;

public final class zzpg
  implements zzpf
{
  public static final zzht<Boolean> zza;
  public static final zzht<Boolean> zzb;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.sdk.screen.manual_screen_view_logging", true);
    zzb = localzzhr.zzb("measurement.sdk.screen.disabling_automatic_reporting", true);
  }
  
  public final boolean zza()
  {
    return true;
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zza.zze()).booleanValue();
  }
  
  public final boolean zzc()
  {
    return ((Boolean)zzb.zze()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */