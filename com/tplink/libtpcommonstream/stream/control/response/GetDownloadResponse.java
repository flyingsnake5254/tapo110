package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

public class GetDownloadResponse
  extends Response
{
  @c("range")
  private String range;
  @c("session_id")
  private String sessionId;
  
  public String getRange()
  {
    return this.range;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public void setRange(String paramString)
  {
    this.range = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\response\GetDownloadResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */