package com.tplink.libtpnetwork.enumerate;

public enum EnumIoTDeviceState
{
  static
  {
    EnumIoTDeviceState localEnumIoTDeviceState1 = new EnumIoTDeviceState("LOADING", 0);
    LOADING = localEnumIoTDeviceState1;
    EnumIoTDeviceState localEnumIoTDeviceState2 = new EnumIoTDeviceState("ONLINE", 1);
    ONLINE = localEnumIoTDeviceState2;
    EnumIoTDeviceState localEnumIoTDeviceState3 = new EnumIoTDeviceState("OFFLINE", 2);
    OFFLINE = localEnumIoTDeviceState3;
    $VALUES = new EnumIoTDeviceState[] { localEnumIoTDeviceState1, localEnumIoTDeviceState2, localEnumIoTDeviceState3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumIoTDeviceState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */