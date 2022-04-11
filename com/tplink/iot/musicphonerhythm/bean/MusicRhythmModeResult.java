package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmModeResult
{
  @c("mode")
  private String mode;
  
  public MusicRhythmModeResult(String paramString)
  {
    this.mode = paramString;
  }
  
  public String getMode()
  {
    return this.mode;
  }
  
  public void setMode(String paramString)
  {
    this.mode = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmModeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */