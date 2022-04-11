package com.tplink.libmediaapi.vod.apienum;

import java.util.HashMap;
import java.util.Map;

public enum EnumVodScale
{
  private static Map<String, EnumVodScale> typeMap;
  private String name;
  
  static
  {
    int i = 0;
    EnumVodScale localEnumVodScale1 = new EnumVodScale("SCALE_MINUS_16", 0, "1/16");
    SCALE_MINUS_16 = localEnumVodScale1;
    EnumVodScale localEnumVodScale2 = new EnumVodScale("SCALE_MINUS_8", 1, "1/8");
    SCALE_MINUS_8 = localEnumVodScale2;
    EnumVodScale localEnumVodScale3 = new EnumVodScale("SCALE_MINUS_4", 2, "1/4");
    SCALE_MINUS_4 = localEnumVodScale3;
    Object localObject = new EnumVodScale("SCALE_MINUS_2", 3, "1/2");
    SCALE_MINUS_2 = (EnumVodScale)localObject;
    EnumVodScale localEnumVodScale4 = new EnumVodScale("SCALE_1", 4, "1/1");
    SCALE_1 = localEnumVodScale4;
    EnumVodScale localEnumVodScale5 = new EnumVodScale("SCALE_PLUS_16", 5, "16/1");
    SCALE_PLUS_16 = localEnumVodScale5;
    EnumVodScale localEnumVodScale6 = new EnumVodScale("SCALE_PLUS_8", 6, "8/1");
    SCALE_PLUS_8 = localEnumVodScale6;
    EnumVodScale localEnumVodScale7 = new EnumVodScale("SCALE_PLUS_4", 7, "4/1");
    SCALE_PLUS_4 = localEnumVodScale7;
    EnumVodScale localEnumVodScale8 = new EnumVodScale("SCALE_PLUS_2", 8, "2/1");
    SCALE_PLUS_2 = localEnumVodScale8;
    $VALUES = new EnumVodScale[] { localEnumVodScale1, localEnumVodScale2, localEnumVodScale3, localObject, localEnumVodScale4, localEnumVodScale5, localEnumVodScale6, localEnumVodScale7, localEnumVodScale8 };
    typeMap = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumVodScale1 = localObject[i];
      typeMap.put(localEnumVodScale1.name, localEnumVodScale1);
      i++;
    }
  }
  
  private EnumVodScale(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumVodScale fromString(String paramString)
  {
    return (EnumVodScale)typeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\vod\apienum\EnumVodScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */