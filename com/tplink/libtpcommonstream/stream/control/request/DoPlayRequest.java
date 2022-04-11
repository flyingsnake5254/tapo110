package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class DoPlayRequest
  extends Request
{
  @c("play")
  private DoPlayParams play;
  
  public DoPlayRequest()
  {
    super("do");
  }
  
  public DoPlayParams getPlay()
  {
    return this.play;
  }
  
  public void setPlay(DoPlayParams paramDoPlayParams)
  {
    this.play = paramDoPlayParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoPlayRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */