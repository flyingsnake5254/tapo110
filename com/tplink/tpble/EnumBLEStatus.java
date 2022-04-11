package com.tplink.tpble;

public enum EnumBLEStatus
{
  static
  {
    EnumBLEStatus localEnumBLEStatus1 = new EnumBLEStatus("BLE_STATUS_IDLE", 0);
    BLE_STATUS_IDLE = localEnumBLEStatus1;
    EnumBLEStatus localEnumBLEStatus2 = new EnumBLEStatus("BLE_STATUS_CONNECTING", 1);
    BLE_STATUS_CONNECTING = localEnumBLEStatus2;
    EnumBLEStatus localEnumBLEStatus3 = new EnumBLEStatus("BLE_STATUS_CONNECTED", 2);
    BLE_STATUS_CONNECTED = localEnumBLEStatus3;
    EnumBLEStatus localEnumBLEStatus4 = new EnumBLEStatus("BLE_STATUS_DISCONNECTED", 3);
    BLE_STATUS_DISCONNECTED = localEnumBLEStatus4;
    $VALUES = new EnumBLEStatus[] { localEnumBLEStatus1, localEnumBLEStatus2, localEnumBLEStatus3, localEnumBLEStatus4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\EnumBLEStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */