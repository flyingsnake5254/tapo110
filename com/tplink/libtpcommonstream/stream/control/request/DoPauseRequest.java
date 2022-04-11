package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class DoPauseRequest
  extends Request
{
  @c("pause")
  private String pause = "null";
  
  public DoPauseRequest()
  {
    super("do");
  }
  
  public String getPause()
  {
    return this.pause;
  }
  
  public void setPause(String paramString)
  {
    this.pause = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoPauseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */