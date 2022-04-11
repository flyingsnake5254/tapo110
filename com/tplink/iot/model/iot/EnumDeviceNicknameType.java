package com.tplink.iot.model.iot;

import com.google.gson.q.c;
import com.tplink.iot.Utils.b0;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum EnumDeviceNicknameType
{
  private static Locale sLocale;
  private static Map<EnumDeviceNicknameType, String> sMap;
  private static Map<String, EnumDeviceNicknameType> sTypeMap;
  private String name;
  
  static
  {
    EnumDeviceNicknameType localEnumDeviceNicknameType1 = new EnumDeviceNicknameType("BEDROOM", 0, "bedroom");
    BEDROOM = localEnumDeviceNicknameType1;
    EnumDeviceNicknameType localEnumDeviceNicknameType2 = new EnumDeviceNicknameType("HALLWAY", 1, "hallway");
    HALLWAY = localEnumDeviceNicknameType2;
    EnumDeviceNicknameType localEnumDeviceNicknameType3 = new EnumDeviceNicknameType("KITCHEN", 2, "kitchen");
    KITCHEN = localEnumDeviceNicknameType3;
    EnumDeviceNicknameType localEnumDeviceNicknameType4 = new EnumDeviceNicknameType("LIVING_ROOM", 3, "living_room");
    LIVING_ROOM = localEnumDeviceNicknameType4;
    EnumDeviceNicknameType localEnumDeviceNicknameType5 = new EnumDeviceNicknameType("MASTER_BEDROOM", 4, "master_bedroom");
    MASTER_BEDROOM = localEnumDeviceNicknameType5;
    EnumDeviceNicknameType localEnumDeviceNicknameType6 = new EnumDeviceNicknameType("OFFICE", 5, "office");
    OFFICE = localEnumDeviceNicknameType6;
    EnumDeviceNicknameType localEnumDeviceNicknameType7 = new EnumDeviceNicknameType("STUDY", 6, "study");
    STUDY = localEnumDeviceNicknameType7;
    EnumDeviceNicknameType localEnumDeviceNicknameType8 = new EnumDeviceNicknameType("CUSTOM", 7, "custom");
    CUSTOM = localEnumDeviceNicknameType8;
    $VALUES = new EnumDeviceNicknameType[] { localEnumDeviceNicknameType1, localEnumDeviceNicknameType2, localEnumDeviceNicknameType3, localEnumDeviceNicknameType4, localEnumDeviceNicknameType5, localEnumDeviceNicknameType6, localEnumDeviceNicknameType7, localEnumDeviceNicknameType8 };
    sLocale = null;
    sMap = new HashMap();
    sTypeMap = new HashMap();
    initMap();
  }
  
  private EnumDeviceNicknameType(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumDeviceNicknameType fromString(String paramString)
  {
    initMap();
    return (EnumDeviceNicknameType)sTypeMap.get(paramString);
  }
  
  public static String fromType(EnumDeviceNicknameType paramEnumDeviceNicknameType)
  {
    initMap();
    return (String)sMap.get(paramEnumDeviceNicknameType);
  }
  
  private static void initMap()
  {
    if (!Locale.getDefault().equals(sLocale))
    {
      sLocale = Locale.getDefault();
      sMap.put(BEDROOM, b0.a(2131953003));
      sMap.put(HALLWAY, b0.a(2131953005));
      sMap.put(KITCHEN, b0.a(2131953006));
      sMap.put(LIVING_ROOM, b0.a(2131953007));
      sMap.put(MASTER_BEDROOM, b0.a(2131953008));
      sMap.put(OFFICE, b0.a(2131953010));
      sMap.put(STUDY, b0.a(2131953011));
      sMap.put(CUSTOM, b0.a(2131953004));
      for (EnumDeviceNicknameType localEnumDeviceNicknameType : values()) {
        sTypeMap.put(localEnumDeviceNicknameType.getName(), localEnumDeviceNicknameType);
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\iot\EnumDeviceNicknameType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */