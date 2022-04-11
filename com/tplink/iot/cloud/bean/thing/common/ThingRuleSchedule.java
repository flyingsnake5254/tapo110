package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import com.tplink.iot.cloud.enumerate.RuleMode;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import java.util.Map;

public class ThingRuleSchedule
{
  private int day;
  @b(MapJsonAdapter.class)
  @c("desired_states")
  private Map<String, Object> desiredStates;
  private boolean enable;
  @c("e_action")
  @Deprecated
  private String endAction;
  @c("e_min")
  private int endTimeMin;
  @c("e_type")
  private RuleTimeType endTimeType;
  private String id;
  private RuleMode mode;
  private int month;
  @c("s_action")
  @Deprecated
  private String startAction;
  @c("s_min")
  private int startTimeMin;
  @c("s_type")
  private RuleTimeType startTimeType;
  @c("time_offset")
  private int timeOffset;
  @c("week_day")
  private byte weekOfDays;
  private int year;
  
  public ThingRuleSchedule()
  {
    RuleTimeType localRuleTimeType = RuleTimeType.NONE;
    this.startTimeType = localRuleTimeType;
    this.endTimeType = localRuleTimeType;
    this.mode = RuleMode.ONCE;
  }
  
  public ThingRuleSchedule(boolean paramBoolean, RuleTimeType paramRuleTimeType1, int paramInt1, RuleTimeType paramRuleTimeType2, int paramInt2, byte paramByte, RuleMode paramRuleMode)
  {
    RuleTimeType localRuleTimeType = RuleTimeType.NONE;
    this.startTimeType = localRuleTimeType;
    this.endTimeType = localRuleTimeType;
    this.mode = RuleMode.ONCE;
    this.enable = paramBoolean;
    this.startTimeType = paramRuleTimeType1;
    this.startTimeMin = paramInt1;
    this.endTimeType = paramRuleTimeType2;
    this.endTimeMin = paramInt2;
    this.weekOfDays = ((byte)paramByte);
    this.mode = paramRuleMode;
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public Map<String, Object> getDesiredStates()
  {
    return this.desiredStates;
  }
  
  public String getEndAction()
  {
    return this.endAction;
  }
  
  public int getEndTimeMin()
  {
    return this.endTimeMin;
  }
  
  public RuleTimeType getEndTimeType()
  {
    return this.endTimeType;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public RuleMode getMode()
  {
    return this.mode;
  }
  
  public int getMonth()
  {
    return this.month;
  }
  
  public String getStartAction()
  {
    return this.startAction;
  }
  
  public int getStartTimeMin()
  {
    return this.startTimeMin;
  }
  
  public RuleTimeType getStartTimeType()
  {
    return this.startTimeType;
  }
  
  public int getTimeOffset()
  {
    return this.timeOffset;
  }
  
  public byte getWeekOfDays()
  {
    return this.weekOfDays;
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }
  
  public void setDesiredStates(Map<String, Object> paramMap)
  {
    this.desiredStates = paramMap;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setEndAction(String paramString)
  {
    this.endAction = paramString;
  }
  
  public void setEndTimeMin(int paramInt)
  {
    this.endTimeMin = paramInt;
  }
  
  public void setEndTimeType(RuleTimeType paramRuleTimeType)
  {
    this.endTimeType = paramRuleTimeType;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMode(RuleMode paramRuleMode)
  {
    this.mode = paramRuleMode;
  }
  
  public void setMonth(int paramInt)
  {
    this.month = paramInt;
  }
  
  public void setStartAction(String paramString)
  {
    this.startAction = paramString;
  }
  
  public void setStartTimeMin(int paramInt)
  {
    this.startTimeMin = paramInt;
  }
  
  public void setStartTimeType(RuleTimeType paramRuleTimeType)
  {
    this.startTimeType = paramRuleTimeType;
  }
  
  public void setTimeOffset(int paramInt)
  {
    this.timeOffset = paramInt;
  }
  
  public void setWeekOfDays(byte paramByte)
  {
    this.weekOfDays = ((byte)paramByte);
  }
  
  public void setYear(int paramInt)
  {
    this.year = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRuleSchedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */