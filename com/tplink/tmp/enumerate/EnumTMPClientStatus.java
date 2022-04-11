package com.tplink.tmp.enumerate;

public enum EnumTMPClientStatus
{
  private String name;
  private int value;
  
  static
  {
    EnumTMPClientStatus localEnumTMPClientStatus1 = new EnumTMPClientStatus("TMPCLIENT_STATUS_IDLE", 0, 0, "TMPCLIENT_STATUS_IDLE");
    TMPCLIENT_STATUS_IDLE = localEnumTMPClientStatus1;
    EnumTMPClientStatus localEnumTMPClientStatus2 = new EnumTMPClientStatus("TMPCLIENT_STATUS_CONNECTING", 1, 1, "TMPCLIENT_STATUS_CONNECTING");
    TMPCLIENT_STATUS_CONNECTING = localEnumTMPClientStatus2;
    EnumTMPClientStatus localEnumTMPClientStatus3 = new EnumTMPClientStatus("TMPCLIENT_STATUS_CONNECTED", 2, 2, "TMPCLIENT_STATUS_CONNECTED");
    TMPCLIENT_STATUS_CONNECTED = localEnumTMPClientStatus3;
    EnumTMPClientStatus localEnumTMPClientStatus4 = new EnumTMPClientStatus("TMPCLIENT_STATUS_DISCONNECTED", 3, 3, "TMPCLIENT_STATUS_DISCONNECTED");
    TMPCLIENT_STATUS_DISCONNECTED = localEnumTMPClientStatus4;
    $VALUES = new EnumTMPClientStatus[] { localEnumTMPClientStatus1, localEnumTMPClientStatus2, localEnumTMPClientStatus3, localEnumTMPClientStatus4 };
  }
  
  private EnumTMPClientStatus(int paramInt, String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tmp\enumerate\EnumTMPClientStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */