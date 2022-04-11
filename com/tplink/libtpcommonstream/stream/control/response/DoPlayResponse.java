package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

public class DoPlayResponse
  extends Response
{
  @c("end_time")
  private String endTime;
  @c("scale")
  private String scale;
  @c("start_time")
  private String startTime;
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getScale()
  {
    return this.scale;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setScale(String paramString)
  {
    this.scale = paramString;
  }
  
  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\response\DoPlayResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */