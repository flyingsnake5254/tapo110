package com.google.firebase.crashlytics.internal.common;

public class SystemCurrentTimeProvider
  implements CurrentTimeProvider
{
  public long getCurrentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\SystemCurrentTimeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */