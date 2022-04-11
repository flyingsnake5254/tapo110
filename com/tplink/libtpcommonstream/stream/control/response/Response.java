package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

public class Response
{
  @c("error_code")
  private int errorCode;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\response\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */