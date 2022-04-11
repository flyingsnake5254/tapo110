package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class Wan
{
  @c("ipaddr")
  private String ipAddress;
  
  public Wan(String paramString)
  {
    this.ipAddress = paramString;
  }
  
  public final String component1()
  {
    return this.ipAddress;
  }
  
  public final Wan copy(String paramString)
  {
    j.e(paramString, "ipAddress");
    return new Wan(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Wan))
      {
        paramObject = (Wan)paramObject;
        if (j.a(this.ipAddress, ((Wan)paramObject).ipAddress)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getIpAddress()
  {
    return this.ipAddress;
  }
  
  public int hashCode()
  {
    String str = this.ipAddress;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setIpAddress(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.ipAddress = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wan(ipAddress=");
    localStringBuilder.append(this.ipAddress);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Wan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */