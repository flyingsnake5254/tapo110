package com.google.android.gms.internal.mlkit_common;

public enum zzap
  implements zzfb
{
  private static final zzfe<zzap> zzdr = new zzao();
  private final int zzds;
  
  static
  {
    zzaa = new zzap("ON_DEVICE_TRANSLATOR_LOAD", 24, 173);
    zzab = new zzap("ON_DEVICE_TRANSLATOR_CLOSE", 25, 174);
    zzac = new zzap("ON_DEVICE_TRANSLATOR_DOWNLOAD", 26, 175);
    zzad = new zzap("ON_DEVICE_TC_ANNOTATE", 27, 241);
    zzae = new zzap("ON_DEVICE_TC_CREATE", 28, 242);
    zzaf = new zzap("ON_DEVICE_TC_LOAD", 29, 243);
    zzag = new zzap("ON_DEVICE_TC_CLOSE", 30, 244);
    zzah = new zzap("ON_DEVICE_TC_DOWNLOAD", 31, 245);
    zzai = new zzap("ON_DEVICE_OBJECT_CREATE", 32, 191);
    zzaj = new zzap("ON_DEVICE_OBJECT_LOAD", 33, 192);
    zzak = new zzap("ON_DEVICE_OBJECT_INFERENCE", 34, 193);
    zzal = new zzap("ON_DEVICE_OBJECT_CLOSE", 35, 194);
    zzam = new zzap("ON_DEVICE_DI_CREATE", 36, 311);
    zzan = new zzap("ON_DEVICE_DI_LOAD", 37, 312);
    zzao = new zzap("ON_DEVICE_DI_DOWNLOAD", 38, 313);
    zzap = new zzap("ON_DEVICE_DI_RECOGNIZE", 39, 314);
    zzaq = new zzap("ON_DEVICE_DI_CLOSE", 40, 315);
    zzar = new zzap("ON_DEVICE_POSE_CREATE", 41, 321);
    zzas = new zzap("ON_DEVICE_POSE_LOAD", 42, 322);
    zzat = new zzap("ON_DEVICE_POSE_INFERENCE", 43, 323);
    zzau = new zzap("ON_DEVICE_POSE_CLOSE", 44, 324);
    zzav = new zzap("ON_DEVICE_SEGMENTATION_CREATE", 45, 331);
    zzaw = new zzap("ON_DEVICE_SEGMENTATION_LOAD", 46, 332);
    zzax = new zzap("ON_DEVICE_SEGMENTATION_INFERENCE", 47, 333);
    zzay = new zzap("ON_DEVICE_SEGMENTATION_CLOSE", 48, 334);
    zzaz = new zzap("CUSTOM_OBJECT_CREATE", 49, 341);
    zzba = new zzap("CUSTOM_OBJECT_LOAD", 50, 342);
    zzbb = new zzap("CUSTOM_OBJECT_INFERENCE", 51, 343);
    zzbc = new zzap("CUSTOM_OBJECT_CLOSE", 52, 344);
    zzbd = new zzap("CUSTOM_IMAGE_LABEL_CREATE", 53, 351);
    zzbe = new zzap("CUSTOM_IMAGE_LABEL_LOAD", 54, 352);
    zzbf = new zzap("CUSTOM_IMAGE_LABEL_DETECT", 55, 353);
    zzbg = new zzap("CUSTOM_IMAGE_LABEL_CLOSE", 56, 354);
    zzbh = new zzap("CLOUD_FACE_DETECT", 57, 31);
    zzbi = new zzap("CLOUD_FACE_CREATE", 58, 32);
    zzbj = new zzap("CLOUD_FACE_CLOSE", 59, 33);
    zzbk = new zzap("CLOUD_CROP_HINTS_CREATE", 60, 41);
    zzbl = new zzap("CLOUD_CROP_HINTS_DETECT", 61, 42);
    zzbm = new zzap("CLOUD_CROP_HINTS_CLOSE", 62, 43);
    zzbn = new zzap("CLOUD_DOCUMENT_TEXT_CREATE", 63, 51);
    zzbo = new zzap("CLOUD_DOCUMENT_TEXT_DETECT", 64, 52);
    zzbp = new zzap("CLOUD_DOCUMENT_TEXT_CLOSE", 65, 53);
    zzbq = new zzap("CLOUD_IMAGE_PROPERTIES_CREATE", 66, 61);
    zzbr = new zzap("CLOUD_IMAGE_PROPERTIES_DETECT", 67, 62);
    zzbs = new zzap("CLOUD_IMAGE_PROPERTIES_CLOSE", 68, 63);
    zzbt = new zzap("CLOUD_IMAGE_LABEL_CREATE", 69, 71);
    zzbu = new zzap("CLOUD_IMAGE_LABEL_DETECT", 70, 72);
    zzbv = new zzap("CLOUD_IMAGE_LABEL_CLOSE", 71, 73);
    zzbw = new zzap("CLOUD_LANDMARK_CREATE", 72, 81);
    zzbx = new zzap("CLOUD_LANDMARK_DETECT", 73, 82);
    zzby = new zzap("CLOUD_LANDMARK_CLOSE", 74, 83);
    zzbz = new zzap("CLOUD_LOGO_CREATE", 75, 91);
    zzca = new zzap("CLOUD_LOGO_DETECT", 76, 92);
    zzcb = new zzap("CLOUD_LOGO_CLOSE", 77, 93);
    zzcc = new zzap("CLOUD_SAFE_SEARCH_CREATE", 78, 111);
    zzcd = new zzap("CLOUD_SAFE_SEARCH_DETECT", 79, 112);
    zzce = new zzap("CLOUD_SAFE_SEARCH_CLOSE", 80, 113);
    zzcf = new zzap("CLOUD_TEXT_CREATE", 81, 121);
    zzcg = new zzap("CLOUD_TEXT_DETECT", 82, 122);
    zzch = new zzap("CLOUD_TEXT_CLOSE", 83, 123);
    zzci = new zzap("CLOUD_WEB_SEARCH_CREATE", 84, 131);
    zzcj = new zzap("CLOUD_WEB_SEARCH_DETECT", 85, 132);
    zzck = new zzap("CLOUD_WEB_SEARCH_CLOSE", 86, 133);
    zzcl = new zzap("CUSTOM_MODEL_RUN", 87, 102);
    zzcm = new zzap("CUSTOM_MODEL_CREATE", 88, 103);
    zzcn = new zzap("CUSTOM_MODEL_CLOSE", 89, 104);
    zzco = new zzap("CUSTOM_MODEL_LOAD", 90, 105);
    zzcp = new zzap("AUTOML_IMAGE_LABELING_RUN", 91, 181);
    zzcq = new zzap("AUTOML_IMAGE_LABELING_CREATE", 92, 182);
    zzcr = new zzap("AUTOML_IMAGE_LABELING_CLOSE", 93, 183);
    zzcs = new zzap("AUTOML_IMAGE_LABELING_LOAD", 94, 184);
    zza = new zzap("MODEL_DOWNLOAD", 95, 100);
    zzct = new zzap("MODEL_UPDATE", 96, 101);
    zzcu = new zzap("REMOTE_MODEL_IS_DOWNLOADED", 97, 251);
    zzcv = new zzap("REMOTE_MODEL_DELETE_ON_DEVICE", 98, 252);
    zzcw = new zzap("ACCELERATION_ANALYTICS", 99, 260);
    zzcx = new zzap("AGGREGATED_AUTO_ML_IMAGE_LABELING_INFERENCE", 100, 200);
    zzcy = new zzap("AGGREGATED_CUSTOM_MODEL_INFERENCE", 101, 201);
    zzcz = new zzap("AGGREGATED_ON_DEVICE_BARCODE_DETECTION", 102, 202);
    zzda = new zzap("AGGREGATED_ON_DEVICE_FACE_DETECTION", 103, 203);
    zzdb = new zzap("AGGREGATED_ON_DEVICE_IMAGE_LABEL_DETECTION", 104, 204);
    zzdc = new zzap("AGGREGATED_ON_DEVICE_OBJECT_INFERENCE", 105, 205);
    zzdd = new zzap("AGGREGATED_ON_DEVICE_TEXT_DETECTION", 106, 206);
    zzde = new zzap("AGGREGATED_ON_DEVICE_POSE_DETECTION", 107, 207);
    zzdf = new zzap("AGGREGATED_ON_DEVICE_SEGMENTATION", 108, 208);
    zzdg = new zzap("AGGREGATED_CUSTOM_OBJECT_INFERENCE", 109, 209);
    zzdh = new zzap("AGGREGATED_CUSTOM_IMAGE_LABEL_DETECTION", 110, 210);
    zzdi = new zzap("REMOTE_CONFIG_FETCH", 111, 271);
    zzdj = new zzap("REMOTE_CONFIG_ACTIVATE", 112, 272);
    zzdk = new zzap("REMOTE_CONFIG_FRC_FETCH", 113, 281);
    zzdl = new zzap("INSTALLATION_ID_INIT", 114, 291);
    zzdm = new zzap("INSTALLATION_ID_REGISTER_NEW_ID", 115, 292);
    zzdn = new zzap("INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN", 116, 293);
    zzdo = new zzap("INSTALLATION_ID_FIS_CREATE_INSTALLATION", 117, 301);
    zzdp = new zzap("INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN", 118, 302);
    zzdq = new zzap("INPUT_IMAGE_CONSTRUCTION", 119, 361);
    zzb = new zzap("HANDLE_LEAKED", 120, 371);
    zzdt = new zzap[] { zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzax, zzay, zzaz, zzba, zzbb, zzbc, zzbd, zzbe, zzbf, zzbg, zzbh, zzbi, zzbj, zzbk, zzbl, zzbm, zzbn, zzbo, zzbp, zzbq, zzbr, zzbs, zzbt, zzbu, zzbv, zzbw, zzbx, zzby, zzbz, zzca, zzcb, zzcc, zzcd, zzce, zzcf, zzcg, zzch, zzci, zzcj, zzck, zzcl, zzcm, zzcn, zzco, zzcp, zzcq, zzcr, zzcs, zza, zzct, zzcu, zzcv, zzcw, zzcx, zzcy, zzcz, zzda, zzdb, zzdc, zzdd, zzde, zzdf, zzdg, zzdh, zzdi, zzdj, zzdk, zzdl, zzdm, zzdn, zzdo, zzdp, zzdq, zzb };
  }
  
  private zzap(int paramInt)
  {
    this.zzds = paramInt;
  }
  
  public static zzfd zzb()
  {
    return zzaq.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzap.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzds);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzds;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */