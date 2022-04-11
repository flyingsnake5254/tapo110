package com.tplink.cloud.bean.update.params;

public class AppVersionParams
{
  private String appPackageName;
  private String locale;
  private String platform;
  
  public AppVersionParams() {}
  
  public AppVersionParams(String paramString1, String paramString2, String paramString3)
  {
    this.appPackageName = paramString1;
    this.platform = paramString2;
    this.locale = paramString3;
  }
  
  public String getAppPackageName()
  {
    return this.appPackageName;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public void setAppPackageName(String paramString)
  {
    this.appPackageName = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setPlatform(String paramString)
  {
    this.platform = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\update\params\AppVersionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */