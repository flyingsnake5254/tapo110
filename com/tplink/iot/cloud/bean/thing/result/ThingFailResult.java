package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.i;

public class ThingFailResult
{
  private String code;
  private i data;
  private String message;
  private String thingName;
  
  public String getCode()
  {
    return this.code;
  }
  
  public i getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setData(i parami)
  {
    this.data = parami;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setThingName(String paramString)
  {
    this.thingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingFailResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */