package com.tplink.libtpappcommonmedia.bean.stream;

import java.util.HashMap;
import java.util.Map;

public enum BitStreamType
{
  private static Map<String, BitStreamType> dist;
  private String resolution;
  private String value;
  
  static
  {
    int i = 0;
    BitStreamType localBitStreamType = new BitStreamType("MINOR_VGA", 0, "VGA", "640*360");
    MINOR_VGA = localBitStreamType;
    Object localObject = new BitStreamType("MAIN_HD", 1, "HD", "1920*1080");
    MAIN_HD = (BitStreamType)localObject;
    $VALUES = new BitStreamType[] { localBitStreamType, localObject };
    dist = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localBitStreamType = localObject[i];
      dist.put(localBitStreamType.value, localBitStreamType);
      i++;
    }
  }
  
  private BitStreamType(String paramString1, String paramString2)
  {
    this.value = paramString1;
    this.resolution = paramString2;
  }
  
  public static BitStreamType fromString(String paramString)
  {
    if (paramString != null) {
      paramString = (BitStreamType)dist.get(paramString);
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public boolean equals(BitStreamType paramBitStreamType)
  {
    boolean bool;
    if ((this.value.equals(paramBitStreamType.value)) && (this.resolution.equals(paramBitStreamType.resolution))) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\stream\BitStreamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */