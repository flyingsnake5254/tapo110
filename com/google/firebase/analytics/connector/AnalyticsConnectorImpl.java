package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl
  implements AnalyticsConnector
{
  private static volatile AnalyticsConnector zzc;
  @VisibleForTesting
  final AppMeasurementSdk zza;
  @VisibleForTesting
  final Map<String, com.google.firebase.analytics.connector.internal.zza> zzb;
  
  AnalyticsConnectorImpl(AppMeasurementSdk paramAppMeasurementSdk)
  {
    Preconditions.checkNotNull(paramAppMeasurementSdk);
    this.zza = paramAppMeasurementSdk;
    this.zzb = new ConcurrentHashMap();
  }
  
  @NonNull
  @KeepForSdk
  public static AnalyticsConnector getInstance()
  {
    return getInstance(FirebaseApp.getInstance());
  }
  
  @NonNull
  @KeepForSdk
  public static AnalyticsConnector getInstance(@NonNull FirebaseApp paramFirebaseApp)
  {
    return (AnalyticsConnector)paramFirebaseApp.get(AnalyticsConnector.class);
  }
  
  @NonNull
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  public static AnalyticsConnector getInstance(@NonNull FirebaseApp paramFirebaseApp, @NonNull Context paramContext, @NonNull Subscriber paramSubscriber)
  {
    Preconditions.checkNotNull(paramFirebaseApp);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramSubscriber);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (zzc == null) {
      try
      {
        if (zzc == null)
        {
          Bundle localBundle = new android/os/Bundle;
          localBundle.<init>(1);
          if (paramFirebaseApp.isDefaultApp())
          {
            paramSubscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
            localBundle.putBoolean("dataCollectionDefaultEnabled", paramFirebaseApp.isDataCollectionDefaultEnabled());
          }
          paramFirebaseApp = new com/google/firebase/analytics/connector/AnalyticsConnectorImpl;
          paramFirebaseApp.<init>(zzee.zza(paramContext, null, null, null, localBundle).zzb());
          zzc = paramFirebaseApp;
        }
      }
      finally {}
    }
    return zzc;
  }
  
  private final boolean zzc(@NonNull String paramString)
  {
    return (!paramString.isEmpty()) && (this.zzb.containsKey(paramString)) && (this.zzb.get(paramString) != null);
  }
  
  @KeepForSdk
  public void clearConditionalUserProperty(@NonNull @Size(max=24L, min=1L) String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle)
  {
    if ((paramString2 != null) && (!zzc.zzb(paramString2, paramBundle))) {
      return;
    }
    this.zza.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String paramString1, @NonNull @Size(max=23L, min=1L) String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = this.zza.getConditionalUserProperties(paramString1, paramString2).iterator();
    while (paramString1.hasNext()) {
      localArrayList.add(zzc.zzh((Bundle)paramString1.next()));
    }
    return localArrayList;
  }
  
  @WorkerThread
  @KeepForSdk
  public int getMaxUserProperties(@NonNull @Size(min=1L) String paramString)
  {
    return this.zza.getMaxUserProperties(paramString);
  }
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    return this.zza.getUserProperties(null, null, paramBoolean);
  }
  
  @KeepForSdk
  public void logEvent(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (!zzc.zza(paramString1)) {
      return;
    }
    if (!zzc.zzb(paramString2, localBundle)) {
      return;
    }
    if (!zzc.zzf(paramString1, paramString2, localBundle)) {
      return;
    }
    zzc.zzm(paramString1, paramString2, localBundle);
    this.zza.logEvent(paramString1, paramString2, localBundle);
  }
  
  @NonNull
  @WorkerThread
  @KeepForSdk
  public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull final String paramString, @NonNull AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener)
  {
    Preconditions.checkNotNull(paramAnalyticsConnectorListener);
    if (!zzc.zza(paramString)) {
      return null;
    }
    if (zzc(paramString)) {
      return null;
    }
    AppMeasurementSdk localAppMeasurementSdk = this.zza;
    if ("fiam".equals(paramString)) {
      paramAnalyticsConnectorListener = new zze(localAppMeasurementSdk, paramAnalyticsConnectorListener);
    } else if ((!"crash".equals(paramString)) && (!"clx".equals(paramString))) {
      paramAnalyticsConnectorListener = null;
    } else {
      paramAnalyticsConnectorListener = new zzg(localAppMeasurementSdk, paramAnalyticsConnectorListener);
    }
    if (paramAnalyticsConnectorListener != null)
    {
      this.zzb.put(paramString, paramAnalyticsConnectorListener);
      new AnalyticsConnector.AnalyticsConnectorHandle()
      {
        @KeepForSdk
        public void registerEventNames(Set<String> paramAnonymousSet)
        {
          if ((AnalyticsConnectorImpl.zzb(AnalyticsConnectorImpl.this, paramString)) && (paramString.equals("fiam")) && (paramAnonymousSet != null) && (!paramAnonymousSet.isEmpty())) {
            ((com.google.firebase.analytics.connector.internal.zza)AnalyticsConnectorImpl.this.zzb.get(paramString)).zzb(paramAnonymousSet);
          }
        }
        
        public final void unregister()
        {
          if (!AnalyticsConnectorImpl.zzb(AnalyticsConnectorImpl.this, paramString)) {
            return;
          }
          AnalyticsConnector.AnalyticsConnectorListener localAnalyticsConnectorListener = ((com.google.firebase.analytics.connector.internal.zza)AnalyticsConnectorImpl.this.zzb.get(paramString)).zza();
          if (localAnalyticsConnectorListener != null) {
            localAnalyticsConnectorListener.onMessageTriggered(0, null);
          }
          AnalyticsConnectorImpl.this.zzb.remove(paramString);
        }
        
        @KeepForSdk
        public void unregisterEventNames()
        {
          if ((AnalyticsConnectorImpl.zzb(AnalyticsConnectorImpl.this, paramString)) && (paramString.equals("fiam"))) {
            ((com.google.firebase.analytics.connector.internal.zza)AnalyticsConnectorImpl.this.zzb.get(paramString)).zzc();
          }
        }
      };
    }
    return null;
  }
  
  @KeepForSdk
  public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty)
  {
    if (!zzc.zze(paramConditionalUserProperty)) {
      return;
    }
    this.zza.setConditionalUserProperty(zzc.zzg(paramConditionalUserProperty));
  }
  
  @KeepForSdk
  public void setUserProperty(@NonNull String paramString1, @NonNull String paramString2, @NonNull Object paramObject)
  {
    if (!zzc.zza(paramString1)) {
      return;
    }
    if (!zzc.zzd(paramString1, paramString2)) {
      return;
    }
    this.zza.setUserProperty(paramString1, paramString2, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\AnalyticsConnectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */