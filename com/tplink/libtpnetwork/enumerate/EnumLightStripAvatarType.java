package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.v.e;

public enum EnumLightStripAvatarType
{
  public static final a Companion;
  private static final Map<String, EnumLightStripAvatarType> mTypeMap;
  private final String value;
  
  static
  {
    int i = 0;
    EnumLightStripAvatarType localEnumLightStripAvatarType1 = new EnumLightStripAvatarType("LIGHT_STRIP", 0, "light_strip");
    LIGHT_STRIP = localEnumLightStripAvatarType1;
    EnumLightStripAvatarType localEnumLightStripAvatarType2 = new EnumLightStripAvatarType("AQUARIUM", 1, "aquarium");
    AQUARIUM = localEnumLightStripAvatarType2;
    Object localObject1 = new EnumLightStripAvatarType("BEHIND_MIRROR", 2, "behind_mirror");
    BEHIND_MIRROR = (EnumLightStripAvatarType)localObject1;
    EnumLightStripAvatarType localEnumLightStripAvatarType3 = new EnumLightStripAvatarType("BEHIND_SOFA", 3, "behind_sofa");
    BEHIND_SOFA = localEnumLightStripAvatarType3;
    EnumLightStripAvatarType localEnumLightStripAvatarType4 = new EnumLightStripAvatarType("BEHIND_TV", 4, "behind_tv");
    BEHIND_TV = localEnumLightStripAvatarType4;
    EnumLightStripAvatarType localEnumLightStripAvatarType5 = new EnumLightStripAvatarType("CEILING_COVE", 5, "ceiling_cove");
    CEILING_COVE = localEnumLightStripAvatarType5;
    EnumLightStripAvatarType localEnumLightStripAvatarType6 = new EnumLightStripAvatarType("STAIR_RAIL", 6, "stair_rail");
    STAIR_RAIL = localEnumLightStripAvatarType6;
    EnumLightStripAvatarType localEnumLightStripAvatarType7 = new EnumLightStripAvatarType("UNDER_CABINET", 7, "under_cabinet");
    UNDER_CABINET = localEnumLightStripAvatarType7;
    EnumLightStripAvatarType localEnumLightStripAvatarType8 = new EnumLightStripAvatarType("UNDER_COUNTER", 8, "under_counter");
    UNDER_COUNTER = localEnumLightStripAvatarType8;
    Object localObject2 = new EnumLightStripAvatarType("STAIR_TREAD", 9, "stair_tread");
    STAIR_TREAD = (EnumLightStripAvatarType)localObject2;
    $VALUES = new EnumLightStripAvatarType[] { localEnumLightStripAvatarType1, localEnumLightStripAvatarType2, localObject1, localEnumLightStripAvatarType3, localEnumLightStripAvatarType4, localEnumLightStripAvatarType5, localEnumLightStripAvatarType6, localEnumLightStripAvatarType7, localEnumLightStripAvatarType8, localObject2 };
    Companion = new a(null);
    localObject1 = values();
    localObject2 = new LinkedHashMap(e.b(b0.a(localObject1.length), 16));
    int j = localObject1.length;
    while (i < j)
    {
      localEnumLightStripAvatarType7 = localObject1[i];
      ((Map)localObject2).put(localEnumLightStripAvatarType7.value, localEnumLightStripAvatarType7);
      i++;
    }
    mTypeMap = (Map)localObject2;
  }
  
  private EnumLightStripAvatarType(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumLightStripAvatarType fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumLightStripAvatarType a(String paramString)
    {
      return (EnumLightStripAvatarType)EnumLightStripAvatarType.access$getMTypeMap$cp().get(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumLightStripAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */