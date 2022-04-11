package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzkb
  implements zzgf
{
  private static final zzge<zzkb> zze = new zzkd();
  private final int zzf;
  
  static
  {
    zzkb localzzkb1 = new zzkb("NNAPI_EXECUTION_PREFERENCE_UNDEFINED", 0, 0);
    zza = localzzkb1;
    zzkb localzzkb2 = new zzkb("NNAPI_EXECUTION_PREFERENCE_LOW_POWER", 1, 1);
    zzb = localzzkb2;
    zzkb localzzkb3 = new zzkb("NNAPI_EXECUTION_PREFERENCE_FAST_SINGLE_ANSWER", 2, 2);
    zzc = localzzkb3;
    zzkb localzzkb4 = new zzkb("NNAPI_EXECUTION_PREFERENCE_SUSTAINED_SPEED", 3, 3);
    zzd = localzzkb4;
    zzg = new zzkb[] { localzzkb1, localzzkb2, localzzkb3, localzzkb4 };
  }
  
  private zzkb(int paramInt)
  {
    this.zzf = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzkc.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzkb.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzf);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */