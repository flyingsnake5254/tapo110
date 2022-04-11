package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;

final class zzf
  implements AppMeasurementSdk.OnEventListener
{
  public zzf(zzg paramzzg) {}
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    if ((paramString1 != null) && (!paramString1.equals("crash")) && (zzc.zzc(paramString2)))
    {
      paramString1 = new Bundle();
      paramString1.putString("name", paramString2);
      paramString1.putLong("timestampInMillis", paramLong);
      paramString1.putBundle("params", paramBundle);
      zzg.zzd(this.zza).onMessageTriggered(3, paramString1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */