package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

public class ThingRuleGuardMode
{
  @b(MapJsonAdapter.class)
  @c("alarm_time")
  private Map<String, Object> alarmTime;
  @c("alarm_type")
  private String alarmType;
  @c("alarm_volume")
  private String alarmVolume;
  @c("device_id_list")
  private List<String> deviceIdList;
  private String id;
  
  public ThingRuleGuardMode(String paramString1, List<String> paramList, String paramString2, String paramString3, Map<String, Object> paramMap)
  {
    this.id = paramString1;
    this.deviceIdList = paramList;
    this.alarmType = paramString2;
    this.alarmVolume = paramString3;
    this.alarmTime = paramMap;
  }
  
  public Map<String, Object> getAlarmTime()
  {
    return this.alarmTime;
  }
  
  public String getAlarmType()
  {
    return this.alarmType;
  }
  
  public String getAlarmVolume()
  {
    return this.alarmVolume;
  }
  
  public List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public void setAlarmTime(Map<String, Object> paramMap)
  {
    this.alarmTime = paramMap;
  }
  
  public void setAlarmType(String paramString)
  {
    this.alarmType = paramString;
  }
  
  public void setAlarmVolume(String paramString)
  {
    this.alarmVolume = paramString;
  }
  
  public void setDeviceIdList(List<String> paramList)
  {
    this.deviceIdList = paramList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GuardMode
  {
    public static final String AWAY = "away";
    public static final String HOME = "home";
    public static final String SLEEP = "sleep";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRuleGuardMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */