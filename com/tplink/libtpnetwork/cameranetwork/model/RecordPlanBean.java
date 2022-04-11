package com.tplink.libtpnetwork.cameranetwork.model;

import androidx.annotation.NonNull;

public class RecordPlanBean
  implements Comparable<RecordPlanBean>
{
  public static final int PLAYBACK_VIDEO_TYPE_COMMON = 1;
  public static final int PLAYBACK_VIDEO_TYPE_MOTION = 2;
  private int dayIndex;
  private int endTime;
  private int recordType;
  private int startTime;
  
  public RecordPlanBean(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.recordType = paramInt1;
    this.dayIndex = paramInt2;
    this.startTime = paramInt3;
    this.endTime = paramInt4;
  }
  
  public int compareTo(@NonNull RecordPlanBean paramRecordPlanBean)
  {
    return getStartTime() - paramRecordPlanBean.getStartTime();
  }
  
  public boolean contains(int paramInt)
  {
    return (this.startTime < paramInt) && (this.endTime > paramInt);
  }
  
  public boolean containsWithEqual(int paramInt)
  {
    return (this.startTime <= paramInt) && (this.endTime >= paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (RecordPlanBean)paramObject;
      if (this.recordType != ((RecordPlanBean)paramObject).recordType) {
        return false;
      }
      if (this.dayIndex != ((RecordPlanBean)paramObject).dayIndex) {
        return false;
      }
      if (this.startTime != ((RecordPlanBean)paramObject).startTime) {
        return false;
      }
      if (this.endTime != ((RecordPlanBean)paramObject).endTime) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int getDayIndex()
  {
    return this.dayIndex;
  }
  
  public int getEndTime()
  {
    return this.endTime;
  }
  
  public int getRecordType()
  {
    return this.recordType;
  }
  
  public int getStartTime()
  {
    return this.startTime;
  }
  
  public int hashCode()
  {
    return ((this.recordType * 31 + this.dayIndex) * 31 + this.startTime) * 31 + this.endTime;
  }
  
  public void setDayIndex(int paramInt)
  {
    this.dayIndex = paramInt;
  }
  
  public void setEndTime(int paramInt)
  {
    this.endTime = paramInt;
  }
  
  public void setRecordType(int paramInt)
  {
    this.recordType = paramInt;
  }
  
  public void setStartTime(int paramInt)
  {
    this.startTime = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordPlanBean{recordType=");
    localStringBuilder.append(this.recordType);
    localStringBuilder.append(", dayIndex=");
    localStringBuilder.append(this.dayIndex);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\RecordPlanBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */