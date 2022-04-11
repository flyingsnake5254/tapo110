package com.tplink.libtpgoogleassistant.bean.params;

public class AuthClientListParams
{
  private String token;
  
  public AuthClientListParams() {}
  
  public AuthClientListParams(String paramString)
  {
    this.token = paramString;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpgoogleassistant\bean\params\AuthClientListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */