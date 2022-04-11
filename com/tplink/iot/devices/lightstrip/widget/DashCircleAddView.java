package com.tplink.iot.devices.lightstrip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class DashCircleAddView
  extends View
{
  private final int c = (int)a(84);
  private final float d;
  private final float f;
  private final Paint p0;
  private final float q;
  private final float x;
  private float y;
  private final Paint z;
  
  public DashCircleAddView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public DashCircleAddView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public DashCircleAddView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = a(2);
    this.d = f1;
    this.f = a(4);
    this.q = a(6);
    float f2 = a(2);
    this.x = f2;
    this.y = a(36);
    paramAttributeSet = new Paint(1);
    paramAttributeSet.setStyle(Paint.Style.STROKE);
    paramAttributeSet.setColor((int)2576980377L);
    paramAttributeSet.setStrokeWidth(f1);
    paramAttributeSet.setStrokeCap(Paint.Cap.ROUND);
    paramAttributeSet.setPathEffect(new DashPathEffect(new float[] { 5.0F, 10.0F }, 0.0F));
    paramContext = p.a;
    this.z = paramAttributeSet;
    paramContext = new Paint(1);
    paramContext.setColor((int)4288256409L);
    paramContext.setStrokeWidth(f2);
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    this.p0 = paramContext;
  }
  
  private final float a(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  private final int b(int paramInt)
  {
    int i = this.c;
    int j = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (j != Integer.MIN_VALUE)
    {
      if (j != 0)
      {
        if (j != 1073741824) {
          paramInt = i;
        }
      }
      else {
        paramInt = this.c;
      }
    }
    else {
      paramInt = Math.min(this.c, paramInt);
    }
    return paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    float f1 = getWidth() / 2.0F;
    paramCanvas.drawCircle(f1, f1, (getWidth() - this.d) / 2.0F - this.q - this.f, this.z);
    float f2 = getWidth() * 0.4F;
    paramCanvas.drawLine(f2, f1, getWidth() - f2, f1, this.p0);
    paramCanvas.drawLine(f1, f2, f1, getHeight() - f2, this.p0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(b(paramInt1), b(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    j.e(paramMotionEvent, "event");
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        setAlpha(1.0F);
      }
    }
    else {
      setAlpha(0.5F);
    }
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\DashCircleAddView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */