package com.tplink.iot.cloud.bean.thing.result;

import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import java.util.List;

public class ThingEventLogResult
{
  private List<ThingEventLog> events;
  
  public List<ThingEventLog> getEvents()
  {
    return this.events;
  }
  
  public void setEvents(List<ThingEventLog> paramList)
  {
    this.events = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingEventLogResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */