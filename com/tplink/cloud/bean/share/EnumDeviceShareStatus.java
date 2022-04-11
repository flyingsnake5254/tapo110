package com.tplink.cloud.bean.share;

import com.google.gson.q.c;

public enum EnumDeviceShareStatus
{
  static
  {
    EnumDeviceShareStatus localEnumDeviceShareStatus1 = new EnumDeviceShareStatus("READY", 0);
    READY = localEnumDeviceShareStatus1;
    EnumDeviceShareStatus localEnumDeviceShareStatus2 = new EnumDeviceShareStatus("ACCEPTED", 1);
    ACCEPTED = localEnumDeviceShareStatus2;
    EnumDeviceShareStatus localEnumDeviceShareStatus3 = new EnumDeviceShareStatus("REJECTED", 2);
    REJECTED = localEnumDeviceShareStatus3;
    $VALUES = new EnumDeviceShareStatus[] { localEnumDeviceShareStatus1, localEnumDeviceShareStatus2, localEnumDeviceShareStatus3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\EnumDeviceShareStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */