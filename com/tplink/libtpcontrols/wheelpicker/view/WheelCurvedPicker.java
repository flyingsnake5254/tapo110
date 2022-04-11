package com.tplink.libtpcontrols.wheelpicker.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Region.Op;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import java.util.HashMap;
import java.util.List;

public class WheelCurvedPicker
  extends WheelCrossPicker
{
  private int A4;
  private final HashMap<Integer, Integer> s4 = new HashMap();
  private final HashMap<Integer, Integer> t4 = new HashMap();
  private final Camera u4 = new Camera();
  private final Matrix v4 = new Matrix();
  private final Matrix w4 = new Matrix();
  private int x4;
  private int y4;
  private int z4;
  
  public WheelCurvedPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelCurvedPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int v(int paramInt)
  {
    if (this.t4.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)this.t4.get(Integer.valueOf(paramInt))).intValue();
    }
    else
    {
      int i = (int)(this.x4 - Math.cos(Math.toRadians(paramInt)) * this.x4);
      this.t4.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      paramInt = i;
    }
    return paramInt;
  }
  
  private int w(int paramInt)
  {
    if (this.s4.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)this.s4.get(Integer.valueOf(paramInt))).intValue();
    }
    else
    {
      int i = (int)(Math.sin(Math.toRadians(paramInt)) * this.x4);
      this.s4.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      paramInt = i;
    }
    return paramInt;
  }
  
  protected void b()
  {
    super.b();
    int i = this.h4.b(this.I3, this.K3, this.Q3, this.R3);
    this.x4 = i;
    this.m4 = ((int)(180.0F / (this.I3 + 1)));
    this.S3 = this.h4.i(i, this.Q3, this.R3);
    this.T3 = this.h4.g(this.x4, this.Q3, this.R3);
    this.q4 = -90;
    this.r4 = 90;
    i = -this.m4;
    int j = this.p2.size();
    int k = this.J3;
    this.o4 = (i * (j - k - 1));
    this.p4 = (this.m4 * k);
  }
  
  protected void e(Canvas paramCanvas)
  {
    for (int i = -this.J3; i < this.p2.size() - this.J3; i++)
    {
      int j = this.m4 * i + (this.n4 + this.y4);
      if ((j <= this.r4) && (j >= this.q4))
      {
        int k = w(j);
        if (k == 0) {
          j = 1;
        }
        int m = v(j);
        this.u4.save();
        this.h4.m(this.u4, j);
        this.u4.getMatrix(this.v4);
        this.u4.restore();
        this.h4.t(this.v4, k, this.U3, this.V3);
        this.u4.save();
        this.u4.translate(0.0F, 0.0F, m);
        this.u4.getMatrix(this.w4);
        this.u4.restore();
        this.h4.t(this.w4, k, this.U3, this.V3);
        this.v4.postConcat(this.w4);
        paramCanvas.save();
        paramCanvas.concat(this.v4);
        paramCanvas.clipRect(this.j4, Region.Op.DIFFERENCE);
        this.f.setColor(this.N3);
        this.f.setAlpha(255 - Math.abs(j) * 255 / this.r4);
        this.h4.k(paramCanvas, this.f, (String)this.p2.get(this.J3 + i), k, this.U3, this.W3);
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.clipRect(this.j4);
        this.f.setColor(this.P3);
        this.h4.k(paramCanvas, this.f, (String)this.p2.get(this.J3 + i), k, this.U3, this.W3);
        paramCanvas.restore();
      }
    }
  }
  
  protected void k(MotionEvent paramMotionEvent)
  {
    this.A4 = this.h4.n(this.Z3, this.a4, this.x4);
    int i = this.h4.r(this.Z3, this.a4);
    if (Math.abs(i) >= this.x4)
    {
      if (i >= 0) {
        this.z4 += 1;
      } else {
        this.z4 -= 1;
      }
      this.Z3 = 0;
      this.a4 = 0;
      this.A4 = 0;
    }
    this.y4 = (this.z4 * 80 + this.A4);
    super.k(paramMotionEvent);
  }
  
  protected void l(MotionEvent paramMotionEvent)
  {
    this.n4 += this.y4;
    this.y4 = 0;
    this.A4 = 0;
    this.z4 = 0;
    super.l(paramMotionEvent);
  }
  
  public void r()
  {
    this.s4.clear();
    this.t4.clear();
    this.h4.c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\view\WheelCurvedPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */