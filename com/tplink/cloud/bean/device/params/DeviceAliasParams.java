package com.tplink.cloud.bean.device.params;

public class DeviceAliasParams
{
  private String alias;
  private String deviceId;
  
  public DeviceAliasParams() {}
  
  public DeviceAliasParams(String paramString1, String paramString2)
  {
    this.deviceId = paramString1;
    this.alias = paramString2;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceAliasParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */