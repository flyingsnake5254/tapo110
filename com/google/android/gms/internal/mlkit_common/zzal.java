package com.google.android.gms.internal.mlkit_common;

public enum zzal
  implements zzfb
{
  private static final zzfe<zzal> zzac = new zzan();
  private final int zzad;
  
  static
  {
    zzal localzzal1 = new zzal("NO_ERROR", 0, 0);
    zza = localzzal1;
    zzal localzzal2 = new zzal("INCOMPATIBLE_INPUT", 1, 1);
    zzb = localzzal2;
    zzal localzzal3 = new zzal("INCOMPATIBLE_OUTPUT", 2, 2);
    zzc = localzzal3;
    zzal localzzal4 = new zzal("INCOMPATIBLE_TFLITE_VERSION", 3, 3);
    zzd = localzzal4;
    zzal localzzal5 = new zzal("MISSING_OP", 4, 4);
    zze = localzzal5;
    zzal localzzal6 = new zzal("DATA_TYPE_ERROR", 5, 6);
    zzf = localzzal6;
    zzal localzzal7 = new zzal("TFLITE_INTERNAL_ERROR", 6, 7);
    zzg = localzzal7;
    zzal localzzal8 = new zzal("TFLITE_UNKNOWN_ERROR", 7, 8);
    zzh = localzzal8;
    zzal localzzal9 = new zzal("MEDIAPIPE_ERROR", 8, 9);
    zzab = localzzal9;
    zzal localzzal10 = new zzal("TIME_OUT_FETCHING_MODEL_METADATA", 9, 5);
    zzi = localzzal10;
    zzal localzzal11 = new zzal("MODEL_NOT_DOWNLOADED", 10, 100);
    zzj = localzzal11;
    zzal localzzal12 = new zzal("URI_EXPIRED", 11, 101);
    zzk = localzzal12;
    zzal localzzal13 = new zzal("NO_NETWORK_CONNECTION", 12, 102);
    zzl = localzzal13;
    zzal localzzal14 = new zzal("METERED_NETWORK", 13, 103);
    zzm = localzzal14;
    zzal localzzal15 = new zzal("DOWNLOAD_FAILED", 14, 104);
    zzn = localzzal15;
    zzal localzzal16 = new zzal("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS", 15, 105);
    zzo = localzzal16;
    zzal localzzal17 = new zzal("MODEL_INFO_DOWNLOAD_NO_HASH", 16, 106);
    zzp = localzzal17;
    zzal localzzal18 = new zzal("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED", 17, 107);
    zzq = localzzal18;
    zzal localzzal19 = new zzal("NO_VALID_MODEL", 18, 108);
    zzr = localzzal19;
    zzal localzzal20 = new zzal("LOCAL_MODEL_INVALID", 19, 109);
    zzs = localzzal20;
    zzal localzzal21 = new zzal("REMOTE_MODEL_INVALID", 20, 110);
    zzt = localzzal21;
    zzal localzzal22 = new zzal("REMOTE_MODEL_LOADER_ERROR", 21, 111);
    zzu = localzzal22;
    zzal localzzal23 = new zzal("REMOTE_MODEL_LOADER_LOADS_NO_MODEL", 22, 112);
    zzv = localzzal23;
    zzal localzzal24 = new zzal("SMART_REPLY_LANG_ID_DETECTAION_FAILURE", 23, 113);
    zzw = localzzal24;
    zzal localzzal25 = new zzal("MODEL_NOT_REGISTERED", 24, 114);
    zzx = localzzal25;
    zzal localzzal26 = new zzal("MODEL_TYPE_MISUSE", 25, 115);
    zzy = localzzal26;
    zzal localzzal27 = new zzal("MODEL_HASH_MISMATCH", 26, 116);
    zzz = localzzal27;
    zzal localzzal28 = new zzal("UNKNOWN_ERROR", 27, 9999);
    zzaa = localzzal28;
    zzae = new zzal[] { localzzal1, localzzal2, localzzal3, localzzal4, localzzal5, localzzal6, localzzal7, localzzal8, localzzal9, localzzal10, localzzal11, localzzal12, localzzal13, localzzal14, localzzal15, localzzal16, localzzal17, localzzal18, localzzal19, localzzal20, localzzal21, localzzal22, localzzal23, localzzal24, localzzal25, localzzal26, localzzal27, localzzal28 };
  }
  
  private zzal(int paramInt)
  {
    this.zzad = paramInt;
  }
  
  public static zzfd zzb()
  {
    return zzam.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzal.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */