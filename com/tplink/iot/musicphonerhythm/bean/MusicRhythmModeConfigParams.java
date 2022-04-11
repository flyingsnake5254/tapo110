package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmModeConfigParams<T>
{
  @c("config")
  private T config;
  @c("mode")
  private String mode;
  
  public MusicRhythmModeConfigParams(String paramString, T paramT)
  {
    this.mode = paramString;
    this.config = paramT;
  }
  
  public T getConfig()
  {
    return (T)this.config;
  }
  
  public String getMode()
  {
    return this.mode;
  }
  
  public void setConfig(T paramT)
  {
    this.config = paramT;
  }
  
  public void setMode(String paramString)
  {
    this.mode = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmModeConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */