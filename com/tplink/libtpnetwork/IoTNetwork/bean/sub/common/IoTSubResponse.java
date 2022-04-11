package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import kotlin.jvm.internal.j;

public final class IoTSubResponse<T>
{
  @c("error_code")
  private final int errorCode;
  private final String method;
  private final T result;
  
  public IoTSubResponse(int paramInt, String paramString, T paramT)
  {
    this.errorCode = paramInt;
    this.method = paramString;
    this.result = paramT;
  }
  
  public final int component1()
  {
    return this.errorCode;
  }
  
  public final String component2()
  {
    return this.method;
  }
  
  public final T component3()
  {
    return (T)this.result;
  }
  
  public final IoTSubResponse<T> copy(int paramInt, String paramString, T paramT)
  {
    return new IoTSubResponse(paramInt, paramString, paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof IoTSubResponse))
      {
        paramObject = (IoTSubResponse)paramObject;
        if ((this.errorCode == ((IoTSubResponse)paramObject).errorCode) && (j.a(this.method, ((IoTSubResponse)paramObject).method)) && (j.a(this.result, ((IoTSubResponse)paramObject).result))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getErrorCode()
  {
    return this.errorCode;
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final T getResult()
  {
    return (T)this.result;
  }
  
  public int hashCode()
  {
    int i = this.errorCode;
    Object localObject = this.method;
    int j = 0;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.result;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public final boolean isSuccess()
  {
    boolean bool;
    if (this.errorCode == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final <R> Response<R> repack(R paramR)
  {
    return new Response(this.errorCode, this.method, paramR);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("####-ChildControl-#####");
    localStringBuilder.append(this.method);
    localStringBuilder.append("#########\r\nerrorCode:");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append("\r\nresult:");
    localStringBuilder.append(this.result);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\IoTSubResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */