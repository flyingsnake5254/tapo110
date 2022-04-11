package com.tplink.libtpcontrols.tpthermostat;

import java.util.HashMap;
import java.util.Map;

public enum ThermostatHvacMode
{
  private static Map<String, ThermostatHvacMode> stringToEnum;
  private String name;
  private int value;
  
  static
  {
    int i = 0;
    ThermostatHvacMode localThermostatHvacMode1 = new ThermostatHvacMode("HVAC_MODE_HEAT", 0, 0, "heat");
    HVAC_MODE_HEAT = localThermostatHvacMode1;
    ThermostatHvacMode localThermostatHvacMode2 = new ThermostatHvacMode("HVAC_MODE_COOL", 1, 1, "cool");
    HVAC_MODE_COOL = localThermostatHvacMode2;
    ThermostatHvacMode localThermostatHvacMode3 = new ThermostatHvacMode("HVAC_MODE_HEAT_COOL", 2, 2, "heat_cool");
    HVAC_MODE_HEAT_COOL = localThermostatHvacMode3;
    Object localObject = new ThermostatHvacMode("HVAC_MODE_ECO", 3, 3, "eco");
    HVAC_MODE_ECO = (ThermostatHvacMode)localObject;
    ThermostatHvacMode localThermostatHvacMode4 = new ThermostatHvacMode("HVAC_MODE_OFF", 4, 4, "off");
    HVAC_MODE_OFF = localThermostatHvacMode4;
    $VALUES = new ThermostatHvacMode[] { localThermostatHvacMode1, localThermostatHvacMode2, localThermostatHvacMode3, localObject, localThermostatHvacMode4 };
    stringToEnum = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localThermostatHvacMode2 = localObject[i];
      stringToEnum.put(localThermostatHvacMode2.toString(), localThermostatHvacMode2);
      i++;
    }
  }
  
  private ThermostatHvacMode(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public static ThermostatHvacMode fromString(String paramString)
  {
    return (ThermostatHvacMode)stringToEnum.get(paramString);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpthermostat\ThermostatHvacMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */