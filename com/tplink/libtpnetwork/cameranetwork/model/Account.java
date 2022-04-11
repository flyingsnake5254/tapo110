package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.a;
import kotlin.jvm.internal.j;

public final class Account
{
  @a(deserialize=false, serialize=false)
  private final boolean hashed;
  private final String password;
  private final String username;
  
  public Account(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.username = paramString1;
    this.password = paramString2;
    this.hashed = paramBoolean;
  }
  
  public final String component1()
  {
    return this.username;
  }
  
  public final String component2()
  {
    return this.password;
  }
  
  public final boolean component3()
  {
    return this.hashed;
  }
  
  public final Account copy(String paramString1, String paramString2, boolean paramBoolean)
  {
    j.e(paramString1, "username");
    j.e(paramString2, "password");
    return new Account(paramString1, paramString2, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Account))
      {
        paramObject = (Account)paramObject;
        if ((j.a(this.username, ((Account)paramObject).username)) && (j.a(this.password, ((Account)paramObject).password)) && (this.hashed == ((Account)paramObject).hashed)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getHashed()
  {
    return this.hashed;
  }
  
  public final String getPassword()
  {
    return this.password;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public int hashCode()
  {
    String str = this.username;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.password;
    if (str != null) {
      i = str.hashCode();
    }
    int k = this.hashed;
    int m = k;
    if (k != 0) {
      m = 1;
    }
    return (j * 31 + i) * 31 + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Account(username=");
    localStringBuilder.append(this.username);
    localStringBuilder.append(", password=");
    localStringBuilder.append(this.password);
    localStringBuilder.append(", hashed=");
    localStringBuilder.append(this.hashed);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Account.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */