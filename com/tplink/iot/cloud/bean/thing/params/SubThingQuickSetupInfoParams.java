package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.i;
import com.google.gson.q.c;

public class SubThingQuickSetupInfoParams
{
  @c("device_id")
  private String deviceId;
  private i requestData;
  
  public SubThingQuickSetupInfoParams() {}
  
  public SubThingQuickSetupInfoParams(String paramString, i parami)
  {
    this.deviceId = paramString;
    this.requestData = parami;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public i getRequestData()
  {
    return this.requestData;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setRequestData(i parami)
  {
    this.requestData = parami;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\SubThingQuickSetupInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */