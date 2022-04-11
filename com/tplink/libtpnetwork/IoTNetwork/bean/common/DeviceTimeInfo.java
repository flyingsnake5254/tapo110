package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.google.gson.q.c;

public class DeviceTimeInfo
{
  private String region;
  @c("time_diff")
  private int timeDiff;
  private long timestamp;
  
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\DeviceTimeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */