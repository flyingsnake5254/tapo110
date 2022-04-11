package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class MarkPositionConfirmInfo
{
  private final int id;
  private final String name;
  
  public MarkPositionConfirmInfo(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.name = paramString;
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final String component2()
  {
    return this.name;
  }
  
  public final MarkPositionConfirmInfo copy(int paramInt, String paramString)
  {
    j.e(paramString, "name");
    return new MarkPositionConfirmInfo(paramInt, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MarkPositionConfirmInfo))
      {
        paramObject = (MarkPositionConfirmInfo)paramObject;
        if ((this.id == ((MarkPositionConfirmInfo)paramObject).id) && (j.a(this.name, ((MarkPositionConfirmInfo)paramObject).name))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    int i = this.id;
    String str = this.name;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MarkPositionConfirmInfo(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MarkPositionConfirmInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */