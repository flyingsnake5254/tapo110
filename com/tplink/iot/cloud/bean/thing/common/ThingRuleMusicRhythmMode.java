package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.i;

public class ThingRuleMusicRhythmMode
{
  private i config;
  private String mode;
  
  public ThingRuleMusicRhythmMode() {}
  
  public ThingRuleMusicRhythmMode(String paramString, i parami)
  {
    this.mode = paramString;
    this.config = parami;
  }
  
  public i getConfig()
  {
    return this.config;
  }
  
  public String getMode()
  {
    return this.mode;
  }
  
  public void setConfig(i parami)
  {
    this.config = parami;
  }
  
  public void setMode(String paramString)
  {
    this.mode = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRuleMusicRhythmMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */