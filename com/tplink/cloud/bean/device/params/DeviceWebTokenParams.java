package com.tplink.cloud.bean.device.params;

public class DeviceWebTokenParams
{
  private String token;
  
  public DeviceWebTokenParams() {}
  
  public DeviceWebTokenParams(String paramString)
  {
    this.token = paramString;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceWebTokenParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */