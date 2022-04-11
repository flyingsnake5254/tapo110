package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class AddPreviewChannelParams
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("resolutions")
  private List<String> resolutions = new ArrayList();
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public List<String> getResolutions()
  {
    return this.resolutions;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\channel\AddPreviewChannelParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */