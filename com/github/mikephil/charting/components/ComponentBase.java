package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

public abstract class ComponentBase
{
  protected boolean mEnabled = true;
  protected int mTextColor = -16777216;
  protected float mTextSize = Utils.convertDpToPixel(10.0F);
  protected Typeface mTypeface = null;
  protected float mXOffset = 5.0F;
  protected float mYOffset = 5.0F;
  
  public int getTextColor()
  {
    return this.mTextColor;
  }
  
  public float getTextSize()
  {
    return this.mTextSize;
  }
  
  public Typeface getTypeface()
  {
    return this.mTypeface;
  }
  
  public float getXOffset()
  {
    return this.mXOffset;
  }
  
  public float getYOffset()
  {
    return this.mYOffset;
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 24.0F) {
      f = 24.0F;
    }
    paramFloat = f;
    if (f < 6.0F) {
      paramFloat = 6.0F;
    }
    this.mTextSize = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.mTypeface = paramTypeface;
  }
  
  public void setXOffset(float paramFloat)
  {
    this.mXOffset = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setYOffset(float paramFloat)
  {
    this.mYOffset = Utils.convertDpToPixel(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\ComponentBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */