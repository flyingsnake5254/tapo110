package com.tplink.cloud.bean.device.params;

public class DeviceTokenParams
{
  private String deviceToken;
  private String serviceId;
  
  public DeviceTokenParams() {}
  
  public DeviceTokenParams(String paramString1, String paramString2)
  {
    this.serviceId = paramString1;
    this.deviceToken = paramString2;
  }
  
  public String getDeviceToken()
  {
    return this.deviceToken;
  }
  
  public String getServiceId()
  {
    return this.serviceId;
  }
  
  public void setDeviceToken(String paramString)
  {
    this.deviceToken = paramString;
  }
  
  public void setServiceId(String paramString)
  {
    this.serviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceTokenParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */