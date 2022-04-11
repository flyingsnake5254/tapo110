package com.google.firebase.crashlytics.internal.settings.model;

public abstract interface Settings
{
  public abstract int getCacheDuration();
  
  public abstract long getExpiresAtMillis();
  
  public abstract FeaturesSettingsData getFeaturesData();
  
  public abstract SessionSettingsData getSessionData();
  
  public abstract int getSettingsVersion();
  
  public abstract boolean isExpired(long paramLong);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\model\Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */