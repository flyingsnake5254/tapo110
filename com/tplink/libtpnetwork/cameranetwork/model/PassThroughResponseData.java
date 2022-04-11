package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class PassThroughResponseData<T>
{
  private final T responseData;
  
  public PassThroughResponseData(T paramT)
  {
    this.responseData = paramT;
  }
  
  public final T component1()
  {
    return (T)this.responseData;
  }
  
  public final PassThroughResponseData<T> copy(T paramT)
  {
    return new PassThroughResponseData(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PassThroughResponseData))
      {
        paramObject = (PassThroughResponseData)paramObject;
        if (j.a(this.responseData, ((PassThroughResponseData)paramObject).responseData)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final T getResponseData()
  {
    return (T)this.responseData;
  }
  
  public int hashCode()
  {
    Object localObject = this.responseData;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PassThroughResponseData(responseData=");
    localStringBuilder.append(this.responseData);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\PassThroughResponseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */