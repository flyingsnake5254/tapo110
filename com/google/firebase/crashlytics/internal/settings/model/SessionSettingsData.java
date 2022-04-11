package com.google.firebase.crashlytics.internal.settings.model;

public class SessionSettingsData
{
  public final int maxCompleteSessionsCount;
  public final int maxCustomExceptionEvents;
  
  public SessionSettingsData(int paramInt1, int paramInt2)
  {
    this.maxCustomExceptionEvents = paramInt1;
    this.maxCompleteSessionsCount = paramInt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\model\SessionSettingsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */