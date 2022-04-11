package com.tplink.libtpcontrols.wheelpicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region.Op;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import java.util.List;

public class WheelStraightPicker
  extends WheelCrossPicker
{
  public WheelStraightPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelStraightPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    super.b();
    this.S3 = this.h4.s(this.I3, this.K3, this.Q3, this.R3);
    this.T3 = this.h4.e(this.I3, this.K3, this.Q3, this.R3);
    this.m4 = this.h4.f(this.K3, this.Q3, this.R3);
    int i = this.h4.q(this.I3, this.K3, this.Q3, this.R3);
    this.q4 = (-i);
    this.r4 = i;
    int j = -this.m4;
    int k = this.p2.size();
    i = this.J3;
    this.o4 = (j * (k - i - 1));
    this.p4 = (this.m4 * i);
  }
  
  protected void e(Canvas paramCanvas)
  {
    for (int i = -this.J3; i < this.p2.size() - this.J3; i++)
    {
      int j = this.h4.j(this.m4, i, this.b4, this.c4, this.Z3, this.a4);
      if ((j <= this.r4) && (j >= this.q4))
      {
        paramCanvas.save();
        paramCanvas.clipRect(this.j4, Region.Op.DIFFERENCE);
        this.f.setColor(this.N3);
        this.f.setAlpha(255 - Math.abs(j) * 255 / this.r4);
        this.h4.k(paramCanvas, this.f, (String)this.p2.get(this.J3 + i), j, this.U3, this.W3);
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.clipRect(this.j4);
        this.f.setColor(this.P3);
        this.h4.k(paramCanvas, this.f, (String)this.p2.get(i + this.J3), j, this.U3, this.W3);
        paramCanvas.restore();
      }
    }
  }
  
  protected void k(MotionEvent paramMotionEvent)
  {
    super.k(paramMotionEvent);
  }
  
  protected void l(MotionEvent paramMotionEvent)
  {
    this.n4 = this.h4.u(this.b4, this.c4);
    super.l(paramMotionEvent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\view\WheelStraightPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */