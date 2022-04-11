package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetVodParams;

public class GetPlaybackRequest
  extends Request
{
  @c("playback")
  private GetVodParams playback;
  
  public GetPlaybackRequest()
  {
    super("get");
  }
  
  public GetVodParams getPlayback()
  {
    return this.playback;
  }
  
  public void setPlayback(GetVodParams paramGetVodParams)
  {
    this.playback = paramGetVodParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetPlaybackRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */