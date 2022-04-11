package com.tplink.libtpcontrols.tpthermostat;

import java.util.HashMap;
import java.util.Map;

public enum ThermostatHavcState
{
  private static Map<String, ThermostatHavcState> stringToEnum;
  private String name;
  private int value;
  
  static
  {
    int i = 0;
    Object localObject = new ThermostatHavcState("HAVC_MODE_HEATING", 0, 0, "heating");
    HAVC_MODE_HEATING = (ThermostatHavcState)localObject;
    ThermostatHavcState localThermostatHavcState1 = new ThermostatHavcState("HAVC_MODE_COOLING", 1, 1, "cooling");
    HAVC_MODE_COOLING = localThermostatHavcState1;
    ThermostatHavcState localThermostatHavcState2 = new ThermostatHavcState("HAVC_MODE_OFF", 2, 2, "off");
    HAVC_MODE_OFF = localThermostatHavcState2;
    $VALUES = new ThermostatHavcState[] { localObject, localThermostatHavcState1, localThermostatHavcState2 };
    stringToEnum = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localThermostatHavcState2 = localObject[i];
      stringToEnum.put(localThermostatHavcState2.toString(), localThermostatHavcState2);
      i++;
    }
  }
  
  private ThermostatHavcState(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public static ThermostatHavcState fromString(String paramString)
  {
    return (ThermostatHavcState)stringToEnum.get(paramString);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpthermostat\ThermostatHavcState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */