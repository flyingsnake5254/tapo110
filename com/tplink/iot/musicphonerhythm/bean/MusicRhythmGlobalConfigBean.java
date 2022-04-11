package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmGlobalConfigBean
{
  @c("base_brightness")
  private int baseBrightness;
  @c("hue")
  private int hue;
  @c("saturation")
  private int saturation;
  @c("single_color_enable")
  private boolean singleColorEnable;
  
  public MusicRhythmGlobalConfigBean(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.singleColorEnable = paramBoolean;
    this.hue = paramInt1;
    this.saturation = paramInt2;
    this.baseBrightness = paramInt3;
  }
  
  public int getBaseBrightness()
  {
    return this.baseBrightness;
  }
  
  public int getHue()
  {
    return this.hue;
  }
  
  public int getSaturation()
  {
    return this.saturation;
  }
  
  public boolean isSingleColorEnable()
  {
    return this.singleColorEnable;
  }
  
  public void setBaseBrightness(int paramInt)
  {
    this.baseBrightness = paramInt;
  }
  
  public void setHue(int paramInt)
  {
    this.hue = paramInt;
  }
  
  public void setSaturation(int paramInt)
  {
    this.saturation = paramInt;
  }
  
  public void setSingleColorEnable(boolean paramBoolean)
  {
    this.singleColorEnable = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmGlobalConfigBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */