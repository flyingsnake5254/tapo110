package com.tplink.libtpdemux.tsdemux.common;

public enum EnumESFrameType
{
  int value;
  
  static
  {
    EnumESFrameType localEnumESFrameType1 = new EnumESFrameType("TS_ES_FRAME_TYPE_INVALID", 0, -1);
    TS_ES_FRAME_TYPE_INVALID = localEnumESFrameType1;
    EnumESFrameType localEnumESFrameType2 = new EnumESFrameType("TS_ES_FRAME_TYPE_DATA", 1, 2);
    TS_ES_FRAME_TYPE_DATA = localEnumESFrameType2;
    EnumESFrameType localEnumESFrameType3 = new EnumESFrameType("TS_ES_FRAME_TYPE_IDR", 2, 5);
    TS_ES_FRAME_TYPE_IDR = localEnumESFrameType3;
    EnumESFrameType localEnumESFrameType4 = new EnumESFrameType("TS_ES_FRAME_TYPE_SEI", 3, 6);
    TS_ES_FRAME_TYPE_SEI = localEnumESFrameType4;
    EnumESFrameType localEnumESFrameType5 = new EnumESFrameType("TS_ES_FRAME_TYPE_SPS", 4, 7);
    TS_ES_FRAME_TYPE_SPS = localEnumESFrameType5;
    EnumESFrameType localEnumESFrameType6 = new EnumESFrameType("TS_ES_FRAME_TYPE_PPS", 5, 8);
    TS_ES_FRAME_TYPE_PPS = localEnumESFrameType6;
    $VALUES = new EnumESFrameType[] { localEnumESFrameType1, localEnumESFrameType2, localEnumESFrameType3, localEnumESFrameType4, localEnumESFrameType5, localEnumESFrameType6 };
  }
  
  private EnumESFrameType(int paramInt)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpdemux\tsdemux\common\EnumESFrameType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */