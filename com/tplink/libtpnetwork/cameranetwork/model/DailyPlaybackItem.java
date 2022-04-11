package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class DailyPlaybackItem
{
  private final long endTime;
  private final long startTime;
  @c("vedio_type")
  private final String type;
  
  public DailyPlaybackItem(long paramLong1, long paramLong2, String paramString)
  {
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.type = paramString;
  }
  
  public final long component1()
  {
    return this.startTime;
  }
  
  public final long component2()
  {
    return this.endTime;
  }
  
  public final String component3()
  {
    return this.type;
  }
  
  public final DailyPlaybackItem copy(long paramLong1, long paramLong2, String paramString)
  {
    j.e(paramString, "type");
    return new DailyPlaybackItem(paramLong1, paramLong2, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DailyPlaybackItem))
      {
        paramObject = (DailyPlaybackItem)paramObject;
        if ((this.startTime == ((DailyPlaybackItem)paramObject).startTime) && (this.endTime == ((DailyPlaybackItem)paramObject).endTime) && (j.a(this.type, ((DailyPlaybackItem)paramObject).type))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getEndTime()
  {
    return this.endTime;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    long l = this.startTime;
    int i = (int)(l ^ l >>> 32);
    l = this.endTime;
    int j = (int)(l ^ l >>> 32);
    String str = this.type;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DailyPlaybackItem(startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DailyPlaybackItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */