package com.tplink.libtpcontrols.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.x0;

public class TPArcColorView
  extends View
{
  private Paint H3;
  private Paint I3;
  private Paint J3;
  private Path K3;
  private final RectF L3 = new RectF();
  private final PointF M3 = new PointF();
  private int[] N3;
  private float[] O3;
  private int P3;
  private int Q3;
  private int R3;
  private int S3;
  private int T3;
  private int U3;
  private int V3;
  private int W3;
  private int X3;
  private int Y3;
  private int Z3;
  private int a4;
  private boolean b4 = false;
  private int c;
  private a c4 = null;
  private int d;
  private b d4 = null;
  private int f;
  int p0;
  int p1;
  private Paint p2;
  private Paint p3;
  private int q;
  private float x;
  int y;
  int z;
  
  public TPArcColorView(Context paramContext)
  {
    super(paramContext);
    e(paramContext, null);
  }
  
  public TPArcColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e(paramContext, paramAttributeSet);
  }
  
  public TPArcColorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramContext, paramAttributeSet);
  }
  
  private int a(float paramFloat)
  {
    double d1 = paramFloat;
    int i;
    if (d1 < 0.5D)
    {
      i = ((int)(this.V3 * paramFloat * 2.0F + this.P3) << 16) + ((int)(this.X3 * paramFloat * 2.0F + this.R3) << 8) + (int)(this.W3 * paramFloat * 2.0F + this.Q3) - 16777216;
    }
    else
    {
      int j;
      if (d1 == 0.5D)
      {
        j = (this.S3 << 16) + (this.U3 << 8);
        i = this.T3;
      }
      else
      {
        double d2 = this.Y3 * 2;
        d1 -= 0.5D;
        j = ((int)(d2 * d1 + this.S3) << 16) + ((int)(this.a4 * 2 * d1 + this.U3) << 8);
        i = (int)(this.Z3 * 2 * d1 + this.T3);
      }
      i = j + i - 16777216;
    }
    return i;
  }
  
  private void b()
  {
    Object localObject = this.d4;
    if (localObject != null) {
      ((b)localObject).a(getProgress(), this.b4);
    }
    localObject = this.c4;
    if (localObject != null) {
      ((a)localObject).a(getPickColor(), this.b4);
    }
    this.b4 = false;
  }
  
  private static int c(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private boolean d(PointF paramPointF, float paramFloat1, float paramFloat2)
  {
    float f1 = this.c / 2.0F - paramFloat1;
    paramFloat1 = this.d / 2.0F - paramFloat2;
    paramFloat2 = (float)Math.sqrt(f1 * f1 + paramFloat1 * paramFloat1);
    int i = this.c;
    int j = i / 2;
    int k = this.f;
    int m = this.q;
    int n = j - k - m / 2;
    float f2 = k;
    float f3 = m / 2.0F;
    float f4 = this.x;
    double d1 = f4;
    int i1 = 0;
    int i2;
    if (((d1 >= 0.5D) && (paramFloat1 < 0.0F)) || ((f4 < 0.5D) && (paramFloat1 > 0.0F))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (paramFloat2 > i / 2.0F) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramFloat2 < i / 2.0F - k * 2 - m) {
      m = 1;
    } else {
      m = 0;
    }
    if ((i2 != 0) && (Math.abs(f1 / paramFloat1) < Math.tan(Math.toRadians((1.0D - (this.x + (f2 + f3) / (n * 6.283185307179586D))) / 2.0D * 360.0D)))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((j == 0) && (m == 0))
    {
      j = i1;
      if (i2 == 0) {}
    }
    else
    {
      j = 1;
    }
    if (j == 0)
    {
      f2 = n;
      f1 = f1 * f2 / paramFloat2;
      paramFloat1 = paramFloat1 * f2 / paramFloat2;
      paramPointF.set(this.c / 2.0F - f1, this.d / 2.0F - paramFloat1);
      b();
    }
    return j ^ 0x1;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = c(paramContext, 10.0F);
    if (paramAttributeSet == null)
    {
      this.q = i;
      this.x = 0.66F;
      this.y = ContextCompat.getColor(paramContext, 17170456);
      this.z = ContextCompat.getColor(paramContext, 17170443);
      this.p0 = ContextCompat.getColor(paramContext, 17170450);
      this.p1 = ContextCompat.getColor(paramContext, 17170445);
    }
    else
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPArcColorView);
      this.q = ((int)paramAttributeSet.getDimension(x0.TPArcColorView_tp_stroke_width, i));
      this.x = paramAttributeSet.getFloat(x0.TPArcColorView_tp_percent, 0.66F);
      this.y = paramAttributeSet.getColor(x0.TPArcColorView_tp_start_color, ContextCompat.getColor(paramContext, 17170456));
      this.z = paramAttributeSet.getColor(x0.TPArcColorView_tp_middle_color, ContextCompat.getColor(paramContext, 17170443));
      this.p0 = paramAttributeSet.getColor(x0.TPArcColorView_tp_end_color, ContextCompat.getColor(paramContext, 17170450));
      this.p1 = paramAttributeSet.getColor(x0.TPArcColorView_tp_default_color, ContextCompat.getColor(paramContext, 17170445));
      paramAttributeSet.recycle();
    }
    paramAttributeSet = new Paint();
    this.I3 = paramAttributeSet;
    paramAttributeSet.setColor(ContextCompat.getColor(paramContext, 17170443));
    this.I3.setStyle(Paint.Style.FILL);
    this.I3.setAntiAlias(true);
    paramAttributeSet = new Paint();
    this.J3 = paramAttributeSet;
    paramAttributeSet.setColor(-1184275);
    this.J3.setStrokeWidth(c(paramContext, 1.0F));
    this.J3.setStyle(Paint.Style.STROKE);
    this.J3.setAntiAlias(true);
    this.K3 = new Path();
    i = c(paramContext, 14.0F);
    this.K3.addCircle(0.0F, 0.0F, i, Path.Direction.CW);
    this.f = (i - this.q / 2);
    paramContext = new Paint();
    this.p2 = paramContext;
    paramContext.setAntiAlias(true);
    this.p2.setStrokeWidth(this.q);
    this.p2.setStyle(Paint.Style.STROKE);
    this.p2.setStrokeJoin(Paint.Join.ROUND);
    this.p2.setStrokeCap(Paint.Cap.ROUND);
    paramContext = new Paint();
    this.p3 = paramContext;
    paramContext.setColor(this.y);
    this.p3.setAntiAlias(true);
    this.p3.setStyle(Paint.Style.FILL);
    paramContext = new Paint();
    this.H3 = paramContext;
    paramContext.setColor(this.p0);
    this.H3.setAntiAlias(true);
    this.H3.setStyle(Paint.Style.FILL);
    int j = this.y;
    i = this.z;
    int k = this.p0;
    int m = this.p1;
    this.N3 = new int[] { j, i, k, m, m };
    paramContext = new float[5];
    this.O3 = paramContext;
    paramContext[0] = 0.0F;
    paramContext[4] = 1.0F;
    g();
  }
  
  private boolean f(PointF paramPointF, float paramFloat1, float paramFloat2)
  {
    float f1 = this.c / 2.0F - paramFloat1;
    paramFloat2 = this.d / 2.0F - paramFloat2;
    paramFloat1 = (float)Math.sqrt(f1 * f1 + paramFloat2 * paramFloat2);
    float f2 = this.x;
    double d1 = f2;
    int i = 0;
    int j;
    if (((d1 >= 0.5D) && (paramFloat2 < 0.0F)) || ((f2 < 0.5D) && (paramFloat2 > 0.0F))) {
      j = 1;
    } else {
      j = 0;
    }
    int k = i;
    if (j != 0)
    {
      k = i;
      if (Math.abs(f1 / paramFloat2) < Math.tan(Math.toRadians((1.0F - this.x) / 2.0F * 360.0F))) {
        k = 1;
      }
    }
    if ((k == 0) && (paramFloat1 > 0.0F))
    {
      int m = this.c;
      j = m / 2;
      i = this.f;
      int n = this.q / 2;
      f1 /= paramFloat1;
      f2 = j - i - n;
      paramFloat1 = paramFloat2 / paramFloat1;
      paramPointF.set(m / 2.0F - f1 * f2, this.d / 2.0F - paramFloat1 * f2);
      b();
    }
    return k ^ 0x1;
  }
  
  private void g()
  {
    int i = this.y;
    int j = (i & 0xFF0000) >> 16;
    this.P3 = j;
    int k = (i & 0xFF00) >> 8;
    this.R3 = k;
    int m = i & 0xFF;
    this.Q3 = m;
    int n = this.z;
    i = (n & 0xFF0000) >> 16;
    this.S3 = i;
    int i1 = (n & 0xFF00) >> 8;
    this.U3 = i1;
    int i2 = n & 0xFF;
    this.T3 = i2;
    n = this.p0;
    this.V3 = (i - j);
    this.X3 = (i1 - k);
    this.W3 = (i2 - m);
    this.Y3 = (((0xFF0000 & n) >> 16) - i);
    this.a4 = (((0xFF00 & n) >> 8) - i1);
    this.Z3 = ((n & 0xFF) - i2);
  }
  
  private int getPickColor()
  {
    return a(getProgress());
  }
  
  public float getProgress()
  {
    PointF localPointF = this.M3;
    float f1 = localPointF.x;
    float f2 = localPointF.y;
    f1 -= this.c / 2.0F;
    float f3 = f2 - this.d / 2.0F;
    f2 = 0.0F;
    boolean bool = f1 < 0.0F;
    if ((bool) && (f3 > 0.0F))
    {
      d1 = -Math.atan2(Math.abs(f3), Math.abs(f1));
    }
    else if ((bool) && (f3 < 0.0F))
    {
      d1 = Math.atan2(Math.abs(f3), Math.abs(f1));
    }
    else
    {
      if ((f1 > 0.0F) && (f3 < 0.0F)) {
        d1 = -Math.atan2(Math.abs(f3), Math.abs(f1));
      } else {
        d1 = Math.atan2(f3, f1);
      }
      d1 += 3.141592653589793D;
    }
    d1 /= 6.283185307179586D;
    f1 = this.x;
    f1 = (float)(d1 + (f1 - 0.5D) / 2.0D) / f1;
    double d1 = f1;
    if (d1 > 0.99D) {
      f2 = 1.0F;
    } else if (d1 >= 0.01D) {
      f2 = f1;
    }
    return f2;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.save();
    int j = this.c;
    int k = j / 2;
    int m = this.d / 2;
    int n = j / 2;
    int i1 = this.q / 2;
    j = this.f;
    float f1 = this.x;
    if ((f1 > 0.97D) && (f1 < 1.0F)) {
      f1 = 0.97F;
    }
    paramCanvas.save();
    float f2 = f1 * 0.5F;
    float f3 = k;
    float f4 = m;
    paramCanvas.rotate((0.75F - f2) * 360.0F, f3, f4);
    Object localObject = this.O3;
    localObject[1] = f2;
    localObject[2] = f1;
    localObject[3] = f1;
    localObject = new SweepGradient(f3, f4, this.N3, this.O3);
    this.p2.setShader((Shader)localObject);
    paramCanvas.drawCircle(f3, f4, n - i1 - j, this.p2);
    paramCanvas.restore();
    if (f1 > 0.0F)
    {
      if (f1 < 1.0F)
      {
        paramCanvas.save();
        paramCanvas.rotate((int)Math.floor(f1 * 360.0F / 2.0F) - 0.5F, f3, f4);
        paramCanvas.drawArc(this.L3, -90.0F, 180.0F, true, this.H3);
        paramCanvas.restore();
      }
      paramCanvas.save();
      paramCanvas.rotate((int)Math.floor((1.0F - f1 / 2.0F) * 360.0F) + 0.5F, f3, f4);
      paramCanvas.drawArc(this.L3, 90.0F, 180.0F, true, this.p3);
      paramCanvas.restore();
    }
    paramCanvas.save();
    localObject = this.M3;
    paramCanvas.translate(((PointF)localObject).x, ((PointF)localObject).y);
    paramCanvas.drawPath(this.K3, this.I3);
    paramCanvas.drawPath(this.K3, this.J3);
    paramCanvas.restore();
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    this.d = paramInt2;
    RectF localRectF = this.L3;
    int i = this.c;
    float f1 = i / 2.0F;
    paramInt1 = this.q;
    localRectF.left = (f1 - paramInt1 / 2.0F);
    int j = this.f;
    localRectF.top = j;
    localRectF.right = (paramInt2 / 2.0F + paramInt1 / 2.0F);
    localRectF.bottom = (paramInt1 + j);
    this.M3.set(i / 2.0F, j + paramInt1 / 2.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          this.b4 = true;
          if (f(this.M3, paramMotionEvent.getX(), paramMotionEvent.getY())) {
            invalidate();
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        }
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
    }
    this.b4 = true;
    if (d(this.M3, paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      invalidate();
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    }
    getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void setDefaultColor(int paramInt)
  {
    this.p1 = paramInt;
    g();
    invalidate();
  }
  
  public void setEndColor(int paramInt)
  {
    this.p0 = paramInt;
    g();
    invalidate();
  }
  
  public void setMiddleColor(int paramInt)
  {
    this.z = paramInt;
    g();
    invalidate();
  }
  
  public void setOnColorChangedListener(a parama)
  {
    this.c4 = parama;
  }
  
  public void setOnProgressListener(b paramb)
  {
    this.d4 = paramb;
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    paramFloat = f1;
    if (f1 < 0.0F) {
      paramFloat = 0.0F;
    }
    float f2 = this.c / 2.0F;
    float f3 = this.f;
    float f4 = this.q / 2.0F;
    f1 = this.x;
    double d1 = paramFloat * f1 * 2.0F;
    double d2 = (f1 + 0.5D) * 3.141592653589793D - d1 * 3.141592653589793D;
    d1 = f2 - f3 - f4;
    double d3 = Math.cos(d2);
    d2 = Math.sin(d2);
    paramFloat = (float)(d3 * d1 + this.c / 2);
    f1 = (float)(this.d / 2 - d1 * d2);
    this.M3.set(paramFloat, f1);
    b();
    invalidate();
  }
  
  public void setStartColor(int paramInt)
  {
    this.y = paramInt;
    g();
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\colorpicker\TPArcColorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */