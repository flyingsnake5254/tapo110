package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

public class GetPreviewResponse
  extends Response
{
  @c("session_id")
  private String sessionId;
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\response\GetPreviewResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */