package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum AlarmSoundType
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    ALARM localALARM = new ALARM("ALARM", 0);
    ALARM = localALARM;
    NOTICE localNOTICE = new NOTICE("NOTICE", 1);
    NOTICE = localNOTICE;
    $VALUES = new AlarmSoundType[] { localALARM, localNOTICE };
  }
  
  private AlarmSoundType(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final AlarmSoundType fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  static final class ALARM
    extends AlarmSoundType
  {
    ALARM(String paramString, int paramInt)
    {
      super(paramInt, "0", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
  
  public static final class Companion
  {
    public final AlarmSoundType fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (AlarmSoundType localAlarmSoundType : AlarmSoundType.values()) {
        if (j.a(localAlarmSoundType.getRaw(), paramString)) {
          return localAlarmSoundType;
        }
      }
      paramString = null;
      return paramString;
    }
  }
  
  static final class NOTICE
    extends AlarmSoundType
  {
    NOTICE(String paramString, int paramInt)
    {
      super(paramInt, "1", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AlarmSoundType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */