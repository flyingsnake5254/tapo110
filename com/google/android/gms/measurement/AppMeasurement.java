package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzfu;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzhw;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzkq;
import com.google.android.gms.measurement.internal.zzku;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
@KeepForSdk
@ShowFirstParty
public class AppMeasurement
{
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final String CRASH_ORIGIN = "crash";
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final String FCM_ORIGIN = "fcm";
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final String FIAM_ORIGIN = "fiam";
  private static volatile AppMeasurement zza;
  private final zzfu zzb;
  private final zzhx zzc;
  
  public AppMeasurement(zzfu paramzzfu)
  {
    Preconditions.checkNotNull(paramzzfu);
    this.zzb = paramzzfu;
    this.zzc = null;
  }
  
  public AppMeasurement(zzhx paramzzhx)
  {
    Preconditions.checkNotNull(paramzzhx);
    this.zzc = paramzzhx;
    this.zzb = null;
  }
  
  @Deprecated
  @Keep
  @NonNull
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  @ShowFirstParty
  public static AppMeasurement getInstance(@NonNull Context paramContext)
  {
    if (zza == null) {
      try
      {
        Object localObject1 = zza;
        if (localObject1 == null)
        {
          Object localObject2;
          try
          {
            localObject1 = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            localObject1 = (zzhx)((Class)localObject1).getDeclaredMethod("getScionFrontendApiImplementation", new Class[] { Context.class, Bundle.class }).invoke(null, new Object[] { paramContext, null });
          }
          catch (ClassNotFoundException|Exception localClassNotFoundException)
          {
            localObject2 = null;
          }
          if (localObject2 != null)
          {
            paramContext = new com/google/android/gms/measurement/AppMeasurement;
            paramContext.<init>((zzhx)localObject2);
            zza = paramContext;
          }
          else
          {
            localObject2 = new com/google/android/gms/internal/measurement/zzcl;
            ((zzcl)localObject2).<init>(0L, 0L, true, null, null, null, null, null);
            paramContext = zzfu.zzC(paramContext, (zzcl)localObject2, null);
            localObject2 = new com/google/android/gms/measurement/AppMeasurement;
            ((AppMeasurement)localObject2).<init>(paramContext);
            zza = (AppMeasurement)localObject2;
          }
        }
      }
      finally {}
    }
    return zza;
  }
  
  @Keep
  public void beginAdUnitExposure(@NonNull @Size(min=1L) String paramString)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzl(paramString);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzB().zza(paramString, this.zzb.zzay().elapsedRealtime());
  }
  
  @Keep
  @KeepForSdk
  @ShowFirstParty
  public void clearConditionalUserProperty(@NonNull @Size(max=24L, min=1L) String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzo(paramString1, paramString2, paramBundle);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzO(paramString1, paramString2, paramBundle);
  }
  
  @Keep
  public void endAdUnitExposure(@NonNull @Size(min=1L) String paramString)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzm(paramString);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzB().zzb(paramString, this.zzb.zzay().elapsedRealtime());
  }
  
  @Keep
  public long generateEventId()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzk();
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzl().zzd();
  }
  
  @Keep
  @NonNull
  public String getAppInstanceId()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzi();
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzD();
  }
  
  @NonNull
  @KeepForSdk
  public Boolean getBoolean()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return (Boolean)localzzhx.zzr(4);
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzi();
  }
  
  @Keep
  @NonNull
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String paramString1, @NonNull @Size(max=23L, min=1L) String paramString2)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      paramString1 = localzzhx.zzp(paramString1, paramString2);
    }
    else
    {
      Preconditions.checkNotNull(this.zzb);
      paramString1 = this.zzb.zzk().zzP(paramString1, paramString2);
    }
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.size();
    }
    paramString2 = new ArrayList(i);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      paramString2.add(new ConditionalUserProperty((Bundle)paramString1.next()));
    }
    return paramString2;
  }
  
  @Keep
  @NonNull
  public String getCurrentScreenClass()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzh();
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzS();
  }
  
  @Keep
  @NonNull
  public String getCurrentScreenName()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzg();
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzR();
  }
  
  @NonNull
  @KeepForSdk
  public Double getDouble()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return (Double)localzzhx.zzr(2);
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzm();
  }
  
  @Keep
  @NonNull
  public String getGmpAppId()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzj();
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzT();
  }
  
  @NonNull
  @KeepForSdk
  public Integer getInteger()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return (Integer)localzzhx.zzr(3);
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzl();
  }
  
  @NonNull
  @KeepForSdk
  public Long getLong()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return (Long)localzzhx.zzr(1);
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzk();
  }
  
  @Keep
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public int getMaxUserProperties(@NonNull @Size(min=1L) String paramString)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzq(paramString);
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzL(paramString);
    return 25;
  }
  
  @NonNull
  @KeepForSdk
  public String getString()
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return (String)localzzhx.zzr(0);
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzj();
  }
  
  @Keep
  @NonNull
  @WorkerThread
  @VisibleForTesting
  protected Map<String, Object> getUserProperties(@NonNull String paramString1, @NonNull @Size(max=24L, min=1L) String paramString2, boolean paramBoolean)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null) {
      return localzzhx.zzc(paramString1, paramString2, paramBoolean);
    }
    Preconditions.checkNotNull(this.zzb);
    return this.zzb.zzk().zzQ(paramString1, paramString2, paramBoolean);
  }
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    Object localObject1 = this.zzc;
    if (localObject1 != null) {
      return ((zzhx)localObject1).zzc(null, null, paramBoolean);
    }
    Preconditions.checkNotNull(this.zzb);
    Object localObject2 = this.zzb.zzk().zzC(paramBoolean);
    localObject1 = new ArrayMap(((List)localObject2).size());
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (zzkq)localIterator.next();
      Object localObject3 = ((zzkq)localObject2).zza();
      if (localObject3 != null) {
        ((Map)localObject1).put(((zzkq)localObject2).zzb, localObject3);
      }
    }
    return (Map<String, Object>)localObject1;
  }
  
  @Keep
  @ShowFirstParty
  public void logEventInternal(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zza(paramString1, paramString2, paramBundle);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzs(paramString1, paramString2, paramBundle);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void logEventInternalNoInterceptor(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle, long paramLong)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzb(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzv(paramString1, paramString2, paramBundle, true, false, paramLong);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void registerOnMeasurementEventListener(@NonNull OnEventListener paramOnEventListener)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zze(paramOnEventListener);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzJ(paramOnEventListener);
  }
  
  @Keep
  @KeepForSdk
  @ShowFirstParty
  public void setConditionalUserProperty(@NonNull ConditionalUserProperty paramConditionalUserProperty)
  {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzn(paramConditionalUserProperty.zza());
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzM(paramConditionalUserProperty.zza());
  }
  
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public void setEventInterceptor(@NonNull EventInterceptor paramEventInterceptor)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzd(paramEventInterceptor);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzI(paramEventInterceptor);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void unregisterOnMeasurementEventListener(@NonNull OnEventListener paramOnEventListener)
  {
    zzhx localzzhx = this.zzc;
    if (localzzhx != null)
    {
      localzzhx.zzf(paramOnEventListener);
      return;
    }
    Preconditions.checkNotNull(this.zzb);
    this.zzb.zzk().zzK(paramOnEventListener);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static class ConditionalUserProperty
  {
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public boolean mActive;
    @Keep
    @NonNull
    @KeepForSdk
    @ShowFirstParty
    public String mAppId;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mCreationTimestamp;
    @Keep
    @NonNull
    public String mExpiredEventName;
    @Keep
    @NonNull
    public Bundle mExpiredEventParams;
    @Keep
    @NonNull
    @KeepForSdk
    @ShowFirstParty
    public String mName;
    @Keep
    @NonNull
    @KeepForSdk
    @ShowFirstParty
    public String mOrigin;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTimeToLive;
    @Keep
    @NonNull
    public String mTimedOutEventName;
    @Keep
    @NonNull
    public Bundle mTimedOutEventParams;
    @Keep
    @NonNull
    @KeepForSdk
    @ShowFirstParty
    public String mTriggerEventName;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggerTimeout;
    @Keep
    @NonNull
    public String mTriggeredEventName;
    @Keep
    @NonNull
    public Bundle mTriggeredEventParams;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggeredTimestamp;
    @Keep
    @NonNull
    @KeepForSdk
    @ShowFirstParty
    public Object mValue;
    
    @KeepForSdk
    public ConditionalUserProperty() {}
    
    @VisibleForTesting
    ConditionalUserProperty(@NonNull Bundle paramBundle)
    {
      Preconditions.checkNotNull(paramBundle);
      this.mAppId = ((String)zzgq.zzb(paramBundle, "app_id", String.class, null));
      this.mOrigin = ((String)zzgq.zzb(paramBundle, "origin", String.class, null));
      this.mName = ((String)zzgq.zzb(paramBundle, "name", String.class, null));
      this.mValue = zzgq.zzb(paramBundle, "value", Object.class, null);
      this.mTriggerEventName = ((String)zzgq.zzb(paramBundle, "trigger_event_name", String.class, null));
      Long localLong = Long.valueOf(0L);
      this.mTriggerTimeout = ((Long)zzgq.zzb(paramBundle, "trigger_timeout", Long.class, localLong)).longValue();
      this.mTimedOutEventName = ((String)zzgq.zzb(paramBundle, "timed_out_event_name", String.class, null));
      this.mTimedOutEventParams = ((Bundle)zzgq.zzb(paramBundle, "timed_out_event_params", Bundle.class, null));
      this.mTriggeredEventName = ((String)zzgq.zzb(paramBundle, "triggered_event_name", String.class, null));
      this.mTriggeredEventParams = ((Bundle)zzgq.zzb(paramBundle, "triggered_event_params", Bundle.class, null));
      this.mTimeToLive = ((Long)zzgq.zzb(paramBundle, "time_to_live", Long.class, localLong)).longValue();
      this.mExpiredEventName = ((String)zzgq.zzb(paramBundle, "expired_event_name", String.class, null));
      this.mExpiredEventParams = ((Bundle)zzgq.zzb(paramBundle, "expired_event_params", Bundle.class, null));
      this.mActive = ((Boolean)zzgq.zzb(paramBundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
      this.mCreationTimestamp = ((Long)zzgq.zzb(paramBundle, "creation_timestamp", Long.class, localLong)).longValue();
      this.mTriggeredTimestamp = ((Long)zzgq.zzb(paramBundle, "triggered_timestamp", Long.class, localLong)).longValue();
    }
    
    @KeepForSdk
    public ConditionalUserProperty(@NonNull ConditionalUserProperty paramConditionalUserProperty)
    {
      Preconditions.checkNotNull(paramConditionalUserProperty);
      this.mAppId = paramConditionalUserProperty.mAppId;
      this.mOrigin = paramConditionalUserProperty.mOrigin;
      this.mCreationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
      this.mName = paramConditionalUserProperty.mName;
      Object localObject = paramConditionalUserProperty.mValue;
      if (localObject != null)
      {
        localObject = zzic.zzb(localObject);
        this.mValue = localObject;
        if (localObject == null) {
          this.mValue = paramConditionalUserProperty.mValue;
        }
      }
      this.mActive = paramConditionalUserProperty.mActive;
      this.mTriggerEventName = paramConditionalUserProperty.mTriggerEventName;
      this.mTriggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
      this.mTimedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
      localObject = paramConditionalUserProperty.mTimedOutEventParams;
      if (localObject != null) {
        this.mTimedOutEventParams = new Bundle((Bundle)localObject);
      }
      this.mTriggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
      localObject = paramConditionalUserProperty.mTriggeredEventParams;
      if (localObject != null) {
        this.mTriggeredEventParams = new Bundle((Bundle)localObject);
      }
      this.mTriggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
      this.mTimeToLive = paramConditionalUserProperty.mTimeToLive;
      this.mExpiredEventName = paramConditionalUserProperty.mExpiredEventName;
      paramConditionalUserProperty = paramConditionalUserProperty.mExpiredEventParams;
      if (paramConditionalUserProperty != null) {
        this.mExpiredEventParams = new Bundle(paramConditionalUserProperty);
      }
    }
    
    @VisibleForTesting
    final Bundle zza()
    {
      Bundle localBundle = new Bundle();
      Object localObject = this.mAppId;
      if (localObject != null) {
        localBundle.putString("app_id", (String)localObject);
      }
      localObject = this.mOrigin;
      if (localObject != null) {
        localBundle.putString("origin", (String)localObject);
      }
      localObject = this.mName;
      if (localObject != null) {
        localBundle.putString("name", (String)localObject);
      }
      localObject = this.mValue;
      if (localObject != null) {
        zzgq.zza(localBundle, localObject);
      }
      localObject = this.mTriggerEventName;
      if (localObject != null) {
        localBundle.putString("trigger_event_name", (String)localObject);
      }
      localBundle.putLong("trigger_timeout", this.mTriggerTimeout);
      localObject = this.mTimedOutEventName;
      if (localObject != null) {
        localBundle.putString("timed_out_event_name", (String)localObject);
      }
      localObject = this.mTimedOutEventParams;
      if (localObject != null) {
        localBundle.putBundle("timed_out_event_params", (Bundle)localObject);
      }
      localObject = this.mTriggeredEventName;
      if (localObject != null) {
        localBundle.putString("triggered_event_name", (String)localObject);
      }
      localObject = this.mTriggeredEventParams;
      if (localObject != null) {
        localBundle.putBundle("triggered_event_params", (Bundle)localObject);
      }
      localBundle.putLong("time_to_live", this.mTimeToLive);
      localObject = this.mExpiredEventName;
      if (localObject != null) {
        localBundle.putString("expired_event_name", (String)localObject);
      }
      localObject = this.mExpiredEventParams;
      if (localObject != null) {
        localBundle.putBundle("expired_event_params", (Bundle)localObject);
      }
      localBundle.putLong("creation_timestamp", this.mCreationTimestamp);
      localBundle.putBoolean("active", this.mActive);
      localBundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
      return localBundle;
    }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\AppMeasurement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */