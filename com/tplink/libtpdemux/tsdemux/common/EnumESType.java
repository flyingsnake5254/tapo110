package com.tplink.libtpdemux.tsdemux.common;

public enum EnumESType
{
  int value;
  
  static
  {
    EnumESType localEnumESType1 = new EnumESType("TS_ES_TYPE_INVALID", 0, -1);
    TS_ES_TYPE_INVALID = localEnumESType1;
    EnumESType localEnumESType2 = new EnumESType("TS_ES_TYPE_VIDEO", 1, 0);
    TS_ES_TYPE_VIDEO = localEnumESType2;
    EnumESType localEnumESType3 = new EnumESType("TS_ES_TYPE_AUDIO", 2, 1);
    TS_ES_TYPE_AUDIO = localEnumESType3;
    $VALUES = new EnumESType[] { localEnumESType1, localEnumESType2, localEnumESType3 };
  }
  
  private EnumESType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpdemux\tsdemux\common\EnumESType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */