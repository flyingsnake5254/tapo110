package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzen
  implements zzgf
{
  private static final zzge<zzen> zzq = new zzep();
  private final int zzr;
  
  static
  {
    zzen localzzen1 = new zzen("UNRECOGNIZED", 0, 0);
    zzn = localzzen1;
    zzen localzzen2 = new zzen("CODE_128", 1, 1);
    zza = localzzen2;
    zzen localzzen3 = new zzen("CODE_39", 2, 2);
    zzb = localzzen3;
    zzen localzzen4 = new zzen("CODE_93", 3, 3);
    zzc = localzzen4;
    zzen localzzen5 = new zzen("CODABAR", 4, 4);
    zzd = localzzen5;
    zzen localzzen6 = new zzen("DATA_MATRIX", 5, 5);
    zze = localzzen6;
    zzen localzzen7 = new zzen("EAN_13", 6, 6);
    zzf = localzzen7;
    zzen localzzen8 = new zzen("EAN_8", 7, 7);
    zzg = localzzen8;
    zzen localzzen9 = new zzen("ITF", 8, 8);
    zzh = localzzen9;
    zzen localzzen10 = new zzen("QR_CODE", 9, 9);
    zzi = localzzen10;
    zzen localzzen11 = new zzen("UPC_A", 10, 10);
    zzj = localzzen11;
    zzen localzzen12 = new zzen("UPC_E", 11, 11);
    zzk = localzzen12;
    zzen localzzen13 = new zzen("PDF417", 12, 12);
    zzl = localzzen13;
    zzen localzzen14 = new zzen("AZTEC", 13, 13);
    zzm = localzzen14;
    zzen localzzen15 = new zzen("DATABAR", 14, 14);
    zzo = localzzen15;
    zzen localzzen16 = new zzen("TEZ_CODE", 15, 16);
    zzp = localzzen16;
    zzs = new zzen[] { localzzen1, localzzen2, localzzen3, localzzen4, localzzen5, localzzen6, localzzen7, localzzen8, localzzen9, localzzen10, localzzen11, localzzen12, localzzen13, localzzen14, localzzen15, localzzen16 };
  }
  
  private zzen(int paramInt)
  {
    this.zzr = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzeo.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzen.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzr);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzr;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */