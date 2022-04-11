package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class CloudTerracePoint
{
  private final String name;
  @c("save_ptz")
  private final String xyz;
  
  public CloudTerracePoint(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.xyz = paramString2;
  }
  
  public final String component1()
  {
    return this.name;
  }
  
  public final String component2()
  {
    return this.xyz;
  }
  
  public final CloudTerracePoint copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "name");
    j.e(paramString2, "xyz");
    return new CloudTerracePoint(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CloudTerracePoint))
      {
        paramObject = (CloudTerracePoint)paramObject;
        if ((j.a(this.name, ((CloudTerracePoint)paramObject).name)) && (j.a(this.xyz, ((CloudTerracePoint)paramObject).xyz))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final String getXyz()
  {
    return this.xyz;
  }
  
  public int hashCode()
  {
    String str = this.name;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.xyz;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloudTerracePoint(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", xyz=");
    localStringBuilder.append(this.xyz);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CloudTerracePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */