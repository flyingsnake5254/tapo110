package com.tplink.tmp.enumerate;

public enum EnumTMPLayerStatus
{
  private String name;
  private int value;
  
  static
  {
    EnumTMPLayerStatus localEnumTMPLayerStatus1 = new EnumTMPLayerStatus("TMP_LAYER_STATUS_IDLE", 0, 0, "TMP_LAYER_STATUS_IDLE");
    TMP_LAYER_STATUS_IDLE = localEnumTMPLayerStatus1;
    EnumTMPLayerStatus localEnumTMPLayerStatus2 = new EnumTMPLayerStatus("TMP_LAYER_STATUS_CONNECTING", 1, 1, "TMP_LAYER_STATUS_CONNECTING");
    TMP_LAYER_STATUS_CONNECTING = localEnumTMPLayerStatus2;
    EnumTMPLayerStatus localEnumTMPLayerStatus3 = new EnumTMPLayerStatus("TMP_LAYER_STATUS_CONNECTED", 2, 2, "TMP_LAYER_STATUS_CONNECTED");
    TMP_LAYER_STATUS_CONNECTED = localEnumTMPLayerStatus3;
    EnumTMPLayerStatus localEnumTMPLayerStatus4 = new EnumTMPLayerStatus("TMP_LAYER_STATUS_DISCONNECTED", 3, 3, "TMP_LAYER_STATUS_DISCONNECTED");
    TMP_LAYER_STATUS_DISCONNECTED = localEnumTMPLayerStatus4;
    $VALUES = new EnumTMPLayerStatus[] { localEnumTMPLayerStatus1, localEnumTMPLayerStatus2, localEnumTMPLayerStatus3, localEnumTMPLayerStatus4 };
  }
  
  private EnumTMPLayerStatus(int paramInt, String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tmp\enumerate\EnumTMPLayerStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */