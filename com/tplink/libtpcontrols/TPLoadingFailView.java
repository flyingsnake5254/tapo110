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

public class TPLoadingFailView
  extends View
{
  private int c = 6;
  private float d = 550.0F;
  private float f = 550.0F;
  private float q = 50.0F;
  private Paint x;
  private int y = -1;
  
  public TPLoadingFailView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPLoadingFailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPLoadingFailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
    d();
  }
  
  private void b()
  {
    this.d = (getPaddingLeft() + getWidth() / 2.0F);
    this.f = (getPaddingTop() + getHeight() / 2.0F);
    this.q = (this.d * 0.5F);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPLoadingFailView);
    this.y = paramAttributeSet.getColor(x0.TPLoadingFailView_fail_color, ContextCompat.getColor(paramContext, p0.white));
    paramAttributeSet.recycle();
  }
  
  private int e(int paramInt, boolean paramBoolean)
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
  
  protected void a(Canvas paramCanvas)
  {
    float f1 = this.d;
    float f2 = this.q;
    float f3 = this.f;
    paramCanvas.drawLine(f1 - f2, f3 - f2, f1 + f2, f3 + f2, this.x);
    f2 = this.d;
    f3 = this.q;
    f1 = this.f;
    paramCanvas.drawLine(f2 - f3, f1 + f3, f2 + f3, f1 - f3, this.x);
  }
  
  protected void d()
  {
    Paint localPaint = new Paint();
    this.x = localPaint;
    localPaint.setAntiAlias(true);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setColor(this.y);
    this.x.setStrokeWidth(this.c);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b();
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(e(paramInt1, true), e(paramInt2, false));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.d = paramParcelable.getFloat("x");
      this.f = paramParcelable.getFloat("y");
      this.q = paramParcelable.getFloat("rect_radius_width");
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
    localBundle.putFloat("rect_radius_width", this.q);
    return localBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPLoadingFailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */