package com.tplink.iot.cloud.bean.share.result;

import com.tplink.iot.cloud.bean.share.common.DeviceShareUserInfo;
import java.util.List;

public class DeviceShareUserInfoListResult
{
  private int margin;
  private List<DeviceShareUserInfo> userList;
  
  public int getMargin()
  {
    return this.margin;
  }
  
  public List<DeviceShareUserInfo> getUserList()
  {
    return this.userList;
  }
  
  public void setMargin(int paramInt)
  {
    this.margin = paramInt;
  }
  
  public void setUserList(List<DeviceShareUserInfo> paramList)
  {
    this.userList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\result\DeviceShareUserInfoListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */