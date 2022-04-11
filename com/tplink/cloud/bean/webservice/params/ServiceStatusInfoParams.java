package com.tplink.cloud.bean.webservice.params;

import com.google.gson.f;

public class ServiceStatusInfoParams
{
  private String appType;
  private String os;
  private f serviceStatusInfo;
  private String terminalUUID;
  
  public ServiceStatusInfoParams() {}
  
  public ServiceStatusInfoParams(String paramString1, String paramString2, String paramString3, f paramf)
  {
    this.appType = paramString1;
    this.os = paramString2;
    this.terminalUUID = paramString3;
    this.serviceStatusInfo = paramf;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getOs()
  {
    return this.os;
  }
  
  public f getServiceStatusInfo()
  {
    return this.serviceStatusInfo;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setOs(String paramString)
  {
    this.os = paramString;
  }
  
  public void setServiceStatusInfo(f paramf)
  {
    this.serviceStatusInfo = paramf;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\params\ServiceStatusInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */