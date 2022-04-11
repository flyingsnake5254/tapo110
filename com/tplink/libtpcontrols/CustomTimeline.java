package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import b.d.w.f.a;

public class CustomTimeline
  extends View
{
  private static float c = 7.0F;
  private static float d = 1.0F;
  private float H3;
  private int I3;
  private int J3;
  private int K3;
  private boolean f;
  private int p0;
  private Paint p1;
  private boolean p2;
  private boolean p3;
  private boolean q;
  private int x;
  private int y;
  private int z;
  
  public CustomTimeline(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomTimeline(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.p1 = new Paint();
    this.f = false;
    this.q = false;
    this.p2 = false;
    this.p3 = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.CustomTimeline);
    this.f = paramAttributeSet.getBoolean(x0.CustomTimeline_drawTimeLineHead, false);
    this.q = paramAttributeSet.getBoolean(x0.CustomTimeline_drawTimeLineEnd, false);
    this.x = paramAttributeSet.getDimensionPixelSize(x0.CustomTimeline_pointPadding, a.a(paramContext, c));
    this.y = paramAttributeSet.getDimensionPixelSize(x0.CustomTimeline_lineWidth, a.a(paramContext, d));
    this.z = paramAttributeSet.getColor(x0.CustomTimeline_timePointColor, -7829368);
    this.p0 = paramAttributeSet.getColor(x0.CustomTimeline_timeLineColor, -7829368);
    this.p2 = paramAttributeSet.getBoolean(x0.CustomTimeline_timePointTop, false);
    this.p3 = paramAttributeSet.getBoolean(x0.CustomTimeline_timePointLine, false);
    this.H3 = paramAttributeSet.getDimension(x0.CustomTimeline_timePointMarginTop, 0.0F);
    paramAttributeSet.recycle();
  }
  
  public int getTimePointPadding()
  {
    return this.x;
  }
  
  public float getTimelineWidth()
  {
    return this.y;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.I3 / 2.0F;
    float f2 = this.J3 / 2.0F;
    int i = this.K3;
    float f3 = i;
    int j = this.x;
    if (f3 > j) {
      f3 = j;
    } else {
      f3 = i;
    }
    f3 /= 2.0F;
    this.p1.setStrokeWidth(j);
    this.p1.setStyle(Paint.Style.FILL);
    this.p1.setColor(this.z);
    this.p1.setAntiAlias(true);
    if (!this.p2)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.p1);
      if (this.f)
      {
        this.p1.setStrokeWidth(this.y);
        this.p1.setColor(this.p0);
        this.p1.setAntiAlias(true);
        paramCanvas.drawLine(f1, f2, f1, 0.0F, this.p1);
      }
      if (this.q)
      {
        this.p1.setStrokeWidth(this.y);
        this.p1.setColor(this.p0);
        this.p1.setAntiAlias(true);
        paramCanvas.drawLine(f1, f2, f1, this.J3, this.p1);
      }
    }
    else
    {
      paramCanvas.drawCircle(f1, this.H3, f3, this.p1);
      if (this.p3)
      {
        this.p1.setStrokeWidth(this.y);
        this.p1.setColor(this.p0);
        this.p1.setAntiAlias(true);
        paramCanvas.drawLine(f1, f3 / 2.0F, f1, this.J3, this.p1);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.I3 = getWidth();
    paramInt1 = getHeight();
    this.J3 = paramInt1;
    this.K3 = Math.min(this.I3, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void setDrawTimelineEnd(boolean paramBoolean)
  {
    this.q = paramBoolean;
    postInvalidate();
  }
  
  public void setDrawTimelineHead(boolean paramBoolean)
  {
    this.f = paramBoolean;
    postInvalidate();
  }
  
  public void setPointTopMode(boolean paramBoolean)
  {
    this.p2 = paramBoolean;
    postInvalidate();
  }
  
  public void setTimePointPadding(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setTimelineDraw(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
    postInvalidate();
  }
  
  public void setTimelineWidth(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\CustomTimeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */