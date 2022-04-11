package com.tplink.libtpcontrols.wheelpicker.widget.curved;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker;
import com.tplink.libtpcontrols.wheelpicker.core.AbstractWheelPicker.a;
import com.tplink.libtpcontrols.wheelpicker.core.a;
import com.tplink.libtpcontrols.wheelpicker.view.WheelCrossPicker;
import java.util.List;

public class WheelDatePicker
  extends LinearLayout
{
  protected float H3;
  protected WheelYearPicker c;
  protected WheelMonthPicker d;
  protected WheelDayPicker f;
  protected int p0 = -16777216;
  protected int p1;
  protected int p2;
  protected int p3;
  protected AbstractWheelPicker.a q;
  protected String x;
  protected String y;
  protected String z;
  
  public WheelDatePicker(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public WheelDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  private void c(WheelCrossPicker paramWheelCrossPicker, final String paramString)
  {
    paramWheelCrossPicker.p(true, new a(paramString));
  }
  
  private void d(AbstractWheelPicker.a parama)
  {
    if ((this.p1 == 0) && (this.p2 == 0) && (this.p3 == 0)) {
      parama.a(0);
    }
    if ((this.p1 == 2) || (this.p2 == 2) || (this.p3 == 2)) {
      parama.a(2);
    }
    if (this.p1 + this.p2 + this.p3 == 1) {
      parama.a(1);
    }
  }
  
  private void e()
  {
    setGravity(17);
    setOrientation(0);
    int i = getResources().getDimensionPixelSize(q0.WheelPadding);
    int j = i * 2;
    this.H3 = i;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    this.c = new WheelYearPicker(getContext());
    this.d = new WheelMonthPicker(getContext());
    this.f = new WheelDayPicker(getContext());
    this.c.setPadding(0, i, j, i);
    this.d.setPadding(0, i, j, i);
    this.f.setPadding(0, i, j, i);
    c(this.c, "年");
    c(this.d, "月");
    c(this.f, "日");
    addView(this.c, localLayoutParams);
    addView(this.d, localLayoutParams);
    addView(this.f, localLayoutParams);
    f(this.c, 0);
    f(this.d, 1);
    f(this.f, 2);
  }
  
  private void f(WheelCrossPicker paramWheelCrossPicker, final int paramInt)
  {
    paramWheelCrossPicker.setOnWheelChangeListener(new b(paramInt));
  }
  
  private boolean g()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.x)) && (!TextUtils.isEmpty(this.y)) && (!TextUtils.isEmpty(this.z))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setCurrentTextColor(int paramInt)
  {
    this.c.setCurrentTextColor(paramInt);
    this.d.setCurrentTextColor(paramInt);
    this.f.setCurrentTextColor(paramInt);
  }
  
  public void setData(List<String> paramList)
  {
    throw new RuntimeException("Set data will not allow here!");
  }
  
  public void setItemCount(int paramInt)
  {
    this.c.setItemCount(paramInt);
    this.d.setItemCount(paramInt);
    this.f.setItemCount(paramInt);
  }
  
  public void setItemIndex(int paramInt)
  {
    this.c.setItemIndex(paramInt);
    this.d.setItemIndex(paramInt);
    this.f.setItemIndex(paramInt);
  }
  
  public void setItemSpace(int paramInt)
  {
    this.c.setItemSpace(paramInt);
    this.d.setItemSpace(paramInt);
    this.f.setItemSpace(paramInt);
  }
  
  public void setLabelColor(int paramInt)
  {
    this.p0 = paramInt;
    invalidate();
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    this.H3 = paramFloat;
    invalidate();
  }
  
  public void setOnWheelChangeListener(AbstractWheelPicker.a parama)
  {
    this.q = parama;
  }
  
  public void setTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
    this.d.setTextColor(paramInt);
    this.f.setTextColor(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.c.setTextSize(paramInt);
    this.d.setTextSize(paramInt);
    this.f.setTextSize(paramInt);
  }
  
  class a
    extends a
  {
    a(String paramString) {}
    
    public void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
    {
      paramPaint.setColor(WheelDatePicker.this.p0);
      paramPaint.setTextAlign(Paint.Align.CENTER);
      paramPaint.setTextSize(WheelDatePicker.this.H3 * 1.5F);
      paramCanvas.drawText(paramString, paramRect2.centerX(), paramRect2.centerY() - (paramPaint.ascent() + paramPaint.descent()) / 2.0F, paramPaint);
    }
  }
  
  class b
    implements AbstractWheelPicker.a
  {
    b(int paramInt) {}
    
    public void a(int paramInt)
    {
      int i = paramInt;
      if (i == 0) {
        WheelDatePicker.this.p1 = paramInt;
      }
      if (i == 1) {
        WheelDatePicker.this.p2 = paramInt;
      }
      if (i == 2) {
        WheelDatePicker.this.p3 = paramInt;
      }
      WheelDatePicker localWheelDatePicker = WheelDatePicker.this;
      AbstractWheelPicker.a locala = localWheelDatePicker.q;
      if (locala != null) {
        WheelDatePicker.b(localWheelDatePicker, locala);
      }
    }
    
    public void b(float paramFloat1, float paramFloat2)
    {
      AbstractWheelPicker.a locala = WheelDatePicker.this.q;
      if (locala != null) {
        locala.b(paramFloat1, paramFloat2);
      }
    }
    
    public void c(int paramInt, String paramString)
    {
      paramInt = paramInt;
      if (paramInt == 0) {
        WheelDatePicker.this.x = paramString;
      }
      if (paramInt == 1) {
        WheelDatePicker.this.y = paramString;
      }
      if (paramInt == 2) {
        WheelDatePicker.this.z = paramString;
      }
      if (WheelDatePicker.a(WheelDatePicker.this))
      {
        paramInt = paramInt;
        if ((paramInt == 0) || (paramInt == 1))
        {
          paramString = WheelDatePicker.this;
          paramString.f.A(Integer.parseInt(paramString.x), Integer.parseInt(WheelDatePicker.this.y));
        }
        paramString = WheelDatePicker.this.q;
        if (paramString != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(WheelDatePicker.this.x);
          localStringBuilder.append("-");
          localStringBuilder.append(WheelDatePicker.this.y);
          localStringBuilder.append("-");
          localStringBuilder.append(WheelDatePicker.this.z);
          paramString.c(-1, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\widget\curved\WheelDatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */