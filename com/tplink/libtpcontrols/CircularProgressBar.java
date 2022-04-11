package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircularProgressBar
  extends View
{
  private Paint c = new Paint();
  private RectF d = new RectF();
  private int f;
  private boolean p0;
  private boolean p1;
  private boolean p2;
  private float q;
  private int x;
  private float y;
  private float z;
  
  public CircularProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.CircularProgressBar);
    this.f = paramContext.getColor(x0.CircularProgressBar_circleColor, 0);
    this.x = paramContext.getColor(x0.CircularProgressBar_progressColor, 0);
    this.q = paramContext.getDimension(x0.CircularProgressBar_circleStrokeWidth, 5.0F);
    this.y = paramContext.getDimension(x0.CircularProgressBar_progressStrokeWidth, 5.0F);
    this.z = paramContext.getFloat(x0.CircularProgressBar_progressValue, 0.0F);
    this.p0 = paramContext.getBoolean(x0.CircularProgressBar_progressEnabled, false);
    this.p1 = paramContext.getBoolean(x0.CircularProgressBar_markerEnabled, true);
    this.p2 = paramContext.getBoolean(x0.CircularProgressBar_startPointEnabled, false);
    paramContext.recycle();
  }
  
  public int getCircleColor()
  {
    return this.f;
  }
  
  public int getCircleProgressColor()
  {
    return this.x;
  }
  
  public float getCircleStrokeWidth()
  {
    return this.q;
  }
  
  public float getProgressStrokeWidth()
  {
    return this.y;
  }
  
  public float getProgressValue()
  {
    return this.z;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    int k = Math.min(i, j);
    float f1 = i / 2.0F;
    float f2 = j / 2.0F;
    float f3;
    if (this.p2) {
      f3 = k / 2.0F - this.y / 2.0F - 15.0F;
    } else {
      f3 = k / 2.0F - this.y / 2.0F;
    }
    this.c.setStrokeWidth(this.q);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(this.f);
    this.c.setAntiAlias(true);
    paramCanvas.drawCircle(f1, f2, f3, this.c);
    if (this.p0)
    {
      if (this.p2)
      {
        this.c.setStrokeWidth(0.0F);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(this.x);
        this.c.setAntiAlias(true);
        paramCanvas.drawCircle(f1, f2 - f3, this.y / 2.0F, this.c);
      }
      this.c.setStrokeWidth(this.y);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setColor(this.x);
      this.c.setAntiAlias(true);
      this.d.set(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
      paramCanvas.drawArc(this.d, 270.0F, this.z * 360.0F, false, this.c);
      if (this.p1)
      {
        double d1 = (float)Math.toRadians(this.z * 360.0F);
        float f4 = (float)Math.sin(d1);
        float f5 = (float)Math.cos(d1);
        this.c.setStrokeWidth(0.0F);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(this.x);
        this.c.setAntiAlias(true);
        paramCanvas.drawCircle(f1 + f4 * f3, f2 - f3 * f5, this.y / 2.0F + 15.0F, this.c);
      }
    }
  }
  
  public void setCircleColor(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.x = paramInt;
    invalidate();
  }
  
  public void setCircleStrokeWidth(float paramFloat)
  {
    this.q = paramFloat;
    invalidate();
  }
  
  public void setMarkerEnabled(boolean paramBoolean)
  {
    this.p1 = paramBoolean;
    invalidate();
  }
  
  public void setProgressEnabled(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
    invalidate();
  }
  
  public void setProgressStrokeWidth(float paramFloat)
  {
    this.y = Math.max(paramFloat, this.q);
    invalidate();
  }
  
  public void setProgressValue(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      this.z = 0.0F;
    } else if (paramFloat > 1.0F) {
      this.z = 1.0F;
    } else {
      this.z = paramFloat;
    }
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\CircularProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */