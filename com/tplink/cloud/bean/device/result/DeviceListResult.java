package com.tplink.cloud.bean.device.result;

import java.util.ArrayList;
import java.util.List;

public class DeviceListResult
{
  private List<DeviceInfoResult> deviceList = new ArrayList();
  
  public List<DeviceInfoResult> getDeviceList()
  {
    return this.deviceList;
  }
  
  public void setDeviceList(List<DeviceInfoResult> paramList)
  {
    this.deviceList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */