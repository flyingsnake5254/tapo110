package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzjt
  implements zzgf
{
  private static final zzjt zze;
  private static final zzge<zzjt> zzf = new zzjs();
  private final int zzg;
  
  static
  {
    zzjt localzzjt1 = new zzjt("ANY_EXECUTION_PREFERENCE", 0, 0);
    zza = localzzjt1;
    zzjt localzzjt2 = new zzjt("LOW_LATENCY", 1, 1);
    zzb = localzzjt2;
    zzjt localzzjt3 = new zzjt("LOW_POWER", 2, 2);
    zzc = localzzjt3;
    zzjt localzzjt4 = new zzjt("FORCE_CPU", 3, 3);
    zzd = localzzjt4;
    zzh = new zzjt[] { localzzjt1, localzzjt2, localzzjt3, localzzjt4 };
    zze = localzzjt1;
  }
  
  private zzjt(int paramInt)
  {
    this.zzg = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzju.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzjt.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */