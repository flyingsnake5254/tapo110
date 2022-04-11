package com.tplink.cloud.bean.device.result;

public class DeviceUnbindInfoResult
{
  private String deviceId;
  private int errorCode;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceUnbindInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */