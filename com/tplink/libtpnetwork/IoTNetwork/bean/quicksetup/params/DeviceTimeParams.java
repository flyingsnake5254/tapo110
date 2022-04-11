package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.c;

public class DeviceTimeParams
{
  private Integer latitude;
  private Integer longitude;
  private String region;
  @c("time_diff")
  private int timeDiff;
  private long timestamp;
  
  public DeviceTimeParams() {}
  
  public DeviceTimeParams(long paramLong, int paramInt, String paramString)
  {
    this.timestamp = paramLong;
    this.timeDiff = paramInt;
    this.region = paramString;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public int getTimeDiff()
  {
    return this.timeDiff;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setTimeDiff(int paramInt)
  {
    this.timeDiff = paramInt;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\params\DeviceTimeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */