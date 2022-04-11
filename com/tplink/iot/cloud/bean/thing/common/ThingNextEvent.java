package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

public class ThingNextEvent
{
  private String avatarUrl;
  private NextEvent nextEvent;
  @b(Base64TypeAdapter.class)
  private String nickname;
  private String roomId;
  private String roomName;
  private String thingName;
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public NextEvent getNextEvent()
  {
    return this.nextEvent;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getRoomId()
  {
    return this.roomId;
  }
  
  public String getRoomName()
  {
    return this.roomName;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setNextEvent(NextEvent paramNextEvent)
  {
    this.nextEvent = paramNextEvent;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setRoomId(String paramString)
  {
    this.roomId = paramString;
  }
  
  public void setRoomName(String paramString)
  {
    this.roomName = paramString;
  }
  
  public void setThingName(String paramString)
  {
    this.thingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingNextEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */