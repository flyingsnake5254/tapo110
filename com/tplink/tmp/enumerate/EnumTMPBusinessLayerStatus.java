package com.tplink.tmp.enumerate;

public enum EnumTMPBusinessLayerStatus
{
  private String name;
  private int value;
  
  static
  {
    EnumTMPBusinessLayerStatus localEnumTMPBusinessLayerStatus1 = new EnumTMPBusinessLayerStatus("TMP_BUSINESS_LAYER_STATUS_IDLE", 0, 0, "TMP_BUSINESS_LAYER_STATUS_IDLE");
    TMP_BUSINESS_LAYER_STATUS_IDLE = localEnumTMPBusinessLayerStatus1;
    EnumTMPBusinessLayerStatus localEnumTMPBusinessLayerStatus2 = new EnumTMPBusinessLayerStatus("TMP_BUSINESS_LAYER_STATUS_CONNECTING", 1, 1, "TMP_BUSINESS_LAYER_STATUS_CONNECTING");
    TMP_BUSINESS_LAYER_STATUS_CONNECTING = localEnumTMPBusinessLayerStatus2;
    EnumTMPBusinessLayerStatus localEnumTMPBusinessLayerStatus3 = new EnumTMPBusinessLayerStatus("TMP_BUSINESS_LAYER_STATUS_CONNECTED", 2, 2, "TMP_BUSINESS_LAYER_STATUS_CONNECTED");
    TMP_BUSINESS_LAYER_STATUS_CONNECTED = localEnumTMPBusinessLayerStatus3;
    EnumTMPBusinessLayerStatus localEnumTMPBusinessLayerStatus4 = new EnumTMPBusinessLayerStatus("TMP_BUSINESS_LAYER_STATUS_DISCONNECTED", 3, 3, "TMP_BUSINESS_LAYER_STATUS_DISCONNECTED");
    TMP_BUSINESS_LAYER_STATUS_DISCONNECTED = localEnumTMPBusinessLayerStatus4;
    $VALUES = new EnumTMPBusinessLayerStatus[] { localEnumTMPBusinessLayerStatus1, localEnumTMPBusinessLayerStatus2, localEnumTMPBusinessLayerStatus3, localEnumTMPBusinessLayerStatus4 };
  }
  
  private EnumTMPBusinessLayerStatus(int paramInt, String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tmp\enumerate\EnumTMPBusinessLayerStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */