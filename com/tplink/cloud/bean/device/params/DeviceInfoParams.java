package com.tplink.cloud.bean.device.params;

public class DeviceInfoParams
{
  private String deviceId;
  
  public DeviceInfoParams() {}
  
  public DeviceInfoParams(String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */