package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class ChildResponseData<T>
{
  @c("responseData")
  private final T responseData;
  
  public ChildResponseData(T paramT)
  {
    this.responseData = paramT;
  }
  
  public final T component1()
  {
    return (T)this.responseData;
  }
  
  public final ChildResponseData<T> copy(T paramT)
  {
    return new ChildResponseData(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ChildResponseData))
      {
        paramObject = (ChildResponseData)paramObject;
        if (j.a(this.responseData, ((ChildResponseData)paramObject).responseData)) {}
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
    localStringBuilder.append("ChildResponseData(responseData=");
    localStringBuilder.append(this.responseData);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\ChildResponseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */