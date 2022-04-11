package com.tplink.iot.cloud.bean.auth.result;

import com.google.gson.q.c;

public class AuthResult
{
  private long expireTimeMillis;
  @c("jwtExpiresIn")
  private long expires;
  @c("jwt")
  private String jsonWebToken;
  
  public long getExpireTimeMillis()
  {
    return this.expireTimeMillis;
  }
  
  public long getExpires()
  {
    return this.expires;
  }
  
  public String getJsonWebToken()
  {
    return this.jsonWebToken;
  }
  
  public boolean isExpired()
  {
    boolean bool;
    if (this.expireTimeMillis < System.currentTimeMillis()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setExpireTimeMillis(long paramLong)
  {
    this.expireTimeMillis = paramLong;
  }
  
  public void setExpires(long paramLong)
  {
    this.expires = paramLong;
  }
  
  public void setJsonWebToken(String paramString)
  {
    this.jsonWebToken = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\auth\result\AuthResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */