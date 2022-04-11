package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;
import java.io.Serializable;

public class LedNightModeBean
  implements Serializable
{
  @c("end_time")
  private Integer endTime;
  @c("night_mode_type")
  private String nightModeType;
  @c("start_time")
  private Integer startTime;
  @c("sunrise_offset")
  private Integer sunriseOffset;
  @c("sunset_offset")
  private Integer sunsetOffset;
  
  public Integer getEndTime()
  {
    return this.endTime;
  }
  
  public String getNightModeType()
  {
    return this.nightModeType;
  }
  
  public Integer getStartTime()
  {
    return this.startTime;
  }
  
  public int getSunriseOffset()
  {
    Integer localInteger = this.sunriseOffset;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.intValue();
    }
    return i;
  }
  
  public int getSunsetOffset()
  {
    Integer localInteger = this.sunsetOffset;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.intValue();
    }
    return i;
  }
  
  public void setEndTime(Integer paramInteger)
  {
    this.endTime = paramInteger;
  }
  
  public void setNightModeType(String paramString)
  {
    this.nightModeType = paramString;
  }
  
  public void setStartTime(Integer paramInteger)
  {
    this.startTime = paramInteger;
  }
  
  public void setSunriseOffset(Integer paramInteger)
  {
    this.sunriseOffset = paramInteger;
  }
  
  public void setSunsetOffset(Integer paramInteger)
  {
    this.sunsetOffset = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\result\LedNightModeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */