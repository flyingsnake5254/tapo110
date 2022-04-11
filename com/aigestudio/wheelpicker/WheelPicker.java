package com.aigestudio.wheelpicker;

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
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.Scroller;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class WheelPicker
  extends View
  implements Runnable
{
  private static final String c = WheelPicker.class.getSimpleName();
  private String A4;
  private boolean B4;
  private Rect H3;
  private Camera I3;
  private Matrix J3;
  private Matrix K3;
  private List L3;
  private String M3;
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
  private int g4;
  private int h4 = 50;
  private int i4 = 8000;
  private int j4;
  private int k4;
  private int l4;
  private int m4;
  private int n4;
  private int o4;
  private b p0;
  private Rect p1;
  private Rect p2;
  private Rect p3;
  private int p4;
  private Scroller q;
  private int q4;
  private int r4 = 8;
  private boolean s4;
  private boolean t4;
  private boolean u4;
  private boolean v4;
  private boolean w4;
  private VelocityTracker x;
  private boolean x4;
  private boolean y;
  private boolean y4;
  private a z;
  private boolean z4;
  
  public WheelPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, e.WheelPicker);
    int i = localTypedArray.getResourceId(e.WheelPicker_wheel_data, 0);
    paramAttributeSet = getResources();
    int j = i;
    if (i == 0) {
      j = a.WheelArrayDefault;
    }
    this.L3 = Arrays.asList(paramAttributeSet.getStringArray(j));
    this.U3 = localTypedArray.getDimensionPixelSize(e.WheelPicker_wheel_item_text_size, getResources().getDimensionPixelSize(b.WheelItemTextSize));
    this.N3 = localTypedArray.getInt(e.WheelPicker_wheel_visible_item_count, 7);
    this.d4 = localTypedArray.getInt(e.WheelPicker_wheel_selected_item_position, 0);
    this.s4 = localTypedArray.getBoolean(e.WheelPicker_wheel_same_width, false);
    this.o4 = localTypedArray.getInt(e.WheelPicker_wheel_maximum_width_text_position, -1);
    this.M3 = localTypedArray.getString(e.WheelPicker_wheel_maximum_width_text);
    this.T3 = localTypedArray.getColor(e.WheelPicker_wheel_selected_item_text_color, -1);
    this.S3 = localTypedArray.getColor(e.WheelPicker_wheel_item_text_color, -7829368);
    this.Y3 = localTypedArray.getDimensionPixelSize(e.WheelPicker_wheel_item_space, getResources().getDimensionPixelSize(b.WheelItemSpace));
    this.w4 = localTypedArray.getBoolean(e.WheelPicker_wheel_cyclic, false);
    this.t4 = localTypedArray.getBoolean(e.WheelPicker_wheel_indicator, false);
    this.W3 = localTypedArray.getColor(e.WheelPicker_wheel_indicator_color, -1166541);
    this.V3 = localTypedArray.getDimensionPixelSize(e.WheelPicker_wheel_indicator_size, getResources().getDimensionPixelSize(b.WheelIndicatorSize));
    this.u4 = localTypedArray.getBoolean(e.WheelPicker_wheel_curtain, false);
    this.X3 = localTypedArray.getColor(e.WheelPicker_wheel_curtain_color, -1996488705);
    this.v4 = localTypedArray.getBoolean(e.WheelPicker_wheel_atmospheric, false);
    this.x4 = localTypedArray.getBoolean(e.WheelPicker_wheel_curved, false);
    this.Z3 = localTypedArray.getInt(e.WheelPicker_wheel_item_align, 0);
    this.A4 = localTypedArray.getString(e.WheelPicker_wheel_font_path);
    localTypedArray.recycle();
    m();
    paramAttributeSet = new Paint(69);
    this.f = paramAttributeSet;
    paramAttributeSet.setTextSize(this.U3);
    if (this.A4 != null) {
      setTypeface(Typeface.createFromAsset(paramContext.getAssets(), this.A4));
    }
    l();
    h();
    this.q = new Scroller(getContext());
    if (Build.VERSION.SDK_INT >= 4)
    {
      paramContext = ViewConfiguration.get(getContext());
      this.h4 = paramContext.getScaledMinimumFlingVelocity();
      this.i4 = paramContext.getScaledMaximumFlingVelocity();
      this.r4 = paramContext.getScaledTouchSlop();
    }
    this.p1 = new Rect();
    this.p2 = new Rect();
    this.p3 = new Rect();
    this.H3 = new Rect();
    this.I3 = new Camera();
    this.J3 = new Matrix();
    this.K3 = new Matrix();
  }
  
  private void a()
  {
    if ((!this.u4) && (this.T3 == -1)) {
      return;
    }
    Rect localRect1 = this.H3;
    Rect localRect2 = this.p1;
    int i = localRect2.left;
    int j = this.k4;
    int k = this.b4;
    localRect1.set(i, j - k, localRect2.right, j + k);
  }
  
  private int b(int paramInt)
  {
    return (int)(this.c4 - Math.cos(Math.toRadians(paramInt)) * this.c4);
  }
  
  private int c(int paramInt)
  {
    if (Math.abs(paramInt) > this.b4)
    {
      if (this.n4 < 0) {}
      for (int i = -this.a4;; i = this.a4) {
        return i - paramInt;
      }
    }
    return -paramInt;
  }
  
  private void d()
  {
    int i = this.Z3;
    if (i != 1)
    {
      if (i != 2) {
        this.l4 = this.j4;
      } else {
        this.l4 = this.p1.right;
      }
    }
    else {
      this.l4 = this.p1.left;
    }
    this.m4 = ((int)(this.k4 - (this.f.ascent() + this.f.descent()) / 2.0F));
  }
  
  private void e()
  {
    int i = this.d4;
    int j = this.a4;
    i *= j;
    if (this.w4) {
      j = Integer.MIN_VALUE;
    } else {
      j = -j * (this.L3.size() - 1) + i;
    }
    this.f4 = j;
    j = i;
    if (this.w4) {
      j = Integer.MAX_VALUE;
    }
    this.g4 = j;
  }
  
  private void f()
  {
    if (!this.t4) {
      return;
    }
    int i = this.V3 / 2;
    int j = this.k4;
    int k = this.b4;
    int m = j + k;
    j -= k;
    Rect localRect1 = this.p2;
    Rect localRect2 = this.p1;
    localRect1.set(localRect2.left, m - i, localRect2.right, m + i);
    localRect2 = this.p3;
    localRect1 = this.p1;
    localRect2.set(localRect1.left, j - i, localRect1.right, j + i);
  }
  
  private int g(int paramInt)
  {
    return (int)(Math.sin(Math.toRadians(paramInt)) * this.c4);
  }
  
  private void h()
  {
    this.R3 = 0;
    this.Q3 = 0;
    if (this.s4)
    {
      this.Q3 = ((int)this.f.measureText(String.valueOf(this.L3.get(0))));
    }
    else if (i(this.o4))
    {
      this.Q3 = ((int)this.f.measureText(String.valueOf(this.L3.get(this.o4))));
    }
    else if (!TextUtils.isEmpty(this.M3))
    {
      this.Q3 = ((int)this.f.measureText(this.M3));
    }
    else
    {
      Iterator localIterator = this.L3.iterator();
      while (localIterator.hasNext())
      {
        localObject = String.valueOf(localIterator.next());
        int i = (int)this.f.measureText((String)localObject);
        this.Q3 = Math.max(this.Q3, i);
      }
    }
    Object localObject = this.f.getFontMetrics();
    this.R3 = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
  }
  
  private boolean i(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.L3.size())) {
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
  
  private void l()
  {
    int i = this.Z3;
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
  
  private void m()
  {
    int i = this.N3;
    if (i >= 2)
    {
      if (i % 2 == 0) {
        this.N3 = (i + 1);
      }
      i = this.N3 + 2;
      this.O3 = i;
      this.P3 = (i / 2);
      return;
    }
    throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
  }
  
  public int getCurrentItemPosition()
  {
    return this.e4;
  }
  
  public int getCurtainColor()
  {
    return this.X3;
  }
  
  public List getData()
  {
    return this.L3;
  }
  
  public int getIndicatorColor()
  {
    return this.W3;
  }
  
  public int getIndicatorSize()
  {
    return this.V3;
  }
  
  public int getItemAlign()
  {
    return this.Z3;
  }
  
  public int getItemSpace()
  {
    return this.Y3;
  }
  
  public int getItemTextColor()
  {
    return this.S3;
  }
  
  public int getItemTextSize()
  {
    return this.U3;
  }
  
  public String getMaximumWidthText()
  {
    return this.M3;
  }
  
  public int getMaximumWidthTextPosition()
  {
    return this.o4;
  }
  
  public int getSelectedItemPosition()
  {
    return this.d4;
  }
  
  public int getSelectedItemTextColor()
  {
    return this.T3;
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
    return this.N3;
  }
  
  public void k(int paramInt, boolean paramBoolean)
  {
    this.y = false;
    if ((paramBoolean) && (this.q.isFinished()))
    {
      int i = getData().size();
      int j = paramInt - this.e4;
      if (j == 0) {
        return;
      }
      paramInt = j;
      if (this.w4)
      {
        paramInt = j;
        if (Math.abs(j) > i / 2)
        {
          paramInt = i;
          if (j > 0) {
            paramInt = -i;
          }
          paramInt = j + paramInt;
        }
      }
      Scroller localScroller = this.q;
      localScroller.startScroll(0, localScroller.getCurrY(), 0, -paramInt * this.a4);
      this.d.post(this);
    }
    else
    {
      if (!this.q.isFinished()) {
        this.q.abortAnimation();
      }
      paramInt = Math.max(Math.min(paramInt, this.L3.size() - 1), 0);
      this.d4 = paramInt;
      this.e4 = paramInt;
      this.n4 = 0;
      e();
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.p0;
    if (localObject != null) {
      ((b)localObject).c(this.n4);
    }
    if (this.L3.size() == 0) {
      return;
    }
    int i = -this.n4 / this.a4;
    int j = this.P3;
    int k = i - j;
    int m = this.d4;
    i = -j;
    m += k;
    while (m < this.d4 + k + this.O3)
    {
      if (this.w4)
      {
        n = m % this.L3.size();
        j = n;
        if (n < 0) {
          j = n + this.L3.size();
        }
        localObject = String.valueOf(this.L3.get(j));
      }
      else if (i(m))
      {
        localObject = String.valueOf(this.L3.get(m));
      }
      else
      {
        localObject = "";
      }
      this.f.setColor(this.S3);
      this.f.setStyle(Paint.Style.FILL);
      j = this.m4;
      int n = this.a4;
      int i1 = i * n + j + this.n4 % n;
      float f1;
      float f2;
      if (this.x4)
      {
        int i2 = Math.abs(j - i1);
        n = this.p1.top;
        f1 = j - i2 - n;
        j = this.m4;
        f1 = f1 * 1.0F / (j - n);
        if (i1 > j) {
          j = 1;
        } else if (i1 < j) {
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
        j = this.j4;
        int i3 = this.Z3;
        if (i3 != 1)
        {
          if (i3 == 2) {
            j = this.p1.right;
          }
        }
        else {
          j = this.p1.left;
        }
        i3 = this.k4 - n;
        this.I3.save();
        this.I3.rotateX(f1);
        this.I3.getMatrix(this.J3);
        this.I3.restore();
        Matrix localMatrix = this.J3;
        f3 = -j;
        f2 = -i3;
        localMatrix.preTranslate(f3, f2);
        localMatrix = this.J3;
        f1 = j;
        float f5 = i3;
        localMatrix.postTranslate(f1, f5);
        this.I3.save();
        this.I3.translate(0.0F, 0.0F, b(i2));
        this.I3.getMatrix(this.K3);
        this.I3.restore();
        this.K3.preTranslate(f3, f2);
        this.K3.postTranslate(f1, f5);
        this.J3.postConcat(this.K3);
        j = n;
      }
      else
      {
        j = 0;
      }
      if (this.v4)
      {
        n = this.m4;
        n = (int)((n - Math.abs(n - i1)) * 1.0F / this.m4 * 255.0F);
        if (n < 0) {
          n = 0;
        }
        this.f.setAlpha(n);
      }
      n = i1;
      if (this.x4) {
        n = this.m4 - j;
      }
      if (this.T3 != -1)
      {
        paramCanvas.save();
        if (this.x4) {
          paramCanvas.concat(this.J3);
        }
        paramCanvas.clipRect(this.H3, Region.Op.DIFFERENCE);
        f2 = this.l4;
        f1 = n;
        paramCanvas.drawText((String)localObject, f2, f1, this.f);
        paramCanvas.restore();
        this.f.setColor(this.T3);
        paramCanvas.save();
        if (this.x4) {
          paramCanvas.concat(this.J3);
        }
        paramCanvas.clipRect(this.H3);
        paramCanvas.drawText((String)localObject, this.l4, f1, this.f);
        paramCanvas.restore();
      }
      else
      {
        paramCanvas.save();
        paramCanvas.clipRect(this.p1);
        if (this.x4) {
          paramCanvas.concat(this.J3);
        }
        paramCanvas.drawText((String)localObject, this.l4, n, this.f);
        paramCanvas.restore();
      }
      if (this.B4)
      {
        paramCanvas.save();
        paramCanvas.clipRect(this.p1);
        this.f.setColor(-1166541);
        j = this.k4 + this.a4 * i;
        localObject = this.p1;
        f2 = ((Rect)localObject).left;
        f1 = j;
        paramCanvas.drawLine(f2, f1, ((Rect)localObject).right, f1, this.f);
        this.f.setColor(-13421586);
        this.f.setStyle(Paint.Style.STROKE);
        j -= this.b4;
        localObject = this.p1;
        paramCanvas.drawRect(((Rect)localObject).left, j, ((Rect)localObject).right, j + this.a4, this.f);
        paramCanvas.restore();
      }
      m++;
      i++;
    }
    if (this.u4)
    {
      this.f.setColor(this.X3);
      this.f.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.H3, this.f);
    }
    if (this.t4)
    {
      this.f.setColor(this.W3);
      this.f.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.p2, this.f);
      paramCanvas.drawRect(this.p3, this.f);
    }
    if (this.B4)
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
    int n = this.Q3;
    paramInt2 = this.R3;
    paramInt1 = this.N3;
    paramInt2 = paramInt2 * paramInt1 + this.Y3 * (paramInt1 - 1);
    paramInt1 = paramInt2;
    if (this.x4) {
      paramInt1 = (int)(paramInt2 * 2 / 3.141592653589793D);
    }
    Object localObject1;
    Object localObject2;
    if (this.B4)
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Wheel's content size is (");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(")");
      Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    paramInt2 = n + (getPaddingLeft() + getPaddingRight());
    paramInt1 += getPaddingTop() + getPaddingBottom();
    if (this.B4)
    {
      localObject2 = c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Wheel's size is (");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(")");
      Log.i((String)localObject2, ((StringBuilder)localObject1).toString());
    }
    setMeasuredDimension(j(i, k, paramInt2), j(j, m, paramInt1));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.p1.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    if (this.B4)
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wheel's drawn rect size is (");
      localStringBuilder.append(this.p1.width());
      localStringBuilder.append(":");
      localStringBuilder.append(this.p1.height());
      localStringBuilder.append(") and location is (");
      localStringBuilder.append(this.p1.left);
      localStringBuilder.append(":");
      localStringBuilder.append(this.p1.top);
      localStringBuilder.append(")");
      Log.i(str, localStringBuilder.toString());
    }
    this.j4 = this.p1.centerX();
    this.k4 = this.p1.centerY();
    d();
    this.c4 = (this.p1.height() / 2);
    paramInt1 = this.p1.height() / this.N3;
    this.a4 = paramInt1;
    this.b4 = (paramInt1 / 2);
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
        else if (Math.abs(this.q4 - paramMotionEvent.getY()) < this.r4)
        {
          this.y4 = true;
        }
        else
        {
          this.y4 = false;
          this.x.addMovement(paramMotionEvent);
          localObject = this.p0;
          if (localObject != null) {
            ((b)localObject).a(1);
          }
          float f1 = paramMotionEvent.getY() - this.p4;
          if (Math.abs(f1) >= 1.0F)
          {
            this.n4 = ((int)(this.n4 + f1));
            this.p4 = ((int)paramMotionEvent.getY());
            invalidate();
          }
        }
      }
      else
      {
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        if ((!this.y4) || (this.z4))
        {
          this.x.addMovement(paramMotionEvent);
          if (Build.VERSION.SDK_INT >= 4) {
            this.x.computeCurrentVelocity(1000, this.i4);
          } else {
            this.x.computeCurrentVelocity(1000);
          }
          this.z4 = false;
          i = (int)this.x.getYVelocity();
          if (Math.abs(i) > this.h4)
          {
            this.q.fling(0, this.n4, 0, i, 0, 0, this.f4, this.g4);
            paramMotionEvent = this.q;
            paramMotionEvent.setFinalY(paramMotionEvent.getFinalY() + c(this.q.getFinalY() % this.a4));
          }
          else
          {
            paramMotionEvent = this.q;
            i = this.n4;
            paramMotionEvent.startScroll(0, i, 0, c(i % this.a4));
          }
          if (!this.w4)
          {
            int j = this.q.getFinalY();
            i = this.g4;
            if (j > i)
            {
              this.q.setFinalY(i);
            }
            else
            {
              i = this.q.getFinalY();
              j = this.f4;
              if (i < j) {
                this.q.setFinalY(j);
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
      this.y = true;
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
        this.z4 = true;
      }
      i = (int)paramMotionEvent.getY();
      this.p4 = i;
      this.q4 = i;
    }
    return true;
  }
  
  public void run()
  {
    Object localObject = this.L3;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if ((this.q.isFinished()) && (!this.z4))
      {
        int i = this.a4;
        if (i == 0) {
          return;
        }
        int j = (-this.n4 / i + this.d4) % this.L3.size();
        i = j;
        if (j < 0) {
          i = j + this.L3.size();
        }
        if (this.B4)
        {
          localObject = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append(":");
          localStringBuilder.append(this.L3.get(i));
          localStringBuilder.append(":");
          localStringBuilder.append(this.n4);
          Log.i((String)localObject, localStringBuilder.toString());
        }
        this.e4 = i;
        localObject = this.z;
        if ((localObject != null) && (this.y)) {
          ((a)localObject).a(this, this.L3.get(i), i);
        }
        localObject = this.p0;
        if ((localObject != null) && (this.y))
        {
          ((b)localObject).b(i);
          this.p0.a(0);
        }
      }
      if (this.q.computeScrollOffset())
      {
        localObject = this.p0;
        if (localObject != null) {
          ((b)localObject).a(2);
        }
        this.n4 = this.q.getCurrY();
        postInvalidate();
        this.d.postDelayed(this, 16L);
      }
    }
  }
  
  public void setAtmospheric(boolean paramBoolean)
  {
    this.v4 = paramBoolean;
    invalidate();
  }
  
  public void setCurtain(boolean paramBoolean)
  {
    this.u4 = paramBoolean;
    a();
    invalidate();
  }
  
  public void setCurtainColor(int paramInt)
  {
    this.X3 = paramInt;
    invalidate();
  }
  
  public void setCurved(boolean paramBoolean)
  {
    this.x4 = paramBoolean;
    requestLayout();
    invalidate();
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.w4 = paramBoolean;
    e();
    invalidate();
  }
  
  public void setData(List paramList)
  {
    Objects.requireNonNull(paramList, "WheelPicker's data can not be null!");
    this.L3 = paramList;
    if ((this.d4 <= paramList.size() - 1) && (this.e4 <= paramList.size() - 1))
    {
      this.d4 = this.e4;
    }
    else
    {
      int i = paramList.size() - 1;
      this.e4 = i;
      this.d4 = i;
    }
    this.n4 = 0;
    h();
    e();
    requestLayout();
    invalidate();
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.B4 = paramBoolean;
  }
  
  public void setIndicator(boolean paramBoolean)
  {
    this.t4 = paramBoolean;
    f();
    invalidate();
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.W3 = paramInt;
    invalidate();
  }
  
  public void setIndicatorSize(int paramInt)
  {
    this.V3 = paramInt;
    f();
    invalidate();
  }
  
  public void setItemAlign(int paramInt)
  {
    this.Z3 = paramInt;
    l();
    d();
    invalidate();
  }
  
  public void setItemSpace(int paramInt)
  {
    this.Y3 = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setItemTextColor(int paramInt)
  {
    this.S3 = paramInt;
    invalidate();
  }
  
  public void setItemTextSize(int paramInt)
  {
    this.U3 = paramInt;
    this.f.setTextSize(paramInt);
    h();
    requestLayout();
    invalidate();
  }
  
  public void setMaximumWidthText(String paramString)
  {
    Objects.requireNonNull(paramString, "Maximum width text can not be null!");
    this.M3 = paramString;
    h();
    requestLayout();
    invalidate();
  }
  
  public void setMaximumWidthTextPosition(int paramInt)
  {
    if (i(paramInt))
    {
      this.o4 = paramInt;
      h();
      requestLayout();
      invalidate();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Maximum width text Position must in [0, ");
    localStringBuilder.append(this.L3.size());
    localStringBuilder.append("), but current is ");
    localStringBuilder.append(paramInt);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void setOnItemSelectedListener(a parama)
  {
    this.z = parama;
  }
  
  public void setOnWheelChangeListener(b paramb)
  {
    this.p0 = paramb;
  }
  
  public void setSameWidth(boolean paramBoolean)
  {
    this.s4 = paramBoolean;
    h();
    requestLayout();
    invalidate();
  }
  
  public void setSelectedItemPosition(int paramInt)
  {
    k(paramInt, true);
  }
  
  public void setSelectedItemTextColor(int paramInt)
  {
    this.T3 = paramInt;
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
    this.N3 = paramInt;
    m();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\WheelPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */