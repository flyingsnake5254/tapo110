package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum LightFrequencyMode
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    LightFrequencyMode localLightFrequencyMode1 = new LightFrequencyMode("AUTO", 0, "auto");
    AUTO = localLightFrequencyMode1;
    LightFrequencyMode localLightFrequencyMode2 = new LightFrequencyMode("OFF", 1, "off");
    OFF = localLightFrequencyMode2;
    LightFrequencyMode localLightFrequencyMode3 = new LightFrequencyMode("FREQUENCY_50_HZ", 2, "50");
    FREQUENCY_50_HZ = localLightFrequencyMode3;
    LightFrequencyMode localLightFrequencyMode4 = new LightFrequencyMode("FREQUENCY_60_HZ", 3, "60");
    FREQUENCY_60_HZ = localLightFrequencyMode4;
    $VALUES = new LightFrequencyMode[] { localLightFrequencyMode1, localLightFrequencyMode2, localLightFrequencyMode3, localLightFrequencyMode4 };
  }
  
  private LightFrequencyMode(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final LightFrequencyMode fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  public static final class Companion
  {
    public final LightFrequencyMode fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (LightFrequencyMode localLightFrequencyMode : LightFrequencyMode.values()) {
        if (j.a(localLightFrequencyMode.getRaw(), paramString)) {
          return localLightFrequencyMode;
        }
      }
      paramString = null;
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\LightFrequencyMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */