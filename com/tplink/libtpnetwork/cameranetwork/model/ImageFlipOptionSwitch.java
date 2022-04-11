package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum ImageFlipOptionSwitch
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    ImageFlipOptionSwitch localImageFlipOptionSwitch1 = new ImageFlipOptionSwitch("ON", 0, "center");
    ON = localImageFlipOptionSwitch1;
    ImageFlipOptionSwitch localImageFlipOptionSwitch2 = new ImageFlipOptionSwitch("OFF", 1, "off");
    OFF = localImageFlipOptionSwitch2;
    $VALUES = new ImageFlipOptionSwitch[] { localImageFlipOptionSwitch1, localImageFlipOptionSwitch2 };
  }
  
  private ImageFlipOptionSwitch(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final ImageFlipOptionSwitch fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public static final class Companion
  {
    public final ImageFlipOptionSwitch fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (ImageFlipOptionSwitch localImageFlipOptionSwitch : ImageFlipOptionSwitch.values()) {
        if (j.a(ImageFlipOptionSwitch.access$getRaw$p(localImageFlipOptionSwitch), paramString)) {
          return localImageFlipOptionSwitch;
        }
      }
      paramString = null;
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ImageFlipOptionSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */