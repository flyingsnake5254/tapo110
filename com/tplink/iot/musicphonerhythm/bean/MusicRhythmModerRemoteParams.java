package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;

public class MusicRhythmModerRemoteParams
  extends DeviceInfoParams
{
  @c("mode")
  private String mode;
  
  public MusicRhythmModerRemoteParams(String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmModerRemoteParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */