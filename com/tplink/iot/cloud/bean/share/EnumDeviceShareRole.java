package com.tplink.iot.cloud.bean.share;

import com.google.gson.q.c;

public enum EnumDeviceShareRole
{
  private String name;
  
  static
  {
    EnumDeviceShareRole localEnumDeviceShareRole1 = new EnumDeviceShareRole("OWNER", 0, "owner");
    OWNER = localEnumDeviceShareRole1;
    EnumDeviceShareRole localEnumDeviceShareRole2 = new EnumDeviceShareRole("SHARER", 1, "sharer");
    SHARER = localEnumDeviceShareRole2;
    $VALUES = new EnumDeviceShareRole[] { localEnumDeviceShareRole1, localEnumDeviceShareRole2 };
  }
  
  private EnumDeviceShareRole(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\EnumDeviceShareRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */