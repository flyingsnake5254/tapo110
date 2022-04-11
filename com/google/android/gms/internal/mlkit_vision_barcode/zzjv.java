package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzjv
  implements zzgf
{
  private static final zzge<zzjv> zzd = new zzjx();
  private final int zze;
  
  static
  {
    zzjv localzzjv1 = new zzjv("GPU_BACKEND_UNSET", 0, 0);
    zza = localzzjv1;
    zzjv localzzjv2 = new zzjv("GPU_BACKEND_OPENCL", 1, 1);
    zzb = localzzjv2;
    zzjv localzzjv3 = new zzjv("GPU_BACKEND_OPENGL", 2, 2);
    zzc = localzzjv3;
    zzf = new zzjv[] { localzzjv1, localzzjv2, localzzjv3 };
  }
  
  private zzjv(int paramInt)
  {
    this.zze = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzjw.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzjv.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */