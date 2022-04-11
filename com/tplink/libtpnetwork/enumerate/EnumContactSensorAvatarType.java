package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.v.e;

public enum EnumContactSensorAvatarType
{
  public static final a Companion;
  private static final Map<String, EnumContactSensorAvatarType> mTypeMap;
  private final String value;
  
  static
  {
    int i = 0;
    EnumContactSensorAvatarType localEnumContactSensorAvatarType1 = new EnumContactSensorAvatarType("SENSOR_T110", 0, "sensor_t110");
    SENSOR_T110 = localEnumContactSensorAvatarType1;
    EnumContactSensorAvatarType localEnumContactSensorAvatarType2 = new EnumContactSensorAvatarType("OUTDOOR", 1, "outdoor");
    OUTDOOR = localEnumContactSensorAvatarType2;
    EnumContactSensorAvatarType localEnumContactSensorAvatarType3 = new EnumContactSensorAvatarType("HALLWAY", 2, "hallway");
    HALLWAY = localEnumContactSensorAvatarType3;
    Object localObject1 = new EnumContactSensorAvatarType("WINDOW", 3, "window");
    WINDOW = (EnumContactSensorAvatarType)localObject1;
    Object localObject2 = new EnumContactSensorAvatarType("BEDROOM", 4, "bedroom");
    BEDROOM = (EnumContactSensorAvatarType)localObject2;
    EnumContactSensorAvatarType localEnumContactSensorAvatarType4 = new EnumContactSensorAvatarType("LIVING_ROOM", 5, "living_room");
    LIVING_ROOM = localEnumContactSensorAvatarType4;
    $VALUES = new EnumContactSensorAvatarType[] { localEnumContactSensorAvatarType1, localEnumContactSensorAvatarType2, localEnumContactSensorAvatarType3, localObject1, localObject2, localEnumContactSensorAvatarType4 };
    Companion = new a(null);
    localObject1 = values();
    localObject2 = new LinkedHashMap(e.b(b0.a(localObject1.length), 16));
    int j = localObject1.length;
    while (i < j)
    {
      localEnumContactSensorAvatarType4 = localObject1[i];
      ((Map)localObject2).put(localEnumContactSensorAvatarType4.value, localEnumContactSensorAvatarType4);
      i++;
    }
    mTypeMap = (Map)localObject2;
  }
  
  private EnumContactSensorAvatarType(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumContactSensorAvatarType fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumContactSensorAvatarType a(String paramString)
    {
      return (EnumContactSensorAvatarType)EnumContactSensorAvatarType.access$getMTypeMap$cp().get(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumContactSensorAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */