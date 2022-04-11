package com.google.android.gms.internal.vision;

public final class zzlb
  implements zzkz
{
  private static final zzbj<Long> zzahg;
  private static final zzbj<Boolean> zzahh;
  private static final zzbj<Boolean> zzahi;
  private static final zzbj<Boolean> zzahj;
  private static final zzbj<Boolean> zzahk;
  private static final zzbj<Boolean> zzahl;
  private static final zzbj<Boolean> zzahm;
  private static final zzbj<Boolean> zzahn;
  private static final zzbj<Boolean> zzaho;
  private static final zzbj<Boolean> zzahp;
  private static final zzbj<Boolean> zzahq;
  private static final zzbj<Boolean> zzahr;
  private static final zzbj<Long> zzahs;
  private static final zzbj<Long> zzaht;
  
  static
  {
    zzbp localzzbp = new zzbp(zzbg.getContentProviderUri("com.google.android.gms.vision.sdk")).zzf("vision.sdk:");
    zzahg = localzzbp.zza("OptionalModule__check_alarm_seconds", 10L);
    zzahh = localzzbp.zza("OptionalModule__enable_barcode_optional_module", false);
    zzahi = localzzbp.zza("OptionalModule__enable_barcode_optional_module_v25", false);
    zzahj = localzzbp.zza("OptionalModule__enable_face_optional_module", false);
    zzahk = localzzbp.zza("OptionalModule__enable_face_optional_module_v25", true);
    zzahl = localzzbp.zza("OptionalModule__enable_ica_optional_module", false);
    zzahm = localzzbp.zza("OptionalModule__enable_ica_optional_module_v25", false);
    zzahn = localzzbp.zza("OptionalModule__enable_ocr_optional_module", false);
    zzaho = localzzbp.zza("OptionalModule__enable_ocr_optional_module_v25", false);
    zzahp = localzzbp.zza("OptionalModule__enable_old_download_path", true);
    zzahq = localzzbp.zza("OptionalModule__enable_optional_module_download_retry", false);
    zzahr = localzzbp.zza("OptionalModule__enable_progress_listener_for_optional_module_download", false);
    zzahs = localzzbp.zza("OptionalModule__listener_timeout_in_minutes", 5L);
    zzaht = localzzbp.zza("OptionalModule__max_download_status_pending_count", 5L);
  }
  
  public final boolean zzjq()
  {
    return ((Boolean)zzahi.get()).booleanValue();
  }
  
  public final boolean zzjr()
  {
    return ((Boolean)zzahm.get()).booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */