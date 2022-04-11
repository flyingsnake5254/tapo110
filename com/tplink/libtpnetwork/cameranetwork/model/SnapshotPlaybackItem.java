package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class SnapshotPlaybackItem
{
  @c("end_time")
  private final long endTime;
  @c("file_id")
  private final String fileId;
  @c("start_time")
  private final long startTime;
  @c("alarm_type")
  private final int type;
  
  public SnapshotPlaybackItem(long paramLong1, long paramLong2, int paramInt)
  {
    this(paramLong1, paramLong2, paramInt, String.valueOf(paramLong1));
  }
  
  public SnapshotPlaybackItem(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.type = paramInt;
    this.fileId = paramString;
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
    return this.type;
  }
  
  public final String component4()
  {
    return this.fileId;
  }
  
  public final SnapshotPlaybackItem copy(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    j.e(paramString, "fileId");
    return new SnapshotPlaybackItem(paramLong1, paramLong2, paramInt, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SnapshotPlaybackItem))
      {
        paramObject = (SnapshotPlaybackItem)paramObject;
        if ((this.startTime == ((SnapshotPlaybackItem)paramObject).startTime) && (this.endTime == ((SnapshotPlaybackItem)paramObject).endTime) && (this.type == ((SnapshotPlaybackItem)paramObject).type) && (j.a(this.fileId, ((SnapshotPlaybackItem)paramObject).fileId))) {}
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
  
  public final String getFileId()
  {
    return this.fileId;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    long l = this.startTime;
    int i = (int)(l ^ l >>> 32);
    l = this.endTime;
    int j = (int)(l ^ l >>> 32);
    int k = this.type;
    String str = this.fileId;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SnapshotPlaybackItem(startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", fileId=");
    localStringBuilder.append(this.fileId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SnapshotPlaybackItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */