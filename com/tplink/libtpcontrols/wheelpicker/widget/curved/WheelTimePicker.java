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

public class WheelTimePicker
  extends LinearLayout
{
  protected WheelHourPicker c;
  protected WheelMinutePicker d;
  protected AbstractWheelPicker.a f;
  protected int p0;
  protected float p1;
  protected String q;
  protected String x;
  protected int y = -16777216;
  protected int z;
  
  public WheelTimePicker(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public WheelTimePicker(Context paramContext, AttributeSet paramAttributeSet)
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
    if ((this.z == 0) && (this.p0 == 0)) {
      parama.a(0);
    }
    if ((this.z == 2) || (this.p0 == 2)) {
      parama.a(2);
    }
    if (this.z + this.p0 == 1) {
      parama.a(1);
    }
  }
  
  private void e()
  {
    setGravity(17);
    setOrientation(0);
    int i = getResources().getDimensionPixelSize(q0.WheelPadding);
    int j = i * 2;
    this.p1 = i;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    this.c = new WheelHourPicker(getContext());
    this.d = new WheelMinutePicker(getContext());
    this.c.setPadding(0, i, j, i);
    this.d.setPadding(0, i, j, i);
    c(this.c, "时");
    c(this.d, "分");
    addView(this.c, localLayoutParams);
    addView(this.d, localLayoutParams);
    f(this.c, 0);
    f(this.d, 1);
  }
  
  private void f(WheelCrossPicker paramWheelCrossPicker, final int paramInt)
  {
    paramWheelCrossPicker.setOnWheelChangeListener(new b(paramInt));
  }
  
  private boolean g()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.q)) && (!TextUtils.isEmpty(this.x))) {
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
  }
  
  public void setData(List<String> paramList)
  {
    throw new RuntimeException("Set data will not allow here!");
  }
  
  public void setDigitType(int paramInt)
  {
    this.c.setDigitType(paramInt);
    this.d.setDigitType(paramInt);
  }
  
  public void setItemCount(int paramInt)
  {
    this.c.setItemCount(paramInt);
    this.d.setItemCount(paramInt);
  }
  
  public void setItemIndex(int paramInt)
  {
    this.c.setItemIndex(paramInt);
    this.d.setItemIndex(paramInt);
  }
  
  public void setItemSpace(int paramInt)
  {
    this.c.setItemSpace(paramInt);
    this.d.setItemSpace(paramInt);
  }
  
  public void setLabelColor(int paramInt)
  {
    this.y = paramInt;
    invalidate();
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    this.p1 = paramFloat;
    invalidate();
  }
  
  public void setOnWheelChangeListener(AbstractWheelPicker.a parama)
  {
    this.f = parama;
  }
  
  public void setTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
    this.d.setTextColor(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.c.setTextSize(paramInt);
    this.d.setTextSize(paramInt);
  }
  
  class a
    extends a
  {
    a(String paramString) {}
    
    public void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
    {
      paramPaint.setColor(WheelTimePicker.this.y);
      paramPaint.setTextAlign(Paint.Align.CENTER);
      paramPaint.setTextSize(WheelTimePicker.this.p1 * 1.5F);
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
        WheelTimePicker.this.z = paramInt;
      }
      if (i == 1) {
        WheelTimePicker.this.p0 = paramInt;
      }
      WheelTimePicker localWheelTimePicker = WheelTimePicker.this;
      AbstractWheelPicker.a locala = localWheelTimePicker.f;
      if (locala != null) {
        WheelTimePicker.b(localWheelTimePicker, locala);
      }
    }
    
    public void b(float paramFloat1, float paramFloat2)
    {
      AbstractWheelPicker.a locala = WheelTimePicker.this.f;
      if (locala != null) {
        locala.b(paramFloat1, paramFloat2);
      }
    }
    
    public void c(int paramInt, String paramString)
    {
      paramInt = paramInt;
      if (paramInt == 0) {
        WheelTimePicker.this.q = paramString;
      }
      if (paramInt == 1) {
        WheelTimePicker.this.x = paramString;
      }
      if (WheelTimePicker.a(WheelTimePicker.this))
      {
        paramString = WheelTimePicker.this.f;
        if (paramString != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(WheelTimePicker.this.q);
          localStringBuilder.append(":");
          localStringBuilder.append(WheelTimePicker.this.x);
          paramString.c(-1, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\widget\curved\WheelTimePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */