package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzbv
  implements zzgf
{
  private static final zzge<zzbv> zzac = new zzbu();
  private final int zzad;
  
  static
  {
    zzbv localzzbv1 = new zzbv("NO_ERROR", 0, 0);
    zza = localzzbv1;
    zzbv localzzbv2 = new zzbv("INCOMPATIBLE_INPUT", 1, 1);
    zzd = localzzbv2;
    zzbv localzzbv3 = new zzbv("INCOMPATIBLE_OUTPUT", 2, 2);
    zze = localzzbv3;
    zzbv localzzbv4 = new zzbv("INCOMPATIBLE_TFLITE_VERSION", 3, 3);
    zzf = localzzbv4;
    zzbv localzzbv5 = new zzbv("MISSING_OP", 4, 4);
    zzg = localzzbv5;
    zzbv localzzbv6 = new zzbv("DATA_TYPE_ERROR", 5, 6);
    zzh = localzzbv6;
    zzbv localzzbv7 = new zzbv("TFLITE_INTERNAL_ERROR", 6, 7);
    zzi = localzzbv7;
    zzbv localzzbv8 = new zzbv("TFLITE_UNKNOWN_ERROR", 7, 8);
    zzj = localzzbv8;
    zzbv localzzbv9 = new zzbv("MEDIAPIPE_ERROR", 8, 9);
    zzk = localzzbv9;
    zzbv localzzbv10 = new zzbv("TIME_OUT_FETCHING_MODEL_METADATA", 9, 5);
    zzl = localzzbv10;
    zzbv localzzbv11 = new zzbv("MODEL_NOT_DOWNLOADED", 10, 100);
    zzb = localzzbv11;
    zzbv localzzbv12 = new zzbv("URI_EXPIRED", 11, 101);
    zzm = localzzbv12;
    zzbv localzzbv13 = new zzbv("NO_NETWORK_CONNECTION", 12, 102);
    zzn = localzzbv13;
    zzbv localzzbv14 = new zzbv("METERED_NETWORK", 13, 103);
    zzo = localzzbv14;
    zzbv localzzbv15 = new zzbv("DOWNLOAD_FAILED", 14, 104);
    zzp = localzzbv15;
    zzbv localzzbv16 = new zzbv("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS", 15, 105);
    zzq = localzzbv16;
    zzbv localzzbv17 = new zzbv("MODEL_INFO_DOWNLOAD_NO_HASH", 16, 106);
    zzr = localzzbv17;
    zzbv localzzbv18 = new zzbv("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED", 17, 107);
    zzs = localzzbv18;
    zzbv localzzbv19 = new zzbv("NO_VALID_MODEL", 18, 108);
    zzt = localzzbv19;
    zzbv localzzbv20 = new zzbv("LOCAL_MODEL_INVALID", 19, 109);
    zzu = localzzbv20;
    zzbv localzzbv21 = new zzbv("REMOTE_MODEL_INVALID", 20, 110);
    zzv = localzzbv21;
    zzbv localzzbv22 = new zzbv("REMOTE_MODEL_LOADER_ERROR", 21, 111);
    zzw = localzzbv22;
    zzbv localzzbv23 = new zzbv("REMOTE_MODEL_LOADER_LOADS_NO_MODEL", 22, 112);
    zzx = localzzbv23;
    zzbv localzzbv24 = new zzbv("SMART_REPLY_LANG_ID_DETECTAION_FAILURE", 23, 113);
    zzy = localzzbv24;
    zzbv localzzbv25 = new zzbv("MODEL_NOT_REGISTERED", 24, 114);
    zzz = localzzbv25;
    zzbv localzzbv26 = new zzbv("MODEL_TYPE_MISUSE", 25, 115);
    zzaa = localzzbv26;
    zzbv localzzbv27 = new zzbv("MODEL_HASH_MISMATCH", 26, 116);
    zzab = localzzbv27;
    zzbv localzzbv28 = new zzbv("UNKNOWN_ERROR", 27, 9999);
    zzc = localzzbv28;
    zzae = new zzbv[] { localzzbv1, localzzbv2, localzzbv3, localzzbv4, localzzbv5, localzzbv6, localzzbv7, localzzbv8, localzzbv9, localzzbv10, localzzbv11, localzzbv12, localzzbv13, localzzbv14, localzzbv15, localzzbv16, localzzbv17, localzzbv18, localzzbv19, localzzbv20, localzzbv21, localzzbv22, localzzbv23, localzzbv24, localzzbv25, localzzbv26, localzzbv27, localzzbv28 };
  }
  
  private zzbv(int paramInt)
  {
    this.zzad = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzbx.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzbv.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzad);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzad;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */