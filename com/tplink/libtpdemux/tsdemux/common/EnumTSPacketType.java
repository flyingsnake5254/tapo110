package com.tplink.libtpdemux.tsdemux.common;

public enum EnumTSPacketType
{
  int value;
  
  static
  {
    EnumTSPacketType localEnumTSPacketType1 = new EnumTSPacketType("TS_TS_PACKET_TYPE_INVALID", 0, -1);
    TS_TS_PACKET_TYPE_INVALID = localEnumTSPacketType1;
    EnumTSPacketType localEnumTSPacketType2 = new EnumTSPacketType("TS_TS_PACKET_TYPE_PAT", 1, 0);
    TS_TS_PACKET_TYPE_PAT = localEnumTSPacketType2;
    EnumTSPacketType localEnumTSPacketType3 = new EnumTSPacketType("TS_TS_PACKET_TYPE_PMT", 2, 1);
    TS_TS_PACKET_TYPE_PMT = localEnumTSPacketType3;
    EnumTSPacketType localEnumTSPacketType4 = new EnumTSPacketType("TS_TS_PACKET_TYPE_VIDEO", 3, 2);
    TS_TS_PACKET_TYPE_VIDEO = localEnumTSPacketType4;
    EnumTSPacketType localEnumTSPacketType5 = new EnumTSPacketType("TS_TS_PACKET_TYPE_AUDIO", 4, 3);
    TS_TS_PACKET_TYPE_AUDIO = localEnumTSPacketType5;
    $VALUES = new EnumTSPacketType[] { localEnumTSPacketType1, localEnumTSPacketType2, localEnumTSPacketType3, localEnumTSPacketType4, localEnumTSPacketType5 };
  }
  
  private EnumTSPacketType(int paramInt)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpdemux\tsdemux\common\EnumTSPacketType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */