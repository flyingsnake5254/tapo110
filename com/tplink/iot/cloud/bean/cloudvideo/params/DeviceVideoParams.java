package com.tplink.iot.cloud.bean.cloudvideo.params;

import java.util.List;

public class DeviceVideoParams
{
  private String deviceId;
  private List<String> uuid;
  
  public DeviceVideoParams(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public DeviceVideoParams(String paramString, List<String> paramList)
  {
    this.deviceId = paramString;
    this.uuid = paramList;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public List<String> getUuid()
  {
    return this.uuid;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setUuid(List<String> paramList)
  {
    this.uuid = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\params\DeviceVideoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */