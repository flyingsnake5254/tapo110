package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceUserNumberLimitParams
{
  private List<String> deviceTypeList;
  
  public DeviceUserNumberLimitParams() {}
  
  public DeviceUserNumberLimitParams(List<String> paramList)
  {
    this.deviceTypeList = paramList;
  }
  
  public List<String> getDeviceTypeList()
  {
    return this.deviceTypeList;
  }
  
  public void setDeviceTypeList(List<String> paramList)
  {
    this.deviceTypeList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceUserNumberLimitParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */