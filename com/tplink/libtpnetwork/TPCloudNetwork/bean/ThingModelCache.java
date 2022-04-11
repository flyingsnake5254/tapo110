package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import java.io.Serializable;

public class ThingModelCache
  implements Serializable
{
  private ThingModel thingModel;
  private String thingModelId;
  
  public ThingModelCache(String paramString, ThingModel paramThingModel)
  {
    this.thingModelId = paramString;
    this.thingModel = paramThingModel;
  }
  
  public ThingModel getThingModel()
  {
    return this.thingModel;
  }
  
  public String getThingModelId()
  {
    return this.thingModelId;
  }
  
  public void setThingModel(ThingModel paramThingModel)
  {
    this.thingModel = paramThingModel;
  }
  
  public void setThingModelId(String paramString)
  {
    this.thingModelId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\ThingModelCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */