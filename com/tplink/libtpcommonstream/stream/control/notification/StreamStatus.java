package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;

public class StreamStatus
{
  public static final String FINISHED = "finished";
  @c("status")
  private String status;
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\StreamStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */