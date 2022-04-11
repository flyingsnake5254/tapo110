package com.tplink.iot.adapter.deviceshare;

import java.io.Serializable;

public class RecordUserBean
  implements Serializable
{
  private String cloudUserName;
  private String nickname;
  
  public RecordUserBean(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public RecordUserBean(String paramString1, String paramString2)
  {
    this.cloudUserName = paramString1;
    this.nickname = paramString2;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public String toString()
  {
    String str1 = this.cloudUserName;
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    return str2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\RecordUserBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */