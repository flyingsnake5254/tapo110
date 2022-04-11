package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class TriggerLogsParams
{
  @c("device_id")
  private String deviceId;
  @c("page_size")
  private int pageSize;
  @c("start_id")
  private int startId;
  
  public TriggerLogsParams(String paramString, int paramInt1, int paramInt2)
  {
    this.deviceId = paramString;
    this.startId = paramInt1;
    this.pageSize = paramInt2;
  }
  
  public final String component1()
  {
    return this.deviceId;
  }
  
  public final int component2()
  {
    return this.startId;
  }
  
  public final int component3()
  {
    return this.pageSize;
  }
  
  public final TriggerLogsParams copy(String paramString, int paramInt1, int paramInt2)
  {
    j.e(paramString, "deviceId");
    return new TriggerLogsParams(paramString, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TriggerLogsParams))
      {
        paramObject = (TriggerLogsParams)paramObject;
        if ((j.a(this.deviceId, ((TriggerLogsParams)paramObject).deviceId)) && (this.startId == ((TriggerLogsParams)paramObject).startId) && (this.pageSize == ((TriggerLogsParams)paramObject).pageSize)) {}
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
  
  public final int getPageSize()
  {
    return this.pageSize;
  }
  
  public final int getStartId()
  {
    return this.startId;
  }
  
  public int hashCode()
  {
    String str = this.deviceId;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (i * 31 + this.startId) * 31 + this.pageSize;
  }
  
  public final void setDeviceId(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.deviceId = paramString;
  }
  
  public final void setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
  }
  
  public final void setStartId(int paramInt)
  {
    this.startId = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TriggerLogsParams(deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(", startId=");
    localStringBuilder.append(this.startId);
    localStringBuilder.append(", pageSize=");
    localStringBuilder.append(this.pageSize);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\TriggerLogsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */