package com.google.firebase.crashlytics.internal.settings.model;

public class SettingsData
  implements Settings
{
  public final AppSettingsData appData;
  public final int cacheDuration;
  public final long expiresAtMillis;
  public final FeaturesSettingsData featuresData;
  public final SessionSettingsData sessionData;
  public final int settingsVersion;
  
  public SettingsData(long paramLong, AppSettingsData paramAppSettingsData, SessionSettingsData paramSessionSettingsData, FeaturesSettingsData paramFeaturesSettingsData, int paramInt1, int paramInt2)
  {
    this.expiresAtMillis = paramLong;
    this.appData = paramAppSettingsData;
    this.sessionData = paramSessionSettingsData;
    this.featuresData = paramFeaturesSettingsData;
    this.settingsVersion = paramInt1;
    this.cacheDuration = paramInt2;
  }
  
  public AppSettingsData getAppSettingsData()
  {
    return this.appData;
  }
  
  public int getCacheDuration()
  {
    return this.cacheDuration;
  }
  
  public long getExpiresAtMillis()
  {
    return this.expiresAtMillis;
  }
  
  public FeaturesSettingsData getFeaturesData()
  {
    return this.featuresData;
  }
  
  public SessionSettingsData getSessionData()
  {
    return this.sessionData;
  }
  
  public int getSettingsVersion()
  {
    return this.settingsVersion;
  }
  
  public boolean isExpired(long paramLong)
  {
    boolean bool;
    if (this.expiresAtMillis < paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\model\SettingsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */