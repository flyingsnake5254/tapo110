package com.tplink.iot.cloud.bean.share.device;

import java.util.List;

public class DeviceUserListResult
{
  private int margin;
  private List<DeviceUserInfoResult> userList;
  
  public int getMargin()
  {
    return this.margin;
  }
  
  public List<DeviceUserInfoResult> getUserList()
  {
    return this.userList;
  }
  
  public void setMargin(int paramInt)
  {
    this.margin = paramInt;
  }
  
  public void setUserList(List<DeviceUserInfoResult> paramList)
  {
    this.userList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\device\DeviceUserListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */