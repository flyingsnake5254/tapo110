package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceUsersParams
{
  private String deviceId;
  private String ownerAccount;
  private List<String> userAccountList;
  
  public DeviceUsersParams() {}
  
  public DeviceUsersParams(String paramString1, String paramString2, List<String> paramList)
  {
    this.deviceId = paramString1;
    this.ownerAccount = paramString2;
    this.userAccountList = paramList;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getOwnerAccount()
  {
    return this.ownerAccount;
  }
  
  public List<String> getUserAccountList()
  {
    return this.userAccountList;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setOwnerAccount(String paramString)
  {
    this.ownerAccount = paramString;
  }
  
  public void setUserAccountList(List<String> paramList)
  {
    this.userAccountList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceUsersParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */