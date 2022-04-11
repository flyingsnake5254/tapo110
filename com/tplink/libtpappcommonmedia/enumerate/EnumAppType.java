package com.tplink.libtpappcommonmedia.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum EnumAppType
{
  private static Map<String, EnumAppType> appTypeMap;
  private String name;
  
  static
  {
    int i = 0;
    Object localObject = new EnumAppType("TAPO", 0, "tapo");
    TAPO = (EnumAppType)localObject;
    EnumAppType localEnumAppType1 = new EnumAppType("VIGI", 1, "vigi");
    VIGI = localEnumAppType1;
    EnumAppType localEnumAppType2 = new EnumAppType("KASA", 2, "kasa");
    KASA = localEnumAppType2;
    $VALUES = new EnumAppType[] { localObject, localEnumAppType1, localEnumAppType2 };
    appTypeMap = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumAppType2 = localObject[i];
      appTypeMap.put(localEnumAppType2.name, localEnumAppType2);
      i++;
    }
  }
  
  private EnumAppType(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumAppType fromString(String paramString)
  {
    return (EnumAppType)appTypeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\enumerate\EnumAppType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */