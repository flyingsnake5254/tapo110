package com.tplink.iot.cloud.bean.thing.params;

import java.util.List;

public class ThingBatchUnbindParams
{
  private List<String> thingNames;
  
  public ThingBatchUnbindParams() {}
  
  public ThingBatchUnbindParams(List<String> paramList)
  {
    this.thingNames = paramList;
  }
  
  public List<String> getThingNames()
  {
    return this.thingNames;
  }
  
  public void setThingNames(List<String> paramList)
  {
    this.thingNames = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\ThingBatchUnbindParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */