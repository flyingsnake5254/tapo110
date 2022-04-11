package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

final class zzd
  implements AppMeasurementSdk.OnEventListener
{
  public zzd(zze paramzze) {}
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    if (!this.zza.zza.contains(paramString2)) {
      return;
    }
    paramString1 = new Bundle();
    paramString1.putString("events", zzc.zzk(paramString2));
    zze.zzd(this.zza).onMessageTriggered(2, paramString1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */