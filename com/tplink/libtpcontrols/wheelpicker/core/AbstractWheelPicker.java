package com.tplink.libtpcontrols.wheelpicker.core;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import com.tplink.libtpcontrols.n0;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.x0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractWheelPicker
  extends View
{
  protected int H3 = 0;
  protected int I3;
  protected int J3;
  protected int K3;
  protected int L3;
  protected int M3;
  protected int N3;
  protected int O3;
  protected int P3;
  protected int Q3;
  protected int R3;
  protected int S3;
  protected int T3;
  protected int U3;
  protected int V3;
  protected int W3;
  protected int X3;
  protected int Y3;
  protected int Z3;
  protected int a4;
  protected int b4;
  protected VelocityTracker c;
  protected int c4;
  protected d d;
  protected boolean d4;
  protected boolean e4;
  protected TextPaint f;
  protected boolean f4;
  protected Context g4;
  protected a p0;
  protected a p1;
  protected List<String> p2;
  protected String p3;
  protected Paint q;
  protected Rect x;
  protected Rect y;
  protected Handler z;
  
  public AbstractWheelPicker(Context paramContext)
  {
    super(paramContext);
    this.g4 = paramContext;
    f(null);
  }
  
  public AbstractWheelPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g4 = paramContext;
    f(paramAttributeSet);
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    i(paramAttributeSet);
    g();
    a();
    b();
  }
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
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
  
  protected void a()
  {
    this.p3 = "";
  }
  
  protected void b()
  {
    this.b4 = 0;
    this.c4 = 0;
    this.Q3 = 0;
    this.R3 = 0;
    String str;
    if (this.e4)
    {
      str = (String)this.p2.get(0);
      this.f.getTextBounds(str, 0, str.length(), this.x);
      this.Q3 = Math.max(this.Q3, this.x.width());
      this.R3 = Math.max(this.R3, this.x.height());
    }
    else
    {
      Iterator localIterator = this.p2.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        this.f.getTextBounds(str, 0, str.length(), this.x);
        this.Q3 = Math.max(this.Q3, this.x.width());
        this.R3 = Math.max(this.R3, this.x.height());
      }
    }
  }
  
  protected abstract void c(Canvas paramCanvas);
  
  protected abstract void d(Canvas paramCanvas);
  
  protected abstract void e(Canvas paramCanvas);
  
  protected void g()
  {
    TextPaint localTextPaint = new TextPaint(69);
    this.f = localTextPaint;
    localTextPaint.setTextAlign(Paint.Align.CENTER);
    this.f.setTextSize(this.M3);
    this.q = new Paint(5);
    this.x = new Rect();
    this.y = new Rect();
    this.z = new Handler();
    int i = Build.VERSION.SDK_INT;
    if (i >= 9) {
      this.d = new b(getContext(), new DecelerateInterpolator());
    } else {
      this.d = new c(getContext(), new DecelerateInterpolator());
    }
    if (i >= 11) {
      this.d.f(ViewConfiguration.getScrollFriction() / 25.0F);
    }
  }
  
  protected void i(AttributeSet paramAttributeSet)
  {
    int i = n0.WheelArrayDefault;
    int j = getResources().getDimensionPixelSize(q0.WheelItemSpace);
    int k = getResources().getDimensionPixelSize(q0.WheelTextSize);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, x0.AbstractWheelPicker);
      int m = paramAttributeSet.getResourceId(x0.AbstractWheelPicker_wheel_data, 0);
      if (m == 0) {
        m = i;
      }
      this.p2 = Arrays.asList(getContext().getResources().getStringArray(m));
      this.J3 = paramAttributeSet.getInt(x0.AbstractWheelPicker_wheel_item_index, 0);
      this.I3 = paramAttributeSet.getInt(x0.AbstractWheelPicker_wheel_item_count, 7);
      this.K3 = paramAttributeSet.getDimensionPixelSize(x0.AbstractWheelPicker_wheel_item_space, j);
      this.L3 = paramAttributeSet.getDimensionPixelSize(x0.AbstractWheelPicker_wheel_divider_height, 1);
      this.M3 = paramAttributeSet.getDimensionPixelSize(x0.AbstractWheelPicker_wheel_text_size, k);
      this.N3 = paramAttributeSet.getColor(x0.AbstractWheelPicker_wheel_text_color, -16777216);
      this.O3 = paramAttributeSet.getColor(x0.AbstractWheelPicker_wheel_divider_color, -5789268);
      this.P3 = paramAttributeSet.getColor(x0.AbstractWheelPicker_wheel_text_color_current, -16777216);
      this.e4 = paramAttributeSet.getBoolean(x0.AbstractWheelPicker_wheel_item_same_size, false);
      this.f4 = paramAttributeSet.getBoolean(x0.AbstractWheelPicker_wheel_has_divider, true);
      paramAttributeSet.recycle();
    }
    else
    {
      this.p2 = Arrays.asList(getContext().getResources().getStringArray(i));
      this.J3 = 0;
      this.I3 = 7;
      this.K3 = j;
      this.M3 = k;
      this.P3 = -16777216;
    }
  }
  
  protected abstract void j(MotionEvent paramMotionEvent);
  
  protected abstract void k(MotionEvent paramMotionEvent);
  
  protected abstract void l(MotionEvent paramMotionEvent);
  
  protected void m(int paramInt)
  {
    if (this.H3 != paramInt)
    {
      this.H3 = paramInt;
      a locala = this.p0;
      if (locala != null) {
        locala.a(paramInt);
      }
    }
  }
  
  protected void n(float paramFloat1, float paramFloat2)
  {
    a locala = this.p0;
    if (locala != null) {
      locala.b(paramFloat1, paramFloat2);
    }
  }
  
  protected void o(int paramInt, String paramString)
  {
    a locala = this.p0;
    if (locala != null) {
      locala.c(paramInt, paramString);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    c(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipRect(this.y);
    e(paramCanvas);
    paramCanvas.restore();
    d(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = this.S3;
    int n = this.T3;
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    paramInt2 = getPaddingTop();
    int i3 = getPaddingBottom();
    setMeasuredDimension(h(i, paramInt1, m + (i1 + i2)), h(j, k, n + (paramInt2 + i3)));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.J3;
    o(paramInt3, (String)this.p2.get(paramInt3));
    this.y.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    this.U3 = this.y.centerX();
    paramInt1 = this.y.centerY();
    this.V3 = paramInt1;
    this.W3 = ((int)(paramInt1 - (this.f.ascent() + this.f.descent()) / 2.0F));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c == null) {
      this.c = VelocityTracker.obtain();
    }
    this.c.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.d.g();
            this.c.recycle();
            this.c = null;
          }
        }
        else
        {
          this.Z3 = ((int)(this.Z3 + (paramMotionEvent.getX() - this.X3)));
          this.a4 = ((int)(this.a4 + (paramMotionEvent.getY() - this.Y3)));
          this.X3 = ((int)paramMotionEvent.getX());
          this.Y3 = ((int)paramMotionEvent.getY());
          k(paramMotionEvent);
        }
      }
      else
      {
        this.b4 += this.Z3;
        this.c4 += this.a4;
        this.Z3 = 0;
        this.a4 = 0;
        this.c.computeCurrentVelocity(150);
        l(paramMotionEvent);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.c.recycle();
        this.c = null;
      }
    }
    else
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      if (!this.d.b()) {
        this.d.g();
      }
      this.X3 = ((int)paramMotionEvent.getX());
      this.Y3 = ((int)paramMotionEvent.getY());
      j(paramMotionEvent);
    }
    return true;
  }
  
  public void p(boolean paramBoolean, a parama)
  {
    this.d4 = paramBoolean;
    this.p1 = parama;
  }
  
  public void setCurrentTextColor(int paramInt)
  {
    this.P3 = paramInt;
  }
  
  public void setData(List<String> paramList)
  {
    this.p2 = paramList;
    b();
    requestLayout();
  }
  
  public void setItemCount(int paramInt)
  {
    this.I3 = paramInt;
    b();
    requestLayout();
  }
  
  public void setItemIndex(int paramInt)
  {
    this.J3 = paramInt;
    b();
    requestLayout();
  }
  
  public void setItemSpace(int paramInt)
  {
    this.K3 = paramInt;
    b();
    requestLayout();
  }
  
  public void setOnWheelChangeListener(a parama)
  {
    this.p0 = parama;
  }
  
  public void setTextColor(int paramInt)
  {
    this.N3 = paramInt;
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.M3 = paramInt;
    this.f.setTextSize(paramInt);
    b();
    requestLayout();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void b(float paramFloat1, float paramFloat2);
    
    public abstract void c(int paramInt, String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\core\AbstractWheelPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */