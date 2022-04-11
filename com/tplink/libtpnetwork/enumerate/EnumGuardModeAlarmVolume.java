package com.tplink.libtpnetwork.enumerate;

public enum EnumGuardModeAlarmVolume
{
  private final String value;
  
  static
  {
    EnumGuardModeAlarmVolume localEnumGuardModeAlarmVolume1 = new EnumGuardModeAlarmVolume("MUTE", 0, "mute");
    MUTE = localEnumGuardModeAlarmVolume1;
    EnumGuardModeAlarmVolume localEnumGuardModeAlarmVolume2 = new EnumGuardModeAlarmVolume("LOW", 1, "low");
    LOW = localEnumGuardModeAlarmVolume2;
    EnumGuardModeAlarmVolume localEnumGuardModeAlarmVolume3 = new EnumGuardModeAlarmVolume("NORMAL", 2, "normal");
    NORMAL = localEnumGuardModeAlarmVolume3;
    EnumGuardModeAlarmVolume localEnumGuardModeAlarmVolume4 = new EnumGuardModeAlarmVolume("HIGH", 3, "high");
    HIGH = localEnumGuardModeAlarmVolume4;
    $VALUES = new EnumGuardModeAlarmVolume[] { localEnumGuardModeAlarmVolume1, localEnumGuardModeAlarmVolume2, localEnumGuardModeAlarmVolume3, localEnumGuardModeAlarmVolume4 };
  }
  
  private EnumGuardModeAlarmVolume(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumGuardModeAlarmVolume.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */