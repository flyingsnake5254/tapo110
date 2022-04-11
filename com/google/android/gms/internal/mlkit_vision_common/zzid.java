package com.google.android.gms.internal.mlkit_vision_common;

public enum zzid
  implements zzep
{
  private static final zzeo<zzid> zzd = new zzig();
  private final int zze;
  
  static
  {
    zzid localzzid1 = new zzid("UNKNOWN_EVENT_TYPE", 0, 0);
    zza = localzzid1;
    zzid localzzid2 = new zzid("VALIDATION_TEST", 1, 1);
    zzb = localzzid2;
    zzid localzzid3 = new zzid("CONTINUOUS_FEEDBACK", 2, 2);
    zzc = localzzid3;
    zzf = new zzid[] { localzzid1, localzzid2, localzzid3 };
  }
  
  private zzid(int paramInt)
  {
    this.zze = paramInt;
  }
  
  public static zzer zzb()
  {
    return zzif.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzid.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zze);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zze;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */