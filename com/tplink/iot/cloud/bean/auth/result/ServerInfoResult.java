package com.tplink.iot.cloud.bean.auth.result;

public class ServerInfoResult
{
  private String appServerUrl;
  private String cloudGatewayUrl;
  private String securityServerUrl;
  
  public String getAppServerUrl()
  {
    return this.appServerUrl;
  }
  
  public String getCloudGatewayUrl()
  {
    return this.cloudGatewayUrl;
  }
  
  public String getSecurityServerUrl()
  {
    return this.securityServerUrl;
  }
  
  public void setAppServerUrl(String paramString)
  {
    this.appServerUrl = paramString;
  }
  
  public void setCloudGatewayUrl(String paramString)
  {
    this.cloudGatewayUrl = paramString;
  }
  
  public void setSecurityServerUrl(String paramString)
  {
    this.securityServerUrl = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\auth\result\ServerInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */