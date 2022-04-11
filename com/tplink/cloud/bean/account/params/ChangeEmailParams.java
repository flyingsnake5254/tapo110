package com.tplink.cloud.bean.account.params;

public class ChangeEmailParams
{
  private String cloudPassword;
  private String cloudUserName;
  private String locale;
  private String newEmail;
  
  public ChangeEmailParams() {}
  
  public ChangeEmailParams(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.cloudUserName = paramString1;
    this.cloudPassword = paramString2;
    this.newEmail = paramString3;
    this.locale = paramString4;
  }
  
  public String getCloudPassword()
  {
    return this.cloudPassword;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getNewEmail()
  {
    return this.newEmail;
  }
  
  public void setCloudPassword(String paramString)
  {
    this.cloudPassword = paramString;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setNewEmail(String paramString)
  {
    this.newEmail = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\ChangeEmailParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */