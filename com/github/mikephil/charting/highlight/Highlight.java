package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis.AxisDependency;

public class Highlight
{
  private YAxis.AxisDependency axis;
  private int mDataIndex = -1;
  private int mDataSetIndex;
  private float mDrawX;
  private float mDrawY;
  private int mStackIndex = -1;
  private float mX = NaN.0F;
  private float mXPx;
  private float mY = NaN.0F;
  private float mYPx;
  
  public Highlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, YAxis.AxisDependency paramAxisDependency)
  {
    this(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramAxisDependency);
    this.mStackIndex = paramInt2;
  }
  
  public Highlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, YAxis.AxisDependency paramAxisDependency)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    this.mXPx = paramFloat3;
    this.mYPx = paramFloat4;
    this.mDataSetIndex = paramInt;
    this.axis = paramAxisDependency;
  }
  
  public Highlight(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    this.mDataSetIndex = paramInt;
  }
  
  public Highlight(float paramFloat, int paramInt1, int paramInt2)
  {
    this(paramFloat, NaN.0F, paramInt1);
    this.mStackIndex = paramInt2;
  }
  
  public boolean equalTo(Highlight paramHighlight)
  {
    if (paramHighlight == null) {
      return false;
    }
    return (this.mDataSetIndex == paramHighlight.mDataSetIndex) && (this.mX == paramHighlight.mX) && (this.mStackIndex == paramHighlight.mStackIndex) && (this.mDataIndex == paramHighlight.mDataIndex);
  }
  
  public YAxis.AxisDependency getAxis()
  {
    return this.axis;
  }
  
  public int getDataIndex()
  {
    return this.mDataIndex;
  }
  
  public int getDataSetIndex()
  {
    return this.mDataSetIndex;
  }
  
  public float getDrawX()
  {
    return this.mDrawX;
  }
  
  public float getDrawY()
  {
    return this.mDrawY;
  }
  
  public int getStackIndex()
  {
    return this.mStackIndex;
  }
  
  public float getX()
  {
    return this.mX;
  }
  
  public float getXPx()
  {
    return this.mXPx;
  }
  
  public float getY()
  {
    return this.mY;
  }
  
  public float getYPx()
  {
    return this.mYPx;
  }
  
  public boolean isStacked()
  {
    boolean bool;
    if (this.mStackIndex >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setDataIndex(int paramInt)
  {
    this.mDataIndex = paramInt;
  }
  
  public void setDraw(float paramFloat1, float paramFloat2)
  {
    this.mDrawX = paramFloat1;
    this.mDrawY = paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Highlight, x: ");
    localStringBuilder.append(this.mX);
    localStringBuilder.append(", y: ");
    localStringBuilder.append(this.mY);
    localStringBuilder.append(", dataSetIndex: ");
    localStringBuilder.append(this.mDataSetIndex);
    localStringBuilder.append(", stackIndex (only stacked barentry): ");
    localStringBuilder.append(this.mStackIndex);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\Highlight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */