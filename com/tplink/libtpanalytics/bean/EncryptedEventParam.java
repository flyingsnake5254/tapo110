package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

public class EncryptedEventParam
{
  @c("taid")
  private String accountId;
  @c("ac")
  private String action;
  @c("cg")
  private String category;
  @c("ct")
  private String content;
  @c("lb")
  private String label;
  @c("lsc")
  private String lastScreenClass;
  @c("lsn")
  private String lastScreenName;
  @c("lv")
  private String lastVersion;
  @c("nt")
  private String netWorkType;
  @c("sc")
  private String screenClass;
  @c("sn")
  private String screenName;
  @c("va")
  private String value;
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public String getLastScreenClass()
  {
    return this.lastScreenClass;
  }
  
  public String getLastScreenName()
  {
    return this.lastScreenName;
  }
  
  public String getLastVersion()
  {
    return this.lastVersion;
  }
  
  public String getNetWorkType()
  {
    return this.netWorkType;
  }
  
  public String getScreenClass()
  {
    return this.screenClass;
  }
  
  public String getScreenName()
  {
    return this.screenName;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLastScreenClass(String paramString)
  {
    this.lastScreenClass = paramString;
  }
  
  public void setLastScreenName(String paramString)
  {
    this.lastScreenName = paramString;
  }
  
  public void setLastVersion(String paramString)
  {
    this.lastVersion = paramString;
  }
  
  public void setNetWorkType(String paramString)
  {
    this.netWorkType = paramString;
  }
  
  public void setScreenClass(String paramString)
  {
    this.screenClass = paramString;
  }
  
  public void setScreenName(String paramString)
  {
    this.screenName = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncryptedEventParam{screenClass='");
    localStringBuilder.append(this.screenClass);
    localStringBuilder.append('\'');
    localStringBuilder.append(", screenName='");
    localStringBuilder.append(this.screenName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", netWorkType='");
    localStringBuilder.append(this.netWorkType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastScreenClass='");
    localStringBuilder.append(this.lastScreenClass);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastScreenName='");
    localStringBuilder.append(this.lastScreenName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", category='");
    localStringBuilder.append(this.category);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action='");
    localStringBuilder.append(this.action);
    localStringBuilder.append('\'');
    localStringBuilder.append(", label='");
    localStringBuilder.append(this.label);
    localStringBuilder.append('\'');
    localStringBuilder.append(", value='");
    localStringBuilder.append(this.value);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastVersion='");
    localStringBuilder.append(this.lastVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.content);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountId='");
    localStringBuilder.append(this.accountId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\EncryptedEventParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */