package com.tplink.libtpnetwork.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum EnumBulbAvatarType
{
  private static Map<String, EnumBulbAvatarType> typeMap;
  private String name;
  
  static
  {
    int i = 0;
    Object localObject = new EnumBulbAvatarType("BULB", 0, "bulb");
    BULB = (EnumBulbAvatarType)localObject;
    EnumBulbAvatarType localEnumBulbAvatarType1 = new EnumBulbAvatarType("TABLE_LAMP_1", 1, "table_lamp_1");
    TABLE_LAMP_1 = localEnumBulbAvatarType1;
    EnumBulbAvatarType localEnumBulbAvatarType2 = new EnumBulbAvatarType("TABLE_LAMP_2", 2, "table_lamp_2");
    TABLE_LAMP_2 = localEnumBulbAvatarType2;
    EnumBulbAvatarType localEnumBulbAvatarType3 = new EnumBulbAvatarType("TABLE_LAMP_3", 3, "table_lamp_3");
    TABLE_LAMP_3 = localEnumBulbAvatarType3;
    EnumBulbAvatarType localEnumBulbAvatarType4 = new EnumBulbAvatarType("TABLE_LAMP_4", 4, "table_lamp_4");
    TABLE_LAMP_4 = localEnumBulbAvatarType4;
    EnumBulbAvatarType localEnumBulbAvatarType5 = new EnumBulbAvatarType("TABLE_LAMP_5", 5, "table_lamp_5");
    TABLE_LAMP_5 = localEnumBulbAvatarType5;
    EnumBulbAvatarType localEnumBulbAvatarType6 = new EnumBulbAvatarType("HANG_LAMP_1", 6, "hang_lamp_1");
    HANG_LAMP_1 = localEnumBulbAvatarType6;
    EnumBulbAvatarType localEnumBulbAvatarType7 = new EnumBulbAvatarType("HANG_LAMP_2", 7, "hang_lamp_2");
    HANG_LAMP_2 = localEnumBulbAvatarType7;
    EnumBulbAvatarType localEnumBulbAvatarType8 = new EnumBulbAvatarType("HANG_LAMP_3", 8, "hang_lamp_3");
    HANG_LAMP_3 = localEnumBulbAvatarType8;
    EnumBulbAvatarType localEnumBulbAvatarType9 = new EnumBulbAvatarType("FLOOR_LAMP_1", 9, "floor_lamp_1");
    FLOOR_LAMP_1 = localEnumBulbAvatarType9;
    EnumBulbAvatarType localEnumBulbAvatarType10 = new EnumBulbAvatarType("FLOOR_LAMP_2", 10, "floor_lamp_2");
    FLOOR_LAMP_2 = localEnumBulbAvatarType10;
    EnumBulbAvatarType localEnumBulbAvatarType11 = new EnumBulbAvatarType("FLOOR_LAMP_3", 11, "floor_lamp_3");
    FLOOR_LAMP_3 = localEnumBulbAvatarType11;
    $VALUES = new EnumBulbAvatarType[] { localObject, localEnumBulbAvatarType1, localEnumBulbAvatarType2, localEnumBulbAvatarType3, localEnumBulbAvatarType4, localEnumBulbAvatarType5, localEnumBulbAvatarType6, localEnumBulbAvatarType7, localEnumBulbAvatarType8, localEnumBulbAvatarType9, localEnumBulbAvatarType10, localEnumBulbAvatarType11 };
    typeMap = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumBulbAvatarType8 = localObject[i];
      typeMap.put(localEnumBulbAvatarType8.name, localEnumBulbAvatarType8);
      i++;
    }
  }
  
  private EnumBulbAvatarType(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumBulbAvatarType fromString(String paramString)
  {
    return (EnumBulbAvatarType)typeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumBulbAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */