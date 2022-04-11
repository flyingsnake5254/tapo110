package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import java.util.ArrayList;

public class MusicRhythmSupportModeResult
{
  @c("mode")
  private ArrayList<String> mode;
  
  public MusicRhythmSupportModeResult()
  {
    this.mode = null;
  }
  
  public MusicRhythmSupportModeResult(ArrayList<String> paramArrayList)
  {
    this.mode = paramArrayList;
  }
  
  public ArrayList<String> getMode()
  {
    return this.mode;
  }
  
  public void setMode(ArrayList<String> paramArrayList)
  {
    this.mode = paramArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmSupportModeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */