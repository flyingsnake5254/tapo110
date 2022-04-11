package com.tplink.tmp.enumerate;

public enum EnumTMPTransportType
{
  private String name;
  private int value;
  
  static
  {
    EnumTMPTransportType localEnumTMPTransportType1 = new EnumTMPTransportType("TRANSPORT_TYPE_UNKNOWN", 0, 0, "UNKNOWN");
    TRANSPORT_TYPE_UNKNOWN = localEnumTMPTransportType1;
    EnumTMPTransportType localEnumTMPTransportType2 = new EnumTMPTransportType("TRANSPORT_TYPE_SSH2", 1, 1, "SSH2");
    TRANSPORT_TYPE_SSH2 = localEnumTMPTransportType2;
    EnumTMPTransportType localEnumTMPTransportType3 = new EnumTMPTransportType("TRANSPORT_TYPE_BLE", 2, 2, "BLE");
    TRANSPORT_TYPE_BLE = localEnumTMPTransportType3;
    EnumTMPTransportType localEnumTMPTransportType4 = new EnumTMPTransportType("TRANSPORT_TYPE_ATA", 3, 3, "ATA");
    TRANSPORT_TYPE_ATA = localEnumTMPTransportType4;
    $VALUES = new EnumTMPTransportType[] { localEnumTMPTransportType1, localEnumTMPTransportType2, localEnumTMPTransportType3, localEnumTMPTransportType4 };
  }
  
  private EnumTMPTransportType(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tmp\enumerate\EnumTMPTransportType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */