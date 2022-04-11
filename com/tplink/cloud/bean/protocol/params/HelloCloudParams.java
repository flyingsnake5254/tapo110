package com.tplink.cloud.bean.protocol.params;

public class HelloCloudParams
{
  private String appPackageName;
  private String appType;
  private String tcspVer;
  private String terminalUUID;
  
  public String getAppPackageName()
  {
    return this.appPackageName;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getTcspVer()
  {
    return this.tcspVer;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public void setAppPackageName(String paramString)
  {
    this.appPackageName = paramString;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setTcspVer(String paramString)
  {
    this.tcspVer = paramString;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\protocol\params\HelloCloudParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */