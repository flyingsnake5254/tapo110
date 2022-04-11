package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.graphics.Rect;
import kotlin.jvm.internal.j;

public final class a
{
  private int a;
  private Rect b;
  
  public a()
  {
    this(0, null, 3, null);
  }
  
  public a(int paramInt, Rect paramRect)
  {
    this.a = paramInt;
    this.b = paramRect;
  }
  
  public final Rect a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.a == ((a)paramObject).a) && (j.a(this.b, ((a)paramObject).b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.a;
    Rect localRect = this.b;
    int j;
    if (localRect != null) {
      j = localRect.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorCursor(index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", coordinates=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\multicolorpalette\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */