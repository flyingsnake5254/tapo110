package com.github.mikephil.charting.components;

import android.graphics.Paint.Align;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class Description
  extends ComponentBase
{
  private MPPointF mPosition;
  private Paint.Align mTextAlign = Paint.Align.RIGHT;
  private String text = "Description Label";
  
  public Description()
  {
    this.mTextSize = Utils.convertDpToPixel(8.0F);
  }
  
  public MPPointF getPosition()
  {
    return this.mPosition;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public Paint.Align getTextAlign()
  {
    return this.mTextAlign;
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = this.mPosition;
    if (localMPPointF == null)
    {
      this.mPosition = MPPointF.getInstance(paramFloat1, paramFloat2);
    }
    else
    {
      localMPPointF.x = paramFloat1;
      localMPPointF.y = paramFloat2;
    }
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setTextAlign(Paint.Align paramAlign)
  {
    this.mTextAlign = paramAlign;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\Description.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */