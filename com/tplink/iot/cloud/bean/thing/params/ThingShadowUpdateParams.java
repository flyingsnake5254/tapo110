package com.tplink.iot.cloud.bean.thing.params;

import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;

public class ThingShadowUpdateParams
  extends ThingShadow
{
  private String edgeThingName;
  
  public ThingShadowUpdateParams() {}
  
  public ThingShadowUpdateParams(long paramLong, ThingShadowState paramThingShadowState)
  {
    super(paramLong, paramThingShadowState);
  }
  
  public ThingShadowUpdateParams(long paramLong, ThingShadowState paramThingShadowState, String paramString)
  {
    super(paramLong, paramThingShadowState);
    this.edgeThingName = paramString;
  }
  
  public String getEdgeThingName()
  {
    return this.edgeThingName;
  }
  
  public void setEdgeThingName(String paramString)
  {
    this.edgeThingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\ThingShadowUpdateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */