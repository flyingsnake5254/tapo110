package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class PubIp
{
  private String ip;
  
  public PubIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public final String component1()
  {
    return this.ip;
  }
  
  public final PubIp copy(String paramString)
  {
    return new PubIp(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PubIp))
      {
        paramObject = (PubIp)paramObject;
        if (j.a(this.ip, ((PubIp)paramObject).ip)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getIp()
  {
    return this.ip;
  }
  
  public int hashCode()
  {
    String str = this.ip;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PubIp(ip=");
    localStringBuilder.append(this.ip);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\PubIp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */