package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceFeatureParams
{
  private String cloudUserName;
  private List<String> deviceIdList;
  
  public DeviceFeatureParams() {}
  
  public DeviceFeatureParams(String paramString, List<String> paramList)
  {
    this.cloudUserName = paramString;
    this.deviceIdList = paramList;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setDeviceIdList(List<String> paramList)
  {
    this.deviceIdList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceFeatureParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */