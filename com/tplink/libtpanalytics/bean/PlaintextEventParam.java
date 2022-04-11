package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

public class PlaintextEventParam
{
  @c("ac")
  private String action;
  @c("cg")
  private String category;
  @c("et")
  private String exceptionTimeStamp;
  @c("lsc")
  private String lastScreenClass;
  @c("lsn")
  private String lastScreenName;
  @c("sc")
  private String screenClass;
  @c("sn")
  private String screenName;
  @c("sid")
  private int sessionId;
  
  public String getAction()
  {
    return this.action;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getExceptionTimeStamp()
  {
    return this.exceptionTimeStamp;
  }
  
  public String getLastScreenClass()
  {
    return this.lastScreenClass;
  }
  
  public String getLastScreenName()
  {
    return this.lastScreenName;
  }
  
  public String getScreenClass()
  {
    return this.screenClass;
  }
  
  public String getScreenName()
  {
    return this.screenName;
  }
  
  public int getSessionId()
  {
    return this.sessionId;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setExceptionTimeStamp(String paramString)
  {
    this.exceptionTimeStamp = paramString;
  }
  
  public void setLastScreenClass(String paramString)
  {
    this.lastScreenClass = paramString;
  }
  
  public void setLastScreenName(String paramString)
  {
    this.lastScreenName = paramString;
  }
  
  public void setScreenClass(String paramString)
  {
    this.screenClass = paramString;
  }
  
  public void setScreenName(String paramString)
  {
    this.screenName = paramString;
  }
  
  public void setSessionId(int paramInt)
  {
    this.sessionId = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlaintextEventParam{sessionId=");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append(", screenClass='");
    localStringBuilder.append(this.screenClass);
    localStringBuilder.append('\'');
    localStringBuilder.append(", screenName='");
    localStringBuilder.append(this.screenName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastScreenName='");
    localStringBuilder.append(this.lastScreenName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastScreenClass='");
    localStringBuilder.append(this.lastScreenClass);
    localStringBuilder.append('\'');
    localStringBuilder.append(", category='");
    localStringBuilder.append(this.category);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action='");
    localStringBuilder.append(this.action);
    localStringBuilder.append('\'');
    localStringBuilder.append(", exceptionTimeStamp='");
    localStringBuilder.append(this.exceptionTimeStamp);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\PlaintextEventParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */