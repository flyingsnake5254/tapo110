package com.tplink.iot.cloud.bean.thing.common;

import java.util.List;

public class ThingMsgPushSettings
{
  private List<MsgPushSetting> msgPushSettings;
  
  public ThingMsgPushSettings() {}
  
  public ThingMsgPushSettings(List<MsgPushSetting> paramList)
  {
    this.msgPushSettings = paramList;
  }
  
  public List<MsgPushSetting> getMsgPushSettings()
  {
    return this.msgPushSettings;
  }
  
  public void setMsgPushSettings(List<MsgPushSetting> paramList)
  {
    this.msgPushSettings = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingMsgPushSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */