package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zze
  implements zza
{
  final Set<String> zza;
  private final AnalyticsConnector.AnalyticsConnectorListener zzb;
  private final AppMeasurementSdk zzc;
  private final zzd zzd;
  
  public zze(AppMeasurementSdk paramAppMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener)
  {
    this.zzb = paramAnalyticsConnectorListener;
    this.zzc = paramAppMeasurementSdk;
    paramAnalyticsConnectorListener = new zzd(this);
    this.zzd = paramAnalyticsConnectorListener;
    paramAppMeasurementSdk.registerOnMeasurementEventListener(paramAnalyticsConnectorListener);
    this.zza = new HashSet();
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zza()
  {
    return this.zzb;
  }
  
  public final void zzb(Set<String> paramSet)
  {
    this.zza.clear();
    Set localSet = this.zza;
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (localHashSet.size() >= 50) {
        break;
      }
      if ((zzc.zzj(str)) && (zzc.zzi(str)))
      {
        str = zzc.zzl(str);
        Preconditions.checkNotNull(str);
        localHashSet.add(str);
      }
    }
    localSet.addAll(localHashSet);
  }
  
  public final void zzc()
  {
    this.zza.clear();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */