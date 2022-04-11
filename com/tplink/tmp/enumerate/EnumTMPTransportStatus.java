package com.tplink.tmp.enumerate;

public enum EnumTMPTransportStatus
{
  private String name;
  private int value;
  
  static
  {
    EnumTMPTransportStatus localEnumTMPTransportStatus1 = new EnumTMPTransportStatus("TMP_TRANSPORT_STATUS_IDLE", 0, 0, "TMP_TRANSPORT_STATUS_IDLE");
    TMP_TRANSPORT_STATUS_IDLE = localEnumTMPTransportStatus1;
    EnumTMPTransportStatus localEnumTMPTransportStatus2 = new EnumTMPTransportStatus("TMP_TRANSPORT_STATUS_CONNECTING", 1, 1, "TMP_TRANSPORT_STATUS_CONNECTING");
    TMP_TRANSPORT_STATUS_CONNECTING = localEnumTMPTransportStatus2;
    EnumTMPTransportStatus localEnumTMPTransportStatus3 = new EnumTMPTransportStatus("TMP_TRANSPORT_STATUS_CONNECTED", 2, 2, "TMP_TRANSPORT_STATUS_CONNECTED");
    TMP_TRANSPORT_STATUS_CONNECTED = localEnumTMPTransportStatus3;
    EnumTMPTransportStatus localEnumTMPTransportStatus4 = new EnumTMPTransportStatus("TMP_TRANSPORT_STATUS_DISCONNECTED", 3, 3, "TMP_TRANSPORT_STATUS_DISCONNECTED");
    TMP_TRANSPORT_STATUS_DISCONNECTED = localEnumTMPTransportStatus4;
    $VALUES = new EnumTMPTransportStatus[] { localEnumTMPTransportStatus1, localEnumTMPTransportStatus2, localEnumTMPTransportStatus3, localEnumTMPTransportStatus4 };
  }
  
  private EnumTMPTransportStatus(int paramInt, String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tmp\enumerate\EnumTMPTransportStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */