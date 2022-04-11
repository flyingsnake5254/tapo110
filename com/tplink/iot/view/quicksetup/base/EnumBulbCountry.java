package com.tplink.iot.view.quicksetup.base;

import java.util.HashMap;
import java.util.Map;

public enum EnumBulbCountry
{
  private static Map<String, EnumBulbCountry> countryMap;
  private String name;
  
  static
  {
    EnumBulbCountry localEnumBulbCountry1 = new EnumBulbCountry("EU", 0, "EU");
    EU = localEnumBulbCountry1;
    EnumBulbCountry localEnumBulbCountry2 = new EnumBulbCountry("US", 1, "US");
    US = localEnumBulbCountry2;
    EnumBulbCountry localEnumBulbCountry3 = new EnumBulbCountry("JP", 2, "JP");
    JP = localEnumBulbCountry3;
    $VALUES = new EnumBulbCountry[] { localEnumBulbCountry1, localEnumBulbCountry2, localEnumBulbCountry3 };
    HashMap localHashMap = new HashMap();
    countryMap = localHashMap;
    localHashMap.put("EN", localEnumBulbCountry1);
    countryMap.put("JP", localEnumBulbCountry3);
    countryMap.put("US", localEnumBulbCountry2);
    countryMap.put("CA", localEnumBulbCountry2);
    countryMap.put("MX", localEnumBulbCountry2);
    countryMap.put("TW", localEnumBulbCountry2);
    countryMap.put("TH", localEnumBulbCountry2);
    countryMap.put("PH", localEnumBulbCountry2);
  }
  
  private EnumBulbCountry(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumBulbCountry fromString(String paramString)
  {
    EnumBulbCountry localEnumBulbCountry = (EnumBulbCountry)countryMap.get(paramString);
    paramString = localEnumBulbCountry;
    if (localEnumBulbCountry == null) {
      paramString = EU;
    }
    return paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\EnumBulbCountry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */