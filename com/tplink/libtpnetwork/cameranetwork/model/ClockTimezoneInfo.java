package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class ClockTimezoneInfo
{
  private ClockStatus clockStatus;
  private Timezone timezone;
  
  public ClockTimezoneInfo(ClockStatus paramClockStatus, Timezone paramTimezone)
  {
    this.clockStatus = paramClockStatus;
    this.timezone = paramTimezone;
  }
  
  public final ClockStatus component1()
  {
    return this.clockStatus;
  }
  
  public final Timezone component2()
  {
    return this.timezone;
  }
  
  public final ClockTimezoneInfo copy(ClockStatus paramClockStatus, Timezone paramTimezone)
  {
    return new ClockTimezoneInfo(paramClockStatus, paramTimezone);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClockTimezoneInfo))
      {
        paramObject = (ClockTimezoneInfo)paramObject;
        if ((j.a(this.clockStatus, ((ClockTimezoneInfo)paramObject).clockStatus)) && (j.a(this.timezone, ((ClockTimezoneInfo)paramObject).timezone))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final ClockStatus getClockStatus()
  {
    return this.clockStatus;
  }
  
  public final Timezone getTimezone()
  {
    return this.timezone;
  }
  
  public int hashCode()
  {
    Object localObject = this.clockStatus;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.timezone;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setClockStatus(ClockStatus paramClockStatus)
  {
    this.clockStatus = paramClockStatus;
  }
  
  public final void setTimezone(Timezone paramTimezone)
  {
    this.timezone = paramTimezone;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClockTimezoneInfo(clockStatus=");
    localStringBuilder.append(this.clockStatus);
    localStringBuilder.append(", timezone=");
    localStringBuilder.append(this.timezone);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ClockTimezoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */