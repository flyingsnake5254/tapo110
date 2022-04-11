package com.tplink.libtpnetwork.cameranetwork.common;

public enum EnumCameraTransportType
{
  static
  {
    EnumCameraTransportType localEnumCameraTransportType1 = new EnumCameraTransportType("LOCAL", 0);
    LOCAL = localEnumCameraTransportType1;
    EnumCameraTransportType localEnumCameraTransportType2 = new EnumCameraTransportType("REMOTE", 1);
    REMOTE = localEnumCameraTransportType2;
    EnumCameraTransportType localEnumCameraTransportType3 = new EnumCameraTransportType("IOT_REMOTE", 2);
    IOT_REMOTE = localEnumCameraTransportType3;
    $VALUES = new EnumCameraTransportType[] { localEnumCameraTransportType1, localEnumCameraTransportType2, localEnumCameraTransportType3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\common\EnumCameraTransportType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */