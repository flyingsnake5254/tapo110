package com.tplink.libtpcontrols.tpwheelview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LoopView
  extends View
{
  private Context H3;
  ScheduledExecutorService I3;
  private ScheduledFuture<?> J3;
  Handler K3;
  a L3;
  private GestureDetector M3;
  private GestureDetector.SimpleOnGestureListener N3;
  boolean O3;
  int P3;
  int Q3;
  int R3;
  int S3;
  int T3;
  float U3;
  float V3;
  int W3;
  int X3;
  int Y3;
  int Z3;
  int a4;
  int b4;
  private final String c = "LoopView";
  int c4;
  private final int d;
  int d4;
  int e4;
  private final int f;
  int f4;
  int g4;
  int h4;
  int i4;
  int j4;
  Paint k4;
  Paint l4;
  Paint m4;
  int[] n4;
  g p0;
  int p1;
  ArrayList<String> p2;
  private int p3;
  private final int q;
  private final int x;
  private final int y;
  final float z;
  
  public LoopView(Context paramContext)
  {
    super(paramContext);
    int i = (int)(getResources().getDisplayMetrics().density * 28.0F);
    this.d = i;
    this.f = 3;
    this.q = -5263441;
    this.x = -13553359;
    this.y = -3815995;
    this.z = 2.0F;
    this.p1 = -1;
    this.I3 = Executors.newSingleThreadScheduledExecutor();
    this.O3 = true;
    this.P3 = -13553359;
    this.Q3 = -3815995;
    this.R3 = -5263441;
    this.S3 = 5;
    this.T3 = i;
    this.U3 = 0.0F;
    this.V3 = 0.0F;
    this.n4 = null;
    g(paramContext);
  }
  
  public LoopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = (int)(getResources().getDisplayMetrics().density * 28.0F);
    this.d = i;
    this.f = 3;
    this.q = -5263441;
    this.x = -13553359;
    this.y = -3815995;
    this.z = 2.0F;
    this.p1 = -1;
    this.I3 = Executors.newSingleThreadScheduledExecutor();
    this.O3 = true;
    this.P3 = -13553359;
    this.Q3 = -3815995;
    this.R3 = -5263441;
    this.S3 = 5;
    this.T3 = i;
    this.U3 = 0.0F;
    this.V3 = 0.0F;
    this.n4 = null;
    c(paramContext, paramAttributeSet);
    g(paramContext);
  }
  
  public LoopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = (int)(getResources().getDisplayMetrics().density * 28.0F);
    this.d = paramInt;
    this.f = 3;
    this.q = -5263441;
    this.x = -13553359;
    this.y = -3815995;
    this.z = 2.0F;
    this.p1 = -1;
    this.I3 = Executors.newSingleThreadScheduledExecutor();
    this.O3 = true;
    this.P3 = -13553359;
    this.Q3 = -3815995;
    this.R3 = -5263441;
    this.S3 = 5;
    this.T3 = paramInt;
    this.U3 = 0.0F;
    this.V3 = 0.0F;
    this.n4 = null;
    c(paramContext, paramAttributeSet);
    g(paramContext);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.WheelView);
    int i = paramContext.getIndexCount();
    for (int j = 0; j < i; j++)
    {
      int k = paramContext.getIndex(j);
      if (k == x0.WheelView_isLoop)
      {
        this.O3 = paramContext.getBoolean(k, true);
      }
      else
      {
        int m;
        if (k == x0.WheelView_itemCount)
        {
          m = paramContext.getResourceId(k, 0);
          if (m > 0)
          {
            this.S3 = getResources().getInteger(m);
          }
          else
          {
            k = paramContext.getInteger(k, 3);
            this.S3 = k;
            if (k <= 0) {
              this.S3 = 3;
            }
          }
        }
        else if (k == x0.WheelView_android_textSize)
        {
          m = paramContext.getResourceId(k, 0);
          if (m > 0) {
            this.T3 = getResources().getDimensionPixelSize(m);
          } else {
            this.T3 = paramContext.getDimensionPixelSize(k, this.d);
          }
        }
        else if (k == x0.WheelView_lineColor)
        {
          m = paramContext.getResourceId(k, 0);
          if (m > 0) {
            this.R3 = getResources().getColor(m);
          } else {
            this.R3 = paramContext.getColor(k, -5263441);
          }
        }
        else if (k == x0.WheelView_selectedTextColor)
        {
          m = paramContext.getResourceId(k, 0);
          if (m > 0) {
            this.P3 = getResources().getColor(m);
          } else {
            this.P3 = paramContext.getColor(k, -13553359);
          }
        }
        else if (k == x0.WheelView_unselectedTextColor)
        {
          m = paramContext.getResourceId(k, 0);
          if (m > 0) {
            this.Q3 = getResources().getColor(m);
          } else {
            this.Q3 = paramContext.getColor(k, -3815995);
          }
        }
      }
    }
    paramContext.recycle();
  }
  
  static int d(LoopView paramLoopView)
  {
    return paramLoopView.p3;
  }
  
  private int e(int paramInt, String paramString)
  {
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTypeface(Typeface.MONOSPACE);
    localPaint.setTextSize(paramInt);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.width();
  }
  
  private void f()
  {
    ArrayList localArrayList = this.p2;
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      this.k4.setColor(this.Q3);
      this.k4.setAntiAlias(true);
      this.k4.setTypeface(Typeface.MONOSPACE);
      this.k4.setTextSize(this.T3);
      this.l4.setColor(this.P3);
      this.l4.setAntiAlias(true);
      this.l4.setTypeface(Typeface.MONOSPACE);
      this.l4.setTextSize(this.T3);
      this.m4.setColor(this.R3);
      this.m4.setAntiAlias(true);
      i();
      if (this.S3 > this.p2.size()) {
        this.S3 = this.p2.size();
      }
      int i = this.S3;
      if (i % 2 == 0) {
        this.S3 = (i + 1);
      }
      i = this.S3 + 2;
      this.S3 = i;
      this.n4 = new int[i];
      i = (int)(this.g4 * 2.0F * (i - 1));
      this.h4 = i;
      this.b4 = ((int)(i * 2 / 3.141592653589793D));
      this.i4 = ((int)(i / 3.141592653589793D));
      i = (this.p1 % this.p2.size() + this.p2.size()) % this.p2.size();
      this.p1 = i;
      this.a4 = i;
    }
  }
  
  private void g(Context paramContext)
  {
    this.W3 = 0;
    this.N3 = new d(this);
    this.K3 = new f(this);
    this.H3 = paramContext;
    this.k4 = new Paint();
    this.l4 = new Paint();
    this.m4 = new Paint();
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramContext = new GestureDetector(paramContext, this.N3);
    this.M3 = paramContext;
    paramContext.setIsLongpressEnabled(false);
  }
  
  private void i()
  {
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTextSize(this.T3);
    localPaint.setTypeface(Typeface.MONOSPACE);
    for (int i = 0; i < this.p2.size(); i++)
    {
      String str = (String)this.p2.get(i);
      localPaint.getTextBounds(str, 0, str.length(), localRect);
      int j = localRect.width();
      if (j > this.f4) {
        this.f4 = j;
      }
      localPaint.getTextBounds("星期", 0, 2, localRect);
      j = localRect.height();
      if (j > this.g4) {
        this.g4 = j;
      }
    }
    this.c4 = this.f4;
  }
  
  private void k()
  {
    int i = (int)(this.W3 % (this.g4 * 2.0F));
    a();
    this.J3 = this.I3.scheduleWithFixedDelay(new e(this, i), 0L, 10L, TimeUnit.MILLISECONDS);
  }
  
  static void m(LoopView paramLoopView)
  {
    paramLoopView.k();
  }
  
  public void a()
  {
    ScheduledFuture localScheduledFuture = this.J3;
    if ((localScheduledFuture != null) && (!localScheduledFuture.isCancelled()))
    {
      this.J3.cancel(true);
      this.J3 = null;
    }
  }
  
  protected final void b(MotionEvent paramMotionEvent)
  {
    if (this.p0 == null) {
      return;
    }
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if ((f1 < this.Y3) && (f1 > this.X3)) {
      this.p0.a();
    }
  }
  
  public final int getSelectedItem()
  {
    return this.p3;
  }
  
  protected final void h()
  {
    if (this.L3 != null) {
      postDelayed(new b(this), 200L);
    }
  }
  
  protected final void j(MotionEvent paramMotionEvent)
  {
    if (this.p0 == null) {
      return;
    }
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if ((f1 < this.Y3) && (f1 > this.X3)) {
      this.p0.b();
    }
  }
  
  protected final void l(float paramFloat)
  {
    a();
    this.J3 = this.I3.scheduleWithFixedDelay(new c(this, paramFloat), 0L, 20, TimeUnit.MILLISECONDS);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.p2;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = new String[this.S3];
      float f1 = this.g4 * 2.0F;
      int i = this.W3;
      int j = (int)(i % f1);
      i = (int)(i / f1);
      this.j4 = i;
      i = this.p1 + i % this.p2.size();
      this.a4 = i;
      boolean bool = this.O3;
      int k = 0;
      if (!bool)
      {
        if (i < 0) {
          this.a4 = 0;
        }
        if (this.a4 > this.p2.size() - 1) {
          this.a4 = (this.p2.size() - 1);
        }
      }
      else
      {
        if (i < 0) {
          this.a4 = (this.p2.size() + this.a4);
        }
        if (this.a4 > this.p2.size() - 1) {
          this.a4 -= this.p2.size();
        }
      }
      int n;
      for (int m = 0;; m++)
      {
        i = this.S3;
        if (m >= i) {
          break;
        }
        n = this.a4 - (i / 2 - m);
        if (this.O3)
        {
          i = n;
          if (n < 0) {
            i = n + this.p2.size();
          }
          n = i;
          if (i > this.p2.size() - 1) {
            n = i - this.p2.size();
          }
          localObject[m] = ((String)this.p2.get(n));
        }
        else if (n < 0)
        {
          localObject[m] = "";
        }
        else if (n > this.p2.size() - 1)
        {
          localObject[m] = "";
        }
        else
        {
          localObject[m] = ((String)this.p2.get(n));
        }
        this.n4[m] = e(this.T3, localObject[m]);
      }
      i = this.X3;
      paramCanvas.drawLine(0.0F, i, this.e4, i, this.m4);
      i = this.Y3;
      paramCanvas.drawLine(0.0F, i, this.e4, i, this.m4);
      for (i = k; i < this.S3; i++)
      {
        paramCanvas.save();
        double d1 = (i * f1 - j) * 3.141592653589793D / this.h4;
        float f2 = (float)(90.0D - d1 / 3.141592653589793D * 180.0D);
        if ((f2 < 90.0F) && (f2 > -90.0F))
        {
          m = (int)(this.i4 - Math.cos(d1) * this.i4 - Math.sin(d1) * this.g4 / 2.0D) + (this.Z3 - this.i4);
          paramCanvas.translate(this.e4 / 2.0F, m);
          f2 = (float)(Math.sin(d1) * 0.6000000238418579D + 0.4000000059604645D);
          paramCanvas.scale(f2, f2);
          f2 = (float)(this.n4[i] / -2.0D);
          n = (int)(Math.sin(d1) * 255.0D * 0.3D);
          this.k4.setAlpha(n);
          n = this.X3;
          if ((m <= n) && (this.g4 + m >= n))
          {
            paramCanvas.save();
            n = this.e4;
            paramCanvas.clipRect(-n / 2.0F, 0.0F, n / 2.0F, this.X3 - m);
            paramCanvas.drawText(localObject[i], f2, this.g4, this.k4);
            paramCanvas.restore();
            paramCanvas.save();
            n = this.e4;
            paramCanvas.clipRect(-n / 2.0F, this.X3 - m, n / 2.0F, (int)f1);
            paramCanvas.drawText(localObject[i], f2, this.g4, this.l4);
            paramCanvas.restore();
          }
          else
          {
            k = this.Y3;
            if ((m <= k) && (this.g4 + m >= k))
            {
              paramCanvas.save();
              n = this.e4;
              paramCanvas.clipRect(-n / 2.0F, 0.0F, n / 2.0F, this.Y3 - m);
              paramCanvas.drawText(localObject[i], f2, this.g4, this.l4);
              paramCanvas.restore();
              paramCanvas.save();
              n = this.e4;
              paramCanvas.clipRect(-n / 2.0F, this.Y3 - m, n / 2.0F, (int)f1);
              paramCanvas.drawText(localObject[i], f2, this.g4, this.k4);
              paramCanvas.restore();
            }
            else if ((m >= n) && (this.g4 + m <= k))
            {
              m = this.e4;
              paramCanvas.clipRect(-m / 2.0F, 0.0F, m / 2.0F, (int)f1);
              paramCanvas.drawText(localObject[i], f2, this.g4, this.l4);
              this.p3 = this.p2.indexOf(localObject[i]);
            }
            else
            {
              m = this.e4;
              paramCanvas.clipRect(-m / 2.0F, 0.0F, m / 2.0F, (int)f1);
              paramCanvas.drawText(localObject[i], f2, this.g4, this.k4);
            }
          }
          paramCanvas.restore();
        }
        else
        {
          paramCanvas.restore();
        }
      }
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
    b.d.w.c.a.e("LoopView", "content is empty, you must set content by call function setArrayList before use this control");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) {
      this.d4 = this.b4;
    } else {
      this.d4 = Math.max(getMeasuredHeight(), this.b4);
    }
    if (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE) {
      this.e4 = this.c4;
    } else {
      this.e4 = getMeasuredWidth();
    }
    paramInt2 = this.d4;
    float f1 = paramInt2;
    int i = this.g4;
    paramInt1 = (int)((f1 - i * 2.0F) / 2.0F);
    this.X3 = paramInt1;
    i = (int)((paramInt2 + i * 2.0F) / 2.0F);
    this.Y3 = i;
    this.Z3 = ((paramInt1 + i) / 2);
    setMeasuredDimension(this.e4, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2)
      {
        if ((!this.M3.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
          k();
        }
        return true;
      }
      float f1 = paramMotionEvent.getRawY();
      this.V3 = f1;
      float f2 = this.U3;
      this.U3 = f1;
      int j = (int)(f2 - f1 + this.W3);
      this.W3 = j;
      if (!this.O3)
      {
        i = (int)(this.p1 * (this.g4 * 2.0F)) * -1;
        if (j < i) {
          this.W3 = i;
        }
      }
    }
    else
    {
      this.U3 = paramMotionEvent.getRawY();
    }
    if (!this.O3)
    {
      i = (int)((this.p2.size() - 1 - this.p1) * (this.g4 * 2.0F));
      if (this.W3 >= i) {
        this.W3 = i;
      }
    }
    invalidate();
    if ((!this.M3.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
      k();
    }
    return true;
  }
  
  public final void setContentList(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.p2 = paramArrayList;
      f();
      invalidate();
      return;
    }
    b.d.w.c.a.e("LoopView", "list can not be null or empty");
  }
  
  public final void setInitPosition(int paramInt)
  {
    ArrayList localArrayList = this.p2;
    if ((localArrayList != null) && (localArrayList.size() != 0)) {
      this.p1 = ((paramInt % this.p2.size() + this.p2.size()) % this.p2.size());
    } else {
      this.p1 = paramInt;
    }
  }
  
  public final void setListener(a parama)
  {
    this.L3 = parama;
  }
  
  public void setOnTabListener(g paramg)
  {
    this.p0 = paramg;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpwheelview\LoopView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */