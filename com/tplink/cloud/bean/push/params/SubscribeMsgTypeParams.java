package com.tplink.cloud.bean.push.params;

public class SubscribeMsgTypeParams
{
  private String appType;
  private String deviceToken;
  
  public SubscribeMsgTypeParams() {}
  
  public SubscribeMsgTypeParams(String paramString1, String paramString2)
  {
    this.appType = paramString1;
    this.deviceToken = paramString2;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getDeviceToken()
  {
    return this.deviceToken;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setDeviceToken(String paramString)
  {
    this.deviceToken = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\SubscribeMsgTypeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */