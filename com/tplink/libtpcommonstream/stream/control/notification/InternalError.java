package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;

public class InternalError
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\InternalError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */