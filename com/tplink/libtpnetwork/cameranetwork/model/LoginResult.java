package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class LoginResult
{
  @c("user_group")
  private final String group;
  @c("stok")
  private final String token;
  
  public LoginResult(String paramString1, String paramString2)
  {
    this.group = paramString1;
    this.token = paramString2;
  }
  
  public final String component1()
  {
    return this.group;
  }
  
  public final String component2()
  {
    return this.token;
  }
  
  public final LoginResult copy(String paramString1, String paramString2)
  {
    j.e(paramString2, "token");
    return new LoginResult(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LoginResult))
      {
        paramObject = (LoginResult)paramObject;
        if ((j.a(this.group, ((LoginResult)paramObject).group)) && (j.a(this.token, ((LoginResult)paramObject).token))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getGroup()
  {
    return this.group;
  }
  
  public final String getToken()
  {
    return this.token;
  }
  
  public int hashCode()
  {
    String str = this.group;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.token;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginResult(group=");
    localStringBuilder.append(this.group);
    localStringBuilder.append(", token=");
    localStringBuilder.append(this.token);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\LoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */