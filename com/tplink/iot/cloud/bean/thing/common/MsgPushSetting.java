package com.tplink.iot.cloud.bean.thing.common;

public class MsgPushSetting
{
  private boolean enabled;
  private String eventId;
  
  public MsgPushSetting() {}
  
  public MsgPushSetting(String paramString, boolean paramBoolean)
  {
    this.eventId = paramString;
    this.enabled = paramBoolean;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\MsgPushSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */