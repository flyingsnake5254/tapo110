package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.annotations.DeferredApi;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface AnalyticsConnector
{
  @KeepForSdk
  public abstract void clearConditionalUserProperty(@NonNull @Size(max=24L, min=1L) String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle);
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public abstract List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String paramString1, @Nullable @Size(max=23L, min=1L) String paramString2);
  
  @WorkerThread
  @KeepForSdk
  public abstract int getMaxUserProperties(@NonNull @Size(min=1L) String paramString);
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public abstract Map<String, Object> getUserProperties(boolean paramBoolean);
  
  @KeepForSdk
  public abstract void logEvent(@NonNull String paramString1, @NonNull String paramString2, @Nullable Bundle paramBundle);
  
  @Nullable
  @KeepForSdk
  @DeferredApi
  public abstract AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String paramString, @NonNull AnalyticsConnectorListener paramAnalyticsConnectorListener);
  
  @KeepForSdk
  public abstract void setConditionalUserProperty(@NonNull ConditionalUserProperty paramConditionalUserProperty);
  
  @KeepForSdk
  public abstract void setUserProperty(@NonNull String paramString1, @NonNull String paramString2, @NonNull Object paramObject);
  
  @KeepForSdk
  public static abstract interface AnalyticsConnectorHandle
  {
    @KeepForSdk
    public abstract void registerEventNames(@NonNull Set<String> paramSet);
    
    @KeepForSdk
    public abstract void unregister();
    
    @KeepForSdk
    public abstract void unregisterEventNames();
  }
  
  @KeepForSdk
  public static abstract interface AnalyticsConnectorListener
  {
    @KeepForSdk
    public abstract void onMessageTriggered(int paramInt, @Nullable Bundle paramBundle);
  }
  
  @KeepForSdk
  public static class ConditionalUserProperty
  {
    @KeepForSdk
    public boolean active;
    @KeepForSdk
    public long creationTimestamp;
    @Nullable
    @KeepForSdk
    public String expiredEventName;
    @Nullable
    @KeepForSdk
    public Bundle expiredEventParams;
    @NonNull
    @KeepForSdk
    public String name;
    @NonNull
    @KeepForSdk
    public String origin;
    @KeepForSdk
    public long timeToLive;
    @Nullable
    @KeepForSdk
    public String timedOutEventName;
    @Nullable
    @KeepForSdk
    public Bundle timedOutEventParams;
    @Nullable
    @KeepForSdk
    public String triggerEventName;
    @KeepForSdk
    public long triggerTimeout;
    @Nullable
    @KeepForSdk
    public String triggeredEventName;
    @Nullable
    @KeepForSdk
    public Bundle triggeredEventParams;
    @KeepForSdk
    public long triggeredTimestamp;
    @Nullable
    @KeepForSdk
    public Object value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\AnalyticsConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */