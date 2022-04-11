package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum NightVisionModeType
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    INFRARED localINFRARED = new INFRARED("INFRARED", 0);
    INFRARED = localINFRARED;
    FULL_COLOR localFULL_COLOR = new FULL_COLOR("FULL_COLOR", 1);
    FULL_COLOR = localFULL_COLOR;
    SMART localSMART = new SMART("SMART", 2);
    SMART = localSMART;
    $VALUES = new NightVisionModeType[] { localINFRARED, localFULL_COLOR, localSMART };
  }
  
  private NightVisionModeType(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final NightVisionModeType fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  public static final class Companion
  {
    public final NightVisionModeType fromString(String paramString)
    {
      for (NightVisionModeType localNightVisionModeType : ) {
        if (j.a(localNightVisionModeType.getRaw(), paramString)) {
          return localNightVisionModeType;
        }
      }
      paramString = null;
      return paramString;
    }
  }
  
  static final class FULL_COLOR
    extends NightVisionModeType
  {
    FULL_COLOR(String paramString, int paramInt)
    {
      super(paramInt, "wtl_night_vision", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
  
  static final class INFRARED
    extends NightVisionModeType
  {
    INFRARED(String paramString, int paramInt)
    {
      super(paramInt, "inf_night_vision", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
  
  static final class SMART
    extends NightVisionModeType
  {
    SMART(String paramString, int paramInt)
    {
      super(paramInt, "md_night_vision", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NightVisionModeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */