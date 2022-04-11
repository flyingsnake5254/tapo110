package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum NightMode
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    NightMode localNightMode1 = new NightMode("AUTO", 0, "auto");
    AUTO = localNightMode1;
    NightMode localNightMode2 = new NightMode("NIGHT", 1, "on");
    NIGHT = localNightMode2;
    NightMode localNightMode3 = new NightMode("DAY", 2, "off");
    DAY = localNightMode3;
    $VALUES = new NightMode[] { localNightMode1, localNightMode2, localNightMode3 };
  }
  
  private NightMode(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final NightMode fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  public static final class Companion
  {
    public final NightMode fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (NightMode localNightMode : NightMode.values()) {
        if (j.a(localNightMode.getRaw(), paramString)) {
          return localNightMode;
        }
      }
      paramString = null;
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NightMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */