package com.google.android.gms.internal.mlkit_vision_common;

public enum zzcz
  implements zzep
{
  private static final zzeo<zzcz> zzq = new zzcy();
  private final int zzr;
  
  static
  {
    zzcz localzzcz1 = new zzcz("UNRECOGNIZED", 0, 0);
    zza = localzzcz1;
    zzcz localzzcz2 = new zzcz("CODE_128", 1, 1);
    zzb = localzzcz2;
    zzcz localzzcz3 = new zzcz("CODE_39", 2, 2);
    zzc = localzzcz3;
    zzcz localzzcz4 = new zzcz("CODE_93", 3, 3);
    zzd = localzzcz4;
    zzcz localzzcz5 = new zzcz("CODABAR", 4, 4);
    zze = localzzcz5;
    zzcz localzzcz6 = new zzcz("DATA_MATRIX", 5, 5);
    zzf = localzzcz6;
    zzcz localzzcz7 = new zzcz("EAN_13", 6, 6);
    zzg = localzzcz7;
    zzcz localzzcz8 = new zzcz("EAN_8", 7, 7);
    zzh = localzzcz8;
    zzcz localzzcz9 = new zzcz("ITF", 8, 8);
    zzi = localzzcz9;
    zzcz localzzcz10 = new zzcz("QR_CODE", 9, 9);
    zzj = localzzcz10;
    zzcz localzzcz11 = new zzcz("UPC_A", 10, 10);
    zzk = localzzcz11;
    zzcz localzzcz12 = new zzcz("UPC_E", 11, 11);
    zzl = localzzcz12;
    zzcz localzzcz13 = new zzcz("PDF417", 12, 12);
    zzm = localzzcz13;
    zzcz localzzcz14 = new zzcz("AZTEC", 13, 13);
    zzn = localzzcz14;
    zzcz localzzcz15 = new zzcz("DATABAR", 14, 14);
    zzo = localzzcz15;
    zzcz localzzcz16 = new zzcz("TEZ_CODE", 15, 16);
    zzp = localzzcz16;
    zzs = new zzcz[] { localzzcz1, localzzcz2, localzzcz3, localzzcz4, localzzcz5, localzzcz6, localzzcz7, localzzcz8, localzzcz9, localzzcz10, localzzcz11, localzzcz12, localzzcz13, localzzcz14, localzzcz15, localzzcz16 };
  }
  
  private zzcz(int paramInt)
  {
    this.zzr = paramInt;
  }
  
  public static zzer zzb()
  {
    return zzdb.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzcz.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */