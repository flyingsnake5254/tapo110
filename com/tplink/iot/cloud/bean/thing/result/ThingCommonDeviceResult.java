package com.tplink.iot.cloud.bean.thing.result;

import java.util.List;

public class ThingCommonDeviceResult
{
  private List<ThingFailResult> failThingList;
  
  public List<ThingFailResult> getFailThingList()
  {
    return this.failThingList;
  }
  
  public void setFailThingList(List<ThingFailResult> paramList)
  {
    this.failThingList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingCommonDeviceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */