package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class DetectionList
{
  @c("search_detection_list")
  private final List<SnapshotPlaybackItem> detectionList;
  @c("snapshot_enable")
  private final Boolean snapshotEnable;
  
  public DetectionList(Wrappers paramWrappers)
  {
    this((Boolean)Model.typeCast(paramWrappers, localModule, Section.PLAYBACK_SNAPSHOT_ENABLE), (List)Model.typeCast(paramWrappers, localModule, Section.PLAYBACK_SNAPSHOT_LIST));
  }
  
  public DetectionList(Boolean paramBoolean, List<SnapshotPlaybackItem> paramList)
  {
    this.snapshotEnable = paramBoolean;
    this.detectionList = paramList;
  }
  
  public final Boolean component1()
  {
    return this.snapshotEnable;
  }
  
  public final List<SnapshotPlaybackItem> component2()
  {
    return this.detectionList;
  }
  
  public final DetectionList copy(Boolean paramBoolean, List<SnapshotPlaybackItem> paramList)
  {
    return new DetectionList(paramBoolean, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DetectionList))
      {
        paramObject = (DetectionList)paramObject;
        if ((j.a(this.snapshotEnable, ((DetectionList)paramObject).snapshotEnable)) && (j.a(this.detectionList, ((DetectionList)paramObject).detectionList))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<SnapshotPlaybackItem> getDetectionList()
  {
    return this.detectionList;
  }
  
  public final Boolean getSnapshotEnable()
  {
    return this.snapshotEnable;
  }
  
  public int hashCode()
  {
    Object localObject = this.snapshotEnable;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.detectionList;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DetectionList(snapshotEnable=");
    localStringBuilder.append(this.snapshotEnable);
    localStringBuilder.append(", detectionList=");
    localStringBuilder.append(this.detectionList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DetectionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */