package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;

public class DoChangeAudioRequest
  extends Request
{
  @c("change_audio")
  private GetPreviewParams changeAudio;
  
  public DoChangeAudioRequest()
  {
    super("do");
  }
  
  public GetPreviewParams getChangeAudio()
  {
    return this.changeAudio;
  }
  
  public void setChangeAudio(GetPreviewParams paramGetPreviewParams)
  {
    this.changeAudio = paramGetPreviewParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoChangeAudioRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */