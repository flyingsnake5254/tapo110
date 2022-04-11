package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetTalkParams;

public class GetTalkRequest
  extends Request
{
  @c("talk")
  private GetTalkParams talk;
  
  public GetTalkRequest()
  {
    super("get");
  }
  
  public GetTalkParams getTalk()
  {
    return this.talk;
  }
  
  public void setTalk(GetTalkParams paramGetTalkParams)
  {
    this.talk = paramGetTalkParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetTalkRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */