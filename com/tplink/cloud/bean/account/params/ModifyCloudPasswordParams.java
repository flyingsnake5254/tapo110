package com.tplink.cloud.bean.account.params;

public class ModifyCloudPasswordParams
{
  private String cloudUserName;
  private String newCloudPassword;
  private String oldCloudPassword;
  
  public ModifyCloudPasswordParams() {}
  
  public ModifyCloudPasswordParams(String paramString1, String paramString2, String paramString3)
  {
    this.cloudUserName = paramString1;
    this.oldCloudPassword = paramString2;
    this.newCloudPassword = paramString3;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getNewCloudPassword()
  {
    return this.newCloudPassword;
  }
  
  public String getOldCloudPassword()
  {
    return this.oldCloudPassword;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setNewCloudPassword(String paramString)
  {
    this.newCloudPassword = paramString;
  }
  
  public void setOldCloudPassword(String paramString)
  {
    this.oldCloudPassword = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\ModifyCloudPasswordParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */