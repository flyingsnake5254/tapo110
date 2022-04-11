package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzbw
  implements zzgf
{
  private static final zzge<zzbw> zzdr = new zzbz();
  private final int zzds;
  
  static
  {
    zza = new zzbw("ON_DEVICE_BARCODE_DETECT", 7, 21);
    zzb = new zzbw("ON_DEVICE_BARCODE_CREATE", 8, 22);
    zzk = new zzbw("ON_DEVICE_BARCODE_CLOSE", 9, 23);
    zzl = new zzbw("ON_DEVICE_IMAGE_LABEL_DETECT", 10, 141);
    zzm = new zzbw("ON_DEVICE_IMAGE_LABEL_CREATE", 11, 142);
    zzn = new zzbw("ON_DEVICE_IMAGE_LABEL_CLOSE", 12, 143);
    zzo = new zzbw("ON_DEVICE_IMAGE_LABEL_LOAD", 13, 144);
    zzp = new zzbw("ON_DEVICE_SMART_REPLY_DETECT", 14, 151);
    zzq = new zzbw("ON_DEVICE_SMART_REPLY_CREATE", 15, 152);
    zzr = new zzbw("ON_DEVICE_SMART_REPLY_CLOSE", 16, 153);
    zzs = new zzbw("ON_DEVICE_SMART_REPLY_BLACKLIST_UPDATE", 17, 154);
    zzt = new zzbw("ON_DEVICE_LANGUAGE_IDENTIFICATION_DETECT", 18, 161);
    zzu = new zzbw("ON_DEVICE_LANGUAGE_IDENTIFICATION_CREATE", 19, 162);
    zzv = new zzbw("ON_DEVICE_LANGUAGE_IDENTIFICATION_LOAD", 20, 164);
    zzw = new zzbw("ON_DEVICE_LANGUAGE_IDENTIFICATION_CLOSE", 21, 163);
    zzx = new zzbw("ON_DEVICE_TRANSLATOR_TRANSLATE", 22, 171);
    zzy = new zzbw("ON_DEVICE_TRANSLATOR_CREATE", 23, 172);
    zzz = new zzbw("ON_DEVICE_TRANSLATOR_LOAD", 24, 173);
    zzaa = new zzbw("ON_DEVICE_TRANSLATOR_CLOSE", 25, 174);
    zzab = new zzbw("ON_DEVICE_TRANSLATOR_DOWNLOAD", 26, 175);
    zzac = new zzbw("ON_DEVICE_TC_ANNOTATE", 27, 241);
    zzad = new zzbw("ON_DEVICE_TC_CREATE", 28, 242);
    zzae = new zzbw("ON_DEVICE_TC_LOAD", 29, 243);
    zzaf = new zzbw("ON_DEVICE_TC_CLOSE", 30, 244);
    zzag = new zzbw("ON_DEVICE_TC_DOWNLOAD", 31, 245);
    zzah = new zzbw("ON_DEVICE_OBJECT_CREATE", 32, 191);
    zzai = new zzbw("ON_DEVICE_OBJECT_LOAD", 33, 192);
    zzaj = new zzbw("ON_DEVICE_OBJECT_INFERENCE", 34, 193);
    zzak = new zzbw("ON_DEVICE_OBJECT_CLOSE", 35, 194);
    zzal = new zzbw("ON_DEVICE_DI_CREATE", 36, 311);
    zzam = new zzbw("ON_DEVICE_DI_LOAD", 37, 312);
    zzan = new zzbw("ON_DEVICE_DI_DOWNLOAD", 38, 313);
    zzao = new zzbw("ON_DEVICE_DI_RECOGNIZE", 39, 314);
    zzap = new zzbw("ON_DEVICE_DI_CLOSE", 40, 315);
    zzaq = new zzbw("ON_DEVICE_POSE_CREATE", 41, 321);
    zzar = new zzbw("ON_DEVICE_POSE_LOAD", 42, 322);
    zzas = new zzbw("ON_DEVICE_POSE_INFERENCE", 43, 323);
    zzat = new zzbw("ON_DEVICE_POSE_CLOSE", 44, 324);
    zzau = new zzbw("ON_DEVICE_SEGMENTATION_CREATE", 45, 331);
    zzav = new zzbw("ON_DEVICE_SEGMENTATION_LOAD", 46, 332);
    zzaw = new zzbw("ON_DEVICE_SEGMENTATION_INFERENCE", 47, 333);
    zzax = new zzbw("ON_DEVICE_SEGMENTATION_CLOSE", 48, 334);
    zzay = new zzbw("CUSTOM_OBJECT_CREATE", 49, 341);
    zzaz = new zzbw("CUSTOM_OBJECT_LOAD", 50, 342);
    zzba = new zzbw("CUSTOM_OBJECT_INFERENCE", 51, 343);
    zzbb = new zzbw("CUSTOM_OBJECT_CLOSE", 52, 344);
    zzbc = new zzbw("CUSTOM_IMAGE_LABEL_CREATE", 53, 351);
    zzbd = new zzbw("CUSTOM_IMAGE_LABEL_LOAD", 54, 352);
    zzbe = new zzbw("CUSTOM_IMAGE_LABEL_DETECT", 55, 353);
    zzbf = new zzbw("CUSTOM_IMAGE_LABEL_CLOSE", 56, 354);
    zzbg = new zzbw("CLOUD_FACE_DETECT", 57, 31);
    zzbh = new zzbw("CLOUD_FACE_CREATE", 58, 32);
    zzbi = new zzbw("CLOUD_FACE_CLOSE", 59, 33);
    zzbj = new zzbw("CLOUD_CROP_HINTS_CREATE", 60, 41);
    zzbk = new zzbw("CLOUD_CROP_HINTS_DETECT", 61, 42);
    zzbl = new zzbw("CLOUD_CROP_HINTS_CLOSE", 62, 43);
    zzbm = new zzbw("CLOUD_DOCUMENT_TEXT_CREATE", 63, 51);
    zzbn = new zzbw("CLOUD_DOCUMENT_TEXT_DETECT", 64, 52);
    zzbo = new zzbw("CLOUD_DOCUMENT_TEXT_CLOSE", 65, 53);
    zzbp = new zzbw("CLOUD_IMAGE_PROPERTIES_CREATE", 66, 61);
    zzbq = new zzbw("CLOUD_IMAGE_PROPERTIES_DETECT", 67, 62);
    zzbr = new zzbw("CLOUD_IMAGE_PROPERTIES_CLOSE", 68, 63);
    zzbs = new zzbw("CLOUD_IMAGE_LABEL_CREATE", 69, 71);
    zzbt = new zzbw("CLOUD_IMAGE_LABEL_DETECT", 70, 72);
    zzbu = new zzbw("CLOUD_IMAGE_LABEL_CLOSE", 71, 73);
    zzbv = new zzbw("CLOUD_LANDMARK_CREATE", 72, 81);
    zzbw = new zzbw("CLOUD_LANDMARK_DETECT", 73, 82);
    zzbx = new zzbw("CLOUD_LANDMARK_CLOSE", 74, 83);
    zzby = new zzbw("CLOUD_LOGO_CREATE", 75, 91);
    zzbz = new zzbw("CLOUD_LOGO_DETECT", 76, 92);
    zzca = new zzbw("CLOUD_LOGO_CLOSE", 77, 93);
    zzcb = new zzbw("CLOUD_SAFE_SEARCH_CREATE", 78, 111);
    zzcc = new zzbw("CLOUD_SAFE_SEARCH_DETECT", 79, 112);
    zzcd = new zzbw("CLOUD_SAFE_SEARCH_CLOSE", 80, 113);
    zzce = new zzbw("CLOUD_TEXT_CREATE", 81, 121);
    zzcf = new zzbw("CLOUD_TEXT_DETECT", 82, 122);
    zzcg = new zzbw("CLOUD_TEXT_CLOSE", 83, 123);
    zzch = new zzbw("CLOUD_WEB_SEARCH_CREATE", 84, 131);
    zzci = new zzbw("CLOUD_WEB_SEARCH_DETECT", 85, 132);
    zzcj = new zzbw("CLOUD_WEB_SEARCH_CLOSE", 86, 133);
    zzck = new zzbw("CUSTOM_MODEL_RUN", 87, 102);
    zzcl = new zzbw("CUSTOM_MODEL_CREATE", 88, 103);
    zzcm = new zzbw("CUSTOM_MODEL_CLOSE", 89, 104);
    zzcn = new zzbw("CUSTOM_MODEL_LOAD", 90, 105);
    zzco = new zzbw("AUTOML_IMAGE_LABELING_RUN", 91, 181);
    zzcp = new zzbw("AUTOML_IMAGE_LABELING_CREATE", 92, 182);
    zzcq = new zzbw("AUTOML_IMAGE_LABELING_CLOSE", 93, 183);
    zzcr = new zzbw("AUTOML_IMAGE_LABELING_LOAD", 94, 184);
    zzcs = new zzbw("MODEL_DOWNLOAD", 95, 100);
    zzct = new zzbw("MODEL_UPDATE", 96, 101);
    zzcu = new zzbw("REMOTE_MODEL_IS_DOWNLOADED", 97, 251);
    zzcv = new zzbw("REMOTE_MODEL_DELETE_ON_DEVICE", 98, 252);
    zzcw = new zzbw("ACCELERATION_ANALYTICS", 99, 260);
    zzcx = new zzbw("AGGREGATED_AUTO_ML_IMAGE_LABELING_INFERENCE", 100, 200);
    zzcy = new zzbw("AGGREGATED_CUSTOM_MODEL_INFERENCE", 101, 201);
    zzc = new zzbw("AGGREGATED_ON_DEVICE_BARCODE_DETECTION", 102, 202);
    zzcz = new zzbw("AGGREGATED_ON_DEVICE_FACE_DETECTION", 103, 203);
    zzda = new zzbw("AGGREGATED_ON_DEVICE_IMAGE_LABEL_DETECTION", 104, 204);
    zzdb = new zzbw("AGGREGATED_ON_DEVICE_OBJECT_INFERENCE", 105, 205);
    zzdc = new zzbw("AGGREGATED_ON_DEVICE_TEXT_DETECTION", 106, 206);
    zzdd = new zzbw("AGGREGATED_ON_DEVICE_POSE_DETECTION", 107, 207);
    zzde = new zzbw("AGGREGATED_ON_DEVICE_SEGMENTATION", 108, 208);
    zzdf = new zzbw("AGGREGATED_CUSTOM_OBJECT_INFERENCE", 109, 209);
    zzdg = new zzbw("AGGREGATED_CUSTOM_IMAGE_LABEL_DETECTION", 110, 210);
    zzdh = new zzbw("REMOTE_CONFIG_FETCH", 111, 271);
    zzdi = new zzbw("REMOTE_CONFIG_ACTIVATE", 112, 272);
    zzdj = new zzbw("REMOTE_CONFIG_FRC_FETCH", 113, 281);
    zzdk = new zzbw("INSTALLATION_ID_INIT", 114, 291);
    zzdl = new zzbw("INSTALLATION_ID_REGISTER_NEW_ID", 115, 292);
    zzdm = new zzbw("INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN", 116, 293);
    zzdn = new zzbw("INSTALLATION_ID_FIS_CREATE_INSTALLATION", 117, 301);
    zzdo = new zzbw("INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN", 118, 302);
    zzdp = new zzbw("INPUT_IMAGE_CONSTRUCTION", 119, 361);
    zzdq = new zzbw("HANDLE_LEAKED", 120, 371);
    zzdt = new zzbw[] { zzd, zze, zzf, zzg, zzh, zzi, zzj, zza, zzb, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzax, zzay, zzaz, zzba, zzbb, zzbc, zzbd, zzbe, zzbf, zzbg, zzbh, zzbi, zzbj, zzbk, zzbl, zzbm, zzbn, zzbo, zzbp, zzbq, zzbr, zzbs, zzbt, zzbu, zzbv, zzbw, zzbx, zzby, zzbz, zzca, zzcb, zzcc, zzcd, zzce, zzcf, zzcg, zzch, zzci, zzcj, zzck, zzcl, zzcm, zzcn, zzco, zzcp, zzcq, zzcr, zzcs, zzct, zzcu, zzcv, zzcw, zzcx, zzcy, zzc, zzcz, zzda, zzdb, zzdc, zzdd, zzde, zzdf, zzdg, zzdh, zzdi, zzdj, zzdk, zzdl, zzdm, zzdn, zzdo, zzdp, zzdq };
  }
  
  private zzbw(int paramInt)
  {
    this.zzds = paramInt;
  }
  
  public static zzgh zzb()
  {
    return zzby.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzbw.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */