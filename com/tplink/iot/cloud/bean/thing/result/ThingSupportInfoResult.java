package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportAlarm;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;

public class ThingSupportInfoResult
{
  private ThingComponentResult components;
  @c("support_alarms")
  private ThingSupportAlarm supportAlarms;
  @c("support_categories")
  private ThingSupportCategory supportCategories;
  
  public ThingComponentResult getComponents()
  {
    return this.components;
  }
  
  public ThingSupportAlarm getSupportAlarms()
  {
    return this.supportAlarms;
  }
  
  public ThingSupportCategory getSupportCategories()
  {
    return this.supportCategories;
  }
  
  public void setComponents(ThingComponentResult paramThingComponentResult)
  {
    this.components = paramThingComponentResult;
  }
  
  public void setSupportAlarms(ThingSupportAlarm paramThingSupportAlarm)
  {
    this.supportAlarms = paramThingSupportAlarm;
  }
  
  public void setSupportCategories(ThingSupportCategory paramThingSupportCategory)
  {
    this.supportCategories = paramThingSupportCategory;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingSupportInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */