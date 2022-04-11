package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import java.util.List;
import java.util.Map;

@KeepForSdk
@ShowFirstParty
public class AppMeasurementSdk
{
  private final zzee zza;
  
  public AppMeasurementSdk(zzee paramzzee)
  {
    this.zza = paramzzee;
  }
  
  @NonNull
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  @ShowFirstParty
  public static AppMeasurementSdk getInstance(@NonNull Context paramContext)
  {
    return zzee.zza(paramContext, null, null, null, null).zzb();
  }
  
  @NonNull
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  public static AppMeasurementSdk getInstance(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, @NonNull Bundle paramBundle)
  {
    return zzee.zza(paramContext, paramString1, paramString2, paramString3, paramBundle).zzb();
  }
  
  @KeepForSdk
  public void beginAdUnitExposure(@NonNull @Size(min=1L) String paramString)
  {
    this.zza.zzu(paramString);
  }
  
  @KeepForSdk
  public void clearConditionalUserProperty(@NonNull @Size(max=24L, min=1L) String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    this.zza.zzl(paramString1, paramString2, paramBundle);
  }
  
  @KeepForSdk
  public void endAdUnitExposure(@NonNull @Size(min=1L) String paramString)
  {
    this.zza.zzv(paramString);
  }
  
  @KeepForSdk
  public long generateEventId()
  {
    return this.zza.zzy();
  }
  
  @Nullable
  @KeepForSdk
  public String getAppIdOrigin()
  {
    return this.zza.zzG();
  }
  
  @Nullable
  @KeepForSdk
  public String getAppInstanceId()
  {
    return this.zza.zzx();
  }
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public List<Bundle> getConditionalUserProperties(@Nullable String paramString1, @Nullable @Size(max=23L, min=1L) String paramString2)
  {
    return this.zza.zzm(paramString1, paramString2);
  }
  
  @Nullable
  @KeepForSdk
  public String getCurrentScreenClass()
  {
    return this.zza.zzA();
  }
  
  @Nullable
  @KeepForSdk
  public String getCurrentScreenName()
  {
    return this.zza.zzz();
  }
  
  @Nullable
  @KeepForSdk
  public String getGmpAppId()
  {
    return this.zza.zzw();
  }
  
  @WorkerThread
  @KeepForSdk
  public int getMaxUserProperties(@NonNull @Size(min=1L) String paramString)
  {
    return this.zza.zzE(paramString);
  }
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public Map<String, Object> getUserProperties(@Nullable String paramString1, @Nullable @Size(max=24L, min=1L) String paramString2, boolean paramBoolean)
  {
    return this.zza.zzB(paramString1, paramString2, paramBoolean);
  }
  
  @KeepForSdk
  public void logEvent(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle)
  {
    this.zza.zzh(paramString1, paramString2, paramBundle);
  }
  
  @KeepForSdk
  public void logEventNoInterceptor(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle, long paramLong)
  {
    this.zza.zzi(paramString1, paramString2, paramBundle, paramLong);
  }
  
  @Nullable
  @KeepForSdk
  public void performAction(@NonNull Bundle paramBundle)
  {
    this.zza.zzD(paramBundle, false);
  }
  
  @Nullable
  @KeepForSdk
  public Bundle performActionWithResponse(@NonNull Bundle paramBundle)
  {
    return this.zza.zzD(paramBundle, true);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void registerOnMeasurementEventListener(@NonNull OnEventListener paramOnEventListener)
  {
    this.zza.zze(paramOnEventListener);
  }
  
  @KeepForSdk
  public void setConditionalUserProperty(@NonNull Bundle paramBundle)
  {
    this.zza.zzk(paramBundle);
  }
  
  @KeepForSdk
  public void setConsent(@NonNull Bundle paramBundle)
  {
    this.zza.zzq(paramBundle);
  }
  
  @KeepForSdk
  public void setCurrentScreen(@NonNull Activity paramActivity, @Nullable @Size(max=36L, min=1L) String paramString1, @Nullable @Size(max=36L, min=1L) String paramString2)
  {
    this.zza.zzo(paramActivity, paramString1, paramString2);
  }
  
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public void setEventInterceptor(@NonNull EventInterceptor paramEventInterceptor)
  {
    this.zza.zzd(paramEventInterceptor);
  }
  
  @KeepForSdk
  public void setMeasurementEnabled(@Nullable Boolean paramBoolean)
  {
    this.zza.zzp(paramBoolean);
  }
  
  @KeepForSdk
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    this.zza.zzp(Boolean.valueOf(paramBoolean));
  }
  
  @KeepForSdk
  public void setUserProperty(@NonNull String paramString1, @NonNull String paramString2, @NonNull Object paramObject)
  {
    this.zza.zzj(paramString1, paramString2, paramObject, true);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void unregisterOnMeasurementEventListener(@NonNull OnEventListener paramOnEventListener)
  {
    this.zza.zzf(paramOnEventListener);
  }
  
  public final void zza(boolean paramBoolean)
  {
    this.zza.zzI(paramBoolean);
  }
  
  @KeepForSdk
  public static final class ConditionalUserProperty
  {
    @NonNull
    @KeepForSdk
    public static final String ACTIVE = "active";
    @NonNull
    @KeepForSdk
    public static final String CREATION_TIMESTAMP = "creation_timestamp";
    @NonNull
    @KeepForSdk
    public static final String EXPIRED_EVENT_NAME = "expired_event_name";
    @NonNull
    @KeepForSdk
    public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
    @NonNull
    @KeepForSdk
    public static final String NAME = "name";
    @NonNull
    @KeepForSdk
    public static final String ORIGIN = "origin";
    @NonNull
    @KeepForSdk
    public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
    @NonNull
    @KeepForSdk
    public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
    @NonNull
    @KeepForSdk
    public static final String TIME_TO_LIVE = "time_to_live";
    @NonNull
    @KeepForSdk
    public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
    @NonNull
    @KeepForSdk
    public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
    @NonNull
    @KeepForSdk
    public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
    @NonNull
    @KeepForSdk
    public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
    @NonNull
    @KeepForSdk
    public static final String TRIGGER_TIMEOUT = "trigger_timeout";
    @NonNull
    @KeepForSdk
    public static final String VALUE = "value";
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static abstract interface EventInterceptor
    extends zzgu
  {
    @WorkerThread
    @KeepForSdk
    @ShowFirstParty
    public abstract void interceptEvent(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static abstract interface OnEventListener
    extends zzgv
  {
    @WorkerThread
    @KeepForSdk
    @ShowFirstParty
    public abstract void onEvent(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle, long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\api\AppMeasurementSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */