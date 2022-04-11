package com.tplink.libtpdemux.tsdemux.common;

public enum EnumTSVideoEncodeType
{
  int value;
  
  static
  {
    EnumTSVideoEncodeType localEnumTSVideoEncodeType1 = new EnumTSVideoEncodeType("TS_VIDEO_ENCODE_TYPE_INVALID", 0, -1);
    TS_VIDEO_ENCODE_TYPE_INVALID = localEnumTSVideoEncodeType1;
    EnumTSVideoEncodeType localEnumTSVideoEncodeType2 = new EnumTSVideoEncodeType("TS_VIDEO_ENCODE_TYPE_H264", 1, 0);
    TS_VIDEO_ENCODE_TYPE_H264 = localEnumTSVideoEncodeType2;
    $VALUES = new EnumTSVideoEncodeType[] { localEnumTSVideoEncodeType1, localEnumTSVideoEncodeType2 };
  }
  
  private EnumTSVideoEncodeType(int paramInt)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpdemux\tsdemux\common\EnumTSVideoEncodeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */