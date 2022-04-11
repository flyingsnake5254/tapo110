package com.tplink.libtpnetwork.cameranetwork.bean;

public enum DeviceModeType
{
  private String value;
  
  static
  {
    DeviceModeType localDeviceModeType1 = new DeviceModeType("HOME_MODE", 0, "HomeMode");
    HOME_MODE = localDeviceModeType1;
    DeviceModeType localDeviceModeType2 = new DeviceModeType("AWAY_MODE", 1, "AwayMode");
    AWAY_MODE = localDeviceModeType2;
    DeviceModeType localDeviceModeType3 = new DeviceModeType("SCHEDULE_MODE", 2, "ScheduleMode");
    SCHEDULE_MODE = localDeviceModeType3;
    $VALUES = new DeviceModeType[] { localDeviceModeType1, localDeviceModeType2, localDeviceModeType3 };
  }
  
  private DeviceModeType(String paramString)
  {
    this.value = paramString;
  }
  
  public static DeviceModeType fromValue(String paramString)
  {
    for (DeviceModeType localDeviceModeType : ) {
      if (localDeviceModeType.value.equals(paramString)) {
        return localDeviceModeType;
      }
    }
    throw new IllegalArgumentException(String.valueOf(paramString));
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\DeviceModeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */