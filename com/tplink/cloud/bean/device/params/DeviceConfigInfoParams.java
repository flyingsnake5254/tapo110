package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceConfigInfoParams
{
  private boolean avatarNeeded;
  private List<String> deviceIdList;
  
  public DeviceConfigInfoParams() {}
  
  public DeviceConfigInfoParams(List<String> paramList, boolean paramBoolean)
  {
    this.deviceIdList = paramList;
    this.avatarNeeded = paramBoolean;
  }
  
  public List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public boolean isAvatarNeeded()
  {
    return this.avatarNeeded;
  }
  
  public void setAvatarNeeded(boolean paramBoolean)
  {
    this.avatarNeeded = paramBoolean;
  }
  
  public void setDeviceIdList(List<String> paramList)
  {
    this.deviceIdList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceConfigInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */