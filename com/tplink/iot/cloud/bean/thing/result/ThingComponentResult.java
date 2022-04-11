package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingComponent;
import java.util.ArrayList;
import java.util.List;

public class ThingComponentResult
{
  @c("component_list")
  private List<ThingComponent> componentList = new ArrayList();
  
  public List<ThingComponent> getComponentList()
  {
    return this.componentList;
  }
  
  public void setComponentList(List<ThingComponent> paramList)
  {
    this.componentList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingComponentResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */