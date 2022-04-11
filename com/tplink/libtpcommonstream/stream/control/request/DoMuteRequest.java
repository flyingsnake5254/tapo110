package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class DoMuteRequest
  extends Request
{
  @c("change_audio")
  private DoMuteParams changeAudio;
  
  public DoMuteRequest()
  {
    super("do");
  }
  
  public DoMuteParams getChangeAudio()
  {
    return this.changeAudio;
  }
  
  public void setChangeAudio(DoMuteParams paramDoMuteParams)
  {
    this.changeAudio = paramDoMuteParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoMuteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */