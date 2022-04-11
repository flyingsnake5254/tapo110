package com.tplink.libtpcontrols.wheelpicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.core.d;
import java.util.List;

public abstract class WheelCrossPicker
  extends AbstractWheelPicker
  implements Runnable
{
  protected c h4;
  protected Rect i4;
  protected Rect j4;
  protected Rect k4;
  protected Rect l4;
  protected int m4;
  protected int n4;
  protected int o4;
  protected int p4;
  protected int q4;
  protected int r4;
  
  public WheelCrossPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelCrossPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void s()
  {
    if (this.H3 != 0) {
      return;
    }
    int i = Math.max(0, this.J3 - this.n4 / this.m4);
    i = Math.min(this.p2.size() - 1, i);
    String str = (String)this.p2.get(i);
    if (!this.p3.equals(str))
    {
      this.p3 = str;
      o(i, str);
    }
  }
  
  private void t()
  {
    int i = Math.abs(this.n4 % this.m4);
    if (i != 0)
    {
      float f = i;
      int j = this.m4;
      if (f >= j / 2.0F) {
        u(i - j, j - i);
      } else {
        u(i, -i);
      }
      postInvalidate();
      this.z.postDelayed(this, 16L);
    }
  }
  
  private void u(int paramInt1, int paramInt2)
  {
    int i = this.n4;
    if (i < 0) {
      this.h4.a(this.d, i, paramInt1);
    } else {
      this.h4.a(this.d, i, paramInt2);
    }
    m(2);
  }
  
  protected void c(Canvas paramCanvas)
  {
    if (this.f4)
    {
      this.q.setColor(this.O3);
      paramCanvas.drawRect(this.j4.left, getHeight() / 2.0F - this.K3 / 2.0F, this.j4.right, getHeight() / 2.0F - this.K3 / 2.0F + this.L3, this.q);
      paramCanvas.drawRect(this.j4.left, getHeight() / 2.0F + this.K3 / 2.0F - this.L3, this.j4.right, getHeight() / 2.0F + this.K3 / 2.0F, this.q);
    }
  }
  
  protected void d(Canvas paramCanvas)
  {
    if (this.p1 != null)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.i4);
      this.p1.a(paramCanvas, this.k4, this.l4, this.q);
      paramCanvas.restore();
    }
  }
  
  protected void g()
  {
    super.g();
    this.h4 = new b();
    this.i4 = new Rect();
    this.j4 = new Rect();
    this.k4 = new Rect();
    this.l4 = new Rect();
  }
  
  protected void j(MotionEvent paramMotionEvent) {}
  
  protected void k(MotionEvent paramMotionEvent)
  {
    m(1);
    n(this.b4 + this.Z3, this.c4 + this.a4);
    invalidate();
  }
  
  protected void l(MotionEvent paramMotionEvent)
  {
    this.h4.l(this.d, this.c, this.n4, this.o4, this.p4, this.r4);
    m(2);
    this.z.post(this);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h4.d(this.j4, this.K3, paramInt1, paramInt2, this.Q3, this.R3, this.U3, this.V3, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    this.h4.h(this.k4, this.l4, this.j4, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    this.i4.set(this.j4);
    if (!this.d4) {
      this.h4.o(this.i4, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
  }
  
  public void p(boolean paramBoolean, com.tplink.libtpcontrols.wheelpicker.core.a parama)
  {
    super.p(paramBoolean, parama);
    invalidate(this.j4);
  }
  
  public void q()
  {
    int i = this.n4;
    int j = this.p4;
    if (i > j) {
      this.h4.a(this.d, i, j - i);
    }
    j = this.n4;
    i = this.o4;
    if (j < i) {
      this.h4.a(this.d, j, i - j);
    }
    this.z.post(this);
  }
  
  public void r() {}
  
  public void run()
  {
    if (this.d.b())
    {
      m(0);
      t();
      s();
    }
    if (this.d.h())
    {
      this.b4 = this.d.d();
      this.c4 = this.d.e();
      this.n4 = this.h4.p(this.d);
      n(this.b4, this.c4);
      postInvalidate();
      this.z.postDelayed(this, 16L);
    }
  }
  
  public void setCurrentTextColor(int paramInt)
  {
    super.setCurrentTextColor(paramInt);
    invalidate(this.j4);
  }
  
  public void setData(List<String> paramList)
  {
    super.setData(paramList);
    r();
  }
  
  public void setItemCount(int paramInt)
  {
    super.setItemCount(paramInt);
    r();
  }
  
  public void setItemSpace(int paramInt)
  {
    super.setItemSpace(paramInt);
    r();
  }
  
  public void setOrientation(int paramInt)
  {
    Object localObject;
    if (paramInt == 0) {
      localObject = new a();
    } else {
      localObject = new b();
    }
    this.h4 = ((c)localObject);
    b();
    requestLayout();
  }
  
  public void setTextSize(int paramInt)
  {
    super.setTextSize(paramInt);
    r();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\view\WheelCrossPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */