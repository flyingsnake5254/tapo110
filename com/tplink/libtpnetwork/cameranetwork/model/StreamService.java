package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class StreamService
{
  private final Integer port;
  
  public StreamService(Integer paramInteger)
  {
    this.port = paramInteger;
  }
  
  public final Integer component1()
  {
    return this.port;
  }
  
  public final StreamService copy(Integer paramInteger)
  {
    return new StreamService(paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StreamService))
      {
        paramObject = (StreamService)paramObject;
        if (j.a(this.port, ((StreamService)paramObject).port)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Integer getPort()
  {
    return this.port;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.port;
    int i;
    if (localInteger != null) {
      i = localInteger.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StreamService(port=");
    localStringBuilder.append(this.port);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\StreamService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */