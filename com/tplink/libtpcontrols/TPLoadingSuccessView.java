package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.ContextCompat;

public class TPLoadingSuccessView
  extends View
{
  private int c = 6;
  private float d = 550.0F;
  private float f = 550.0F;
  private a p0;
  private int p1 = -1;
  private Paint q;
  private float x;
  private a y;
  private a z;
  
  public TPLoadingSuccessView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPLoadingSuccessView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPLoadingSuccessView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    this.d = (getPaddingLeft() + getWidth() / 2.0F);
    this.f = (getPaddingTop() + getHeight() / 2.0F);
    this.x = Math.min(getWidth() / 2, getHeight() / 2);
    e();
    d();
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPLoadingSuccessView);
    this.p1 = paramAttributeSet.getColor(x0.TPLoadingSuccessView_success_color, ContextCompat.getColor(paramContext, p0.white));
    paramAttributeSet.recycle();
  }
  
  private int f(int paramInt, boolean paramBoolean)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    int k;
    if (paramBoolean)
    {
      k = getPaddingLeft();
      paramInt = getPaddingRight();
    }
    else
    {
      k = getPaddingTop();
      paramInt = getPaddingBottom();
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
      paramInt = m + (k + paramInt);
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
  
  protected void a(Canvas paramCanvas)
  {
    a locala = this.y;
    float f1 = locala.a;
    float f2 = locala.b;
    locala = this.z;
    float f3 = locala.a;
    int i = this.c;
    paramCanvas.drawLine(f1, f2, i / 3.0F + f3, locala.b + i / 3.0F, this.q);
    locala = this.z;
    f1 = locala.a;
    f2 = locala.b;
    locala = this.p0;
    paramCanvas.drawLine(f1, f2, locala.a, locala.b, this.q);
  }
  
  protected void d()
  {
    Paint localPaint = new Paint();
    this.q = localPaint;
    localPaint.setAntiAlias(true);
    this.q.setStyle(Paint.Style.FILL);
    this.q.setColor(this.p1);
    this.q.setStrokeWidth(this.c);
  }
  
  protected void e()
  {
    float f1 = (float)(this.x * 0.5D * Math.cos(Math.toRadians(10.0D)));
    float f2 = (float)(this.x * 0.5D * Math.sin(Math.toRadians(10.0D)));
    float f3 = (float)(this.x * 0.45D * Math.sin(Math.toRadians(16.0D)));
    float f4 = (float)(this.x * 0.45D * Math.cos(Math.toRadians(16.0D)));
    float f5 = (float)(this.x * 0.7D * Math.cos(Math.toRadians(24.0D)));
    float f6 = (float)(this.x * 0.7D * Math.sin(Math.toRadians(24.0D)));
    this.y = new a(this.d - f1, this.f - f2);
    this.z = new a(this.d - f3, this.f + f4);
    this.p0 = new a(this.d + f5, this.f - f6);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b();
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(f(paramInt1, true), f(paramInt2, false));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.d = paramParcelable.getFloat("x");
      this.f = paramParcelable.getFloat("y");
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
    localBundle.putFloat("x", this.d);
    localBundle.putFloat("y", this.f);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPLoadingSuccessView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */