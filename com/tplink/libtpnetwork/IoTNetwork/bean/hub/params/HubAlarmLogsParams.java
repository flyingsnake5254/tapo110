package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;

public final class HubAlarmLogsParams
{
  @c("page_size")
  private int pageSize;
  @c("start_id")
  private int startId;
  
  public HubAlarmLogsParams(int paramInt1, int paramInt2)
  {
    this.startId = paramInt1;
    this.pageSize = paramInt2;
  }
  
  public final int component1()
  {
    return this.startId;
  }
  
  public final int component2()
  {
    return this.pageSize;
  }
  
  public final HubAlarmLogsParams copy(int paramInt1, int paramInt2)
  {
    return new HubAlarmLogsParams(paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HubAlarmLogsParams))
      {
        paramObject = (HubAlarmLogsParams)paramObject;
        if ((this.startId == ((HubAlarmLogsParams)paramObject).startId) && (this.pageSize == ((HubAlarmLogsParams)paramObject).pageSize)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
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
    return this.startId * 31 + this.pageSize;
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
    localStringBuilder.append("HubAlarmLogsParams(startId=");
    localStringBuilder.append(this.startId);
    localStringBuilder.append(", pageSize=");
    localStringBuilder.append(this.pageSize);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\HubAlarmLogsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */