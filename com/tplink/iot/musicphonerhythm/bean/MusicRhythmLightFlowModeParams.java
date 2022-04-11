package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmLightFlowModeParams
{
  @c("interval")
  private int interval;
  @c("off_time")
  private int offTime;
  @c("start_point")
  private int startPoint;
  
  public MusicRhythmLightFlowModeParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this.startPoint = paramInt1;
    this.interval = paramInt2;
    this.offTime = paramInt3;
  }
  
  public int getInterval()
  {
    return this.interval;
  }
  
  public int getOffTime()
  {
    return this.offTime;
  }
  
  public int getStartPoint()
  {
    return this.startPoint;
  }
  
  public void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
  
  public void setOffTime(int paramInt)
  {
    this.offTime = paramInt;
  }
  
  public void setStartPoint(int paramInt)
  {
    this.startPoint = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmLightFlowModeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */