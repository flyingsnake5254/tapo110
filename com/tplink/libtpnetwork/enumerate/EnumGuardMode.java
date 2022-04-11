package com.tplink.libtpnetwork.enumerate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public enum EnumGuardMode
{
  public static final a Companion;
  private static final List<String> types;
  private final String value;
  
  static
  {
    int i = 0;
    EnumGuardMode localEnumGuardMode = new EnumGuardMode("HOME", 0, "home");
    HOME = localEnumGuardMode;
    Object localObject1 = new EnumGuardMode("AWAY", 1, "away");
    AWAY = (EnumGuardMode)localObject1;
    Object localObject2 = new EnumGuardMode("SLEEP", 2, "sleep");
    SLEEP = (EnumGuardMode)localObject2;
    $VALUES = new EnumGuardMode[] { localEnumGuardMode, localObject1, localObject2 };
    Companion = new a(null);
    localObject1 = values();
    localObject2 = new ArrayList(localObject1.length);
    int j = localObject1.length;
    while (i < j)
    {
      ((Collection)localObject2).add(localObject1[i].value);
      i++;
    }
    types = (List)localObject2;
  }
  
  private EnumGuardMode(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumGuardMode getEnumGuardMode(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public static final EnumGuardMode getEnumGuardModeOrNull(String paramString)
  {
    return Companion.b(paramString);
  }
  
  public static final List<String> getTypes()
  {
    return types;
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumGuardMode a(String paramString)
    {
      paramString = b(paramString);
      if (paramString == null) {
        paramString = EnumGuardMode.HOME;
      }
      return paramString;
    }
    
    public final EnumGuardMode b(String paramString)
    {
      EnumGuardMode localEnumGuardMode = EnumGuardMode.HOME;
      if (j.a(paramString, localEnumGuardMode.getValue()))
      {
        paramString = localEnumGuardMode;
      }
      else
      {
        localEnumGuardMode = EnumGuardMode.AWAY;
        if (j.a(paramString, localEnumGuardMode.getValue()))
        {
          paramString = localEnumGuardMode;
        }
        else
        {
          localEnumGuardMode = EnumGuardMode.SLEEP;
          if (j.a(paramString, localEnumGuardMode.getValue())) {
            paramString = localEnumGuardMode;
          } else {
            paramString = null;
          }
        }
      }
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumGuardMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */