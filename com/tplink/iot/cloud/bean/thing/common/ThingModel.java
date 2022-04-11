package com.tplink.iot.cloud.bean.thing.common;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThingModel
{
  private List<ThingEvent> events = new ArrayList();
  private List<ThingProperty> properties = new ArrayList();
  private List<ThingService> services = new ArrayList();
  
  public List<ThingEvent> getEvents()
  {
    return this.events;
  }
  
  public List<ThingProperty> getProperties()
  {
    return this.properties;
  }
  
  public List<ThingService> getServices()
  {
    return this.services;
  }
  
  public ThingEvent getThingEvent(@NonNull String paramString)
  {
    Iterator localIterator = this.events.iterator();
    while (localIterator.hasNext())
    {
      ThingEvent localThingEvent = (ThingEvent)localIterator.next();
      if (paramString.equals(localThingEvent.getId())) {
        return localThingEvent;
      }
    }
    return null;
  }
  
  public ThingProperty getThingProperty(@NonNull String paramString)
  {
    Iterator localIterator = this.properties.iterator();
    while (localIterator.hasNext())
    {
      ThingProperty localThingProperty = (ThingProperty)localIterator.next();
      if (paramString.equals(localThingProperty.getId())) {
        return localThingProperty;
      }
    }
    return null;
  }
  
  public ThingService getThingService(@NonNull String paramString)
  {
    Iterator localIterator = this.services.iterator();
    while (localIterator.hasNext())
    {
      ThingService localThingService = (ThingService)localIterator.next();
      if (paramString.equals(localThingService.getId())) {
        return localThingService;
      }
    }
    return null;
  }
  
  public void setEvents(List<ThingEvent> paramList)
  {
    this.events = paramList;
  }
  
  public void setProperties(List<ThingProperty> paramList)
  {
    this.properties = paramList;
  }
  
  public void setServices(List<ThingService> paramList)
  {
    this.services = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */