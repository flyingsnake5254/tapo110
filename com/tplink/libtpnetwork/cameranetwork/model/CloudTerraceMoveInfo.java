package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class CloudTerraceMoveInfo
{
  @c("x_coord")
  private final String x;
  @c("y_coord")
  private final String y;
  
  public CloudTerraceMoveInfo(String paramString1, String paramString2)
  {
    this.x = paramString1;
    this.y = paramString2;
  }
  
  public final String component1()
  {
    return this.x;
  }
  
  public final String component2()
  {
    return this.y;
  }
  
  public final CloudTerraceMoveInfo copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "x");
    j.e(paramString2, "y");
    return new CloudTerraceMoveInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CloudTerraceMoveInfo))
      {
        paramObject = (CloudTerraceMoveInfo)paramObject;
        if ((j.a(this.x, ((CloudTerraceMoveInfo)paramObject).x)) && (j.a(this.y, ((CloudTerraceMoveInfo)paramObject).y))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getX()
  {
    return this.x;
  }
  
  public final String getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    String str = this.x;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.y;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloudTerraceMoveInfo(");
    localStringBuilder.append(this.x);
    localStringBuilder.append(',');
    localStringBuilder.append(this.y);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CloudTerraceMoveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */