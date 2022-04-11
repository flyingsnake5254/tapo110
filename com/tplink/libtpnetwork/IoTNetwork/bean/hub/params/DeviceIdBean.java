package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;

public class DeviceIdBean
{
  @c("device_id")
  private String deviceId;
  
  public DeviceIdBean() {}
  
  public DeviceIdBean(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\DeviceIdBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */