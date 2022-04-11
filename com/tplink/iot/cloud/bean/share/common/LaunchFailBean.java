package com.tplink.iot.cloud.bean.share.common;

import com.google.gson.i;

public class LaunchFailBean
{
  private int code;
  private i data;
  private String message;
  private String thingName;
  
  public int getCode()
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
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\common\LaunchFailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */