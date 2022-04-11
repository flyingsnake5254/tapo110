package com.tplink.iot.cloud.bean.auth.params;

public class AuthParams
{
  private String appType;
  private String terminalUUID;
  private String token;
  
  public AuthParams() {}
  
  public AuthParams(String paramString1, String paramString2, String paramString3)
  {
    this.appType = paramString1;
    this.terminalUUID = paramString2;
    this.token = paramString3;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\auth\params\AuthParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */