package com.tplink.cloud.bean.device.params;

public class DeviceListParams
{
  private String deviceType;
  private String protocol;
  
  public DeviceListParams() {}
  
  public DeviceListParams(String paramString1, String paramString2)
  {
    this.protocol = paramString1;
    this.deviceType = paramString2;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public String getProtocol()
  {
    return this.protocol;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setProtocol(String paramString)
  {
    this.protocol = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */