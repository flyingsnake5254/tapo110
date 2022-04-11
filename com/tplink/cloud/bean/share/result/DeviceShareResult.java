package com.tplink.cloud.bean.share.result;

public class DeviceShareResult
{
  private String deviceId;
  private int errorCode;
  private String shareId;
  private String sharerUserName;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getShareId()
  {
    return this.shareId;
  }
  
  public String getSharerUserName()
  {
    return this.sharerUserName;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setShareId(String paramString)
  {
    this.shareId = paramString;
  }
  
  public void setSharerUserName(String paramString)
  {
    this.sharerUserName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\result\DeviceShareResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */