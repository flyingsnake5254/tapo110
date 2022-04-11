package com.tplink.cloud.bean.account.params;

public class TopicSubscriptionParams
{
  private String email;
  private String productLine;
  
  public TopicSubscriptionParams() {}
  
  public TopicSubscriptionParams(String paramString1, String paramString2)
  {
    this.email = paramString1;
    this.productLine = paramString2;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getProductLine()
  {
    return this.productLine;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setProductLine(String paramString)
  {
    this.productLine = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\TopicSubscriptionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */