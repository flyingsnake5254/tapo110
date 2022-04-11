package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class DoStopRequest
  extends Request
{
  @c("stop")
  private String stop = "null";
  
  public DoStopRequest()
  {
    super("do");
  }
  
  public String getStop()
  {
    return this.stop;
  }
  
  public void setStop(String paramString)
  {
    this.stop = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoStopRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */