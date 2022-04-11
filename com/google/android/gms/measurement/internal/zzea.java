package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
public final class zzea
{
  public static final zzdz<Long> zzA;
  public static final zzdz<Integer> zzB;
  public static final zzdz<Long> zzC;
  public static final zzdz<Integer> zzD;
  public static final zzdz<Integer> zzE;
  public static final zzdz<Integer> zzF;
  public static final zzdz<Integer> zzG;
  public static final zzdz<Integer> zzH;
  public static final zzdz<Long> zzI;
  public static final zzdz<Boolean> zzJ;
  public static final zzdz<String> zzK;
  public static final zzdz<Long> zzL;
  public static final zzdz<Integer> zzM;
  public static final zzdz<Double> zzN;
  public static final zzdz<Integer> zzO;
  public static final zzdz<Integer> zzP;
  public static final zzdz<Long> zzQ;
  public static final zzdz<Boolean> zzR;
  public static final zzdz<Boolean> zzS;
  public static final zzdz<Boolean> zzT;
  public static final zzdz<Boolean> zzU;
  public static final zzdz<Boolean> zzV;
  public static final zzdz<Boolean> zzW;
  public static final zzdz<Boolean> zzX;
  public static final zzdz<Boolean> zzY;
  public static final zzdz<Boolean> zzZ;
  public static final zzdz<Long> zza;
  public static final zzdz<Boolean> zzaA;
  public static final zzdz<Boolean> zzaB;
  public static final zzdz<Boolean> zzaC;
  public static final zzdz<Boolean> zzaD;
  public static final zzdz<Boolean> zzaE;
  public static final zzdz<Boolean> zzaF;
  private static final List<zzdz<?>> zzaG = Collections.synchronizedList(new ArrayList());
  private static final Set<zzdz<?>> zzaH = Collections.synchronizedSet(new HashSet());
  public static final zzdz<Boolean> zzaa;
  public static final zzdz<Boolean> zzab;
  public static final zzdz<Boolean> zzac;
  public static final zzdz<Boolean> zzad;
  public static final zzdz<Boolean> zzae;
  public static final zzdz<Boolean> zzaf;
  public static final zzdz<Boolean> zzag;
  public static final zzdz<Boolean> zzah;
  public static final zzdz<Boolean> zzai;
  public static final zzdz<Boolean> zzaj;
  public static final zzdz<Boolean> zzak;
  public static final zzdz<Boolean> zzal;
  public static final zzdz<Boolean> zzam;
  public static final zzdz<Boolean> zzan;
  public static final zzdz<Boolean> zzao;
  public static final zzdz<Boolean> zzap;
  public static final zzdz<Boolean> zzaq;
  public static final zzdz<Boolean> zzar;
  public static final zzdz<Boolean> zzas;
  public static final zzdz<Boolean> zzat;
  public static final zzdz<Integer> zzau;
  public static final zzdz<Boolean> zzav;
  public static final zzdz<Boolean> zzaw;
  public static final zzdz<Boolean> zzax;
  public static final zzdz<Boolean> zzay;
  public static final zzdz<Boolean> zzaz;
  public static final zzdz<Long> zzb;
  public static final zzdz<Long> zzc;
  public static final zzdz<String> zzd;
  public static final zzdz<String> zze;
  public static final zzdz<Integer> zzf;
  public static final zzdz<Integer> zzg;
  public static final zzdz<Integer> zzh;
  public static final zzdz<Integer> zzi;
  public static final zzdz<Integer> zzj;
  public static final zzdz<Integer> zzk;
  public static final zzdz<Integer> zzl;
  public static final zzdz<Integer> zzm;
  public static final zzdz<Integer> zzn;
  public static final zzdz<Integer> zzo;
  public static final zzdz<String> zzp;
  public static final zzdz<Long> zzq;
  public static final zzdz<Long> zzr;
  public static final zzdz<Long> zzs;
  public static final zzdz<Long> zzt;
  public static final zzdz<Long> zzu;
  public static final zzdz<Long> zzv;
  public static final zzdz<Long> zzw;
  public static final zzdz<Long> zzx;
  public static final zzdz<Long> zzy;
  public static final zzdz<Long> zzz;
  
  static
  {
    Object localObject1 = Long.valueOf(10000L);
    zza = zzb("measurement.ad_id_cache_time", localObject1, localObject1, zzau.zza);
    Object localObject2 = Long.valueOf(86400000L);
    zzb = zzb("measurement.monitoring.sample_period_millis", localObject2, localObject2, zzbf.zza);
    Object localObject3 = Long.valueOf(3600000L);
    zzc = zzb("measurement.config.cache_time", localObject2, localObject3, zzbq.zza);
    zzd = zzb("measurement.config.url_scheme", "https", "https", zzcb.zza);
    zze = zzb("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcm.zza);
    Integer localInteger1 = Integer.valueOf(100);
    zzf = zzb("measurement.upload.max_bundles", localInteger1, localInteger1, zzcx.zza);
    Object localObject4 = Integer.valueOf(65536);
    zzg = zzb("measurement.upload.max_batch_size", localObject4, localObject4, zzdi.zza);
    zzh = zzb("measurement.upload.max_bundle_size", localObject4, localObject4, zzdt.zza);
    Integer localInteger2 = Integer.valueOf(1000);
    zzi = zzb("measurement.upload.max_events_per_bundle", localInteger2, localInteger2, zzdu.zza);
    localObject4 = Integer.valueOf(100000);
    zzj = zzb("measurement.upload.max_events_per_day", localObject4, localObject4, zzdv.zza);
    zzk = zzb("measurement.upload.max_error_events_per_day", localInteger2, localInteger2, zzav.zza);
    localInteger2 = Integer.valueOf(50000);
    zzl = zzb("measurement.upload.max_public_events_per_day", localInteger2, localInteger2, zzaw.zza);
    localInteger2 = Integer.valueOf(10000);
    zzm = zzb("measurement.upload.max_conversions_per_day", localInteger2, localInteger2, zzax.zza);
    localInteger2 = Integer.valueOf(10);
    zzn = zzb("measurement.upload.max_realtime_events_per_day", localInteger2, localInteger2, zzay.zza);
    zzo = zzb("measurement.store.max_stored_events_per_app", localObject4, localObject4, zzaz.zza);
    zzp = zzb("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzba.zza);
    localObject4 = Long.valueOf(43200000L);
    zzq = zzb("measurement.upload.backoff_period", localObject4, localObject4, zzbb.zza);
    zzr = zzb("measurement.upload.window_interval", localObject3, localObject3, zzbc.zza);
    zzs = zzb("measurement.upload.interval", localObject3, localObject3, zzbd.zza);
    zzt = zzb("measurement.upload.realtime_upload_interval", localObject1, localObject1, zzbe.zza);
    localObject1 = Long.valueOf(1000L);
    zzu = zzb("measurement.upload.debug_upload_interval", localObject1, localObject1, zzbg.zza);
    localObject1 = Long.valueOf(500L);
    zzv = zzb("measurement.upload.minimum_delay", localObject1, localObject1, zzbh.zza);
    localObject1 = Long.valueOf(60000L);
    zzw = zzb("measurement.alarm_manager.minimum_interval", localObject1, localObject1, zzbi.zza);
    zzx = zzb("measurement.upload.stale_data_deletion_interval", localObject2, localObject2, zzbj.zza);
    localObject2 = Long.valueOf(604800000L);
    zzy = zzb("measurement.upload.refresh_blacklisted_config_interval", localObject2, localObject2, zzbk.zza);
    localObject1 = Long.valueOf(15000L);
    zzz = zzb("measurement.upload.initial_upload_delay_time", localObject1, localObject1, zzbl.zza);
    localObject1 = Long.valueOf(1800000L);
    zzA = zzb("measurement.upload.retry_time", localObject1, localObject1, zzbm.zza);
    localObject1 = Integer.valueOf(6);
    zzB = zzb("measurement.upload.retry_count", localObject1, localObject1, zzbn.zza);
    localObject1 = Long.valueOf(2419200000L);
    zzC = zzb("measurement.upload.max_queue_time", localObject1, localObject1, zzbo.zza);
    localObject1 = Integer.valueOf(4);
    zzD = zzb("measurement.lifetimevalue.max_currency_tracked", localObject1, localObject1, zzbp.zza);
    localObject1 = Integer.valueOf(200);
    zzE = zzb("measurement.audience.filter_result_max_count", localObject1, localObject1, zzbr.zza);
    localObject3 = Integer.valueOf(25);
    zzF = zzb("measurement.upload.max_public_user_properties", localObject3, localObject3, null);
    localObject1 = Integer.valueOf(500);
    zzG = zzb("measurement.upload.max_event_name_cardinality", localObject1, localObject1, null);
    zzH = zzb("measurement.upload.max_public_event_params", localObject3, localObject3, null);
    localObject1 = Long.valueOf(5000L);
    zzI = zzb("measurement.service_client.idle_disconnect_millis", localObject1, localObject1, zzbs.zza);
    localObject1 = Boolean.FALSE;
    zzJ = zzb("measurement.test.boolean_flag", localObject1, localObject1, zzbt.zza);
    zzK = zzb("measurement.test.string_flag", "---", "---", zzbu.zza);
    localObject3 = Long.valueOf(-1L);
    zzL = zzb("measurement.test.long_flag", localObject3, localObject3, zzbv.zza);
    localObject3 = Integer.valueOf(-2);
    zzM = zzb("measurement.test.int_flag", localObject3, localObject3, zzbw.zza);
    localObject3 = Double.valueOf(-3.0D);
    zzN = zzb("measurement.test.double_flag", localObject3, localObject3, zzbx.zza);
    localObject3 = Integer.valueOf(50);
    zzO = zzb("measurement.experiment.max_ids", localObject3, localObject3, zzby.zza);
    zzP = zzb("measurement.max_bundles_per_iteration", localInteger1, localInteger1, zzbz.zza);
    zzQ = zzb("measurement.sdk.attribution.cache.ttl", localObject2, localObject2, zzca.zza);
    zzR = zzb("measurement.validation.internal_limits_internal_event_params", localObject1, localObject1, zzcc.zza);
    localObject2 = Boolean.TRUE;
    zzS = zzb("measurement.collection.firebase_global_collection_flag_enabled", localObject2, localObject2, zzcd.zza);
    zzT = zzb("measurement.collection.redundant_engagement_removal_enabled", localObject1, localObject1, zzce.zza);
    zzU = zzb("measurement.collection.log_event_and_bundle_v2", localObject2, localObject2, zzcf.zza);
    zzV = zzb("measurement.quality.checksum", localObject1, localObject1, null);
    zzW = zzb("measurement.sdk.collection.validate_param_names_alphabetical", localObject2, localObject2, zzcg.zza);
    zzX = zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", localObject1, localObject1, zzch.zza);
    zzY = zzb("measurement.audience.refresh_event_count_filters_timestamp", localObject1, localObject1, zzci.zza);
    zzZ = zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", localObject1, localObject1, zzcj.zza);
    zzaa = zzb("measurement.sdk.collection.retrieve_deeplink_from_bow_2", localObject2, localObject2, zzck.zza);
    zzab = zzb("measurement.sdk.collection.last_deep_link_referrer2", localObject2, localObject2, zzcl.zza);
    zzac = zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", localObject1, localObject1, zzcn.zza);
    zzad = zzb("measurement.sdk.collection.last_gclid_from_referrer2", localObject1, localObject1, zzco.zza);
    zzae = zzb("measurement.sdk.collection.enable_extend_user_property_size", localObject2, localObject2, zzcp.zza);
    zzaf = zzb("measurement.upload.file_lock_state_check", localObject2, localObject2, zzcq.zza);
    zzag = zzb("measurement.ga.ga_app_id", localObject1, localObject1, zzcr.zza);
    zzah = zzb("measurement.lifecycle.app_in_background_parameter", localObject1, localObject1, zzcs.zza);
    zzai = zzb("measurement.integration.disable_firebase_instance_id", localObject1, localObject1, zzct.zza);
    zzaj = zzb("measurement.lifecycle.app_backgrounded_engagement", localObject1, localObject1, zzcu.zza);
    zzak = zzb("measurement.collection.service.update_with_analytics_fix", localObject1, localObject1, zzcv.zza);
    zzal = zzb("measurement.service.use_appinfo_modified", localObject2, localObject2, zzcw.zza);
    zzam = zzb("measurement.client.firebase_feature_rollout.v1.enable", localObject2, localObject2, zzcy.zza);
    zzan = zzb("measurement.client.sessions.check_on_reset_and_enable2", localObject2, localObject2, zzcz.zza);
    zzao = zzb("measurement.scheduler.task_thread.cleanup_on_exit", localObject1, localObject1, zzda.zza);
    zzap = zzb("measurement.upload.file_truncate_fix", localObject1, localObject1, zzdb.zza);
    zzaq = zzb("measurement.sdk.screen.disabling_automatic_reporting", localObject2, localObject2, zzdc.zza);
    zzar = zzb("measurement.sdk.screen.manual_screen_view_logging", localObject2, localObject2, zzdd.zza);
    zzas = zzb("measurement.collection.synthetic_data_mitigation", localObject1, localObject1, zzde.zza);
    zzat = zzb("measurement.androidId.delete_feature", localObject2, localObject2, zzdf.zza);
    localInteger1 = Integer.valueOf(203600);
    zzau = zzb("measurement.service.storage_consent_support_version", localInteger1, localInteger1, zzdg.zza);
    zzav = zzb("measurement.upload.directly_maybe_log_error_events", localObject2, localObject2, zzdh.zza);
    zzaw = zzb("measurement.frontend.directly_maybe_log_error_events", localObject1, localObject1, zzdj.zza);
    zzax = zzb("measurement.client.properties.non_null_origin", localObject2, localObject2, zzdk.zza);
    zzay = zzb("measurement.client.click_identifier_control.dev", localObject1, localObject1, zzdl.zza);
    zzaz = zzb("measurement.service.click_identifier_control", localObject1, localObject1, zzdm.zza);
    zzaA = zzb("measurement.client.reject_blank_user_id", localObject2, localObject2, zzdn.zza);
    zzaB = zzb("measurement.config.persist_last_modified", localObject2, localObject2, zzdo.zza);
    zzaC = zzb("measurement.client.consent.suppress_1p_in_ga4f_install", localObject2, localObject2, zzdp.zza);
    zzaD = zzb("measurement.module.pixie.ees", localObject1, localObject1, zzdq.zza);
    zzaE = zzb("measurement.euid.client.dev", localObject1, localObject1, zzdr.zza);
    zzaF = zzb("measurement.euid.service", localObject1, localObject1, zzds.zza);
  }
  
  public static Map<String, String> zza(Context paramContext)
  {
    paramContext = zzha.zza(paramContext.getContentResolver(), zzhk.zza("com.google.android.gms.measurement"));
    if (paramContext == null) {
      paramContext = Collections.emptyMap();
    } else {
      paramContext = paramContext.zzb();
    }
    return paramContext;
  }
  
  @VisibleForTesting
  static <V> zzdz<V> zzb(String paramString, V paramV1, V paramV2, zzdx<V> paramzzdx)
  {
    paramString = new zzdz(paramString, paramV1, paramV2, paramzzdx, null);
    zzaG.add(paramString);
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */