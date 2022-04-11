package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class LastAlarmInfo
{
  @c("last_alarm_time")
  private final String alarmTime;
  @c("last_alarm_type")
  private final String alarmType;
  
  public LastAlarmInfo(String paramString1, String paramString2)
  {
    this.alarmType = paramString1;
    this.alarmTime = paramString2;
  }
  
  public final String component1()
  {
    return this.alarmType;
  }
  
  public final String component2()
  {
    return this.alarmTime;
  }
  
  public final LastAlarmInfo copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "alarmType");
    j.e(paramString2, "alarmTime");
    return new LastAlarmInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LastAlarmInfo))
      {
        paramObject = (LastAlarmInfo)paramObject;
        if ((j.a(this.alarmType, ((LastAlarmInfo)paramObject).alarmType)) && (j.a(this.alarmTime, ((LastAlarmInfo)paramObject).alarmTime))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getAlarmTime()
  {
    return this.alarmTime;
  }
  
  public final String getAlarmType()
  {
    return this.alarmType;
  }
  
  public int hashCode()
  {
    String str = this.alarmType;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.alarmTime;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LastAlarmInfo(alarmType=");
    localStringBuilder.append(this.alarmType);
    localStringBuilder.append(", alarmTime=");
    localStringBuilder.append(this.alarmTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\LastAlarmInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */