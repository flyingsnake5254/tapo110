package com.tplink.libtpnetwork.enumerate;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EnumSwitchAvatarType
{
  private static Map<String, EnumSwitchAvatarType> typeMap;
  private String name;
  
  static
  {
    EnumSwitchAvatarType localEnumSwitchAvatarType1 = new EnumSwitchAvatarType("SWITCH_S220", 0, "switch");
    SWITCH_S220 = localEnumSwitchAvatarType1;
    EnumSwitchAvatarType localEnumSwitchAvatarType2 = new EnumSwitchAvatarType("SWITCH_S210", 1, "switch_s210");
    SWITCH_S210 = localEnumSwitchAvatarType2;
    EnumSwitchAvatarType localEnumSwitchAvatarType3 = new EnumSwitchAvatarType("TABLE_LAMP_1", 2, "table_lamp_1");
    TABLE_LAMP_1 = localEnumSwitchAvatarType3;
    EnumSwitchAvatarType localEnumSwitchAvatarType4 = new EnumSwitchAvatarType("TABLE_LAMP_2", 3, "table_lamp_2");
    TABLE_LAMP_2 = localEnumSwitchAvatarType4;
    EnumSwitchAvatarType localEnumSwitchAvatarType5 = new EnumSwitchAvatarType("TABLE_LAMP_3", 4, "table_lamp_3");
    TABLE_LAMP_3 = localEnumSwitchAvatarType5;
    EnumSwitchAvatarType localEnumSwitchAvatarType6 = new EnumSwitchAvatarType("TABLE_LAMP_4", 5, "table_lamp_4");
    TABLE_LAMP_4 = localEnumSwitchAvatarType6;
    EnumSwitchAvatarType localEnumSwitchAvatarType7 = new EnumSwitchAvatarType("TABLE_LAMP_5", 6, "table_lamp_5");
    TABLE_LAMP_5 = localEnumSwitchAvatarType7;
    EnumSwitchAvatarType localEnumSwitchAvatarType8 = new EnumSwitchAvatarType("HANG_LAMP_1", 7, "hang_lamp_1");
    HANG_LAMP_1 = localEnumSwitchAvatarType8;
    EnumSwitchAvatarType localEnumSwitchAvatarType9 = new EnumSwitchAvatarType("HANG_LAMP_2", 8, "hang_lamp_2");
    HANG_LAMP_2 = localEnumSwitchAvatarType9;
    EnumSwitchAvatarType localEnumSwitchAvatarType10 = new EnumSwitchAvatarType("HANG_LAMP_3", 9, "hang_lamp_3");
    HANG_LAMP_3 = localEnumSwitchAvatarType10;
    EnumSwitchAvatarType localEnumSwitchAvatarType11 = new EnumSwitchAvatarType("FLOOR_LAMP_1", 10, "floor_lamp_1");
    FLOOR_LAMP_1 = localEnumSwitchAvatarType11;
    EnumSwitchAvatarType localEnumSwitchAvatarType12 = new EnumSwitchAvatarType("FLOOR_LAMP_2", 11, "floor_lamp_2");
    FLOOR_LAMP_2 = localEnumSwitchAvatarType12;
    EnumSwitchAvatarType localEnumSwitchAvatarType13 = new EnumSwitchAvatarType("FLOOR_LAMP_3", 12, "floor_lamp_3");
    FLOOR_LAMP_3 = localEnumSwitchAvatarType13;
    Object localObject = new EnumSwitchAvatarType("FAN", 13, "fan");
    FAN = (EnumSwitchAvatarType)localObject;
    $VALUES = new EnumSwitchAvatarType[] { localEnumSwitchAvatarType1, localEnumSwitchAvatarType2, localEnumSwitchAvatarType3, localEnumSwitchAvatarType4, localEnumSwitchAvatarType5, localEnumSwitchAvatarType6, localEnumSwitchAvatarType7, localEnumSwitchAvatarType8, localEnumSwitchAvatarType9, localEnumSwitchAvatarType10, localEnumSwitchAvatarType11, localEnumSwitchAvatarType12, localEnumSwitchAvatarType13, localObject };
    typeMap = new HashMap();
    for (localEnumSwitchAvatarType7 : values()) {
      typeMap.put(localEnumSwitchAvatarType7.name, localEnumSwitchAvatarType7);
    }
  }
  
  private EnumSwitchAvatarType(String paramString)
  {
    this.name = paramString;
  }
  
  @Nullable
  public static EnumSwitchAvatarType fromString(String paramString)
  {
    return (EnumSwitchAvatarType)typeMap.get(paramString);
  }
  
  private static List<String> getAllAvatarNames()
  {
    ArrayList localArrayList = new ArrayList();
    EnumSwitchAvatarType[] arrayOfEnumSwitchAvatarType = values();
    int i = arrayOfEnumSwitchAvatarType.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(arrayOfEnumSwitchAvatarType[j].name);
    }
    return localArrayList;
  }
  
  public static List<String> getS210AvatarNames()
  {
    List localList = getAllAvatarNames();
    localList.remove(SWITCH_S220.name);
    return localList;
  }
  
  public static List<String> getS220AvatarNames()
  {
    List localList = getAllAvatarNames();
    localList.remove(SWITCH_S210.name);
    return localList;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumSwitchAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */