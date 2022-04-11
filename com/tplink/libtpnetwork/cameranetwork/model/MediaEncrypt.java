package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class MediaEncrypt
{
  private final String enabled;
  
  public MediaEncrypt(String paramString)
  {
    this.enabled = paramString;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final MediaEncrypt copy(String paramString)
  {
    j.e(paramString, "enabled");
    return new MediaEncrypt(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MediaEncrypt))
      {
        paramObject = (MediaEncrypt)paramObject;
        if (j.a(this.enabled, ((MediaEncrypt)paramObject).enabled)) {}
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
  
  public int hashCode()
  {
    String str = this.enabled;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaEncrypt(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MediaEncrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */