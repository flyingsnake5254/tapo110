package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

public final class zzg
  implements zza
{
  private final AnalyticsConnector.AnalyticsConnectorListener zza;
  private final AppMeasurementSdk zzb;
  private final zzf zzc;
  
  public zzg(AppMeasurementSdk paramAppMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener)
  {
    this.zza = paramAnalyticsConnectorListener;
    this.zzb = paramAppMeasurementSdk;
    paramAnalyticsConnectorListener = new zzf(this);
    this.zzc = paramAnalyticsConnectorListener;
    paramAppMeasurementSdk.registerOnMeasurementEventListener(paramAnalyticsConnectorListener);
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zza()
  {
    return this.zza;
  }
  
  public final void zzb(Set<String> paramSet) {}
  
  public final void zzc() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */