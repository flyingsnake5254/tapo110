package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class Request
{
  @c("method")
  private String method;
  
  public Request(String paramString)
  {
    this.method = paramString;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */