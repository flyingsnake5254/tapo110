package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class MotionDetectionInfo
{
  private final MotionDetectConfig config;
  private final List<MotionDetectRegion> regions;
  
  public MotionDetectionInfo(MotionDetectConfig paramMotionDetectConfig, List<MotionDetectRegion> paramList)
  {
    this.config = paramMotionDetectConfig;
    this.regions = paramList;
  }
  
  public MotionDetectionInfo(Wrappers paramWrappers)
  {
    this(localMotionDetectConfig, paramWrappers);
  }
  
  public final MotionDetectConfig component1()
  {
    return this.config;
  }
  
  public final List<MotionDetectRegion> component2()
  {
    return this.regions;
  }
  
  public final MotionDetectionInfo copy(MotionDetectConfig paramMotionDetectConfig, List<MotionDetectRegion> paramList)
  {
    return new MotionDetectionInfo(paramMotionDetectConfig, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MotionDetectionInfo))
      {
        paramObject = (MotionDetectionInfo)paramObject;
        if ((j.a(this.config, ((MotionDetectionInfo)paramObject).config)) && (j.a(this.regions, ((MotionDetectionInfo)paramObject).regions))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final MotionDetectConfig getConfig()
  {
    return this.config;
  }
  
  public final List<MotionDetectRegion> getRegions()
  {
    return this.regions;
  }
  
  public int hashCode()
  {
    Object localObject = this.config;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.regions;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotionDetectionInfo(config=");
    localStringBuilder.append(this.config);
    localStringBuilder.append(", regions=");
    localStringBuilder.append(this.regions);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MotionDetectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */