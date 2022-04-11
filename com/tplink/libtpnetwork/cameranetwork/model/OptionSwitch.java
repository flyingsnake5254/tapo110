package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum OptionSwitch
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    ON localON = new ON("ON", 0);
    ON = localON;
    OFF localOFF = new OFF("OFF", 1);
    OFF = localOFF;
    $VALUES = new OptionSwitch[] { localON, localOFF };
  }
  
  private OptionSwitch(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final OptionSwitch fromBoolean(boolean paramBoolean)
  {
    return Companion.fromBoolean(paramBoolean);
  }
  
  public static final OptionSwitch fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public static final boolean isOff(String paramString)
  {
    return Companion.isOff(paramString);
  }
  
  public static final boolean isOn(String paramString)
  {
    return Companion.isOn(paramString);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  public static final class Companion
  {
    public final OptionSwitch fromBoolean(boolean paramBoolean)
    {
      OptionSwitch localOptionSwitch;
      if (paramBoolean) {
        localOptionSwitch = OptionSwitch.ON;
      } else {
        localOptionSwitch = OptionSwitch.OFF;
      }
      return localOptionSwitch;
    }
    
    public final OptionSwitch fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (OptionSwitch localOptionSwitch : OptionSwitch.values()) {
        if (j.a(localOptionSwitch.getRaw(), paramString)) {
          return localOptionSwitch;
        }
      }
      paramString = null;
      return paramString;
    }
    
    public final boolean isOff(String paramString)
    {
      j.e(paramString, "raw");
      boolean bool;
      if (fromString(paramString) == OptionSwitch.OFF) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final boolean isOn(String paramString)
    {
      j.e(paramString, "raw");
      boolean bool;
      if (fromString(paramString) == OptionSwitch.ON) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  static final class OFF
    extends OptionSwitch
  {
    OFF(String paramString, int paramInt)
    {
      super(paramInt, "off", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
  
  static final class ON
    extends OptionSwitch
  {
    ON(String paramString, int paramInt)
    {
      super(paramInt, "on", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\OptionSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */