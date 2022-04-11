package com.tplink.libtpnetwork.enumerate;

public enum EnumDeviceStatus
{
  static
  {
    EnumDeviceStatus localEnumDeviceStatus1 = new EnumDeviceStatus("STATUS_ONLINE", 0);
    STATUS_ONLINE = localEnumDeviceStatus1;
    EnumDeviceStatus localEnumDeviceStatus2 = new EnumDeviceStatus("STATUS_OFFLINE", 1);
    STATUS_OFFLINE = localEnumDeviceStatus2;
    $VALUES = new EnumDeviceStatus[] { localEnumDeviceStatus1, localEnumDeviceStatus2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumDeviceStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */