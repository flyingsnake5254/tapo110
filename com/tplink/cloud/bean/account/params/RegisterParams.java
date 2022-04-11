package com.tplink.cloud.bean.account.params;

import java.util.Map;

public class RegisterParams
{
  private String cloudPassword;
  private String countryCode;
  private String email;
  private String locale;
  private String nickname;
  private String productLine;
  private Map<String, Boolean> topicSubscription;
  @Deprecated
  private String username;
  
  public RegisterParams() {}
  
  public RegisterParams(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.email = paramString1;
    this.nickname = paramString2;
    this.cloudPassword = paramString3;
    this.locale = paramString4;
  }
  
  public RegisterParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<String, Boolean> paramMap)
  {
    this.email = paramString1;
    this.nickname = paramString2;
    this.cloudPassword = paramString3;
    this.locale = paramString4;
    this.countryCode = paramString5;
    this.productLine = paramString6;
    this.topicSubscription = paramMap;
  }
  
  public String getCloudPassword()
  {
    return this.cloudPassword;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getProductLine()
  {
    return this.productLine;
  }
  
  public Map<String, Boolean> getTopicSubscription()
  {
    return this.topicSubscription;
  }
  
  @Deprecated
  public String getUsername()
  {
    return this.username;
  }
  
  public void setCloudPassword(String paramString)
  {
    this.cloudPassword = paramString;
  }
  
  public void setCountryCode(String paramString)
  {
    this.countryCode = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setProductLine(String paramString)
  {
    this.productLine = paramString;
  }
  
  public void setTopicSubscription(Map<String, Boolean> paramMap)
  {
    this.topicSubscription = paramMap;
  }
  
  @Deprecated
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\RegisterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */