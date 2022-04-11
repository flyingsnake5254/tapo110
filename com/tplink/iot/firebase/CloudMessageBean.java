package com.tplink.iot.firebase;

import java.io.Serializable;

public class CloudMessageBean
  implements Serializable
{
  private String alias;
  private String content;
  private int deviceCount;
  private String deviceId;
  private String imgUrl;
  private String messageId;
  private String messageType;
  private String summaryDate;
  private String taskId;
  private String timestamp;
  private String title;
  private String userName;
  private String uuid;
  
  public CloudMessageBean(String paramString1, String paramString2, String paramString3)
  {
    this.messageId = paramString1;
    this.messageType = paramString2;
    this.timestamp = paramString3;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getDeviceCount()
  {
    return this.deviceCount;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getImgUrl()
  {
    return this.imgUrl;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public String getMessageType()
  {
    return this.messageType;
  }
  
  public String getSummaryDate()
  {
    return this.summaryDate;
  }
  
  public String getTaskId()
  {
    return this.taskId;
  }
  
  public String getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setDeviceCount(int paramInt)
  {
    this.deviceCount = paramInt;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setImgUrl(String paramString)
  {
    this.imgUrl = paramString;
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public void setMessageType(String paramString)
  {
    this.messageType = paramString;
  }
  
  public void setSummaryDate(String paramString)
  {
    this.summaryDate = paramString;
  }
  
  public void setTaskId(String paramString)
  {
    this.taskId = paramString;
  }
  
  public void setTimestamp(String paramString)
  {
    this.timestamp = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\firebase\CloudMessageBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */