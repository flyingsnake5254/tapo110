package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.Request;
import java.util.ArrayList;
import java.util.List;

public class DoAddPlaybackChannelsRequest
  extends Request
{
  @c("playback_add_channels")
  private List<Integer> playbackAddChannels = new ArrayList();
  
  public DoAddPlaybackChannelsRequest()
  {
    super("do");
  }
  
  public List<Integer> getPlaybackAddChannels()
  {
    return this.playbackAddChannels;
  }
  
  public void setPlaybackAddChannels(List<Integer> paramList)
  {
    this.playbackAddChannels = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\channel\DoAddPlaybackChannelsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */