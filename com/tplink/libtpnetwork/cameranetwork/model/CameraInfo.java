package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class CameraInfo
{
  public static final Companion Companion = new Companion(null);
  private final BasicInfo basicInfo;
  private final SystemInfo systemInfo;
  
  public CameraInfo(BasicInfo paramBasicInfo, SystemInfo paramSystemInfo)
  {
    this.basicInfo = paramBasicInfo;
    this.systemInfo = paramSystemInfo;
  }
  
  public CameraInfo(Wrappers paramWrappers)
  {
    this((BasicInfo)Model.typeCast(paramWrappers, BasicInfo.class), (SystemInfo)Model.typeCast(paramWrappers, SystemInfo.class));
  }
  
  public final BasicInfo component1()
  {
    return this.basicInfo;
  }
  
  public final SystemInfo component2()
  {
    return this.systemInfo;
  }
  
  public final CameraInfo copy(BasicInfo paramBasicInfo, SystemInfo paramSystemInfo)
  {
    return new CameraInfo(paramBasicInfo, paramSystemInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CameraInfo))
      {
        paramObject = (CameraInfo)paramObject;
        if ((j.a(this.basicInfo, ((CameraInfo)paramObject).basicInfo)) && (j.a(this.systemInfo, ((CameraInfo)paramObject).systemInfo))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final BasicInfo getBasicInfo()
  {
    return this.basicInfo;
  }
  
  public final SystemInfo getSystemInfo()
  {
    return this.systemInfo;
  }
  
  public int hashCode()
  {
    Object localObject = this.basicInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.systemInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraInfo(basicInfo=");
    localStringBuilder.append(this.basicInfo);
    localStringBuilder.append(", systemInfo=");
    localStringBuilder.append(this.systemInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromResponse<CameraInfo>
  {
    public CameraInfo fromResponse(Response<Wrappers> paramResponse)
    {
      j.e(paramResponse, "response");
      if (j.a(paramResponse.getMethod(), Method.GET_DEVICE_INFO.getValue())) {
        paramResponse = new CameraInfo((Wrappers)paramResponse.getResult());
      } else {
        paramResponse = null;
      }
      return paramResponse;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CameraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */