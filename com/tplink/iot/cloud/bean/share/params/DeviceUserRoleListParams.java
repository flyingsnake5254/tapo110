package com.tplink.iot.cloud.bean.share.params;

import java.util.List;

public class DeviceUserRoleListParams
{
  private List<DeviceUserRoleParams> things;
  private String userAccount;
  
  public DeviceUserRoleListParams() {}
  
  public DeviceUserRoleListParams(String paramString, List<DeviceUserRoleParams> paramList)
  {
    this.userAccount = paramString;
    this.things = paramList;
  }
  
  public List<DeviceUserRoleParams> getThings()
  {
    return this.things;
  }
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public void setThings(List<DeviceUserRoleParams> paramList)
  {
    this.things = paramList;
  }
  
  public void setUserAccount(String paramString)
  {
    this.userAccount = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\params\DeviceUserRoleListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */