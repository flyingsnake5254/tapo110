package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class MarkedPositionInfo
  implements Cloneable
{
  private final Object fileOrBitmap;
  private final int id;
  private final String name;
  private final Double positionPan;
  private final Double positionTilt;
  private final Integer readOnly;
  
  public MarkedPositionInfo(int paramInt, String paramString, Integer paramInteger, Double paramDouble1, Double paramDouble2, Object paramObject)
  {
    this.id = paramInt;
    this.name = paramString;
    this.readOnly = paramInteger;
    this.positionPan = paramDouble1;
    this.positionTilt = paramDouble2;
    this.fileOrBitmap = paramObject;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return copy$default(this, 0, null, null, null, null, null, 63, null);
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final String component2()
  {
    return this.name;
  }
  
  public final Integer component3()
  {
    return this.readOnly;
  }
  
  public final Double component4()
  {
    return this.positionPan;
  }
  
  public final Double component5()
  {
    return this.positionTilt;
  }
  
  public final Object component6()
  {
    return this.fileOrBitmap;
  }
  
  public final MarkedPositionInfo copy(int paramInt, String paramString, Integer paramInteger, Double paramDouble1, Double paramDouble2, Object paramObject)
  {
    j.e(paramString, "name");
    j.e(paramObject, "fileOrBitmap");
    return new MarkedPositionInfo(paramInt, paramString, paramInteger, paramDouble1, paramDouble2, paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MarkedPositionInfo))
      {
        paramObject = (MarkedPositionInfo)paramObject;
        if ((this.id == ((MarkedPositionInfo)paramObject).id) && (j.a(this.name, ((MarkedPositionInfo)paramObject).name)) && (j.a(this.readOnly, ((MarkedPositionInfo)paramObject).readOnly)) && (j.a(this.positionPan, ((MarkedPositionInfo)paramObject).positionPan)) && (j.a(this.positionTilt, ((MarkedPositionInfo)paramObject).positionTilt)) && (j.a(this.fileOrBitmap, ((MarkedPositionInfo)paramObject).fileOrBitmap))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Object getFileOrBitmap()
  {
    return this.fileOrBitmap;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final Double getPositionPan()
  {
    return this.positionPan;
  }
  
  public final Double getPositionTilt()
  {
    return this.positionTilt;
  }
  
  public final Integer getReadOnly()
  {
    return this.readOnly;
  }
  
  public int hashCode()
  {
    int i = this.id;
    Object localObject = this.name;
    int j = 0;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.readOnly;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.positionPan;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.positionTilt;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.fileOrBitmap;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MarkedPositionInfo(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", readOnly=");
    localStringBuilder.append(this.readOnly);
    localStringBuilder.append(", positionPan=");
    localStringBuilder.append(this.positionPan);
    localStringBuilder.append(", positionTilt=");
    localStringBuilder.append(this.positionTilt);
    localStringBuilder.append(", fileOrBitmap=");
    localStringBuilder.append(this.fileOrBitmap);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MarkedPositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */