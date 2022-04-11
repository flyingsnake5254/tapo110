package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

public class ThingComponent
{
  private String id;
  @c("ver_code")
  private int verCode;
  
  public String getId()
  {
    return this.id;
  }
  
  public int getVerCode()
  {
    return this.verCode;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setVerCode(int paramInt)
  {
    this.verCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */