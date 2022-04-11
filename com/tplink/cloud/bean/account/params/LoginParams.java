package com.tplink.cloud.bean.account.params;

public class LoginParams
{
  private String appType;
  private String appVersion;
  private String cloudPassword;
  private String cloudUserName;
  private String platform;
  private boolean refreshTokenNeeded;
  private String terminalUUID;
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getCloudPassword()
  {
    return this.cloudPassword;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public boolean isRefreshTokenNeeded()
  {
    return this.refreshTokenNeeded;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.appVersion = paramString;
  }
  
  public void setCloudPassword(String paramString)
  {
    this.cloudPassword = paramString;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setPlatform(String paramString)
  {
    this.platform = paramString;
  }
  
  public void setRefreshTokenNeeded(boolean paramBoolean)
  {
    this.refreshTokenNeeded = paramBoolean;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\LoginParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */