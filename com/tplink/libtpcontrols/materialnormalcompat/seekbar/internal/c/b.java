package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

public class b
  extends c
  implements Animatable
{
  private float H3;
  private int I3;
  private int J3;
  private int K3;
  Path L3 = new Path();
  RectF M3 = new RectF();
  Matrix N3 = new Matrix();
  private b O3;
  private final Runnable P3 = new a();
  private boolean p0 = false;
  private boolean p1 = false;
  private int p2 = 250;
  private float p3;
  private float x = 0.0F;
  private Interpolator y = new AccelerateDecelerateInterpolator();
  private long z;
  
  public b(@NonNull ColorStateList paramColorStateList, int paramInt)
  {
    super(paramColorStateList);
    this.p3 = paramInt;
    paramInt = paramColorStateList.getDefaultColor();
    this.J3 = paramColorStateList.getColorForState(new int[] { 16842919 }, paramInt);
    this.K3 = paramColorStateList.getDefaultColor();
  }
  
  private static int n(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * paramFloat + f3 * f1), (int)(f4 * paramFloat + f5 * f1), (int)(f6 * paramFloat + f7 * f1), (int)(f8 * paramFloat + f9 * f1));
  }
  
  private void o(Rect paramRect)
  {
    float f1 = this.x;
    Path localPath = this.L3;
    RectF localRectF = this.M3;
    Matrix localMatrix = this.N3;
    localPath.reset();
    int i = Math.min(paramRect.width(), paramRect.height());
    float f2 = this.p3;
    f2 += (i - f2) * f1;
    float f3 = f2 / 2.0F;
    float f4 = 1.0F - f1;
    float f5 = f3 * f4;
    i = paramRect.left;
    f1 = i;
    int j = paramRect.top;
    localRectF.set(f1, j, i + f2, j + f2);
    Path.Direction localDirection = Path.Direction.CCW;
    localPath.addRoundRect(localRectF, new float[] { f3, f3, f3, f3, f3, f3, f5, f5 }, localDirection);
    localMatrix.reset();
    localMatrix.postRotate(-45.0F, paramRect.left + f3, paramRect.top + f3);
    localMatrix.postTranslate((paramRect.width() - f2) / 2.0F, 0.0F);
    localMatrix.postTranslate(0.0F, (paramRect.bottom - f2 - this.I3) * f4);
    localPath.transform(localMatrix);
  }
  
  private void q()
  {
    b localb = this.O3;
    if (localb != null) {
      if (this.p0) {
        localb.a();
      } else {
        localb.b();
      }
    }
  }
  
  private void u(float paramFloat)
  {
    float f1 = this.H3;
    float f2;
    if (this.p0) {
      f2 = 0.0F;
    } else {
      f2 = 1.0F;
    }
    this.x = (f1 + (f2 - f1) * paramFloat);
    o(getBounds());
    invalidateSelf();
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (!this.L3.isEmpty())
    {
      paramPaint.setStyle(Paint.Style.FILL);
      paramPaint.setColor(n(this.J3, this.K3, this.x));
      paramCanvas.drawPath(this.L3, paramPaint);
    }
  }
  
  public boolean isRunning()
  {
    return this.p1;
  }
  
  public void l()
  {
    this.p0 = true;
    unscheduleSelf(this.P3);
    float f = this.x;
    if (f > 0.0F)
    {
      this.p1 = true;
      this.H3 = f;
      this.p2 = (250 - (int)((1.0F - f) * 250.0F));
      long l = SystemClock.uptimeMillis();
      this.z = l;
      scheduleSelf(this.P3, l + 16L);
    }
    else
    {
      q();
    }
  }
  
  public void m()
  {
    unscheduleSelf(this.P3);
    this.p0 = false;
    float f = this.x;
    if (f < 1.0F)
    {
      this.p1 = true;
      this.H3 = f;
      this.p2 = ((int)((1.0F - f) * 250.0F));
      long l = SystemClock.uptimeMillis();
      this.z = l;
      scheduleSelf(this.P3, l + 16L);
    }
    else
    {
      q();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    o(paramRect);
  }
  
  public Path p()
  {
    return this.L3;
  }
  
  public void r(int paramInt1, int paramInt2)
  {
    this.J3 = paramInt1;
    this.K3 = paramInt2;
  }
  
  public void s(int paramInt)
  {
    this.I3 = paramInt;
  }
  
  public void start() {}
  
  public void stop()
  {
    unscheduleSelf(this.P3);
  }
  
  public void t(b paramb)
  {
    this.O3 = paramb;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = l1 - b.e(b.this);
      b localb;
      if (l2 < b.f(b.this))
      {
        float f = b.g(b.this).getInterpolation((float)l2 / b.f(b.this));
        localb = b.this;
        localb.scheduleSelf(b.h(localb), l1 + 16L);
        b.i(b.this, f);
      }
      else
      {
        localb = b.this;
        localb.unscheduleSelf(b.h(localb));
        b.j(b.this, false);
        b.i(b.this, 1.0F);
        b.k(b.this);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */