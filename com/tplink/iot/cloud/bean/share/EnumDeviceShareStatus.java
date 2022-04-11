package com.tplink.iot.cloud.bean.share;

import com.google.gson.q.c;

public enum EnumDeviceShareStatus
{
  private String name;
  
  static
  {
    EnumDeviceShareStatus localEnumDeviceShareStatus1 = new EnumDeviceShareStatus("READY", 0, "ready");
    READY = localEnumDeviceShareStatus1;
    EnumDeviceShareStatus localEnumDeviceShareStatus2 = new EnumDeviceShareStatus("ACCEPTED", 1, "accepted");
    ACCEPTED = localEnumDeviceShareStatus2;
    EnumDeviceShareStatus localEnumDeviceShareStatus3 = new EnumDeviceShareStatus("REJECTED", 2, "rejected");
    REJECTED = localEnumDeviceShareStatus3;
    $VALUES = new EnumDeviceShareStatus[] { localEnumDeviceShareStatus1, localEnumDeviceShareStatus2, localEnumDeviceShareStatus3 };
  }
  
  private EnumDeviceShareStatus(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\EnumDeviceShareStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */