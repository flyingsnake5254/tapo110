package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.ContextCompat;

public class TPLoadingView
  extends View
{
  private int H3 = 0;
  private Paint I3;
  private a J3;
  private a K3;
  private a L3;
  private a M3;
  private a N3;
  private a O3;
  private a P3;
  private a Q3;
  private a R3;
  private a S3;
  private a T3;
  private int U3 = -1;
  private float c = 550.0F;
  private float d = 550.0F;
  private float f = 50.0F;
  private double p0;
  private float p1;
  private boolean p2 = true;
  private boolean p3 = false;
  private float q = 110.0F;
  private float x = 10.0F;
  private double y;
  private long z;
  
  public TPLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet);
    e();
  }
  
  private void c()
  {
    this.y = 91.0D;
    this.z = 20L;
    this.p0 = 2.2D;
    this.p1 = 3.2F;
    this.x = 10.0F;
    this.c = (getPaddingLeft() + getWidth() / 2.0F);
    this.d = (getPaddingTop() + getHeight() / 2.0F);
    float f1 = this.c;
    this.f = (0.4F * f1);
    this.q = (0.88F * f1);
    this.x = (f1 * 0.1F);
    f();
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPLoadingView);
    this.U3 = paramAttributeSet.getColor(x0.TPLoadingView_load_color, ContextCompat.getColor(paramContext, p0.common_tplink_teal));
    paramAttributeSet.recycle();
  }
  
  private int g(int paramInt, boolean paramBoolean)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    int k;
    if (paramBoolean)
    {
      paramInt = getPaddingLeft();
      k = getPaddingRight();
    }
    else
    {
      paramInt = getPaddingTop();
      k = getPaddingBottom();
    }
    if (i == 1073741824)
    {
      paramInt = j;
    }
    else
    {
      int m;
      if (paramBoolean) {
        m = getSuggestedMinimumWidth();
      } else {
        m = getSuggestedMinimumHeight();
      }
      paramInt = m + (paramInt + k);
      if (i == Integer.MIN_VALUE) {
        if (paramBoolean) {
          paramInt = Math.max(paramInt, j);
        } else {
          paramInt = Math.min(paramInt, j);
        }
      }
    }
    return paramInt;
  }
  
  private void h()
  {
    float f1 = (float)(this.q * Math.sin(Math.toRadians(this.y / 2.0D)));
    float f2 = (float)(this.q * Math.cos(Math.toRadians(this.y / 2.0D)));
    float f3 = (float)(this.f * Math.sin(Math.toRadians(this.y / 2.0D)));
    float f4 = (float)(this.f * Math.cos(Math.toRadians(this.y / 2.0D)));
    float f5 = (float)(this.x * Math.sin(Math.toRadians(this.y / 2.0D)));
    float f6 = (float)(this.x * Math.cos(Math.toRadians(this.y / 2.0D)));
    a locala1 = this.K3;
    a locala2 = this.J3;
    locala2.a -= f1;
    locala2.b += f2;
    locala1 = this.L3;
    locala1.a = (locala2.a - f1 + f4);
    locala1.b = (locala2.b + f2 + f3);
    locala1 = this.M3;
    locala1.a = (locala2.a - f1 + f4 - f6);
    locala1.b = (locala2.b + f2 + f3 - f5);
    locala1 = this.N3;
    locala1.a = (locala2.a - f1 + f4 + f5);
    locala1.b = (locala2.b + f2 + f3 - f6);
    locala1 = this.O3;
    locala2.a += f4;
    locala2.b += f3;
    locala1 = this.P3;
    locala2.a -= f4;
    locala2.b += f3;
    locala1 = this.Q3;
    locala1.a = (locala2.a + f1 - f4);
    locala1.b = (locala2.b + f2 + f3);
    locala1 = this.R3;
    locala1.a = (locala2.a + f1 - f4 - f5);
    locala1.b = (locala2.b + f2 + f3 - f6);
    locala1 = this.S3;
    locala1.a = (locala2.a + f1 - f4 + f6);
    locala1.b = (locala2.b + f2 + f3 - f5);
    locala1 = this.T3;
    locala2.a += f1;
    locala2.b += f2;
  }
  
  public void a()
  {
    int i = this.H3;
    if (i < 10)
    {
      a locala;
      if (i < 5)
      {
        this.y += this.p0;
        locala = this.J3;
        locala.b += this.p1;
      }
      else
      {
        this.y -= this.p0;
        locala = this.J3;
        locala.b -= this.p1;
      }
      h();
      this.H3 += 1;
    }
    else
    {
      this.H3 = 0;
    }
    postInvalidateDelayed(this.z);
  }
  
  protected void b(Canvas paramCanvas)
  {
    Path localPath = new Path();
    if (this.J3 == null) {
      f();
    }
    a locala1 = this.J3;
    localPath.moveTo(locala1.a, locala1.b);
    locala1 = this.K3;
    localPath.lineTo(locala1.a, locala1.b);
    locala1 = this.M3;
    localPath.lineTo(locala1.a, locala1.b);
    a locala2 = this.M3;
    float f1 = locala2.a;
    a locala3 = this.N3;
    float f2 = locala3.a;
    f1 = (f1 + f2) / 2.0F;
    locala1 = this.L3;
    f1 = (f1 + locala1.a) / 2.0F;
    float f3 = locala2.b;
    float f4 = locala3.b;
    localPath.quadTo(f1, ((f3 + f4) / 2.0F + locala1.b) / 2.0F, f2, f4);
    locala1 = this.O3;
    localPath.lineTo(locala1.a, locala1.b);
    localPath.close();
    paramCanvas.drawPath(localPath, this.I3);
    localPath = new Path();
    locala1 = this.J3;
    localPath.moveTo(locala1.a, locala1.b);
    locala1 = this.P3;
    localPath.lineTo(locala1.a, locala1.b);
    locala1 = this.R3;
    localPath.lineTo(locala1.a, locala1.b);
    locala1 = this.R3;
    f1 = locala1.a;
    locala3 = this.S3;
    f2 = locala3.a;
    f1 = (f1 + f2) / 2.0F;
    locala2 = this.Q3;
    f4 = (f1 + locala2.a) / 2.0F;
    f3 = locala1.b;
    f1 = locala3.b;
    localPath.quadTo(f4, ((f3 + f1) / 2.0F + locala2.b) / 2.0F, f2, f1);
    locala1 = this.T3;
    localPath.lineTo(locala1.a, locala1.b);
    localPath.close();
    paramCanvas.drawPath(localPath, this.I3);
  }
  
  protected void e()
  {
    Paint localPaint = new Paint();
    this.I3 = localPaint;
    localPaint.setAntiAlias(true);
    this.I3.setStyle(Paint.Style.FILL);
    this.I3.setColor(this.U3);
  }
  
  protected void f()
  {
    float f1 = (float)(this.q * Math.sin(Math.toRadians(this.y / 2.0D)));
    float f2 = (float)(this.q * Math.cos(Math.toRadians(this.y / 2.0D)));
    float f3 = (float)(this.f * Math.sin(Math.toRadians(this.y / 2.0D)));
    float f4 = (float)(this.f * Math.cos(Math.toRadians(this.y / 2.0D)));
    float f5 = (float)(this.x * Math.sin(Math.toRadians(this.y / 2.0D)));
    float f6 = (float)(this.x * Math.cos(Math.toRadians(this.y / 2.0D)));
    a locala = new a(this.c, this.d * 0.4F);
    this.J3 = locala;
    this.K3 = new a(locala.a - f1, locala.b + f2);
    locala = this.J3;
    this.L3 = new a(locala.a - f1 + f4, locala.b + f2 + f3);
    locala = this.J3;
    this.M3 = new a(locala.a - f1 + f4 - f6, locala.b + f2 + f3 - f5);
    locala = this.J3;
    this.N3 = new a(locala.a - f1 + f4 + f5, locala.b + f2 + f3 - f6);
    locala = this.J3;
    this.O3 = new a(locala.a + f4, locala.b + f3);
    locala = this.J3;
    this.P3 = new a(locala.a - f4, locala.b + f3);
    locala = this.J3;
    this.Q3 = new a(locala.a + f1 - f4, locala.b + f2 + f3);
    locala = this.J3;
    this.R3 = new a(locala.a + f1 - f4 - f5, locala.b + f2 + f3 - f6);
    locala = this.J3;
    this.S3 = new a(locala.a + f1 - f4 + f6, locala.b + f2 + f3 - f5);
    locala = this.J3;
    this.T3 = new a(locala.a + f1, locala.b + f2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.p2)
    {
      this.p2 = false;
      c();
    }
    b(paramCanvas);
    if (this.p3) {
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(g(paramInt1, true), g(paramInt2, false));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.c = paramParcelable.getFloat("x");
      this.d = paramParcelable.getFloat("y");
      this.f = paramParcelable.getFloat("rect_radius_width");
      this.q = paramParcelable.getFloat("rect_radius_height");
      this.x = paramParcelable.getFloat("small_rect_height");
      this.y = paramParcelable.getDouble("angle");
      this.p2 = paramParcelable.getBoolean("is_first");
      this.p3 = paramParcelable.getBoolean("is_animating");
      this.H3 = paramParcelable.getInt("count");
      super.onRestoreInstanceState(paramParcelable.getParcelable("instance_state"));
    }
    else
    {
      super.onRestoreInstanceState(paramParcelable);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instance_state", super.onSaveInstanceState());
    localBundle.putFloat("x", this.c);
    localBundle.putFloat("y", this.d);
    localBundle.putFloat("rect_radius_width", this.f);
    localBundle.putFloat("rect_radius_height", this.q);
    localBundle.putFloat("small_rect_height", this.x);
    localBundle.putDouble("angle", this.y);
    localBundle.putBoolean("is_first", this.p2);
    localBundle.putBoolean("is_animating", this.p3);
    localBundle.putInt("count", this.H3);
    return localBundle;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */