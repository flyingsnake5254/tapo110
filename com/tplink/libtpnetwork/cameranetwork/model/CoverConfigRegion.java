package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class CoverConfigRegion
{
  private final String height;
  private final String width;
  @c("x_coor")
  private final String x;
  @c("y_coor")
  private final String y;
  
  public CoverConfigRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(String.valueOf(paramInt4), String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramInt2));
  }
  
  public CoverConfigRegion(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.height = paramString1;
    this.width = paramString2;
    this.x = paramString3;
    this.y = paramString4;
  }
  
  public final String component1()
  {
    return this.height;
  }
  
  public final String component2()
  {
    return this.width;
  }
  
  public final String component3()
  {
    return this.x;
  }
  
  public final String component4()
  {
    return this.y;
  }
  
  public final CoverConfigRegion copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString1, "height");
    j.e(paramString2, "width");
    j.e(paramString3, "x");
    j.e(paramString4, "y");
    return new CoverConfigRegion(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CoverConfigRegion))
      {
        paramObject = (CoverConfigRegion)paramObject;
        if ((j.a(this.height, ((CoverConfigRegion)paramObject).height)) && (j.a(this.width, ((CoverConfigRegion)paramObject).width)) && (j.a(this.x, ((CoverConfigRegion)paramObject).x)) && (j.a(this.y, ((CoverConfigRegion)paramObject).y))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getHeight()
  {
    return this.height;
  }
  
  public final String getWidth()
  {
    return this.width;
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
    String str = this.height;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.width;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.x;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.y;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoverConfigRegion(height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CoverConfigRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */