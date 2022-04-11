package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.q.c;

public class SubThingAddParams
{
  private String category;
  @c("device_id")
  private String deviceId;
  
  public SubThingAddParams() {}
  
  public SubThingAddParams(String paramString1, String paramString2)
  {
    this.deviceId = paramString1;
    this.category = paramString2;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\SubThingAddParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */