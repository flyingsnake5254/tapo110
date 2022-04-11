package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class StartUpdateFirmwareInfo
{
  @c("wait_time")
  private final Integer waitTime;
  
  public StartUpdateFirmwareInfo(Integer paramInteger)
  {
    this.waitTime = paramInteger;
  }
  
  public final Integer component1()
  {
    return this.waitTime;
  }
  
  public final StartUpdateFirmwareInfo copy(Integer paramInteger)
  {
    return new StartUpdateFirmwareInfo(paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StartUpdateFirmwareInfo))
      {
        paramObject = (StartUpdateFirmwareInfo)paramObject;
        if (j.a(this.waitTime, ((StartUpdateFirmwareInfo)paramObject).waitTime)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Integer getWaitTime()
  {
    return this.waitTime;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.waitTime;
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
    localStringBuilder.append("StartUpdateFirmwareInfo(waitTime=");
    localStringBuilder.append(this.waitTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\StartUpdateFirmwareInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */