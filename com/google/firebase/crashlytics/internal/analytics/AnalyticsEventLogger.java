package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface AnalyticsEventLogger
{
  public abstract void logEvent(@NonNull String paramString, @Nullable Bundle paramBundle);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\analytics\AnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */