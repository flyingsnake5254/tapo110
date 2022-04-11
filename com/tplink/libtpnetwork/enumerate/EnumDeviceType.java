package com.tplink.libtpnetwork.enumerate;

import com.google.gson.q.c;

public enum EnumDeviceType
{
  private String deviceType;
  
  static
  {
    EnumDeviceType localEnumDeviceType1 = new EnumDeviceType("UNKNOWN", 0, "unknown");
    UNKNOWN = localEnumDeviceType1;
    EnumDeviceType localEnumDeviceType2 = new EnumDeviceType("BULB", 1, "SMART.TAPOBULB");
    BULB = localEnumDeviceType2;
    EnumDeviceType localEnumDeviceType3 = new EnumDeviceType("PLUG", 2, "SMART.TAPOPLUG");
    PLUG = localEnumDeviceType3;
    EnumDeviceType localEnumDeviceType4 = new EnumDeviceType("CAMERA", 3, "SMART.IPCAMERA");
    CAMERA = localEnumDeviceType4;
    EnumDeviceType localEnumDeviceType5 = new EnumDeviceType("HUB", 4, "SMART.TAPOHUB");
    HUB = localEnumDeviceType5;
    EnumDeviceType localEnumDeviceType6 = new EnumDeviceType("SENSOR", 5, "SMART.TAPOSENSOR");
    SENSOR = localEnumDeviceType6;
    EnumDeviceType localEnumDeviceType7 = new EnumDeviceType("SWITCH", 6, "SMART.TAPOSWITCH");
    SWITCH = localEnumDeviceType7;
    EnumDeviceType localEnumDeviceType8 = new EnumDeviceType("ENERGY", 7, "SMART.TAPOENERGY");
    ENERGY = localEnumDeviceType8;
    $VALUES = new EnumDeviceType[] { localEnumDeviceType1, localEnumDeviceType2, localEnumDeviceType3, localEnumDeviceType4, localEnumDeviceType5, localEnumDeviceType6, localEnumDeviceType7, localEnumDeviceType8 };
  }
  
  private EnumDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public static EnumDeviceType fromType(String paramString)
  {
    for (EnumDeviceType localEnumDeviceType : ) {
      if (localEnumDeviceType.getDeviceType().equals(paramString)) {
        return localEnumDeviceType;
      }
    }
    return UNKNOWN;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumDeviceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */