package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.Scroller;
import com.tplink.iot.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class WheelPicker
  extends View
  implements Runnable
{
  private static final String c = WheelPicker.class.getSimpleName();
  private Camera H3;
  private Matrix I3;
  private Matrix J3;
  private List K3;
  private String L3;
  private int M3;
  private int N3;
  private int O3;
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
  private int b4;
  private int c4;
  private final Handler d = new Handler();
  private int d4;
  private int e4;
  private Paint f;
  private int f4;
  private int g4 = 50;
  private int h4 = 8000;
  private int i4;
  private int j4;
  private int k4;
  private int l4;
  private int m4;
  private int n4;
  private int o4;
  private Rect p0;
  private Rect p1;
  private Rect p2;
  private Rect p3;
  private int p4;
  private Scroller q;
  private int q4 = 8;
  private boolean r4;
  private boolean s4;
  private boolean t4;
  private boolean u4;
  private boolean v4;
  private boolean w4;
  private VelocityTracker x;
  private boolean x4;
  private a y;
  private boolean y4;
  private b z;
  private boolean z4;
  
  public WheelPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.WheelPicker);
    int i = paramAttributeSet.getResourceId(5, 0);
    paramContext = getResources();
    int j = i;
    if (i == 0) {
      j = 2130903053;
    }
    this.K3 = Arrays.asList(paramContext.getStringArray(j));
    this.T3 = paramAttributeSet.getDimensionPixelSize(13, getResources().getDimensionPixelSize(2131165917));
    this.M3 = paramAttributeSet.getInt(19, 7);
    this.c4 = paramAttributeSet.getInt(17, 0);
    this.r4 = paramAttributeSet.getBoolean(16, false);
    this.n4 = paramAttributeSet.getInt(15, -1);
    this.L3 = paramAttributeSet.getString(14);
    this.S3 = paramAttributeSet.getColor(18, -16742145);
    this.R3 = paramAttributeSet.getColor(12, -1979711488);
    this.X3 = paramAttributeSet.getDimensionPixelSize(11, getResources().getDimensionPixelSize(2131165914));
    this.v4 = paramAttributeSet.getBoolean(4, false);
    this.s4 = paramAttributeSet.getBoolean(7, false);
    this.V3 = paramAttributeSet.getColor(8, -16742145);
    this.U3 = paramAttributeSet.getDimensionPixelSize(9, getResources().getDimensionPixelSize(2131165288));
    this.t4 = paramAttributeSet.getBoolean(1, false);
    this.W3 = paramAttributeSet.getColor(2, -1996488705);
    this.u4 = paramAttributeSet.getBoolean(0, false);
    this.w4 = paramAttributeSet.getBoolean(3, false);
    this.Y3 = paramAttributeSet.getInt(10, 0);
    paramAttributeSet.recycle();
    paramContext = new Paint(69);
    this.f = paramContext;
    paramContext.setTextSize(this.T3);
    this.q = new Scroller(getContext());
    if (Build.VERSION.SDK_INT >= 4)
    {
      paramContext = ViewConfiguration.get(getContext());
      this.g4 = paramContext.getScaledMinimumFlingVelocity();
      this.h4 = paramContext.getScaledMaximumFlingVelocity();
      this.q4 = paramContext.getScaledTouchSlop();
    }
    this.p0 = new Rect();
    this.p1 = new Rect();
    this.p2 = new Rect();
    this.p3 = new Rect();
    this.H3 = new Camera();
    this.I3 = new Matrix();
    this.J3 = new Matrix();
  }
  
  private void a()
  {
    if ((!this.t4) && (this.S3 == -1)) {
      return;
    }
    Rect localRect1 = this.p3;
    Rect localRect2 = this.p0;
    int i = localRect2.left;
    int j = this.j4;
    int k = this.a4;
    localRect1.set(i, j - k, localRect2.right, j + k);
  }
  
  private int b(int paramInt)
  {
    return (int)(this.b4 - Math.cos(Math.toRadians(paramInt)) * this.b4);
  }
  
  private int c(int paramInt)
  {
    if (Math.abs(paramInt) > this.a4)
    {
      if (this.m4 < 0) {}
      for (int i = -this.Z3;; i = this.Z3) {
        return i - paramInt;
      }
    }
    return -paramInt;
  }
  
  private void d()
  {
    int i = this.Y3;
    if (i != 1)
    {
      if (i != 2) {
        this.k4 = this.i4;
      } else {
        this.k4 = this.p0.right;
      }
    }
    else {
      this.k4 = this.p0.left;
    }
    this.l4 = ((int)(this.j4 - (this.f.ascent() + this.f.descent()) / 2.0F));
  }
  
  private void e()
  {
    int i = this.c4;
    int j = this.Z3;
    i *= j;
    if (this.v4) {
      j = Integer.MIN_VALUE;
    } else {
      j = -j * (this.K3.size() - 1) + i;
    }
    this.e4 = j;
    j = i;
    if (this.v4) {
      j = Integer.MAX_VALUE;
    }
    this.f4 = j;
  }
  
  private void f()
  {
    if (!this.s4) {
      return;
    }
    int i = this.U3 / 2;
    int j = this.j4;
    int k = this.a4;
    int m = j + k;
    k = j - k;
    Rect localRect1 = this.p1;
    Rect localRect2 = this.p0;
    localRect1.set(localRect2.left, m - i, localRect2.right, m + i);
    localRect1 = this.p2;
    localRect2 = this.p0;
    localRect1.set(localRect2.left, k - i, localRect2.right, k + i);
  }
  
  private int g(int paramInt)
  {
    return (int)(Math.sin(Math.toRadians(paramInt)) * this.b4);
  }
  
  private void h()
  {
    this.Q3 = 0;
    this.P3 = 0;
    if (this.r4)
    {
      this.P3 = ((int)this.f.measureText(String.valueOf(this.K3.get(0))));
    }
    else if (i(this.n4))
    {
      this.P3 = ((int)this.f.measureText(String.valueOf(this.K3.get(this.n4))));
    }
    else if (!TextUtils.isEmpty(this.L3))
    {
      this.P3 = ((int)this.f.measureText(this.L3));
    }
    else
    {
      Iterator localIterator = this.K3.iterator();
      while (localIterator.hasNext())
      {
        localObject = String.valueOf(localIterator.next());
        int i = (int)this.f.measureText((String)localObject);
        this.P3 = Math.max(this.P3, i);
      }
    }
    Object localObject = this.f.getFontMetrics();
    this.Q3 = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
  }
  
  private boolean i(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.K3.size())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private int j(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1073741824) {
      if (paramInt1 == Integer.MIN_VALUE) {
        paramInt2 = Math.min(paramInt3, paramInt2);
      } else {
        paramInt2 = paramInt3;
      }
    }
    return paramInt2;
  }
  
  private void k()
  {
    int i = this.Y3;
    if (i != 1)
    {
      if (i != 2) {
        this.f.setTextAlign(Paint.Align.CENTER);
      } else {
        this.f.setTextAlign(Paint.Align.RIGHT);
      }
    }
    else {
      this.f.setTextAlign(Paint.Align.LEFT);
    }
  }
  
  private void l()
  {
    int i = this.M3;
    if (i >= 2)
    {
      if (i % 2 == 0) {
        this.M3 = (i + 1);
      }
      i = this.M3 + 2;
      this.N3 = i;
      this.O3 = (i / 2);
      return;
    }
    throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
  }
  
  public int getCurrentItemPosition()
  {
    return this.d4;
  }
  
  public int getCurtainColor()
  {
    return this.W3;
  }
  
  public List getData()
  {
    return this.K3;
  }
  
  public int getIndicatorColor()
  {
    return this.V3;
  }
  
  public int getIndicatorSize()
  {
    return this.U3;
  }
  
  public int getItemAlign()
  {
    return this.Y3;
  }
  
  public int getItemSpace()
  {
    return this.X3;
  }
  
  public int getItemTextColor()
  {
    return this.R3;
  }
  
  public int getItemTextSize()
  {
    return this.T3;
  }
  
  public String getMaximumWidthText()
  {
    return this.L3;
  }
  
  public int getMaximumWidthTextPosition()
  {
    return this.n4;
  }
  
  public int getSelectedItemPosition()
  {
    return this.c4;
  }
  
  public int getSelectedItemTextColor()
  {
    return this.S3;
  }
  
  public Typeface getTypeface()
  {
    Paint localPaint = this.f;
    if (localPaint != null) {
      return localPaint.getTypeface();
    }
    return null;
  }
  
  public int getVisibleItemCount()
  {
    return this.M3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.z;
    if (localObject != null) {
      ((b)localObject).c(this.m4);
    }
    int i = -this.m4 / this.Z3;
    int j = this.O3;
    int k = i - j;
    int m = this.c4;
    i = -j;
    m += k;
    while (m < this.c4 + k + this.N3)
    {
      if (this.v4)
      {
        n = m % this.K3.size();
        j = n;
        if (n < 0) {
          j = n + this.K3.size();
        }
        localObject = String.valueOf(this.K3.get(j));
      }
      else if (i(m))
      {
        localObject = String.valueOf(this.K3.get(m));
      }
      else
      {
        localObject = "";
      }
      this.f.setColor(this.R3);
      this.f.setStyle(Paint.Style.FILL);
      int n = this.l4;
      j = this.Z3;
      int i1 = i * j + n + this.m4 % j;
      float f1;
      float f2;
      if (this.w4)
      {
        int i2 = Math.abs(n - i1);
        j = this.p0.top;
        f1 = n - i2 - j;
        n = this.l4;
        f1 = f1 * 1.0F / (n - j);
        if (i1 > n) {
          j = 1;
        } else if (i1 < n) {
          j = -1;
        } else {
          j = 0;
        }
        f1 = -(1.0F - f1);
        f2 = 90.0F;
        float f3 = f1 * 90.0F * j;
        f1 = f3;
        if (f3 < -90.0F) {
          f1 = -90.0F;
        }
        if (f1 > 90.0F) {
          f1 = f2;
        }
        i2 = (int)f1;
        n = g(i2);
        j = this.i4;
        int i3 = this.Y3;
        if (i3 != 1)
        {
          if (i3 == 2) {
            j = this.p0.right;
          }
        }
        else {
          j = this.p0.left;
        }
        i3 = this.j4 - n;
        this.H3.save();
        this.H3.rotateX(f1);
        this.H3.getMatrix(this.I3);
        this.H3.restore();
        Matrix localMatrix = this.I3;
        float f5 = -j;
        f2 = -i3;
        localMatrix.preTranslate(f5, f2);
        localMatrix = this.I3;
        f3 = j;
        f1 = i3;
        localMatrix.postTranslate(f3, f1);
        this.H3.save();
        this.H3.translate(0.0F, 0.0F, b(i2));
        this.H3.getMatrix(this.J3);
        this.H3.restore();
        this.J3.preTranslate(f5, f2);
        this.J3.postTranslate(f3, f1);
        j = n;
      }
      else
      {
        j = 0;
      }
      if (this.u4)
      {
        n = this.l4;
        n = (int)((n - Math.abs(n - i1)) * 1.0F / this.l4 * 255.0F);
        if (n < 0) {
          n = 0;
        }
        this.f.setAlpha(n);
      }
      n = i1;
      if (this.w4) {
        n = this.l4 - j;
      }
      if (this.S3 != -1)
      {
        paramCanvas.save();
        if (this.w4) {
          paramCanvas.concat(this.J3);
        }
        paramCanvas.clipRect(this.p3, Region.Op.DIFFERENCE);
        f2 = this.k4;
        f1 = n;
        paramCanvas.drawText((String)localObject, f2, f1, this.f);
        paramCanvas.restore();
        this.f.setColor(this.S3);
        paramCanvas.save();
        if (this.w4) {
          paramCanvas.concat(this.J3);
        }
        paramCanvas.clipRect(this.p3);
        paramCanvas.drawText((String)localObject, this.k4, f1, this.f);
        paramCanvas.restore();
      }
      else
      {
        paramCanvas.save();
        paramCanvas.clipRect(this.p0);
        if (this.w4) {
          paramCanvas.concat(this.J3);
        }
        paramCanvas.drawText((String)localObject, this.k4, n, this.f);
        paramCanvas.restore();
      }
      if (this.z4)
      {
        paramCanvas.save();
        paramCanvas.clipRect(this.p0);
        this.f.setColor(-1166541);
        j = this.j4 + this.Z3 * i;
        localObject = this.p0;
        f1 = ((Rect)localObject).left;
        f2 = j;
        paramCanvas.drawLine(f1, f2, ((Rect)localObject).right, f2, this.f);
        this.f.setColor(-13421586);
        this.f.setStyle(Paint.Style.STROKE);
        j -= this.a4;
        localObject = this.p0;
        paramCanvas.drawRect(((Rect)localObject).left, j, ((Rect)localObject).right, j + this.Z3, this.f);
        paramCanvas.restore();
      }
      m++;
      i++;
    }
    if (this.t4)
    {
      this.f.setColor(this.W3);
      this.f.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.p3, this.f);
    }
    if (this.s4)
    {
      this.f.setColor(this.V3);
      this.f.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.p1, this.f);
      paramCanvas.drawRect(this.p2, this.f);
    }
    if (this.z4)
    {
      this.f.setColor(1144254003);
      this.f.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(0.0F, 0.0F, getPaddingLeft(), getHeight(), this.f);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getPaddingTop(), this.f);
      paramCanvas.drawRect(getWidth() - getPaddingRight(), 0.0F, getWidth(), getHeight(), this.f);
      paramCanvas.drawRect(0.0F, getHeight() - getPaddingBottom(), getWidth(), getHeight(), this.f);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = this.P3;
    paramInt2 = this.Q3;
    paramInt1 = this.M3;
    paramInt1 = paramInt2 * paramInt1 + this.X3 * (paramInt1 - 1);
    paramInt2 = paramInt1;
    if (this.w4) {
      paramInt2 = (int)(paramInt1 * 2 / 3.141592653589793D);
    }
    paramInt1 = n;
    if (this.z4) {
      paramInt1 = n + (getPaddingLeft() + getPaddingRight());
    }
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    n = paramInt1;
    if (this.z4) {
      n = j(i, k, paramInt1);
    }
    setMeasuredDimension(n, j(j, m, paramInt2 + (i1 + i2)));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.p0.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    if (this.z4) {
      this.i4 = this.p0.centerX();
    }
    this.j4 = this.p0.centerY();
    d();
    this.b4 = (this.p0.height() / 2);
    paramInt1 = this.p0.height() / this.M3;
    this.Z3 = paramInt1;
    this.a4 = (paramInt1 / 2);
    e();
    f();
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (getParent() != null) {
              getParent().requestDisallowInterceptTouchEvent(false);
            }
            paramMotionEvent = this.x;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.recycle();
              this.x = null;
            }
          }
        }
        else if (Math.abs(this.p4 - paramMotionEvent.getY()) < this.q4)
        {
          this.x4 = true;
        }
        else
        {
          this.x4 = false;
          this.x.addMovement(paramMotionEvent);
          localObject = this.z;
          if (localObject != null) {
            ((b)localObject).a(1);
          }
          float f1 = paramMotionEvent.getY() - this.o4;
          if (Math.abs(f1) >= 1.0F)
          {
            this.m4 = ((int)(this.m4 + f1));
            this.o4 = ((int)paramMotionEvent.getY());
            invalidate();
          }
        }
      }
      else
      {
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (!this.x4)
        {
          this.x.addMovement(paramMotionEvent);
          if (Build.VERSION.SDK_INT >= 4) {
            this.x.computeCurrentVelocity(1000, this.h4);
          } else {
            this.x.computeCurrentVelocity(1000);
          }
          this.y4 = false;
          i = (int)this.x.getYVelocity();
          if (Math.abs(i) > this.g4)
          {
            this.q.fling(0, this.m4, 0, i, 0, 0, this.e4, this.f4);
            paramMotionEvent = this.q;
            paramMotionEvent.setFinalY(paramMotionEvent.getFinalY() + c(this.q.getFinalY() % this.Z3));
          }
          else
          {
            paramMotionEvent = this.q;
            i = this.m4;
            paramMotionEvent.startScroll(0, i, 0, c(i % this.Z3));
            paramMotionEvent = this.q;
            paramMotionEvent.setFinalY(paramMotionEvent.getFinalY() + c(this.q.getFinalY() % this.Z3));
          }
          if (!this.v4)
          {
            int j = this.q.getFinalY();
            i = this.f4;
            if (j > i)
            {
              this.q.setFinalY(i);
            }
            else
            {
              j = this.q.getFinalY();
              i = this.e4;
              if (j < i) {
                this.q.setFinalY(i);
              }
            }
          }
          this.d.post(this);
          paramMotionEvent = this.x;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.recycle();
            this.x = null;
          }
        }
      }
    }
    else
    {
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      localObject = this.x;
      if (localObject == null) {
        this.x = VelocityTracker.obtain();
      } else {
        ((VelocityTracker)localObject).clear();
      }
      this.x.addMovement(paramMotionEvent);
      if (!this.q.isFinished())
      {
        this.q.abortAnimation();
        localObject = this.q;
        ((Scroller)localObject).setFinalY(((Scroller)localObject).getFinalY() + c(this.q.getFinalY() % this.Z3));
      }
      i = (int)paramMotionEvent.getY();
      this.o4 = i;
      this.p4 = i;
    }
    return true;
  }
  
  public void run()
  {
    Object localObject = this.K3;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if ((this.q.isFinished()) && (!this.y4))
      {
        int i = this.Z3;
        if (i == 0) {
          return;
        }
        int j = (-this.m4 / i + this.c4) % this.K3.size();
        i = j;
        if (j < 0) {
          i = j + this.K3.size();
        }
        if (this.z4) {
          this.d4 = i;
        }
        localObject = this.y;
        if (localObject != null) {
          ((a)localObject).a(this, this.K3.get(i), i);
        }
        localObject = this.z;
        if (localObject != null)
        {
          ((b)localObject).b(i);
          this.z.a(0);
        }
      }
      if (this.q.computeScrollOffset())
      {
        localObject = this.z;
        if (localObject != null) {
          ((b)localObject).a(2);
        }
        this.m4 = this.q.getCurrY();
        postInvalidate();
        this.d.postDelayed(this, 16L);
      }
    }
  }
  
  public void setAtmospheric(boolean paramBoolean)
  {
    this.u4 = paramBoolean;
    invalidate();
  }
  
  public void setCurtain(boolean paramBoolean)
  {
    this.t4 = paramBoolean;
    a();
    invalidate();
  }
  
  public void setCurtainColor(int paramInt)
  {
    this.W3 = paramInt;
    invalidate();
  }
  
  public void setCurved(boolean paramBoolean)
  {
    this.w4 = paramBoolean;
    requestLayout();
    invalidate();
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.v4 = paramBoolean;
    e();
    invalidate();
  }
  
  public void setData(List paramList)
  {
    Objects.requireNonNull(paramList, "WheelPicker's data can not be null!");
    this.K3 = paramList;
    if ((this.c4 <= paramList.size() - 1) && (this.d4 <= paramList.size() - 1))
    {
      this.c4 = this.d4;
    }
    else
    {
      int i = paramList.size() - 1;
      this.d4 = i;
      this.c4 = i;
    }
    this.m4 = 0;
    h();
    e();
    requestLayout();
    invalidate();
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.z4 = paramBoolean;
  }
  
  public void setIndicator(boolean paramBoolean)
  {
    this.s4 = paramBoolean;
    f();
    invalidate();
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.V3 = paramInt;
    invalidate();
  }
  
  public void setIndicatorSize(int paramInt)
  {
    this.U3 = paramInt;
    f();
    invalidate();
  }
  
  public void setItemAlign(int paramInt)
  {
    this.Y3 = paramInt;
    k();
    d();
    invalidate();
  }
  
  public void setItemSpace(int paramInt)
  {
    this.X3 = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setItemTextColor(int paramInt)
  {
    this.R3 = paramInt;
    invalidate();
  }
  
  public void setItemTextSize(int paramInt)
  {
    this.T3 = paramInt;
    this.f.setTextSize(paramInt);
    h();
    requestLayout();
    invalidate();
  }
  
  public void setMaximumWidthText(String paramString)
  {
    Objects.requireNonNull(paramString, "Maximum width text can not be null!");
    this.L3 = paramString;
    h();
    requestLayout();
    invalidate();
  }
  
  public void setMaximumWidthTextPosition(int paramInt)
  {
    if (i(paramInt))
    {
      this.n4 = paramInt;
      h();
      requestLayout();
      invalidate();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Maximum width text Position must in [0, ");
    localStringBuilder.append(this.K3.size());
    localStringBuilder.append("), but current is ");
    localStringBuilder.append(paramInt);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void setOnItemSelectedListener(a parama)
  {
    this.y = parama;
  }
  
  public void setOnWheelChangeListener(b paramb)
  {
    this.z = paramb;
  }
  
  public void setSameWidth(boolean paramBoolean)
  {
    this.r4 = paramBoolean;
    h();
    requestLayout();
    invalidate();
  }
  
  public void setSelectedItemPosition(int paramInt)
  {
    paramInt = Math.max(Math.min(paramInt, this.K3.size() - 1), 0);
    this.c4 = paramInt;
    this.d4 = paramInt;
    this.m4 = 0;
    e();
    requestLayout();
    invalidate();
  }
  
  public void setSelectedItemTextColor(int paramInt)
  {
    this.S3 = paramInt;
    a();
    invalidate();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Paint localPaint = this.f;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    h();
    requestLayout();
    invalidate();
  }
  
  public void setVisibleItemCount(int paramInt)
  {
    this.M3 = paramInt;
    l();
    requestLayout();
  }
  
  public static abstract interface a
  {
    public abstract void a(WheelPicker paramWheelPicker, Object paramObject, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
    
    public abstract void b(int paramInt);
    
    public abstract void c(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\WheelPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */