package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class ChildRequestData<T>
{
  private final String device_id;
  @c("requestData")
  private final T requestData;
  
  public ChildRequestData(T paramT, String paramString)
  {
    this.requestData = paramT;
    this.device_id = paramString;
  }
  
  public final T component1()
  {
    return (T)this.requestData;
  }
  
  public final String component2()
  {
    return this.device_id;
  }
  
  public final ChildRequestData<T> copy(T paramT, String paramString)
  {
    j.e(paramString, "device_id");
    return new ChildRequestData(paramT, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ChildRequestData))
      {
        paramObject = (ChildRequestData)paramObject;
        if ((j.a(this.requestData, ((ChildRequestData)paramObject).requestData)) && (j.a(this.device_id, ((ChildRequestData)paramObject).device_id))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDevice_id()
  {
    return this.device_id;
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
    localObject = this.device_id;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildRequestData(requestData=");
    localStringBuilder.append(this.requestData);
    localStringBuilder.append(", device_id=");
    localStringBuilder.append(this.device_id);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\ChildRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */