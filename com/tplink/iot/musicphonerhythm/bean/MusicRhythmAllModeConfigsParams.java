package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmAllModeConfigsParams
{
  @c("start_index")
  private int startIndex;
  
  public MusicRhythmAllModeConfigsParams() {}
  
  public MusicRhythmAllModeConfigsParams(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmAllModeConfigsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */