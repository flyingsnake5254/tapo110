package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull.List;

final class zzfb
  extends zzgo
{
  @VisibleForTesting
  static final Pair<String, Long> zza = new Pair("", Long.valueOf(0L));
  public zzez zzb;
  public final zzey zzc = new zzey(this, "first_open_time", 0L);
  public final zzey zzd = new zzey(this, "app_install_time", 0L);
  public final zzfa zze = new zzfa(this, "app_instance_id", null);
  public final zzey zzf = new zzey(this, "session_timeout", 1800000L);
  public final zzew zzg = new zzew(this, "start_new_session", true);
  public final zzfa zzh = new zzfa(this, "non_personalized_ads", null);
  public final zzew zzi = new zzew(this, "allow_remote_dynamite", false);
  public final zzey zzj = new zzey(this, "last_pause_time", 0L);
  public boolean zzk;
  public final zzew zzl = new zzew(this, "app_backgrounded", false);
  public final zzew zzm = new zzew(this, "deep_link_retrieval_complete", false);
  public final zzey zzn = new zzey(this, "deep_link_retrieval_attempts", 0L);
  public final zzfa zzo = new zzfa(this, "firebase_feature_rollouts", null);
  public final zzfa zzp = new zzfa(this, "deferred_attribution_cache", null);
  public final zzey zzq = new zzey(this, "deferred_attribution_cache_timestamp", 0L);
  public final zzex zzr = new zzex(this, "default_event_parameters", null);
  private SharedPreferences zzt;
  private String zzu;
  private boolean zzv;
  private long zzw;
  
  zzfb(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  protected final boolean zza()
  {
    return true;
  }
  
  @EnsuresNonNull.List({@org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.preferences"}), @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.monitoringSample"})})
  @WorkerThread
  protected final void zzaz()
  {
    Object localObject = this.zzs.zzax().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    this.zzt = ((SharedPreferences)localObject);
    boolean bool = ((SharedPreferences)localObject).getBoolean("has_been_opened", false);
    this.zzk = bool;
    if (!bool)
    {
      localObject = this.zzt.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("has_been_opened", true);
      ((SharedPreferences.Editor)localObject).apply();
    }
    this.zzs.zzc();
    this.zzb = new zzez(this, "health_monitor", Math.max(0L, ((Long)zzea.zzb.zzb(null)).longValue()), null);
  }
  
  @WorkerThread
  final Pair<String, Boolean> zzb(String paramString)
  {
    zzg();
    long l = this.zzs.zzay().elapsedRealtime();
    String str = this.zzu;
    if ((str != null) && (l < this.zzw)) {
      return new Pair(str, Boolean.valueOf(this.zzv));
    }
    this.zzw = (l + this.zzs.zzc().zzj(paramString, zzea.zza));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzax());
      this.zzu = "";
      str = paramString.getId();
      if (str != null) {
        this.zzu = str;
      }
      this.zzv = paramString.isLimitAdTrackingEnabled();
    }
    catch (Exception paramString)
    {
      this.zzs.zzau().zzj().zzb("Unable to get advertising id", paramString);
      this.zzu = "";
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(this.zzu, Boolean.valueOf(this.zzv));
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final SharedPreferences zzd()
  {
    zzg();
    zzv();
    Preconditions.checkNotNull(this.zzt);
    return this.zzt;
  }
  
  @WorkerThread
  final void zze(Boolean paramBoolean)
  {
    zzg();
    SharedPreferences.Editor localEditor = zzd().edit();
    if (paramBoolean != null) {
      localEditor.putBoolean("measurement_enabled", paramBoolean.booleanValue());
    } else {
      localEditor.remove("measurement_enabled");
    }
    localEditor.apply();
  }
  
  @WorkerThread
  final Boolean zzf()
  {
    zzg();
    if (zzd().contains("measurement_enabled")) {
      return Boolean.valueOf(zzd().getBoolean("measurement_enabled", true));
    }
    return null;
  }
  
  @WorkerThread
  final boolean zzh(int paramInt)
  {
    return zzaf.zzm(paramInt, zzd().getInt("consent_source", 100));
  }
  
  @WorkerThread
  final zzaf zzi()
  {
    zzg();
    return zzaf.zzc(zzd().getString("consent_settings", "G1"));
  }
  
  @WorkerThread
  final void zzj(boolean paramBoolean)
  {
    zzg();
    this.zzs.zzau().zzk().zzb("App measurement setting deferred collection", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzd().edit();
    localEditor.putBoolean("deferred_analytics_collection", paramBoolean);
    localEditor.apply();
  }
  
  @WorkerThread
  final boolean zzk()
  {
    SharedPreferences localSharedPreferences = this.zzt;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.contains("deferred_analytics_collection");
  }
  
  final boolean zzl(long paramLong)
  {
    return paramLong - this.zzf.zza() > this.zzj.zza();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */