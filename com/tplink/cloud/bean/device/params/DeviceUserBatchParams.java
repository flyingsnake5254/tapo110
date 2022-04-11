package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceUserBatchParams
{
  private List<String> deviceIdList;
  private String ownerAccount;
  private String userAccount;
  
  public DeviceUserBatchParams() {}
  
  public DeviceUserBatchParams(List<String> paramList, String paramString1, String paramString2)
  {
    this.deviceIdList = paramList;
    this.ownerAccount = paramString1;
    this.userAccount = paramString2;
  }
  
  public List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public String getOwnerAccount()
  {
    return this.ownerAccount;
  }
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public void setDeviceIdList(List<String> paramList)
  {
    this.deviceIdList = paramList;
  }
  
  public void setOwnerAccount(String paramString)
  {
    this.ownerAccount = paramString;
  }
  
  public void setUserAccount(String paramString)
  {
    this.userAccount = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceUserBatchParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */