package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class TapoCareList
{
  private String name;
  private Integer version;
  
  public TapoCareList(String paramString, Integer paramInteger)
  {
    this.name = paramString;
    this.version = paramInteger;
  }
  
  public final String component1()
  {
    return this.name;
  }
  
  public final Integer component2()
  {
    return this.version;
  }
  
  public final TapoCareList copy(String paramString, Integer paramInteger)
  {
    return new TapoCareList(paramString, paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TapoCareList))
      {
        paramObject = (TapoCareList)paramObject;
        if ((j.a(this.name, ((TapoCareList)paramObject).name)) && (j.a(this.version, ((TapoCareList)paramObject).version))) {}
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
  
  public final Integer getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    Object localObject = this.name;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.version;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public final void setVersion(Integer paramInteger)
  {
    this.version = paramInteger;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TapoCareList(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\TapoCareList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */