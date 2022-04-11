package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class GetPanoramaParams
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetPanoramaParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */