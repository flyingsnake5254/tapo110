package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;

public final class d
{
  public static final a a = new a(null);
  private int b;
  private int c;
  private int d;
  
  public d(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public static final d a(@ColorInt int paramInt)
  {
    return a.a(paramInt);
  }
  
  @ColorInt
  public final int b()
  {
    return Color.argb(255, this.b, this.c, this.d);
  }
  
  public final c c()
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(b(), arrayOfFloat);
    int i = (int)arrayOfFloat[0];
    float f1 = arrayOfFloat[1];
    float f2 = 100;
    return new c(i, (int)(f1 * f2), (int)(arrayOfFloat[2] * f2));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.b == ((d)paramObject).b) && (this.c == ((d)paramObject).c) && (this.d == ((d)paramObject).d)) {}
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
    return (this.b * 31 + this.c) * 31 + this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RGB(red=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", green=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", blue=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final d a(@ColorInt int paramInt)
    {
      return new d(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\multicolorpalette\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */