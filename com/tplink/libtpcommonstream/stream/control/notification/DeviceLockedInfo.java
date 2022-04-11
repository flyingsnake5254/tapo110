package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;

public class DeviceLockedInfo
{
  @c("event_message")
  private String eventMessage;
  
  public String getEventMessage()
  {
    return this.eventMessage;
  }
  
  public void setEventMessage(String paramString)
  {
    this.eventMessage = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\DeviceLockedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */