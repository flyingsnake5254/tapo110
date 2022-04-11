package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;

public abstract interface SettingsDataProvider
{
  public abstract Task<AppSettingsData> getAppSettings();
  
  public abstract Settings getSettings();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */