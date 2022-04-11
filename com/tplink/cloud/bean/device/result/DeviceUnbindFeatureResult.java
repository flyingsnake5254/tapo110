package com.tplink.cloud.bean.device.result;

import java.util.ArrayList;
import java.util.List;

public class DeviceUnbindFeatureResult
{
  private List<DeviceUnbindInfoResult> deviceIdList = new ArrayList();
  
  public List<DeviceUnbindInfoResult> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public void setDeviceIdList(List<DeviceUnbindInfoResult> paramList)
  {
    this.deviceIdList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceUnbindFeatureResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */