package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

public class EncryptedSourceParam
{
  @c("apv")
  private String appVersion;
  @c("lg")
  private String language;
  @c("rg")
  private String region;
  @c("sv")
  private String systemVersion;
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public String getSystemVersion()
  {
    return this.systemVersion;
  }
  
  public boolean isNotAllNull()
  {
    boolean bool;
    if ((this.appVersion == null) && (this.language == null) && (this.region == null) && (this.systemVersion == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setAppVersion(String paramString)
  {
    this.appVersion = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setSystemVersion(String paramString)
  {
    this.systemVersion = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\EncryptedSourceParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */