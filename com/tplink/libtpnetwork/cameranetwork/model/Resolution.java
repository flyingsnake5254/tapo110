package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class Resolution
{
  private final String resolution;
  private final String secname;
  
  public Resolution(ResolutionType paramResolutionType)
  {
    this("main", paramResolutionType.toString());
  }
  
  public Resolution(String paramString1, String paramString2)
  {
    this.secname = paramString1;
    this.resolution = paramString2;
  }
  
  public final String component1()
  {
    return this.secname;
  }
  
  public final String component2()
  {
    return this.resolution;
  }
  
  public final Resolution copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "secname");
    j.e(paramString2, "resolution");
    return new Resolution(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Resolution))
      {
        paramObject = (Resolution)paramObject;
        if ((j.a(this.secname, ((Resolution)paramObject).secname)) && (j.a(this.resolution, ((Resolution)paramObject).resolution))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getResolution()
  {
    return this.resolution;
  }
  
  public final String getSecname()
  {
    return this.secname;
  }
  
  public int hashCode()
  {
    String str = this.secname;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.resolution;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Resolution(secname=");
    localStringBuilder.append(this.secname);
    localStringBuilder.append(", resolution=");
    localStringBuilder.append(this.resolution);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Resolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */