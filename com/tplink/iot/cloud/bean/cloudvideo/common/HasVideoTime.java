package com.tplink.iot.cloud.bean.cloudvideo.common;

public class HasVideoTime
{
  private String deviceLocalTime;
  private long utcTime;
  
  public String getDeviceLocalTime()
  {
    return this.deviceLocalTime;
  }
  
  public long getUtcTime()
  {
    return this.utcTime;
  }
  
  public void setDeviceLocalTime(String paramString)
  {
    this.deviceLocalTime = paramString;
  }
  
  public void setUtcTime(long paramLong)
  {
    this.utcTime = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\HasVideoTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */