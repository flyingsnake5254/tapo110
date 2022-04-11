package com.google.android.gms.internal.measurement;

public final class zzps
  implements zzpr
{
  public static final zzht<Boolean> zza;
  public static final zzht<Double> zzb;
  public static final zzht<Long> zzc;
  public static final zzht<Long> zzd;
  public static final zzht<String> zze;
  
  static
  {
    zzhr localzzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
    zza = localzzhr.zzb("measurement.test.boolean_flag", false);
    zzb = localzzhr.zzc("measurement.test.double_flag", -3.0D);
    zzc = localzzhr.zza("measurement.test.int_flag", -2L);
    zzd = localzzhr.zza("measurement.test.long_flag", -1L);
    zze = localzzhr.zzd("measurement.test.string_flag", "---");
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zze()).booleanValue();
  }
  
  public final double zzb()
  {
    return ((Double)zzb.zze()).doubleValue();
  }
  
  public final long zzc()
  {
    return ((Long)zzc.zze()).longValue();
  }
  
  public final long zzd()
  {
    return ((Long)zzd.zze()).longValue();
  }
  
  public final String zze()
  {
    return (String)zze.zze();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */