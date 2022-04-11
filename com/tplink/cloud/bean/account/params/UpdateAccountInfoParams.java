package com.tplink.cloud.bean.account.params;

public class UpdateAccountInfoParams
{
  private String cloudUserName;
  private String countryCode;
  private String nickname;
  
  public UpdateAccountInfoParams() {}
  
  public UpdateAccountInfoParams(String paramString1, String paramString2)
  {
    this.cloudUserName = paramString1;
    this.nickname = paramString2;
  }
  
  public UpdateAccountInfoParams(String paramString1, String paramString2, String paramString3)
  {
    this.cloudUserName = paramString1;
    this.nickname = paramString2;
    this.countryCode = paramString3;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setCountryCode(String paramString)
  {
    this.countryCode = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\UpdateAccountInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */