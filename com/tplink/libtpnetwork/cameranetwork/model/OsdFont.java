package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class OsdFont
{
  private final String color;
  @c("color_type")
  private final String colorType;
  private final String display;
  private final String size;
  
  public OsdFont()
  {
    this(null, null, null, null, 15, null);
  }
  
  public OsdFont(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.size = paramString1;
    this.color = paramString2;
    this.colorType = paramString3;
    this.display = paramString4;
  }
  
  public final String component1()
  {
    return this.size;
  }
  
  public final String component2()
  {
    return this.color;
  }
  
  public final String component3()
  {
    return this.colorType;
  }
  
  public final String component4()
  {
    return this.display;
  }
  
  public final OsdFont copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString1, "size");
    j.e(paramString2, "color");
    j.e(paramString3, "colorType");
    j.e(paramString4, "display");
    return new OsdFont(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OsdFont))
      {
        paramObject = (OsdFont)paramObject;
        if ((j.a(this.size, ((OsdFont)paramObject).size)) && (j.a(this.color, ((OsdFont)paramObject).color)) && (j.a(this.colorType, ((OsdFont)paramObject).colorType)) && (j.a(this.display, ((OsdFont)paramObject).display))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getColor()
  {
    return this.color;
  }
  
  public final String getColorType()
  {
    return this.colorType;
  }
  
  public final String getDisplay()
  {
    return this.display;
  }
  
  public final String getSize()
  {
    return this.size;
  }
  
  public int hashCode()
  {
    String str = this.size;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.color;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.colorType;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.display;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OsdFont(size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", color=");
    localStringBuilder.append(this.color);
    localStringBuilder.append(", colorType=");
    localStringBuilder.append(this.colorType);
    localStringBuilder.append(", display=");
    localStringBuilder.append(this.display);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\OsdFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */