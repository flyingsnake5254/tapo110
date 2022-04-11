package com.google.android.gms.internal.mlkit_vision_common;

public enum zzag
  implements zzep
{
  private static final zzeo<zzag> zzdr = new zzaf();
  private final int zzds;
  
  static
  {
    zzaa = new zzag("ON_DEVICE_TRANSLATOR_CLOSE", 25, 174);
    zzab = new zzag("ON_DEVICE_TRANSLATOR_DOWNLOAD", 26, 175);
    zzac = new zzag("ON_DEVICE_TC_ANNOTATE", 27, 241);
    zzad = new zzag("ON_DEVICE_TC_CREATE", 28, 242);
    zzae = new zzag("ON_DEVICE_TC_LOAD", 29, 243);
    zzaf = new zzag("ON_DEVICE_TC_CLOSE", 30, 244);
    zzag = new zzag("ON_DEVICE_TC_DOWNLOAD", 31, 245);
    zzah = new zzag("ON_DEVICE_OBJECT_CREATE", 32, 191);
    zzai = new zzag("ON_DEVICE_OBJECT_LOAD", 33, 192);
    zzaj = new zzag("ON_DEVICE_OBJECT_INFERENCE", 34, 193);
    zzak = new zzag("ON_DEVICE_OBJECT_CLOSE", 35, 194);
    zzal = new zzag("ON_DEVICE_DI_CREATE", 36, 311);
    zzam = new zzag("ON_DEVICE_DI_LOAD", 37, 312);
    zzan = new zzag("ON_DEVICE_DI_DOWNLOAD", 38, 313);
    zzao = new zzag("ON_DEVICE_DI_RECOGNIZE", 39, 314);
    zzap = new zzag("ON_DEVICE_DI_CLOSE", 40, 315);
    zzaq = new zzag("ON_DEVICE_POSE_CREATE", 41, 321);
    zzar = new zzag("ON_DEVICE_POSE_LOAD", 42, 322);
    zzas = new zzag("ON_DEVICE_POSE_INFERENCE", 43, 323);
    zzat = new zzag("ON_DEVICE_POSE_CLOSE", 44, 324);
    zzau = new zzag("ON_DEVICE_SEGMENTATION_CREATE", 45, 331);
    zzav = new zzag("ON_DEVICE_SEGMENTATION_LOAD", 46, 332);
    zzaw = new zzag("ON_DEVICE_SEGMENTATION_INFERENCE", 47, 333);
    zzax = new zzag("ON_DEVICE_SEGMENTATION_CLOSE", 48, 334);
    zzay = new zzag("CUSTOM_OBJECT_CREATE", 49, 341);
    zzaz = new zzag("CUSTOM_OBJECT_LOAD", 50, 342);
    zzba = new zzag("CUSTOM_OBJECT_INFERENCE", 51, 343);
    zzbb = new zzag("CUSTOM_OBJECT_CLOSE", 52, 344);
    zzbc = new zzag("CUSTOM_IMAGE_LABEL_CREATE", 53, 351);
    zzbd = new zzag("CUSTOM_IMAGE_LABEL_LOAD", 54, 352);
    zzbe = new zzag("CUSTOM_IMAGE_LABEL_DETECT", 55, 353);
    zzbf = new zzag("CUSTOM_IMAGE_LABEL_CLOSE", 56, 354);
    zzbg = new zzag("CLOUD_FACE_DETECT", 57, 31);
    zzbh = new zzag("CLOUD_FACE_CREATE", 58, 32);
    zzbi = new zzag("CLOUD_FACE_CLOSE", 59, 33);
    zzbj = new zzag("CLOUD_CROP_HINTS_CREATE", 60, 41);
    zzbk = new zzag("CLOUD_CROP_HINTS_DETECT", 61, 42);
    zzbl = new zzag("CLOUD_CROP_HINTS_CLOSE", 62, 43);
    zzbm = new zzag("CLOUD_DOCUMENT_TEXT_CREATE", 63, 51);
    zzbn = new zzag("CLOUD_DOCUMENT_TEXT_DETECT", 64, 52);
    zzbo = new zzag("CLOUD_DOCUMENT_TEXT_CLOSE", 65, 53);
    zzbp = new zzag("CLOUD_IMAGE_PROPERTIES_CREATE", 66, 61);
    zzbq = new zzag("CLOUD_IMAGE_PROPERTIES_DETECT", 67, 62);
    zzbr = new zzag("CLOUD_IMAGE_PROPERTIES_CLOSE", 68, 63);
    zzbs = new zzag("CLOUD_IMAGE_LABEL_CREATE", 69, 71);
    zzbt = new zzag("CLOUD_IMAGE_LABEL_DETECT", 70, 72);
    zzbu = new zzag("CLOUD_IMAGE_LABEL_CLOSE", 71, 73);
    zzbv = new zzag("CLOUD_LANDMARK_CREATE", 72, 81);
    zzbw = new zzag("CLOUD_LANDMARK_DETECT", 73, 82);
    zzbx = new zzag("CLOUD_LANDMARK_CLOSE", 74, 83);
    zzby = new zzag("CLOUD_LOGO_CREATE", 75, 91);
    zzbz = new zzag("CLOUD_LOGO_DETECT", 76, 92);
    zzca = new zzag("CLOUD_LOGO_CLOSE", 77, 93);
    zzcb = new zzag("CLOUD_SAFE_SEARCH_CREATE", 78, 111);
    zzcc = new zzag("CLOUD_SAFE_SEARCH_DETECT", 79, 112);
    zzcd = new zzag("CLOUD_SAFE_SEARCH_CLOSE", 80, 113);
    zzce = new zzag("CLOUD_TEXT_CREATE", 81, 121);
    zzcf = new zzag("CLOUD_TEXT_DETECT", 82, 122);
    zzcg = new zzag("CLOUD_TEXT_CLOSE", 83, 123);
    zzch = new zzag("CLOUD_WEB_SEARCH_CREATE", 84, 131);
    zzci = new zzag("CLOUD_WEB_SEARCH_DETECT", 85, 132);
    zzcj = new zzag("CLOUD_WEB_SEARCH_CLOSE", 86, 133);
    zzck = new zzag("CUSTOM_MODEL_RUN", 87, 102);
    zzcl = new zzag("CUSTOM_MODEL_CREATE", 88, 103);
    zzcm = new zzag("CUSTOM_MODEL_CLOSE", 89, 104);
    zzcn = new zzag("CUSTOM_MODEL_LOAD", 90, 105);
    zzco = new zzag("AUTOML_IMAGE_LABELING_RUN", 91, 181);
    zzcp = new zzag("AUTOML_IMAGE_LABELING_CREATE", 92, 182);
    zzcq = new zzag("AUTOML_IMAGE_LABELING_CLOSE", 93, 183);
    zzcr = new zzag("AUTOML_IMAGE_LABELING_LOAD", 94, 184);
    zzcs = new zzag("MODEL_DOWNLOAD", 95, 100);
    zzct = new zzag("MODEL_UPDATE", 96, 101);
    zzcu = new zzag("REMOTE_MODEL_IS_DOWNLOADED", 97, 251);
    zzcv = new zzag("REMOTE_MODEL_DELETE_ON_DEVICE", 98, 252);
    zzcw = new zzag("ACCELERATION_ANALYTICS", 99, 260);
    zzcx = new zzag("AGGREGATED_AUTO_ML_IMAGE_LABELING_INFERENCE", 100, 200);
    zzcy = new zzag("AGGREGATED_CUSTOM_MODEL_INFERENCE", 101, 201);
    zzcz = new zzag("AGGREGATED_ON_DEVICE_BARCODE_DETECTION", 102, 202);
    zzda = new zzag("AGGREGATED_ON_DEVICE_FACE_DETECTION", 103, 203);
    zzdb = new zzag("AGGREGATED_ON_DEVICE_IMAGE_LABEL_DETECTION", 104, 204);
    zzdc = new zzag("AGGREGATED_ON_DEVICE_OBJECT_INFERENCE", 105, 205);
    zzdd = new zzag("AGGREGATED_ON_DEVICE_TEXT_DETECTION", 106, 206);
    zzde = new zzag("AGGREGATED_ON_DEVICE_POSE_DETECTION", 107, 207);
    zzdf = new zzag("AGGREGATED_ON_DEVICE_SEGMENTATION", 108, 208);
    zzdg = new zzag("AGGREGATED_CUSTOM_OBJECT_INFERENCE", 109, 209);
    zzdh = new zzag("AGGREGATED_CUSTOM_IMAGE_LABEL_DETECTION", 110, 210);
    zzdi = new zzag("REMOTE_CONFIG_FETCH", 111, 271);
    zzdj = new zzag("REMOTE_CONFIG_ACTIVATE", 112, 272);
    zzdk = new zzag("REMOTE_CONFIG_FRC_FETCH", 113, 281);
    zzdl = new zzag("INSTALLATION_ID_INIT", 114, 291);
    zzdm = new zzag("INSTALLATION_ID_REGISTER_NEW_ID", 115, 292);
    zzdn = new zzag("INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN", 116, 293);
    zzdo = new zzag("INSTALLATION_ID_FIS_CREATE_INSTALLATION", 117, 301);
    zzdp = new zzag("INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN", 118, 302);
    zza = new zzag("INPUT_IMAGE_CONSTRUCTION", 119, 361);
    zzdq = new zzag("HANDLE_LEAKED", 120, 371);
    zzdt = new zzag[] { zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzax, zzay, zzaz, zzba, zzbb, zzbc, zzbd, zzbe, zzbf, zzbg, zzbh, zzbi, zzbj, zzbk, zzbl, zzbm, zzbn, zzbo, zzbp, zzbq, zzbr, zzbs, zzbt, zzbu, zzbv, zzbw, zzbx, zzby, zzbz, zzca, zzcb, zzcc, zzcd, zzce, zzcf, zzcg, zzch, zzci, zzcj, zzck, zzcl, zzcm, zzcn, zzco, zzcp, zzcq, zzcr, zzcs, zzct, zzcu, zzcv, zzcw, zzcx, zzcy, zzcz, zzda, zzdb, zzdc, zzdd, zzde, zzdf, zzdg, zzdh, zzdi, zzdj, zzdk, zzdl, zzdm, zzdn, zzdo, zzdp, zza, zzdq };
  }
  
  private zzag(int paramInt)
  {
    this.zzds = paramInt;
  }
  
  public static zzer zzb()
  {
    return zzah.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzag.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */