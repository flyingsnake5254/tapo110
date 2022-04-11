package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class Request<T>
{
  private final String method;
  private final T params;
  
  public Request(Method paramMethod, T paramT)
  {
    this(paramMethod.getValue(), paramT);
  }
  
  public Request(String paramString, T paramT)
  {
    this.method = paramString;
    this.params = paramT;
  }
  
  public final String component1()
  {
    return this.method;
  }
  
  public final T component2()
  {
    return (T)this.params;
  }
  
  public final Request<T> copy(String paramString, T paramT)
  {
    j.e(paramString, "method");
    return new Request(paramString, paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Request))
      {
        paramObject = (Request)paramObject;
        if ((j.a(this.method, ((Request)paramObject).method)) && (j.a(this.params, ((Request)paramObject).params))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final T getParams()
  {
    return (T)this.params;
  }
  
  public int hashCode()
  {
    Object localObject = this.method;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.params;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request(method=");
    localStringBuilder.append(this.method);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */