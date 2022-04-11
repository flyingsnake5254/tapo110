package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class CoverConfig
{
  private final String enabled;
  
  public CoverConfig(String paramString)
  {
    this.enabled = paramString;
  }
  
  public CoverConfig(boolean paramBoolean)
  {
    this(str);
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final CoverConfig copy(String paramString)
  {
    j.e(paramString, "enabled");
    return new CoverConfig(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CoverConfig))
      {
        paramObject = (CoverConfig)paramObject;
        if (j.a(this.enabled, ((CoverConfig)paramObject).enabled)) {}
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
    localStringBuilder.append("CoverConfig(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CoverConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */