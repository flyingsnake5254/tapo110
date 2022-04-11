package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;
import java.util.Objects;

public class SmartThingStateReported
{
  private List<SmartThingTriggerState> stateList;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartThingStateReported)paramObject;
      return Objects.equals(this.stateList, ((SmartThingStateReported)paramObject).stateList);
    }
    return false;
  }
  
  public List<SmartThingTriggerState> getStateList()
  {
    return this.stateList;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.stateList });
  }
  
  public void setStateList(List<SmartThingTriggerState> paramList)
  {
    this.stateList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartThingStateReported.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */