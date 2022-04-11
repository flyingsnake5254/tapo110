package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class AccountInfoCache
{
  private String username;
  
  public AccountInfoCache(String paramString)
  {
    this.username = paramString;
  }
  
  public final String component1()
  {
    return this.username;
  }
  
  public final AccountInfoCache copy(String paramString)
  {
    return new AccountInfoCache(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AccountInfoCache))
      {
        paramObject = (AccountInfoCache)paramObject;
        if (j.a(this.username, ((AccountInfoCache)paramObject).username)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public int hashCode()
  {
    String str = this.username;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AccountInfoCache(username=");
    localStringBuilder.append(this.username);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AccountInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */