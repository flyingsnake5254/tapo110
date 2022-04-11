package com.tplink.cloud.bean.push.params;

import com.tplink.cloud.bean.push.EnumNotificationDirection;

public class NotificationMsgTypeParams
{
  private EnumNotificationDirection direction;
  private long indexTime;
  private String msgType;
  
  public EnumNotificationDirection getDirection()
  {
    return this.direction;
  }
  
  public long getIndexTime()
  {
    return this.indexTime;
  }
  
  public String getMsgType()
  {
    return this.msgType;
  }
  
  public void setDirection(EnumNotificationDirection paramEnumNotificationDirection)
  {
    this.direction = paramEnumNotificationDirection;
  }
  
  public void setIndexTime(long paramLong)
  {
    this.indexTime = paramLong;
  }
  
  public void setMsgType(String paramString)
  {
    this.msgType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\NotificationMsgTypeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */