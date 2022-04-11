package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class OsdElement
{
  private String enabled;
  private String text;
  @c("x_coor")
  private final String x;
  @c("y_coor")
  private final String y;
  
  public OsdElement(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.x = paramString1;
    this.y = paramString2;
    this.text = paramString3;
    this.enabled = paramString4;
  }
  
  public final String component1()
  {
    return this.x;
  }
  
  public final String component2()
  {
    return this.y;
  }
  
  public final String component3()
  {
    return this.text;
  }
  
  public final String component4()
  {
    return this.enabled;
  }
  
  public final OsdElement copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString1, "x");
    j.e(paramString2, "y");
    j.e(paramString4, "enabled");
    return new OsdElement(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OsdElement))
      {
        paramObject = (OsdElement)paramObject;
        if ((j.a(this.x, ((OsdElement)paramObject).x)) && (j.a(this.y, ((OsdElement)paramObject).y)) && (j.a(this.text, ((OsdElement)paramObject).text)) && (j.a(this.enabled, ((OsdElement)paramObject).enabled))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getText()
  {
    return this.text;
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
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.text;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.enabled;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public final void setEnabled(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.enabled = paramString;
  }
  
  public final void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OsdElement(x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", text=");
    localStringBuilder.append(this.text);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\OsdElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */