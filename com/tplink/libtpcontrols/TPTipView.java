package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class TPTipView
  extends View
{
  private a H3;
  private a I3;
  private a J3;
  private a K3;
  private a L3;
  private a M3;
  private float c = 550.0F;
  private float d = 550.0F;
  private boolean f = true;
  private int p0;
  private int p1;
  private float p2;
  private a p3;
  private float q;
  private Paint x;
  private Paint y;
  private int z;
  
  public TPTipView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPTipView);
    this.z = paramContext.getInt(x0.TPTipView_tip_type, 0);
    this.p0 = paramContext.getColor(x0.TPTipView_tip_circle_color, getResources().getColor(p0.common_tplink_green));
    this.p1 = paramContext.getColor(x0.TPTipView_tip_line_color, getResources().getColor(p0.white));
    this.p2 = paramContext.getDimension(x0.TPTipView_tip_line_width, 2.0F);
    paramContext.recycle();
    a();
  }
  
  private void a()
  {
    this.c = (getPaddingLeft() + getWidth() / 2.0F);
    this.d = (getPaddingTop() + getHeight() / 2.0F);
    this.q = Math.min(getWidth() / 2, getHeight() / 2);
    b();
    c();
  }
  
  private void b()
  {
    Paint localPaint = new Paint();
    this.x = localPaint;
    localPaint.setAntiAlias(true);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setColor(this.p0);
    localPaint = new Paint();
    this.y = localPaint;
    localPaint.setAntiAlias(true);
    this.y.setStyle(Paint.Style.FILL);
    this.y.setColor(-1);
    this.y.setStrokeWidth(this.p1);
    this.y.setStrokeWidth(this.p2);
  }
  
  private void c()
  {
    float f1 = (float)(this.q * 0.5D * Math.cos(Math.toRadians(10.0D)));
    float f2 = (float)(this.q * 0.5D * Math.sin(Math.toRadians(10.0D)));
    float f3 = (float)(this.q * 0.45D * Math.sin(Math.toRadians(16.0D)));
    float f4 = (float)(this.q * 0.45D * Math.cos(Math.toRadians(16.0D)));
    float f5 = (float)(this.q * 0.7D * Math.cos(Math.toRadians(24.0D)));
    float f6 = (float)(this.q * 0.7D * Math.sin(Math.toRadians(24.0D)));
    this.p3 = new a(this.c - f1, this.d - f2);
    this.H3 = new a(this.c - f3, this.d + f4);
    this.I3 = new a(this.c + f5, this.d - f6);
    f3 = (float)(this.q * 0.6D * Math.cos(Math.toRadians(45.0D)));
    f2 = (float)(this.q * 0.6D * Math.sin(Math.toRadians(45.0D)));
    this.J3 = new a(this.c - f3, this.d - f2);
    this.K3 = new a(this.c + f3, this.d + f2);
    this.L3 = new a(this.c - f3, this.d + f2);
    this.M3 = new a(this.c + f3, this.d - f2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.f)
    {
      a();
      this.f = false;
    }
    paramCanvas.drawCircle(this.c, this.d, this.q, this.x);
    a locala;
    float f1;
    float f2;
    if (this.z == 0)
    {
      locala = this.p3;
      f1 = locala.a;
      f2 = locala.b;
      locala = this.H3;
      paramCanvas.drawLine(f1, f2, locala.a, locala.b, this.y);
      locala = this.H3;
      f1 = locala.a;
      f2 = locala.b;
      locala = this.I3;
      paramCanvas.drawLine(f1, f2, locala.a, locala.b, this.y);
    }
    else
    {
      locala = this.J3;
      f1 = locala.a;
      f2 = locala.b;
      locala = this.K3;
      paramCanvas.drawLine(f1, f2, locala.a, locala.b, this.y);
      locala = this.L3;
      f1 = locala.a;
      f2 = locala.b;
      locala = this.M3;
      paramCanvas.drawLine(f1, f2, locala.a, locala.b, this.y);
    }
  }
  
  public void setCirclePaint(int paramInt)
  {
    paramInt = getResources().getColor(paramInt);
    this.p0 = paramInt;
    this.x.setColor(paramInt);
    invalidate();
  }
  
  public void setLinePaint(int paramInt)
  {
    paramInt = getResources().getColor(paramInt);
    this.p1 = paramInt;
    this.y.setColor(paramInt);
    invalidate();
  }
  
  public void setTipType(int paramInt)
  {
    if (paramInt == 0) {
      this.z = 0;
    } else if (paramInt == 1) {
      this.z = 1;
    } else {
      this.z = 0;
    }
    invalidate();
  }
  
  static class a
  {
    public float a;
    public float b;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPTipView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */