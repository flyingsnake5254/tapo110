package com.tplink.iot.cloud.bean.thing.result;

import java.util.Iterator;
import java.util.List;

public class ThingShadowListResult
{
  private List<ThingFailResult> failThingList;
  private List<ThingShadowResult> shadows;
  
  public List<ThingFailResult> getFailThingList()
  {
    return this.failThingList;
  }
  
  public List<ThingShadowResult> getShadows()
  {
    return this.shadows;
  }
  
  public ThingFailResult getThingShadowFailResult(String paramString)
  {
    Object localObject = this.failThingList;
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (ThingFailResult)localIterator.next();
        if (paramString.equals(((ThingFailResult)localObject).getThingName())) {
          return (ThingFailResult)localObject;
        }
      }
    }
    return null;
  }
  
  public ThingShadowResult getThingShadowResult(String paramString)
  {
    Object localObject = this.shadows;
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (ThingShadowResult)localIterator.next();
        if (paramString.equals(((ThingShadowResult)localObject).getThingName())) {
          return (ThingShadowResult)localObject;
        }
      }
    }
    return null;
  }
  
  public void setFailThingList(List<ThingFailResult> paramList)
  {
    this.failThingList = paramList;
  }
  
  public void setShadows(List<ThingShadowResult> paramList)
  {
    this.shadows = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingShadowListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */