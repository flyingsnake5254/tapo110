package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;

public final class SnapshotPlaybackFilter
{
  private final int channel;
  @c("end_index")
  private final int endIndex;
  @c("end_time")
  private long endTime;
  @c("start_index")
  private final int startIndex;
  @c("start_time")
  private final long startTime;
  
  public SnapshotPlaybackFilter(long paramLong1, long paramLong2)
  {
    this(paramLong1, paramLong2, 0, 0, 99);
  }
  
  public SnapshotPlaybackFilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this(paramLong1, paramLong2, 0, paramInt1, paramInt2);
  }
  
  public SnapshotPlaybackFilter(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.channel = paramInt1;
    this.startIndex = paramInt2;
    this.endIndex = paramInt3;
  }
  
  public final long component1()
  {
    return this.startTime;
  }
  
  public final long component2()
  {
    return this.endTime;
  }
  
  public final int component3()
  {
    return this.channel;
  }
  
  public final int component4()
  {
    return this.startIndex;
  }
  
  public final int component5()
  {
    return this.endIndex;
  }
  
  public final SnapshotPlaybackFilter copy(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    return new SnapshotPlaybackFilter(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SnapshotPlaybackFilter))
      {
        paramObject = (SnapshotPlaybackFilter)paramObject;
        if ((this.startTime == ((SnapshotPlaybackFilter)paramObject).startTime) && (this.endTime == ((SnapshotPlaybackFilter)paramObject).endTime) && (this.channel == ((SnapshotPlaybackFilter)paramObject).channel) && (this.startIndex == ((SnapshotPlaybackFilter)paramObject).startIndex) && (this.endIndex == ((SnapshotPlaybackFilter)paramObject).endIndex)) {}
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
    long l = this.startTime;
    int i = (int)(l ^ l >>> 32);
    l = this.endTime;
    return (((i * 31 + (int)(l ^ l >>> 32)) * 31 + this.channel) * 31 + this.startIndex) * 31 + this.endIndex;
  }
  
  public final void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SnapshotPlaybackFilter(startTime=");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SnapshotPlaybackFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */