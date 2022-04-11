package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzkl
  implements zzgf
{
  private static final zzge<zzkl> zzd = new zzko();
  private final int zze;
  
  static
  {
    zzkl localzzkl1 = new zzkl("UNKNOWN_EVENT_TYPE", 0, 0);
    zza = localzzkl1;
    zzkl localzzkl2 = new zzkl("VALIDATION_TEST", 1, 1);
    zzb = localzzkl2;
    zzkl localzzkl3 = new zzkl("CONTINUOUS_FEEDBACK", 2, 2);
    zzc = localzzkl3;
    zzf = new zzkl[] { localzzkl1, localzzkl2, localzzkl3 };
  }
  
  private zzkl(int paramInt)
  {
    this.zze = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzkn.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzkl.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */