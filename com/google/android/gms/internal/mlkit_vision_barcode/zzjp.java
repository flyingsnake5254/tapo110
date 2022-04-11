package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzjp
  implements zzgf
{
  private static final zzge<zzjp> zzf = new zzjr();
  private final int zzg;
  
  static
  {
    zzjp localzzjp1 = new zzjp("DELEGATE_NONE", 0, 0);
    zza = localzzjp1;
    zzjp localzzjp2 = new zzjp("NNAPI", 1, 1);
    zzb = localzzjp2;
    zzjp localzzjp3 = new zzjp("GPU", 2, 2);
    zzc = localzzjp3;
    zzjp localzzjp4 = new zzjp("HEXAGON", 3, 3);
    zzd = localzzjp4;
    zzjp localzzjp5 = new zzjp("EDGETPU", 4, 4);
    zze = localzzjp5;
    zzh = new zzjp[] { localzzjp1, localzzjp2, localzzjp3, localzzjp4, localzzjp5 };
  }
  
  private zzjp(int paramInt)
  {
    this.zzg = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzjq.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzjp.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */