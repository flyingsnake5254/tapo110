package com.tplink.libtpcontrols.tppulltorefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;

public class TPCircleProgressBar
  extends View
{
  private long H3 = 0L;
  private boolean I3 = false;
  private boolean J3 = false;
  private long K3 = 0L;
  private float L3;
  private int M3 = -1;
  private Paint c;
  private float d = 270.0F;
  private float f = 16.0F;
  private long p0 = 200L;
  private long p1 = 460L;
  private boolean p2 = false;
  private long p3 = 0L;
  private int q;
  private float x = 270.0F;
  private float y = 0.0F;
  private float z = 360.0F;
  
  public TPCircleProgressBar(Context paramContext)
  {
    this(paramContext, null, -1);
  }
  
  public TPCircleProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public TPCircleProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext);
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.x + 20.0F, getWidth() / 2.0F, getHeight() / 2.0F);
    paramCanvas.drawCircle(getWidth() - this.q / 2.0F, getHeight() / 2.0F, this.q / 2.0F, this.c);
    paramCanvas.restore();
  }
  
  private void c(Canvas paramCanvas)
  {
    this.c.setStrokeWidth(this.q);
    this.c.setStyle(Paint.Style.STROKE);
    int i = this.q;
    RectF localRectF = new RectF(i / 2.0F, i / 2.0F, getWidth() - this.q / 2.0F, getHeight() - this.q / 2.0F);
    float f1 = this.y;
    paramCanvas.drawArc(localRectF, f1, (this.x + 360.0F - f1) % 360.0F, false, this.c);
    this.c.setStrokeWidth(0.0F);
    this.c.setStyle(Paint.Style.FILL);
    paramCanvas.save();
    paramCanvas.rotate(this.y, getWidth() / 2.0F, getHeight() / 2.0F);
    paramCanvas.drawCircle(getWidth() - this.q / 2.0F, getHeight() / 2.0F, this.q / 2.0F, this.c);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.rotate(this.x, getWidth() / 2.0F, getHeight() / 2.0F);
    paramCanvas.drawCircle(getWidth() - this.q / 2.0F, getHeight() / 2.0F, this.q / 2.0F, this.c);
    paramCanvas.restore();
  }
  
  private void d(Context paramContext)
  {
    this.q = a(2.0F);
    Paint localPaint = new Paint();
    this.c = localPaint;
    localPaint.setColor(ContextCompat.getColor(paramContext, p0.common_tplink_yellow));
    this.c.setAntiAlias(true);
  }
  
  private void j(long paramLong)
  {
    long l1;
    long l2;
    float f1;
    float f2;
    float f3;
    if (this.J3)
    {
      l1 = this.p3 + paramLong;
      this.p3 = l1;
      l2 = this.p1;
      if (l1 >= l2)
      {
        this.p3 = l2;
        this.J3 = false;
        this.H3 = 0L;
      }
      if (this.p2)
      {
        f1 = this.y + this.z / 1000.0F * (float)paramLong;
        this.y = f1;
        paramLong = this.p3;
        if (paramLong <= l2)
        {
          f2 = this.d;
          f3 = this.f;
          this.x = (f1 + f3 + (f2 - f3) / (float)l2 * (float)paramLong);
        }
        else
        {
          this.x = (f1 + this.d);
        }
      }
      else
      {
        f3 = this.x + this.z / 1000.0F * (float)paramLong;
        this.x = f3;
        paramLong = this.p3;
        if (paramLong <= l2)
        {
          f1 = this.d;
          this.y = (f3 + 360.0F - (f1 - (f1 - this.f) / (float)l2 * (float)paramLong));
        }
        else
        {
          this.y = (f3 + 360.0F - this.f);
        }
      }
    }
    else
    {
      l1 = this.H3 + paramLong;
      this.H3 = l1;
      l2 = this.p0;
      if (l1 >= l2)
      {
        this.H3 = l2;
        this.J3 = true;
        this.p3 = 0L;
        this.p2 = (true ^ this.p2);
      }
      f1 = this.x;
      float f4 = this.z;
      f2 = f4 / 1000.0F;
      f3 = (float)paramLong;
      this.x = (f1 + f2 * f3);
      this.y += f4 / 1000.0F * f3;
    }
    this.x %= 360.0F;
    this.y %= 360.0F;
  }
  
  public boolean e()
  {
    return this.I3;
  }
  
  public void f()
  {
    this.J3 = true;
    this.p2 = true;
    this.p3 = 0L;
    this.H3 = 0L;
    this.y = 0.0F;
    this.x = this.f;
    invalidate();
  }
  
  public void g()
  {
    this.I3 = true;
    this.K3 = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void h()
  {
    this.I3 = true;
    f();
    invalidate();
  }
  
  public void i()
  {
    this.I3 = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.q);
    c(paramCanvas);
    b(paramCanvas);
    if (this.I3)
    {
      long l = SystemClock.uptimeMillis();
      j(l - this.K3);
      invalidate();
      this.K3 = l;
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      this.L3 = 0.0F;
    } else if (paramFloat > 1.0F) {
      this.L3 = 1.0F;
    } else {
      this.L3 = paramFloat;
    }
    if (this.I3) {
      this.I3 = false;
    }
    this.y = 0.0F;
    this.J3 = true;
    this.p2 = true;
    float f1 = (float)this.p1;
    paramFloat = this.L3;
    this.p3 = ((f1 * paramFloat));
    this.y = 0.0F;
    float f2 = this.d;
    f1 = this.f;
    this.x = ((f2 - f1) * paramFloat + f1);
    invalidate();
  }
  
  public void setProgressBarColor(int paramInt)
  {
    this.M3 = paramInt;
    this.c.setColor(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tppulltorefresh\TPCircleProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */