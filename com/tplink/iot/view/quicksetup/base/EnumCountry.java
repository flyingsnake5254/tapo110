package com.tplink.iot.view.quicksetup.base;

import java.util.HashMap;
import java.util.Map;

public enum EnumCountry
{
  private static Map<String, EnumCountry> countryMap;
  private String name;
  
  static
  {
    int i = 0;
    EnumCountry localEnumCountry1 = new EnumCountry("EU", 0, "EU");
    EU = localEnumCountry1;
    EnumCountry localEnumCountry2 = new EnumCountry("US", 1, "US");
    US = localEnumCountry2;
    EnumCountry localEnumCountry3 = new EnumCountry("UK", 2, "UK");
    UK = localEnumCountry3;
    Object localObject = new EnumCountry("JP", 3, "JP");
    JP = (EnumCountry)localObject;
    EnumCountry localEnumCountry4 = new EnumCountry("FR", 4, "FR");
    FR = localEnumCountry4;
    EnumCountry localEnumCountry5 = new EnumCountry("AU", 5, "AU");
    AU = localEnumCountry5;
    $VALUES = new EnumCountry[] { localEnumCountry1, localEnumCountry2, localEnumCountry3, localObject, localEnumCountry4, localEnumCountry5 };
    countryMap = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localEnumCountry1 = localObject[i];
      countryMap.put(localEnumCountry1.getName(), localEnumCountry1);
      i++;
    }
  }
  
  private EnumCountry(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumCountry fromString(String paramString)
  {
    return (EnumCountry)countryMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\EnumCountry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */