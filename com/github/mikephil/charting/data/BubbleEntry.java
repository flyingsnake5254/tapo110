package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
public class BubbleEntry
  extends Entry
{
  private float mSize = 0.0F;
  
  public BubbleEntry(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramFloat1, paramFloat2);
    this.mSize = paramFloat3;
  }
  
  public BubbleEntry(float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    super(paramFloat1, paramFloat2, paramDrawable);
    this.mSize = paramFloat3;
  }
  
  public BubbleEntry(float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable, Object paramObject)
  {
    super(paramFloat1, paramFloat2, paramDrawable, paramObject);
    this.mSize = paramFloat3;
  }
  
  public BubbleEntry(float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    super(paramFloat1, paramFloat2, paramObject);
    this.mSize = paramFloat3;
  }
  
  public BubbleEntry copy()
  {
    return new BubbleEntry(getX(), getY(), this.mSize, getData());
  }
  
  public float getSize()
  {
    return this.mSize;
  }
  
  public void setSize(float paramFloat)
  {
    this.mSize = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BubbleEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */