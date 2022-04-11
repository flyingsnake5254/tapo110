package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;
import java.util.List;

public class ThingTemperatureRecords
{
  @c("current_temp")
  private float currentTemp;
  @c("local_time")
  private long localTime;
  private List<Integer> today;
  @c("today_status")
  private List<Integer> todayStatus;
  private List<Integer> yesterday;
  @c("yesterday_status")
  private List<Integer> yesterdayStatus;
  
  public float getCurrentTemp()
  {
    return this.currentTemp;
  }
  
  public long getLocalTime()
  {
    return this.localTime;
  }
  
  public List<Integer> getToday()
  {
    return this.today;
  }
  
  public List<Integer> getTodayStatus()
  {
    return this.todayStatus;
  }
  
  public List<Integer> getYesterday()
  {
    return this.yesterday;
  }
  
  public List<Integer> getYesterdayStatus()
  {
    return this.yesterdayStatus;
  }
  
  public void setCurrentTemp(float paramFloat)
  {
    this.currentTemp = paramFloat;
  }
  
  public void setLocalTime(long paramLong)
  {
    this.localTime = paramLong;
  }
  
  public void setToday(List<Integer> paramList)
  {
    this.today = paramList;
  }
  
  public void setTodayStatus(List<Integer> paramList)
  {
    this.todayStatus = paramList;
  }
  
  public void setYesterday(List<Integer> paramList)
  {
    this.yesterday = paramList;
  }
  
  public void setYesterdayStatus(List<Integer> paramList)
  {
    this.yesterdayStatus = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingTemperatureRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */