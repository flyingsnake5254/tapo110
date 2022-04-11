package com.tplink.libtpnetwork.enumerate;

public enum EnumPowerOnState
{
  private final String type;
  
  static
  {
    EnumPowerOnState localEnumPowerOnState1 = new EnumPowerOnState("LAST_STATES", 0, "last_states");
    LAST_STATES = localEnumPowerOnState1;
    EnumPowerOnState localEnumPowerOnState2 = new EnumPowerOnState("ALWAYS_ON", 1, "custom");
    ALWAYS_ON = localEnumPowerOnState2;
    EnumPowerOnState localEnumPowerOnState3 = new EnumPowerOnState("ALWAYS_OFF", 2, "custom");
    ALWAYS_OFF = localEnumPowerOnState3;
    $VALUES = new EnumPowerOnState[] { localEnumPowerOnState1, localEnumPowerOnState2, localEnumPowerOnState3 };
  }
  
  private EnumPowerOnState(String paramString)
  {
    this.type = paramString;
  }
  
  public final String getType()
  {
    return this.type;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumPowerOnState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */