package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;

public abstract interface AnalyticsEventReceiver
{
  public abstract void onEvent(@NonNull String paramString, @NonNull Bundle paramBundle);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\analytics\AnalyticsEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */