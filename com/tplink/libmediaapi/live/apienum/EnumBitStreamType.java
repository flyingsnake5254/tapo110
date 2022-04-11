package com.tplink.libmediaapi.live.apienum;

import java.util.HashMap;
import java.util.Map;

public enum EnumBitStreamType
{
  private static Map<String, EnumBitStreamType> dist;
  private String resolution;
  private String value;
  
  static
  {
    int i = 0;
    Object localObject = new EnumBitStreamType("MINOR_VGA", 0, "VGA", "640*360");
    MINOR_VGA = (EnumBitStreamType)localObject;
    EnumBitStreamType localEnumBitStreamType = new EnumBitStreamType("MAIN_HD", 1, "HD", "1920*1080");
    MAIN_HD = localEnumBitStreamType;
    $VALUES = new EnumBitStreamType[] { localObject, localEnumBitStreamType };
    dist = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumBitStreamType = localObject[i];
      dist.put(localEnumBitStreamType.value, localEnumBitStreamType);
      i++;
    }
  }
  
  private EnumBitStreamType(String paramString1, String paramString2)
  {
    this.value = paramString1;
    this.resolution = paramString2;
  }
  
  public static EnumBitStreamType fromString(String paramString)
  {
    if (paramString != null) {
      paramString = (EnumBitStreamType)dist.get(paramString);
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public boolean equals(EnumBitStreamType paramEnumBitStreamType)
  {
    boolean bool;
    if ((this.value.equals(paramEnumBitStreamType.value)) && (this.resolution.equals(paramEnumBitStreamType.resolution))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public int getResolutionPixels()
  {
    try
    {
      String[] arrayOfString = getResolution().split("\\*");
      int i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(arrayOfString[1]);
      return i * j;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BitStreamType(");
    localStringBuilder.append(this.value);
    localStringBuilder.append(",");
    localStringBuilder.append(this.resolution);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\live\apienum\EnumBitStreamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */