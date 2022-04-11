package com.tplink.libtpnetwork.enumerate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.v.e;

public enum EnumButtonAvatarType
{
  public static final a Companion;
  private static final Map<String, EnumButtonAvatarType> mTypeMap;
  private final String value;
  
  static
  {
    int i = 0;
    Object localObject1 = new EnumButtonAvatarType("BUTTON", 0, "button");
    BUTTON = (EnumButtonAvatarType)localObject1;
    EnumButtonAvatarType localEnumButtonAvatarType1 = new EnumButtonAvatarType("DOORBELL", 1, "doorbell");
    DOORBELL = localEnumButtonAvatarType1;
    Object localObject2 = new EnumButtonAvatarType("BULB", 2, "bulb");
    BULB = (EnumButtonAvatarType)localObject2;
    EnumButtonAvatarType localEnumButtonAvatarType2 = new EnumButtonAvatarType("WINDOW", 3, "window");
    WINDOW = localEnumButtonAvatarType2;
    $VALUES = new EnumButtonAvatarType[] { localObject1, localEnumButtonAvatarType1, localObject2, localEnumButtonAvatarType2 };
    Companion = new a(null);
    localObject2 = values();
    localObject1 = new LinkedHashMap(e.b(b0.a(localObject2.length), 16));
    int j = localObject2.length;
    while (i < j)
    {
      localEnumButtonAvatarType2 = localObject2[i];
      ((Map)localObject1).put(localEnumButtonAvatarType2.value, localEnumButtonAvatarType2);
      i++;
    }
    mTypeMap = (Map)localObject1;
  }
  
  private EnumButtonAvatarType(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumButtonAvatarType fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumButtonAvatarType a(String paramString)
    {
      return (EnumButtonAvatarType)EnumButtonAvatarType.access$getMTypeMap$cp().get(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumButtonAvatarType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */