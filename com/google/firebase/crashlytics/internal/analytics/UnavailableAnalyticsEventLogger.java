package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;

public class UnavailableAnalyticsEventLogger
  implements AnalyticsEventLogger
{
  public void logEvent(@NonNull String paramString, @Nullable Bundle paramBundle)
  {
    Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\analytics\UnavailableAnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */