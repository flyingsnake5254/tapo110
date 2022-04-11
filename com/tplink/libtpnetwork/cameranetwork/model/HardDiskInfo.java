package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class HardDiskInfo
{
  public static final Companion Companion = new Companion(null);
  @c("detect_status")
  private String detectStatus;
  @c("msg_push_free_space")
  private final String freeMessageSpace;
  @c("picture_free_space")
  private final String freePictureSpace;
  @c("free_space")
  private final String freeSpace;
  @c("video_free_space")
  private String freeVideoSpace;
  private final Float percent;
  @c("record_duration")
  private final String recordDuration;
  @c("record_free_duration")
  private final String recordFreeDuration;
  @c("record_start_time")
  private final String recordStartTime;
  private String status;
  @c("msg_push_total_space")
  private final String totalMessageSpace;
  @c("picture_total_space")
  private final String totalPictureSpace;
  @c("total_space")
  private final String totalSpace;
  @c("video_total_space")
  private final String totalVideoSpace;
  private final String type;
  
  public HardDiskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Float paramFloat)
  {
    this.status = paramString1;
    this.detectStatus = paramString2;
    this.type = paramString3;
    this.totalSpace = paramString4;
    this.freeSpace = paramString5;
    this.totalVideoSpace = paramString6;
    this.freeVideoSpace = paramString7;
    this.totalPictureSpace = paramString8;
    this.freePictureSpace = paramString9;
    this.totalMessageSpace = paramString10;
    this.freeMessageSpace = paramString11;
    this.recordDuration = paramString12;
    this.recordFreeDuration = paramString13;
    this.recordStartTime = paramString14;
    this.percent = paramFloat;
  }
  
  public final String component1()
  {
    return this.status;
  }
  
  public final String component10()
  {
    return this.totalMessageSpace;
  }
  
  public final String component11()
  {
    return this.freeMessageSpace;
  }
  
  public final String component12()
  {
    return this.recordDuration;
  }
  
  public final String component13()
  {
    return this.recordFreeDuration;
  }
  
  public final String component14()
  {
    return this.recordStartTime;
  }
  
  public final Float component15()
  {
    return this.percent;
  }
  
  public final String component2()
  {
    return this.detectStatus;
  }
  
  public final String component3()
  {
    return this.type;
  }
  
  public final String component4()
  {
    return this.totalSpace;
  }
  
  public final String component5()
  {
    return this.freeSpace;
  }
  
  public final String component6()
  {
    return this.totalVideoSpace;
  }
  
  public final String component7()
  {
    return this.freeVideoSpace;
  }
  
  public final String component8()
  {
    return this.totalPictureSpace;
  }
  
  public final String component9()
  {
    return this.freePictureSpace;
  }
  
  public final HardDiskInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Float paramFloat)
  {
    j.e(paramString1, "status");
    j.e(paramString4, "totalSpace");
    j.e(paramString6, "totalVideoSpace");
    j.e(paramString7, "freeVideoSpace");
    return new HardDiskInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HardDiskInfo))
      {
        paramObject = (HardDiskInfo)paramObject;
        if ((j.a(this.status, ((HardDiskInfo)paramObject).status)) && (j.a(this.detectStatus, ((HardDiskInfo)paramObject).detectStatus)) && (j.a(this.type, ((HardDiskInfo)paramObject).type)) && (j.a(this.totalSpace, ((HardDiskInfo)paramObject).totalSpace)) && (j.a(this.freeSpace, ((HardDiskInfo)paramObject).freeSpace)) && (j.a(this.totalVideoSpace, ((HardDiskInfo)paramObject).totalVideoSpace)) && (j.a(this.freeVideoSpace, ((HardDiskInfo)paramObject).freeVideoSpace)) && (j.a(this.totalPictureSpace, ((HardDiskInfo)paramObject).totalPictureSpace)) && (j.a(this.freePictureSpace, ((HardDiskInfo)paramObject).freePictureSpace)) && (j.a(this.totalMessageSpace, ((HardDiskInfo)paramObject).totalMessageSpace)) && (j.a(this.freeMessageSpace, ((HardDiskInfo)paramObject).freeMessageSpace)) && (j.a(this.recordDuration, ((HardDiskInfo)paramObject).recordDuration)) && (j.a(this.recordFreeDuration, ((HardDiskInfo)paramObject).recordFreeDuration)) && (j.a(this.recordStartTime, ((HardDiskInfo)paramObject).recordStartTime)) && (j.a(this.percent, ((HardDiskInfo)paramObject).percent))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDetectStatus()
  {
    return this.detectStatus;
  }
  
  public final String getFreeMessageSpace()
  {
    return this.freeMessageSpace;
  }
  
  public final String getFreePictureSpace()
  {
    return this.freePictureSpace;
  }
  
  public final String getFreeSpace()
  {
    return this.freeSpace;
  }
  
  public final String getFreeVideoSpace()
  {
    return this.freeVideoSpace;
  }
  
  public final Float getPercent()
  {
    return this.percent;
  }
  
  public final String getRecordDuration()
  {
    return this.recordDuration;
  }
  
  public final String getRecordFreeDuration()
  {
    return this.recordFreeDuration;
  }
  
  public final String getRecordStartTime()
  {
    return this.recordStartTime;
  }
  
  public final String getStatus()
  {
    return this.status;
  }
  
  public final String getTotalMessageSpace()
  {
    return this.totalMessageSpace;
  }
  
  public final String getTotalPictureSpace()
  {
    return this.totalPictureSpace;
  }
  
  public final String getTotalSpace()
  {
    return this.totalSpace;
  }
  
  public final String getTotalVideoSpace()
  {
    return this.totalVideoSpace;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    Object localObject = this.status;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.detectStatus;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.type;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.totalSpace;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.freeSpace;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.totalVideoSpace;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.freeVideoSpace;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.totalPictureSpace;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.freePictureSpace;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.totalMessageSpace;
    int i6;
    if (localObject != null) {
      i6 = localObject.hashCode();
    } else {
      i6 = 0;
    }
    localObject = this.freeMessageSpace;
    int i7;
    if (localObject != null) {
      i7 = localObject.hashCode();
    } else {
      i7 = 0;
    }
    localObject = this.recordDuration;
    int i8;
    if (localObject != null) {
      i8 = localObject.hashCode();
    } else {
      i8 = 0;
    }
    localObject = this.recordFreeDuration;
    int i9;
    if (localObject != null) {
      i9 = localObject.hashCode();
    } else {
      i9 = 0;
    }
    localObject = this.recordStartTime;
    int i10;
    if (localObject != null) {
      i10 = localObject.hashCode();
    } else {
      i10 = 0;
    }
    localObject = this.percent;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((((((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i;
  }
  
  public final void setDetectStatus(String paramString)
  {
    this.detectStatus = paramString;
  }
  
  public final void setFreeVideoSpace(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.freeVideoSpace = paramString;
  }
  
  public final void setStatus(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.status = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HardDiskInfo(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", detectStatus=");
    localStringBuilder.append(this.detectStatus);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", totalSpace=");
    localStringBuilder.append(this.totalSpace);
    localStringBuilder.append(", freeSpace=");
    localStringBuilder.append(this.freeSpace);
    localStringBuilder.append(", totalVideoSpace=");
    localStringBuilder.append(this.totalVideoSpace);
    localStringBuilder.append(", freeVideoSpace=");
    localStringBuilder.append(this.freeVideoSpace);
    localStringBuilder.append(", totalPictureSpace=");
    localStringBuilder.append(this.totalPictureSpace);
    localStringBuilder.append(", freePictureSpace=");
    localStringBuilder.append(this.freePictureSpace);
    localStringBuilder.append(", totalMessageSpace=");
    localStringBuilder.append(this.totalMessageSpace);
    localStringBuilder.append(", freeMessageSpace=");
    localStringBuilder.append(this.freeMessageSpace);
    localStringBuilder.append(", recordDuration=");
    localStringBuilder.append(this.recordDuration);
    localStringBuilder.append(", recordFreeDuration=");
    localStringBuilder.append(this.recordFreeDuration);
    localStringBuilder.append(", recordStartTime=");
    localStringBuilder.append(this.recordStartTime);
    localStringBuilder.append(", percent=");
    localStringBuilder.append(this.percent);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromResponse<HardDiskInfo>
  {
    public HardDiskInfo fromResponse(Response<Wrappers> paramResponse)
    {
      j.e(paramResponse, "response");
      boolean bool = j.a(paramResponse.getMethod(), Method.GET_LED_STATUS.getValue());
      Object localObject1 = null;
      Object localObject2 = localObject1;
      if (bool)
      {
        paramResponse = (List)Model.typeCast((Wrappers)paramResponse.getResult(), Module.HARD_DISK_MANAGE, Section.HARD_DISK_INFO);
        localObject2 = localObject1;
        if (paramResponse != null)
        {
          localObject2 = new ArrayList(l.l(paramResponse, 10));
          paramResponse = paramResponse.iterator();
          while (paramResponse.hasNext()) {
            ((Collection)localObject2).add((HardDiskInfo)l.w(((Map)paramResponse.next()).values()));
          }
          localObject2 = (HardDiskInfo)l.x((List)localObject2);
        }
      }
      return (HardDiskInfo)localObject2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\HardDiskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */