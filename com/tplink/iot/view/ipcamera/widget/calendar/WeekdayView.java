package com.tplink.iot.view.ipcamera.widget.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.ContextCompat;
import com.tplink.iot.b;

public class WeekdayView
  extends View
{
  private int H3 = 40;
  private int I3 = 40;
  private int J3 = 0;
  private String[] c;
  private boolean d = false;
  private boolean f = false;
  private int p0 = 1;
  private int p1 = 13;
  private Paint p2;
  private DisplayMetrics p3;
  private int q = Color.parseColor("#5C5C5C");
  private int x = Color.parseColor("#5C5C5C");
  private int y = getResources().getColor(2131099678);
  private int z = getResources().getColor(2131099678);
  
  public WeekdayView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public WeekdayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public WeekdayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.p3 = getResources().getDisplayMetrics();
    this.p2 = new Paint(1);
    b(paramContext, paramAttributeSet);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.WeekdayView);
    this.c = new String[] { paramContext.getString(3), paramContext.getString(1), paramContext.getString(5), paramContext.getString(6), paramContext.getString(4), paramContext.getString(0), paramContext.getString(2) };
    this.y = paramContext.getColor(7, ContextCompat.getColor(getContext(), 2131099678));
    this.z = paramContext.getColor(8, ContextCompat.getColor(getContext(), 2131099678));
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth() - this.H3 - this.I3;
    int j = getHeight();
    this.p2.setStyle(Paint.Style.FILL);
    this.p2.setTypeface(Typeface.DEFAULT_BOLD);
    this.p2.setAntiAlias(true);
    this.p2.setTextSize(this.p1 * this.p3.scaledDensity);
    this.J3 = (i / this.c.length);
    Object localObject;
    for (int k = 0;; k++)
    {
      localObject = this.c;
      if (k >= localObject.length) {
        break;
      }
      localObject = localObject[k];
      int m = (int)this.p2.measureText((String)localObject);
      int n = this.H3;
      int i1 = this.J3;
      int i2 = (i1 - m) / 2;
      m = (int)(j / 2 - (this.p2.ascent() + this.p2.descent()) / 2.0F);
      if ((!((String)localObject).equals(getResources().getString(2131954455))) && (!((String)localObject).equals(getResources().getString(2131954456)))) {
        this.p2.setColor(this.y);
      } else {
        this.p2.setColor(this.z);
      }
      paramCanvas.drawText((String)localObject, n + i1 * k + i2, m, this.p2);
    }
    k = (int)this.p2.measureText(localObject[0]);
    k = this.H3 + (this.J3 - k) / 2;
    this.p2.setStyle(Paint.Style.STROKE);
    this.p2.setStrokeWidth(this.p0);
    if (this.d)
    {
      this.p2.setColor(this.q);
      paramCanvas.drawLine(k, 0.0F, this.H3 + i + this.I3, 0.0F, this.p2);
    }
    if (this.f)
    {
      this.p2.setColor(this.x);
      float f1 = k;
      float f2 = j;
      paramCanvas.drawLine(f1, f2, i, f2, this.p2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    float f1;
    if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) {
      f1 = this.p3.density;
    } else {
      f1 = this.p3.density;
    }
    setMeasuredDimension(paramInt1, (int)f1 * 30);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setWeedayColor(int paramInt)
  {
    this.y = paramInt;
    invalidate();
  }
  
  public void setWeekendColor(int paramInt)
  {
    this.z = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\calendar\WeekdayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */