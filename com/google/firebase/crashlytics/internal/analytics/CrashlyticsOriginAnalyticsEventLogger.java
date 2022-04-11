package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class CrashlyticsOriginAnalyticsEventLogger
  implements AnalyticsEventLogger
{
  static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
  @NonNull
  private final AnalyticsConnector analyticsConnector;
  
  public CrashlyticsOriginAnalyticsEventLogger(@NonNull AnalyticsConnector paramAnalyticsConnector)
  {
    this.analyticsConnector = paramAnalyticsConnector;
  }
  
  public void logEvent(@NonNull String paramString, @Nullable Bundle paramBundle)
  {
    this.analyticsConnector.logEvent("clx", paramString, paramBundle);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\analytics\CrashlyticsOriginAnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */