package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
public class CandleEntry
  extends Entry
{
  private float mClose = 0.0F;
  private float mOpen = 0.0F;
  private float mShadowHigh = 0.0F;
  private float mShadowLow = 0.0F;
  
  public CandleEntry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    super(paramFloat1, (paramFloat2 + paramFloat3) / 2.0F);
    this.mShadowHigh = paramFloat2;
    this.mShadowLow = paramFloat3;
    this.mOpen = paramFloat4;
    this.mClose = paramFloat5;
  }
  
  public CandleEntry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Drawable paramDrawable)
  {
    super(paramFloat1, (paramFloat2 + paramFloat3) / 2.0F, paramDrawable);
    this.mShadowHigh = paramFloat2;
    this.mShadowLow = paramFloat3;
    this.mOpen = paramFloat4;
    this.mClose = paramFloat5;
  }
  
  public CandleEntry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Drawable paramDrawable, Object paramObject)
  {
    super(paramFloat1, (paramFloat2 + paramFloat3) / 2.0F, paramDrawable, paramObject);
    this.mShadowHigh = paramFloat2;
    this.mShadowLow = paramFloat3;
    this.mOpen = paramFloat4;
    this.mClose = paramFloat5;
  }
  
  public CandleEntry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Object paramObject)
  {
    super(paramFloat1, (paramFloat2 + paramFloat3) / 2.0F, paramObject);
    this.mShadowHigh = paramFloat2;
    this.mShadowLow = paramFloat3;
    this.mOpen = paramFloat4;
    this.mClose = paramFloat5;
  }
  
  public CandleEntry copy()
  {
    return new CandleEntry(getX(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
  }
  
  public float getBodyRange()
  {
    return Math.abs(this.mOpen - this.mClose);
  }
  
  public float getClose()
  {
    return this.mClose;
  }
  
  public float getHigh()
  {
    return this.mShadowHigh;
  }
  
  public float getLow()
  {
    return this.mShadowLow;
  }
  
  public float getOpen()
  {
    return this.mOpen;
  }
  
  public float getShadowRange()
  {
    return Math.abs(this.mShadowHigh - this.mShadowLow);
  }
  
  public float getY()
  {
    return super.getY();
  }
  
  public void setClose(float paramFloat)
  {
    this.mClose = paramFloat;
  }
  
  public void setHigh(float paramFloat)
  {
    this.mShadowHigh = paramFloat;
  }
  
  public void setLow(float paramFloat)
  {
    this.mShadowLow = paramFloat;
  }
  
  public void setOpen(float paramFloat)
  {
    this.mOpen = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\CandleEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */