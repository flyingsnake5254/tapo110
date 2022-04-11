package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

public abstract class c
  extends Drawable
{
  private ColorStateList c;
  private final Paint d;
  private int f;
  private int q = 255;
  
  public c(@NonNull ColorStateList paramColorStateList)
  {
    this.c = paramColorStateList;
    this.f = paramColorStateList.getDefaultColor();
    this.d = new Paint(1);
  }
  
  private boolean d(int[] paramArrayOfInt)
  {
    int i = this.c.getColorForState(paramArrayOfInt, this.f);
    if (i != this.f)
    {
      this.f = i;
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  abstract void a(Canvas paramCanvas, Paint paramPaint);
  
  int b(int paramInt)
  {
    int i = this.q;
    return paramInt * (i + (i >> 7)) >> 8;
  }
  
  public void c(@NonNull ColorStateList paramColorStateList)
  {
    this.c = paramColorStateList;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.d.setColor(this.f);
    int i = b(Color.alpha(this.f));
    this.d.setAlpha(i);
    a(paramCanvas, this.d);
  }
  
  public int getAlpha()
  {
    return this.q;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    boolean bool;
    if ((!this.c.isStateful()) && (!super.isStateful())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    this.q = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = super.setState(paramArrayOfInt);
    if ((!d(paramArrayOfInt)) && (!bool)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */