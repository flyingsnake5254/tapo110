package com.tplink.nbu.bean.iam;

public class Event
{
  private String accountId;
  private String appType;
  private String os;
  private String taskId;
  private String type;
  private long unixTimestampUtc;
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getOs()
  {
    return this.os;
  }
  
  public String getTaskId()
  {
    return this.taskId;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public long getUnixTimestampUtc()
  {
    return this.unixTimestampUtc;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setOs(String paramString)
  {
    this.os = paramString;
  }
  
  public void setTaskId(String paramString)
  {
    this.taskId = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUnixTimestampUtc(long paramLong)
  {
    this.unixTimestampUtc = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\bean\iam\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */