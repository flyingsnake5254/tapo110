package com.tplink.cloud.bean.share.params;

public class DeviceShareParams
{
  private String appCategory;
  private String deviceId;
  private int shareExpires;
  private String sharerUserName;
  
  public DeviceShareParams() {}
  
  public DeviceShareParams(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.deviceId = paramString1;
    this.sharerUserName = paramString2;
    this.shareExpires = paramInt;
    this.appCategory = paramString3;
  }
  
  public String getAppCategory()
  {
    return this.appCategory;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getShareExpires()
  {
    return this.shareExpires;
  }
  
  public String getSharerUserName()
  {
    return this.sharerUserName;
  }
  
  public void setAppCategory(String paramString)
  {
    this.appCategory = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setShareExpires(int paramInt)
  {
    this.shareExpires = paramInt;
  }
  
  public void setSharerUserName(String paramString)
  {
    this.sharerUserName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\DeviceShareParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */