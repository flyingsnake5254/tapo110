package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class TriggerLog
{
  private String event;
  private String eventId;
  private int id;
  private Map<String, ? extends Object> params;
  private long timestamp;
  
  public TriggerLog(int paramInt, long paramLong, @TriggerLogEvent String paramString, Map<String, ? extends Object> paramMap)
  {
    this.id = paramInt;
    this.timestamp = paramLong;
    this.event = paramString;
    this.params = paramMap;
  }
  
  public TriggerLog(ThingEventLog paramThingEventLog)
  {
    this(i, paramThingEventLog.getTimestamp(), paramThingEventLog.getName(), paramThingEventLog.getParams());
    this.eventId = paramThingEventLog.getEventId();
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final long component2()
  {
    return this.timestamp;
  }
  
  public final String component3()
  {
    return this.event;
  }
  
  public final Map<String, Object> component4()
  {
    return this.params;
  }
  
  public final TriggerLog copy(int paramInt, long paramLong, @TriggerLogEvent String paramString, Map<String, ? extends Object> paramMap)
  {
    return new TriggerLog(paramInt, paramLong, paramString, paramMap);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TriggerLog))
      {
        paramObject = (TriggerLog)paramObject;
        if ((this.id == ((TriggerLog)paramObject).id) && (this.timestamp == ((TriggerLog)paramObject).timestamp) && (j.a(this.event, ((TriggerLog)paramObject).event)) && (j.a(this.params, ((TriggerLog)paramObject).params))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getEvent()
  {
    return this.event;
  }
  
  public final String getEventId()
  {
    return this.eventId;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final Map<String, Object> getParams()
  {
    return this.params;
  }
  
  public final long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int hashCode()
  {
    int i = this.id;
    long l = this.timestamp;
    int j = (int)(l ^ l >>> 32);
    Object localObject = this.event;
    int k = 0;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.params;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + m) * 31 + k;
  }
  
  public final void setEvent(String paramString)
  {
    this.event = paramString;
  }
  
  public final void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setParams(Map<String, ? extends Object> paramMap)
  {
    this.params = paramMap;
  }
  
  public final void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TriggerLog(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.event);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\TriggerLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */