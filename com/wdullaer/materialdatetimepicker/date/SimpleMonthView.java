package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SimpleMonthView
  extends MonthView
{
  public SimpleMonthView(Context paramContext, AttributeSet paramAttributeSet, a parama)
  {
    super(paramContext, paramAttributeSet, parama);
  }
  
  public void d(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    if (this.W3 == paramInt3) {
      paramCanvas.drawCircle(paramInt4, paramInt5 - MonthView.f / 3, MonthView.z, this.L3);
    }
    if ((m(paramInt1, paramInt2, paramInt3)) && (this.W3 != paramInt3))
    {
      paramCanvas.drawCircle(paramInt4, MonthView.f + paramInt5 - MonthView.p1, MonthView.p0, this.L3);
      this.J3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
    }
    else
    {
      this.J3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
    }
    if (this.p2.f(paramInt1, paramInt2, paramInt3))
    {
      this.J3.setColor(this.o4);
    }
    else if (this.W3 == paramInt3)
    {
      this.J3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
      this.J3.setColor(this.k4);
    }
    else if ((this.V3) && (this.X3 == paramInt3))
    {
      this.J3.setColor(this.m4);
    }
    else
    {
      Paint localPaint = this.J3;
      if (m(paramInt1, paramInt2, paramInt3)) {
        paramInt1 = this.n4;
      } else {
        paramInt1 = this.j4;
      }
      localPaint.setColor(paramInt1);
    }
    paramCanvas.drawText(String.format(this.p2.c(), "%d", new Object[] { Integer.valueOf(paramInt3) }), paramInt4, paramInt5, this.J3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\SimpleMonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */