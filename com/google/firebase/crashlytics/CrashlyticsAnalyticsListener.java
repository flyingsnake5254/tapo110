package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

class CrashlyticsAnalyticsListener
  implements AnalyticsConnector.AnalyticsConnectorListener
{
  static final String CRASHLYTICS_ORIGIN = "clx";
  static final String EVENT_NAME_KEY = "name";
  static final String EVENT_ORIGIN_KEY = "_o";
  static final String EVENT_PARAMS_KEY = "params";
  private AnalyticsEventReceiver breadcrumbEventReceiver;
  private AnalyticsEventReceiver crashlyticsOriginEventReceiver;
  
  private static void notifyEventReceiver(@Nullable AnalyticsEventReceiver paramAnalyticsEventReceiver, @NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramAnalyticsEventReceiver == null) {
      return;
    }
    paramAnalyticsEventReceiver.onEvent(paramString, paramBundle);
  }
  
  private void notifyEventReceivers(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    AnalyticsEventReceiver localAnalyticsEventReceiver;
    if ("clx".equals(paramBundle.getString("_o"))) {
      localAnalyticsEventReceiver = this.crashlyticsOriginEventReceiver;
    } else {
      localAnalyticsEventReceiver = this.breadcrumbEventReceiver;
    }
    notifyEventReceiver(localAnalyticsEventReceiver, paramString, paramBundle);
  }
  
  public void onMessageTriggered(int paramInt, @Nullable Bundle paramBundle)
  {
    Logger.getLogger().v(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", new Object[] { Integer.valueOf(paramInt), paramBundle }));
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("name");
    if (str != null)
    {
      Bundle localBundle = paramBundle.getBundle("params");
      paramBundle = localBundle;
      if (localBundle == null) {
        paramBundle = new Bundle();
      }
      notifyEventReceivers(str, paramBundle);
    }
  }
  
  public void setBreadcrumbEventReceiver(@Nullable AnalyticsEventReceiver paramAnalyticsEventReceiver)
  {
    this.breadcrumbEventReceiver = paramAnalyticsEventReceiver;
  }
  
  public void setCrashlyticsOriginEventReceiver(@Nullable AnalyticsEventReceiver paramAnalyticsEventReceiver)
  {
    this.crashlyticsOriginEventReceiver = paramAnalyticsEventReceiver;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\CrashlyticsAnalyticsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */