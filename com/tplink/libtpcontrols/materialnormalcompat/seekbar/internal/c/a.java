package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

public class a
  extends c
  implements Animatable
{
  private int H3;
  private int I3;
  private int J3;
  private int K3;
  private int L3;
  private final Runnable M3 = new a();
  private boolean p0 = false;
  private boolean p1 = false;
  private int p2 = 250;
  private float p3;
  private float x = 0.0F;
  private Interpolator y = new AccelerateDecelerateInterpolator();
  private long z;
  
  public a(@NonNull ColorStateList paramColorStateList)
  {
    super(paramColorStateList);
    this.I3 = paramColorStateList.getColorForState(new int[] { 16842908 }, -65536);
    this.H3 = paramColorStateList.getColorForState(new int[] { 16842919 }, -65536);
    this.J3 = paramColorStateList.getColorForState(new int[] { -16842910 }, -65536);
  }
  
  private int m(int paramInt)
  {
    return paramInt * 100 >> 8;
  }
  
  private void n(float paramFloat)
  {
    float f1 = this.p3;
    float f2;
    if (this.p0) {
      f2 = 0.0F;
    } else {
      f2 = 1.0F;
    }
    this.x = (f1 + (f2 - f1) * paramFloat);
    invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    Rect localRect = getBounds();
    int i = Math.min(localRect.width(), localRect.height());
    float f1 = this.x;
    int j = this.K3;
    int k = this.L3;
    float f2 = i / 2.0F;
    if (f1 > 0.0F)
    {
      if (k != 0)
      {
        paramPaint.setColor(k);
        paramPaint.setAlpha(m(Color.alpha(k)));
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2, paramPaint);
      }
      if (j != 0)
      {
        paramPaint.setColor(j);
        paramPaint.setAlpha(b(Color.alpha(j)));
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2 * f1, paramPaint);
      }
    }
  }
  
  public boolean isRunning()
  {
    return this.p1;
  }
  
  public void k()
  {
    unscheduleSelf(this.M3);
    float f = this.x;
    if (f > 0.0F)
    {
      this.p0 = true;
      this.p1 = true;
      this.p3 = f;
      this.p2 = ((int)((1.0F - (f - 1.0F) / -1.0F) * 250.0F));
      long l = SystemClock.uptimeMillis();
      this.z = l;
      scheduleSelf(this.M3, l + 16L);
    }
  }
  
  public void l()
  {
    unscheduleSelf(this.M3);
    float f = this.x;
    if (f < 1.0F)
    {
      this.p0 = false;
      this.p1 = true;
      this.p3 = f;
      this.p2 = ((int)((1.0F - (f - 0.0F) / 1.0F) * 250.0F));
      long l = SystemClock.uptimeMillis();
      this.z = l;
      scheduleSelf(this.M3, l + 16L);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = getState();
    int i = arrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfInt[j] == 16842919)
      {
        j = 1;
        break label41;
      }
    }
    j = 0;
    label41:
    super.setState(paramArrayOfInt);
    int k = paramArrayOfInt.length;
    int m = 0;
    int n = 1;
    int i1 = 0;
    int i3;
    for (i = 0; m < k; i = i3)
    {
      int i2 = paramArrayOfInt[m];
      int i4;
      if (i2 == 16842908)
      {
        i3 = 1;
        i4 = i1;
      }
      else if (i2 == 16842919)
      {
        i4 = 1;
        i3 = i;
      }
      else
      {
        i4 = i1;
        i3 = i;
        if (i2 == 16842910)
        {
          n = 0;
          i3 = i;
          i4 = i1;
        }
      }
      m++;
      i1 = i4;
    }
    if (n != 0)
    {
      unscheduleSelf(this.M3);
      this.K3 = this.J3;
      this.L3 = 0;
      this.x = 0.5F;
      invalidateSelf();
    }
    else if (i1 != 0)
    {
      l();
      j = this.H3;
      this.L3 = j;
      this.K3 = j;
    }
    else if (j != 0)
    {
      j = this.H3;
      this.L3 = j;
      this.K3 = j;
      k();
    }
    else if (i != 0)
    {
      this.K3 = this.I3;
      this.L3 = 0;
      this.x = 1.0F;
      invalidateSelf();
    }
    else
    {
      this.K3 = 0;
      this.L3 = 0;
      this.x = 0.0F;
      invalidateSelf();
    }
    return true;
  }
  
  public void start() {}
  
  public void stop() {}
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = l1 - a.e(a.this);
      a locala;
      if (l2 < a.f(a.this))
      {
        float f = a.g(a.this).getInterpolation((float)l2 / a.f(a.this));
        locala = a.this;
        locala.scheduleSelf(a.h(locala), l1 + 16L);
        a.i(a.this, f);
      }
      else
      {
        locala = a.this;
        locala.unscheduleSelf(a.h(locala));
        a.j(a.this, false);
        a.i(a.this, 1.0F);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */