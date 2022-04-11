package com.wdullaer.materialdatetimepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

public class VerticalTextView
  extends TextView
{
  final boolean c;
  
  public VerticalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getGravity();
    if ((Gravity.isVertical(i)) && ((i & 0x70) == 80))
    {
      setGravity(i & 0x7 | 0x30);
      this.c = false;
    }
    else
    {
      this.c = true;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.setColor(getCurrentTextColor());
    localTextPaint.drawableState = getDrawableState();
    paramCanvas.save();
    if (this.c)
    {
      paramCanvas.translate(getWidth(), 0.0F);
      paramCanvas.rotate(90.0F);
    }
    else
    {
      paramCanvas.translate(0.0F, getHeight());
      paramCanvas.rotate(-90.0F);
    }
    paramCanvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
    getLayout().draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt2, paramInt1);
    setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\VerticalTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */