package com.tplink.iot.view.quicksetup.base;

import java.io.Serializable;

public class DeviceLocationInfo
  implements Serializable
{
  private Integer latitude;
  private Integer longitude;
  
  public DeviceLocationInfo() {}
  
  public DeviceLocationInfo(Integer paramInteger1, Integer paramInteger2)
  {
    this.longitude = paramInteger1;
    this.latitude = paramInteger2;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\DeviceLocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */