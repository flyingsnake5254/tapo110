package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;
import java.util.List;

public class ThingEnergyUsage
{
  @c("current_power")
  private int currentPower;
  @c("local_time")
  private String localTime;
  @c("month_energy")
  private int monthEnergy;
  @c("month_runtime")
  private int monthRuntime;
  private List<Integer> past1y;
  private List<Integer> past24h;
  private List<Integer> past30d;
  private List<List<Integer>> past7d;
  @c("today_energy")
  private int todayEnergy;
  @c("today_runtime")
  private int todayRuntime;
  
  public int getCurrentPower()
  {
    return this.currentPower;
  }
  
  public String getLocalTime()
  {
    return this.localTime;
  }
  
  public int getMonthEnergy()
  {
    return this.monthEnergy;
  }
  
  public int getMonthRuntime()
  {
    return this.monthRuntime;
  }
  
  public List<Integer> getPast1y()
  {
    return this.past1y;
  }
  
  public List<Integer> getPast24h()
  {
    return this.past24h;
  }
  
  public List<Integer> getPast30d()
  {
    return this.past30d;
  }
  
  public List<List<Integer>> getPast7d()
  {
    return this.past7d;
  }
  
  public int getTodayEnergy()
  {
    return this.todayEnergy;
  }
  
  public int getTodayRuntime()
  {
    return this.todayRuntime;
  }
  
  public void setCurrentPower(int paramInt)
  {
    this.currentPower = paramInt;
  }
  
  public void setLocalTime(String paramString)
  {
    this.localTime = paramString;
  }
  
  public void setMonthEnergy(int paramInt)
  {
    this.monthEnergy = paramInt;
  }
  
  public void setMonthRuntime(int paramInt)
  {
    this.monthRuntime = paramInt;
  }
  
  public void setPast1y(List<Integer> paramList)
  {
    this.past1y = paramList;
  }
  
  public void setPast24h(List<Integer> paramList)
  {
    this.past24h = paramList;
  }
  
  public void setPast30d(List<Integer> paramList)
  {
    this.past30d = paramList;
  }
  
  public void setPast7d(List<List<Integer>> paramList)
  {
    this.past7d = paramList;
  }
  
  public void setTodayEnergy(int paramInt)
  {
    this.todayEnergy = paramInt;
  }
  
  public void setTodayRuntime(int paramInt)
  {
    this.todayRuntime = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingEnergyUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */