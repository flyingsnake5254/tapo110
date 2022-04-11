package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

abstract interface SettingsJsonTransform
{
  public abstract SettingsData buildFromJson(CurrentTimeProvider paramCurrentTimeProvider, JSONObject paramJSONObject)
    throws JSONException;
  
  public abstract JSONObject toJson(SettingsData paramSettingsData)
    throws JSONException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsJsonTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */