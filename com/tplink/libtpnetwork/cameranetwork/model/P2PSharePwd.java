package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class P2PSharePwd
{
  private final String sharepwd;
  private final String username;
  
  public P2PSharePwd(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.sharepwd = paramString2;
  }
  
  public final String component1()
  {
    return this.username;
  }
  
  public final String component2()
  {
    return this.sharepwd;
  }
  
  public final P2PSharePwd copy(String paramString1, String paramString2)
  {
    j.e(paramString2, "sharepwd");
    return new P2PSharePwd(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof P2PSharePwd))
      {
        paramObject = (P2PSharePwd)paramObject;
        if ((j.a(this.username, ((P2PSharePwd)paramObject).username)) && (j.a(this.sharepwd, ((P2PSharePwd)paramObject).sharepwd))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getSharepwd()
  {
    return this.sharepwd;
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
    str = this.sharepwd;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("P2PSharePwd(username=");
    localStringBuilder.append(this.username);
    localStringBuilder.append(", sharepwd=");
    localStringBuilder.append(this.sharepwd);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\P2PSharePwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */