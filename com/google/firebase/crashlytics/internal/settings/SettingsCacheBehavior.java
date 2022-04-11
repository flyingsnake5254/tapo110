package com.google.firebase.crashlytics.internal.settings;

public enum SettingsCacheBehavior
{
  static
  {
    SettingsCacheBehavior localSettingsCacheBehavior1 = new SettingsCacheBehavior("USE_CACHE", 0);
    USE_CACHE = localSettingsCacheBehavior1;
    SettingsCacheBehavior localSettingsCacheBehavior2 = new SettingsCacheBehavior("SKIP_CACHE_LOOKUP", 1);
    SKIP_CACHE_LOOKUP = localSettingsCacheBehavior2;
    SettingsCacheBehavior localSettingsCacheBehavior3 = new SettingsCacheBehavior("IGNORE_CACHE_EXPIRATION", 2);
    IGNORE_CACHE_EXPIRATION = localSettingsCacheBehavior3;
    $VALUES = new SettingsCacheBehavior[] { localSettingsCacheBehavior1, localSettingsCacheBehavior2, localSettingsCacheBehavior3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsCacheBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */