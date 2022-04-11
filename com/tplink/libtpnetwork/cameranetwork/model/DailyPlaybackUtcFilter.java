package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;

public final class DailyPlaybackUtcFilter
{
  private final int channel;
  @c("end_index")
  private final int endIndex;
  @c("end_time")
  private long endTime;
  private final int id;
  @c("start_index")
  private final int startIndex;
  @c("start_time")
  private final long startTime;
  
  public DailyPlaybackUtcFilter(int paramInt, long paramLong1, long paramLong2)
  {
    this(paramInt, paramLong1, paramLong2, 0, 0, 99);
  }
  
  public DailyPlaybackUtcFilter(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramLong1, paramLong2, 0, paramInt2, paramInt3);
  }
  
  public DailyPlaybackUtcFilter(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.id = paramInt1;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.channel = paramInt2;
    this.startIndex = paramInt3;
    this.endIndex = paramInt4;
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final long component2()
  {
    return this.startTime;
  }
  
  public final long component3()
  {
    return this.endTime;
  }
  
  public final int component4()
  {
    return this.channel;
  }
  
  public final int component5()
  {
    return this.startIndex;
  }
  
  public final int component6()
  {
    return this.endIndex;
  }
  
  public final DailyPlaybackUtcFilter copy(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    return new DailyPlaybackUtcFilter(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DailyPlaybackUtcFilter))
      {
        paramObject = (DailyPlaybackUtcFilter)paramObject;
        if ((this.id == ((DailyPlaybackUtcFilter)paramObject).id) && (this.startTime == ((DailyPlaybackUtcFilter)paramObject).startTime) && (this.endTime == ((DailyPlaybackUtcFilter)paramObject).endTime) && (this.channel == ((DailyPlaybackUtcFilter)paramObject).channel) && (this.startIndex == ((DailyPlaybackUtcFilter)paramObject).startIndex) && (this.endIndex == ((DailyPlaybackUtcFilter)paramObject).endIndex)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getChannel()
  {
    return this.channel;
  }
  
  public final int getEndIndex()
  {
    return this.endIndex;
  }
  
  public final long getEndTime()
  {
    return this.endTime;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final int getStartIndex()
  {
    return this.startIndex;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  public int hashCode()
  {
    int i = this.id;
    long l = this.startTime;
    int j = (int)(l ^ l >>> 32);
    l = this.endTime;
    return ((((i * 31 + j) * 31 + (int)(l ^ l >>> 32)) * 31 + this.channel) * 31 + this.startIndex) * 31 + this.endIndex;
  }
  
  public final void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DailyPlaybackUtcFilter(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", channel=");
    localStringBuilder.append(this.channel);
    localStringBuilder.append(", startIndex=");
    localStringBuilder.append(this.startIndex);
    localStringBuilder.append(", endIndex=");
    localStringBuilder.append(this.endIndex);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DailyPlaybackUtcFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */