package com.tplink.iot.cloud.bean.thing.params;

import java.util.List;

public class ThingCommonDeviceParams
{
  private boolean isCommon;
  private List<String> thingNames;
  
  public ThingCommonDeviceParams() {}
  
  public ThingCommonDeviceParams(boolean paramBoolean, List<String> paramList)
  {
    this.isCommon = paramBoolean;
    this.thingNames = paramList;
  }
  
  public List<String> getThingNames()
  {
    return this.thingNames;
  }
  
  public boolean isCommon()
  {
    return this.isCommon;
  }
  
  public void setCommon(boolean paramBoolean)
  {
    this.isCommon = paramBoolean;
  }
  
  public void setThingNames(List<String> paramList)
  {
    this.thingNames = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\ThingCommonDeviceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */