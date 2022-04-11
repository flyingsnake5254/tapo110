package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

public enum EnumShutdownMode
{
  private final String value;
  
  static
  {
    EnumShutdownMode localEnumShutdownMode1 = new EnumShutdownMode("FULL_CLOSED", 0, "full_closed");
    FULL_CLOSED = localEnumShutdownMode1;
    EnumShutdownMode localEnumShutdownMode2 = new EnumShutdownMode("FULL_OPEN", 1, "full_open");
    FULL_OPEN = localEnumShutdownMode2;
    $VALUES = new EnumShutdownMode[] { localEnumShutdownMode1, localEnumShutdownMode2 };
  }
  
  private EnumShutdownMode(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\EnumShutdownMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */