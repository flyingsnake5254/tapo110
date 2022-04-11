package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class DefaultAp
{
  private final String ssid;
  private final String status;
  
  public DefaultAp(String paramString1, String paramString2)
  {
    this.ssid = paramString1;
    this.status = paramString2;
  }
  
  public final String component1()
  {
    return this.ssid;
  }
  
  public final String component2()
  {
    return this.status;
  }
  
  public final DefaultAp copy(String paramString1, String paramString2)
  {
    return new DefaultAp(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DefaultAp))
      {
        paramObject = (DefaultAp)paramObject;
        if ((j.a(this.ssid, ((DefaultAp)paramObject).ssid)) && (j.a(this.status, ((DefaultAp)paramObject).status))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getSsid()
  {
    return this.ssid;
  }
  
  public final String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    String str = this.ssid;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.status;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultAp(ssid=");
    localStringBuilder.append(this.ssid);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DefaultAp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */