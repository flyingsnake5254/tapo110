package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;
import com.tplink.iot.cloud.enumerate.RuleMode;
import com.tplink.iot.cloud.enumerate.RuleTimeType;

public class ThingRuleAwayMode
{
  private Integer day;
  private boolean enable;
  @c("end_min")
  private int endTimeMin;
  @c("end_time_offset")
  private int endTimeOffset;
  @c("end_time_type")
  private RuleTimeType endTimeType;
  private int frequency;
  private String id;
  private RuleMode mode;
  private Integer month;
  @c("start_min")
  private int startTimeMin;
  @c("start_time_offset")
  private int startTimeOffset;
  @c("start_time_type")
  private RuleTimeType startTimeType;
  @c("week_day")
  private byte weekOfDays;
  private Integer year;
  
  public ThingRuleAwayMode()
  {
    RuleTimeType localRuleTimeType = RuleTimeType.NONE;
    this.startTimeType = localRuleTimeType;
    this.endTimeType = localRuleTimeType;
    this.mode = RuleMode.ONCE;
  }
  
  public ThingRuleAwayMode(boolean paramBoolean, RuleTimeType paramRuleTimeType1, int paramInt1, RuleTimeType paramRuleTimeType2, int paramInt2, byte paramByte, int paramInt3, RuleMode paramRuleMode)
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
    this.frequency = paramInt3;
    this.mode = paramRuleMode;
  }
  
  public Integer getDay()
  {
    return this.day;
  }
  
  public int getEndTimeMin()
  {
    return this.endTimeMin;
  }
  
  public int getEndTimeOffset()
  {
    return this.endTimeOffset;
  }
  
  public RuleTimeType getEndTimeType()
  {
    return this.endTimeType;
  }
  
  public int getFrequency()
  {
    return this.frequency;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public RuleMode getMode()
  {
    return this.mode;
  }
  
  public Integer getMonth()
  {
    return this.month;
  }
  
  public int getStartTimeMin()
  {
    return this.startTimeMin;
  }
  
  public int getStartTimeOffset()
  {
    return this.startTimeOffset;
  }
  
  public RuleTimeType getStartTimeType()
  {
    return this.startTimeType;
  }
  
  public byte getWeekOfDays()
  {
    return this.weekOfDays;
  }
  
  public Integer getYear()
  {
    return this.year;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setDay(Integer paramInteger)
  {
    this.day = paramInteger;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setEndTimeMin(int paramInt)
  {
    this.endTimeMin = paramInt;
  }
  
  public void setEndTimeOffset(int paramInt)
  {
    this.endTimeOffset = paramInt;
  }
  
  public void setEndTimeType(RuleTimeType paramRuleTimeType)
  {
    this.endTimeType = paramRuleTimeType;
  }
  
  public void setFrequency(int paramInt)
  {
    this.frequency = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMode(RuleMode paramRuleMode)
  {
    this.mode = paramRuleMode;
  }
  
  public void setMonth(Integer paramInteger)
  {
    this.month = paramInteger;
  }
  
  public void setStartTimeMin(int paramInt)
  {
    this.startTimeMin = paramInt;
  }
  
  public void setStartTimeOffset(int paramInt)
  {
    this.startTimeOffset = paramInt;
  }
  
  public void setStartTimeType(RuleTimeType paramRuleTimeType)
  {
    this.startTimeType = paramRuleTimeType;
  }
  
  public void setWeekOfDays(byte paramByte)
  {
    this.weekOfDays = ((byte)paramByte);
  }
  
  public void setYear(Integer paramInteger)
  {
    this.year = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRuleAwayMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */