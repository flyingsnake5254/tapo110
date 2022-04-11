package com.tplink.libtpnetwork.IoTNetwork;

public enum EnumIoTTransportType
{
  static
  {
    EnumIoTTransportType localEnumIoTTransportType1 = new EnumIoTTransportType("HTTP", 0);
    HTTP = localEnumIoTTransportType1;
    EnumIoTTransportType localEnumIoTTransportType2 = new EnumIoTTransportType("BLE", 1);
    BLE = localEnumIoTTransportType2;
    EnumIoTTransportType localEnumIoTTransportType3 = new EnumIoTTransportType("PASS_THROUGH", 2);
    PASS_THROUGH = localEnumIoTTransportType3;
    $VALUES = new EnumIoTTransportType[] { localEnumIoTTransportType1, localEnumIoTTransportType2, localEnumIoTTransportType3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\EnumIoTTransportType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */