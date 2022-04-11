package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class PassThroughRequestData<T>
{
  private final String deviceId;
  private final T requestData;
  
  public PassThroughRequestData(T paramT, String paramString)
  {
    this.requestData = paramT;
    this.deviceId = paramString;
  }
  
  public final T component1()
  {
    return (T)this.requestData;
  }
  
  public final String component2()
  {
    return this.deviceId;
  }
  
  public final PassThroughRequestData<T> copy(T paramT, String paramString)
  {
    return new PassThroughRequestData(paramT, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PassThroughRequestData))
      {
        paramObject = (PassThroughRequestData)paramObject;
        if ((j.a(this.requestData, ((PassThroughRequestData)paramObject).requestData)) && (j.a(this.deviceId, ((PassThroughRequestData)paramObject).deviceId))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDeviceId()
  {
    return this.deviceId;
  }
  
  public final T getRequestData()
  {
    return (T)this.requestData;
  }
  
  public int hashCode()
  {
    Object localObject = this.requestData;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.deviceId;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PassThroughRequestData(requestData=");
    localStringBuilder.append(this.requestData);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\PassThroughRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */