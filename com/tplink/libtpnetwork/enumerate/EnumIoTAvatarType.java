package com.tplink.libtpnetwork.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum EnumIoTAvatarType
{
  private static Map<String, EnumIoTAvatarType> typeMap;
  private String name;
  
  static
  {
    EnumIoTAvatarType localEnumIoTAvatarType1 = new EnumIoTAvatarType("PLUG", 0, "plug");
    PLUG = localEnumIoTAvatarType1;
    EnumIoTAvatarType localEnumIoTAvatarType2 = new EnumIoTAvatarType("FAN", 1, "fan");
    FAN = localEnumIoTAvatarType2;
    EnumIoTAvatarType localEnumIoTAvatarType3 = new EnumIoTAvatarType("TABLE_LAMP", 2, "table_lamp");
    TABLE_LAMP = localEnumIoTAvatarType3;
    EnumIoTAvatarType localEnumIoTAvatarType4 = new EnumIoTAvatarType("CEILING_LAMP", 3, "ceiling_lamp");
    CEILING_LAMP = localEnumIoTAvatarType4;
    EnumIoTAvatarType localEnumIoTAvatarType5 = new EnumIoTAvatarType("TAPE_LIGHTS", 4, "tape_lights");
    TAPE_LIGHTS = localEnumIoTAvatarType5;
    Object localObject = new EnumIoTAvatarType("WALL_LAMP", 5, "wall_lamp");
    WALL_LAMP = (EnumIoTAvatarType)localObject;
    EnumIoTAvatarType localEnumIoTAvatarType6 = new EnumIoTAvatarType("SOUND", 6, "sound");
    SOUND = localEnumIoTAvatarType6;
    EnumIoTAvatarType localEnumIoTAvatarType7 = new EnumIoTAvatarType("RADIO", 7, "radio");
    RADIO = localEnumIoTAvatarType7;
    EnumIoTAvatarType localEnumIoTAvatarType8 = new EnumIoTAvatarType("HUMIDIFIER", 8, "humidifier");
    HUMIDIFIER = localEnumIoTAvatarType8;
    EnumIoTAvatarType localEnumIoTAvatarType9 = new EnumIoTAvatarType("KETTLE", 9, "kettle");
    KETTLE = localEnumIoTAvatarType9;
    EnumIoTAvatarType localEnumIoTAvatarType10 = new EnumIoTAvatarType("COFFEE_MAKER", 10, "coffee_maker");
    COFFEE_MAKER = localEnumIoTAvatarType10;
    EnumIoTAvatarType localEnumIoTAvatarType11 = new EnumIoTAvatarType("JUICER", 11, "juicer");
    JUICER = localEnumIoTAvatarType11;
    EnumIoTAvatarType localEnumIoTAvatarType12 = new EnumIoTAvatarType("EGG_BOILER", 12, "egg_boiler");
    EGG_BOILER = localEnumIoTAvatarType12;
    EnumIoTAvatarType localEnumIoTAvatarType13 = new EnumIoTAvatarType("BREAD_MAKER", 13, "bread_maker");
    BREAD_MAKER = localEnumIoTAvatarType13;
    EnumIoTAvatarType localEnumIoTAvatarType14 = new EnumIoTAvatarType("HOUSE", 14, "house");
    HOUSE = localEnumIoTAvatarType14;
    $VALUES = new EnumIoTAvatarType[] { localEnumIoTAvatarType1, localEnumIoTAvatarType2, localEnumIoTAvatarType3, localEnumIoTAvatarType4, localEnumIoTAvatarType5, localObject, localEnumIoTAvatarType6, localEnumIoTAvatarType7, localEnumIoTAvatarType8, localEnumIoTAvatarType9, localEnumIoTAvatarType10, localEnumIoTAvatarType11, localEnumIoTAvatarType12, localEnumIoTAvatarType13, localEnumIoTAvatarType14 };
    typeMap = new HashMap();
    for (localEnumIoTAvatarType7 : values()) {
      typeMap.put(localEnumIoTAvatarType7.getName(), localEnumIoTAvatarType7);
    }
  }
  
  private EnumIoTAvatarType(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumIoTAvatarType fromString(String paramString)
  {
    return (EnumIoTAvatarType)typeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumIoTAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */