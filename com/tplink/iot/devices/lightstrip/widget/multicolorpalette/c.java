package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;

public final class c
{
  private static final c a = new c(0, 0, 0);
  public static final a b = new a(null);
  private int c;
  private int d;
  private int e;
  
  public c(@IntRange(from=0L, to=360L) int paramInt1, @IntRange(from=0L, to=100L) int paramInt2, @IntRange(from=0L, to=100L) int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public c(float[] paramArrayOfFloat)
  {
    this(i, (int)(f1 * f2), (int)(paramArrayOfFloat[2] * f2));
  }
  
  public final int a()
  {
    return this.e;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final float[] d()
  {
    return new float[] { this.c / 360.0F, this.d / 100.0F, this.e / 100.0F };
  }
  
  public final void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.c == ((c)paramObject).c) && (this.d == ((c)paramObject).d) && (this.e == ((c)paramObject).e)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @ColorInt
  public final int f()
  {
    return Color.HSVToColor(new float[] { this.c, this.d / 100.0F, this.e / 100.0F });
  }
  
  @ColorInt
  public final int g()
  {
    return Color.HSVToColor(new float[] { this.c, this.d / 100.0F, 1.0F });
  }
  
  public final float[] h()
  {
    return new float[] { this.c, this.d, this.e };
  }
  
  public int hashCode()
  {
    return (this.c * 31 + this.d) * 31 + this.e;
  }
  
  public final d i()
  {
    return d.a.a(g());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HSB(hue=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", saturation=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", brightness=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final c a()
    {
      kotlin.u.c.a locala = kotlin.u.c.b;
      return new c(locala.d(0, 360), locala.d(0, 100), 100);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\multicolorpalette\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */