package com.tplink.cloud.bean.push.params;

import com.tplink.cloud.bean.push.EnumNotificationDirection;
import java.util.List;

public class NotificationParams
{
  private String appType;
  private String deviceToken;
  private EnumNotificationDirection direction;
  private int index;
  private long indexTime;
  private int limit;
  private String locale;
  private String mobileType;
  private List<String> msgTypes;
  private String terminalUUID;
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getDeviceToken()
  {
    return this.deviceToken;
  }
  
  public EnumNotificationDirection getDirection()
  {
    return this.direction;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public long getIndexTime()
  {
    return this.indexTime;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getMobileType()
  {
    return this.mobileType;
  }
  
  public List<String> getMsgTypes()
  {
    return this.msgTypes;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setDeviceToken(String paramString)
  {
    this.deviceToken = paramString;
  }
  
  public void setDirection(EnumNotificationDirection paramEnumNotificationDirection)
  {
    this.direction = paramEnumNotificationDirection;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setIndexTime(long paramLong)
  {
    this.indexTime = paramLong;
  }
  
  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setMobileType(String paramString)
  {
    this.mobileType = paramString;
  }
  
  public void setMsgTypes(List<String> paramList)
  {
    this.msgTypes = paramList;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\NotificationParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */