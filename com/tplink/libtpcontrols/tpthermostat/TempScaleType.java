package com.tplink.libtpcontrols.tpthermostat;

import java.util.HashMap;
import java.util.Map;

public enum TempScaleType
{
  private static Map<String, TempScaleType> stringToEnum;
  private String name;
  private int value;
  
  static
  {
    int i = 0;
    Object localObject = new TempScaleType("SCALE_TYPE_C", 0, 0, "C");
    SCALE_TYPE_C = (TempScaleType)localObject;
    TempScaleType localTempScaleType = new TempScaleType("SCALE_TYPE_F", 1, 1, "F");
    SCALE_TYPE_F = localTempScaleType;
    $VALUES = new TempScaleType[] { localObject, localTempScaleType };
    stringToEnum = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localTempScaleType = localObject[i];
      stringToEnum.put(localTempScaleType.toString(), localTempScaleType);
      i++;
    }
  }
  
  private TempScaleType(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public static TempScaleType fromString(String paramString)
  {
    return (TempScaleType)stringToEnum.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpthermostat\TempScaleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */