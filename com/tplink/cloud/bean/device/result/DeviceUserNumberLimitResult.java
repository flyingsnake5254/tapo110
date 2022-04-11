package com.tplink.cloud.bean.device.result;

public class DeviceUserNumberLimitResult
{
  private String deviceType;
  private int userNumberLimit;
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public int getUserNumberLimit()
  {
    return this.userNumberLimit;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setUserNumberLimit(int paramInt)
  {
    this.userNumberLimit = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceUserNumberLimitResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */