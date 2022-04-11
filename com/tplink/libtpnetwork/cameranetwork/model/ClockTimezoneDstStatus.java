package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class ClockTimezoneDstStatus
{
  private ClockStatus clockStatus;
  private DstInfo dstInfo;
  private Timezone timezone;
  
  public ClockTimezoneDstStatus(ClockStatus paramClockStatus, Timezone paramTimezone, DstInfo paramDstInfo)
  {
    this.clockStatus = paramClockStatus;
    this.timezone = paramTimezone;
    this.dstInfo = paramDstInfo;
  }
  
  public final ClockStatus component1()
  {
    return this.clockStatus;
  }
  
  public final Timezone component2()
  {
    return this.timezone;
  }
  
  public final DstInfo component3()
  {
    return this.dstInfo;
  }
  
  public final ClockTimezoneDstStatus copy(ClockStatus paramClockStatus, Timezone paramTimezone, DstInfo paramDstInfo)
  {
    return new ClockTimezoneDstStatus(paramClockStatus, paramTimezone, paramDstInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClockTimezoneDstStatus))
      {
        paramObject = (ClockTimezoneDstStatus)paramObject;
        if ((j.a(this.clockStatus, ((ClockTimezoneDstStatus)paramObject).clockStatus)) && (j.a(this.timezone, ((ClockTimezoneDstStatus)paramObject).timezone)) && (j.a(this.dstInfo, ((ClockTimezoneDstStatus)paramObject).dstInfo))) {}
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
  
  public final DstInfo getDstInfo()
  {
    return this.dstInfo;
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
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.dstInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public final void setClockStatus(ClockStatus paramClockStatus)
  {
    this.clockStatus = paramClockStatus;
  }
  
  public final void setDstInfo(DstInfo paramDstInfo)
  {
    this.dstInfo = paramDstInfo;
  }
  
  public final void setTimezone(Timezone paramTimezone)
  {
    this.timezone = paramTimezone;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClockTimezoneDstStatus(clockStatus=");
    localStringBuilder.append(this.clockStatus);
    localStringBuilder.append(", timezone=");
    localStringBuilder.append(this.timezone);
    localStringBuilder.append(", dstInfo=");
    localStringBuilder.append(this.dstInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ClockTimezoneDstStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */