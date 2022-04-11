package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;
import java.util.Objects;

public class SmartAction
{
  private List<SmartReferAction> smarts;
  private List<SmartThingAction> things;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartAction)paramObject;
      if ((!Objects.equals(this.smarts, ((SmartAction)paramObject).smarts)) || (!Objects.equals(this.things, ((SmartAction)paramObject).things))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public List<SmartReferAction> getSmarts()
  {
    return this.smarts;
  }
  
  public List<SmartThingAction> getThings()
  {
    return this.things;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.smarts, this.things });
  }
  
  public void setSmarts(List<SmartReferAction> paramList)
  {
    this.smarts = paramList;
  }
  
  public void setThings(List<SmartThingAction> paramList)
  {
    this.things = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */