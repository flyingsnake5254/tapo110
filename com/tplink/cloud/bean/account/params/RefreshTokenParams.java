package com.tplink.cloud.bean.account.params;

public class RefreshTokenParams
{
  private String appType;
  private String refreshToken;
  private String terminalUUID;
  
  public RefreshTokenParams() {}
  
  public RefreshTokenParams(String paramString1, String paramString2, String paramString3)
  {
    this.refreshToken = paramString1;
    this.appType = paramString2;
    this.terminalUUID = paramString3;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    this.refreshToken = paramString;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\RefreshTokenParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */