package com.tplink.iot.cloud.bean.thing.params;

import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerState;
import java.util.List;
import java.util.Objects;

public class ThingEventParams
{
  private String name;
  private List<SmartThingTriggerState> paramList;
  
  public ThingEventParams() {}
  
  public ThingEventParams(String paramString)
  {
    this.name = paramString;
  }
  
  public ThingEventParams(String paramString, List<SmartThingTriggerState> paramList1)
  {
    this.name = paramString;
    this.paramList = paramList1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i = 0;
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (ThingEventParams)paramObject;
      if (!Objects.equals(this.name, ((ThingEventParams)paramObject).name)) {
        return false;
      }
      List localList = this.paramList;
      int j;
      if (localList != null)
      {
        j = i;
        if (!localList.isEmpty()) {}
      }
      else
      {
        localList = ((ThingEventParams)paramObject).paramList;
        if (localList != null)
        {
          j = i;
          if (!localList.isEmpty()) {}
        }
        else
        {
          j = 1;
        }
      }
      if (j == 0) {
        return Objects.equals(this.paramList, ((ThingEventParams)paramObject).paramList);
      }
      return true;
    }
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<SmartThingTriggerState> getParamList()
  {
    return this.paramList;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.name, this.paramList });
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParamList(List<SmartThingTriggerState> paramList1)
  {
    this.paramList = paramList1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\ThingEventParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */