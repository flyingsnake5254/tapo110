package com.google.android.gms.internal.mlkit_vision_common;

public enum zzac
  implements zzep
{
  private static final zzeo<zzac> zzac = new zzae();
  private final int zzad;
  
  static
  {
    zzac localzzac1 = new zzac("NO_ERROR", 0, 0);
    zza = localzzac1;
    zzac localzzac2 = new zzac("INCOMPATIBLE_INPUT", 1, 1);
    zzb = localzzac2;
    zzac localzzac3 = new zzac("INCOMPATIBLE_OUTPUT", 2, 2);
    zzc = localzzac3;
    zzac localzzac4 = new zzac("INCOMPATIBLE_TFLITE_VERSION", 3, 3);
    zzd = localzzac4;
    zzac localzzac5 = new zzac("MISSING_OP", 4, 4);
    zze = localzzac5;
    zzac localzzac6 = new zzac("DATA_TYPE_ERROR", 5, 6);
    zzf = localzzac6;
    zzac localzzac7 = new zzac("TFLITE_INTERNAL_ERROR", 6, 7);
    zzg = localzzac7;
    zzac localzzac8 = new zzac("TFLITE_UNKNOWN_ERROR", 7, 8);
    zzh = localzzac8;
    zzac localzzac9 = new zzac("MEDIAPIPE_ERROR", 8, 9);
    zzi = localzzac9;
    zzac localzzac10 = new zzac("TIME_OUT_FETCHING_MODEL_METADATA", 9, 5);
    zzj = localzzac10;
    zzac localzzac11 = new zzac("MODEL_NOT_DOWNLOADED", 10, 100);
    zzk = localzzac11;
    zzac localzzac12 = new zzac("URI_EXPIRED", 11, 101);
    zzl = localzzac12;
    zzac localzzac13 = new zzac("NO_NETWORK_CONNECTION", 12, 102);
    zzm = localzzac13;
    zzac localzzac14 = new zzac("METERED_NETWORK", 13, 103);
    zzn = localzzac14;
    zzac localzzac15 = new zzac("DOWNLOAD_FAILED", 14, 104);
    zzo = localzzac15;
    zzac localzzac16 = new zzac("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS", 15, 105);
    zzp = localzzac16;
    zzac localzzac17 = new zzac("MODEL_INFO_DOWNLOAD_NO_HASH", 16, 106);
    zzq = localzzac17;
    zzac localzzac18 = new zzac("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED", 17, 107);
    zzr = localzzac18;
    zzac localzzac19 = new zzac("NO_VALID_MODEL", 18, 108);
    zzs = localzzac19;
    zzac localzzac20 = new zzac("LOCAL_MODEL_INVALID", 19, 109);
    zzt = localzzac20;
    zzac localzzac21 = new zzac("REMOTE_MODEL_INVALID", 20, 110);
    zzu = localzzac21;
    zzac localzzac22 = new zzac("REMOTE_MODEL_LOADER_ERROR", 21, 111);
    zzv = localzzac22;
    zzac localzzac23 = new zzac("REMOTE_MODEL_LOADER_LOADS_NO_MODEL", 22, 112);
    zzw = localzzac23;
    zzac localzzac24 = new zzac("SMART_REPLY_LANG_ID_DETECTAION_FAILURE", 23, 113);
    zzx = localzzac24;
    zzac localzzac25 = new zzac("MODEL_NOT_REGISTERED", 24, 114);
    zzy = localzzac25;
    zzac localzzac26 = new zzac("MODEL_TYPE_MISUSE", 25, 115);
    zzz = localzzac26;
    zzac localzzac27 = new zzac("MODEL_HASH_MISMATCH", 26, 116);
    zzaa = localzzac27;
    zzac localzzac28 = new zzac("UNKNOWN_ERROR", 27, 9999);
    zzab = localzzac28;
    zzae = new zzac[] { localzzac1, localzzac2, localzzac3, localzzac4, localzzac5, localzzac6, localzzac7, localzzac8, localzzac9, localzzac10, localzzac11, localzzac12, localzzac13, localzzac14, localzzac15, localzzac16, localzzac17, localzzac18, localzzac19, localzzac20, localzzac21, localzzac22, localzzac23, localzzac24, localzzac25, localzzac26, localzzac27, localzzac28 };
  }
  
  private zzac(int paramInt)
  {
    this.zzad = paramInt;
  }
  
  public static zzer zzb()
  {
    return zzad.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzac.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */