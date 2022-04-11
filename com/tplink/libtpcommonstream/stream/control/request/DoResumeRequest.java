package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class DoResumeRequest
  extends Request
{
  @c("play")
  private String play = "null";
  
  public DoResumeRequest()
  {
    super("do");
  }
  
  public String getPlay()
  {
    return this.play;
  }
  
  public void setPlay(String paramString)
  {
    this.play = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoResumeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */