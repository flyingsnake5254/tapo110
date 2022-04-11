package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.enumerate.RuleMode;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.Utils.i;
import java.io.Serializable;

public class ScheduleRuleBean
  implements Serializable
{
  private int day;
  @c("desired_states")
  private DesiredStatesBean desiredStates;
  private boolean enable;
  @c("e_action")
  @Deprecated
  private String endAction;
  @c("e_min")
  private int endTimeMin;
  @c("e_type")
  private RuleTimeType endTimeType;
  private String id;
  private transient boolean isDeleting;
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
  
  public ScheduleRuleBean()
  {
    RuleTimeType localRuleTimeType = RuleTimeType.NONE;
    this.startTimeType = localRuleTimeType;
    this.endTimeType = localRuleTimeType;
    this.mode = RuleMode.ONCE;
  }
  
  public ScheduleRuleBean(ThingRuleSchedule paramThingRuleSchedule)
  {
    RuleTimeType localRuleTimeType = RuleTimeType.NONE;
    this.startTimeType = localRuleTimeType;
    this.endTimeType = localRuleTimeType;
    this.mode = RuleMode.ONCE;
    if (paramThingRuleSchedule == null) {
      return;
    }
    setId(paramThingRuleSchedule.getId());
    setEnable(paramThingRuleSchedule.isEnable());
    setStartTimeType(paramThingRuleSchedule.getStartTimeType());
    setStartTimeMin(paramThingRuleSchedule.getStartTimeMin());
    setStartAction(paramThingRuleSchedule.getStartAction());
    setEndTimeType(paramThingRuleSchedule.getEndTimeType());
    setEndTimeMin(paramThingRuleSchedule.getEndTimeMin());
    setEndAction(paramThingRuleSchedule.getEndAction());
    setMode(paramThingRuleSchedule.getMode());
    setWeekOfDays(paramThingRuleSchedule.getWeekOfDays());
    setYear(paramThingRuleSchedule.getYear());
    setMonth(paramThingRuleSchedule.getMonth());
    setDay(paramThingRuleSchedule.getDay());
    setTimeOffset(paramThingRuleSchedule.getTimeOffset());
    paramThingRuleSchedule = paramThingRuleSchedule.getDesiredStates();
    if (paramThingRuleSchedule != null) {
      this.desiredStates = ((DesiredStatesBean)i.a(i.i(paramThingRuleSchedule), DesiredStatesBean.class));
    }
  }
  
  public void cloneOther(ScheduleRuleBean paramScheduleRuleBean)
  {
    setId(paramScheduleRuleBean.getId());
    setEnable(paramScheduleRuleBean.isEnable());
    setStartTimeType(paramScheduleRuleBean.getStartTimeType());
    setStartTimeMin(paramScheduleRuleBean.getStartTimeMin());
    setStartAction(paramScheduleRuleBean.getStartAction());
    setEndTimeType(paramScheduleRuleBean.getEndTimeType());
    setEndTimeMin(paramScheduleRuleBean.getEndTimeMin());
    setEndAction(paramScheduleRuleBean.getEndAction());
    setMode(paramScheduleRuleBean.getMode());
    setWeekOfDays(paramScheduleRuleBean.getWeekOfDays());
    setYear(paramScheduleRuleBean.getYear());
    setMonth(paramScheduleRuleBean.getMonth());
    setDay(paramScheduleRuleBean.getDay());
    setTimeOffset(paramScheduleRuleBean.getTimeOffset());
    setDesiredStates(paramScheduleRuleBean.getDesiredStates());
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public DesiredStatesBean getDesiredStates()
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
  
  public boolean isActionOn()
  {
    return "on".equalsIgnoreCase(getStartAction());
  }
  
  public boolean isDeleting()
  {
    return this.isDeleting;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public boolean isRepeat()
  {
    boolean bool;
    if (getMode() == RuleMode.REPEAT) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }
  
  public void setDeleting(boolean paramBoolean)
  {
    this.isDeleting = paramBoolean;
  }
  
  public void setDesiredStates(DesiredStatesBean paramDesiredStatesBean)
  {
    this.desiredStates = paramDesiredStatesBean;
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
  
  public void setRepeat(boolean paramBoolean)
  {
    RuleMode localRuleMode;
    if (paramBoolean) {
      localRuleMode = RuleMode.REPEAT;
    } else {
      localRuleMode = RuleMode.ONCE;
    }
    setMode(localRuleMode);
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
  
  public ThingRuleSchedule toThingRuleSchedule()
  {
    ThingRuleSchedule localThingRuleSchedule = new ThingRuleSchedule(this.enable, this.startTimeType, this.startTimeMin, this.endTimeType, this.endTimeMin, this.weekOfDays, this.mode);
    localThingRuleSchedule.setId(this.id);
    localThingRuleSchedule.setMonth(this.month);
    localThingRuleSchedule.setYear(this.year);
    localThingRuleSchedule.setDay(this.day);
    localThingRuleSchedule.setTimeOffset(this.timeOffset);
    localThingRuleSchedule.setEndAction(this.endAction);
    localThingRuleSchedule.setStartAction(this.startAction);
    DesiredStatesBean localDesiredStatesBean = this.desiredStates;
    if (localDesiredStatesBean != null) {
      localThingRuleSchedule.setDesiredStates(localDesiredStatesBean.toMap());
    }
    return localThingRuleSchedule;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\ScheduleRuleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */