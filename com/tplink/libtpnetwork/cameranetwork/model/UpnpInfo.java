package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class UpnpInfo
{
  private String enabled;
  private String mode;
  
  public UpnpInfo(String paramString1, String paramString2)
  {
    this.enabled = paramString1;
    this.mode = paramString2;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final String component2()
  {
    return this.mode;
  }
  
  public final UpnpInfo copy(String paramString1, String paramString2)
  {
    return new UpnpInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpnpInfo))
      {
        paramObject = (UpnpInfo)paramObject;
        if ((j.a(this.enabled, ((UpnpInfo)paramObject).enabled)) && (j.a(this.mode, ((UpnpInfo)paramObject).mode))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getMode()
  {
    return this.mode;
  }
  
  public int hashCode()
  {
    String str = this.enabled;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.mode;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setEnabled(String paramString)
  {
    this.enabled = paramString;
  }
  
  public final void setMode(String paramString)
  {
    this.mode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpnpInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\UpnpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */