package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class CloudTerraceMoveStepInfo
{
  private final String direction;
  
  public CloudTerraceMoveStepInfo(String paramString)
  {
    this.direction = paramString;
  }
  
  public final String component1()
  {
    return this.direction;
  }
  
  public final CloudTerraceMoveStepInfo copy(String paramString)
  {
    j.e(paramString, "direction");
    return new CloudTerraceMoveStepInfo(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CloudTerraceMoveStepInfo))
      {
        paramObject = (CloudTerraceMoveStepInfo)paramObject;
        if (j.a(this.direction, ((CloudTerraceMoveStepInfo)paramObject).direction)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDirection()
  {
    return this.direction;
  }
  
  public int hashCode()
  {
    String str = this.direction;
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
    localStringBuilder.append("CloudTerraceMoveStepInfo(direction=");
    localStringBuilder.append(this.direction);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CloudTerraceMoveStepInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */