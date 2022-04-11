package com.google.android.gms.internal.measurement;

public final class zzpp
  implements zzpo
{
  public static final zzht<Boolean> zza;
  public static final zzht<Long> zzb;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.config.persist_last_modified", true);
    zzb = localzzhr.zza("measurement.id.config.persist_last_modified", 0L);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzpp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */