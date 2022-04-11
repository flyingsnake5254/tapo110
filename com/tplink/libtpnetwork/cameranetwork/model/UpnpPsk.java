package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class UpnpPsk
{
  private String psk;
  @c("psk_identity")
  private String pskIdentity;
  
  public UpnpPsk(String paramString1, String paramString2)
  {
    this.psk = paramString1;
    this.pskIdentity = paramString2;
  }
  
  public final String component1()
  {
    return this.psk;
  }
  
  public final String component2()
  {
    return this.pskIdentity;
  }
  
  public final UpnpPsk copy(String paramString1, String paramString2)
  {
    return new UpnpPsk(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpnpPsk))
      {
        paramObject = (UpnpPsk)paramObject;
        if ((j.a(this.psk, ((UpnpPsk)paramObject).psk)) && (j.a(this.pskIdentity, ((UpnpPsk)paramObject).pskIdentity))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getPsk()
  {
    return this.psk;
  }
  
  public final String getPskIdentity()
  {
    return this.pskIdentity;
  }
  
  public int hashCode()
  {
    String str = this.psk;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.pskIdentity;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setPsk(String paramString)
  {
    this.psk = paramString;
  }
  
  public final void setPskIdentity(String paramString)
  {
    this.pskIdentity = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpnpPsk(psk=");
    localStringBuilder.append(this.psk);
    localStringBuilder.append(", pskIdentity=");
    localStringBuilder.append(this.pskIdentity);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\UpnpPsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */