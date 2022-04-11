package com.tplink.libtpcontrols.wheelpickerview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tplink.libtpcontrols.x0;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LoopView
  extends View
{
  private static final int c = (int)(Resources.getSystem().getDisplayMetrics().density * 15.0F);
  List<String> H3;
  int I3;
  int J3;
  int K3;
  int L3;
  int M3;
  float N3;
  boolean O3;
  int P3;
  int Q3;
  int R3;
  int S3;
  private int T3;
  int U3;
  int V3;
  int W3;
  String[] X3;
  int Y3;
  int Z3;
  int a4;
  int b4;
  private int c4 = 0;
  private float d = 1.05F;
  private float d4;
  long e4 = 0L;
  private Context f;
  private Rect f4 = new Rect();
  private int g4;
  private int h4;
  private ScheduledFuture<?> p0;
  private Paint p1;
  private Paint p2;
  private Paint p3;
  Handler q;
  private GestureDetector x;
  d y;
  ScheduledExecutorService z = Executors.newSingleThreadScheduledExecutor();
  
  public LoopView(Context paramContext)
  {
    super(paramContext);
    c(paramContext, null);
  }
  
  public LoopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
  }
  
  public LoopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
  }
  
  private int b(String paramString, Paint paramPaint, Rect paramRect)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), paramRect);
    int i = (int)(paramRect.width() * this.d);
    int j = this.Z3;
    int k = this.g4;
    return (j - k - i) / 2 + k;
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.f = paramContext;
    this.q = new c(this);
    GestureDetector localGestureDetector = new GestureDetector(paramContext, new b(this));
    this.x = localGestureDetector;
    localGestureDetector.setIsLongpressEnabled(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.androidWheelView);
    this.I3 = paramContext.getInteger(x0.androidWheelView_awv_textsize, c);
    this.I3 = ((int)(Resources.getSystem().getDisplayMetrics().density * this.I3));
    this.N3 = paramContext.getFloat(x0.androidWheelView_awv_lineSpace, 2.0F);
    this.L3 = paramContext.getInteger(x0.androidWheelView_awv_centerTextColor, -13553359);
    this.K3 = paramContext.getInteger(x0.androidWheelView_awv_outerTextColor, -5263441);
    this.M3 = paramContext.getInteger(x0.androidWheelView_awv_dividerTextColor, -3815995);
    int i = paramContext.getInteger(x0.androidWheelView_awv_itemsVisibleCount, 9);
    this.W3 = i;
    if (i % 2 == 0) {
      this.W3 = 9;
    }
    this.O3 = paramContext.getBoolean(x0.androidWheelView_awv_isLoop, true);
    paramContext.recycle();
    this.X3 = new String[this.W3];
    this.R3 = 0;
    this.S3 = -1;
    d();
  }
  
  private void d()
  {
    Paint localPaint = new Paint();
    this.p1 = localPaint;
    localPaint.setColor(this.K3);
    this.p1.setAntiAlias(true);
    this.p1.setTypeface(Typeface.MONOSPACE);
    this.p1.setTextSize(this.I3);
    localPaint = new Paint();
    this.p2 = localPaint;
    localPaint.setColor(this.L3);
    this.p2.setAntiAlias(true);
    this.p2.setTextScaleX(this.d);
    this.p2.setTypeface(Typeface.MONOSPACE);
    this.p2.setTextSize(this.I3);
    localPaint = new Paint();
    this.p3 = localPaint;
    localPaint.setColor(this.M3);
    this.p3.setAntiAlias(true);
  }
  
  private void f()
  {
    if (this.H3 == null) {
      return;
    }
    this.Z3 = getMeasuredWidth();
    int i = getMeasuredHeight();
    this.Y3 = i;
    if ((this.Z3 != 0) && (i != 0))
    {
      this.g4 = getPaddingLeft();
      i = getPaddingRight();
      this.h4 = i;
      this.Z3 -= i;
      this.p2.getTextBounds("星期", 0, 2, this.f4);
      this.J3 = this.f4.height();
      i = this.Y3;
      int j = (int)(i * 3.141592653589793D / 2.0D);
      this.a4 = j;
      float f1 = j;
      float f2 = this.N3;
      j = (int)(f1 / ((this.W3 - 1) * f2));
      this.J3 = j;
      this.b4 = (i / 2);
      this.P3 = ((int)((i - j * f2) / 2.0F));
      this.Q3 = ((int)((i + f2 * j) / 2.0F));
      if (this.S3 == -1) {
        if (this.O3) {
          this.S3 = ((this.H3.size() + 1) / 2);
        } else {
          this.S3 = 0;
        }
      }
      this.U3 = this.S3;
    }
  }
  
  public void a()
  {
    ScheduledFuture localScheduledFuture = this.p0;
    if ((localScheduledFuture != null) && (!localScheduledFuture.isCancelled()))
    {
      this.p0.cancel(true);
      this.p0 = null;
    }
  }
  
  protected final void e()
  {
    if (this.y != null) {
      postDelayed(new e(this), 200L);
    }
  }
  
  protected final void g(float paramFloat)
  {
    a();
    this.p0 = this.z.scheduleWithFixedDelay(new a(this, paramFloat), 0L, 10, TimeUnit.MILLISECONDS);
  }
  
  public final int getSelectedItem()
  {
    return this.T3;
  }
  
  void h(ACTION paramACTION)
  {
    a();
    if ((paramACTION == ACTION.FLING) || (paramACTION == ACTION.DAGGLE))
    {
      float f1 = this.N3 * this.J3;
      int i = (int)((this.R3 % f1 + f1) % f1);
      this.c4 = i;
      if (i > f1 / 2.0F) {
        this.c4 = ((int)(f1 - i));
      } else {
        this.c4 = (-i);
      }
    }
    this.p0 = this.z.scheduleWithFixedDelay(new f(this, this.c4), 0L, 10L, TimeUnit.MILLISECONDS);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.H3;
    if (localObject == null) {
      return;
    }
    int i = (int)(this.R3 / (this.N3 * this.J3));
    this.V3 = i;
    i = this.S3 + i % ((List)localObject).size();
    this.U3 = i;
    if (!this.O3)
    {
      if (i < 0) {
        this.U3 = 0;
      }
      if (this.U3 > this.H3.size() - 1) {
        this.U3 = (this.H3.size() - 1);
      }
    }
    else
    {
      if (i < 0) {
        this.U3 = (this.H3.size() + this.U3);
      }
      if (this.U3 > this.H3.size() - 1) {
        this.U3 -= this.H3.size();
      }
    }
    int j = (int)(this.R3 % (this.N3 * this.J3));
    int m;
    for (int k = 0;; k++)
    {
      i = this.W3;
      if (k >= i) {
        break;
      }
      i = this.U3 - (i / 2 - k);
      if (this.O3)
      {
        for (;;)
        {
          m = i;
          if (i >= 0) {
            break;
          }
          i += this.H3.size();
        }
        while (m > this.H3.size() - 1) {
          m -= this.H3.size();
        }
        this.X3[k] = ((String)this.H3.get(m));
      }
      else if (i < 0)
      {
        this.X3[k] = "";
      }
      else if (i > this.H3.size() - 1)
      {
        this.X3[k] = "";
      }
      else
      {
        this.X3[k] = ((String)this.H3.get(i));
      }
    }
    float f1 = this.g4;
    i = this.P3;
    paramCanvas.drawLine(f1, i, this.Z3, i, this.p3);
    f1 = this.g4;
    i = this.Q3;
    paramCanvas.drawLine(f1, i, this.Z3, i, this.p3);
    for (i = 0; i < this.W3; i++)
    {
      paramCanvas.save();
      f1 = this.J3 * this.N3;
      double d1 = (i * f1 - j) * 3.141592653589793D / this.a4;
      if ((d1 < 3.141592653589793D) && (d1 > 0.0D))
      {
        int n = (int)(this.b4 - Math.cos(d1) * this.b4 - Math.sin(d1) * this.J3 / 2.0D);
        paramCanvas.translate(0.0F, n);
        paramCanvas.scale(1.0F, (float)Math.sin(d1));
        m = this.P3;
        if ((n <= m) && (this.J3 + n >= m))
        {
          paramCanvas.save();
          paramCanvas.clipRect(0, 0, this.Z3, this.P3 - n);
          localObject = this.X3;
          paramCanvas.drawText(localObject[i], b(localObject[i], this.p1, this.f4), this.J3, this.p1);
          paramCanvas.restore();
          paramCanvas.save();
          paramCanvas.clipRect(0, this.P3 - n, this.Z3, (int)f1);
          localObject = this.X3;
          paramCanvas.drawText(localObject[i], b(localObject[i], this.p2, this.f4), this.J3, this.p2);
          paramCanvas.restore();
        }
        else
        {
          k = this.Q3;
          if ((n <= k) && (this.J3 + n >= k))
          {
            paramCanvas.save();
            paramCanvas.clipRect(0, 0, this.Z3, this.Q3 - n);
            localObject = this.X3;
            paramCanvas.drawText(localObject[i], b(localObject[i], this.p2, this.f4), this.J3, this.p2);
            paramCanvas.restore();
            paramCanvas.save();
            paramCanvas.clipRect(0, this.Q3 - n, this.Z3, (int)f1);
            localObject = this.X3;
            paramCanvas.drawText(localObject[i], b(localObject[i], this.p1, this.f4), this.J3, this.p1);
            paramCanvas.restore();
          }
          else if ((n >= m) && (this.J3 + n <= k))
          {
            paramCanvas.clipRect(0, 0, this.Z3, (int)f1);
            localObject = this.X3;
            paramCanvas.drawText(localObject[i], b(localObject[i], this.p2, this.f4), this.J3, this.p2);
            this.T3 = this.H3.indexOf(this.X3[i]);
          }
          else
          {
            paramCanvas.clipRect(0, 0, this.Z3, (int)f1);
            localObject = this.X3;
            paramCanvas.drawText(localObject[i], b(localObject[i], this.p1, this.f4), this.J3, this.p1);
          }
        }
        paramCanvas.restore();
      }
      else
      {
        paramCanvas.restore();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    f();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.x.onTouchEvent(paramMotionEvent);
    float f1 = this.N3 * this.J3;
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      float f2;
      if (i != 2)
      {
        if (!bool)
        {
          f2 = paramMotionEvent.getY();
          i = this.b4;
          i = (int)((Math.acos((i - f2) / i) * this.b4 + f1 / 2.0F) / f1);
          f2 = this.R3;
          this.c4 = ((int)((i - this.W3 / 2) * f1 - (f2 % f1 + f1) % f1));
          if (System.currentTimeMillis() - this.e4 > 120L) {
            h(ACTION.DAGGLE);
          } else {
            h(ACTION.CLICK);
          }
        }
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        f2 = this.d4;
        float f3 = paramMotionEvent.getRawY();
        this.d4 = paramMotionEvent.getRawY();
        this.R3 = ((int)(this.R3 + (f2 - f3)));
        if (!this.O3)
        {
          f2 = -this.S3 * f1;
          f1 = (this.H3.size() - 1 - this.S3) * f1;
          i = this.R3;
          if (i < f2) {
            this.R3 = ((int)f2);
          } else if (i > f1) {
            this.R3 = ((int)f1);
          }
        }
      }
    }
    else
    {
      this.e4 = System.currentTimeMillis();
      a();
      this.d4 = paramMotionEvent.getRawY();
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    invalidate();
    return true;
  }
  
  public void setCenterTextColor(int paramInt)
  {
    this.L3 = paramInt;
    this.p2.setColor(paramInt);
  }
  
  public void setCurrentPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.H3.size()) && (paramInt != this.T3))
    {
      this.S3 = paramInt;
      this.R3 = 0;
      this.c4 = 0;
      invalidate();
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    this.M3 = paramInt;
    this.p3.setColor(paramInt);
  }
  
  public final void setInitPosition(int paramInt)
  {
    if (paramInt < 0)
    {
      this.S3 = 0;
    }
    else
    {
      List localList = this.H3;
      if ((localList != null) && (localList.size() > paramInt)) {
        this.S3 = paramInt;
      }
    }
  }
  
  public final void setItems(List<String> paramList)
  {
    this.H3 = paramList;
    f();
    invalidate();
  }
  
  public void setItemsVisibleCount(int paramInt)
  {
    if (paramInt % 2 == 0) {
      return;
    }
    if (paramInt != this.W3)
    {
      this.W3 = paramInt;
      this.X3 = new String[paramInt];
    }
  }
  
  public void setLineSpacingMultiplier(float paramFloat)
  {
    if (paramFloat > 1.0F) {
      this.N3 = paramFloat;
    }
  }
  
  public final void setListener(d paramd)
  {
    this.y = paramd;
  }
  
  public void setOuterTextColor(int paramInt)
  {
    this.K3 = paramInt;
    this.p1.setColor(paramInt);
  }
  
  public void setScaleX(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void setTextSize(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      int i = (int)(this.f.getResources().getDisplayMetrics().density * paramFloat);
      this.I3 = i;
      this.p1.setTextSize(i);
      this.p2.setTextSize(this.I3);
    }
  }
  
  public static enum ACTION
  {
    static
    {
      ACTION localACTION1 = new ACTION("CLICK", 0);
      CLICK = localACTION1;
      ACTION localACTION2 = new ACTION("FLING", 1);
      FLING = localACTION2;
      ACTION localACTION3 = new ACTION("DAGGLE", 2);
      DAGGLE = localACTION3;
      $VALUES = new ACTION[] { localACTION1, localACTION2, localACTION3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpickerview\LoopView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */