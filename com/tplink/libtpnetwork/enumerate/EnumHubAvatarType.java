package com.tplink.libtpnetwork.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum EnumHubAvatarType
{
  private static Map<String, EnumHubAvatarType> typeMap;
  private String name;
  
  static
  {
    int i = 0;
    EnumHubAvatarType localEnumHubAvatarType1 = new EnumHubAvatarType("HUB", 0, "hub");
    HUB = localEnumHubAvatarType1;
    Object localObject = new EnumHubAvatarType("ALARM", 1, "alarm");
    ALARM = (EnumHubAvatarType)localObject;
    EnumHubAvatarType localEnumHubAvatarType2 = new EnumHubAvatarType("ALARM_2", 2, "alarm_2");
    ALARM_2 = localEnumHubAvatarType2;
    EnumHubAvatarType localEnumHubAvatarType3 = new EnumHubAvatarType("DOORBELL", 3, "doorbell");
    DOORBELL = localEnumHubAvatarType3;
    EnumHubAvatarType localEnumHubAvatarType4 = new EnumHubAvatarType("CLOCK", 4, "clock");
    CLOCK = localEnumHubAvatarType4;
    EnumHubAvatarType localEnumHubAvatarType5 = new EnumHubAvatarType("CLOCK_2", 5, "clock_2");
    CLOCK_2 = localEnumHubAvatarType5;
    EnumHubAvatarType localEnumHubAvatarType6 = new EnumHubAvatarType("GATEWAY", 6, "gateway");
    GATEWAY = localEnumHubAvatarType6;
    $VALUES = new EnumHubAvatarType[] { localEnumHubAvatarType1, localObject, localEnumHubAvatarType2, localEnumHubAvatarType3, localEnumHubAvatarType4, localEnumHubAvatarType5, localEnumHubAvatarType6 };
    typeMap = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumHubAvatarType3 = localObject[i];
      typeMap.put(localEnumHubAvatarType3.name, localEnumHubAvatarType3);
      i++;
    }
  }
  
  private EnumHubAvatarType(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumHubAvatarType fromString(String paramString)
  {
    return (EnumHubAvatarType)typeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumHubAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */