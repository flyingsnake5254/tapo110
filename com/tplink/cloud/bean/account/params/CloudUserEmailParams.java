package com.tplink.cloud.bean.account.params;

public class CloudUserEmailParams
{
  private String email;
  private String locale;
  
  public CloudUserEmailParams() {}
  
  public CloudUserEmailParams(String paramString1, String paramString2)
  {
    this.email = paramString1;
    this.locale = paramString2;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\CloudUserEmailParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */