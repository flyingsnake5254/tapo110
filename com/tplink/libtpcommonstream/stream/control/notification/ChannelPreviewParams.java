package com.tplink.libtpcommonstream.stream.control.notification;

import android.util.Pair;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class ChannelPreviewParams
{
  @c("audio")
  private List<String> audio = new ArrayList();
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("resolutions")
  private List<String> resolutions = new ArrayList();
  
  public List<String> getAudio()
  {
    return this.audio;
  }
  
  public Pair<String, String> getChannelPreviewParams(String paramString)
  {
    int i = this.channels.indexOf(paramString);
    if ((i > 0) && (i < this.resolutions.size()) && (i < this.audio.size())) {
      paramString = new Pair((String)this.resolutions.get(i), (String)this.audio.get(i));
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public List<String> getResolutions()
  {
    return this.resolutions;
  }
  
  public void setAudio(List<String> paramList)
  {
    this.audio = paramList;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
  
  public void setResolutions(List<String> paramList)
  {
    this.resolutions = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\ChannelPreviewParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */