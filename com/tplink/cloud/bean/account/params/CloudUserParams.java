package com.tplink.cloud.bean.account.params;

public class CloudUserParams
{
  private String cloudUserName;
  
  public CloudUserParams() {}
  
  public CloudUserParams(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\CloudUserParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */