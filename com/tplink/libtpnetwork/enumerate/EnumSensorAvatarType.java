package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.v.e;

public enum EnumSensorAvatarType
{
  public static final a Companion;
  private static final Map<String, EnumSensorAvatarType> mTypeMap;
  private final String value;
  
  static
  {
    int i = 0;
    EnumSensorAvatarType localEnumSensorAvatarType1 = new EnumSensorAvatarType("SENSOR", 0, "sensor");
    SENSOR = localEnumSensorAvatarType1;
    Object localObject1 = new EnumSensorAvatarType("OUTDOOR", 1, "outdoor");
    OUTDOOR = (EnumSensorAvatarType)localObject1;
    EnumSensorAvatarType localEnumSensorAvatarType2 = new EnumSensorAvatarType("HALLWAY", 2, "hallway");
    HALLWAY = localEnumSensorAvatarType2;
    EnumSensorAvatarType localEnumSensorAvatarType3 = new EnumSensorAvatarType("WINDOW", 3, "window");
    WINDOW = localEnumSensorAvatarType3;
    Object localObject2 = new EnumSensorAvatarType("BEDROOM", 4, "bedroom");
    BEDROOM = (EnumSensorAvatarType)localObject2;
    EnumSensorAvatarType localEnumSensorAvatarType4 = new EnumSensorAvatarType("LIVING_ROOM", 5, "living_room");
    LIVING_ROOM = localEnumSensorAvatarType4;
    $VALUES = new EnumSensorAvatarType[] { localEnumSensorAvatarType1, localObject1, localEnumSensorAvatarType2, localEnumSensorAvatarType3, localObject2, localEnumSensorAvatarType4 };
    Companion = new a(null);
    localObject2 = values();
    localObject1 = new LinkedHashMap(e.b(b0.a(localObject2.length), 16));
    int j = localObject2.length;
    while (i < j)
    {
      localEnumSensorAvatarType1 = localObject2[i];
      ((Map)localObject1).put(localEnumSensorAvatarType1.value, localEnumSensorAvatarType1);
      i++;
    }
    mTypeMap = (Map)localObject1;
  }
  
  private EnumSensorAvatarType(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumSensorAvatarType fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumSensorAvatarType a(String paramString)
    {
      return (EnumSensorAvatarType)EnumSensorAvatarType.access$getMTypeMap$cp().get(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumSensorAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */