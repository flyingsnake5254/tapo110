package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class ClockStatus
{
  @c("local_time")
  private final String localTime;
  @c("seconds_from_1970")
  private final long seconds;
  
  public ClockStatus(long paramLong, String paramString)
  {
    this.seconds = paramLong;
    this.localTime = paramString;
  }
  
  public final long component1()
  {
    return this.seconds;
  }
  
  public final String component2()
  {
    return this.localTime;
  }
  
  public final ClockStatus copy(long paramLong, String paramString)
  {
    j.e(paramString, "localTime");
    return new ClockStatus(paramLong, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClockStatus))
      {
        paramObject = (ClockStatus)paramObject;
        if ((this.seconds == ((ClockStatus)paramObject).seconds) && (j.a(this.localTime, ((ClockStatus)paramObject).localTime))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getLocalTime()
  {
    return this.localTime;
  }
  
  public final long getSeconds()
  {
    return this.seconds;
  }
  
  public int hashCode()
  {
    long l = this.seconds;
    int i = (int)(l ^ l >>> 32);
    String str = this.localTime;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClockStatus(seconds=");
    localStringBuilder.append(this.seconds);
    localStringBuilder.append(", localTime=");
    localStringBuilder.append(this.localTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ClockStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */