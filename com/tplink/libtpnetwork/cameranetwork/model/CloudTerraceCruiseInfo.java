package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class CloudTerraceCruiseInfo
{
  @c("coord")
  private final String coordinate;
  
  public CloudTerraceCruiseInfo(String paramString)
  {
    this.coordinate = paramString;
  }
  
  public final String component1()
  {
    return this.coordinate;
  }
  
  public final CloudTerraceCruiseInfo copy(String paramString)
  {
    j.e(paramString, "coordinate");
    return new CloudTerraceCruiseInfo(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CloudTerraceCruiseInfo))
      {
        paramObject = (CloudTerraceCruiseInfo)paramObject;
        if (j.a(this.coordinate, ((CloudTerraceCruiseInfo)paramObject).coordinate)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getCoordinate()
  {
    return this.coordinate;
  }
  
  public int hashCode()
  {
    String str = this.coordinate;
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
    localStringBuilder.append("CloudTerraceCruiseInfo(coordinate=");
    localStringBuilder.append(this.coordinate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CloudTerraceCruiseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */