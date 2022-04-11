package com.tplink.libtpnetwork.cameranetwork.model;

public final class Schedule
{
  private final int endHour;
  private final int endMinute;
  private final boolean isCrossTwoDays;
  private final boolean isEmpty;
  private final boolean isScheduleAllDay;
  private final boolean isScheduleBeforeDawn;
  private final boolean isScheduleDayTime;
  private final boolean isScheduleMidnight;
  private final int startHour;
  private final int startMinute;
  private final int type;
  
  public Schedule(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.startHour = paramInt1;
    this.startMinute = paramInt2;
    this.endHour = paramInt3;
    this.endMinute = paramInt4;
    this.type = paramInt5;
    boolean bool1 = true;
    boolean bool2;
    if ((paramInt1 == 0) && (paramInt3 == 24) && (paramInt2 == 0) && (paramInt4 == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.isScheduleAllDay = bool2;
    if ((paramInt1 == 8) && (paramInt3 == 20) && (paramInt2 == 0) && (paramInt4 == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.isScheduleDayTime = bool2;
    if ((paramInt1 == 20) && (paramInt3 == 24) && (paramInt2 == 0) && (paramInt4 == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.isScheduleMidnight = bool2;
    if ((paramInt1 == 0) && (paramInt3 == 8) && (paramInt2 == 0) && (paramInt4 == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.isScheduleBeforeDawn = bool2;
    if (paramInt1 * 60 + paramInt2 > paramInt3 * 60 + paramInt4) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.isCrossTwoDays = bool2;
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    this.isEmpty = bool2;
  }
  
  public final int component1()
  {
    return this.startHour;
  }
  
  public final int component2()
  {
    return this.startMinute;
  }
  
  public final int component3()
  {
    return this.endHour;
  }
  
  public final int component4()
  {
    return this.endMinute;
  }
  
  public final int component5()
  {
    return this.type;
  }
  
  public final Schedule copy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return new Schedule(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Schedule))
      {
        paramObject = (Schedule)paramObject;
        if ((this.startHour == ((Schedule)paramObject).startHour) && (this.startMinute == ((Schedule)paramObject).startMinute) && (this.endHour == ((Schedule)paramObject).endHour) && (this.endMinute == ((Schedule)paramObject).endMinute) && (this.type == ((Schedule)paramObject).type)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getEndHour()
  {
    return this.endHour;
  }
  
  public final int getEndMinute()
  {
    return this.endMinute;
  }
  
  public final int getStartHour()
  {
    return this.startHour;
  }
  
  public final int getStartMinute()
  {
    return this.startMinute;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return (((this.startHour * 31 + this.startMinute) * 31 + this.endHour) * 31 + this.endMinute) * 31 + this.type;
  }
  
  public final boolean isCrossTwoDays()
  {
    return this.isCrossTwoDays;
  }
  
  public final boolean isEmpty()
  {
    return this.isEmpty;
  }
  
  public final boolean isScheduleAllDay()
  {
    return this.isScheduleAllDay;
  }
  
  public final boolean isScheduleBeforeDawn()
  {
    return this.isScheduleBeforeDawn;
  }
  
  public final boolean isScheduleDayTime()
  {
    return this.isScheduleDayTime;
  }
  
  public final boolean isScheduleMidnight()
  {
    return this.isScheduleMidnight;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Schedule(startHour=");
    localStringBuilder.append(this.startHour);
    localStringBuilder.append(", startMinute=");
    localStringBuilder.append(this.startMinute);
    localStringBuilder.append(", endHour=");
    localStringBuilder.append(this.endHour);
    localStringBuilder.append(", endMinute=");
    localStringBuilder.append(this.endMinute);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Schedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */