package com.tplink.cloud.bean.account.params;

public class AppConfigInfoParams
  extends CloudUserParams
{
  private String appType;
  
  public AppConfigInfoParams() {}
  
  public AppConfigInfoParams(String paramString1, String paramString2)
  {
    super(paramString1);
    this.appType = paramString2;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\AppConfigInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */