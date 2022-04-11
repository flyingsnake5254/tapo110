package com.tplink.libmediaapi.live.apienum;

import java.util.HashMap;
import java.util.Map;

public enum EnumTalkMode
{
  private static Map<String, EnumTalkMode> typeMap;
  private String name;
  
  static
  {
    int i = 0;
    EnumTalkMode localEnumTalkMode1 = new EnumTalkMode("HALP_DUPLEX", 0, "half_duplex");
    HALP_DUPLEX = localEnumTalkMode1;
    EnumTalkMode localEnumTalkMode2 = new EnumTalkMode("VAD", 1, "vad");
    VAD = localEnumTalkMode2;
    Object localObject = new EnumTalkMode("AEC", 2, "aec");
    AEC = (EnumTalkMode)localObject;
    $VALUES = new EnumTalkMode[] { localEnumTalkMode1, localEnumTalkMode2, localObject };
    typeMap = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumTalkMode2 = localObject[i];
      typeMap.put(localEnumTalkMode2.name, localEnumTalkMode2);
      i++;
    }
  }
  
  private EnumTalkMode(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumTalkMode fromString(String paramString)
  {
    return (EnumTalkMode)typeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\live\apienum\EnumTalkMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */