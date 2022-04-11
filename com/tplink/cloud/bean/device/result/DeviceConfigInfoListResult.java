package com.tplink.cloud.bean.device.result;

import java.util.ArrayList;
import java.util.List;

public class DeviceConfigInfoListResult
{
  private List<DeviceConfigInfoResult> deviceConfigInfo = new ArrayList();
  
  public List<DeviceConfigInfoResult> getDeviceConfigInfo()
  {
    return this.deviceConfigInfo;
  }
  
  public void setDeviceConfigInfo(List<DeviceConfigInfoResult> paramList)
  {
    this.deviceConfigInfo = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceConfigInfoListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */