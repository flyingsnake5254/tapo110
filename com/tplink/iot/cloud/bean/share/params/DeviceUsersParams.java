package com.tplink.iot.cloud.bean.share.params;

import java.util.List;

public class DeviceUsersParams
{
  private boolean isSubThing;
  private String ownerAccount;
  private List<UserAccountBean> userAccountList;
  
  public DeviceUsersParams() {}
  
  public DeviceUsersParams(String paramString, List<UserAccountBean> paramList, boolean paramBoolean)
  {
    this.ownerAccount = paramString;
    this.userAccountList = paramList;
    this.isSubThing = paramBoolean;
  }
  
  public String getOwnerAccount()
  {
    return this.ownerAccount;
  }
  
  public List<UserAccountBean> getUserAccountList()
  {
    return this.userAccountList;
  }
  
  public boolean isSubThing()
  {
    return this.isSubThing;
  }
  
  public void setOwnerAccount(String paramString)
  {
    this.ownerAccount = paramString;
  }
  
  public void setSubThing(boolean paramBoolean)
  {
    this.isSubThing = paramBoolean;
  }
  
  public void setUserAccountList(List<UserAccountBean> paramList)
  {
    this.userAccountList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\params\DeviceUsersParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */