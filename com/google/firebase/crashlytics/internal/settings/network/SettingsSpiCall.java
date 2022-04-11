package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import org.json.JSONObject;

public abstract interface SettingsSpiCall
{
  public abstract JSONObject invoke(SettingsRequest paramSettingsRequest, boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\network\SettingsSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */