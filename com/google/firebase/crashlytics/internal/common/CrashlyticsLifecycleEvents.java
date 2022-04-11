package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;

abstract interface CrashlyticsLifecycleEvents
{
  public abstract void onBeginSession(@NonNull String paramString, long paramLong);
  
  public abstract void onCustomKey(String paramString1, String paramString2);
  
  public abstract void onLog(long paramLong, String paramString);
  
  public abstract void onUserId(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsLifecycleEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */