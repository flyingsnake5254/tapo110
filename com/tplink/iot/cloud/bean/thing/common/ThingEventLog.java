package com.tplink.iot.cloud.bean.thing.common;

import java.util.Map;

public class ThingEventLog
{
  private String eventId;
  private Integer logId;
  private String name;
  private Map<String, Object> params;
  private long timestamp;
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public Integer getLogId()
  {
    return this.logId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Map<String, Object> getParams()
  {
    return this.params;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
  
  public void setLogId(Integer paramInteger)
  {
    this.logId = paramInteger;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParams(Map<String, Object> paramMap)
  {
    this.params = paramMap;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingEventLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */