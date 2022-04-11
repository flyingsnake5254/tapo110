package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceUserRoleParams
{
  private List<String> deviceIdList;
  private String userAccount;
  
  public DeviceUserRoleParams() {}
  
  public DeviceUserRoleParams(List<String> paramList, String paramString)
  {
    this.deviceIdList = paramList;
    this.userAccount = paramString;
  }
  
  public List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public void setDeviceIdList(List<String> paramList)
  {
    this.deviceIdList = paramList;
  }
  
  public void setUserAccount(String paramString)
  {
    this.userAccount = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceUserRoleParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */