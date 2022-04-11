package com.tplink.cloud.bean.account.params;

public class CheckPasswordParams
{
  private String cloudPassword;
  private String cloudUserName;
  
  public CheckPasswordParams() {}
  
  public CheckPasswordParams(String paramString1, String paramString2)
  {
    this.cloudUserName = paramString1;
    this.cloudPassword = paramString2;
  }
  
  public String getCloudPassword()
  {
    return this.cloudPassword;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public void setCloudPassword(String paramString)
  {
    this.cloudPassword = paramString;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\CheckPasswordParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */