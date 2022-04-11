package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

public class GetPlaybackResponse
  extends Response
{
  @c("session_id")
  private String sessionId;
  @c("speed")
  private String speed;
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public String getSpeed()
  {
    return this.speed;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSpeed(String paramString)
  {
    this.speed = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\response\GetPlaybackResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */