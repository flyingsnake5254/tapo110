package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;
import java.util.List;

public class ThingSupportAlarm
{
  @c("alarm_type_list")
  private List<String> alarmTypeList;
  
  public List<String> getAlarmTypeList()
  {
    return this.alarmTypeList;
  }
  
  public void setAlarmTypeList(List<String> paramList)
  {
    this.alarmTypeList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingSupportAlarm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */