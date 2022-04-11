package com.tplink.libtpnetwork.libwss.bean.params;

import com.google.gson.q.c;

public class SkillActiveParams
{
  @c("amznAuthCode")
  private String amazonAuthCode;
  @c("code")
  private String code;
  @c("error")
  private String error;
  @c("scope")
  private String scope;
  @c("state")
  private String state;
  
  public String getAmazonAuthCode()
  {
    return this.amazonAuthCode;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getError()
  {
    return this.error;
  }
  
  public String getScope()
  {
    return this.scope;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setAmazonAuthCode(String paramString)
  {
    this.amazonAuthCode = paramString;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setError(String paramString)
  {
    this.error = paramString;
  }
  
  public void setScope(String paramString)
  {
    this.scope = paramString;
  }
  
  public void setState(String paramString)
  {
    this.state = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\params\SkillActiveParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */