package com.tplink.iot.cloud.bean.thing.result;

import com.tplink.iot.cloud.bean.thing.common.ThingShadow;

public class ThingShadowUpdateResult
  extends ThingShadow
{
  private String requestId;
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingShadowUpdateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */