package com.tplink.cloud.bean.device.params;

public class DeviceUnbindParams
{
  private String cloudUserName;
  private String deviceId;
  
  public DeviceUnbindParams() {}
  
  public DeviceUnbindParams(String paramString1, String paramString2)
  {
    this.deviceId = paramString1;
    this.cloudUserName = paramString2;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceUnbindParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */