package com.tplink.iot.cloud.bean.thing.common;

import androidx.annotation.NonNull;

public class ThingShadow
{
  private ThingShadowState state;
  private long version;
  
  public ThingShadow() {}
  
  public ThingShadow(long paramLong, ThingShadowState paramThingShadowState)
  {
    this.version = paramLong;
    this.state = paramThingShadowState;
  }
  
  public Object getDesiredValue(@NonNull ThingProperty paramThingProperty)
  {
    ThingShadowState localThingShadowState = this.state;
    if (localThingShadowState != null) {
      paramThingProperty = localThingShadowState.getDesiredValue(paramThingProperty);
    } else {
      paramThingProperty = null;
    }
    return paramThingProperty;
  }
  
  public Object getReportedValue(@NonNull ThingProperty paramThingProperty)
  {
    ThingShadowState localThingShadowState = this.state;
    if (localThingShadowState != null) {
      paramThingProperty = localThingShadowState.getReportedValue(paramThingProperty);
    } else {
      paramThingProperty = null;
    }
    return paramThingProperty;
  }
  
  public ThingShadowState getState()
  {
    return this.state;
  }
  
  public long getVersion()
  {
    return this.version;
  }
  
  public void setState(ThingShadowState paramThingShadowState)
  {
    this.state = paramThingShadowState;
  }
  
  public void setVersion(long paramLong)
  {
    this.version = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */