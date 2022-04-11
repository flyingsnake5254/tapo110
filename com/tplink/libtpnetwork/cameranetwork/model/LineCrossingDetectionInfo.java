package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class LineCrossingDetectionInfo
{
  private final ArmScheduleInfo armScheduleInfo;
  private final DetectionInfo detectionInfo;
  
  public LineCrossingDetectionInfo(DetectionInfo paramDetectionInfo, ArmScheduleInfo paramArmScheduleInfo)
  {
    this.detectionInfo = paramDetectionInfo;
    this.armScheduleInfo = paramArmScheduleInfo;
  }
  
  public LineCrossingDetectionInfo(Wrappers paramWrappers)
  {
    this((DetectionInfo)Model.typeCast(paramWrappers, localModule, Section.DETECTION), (ArmScheduleInfo)Model.typeCast(paramWrappers, localModule, Section.ARMING_SCHEDULE));
  }
  
  public final DetectionInfo component1()
  {
    return this.detectionInfo;
  }
  
  public final ArmScheduleInfo component2()
  {
    return this.armScheduleInfo;
  }
  
  public final LineCrossingDetectionInfo copy(DetectionInfo paramDetectionInfo, ArmScheduleInfo paramArmScheduleInfo)
  {
    return new LineCrossingDetectionInfo(paramDetectionInfo, paramArmScheduleInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LineCrossingDetectionInfo))
      {
        paramObject = (LineCrossingDetectionInfo)paramObject;
        if ((j.a(this.detectionInfo, ((LineCrossingDetectionInfo)paramObject).detectionInfo)) && (j.a(this.armScheduleInfo, ((LineCrossingDetectionInfo)paramObject).armScheduleInfo))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final ArmScheduleInfo getArmScheduleInfo()
  {
    return this.armScheduleInfo;
  }
  
  public final DetectionInfo getDetectionInfo()
  {
    return this.detectionInfo;
  }
  
  public int hashCode()
  {
    Object localObject = this.detectionInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.armScheduleInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LineCrossingDetectionInfo(detectionInfo=");
    localStringBuilder.append(this.detectionInfo);
    localStringBuilder.append(", armScheduleInfo=");
    localStringBuilder.append(this.armScheduleInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\LineCrossingDetectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */