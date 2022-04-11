package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.v.e;

public enum EnumTRVAvatarType
{
  public static final a Companion;
  private static final Map<String, EnumTRVAvatarType> mTypeMap;
  private final String value;
  
  static
  {
    int i = 0;
    Object localObject1 = new EnumTRVAvatarType("TRV", 0, "trv");
    TRV = (EnumTRVAvatarType)localObject1;
    EnumTRVAvatarType localEnumTRVAvatarType1 = new EnumTRVAvatarType("LIVING_ROOM", 1, "living_room");
    LIVING_ROOM = localEnumTRVAvatarType1;
    EnumTRVAvatarType localEnumTRVAvatarType2 = new EnumTRVAvatarType("BED", 2, "bed");
    BED = localEnumTRVAvatarType2;
    EnumTRVAvatarType localEnumTRVAvatarType3 = new EnumTRVAvatarType("KITCHEN", 3, "kitchen");
    KITCHEN = localEnumTRVAvatarType3;
    EnumTRVAvatarType localEnumTRVAvatarType4 = new EnumTRVAvatarType("DINING_ROOM", 4, "dining_room");
    DINING_ROOM = localEnumTRVAvatarType4;
    Object localObject2 = new EnumTRVAvatarType("BATHROOM", 5, "bathroom");
    BATHROOM = (EnumTRVAvatarType)localObject2;
    EnumTRVAvatarType localEnumTRVAvatarType5 = new EnumTRVAvatarType("OFFICE", 6, "office");
    OFFICE = localEnumTRVAvatarType5;
    EnumTRVAvatarType localEnumTRVAvatarType6 = new EnumTRVAvatarType("STUDY", 7, "study");
    STUDY = localEnumTRVAvatarType6;
    EnumTRVAvatarType localEnumTRVAvatarType7 = new EnumTRVAvatarType("BABY_ROOM", 8, "baby_room");
    BABY_ROOM = localEnumTRVAvatarType7;
    $VALUES = new EnumTRVAvatarType[] { localObject1, localEnumTRVAvatarType1, localEnumTRVAvatarType2, localEnumTRVAvatarType3, localEnumTRVAvatarType4, localObject2, localEnumTRVAvatarType5, localEnumTRVAvatarType6, localEnumTRVAvatarType7 };
    Companion = new a(null);
    localObject2 = values();
    localObject1 = new LinkedHashMap(e.b(b0.a(localObject2.length), 16));
    int j = localObject2.length;
    while (i < j)
    {
      localEnumTRVAvatarType3 = localObject2[i];
      ((Map)localObject1).put(localEnumTRVAvatarType3.value, localEnumTRVAvatarType3);
      i++;
    }
    mTypeMap = (Map)localObject1;
  }
  
  private EnumTRVAvatarType(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumTRVAvatarType fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumTRVAvatarType a(String paramString)
    {
      return (EnumTRVAvatarType)EnumTRVAvatarType.access$getMTypeMap$cp().get(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumTRVAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */