package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmPowerModeParams
{
  @c("sensitivity")
  private int sensitivity;
  @c("start_point")
  private int startPoint;
  
  public MusicRhythmPowerModeParams(int paramInt1, int paramInt2)
  {
    this.startPoint = paramInt1;
    this.sensitivity = paramInt2;
  }
  
  public int getSensitivity()
  {
    return this.sensitivity;
  }
  
  public int getStartPoint()
  {
    return this.startPoint;
  }
  
  public void setSensitivity(int paramInt)
  {
    this.sensitivity = paramInt;
  }
  
  public void setStartPoint(int paramInt)
  {
    this.startPoint = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmPowerModeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */