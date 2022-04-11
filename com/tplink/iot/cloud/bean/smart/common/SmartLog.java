package com.tplink.iot.cloud.bean.smart.common;

public class SmartLog
{
  private SmartLogAction actionSetting;
  private String avatarUrl;
  private int code;
  private String id;
  private String smartId;
  private String smartName;
  private String timestamp;
  private int triggerCount;
  private String triggerId;
  private SmartLogTrigger triggerSetting;
  
  public SmartLogAction getActionSetting()
  {
    return this.actionSetting;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getSmartId()
  {
    return this.smartId;
  }
  
  public String getSmartName()
  {
    return this.smartName;
  }
  
  public String getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getTriggerCount()
  {
    return this.triggerCount;
  }
  
  public String getTriggerId()
  {
    return this.triggerId;
  }
  
  public SmartLogTrigger getTriggerSetting()
  {
    return this.triggerSetting;
  }
  
  public void setActionSetting(SmartLogAction paramSmartLogAction)
  {
    this.actionSetting = paramSmartLogAction;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setSmartId(String paramString)
  {
    this.smartId = paramString;
  }
  
  public void setSmartName(String paramString)
  {
    this.smartName = paramString;
  }
  
  public void setTimestamp(String paramString)
  {
    this.timestamp = paramString;
  }
  
  public void setTriggerCount(int paramInt)
  {
    this.triggerCount = paramInt;
  }
  
  public void setTriggerId(String paramString)
  {
    this.triggerId = paramString;
  }
  
  public void setTriggerSetting(SmartLogTrigger paramSmartLogTrigger)
  {
    this.triggerSetting = paramSmartLogTrigger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */