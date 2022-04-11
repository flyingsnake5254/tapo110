package com.tplink.iot.cloud.bean.smart.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import java.util.Map;
import java.util.Objects;

public class SmartThingFutureAction
{
  private int delaySeconds;
  private ThingServiceParams service;
  @b(MapJsonAdapter.class)
  private Map<String, Object> stateDesired;
  
  public SmartThingFutureAction() {}
  
  public SmartThingFutureAction(int paramInt, ThingServiceParams paramThingServiceParams)
  {
    this.delaySeconds = paramInt;
    this.service = paramThingServiceParams;
  }
  
  public SmartThingFutureAction(int paramInt, Map<String, Object> paramMap)
  {
    this.delaySeconds = paramInt;
    this.stateDesired = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartThingFutureAction)paramObject;
      if ((this.delaySeconds != ((SmartThingFutureAction)paramObject).delaySeconds) || (!Objects.equals(this.stateDesired, ((SmartThingFutureAction)paramObject).stateDesired)) || (!Objects.equals(this.service, ((SmartThingFutureAction)paramObject).service))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int getDelaySeconds()
  {
    return this.delaySeconds;
  }
  
  public ThingServiceParams getService()
  {
    return this.service;
  }
  
  public Map<String, Object> getStateDesired()
  {
    return this.stateDesired;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.delaySeconds), this.stateDesired, this.service });
  }
  
  public void setDelaySeconds(int paramInt)
  {
    this.delaySeconds = paramInt;
  }
  
  public void setService(ThingServiceParams paramThingServiceParams)
  {
    this.service = paramThingServiceParams;
  }
  
  public void setStateDesired(Map<String, Object> paramMap)
  {
    this.stateDesired = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartThingFutureAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */