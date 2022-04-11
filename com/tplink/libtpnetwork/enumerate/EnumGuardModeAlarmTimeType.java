package com.tplink.libtpnetwork.enumerate;

public enum EnumGuardModeAlarmTimeType
{
  private final String value;
  
  static
  {
    EnumGuardModeAlarmTimeType localEnumGuardModeAlarmTimeType1 = new EnumGuardModeAlarmTimeType("ALWAYS", 0, "always");
    ALWAYS = localEnumGuardModeAlarmTimeType1;
    EnumGuardModeAlarmTimeType localEnumGuardModeAlarmTimeType2 = new EnumGuardModeAlarmTimeType("CUSTOM_TIME", 1, "custom_time");
    CUSTOM_TIME = localEnumGuardModeAlarmTimeType2;
    $VALUES = new EnumGuardModeAlarmTimeType[] { localEnumGuardModeAlarmTimeType1, localEnumGuardModeAlarmTimeType2 };
  }
  
  private EnumGuardModeAlarmTimeType(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumGuardModeAlarmTimeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */