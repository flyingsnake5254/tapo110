package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzjz
  implements zzgf
{
  private static final zzge<zzjz> zzf = new zzjy();
  private final int zzg;
  
  static
  {
    zzjz localzzjz1 = new zzjz("HANG_DETECTION_DEFAULT", 0, 0);
    zza = localzzjz1;
    zzjz localzzjz2 = new zzjz("HANG_DETECTION_NONE", 1, 1);
    zzb = localzzjz2;
    zzjz localzzjz3 = new zzjz("HANG_DETECTION_LOG_ONLY", 2, 2);
    zzc = localzzjz3;
    zzjz localzzjz4 = new zzjz("HANG_DETECTION_CRASH_PROCESS", 3, 3);
    zzd = localzzjz4;
    zzjz localzzjz5 = new zzjz("HANG_DETECTION_ABANDON_THREAD", 4, 4);
    zze = localzzjz5;
    zzh = new zzjz[] { localzzjz1, localzzjz2, localzzjz3, localzzjz4, localzzjz5 };
  }
  
  private zzjz(int paramInt)
  {
    this.zzg = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzka.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzjz.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzg);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzg;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */