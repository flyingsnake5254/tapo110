package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

@SuppressLint({"ParcelCreator"})
public class BarEntry
  extends Entry
{
  private float mNegativeSum;
  private float mPositiveSum;
  private Range[] mRanges;
  private float[] mYVals;
  
  public BarEntry(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }
  
  public BarEntry(float paramFloat1, float paramFloat2, Drawable paramDrawable)
  {
    super(paramFloat1, paramFloat2, paramDrawable);
  }
  
  public BarEntry(float paramFloat1, float paramFloat2, Drawable paramDrawable, Object paramObject)
  {
    super(paramFloat1, paramFloat2, paramDrawable, paramObject);
  }
  
  public BarEntry(float paramFloat1, float paramFloat2, Object paramObject)
  {
    super(paramFloat1, paramFloat2, paramObject);
  }
  
  public BarEntry(float paramFloat, float[] paramArrayOfFloat)
  {
    super(paramFloat, calcSum(paramArrayOfFloat));
    this.mYVals = paramArrayOfFloat;
    calcPosNegSum();
    calcRanges();
  }
  
  public BarEntry(float paramFloat, float[] paramArrayOfFloat, Drawable paramDrawable)
  {
    super(paramFloat, calcSum(paramArrayOfFloat), paramDrawable);
    this.mYVals = paramArrayOfFloat;
    calcPosNegSum();
    calcRanges();
  }
  
  public BarEntry(float paramFloat, float[] paramArrayOfFloat, Drawable paramDrawable, Object paramObject)
  {
    super(paramFloat, calcSum(paramArrayOfFloat), paramDrawable, paramObject);
    this.mYVals = paramArrayOfFloat;
    calcPosNegSum();
    calcRanges();
  }
  
  public BarEntry(float paramFloat, float[] paramArrayOfFloat, Object paramObject)
  {
    super(paramFloat, calcSum(paramArrayOfFloat), paramObject);
    this.mYVals = paramArrayOfFloat;
    calcPosNegSum();
    calcRanges();
  }
  
  private void calcPosNegSum()
  {
    float[] arrayOfFloat = this.mYVals;
    if (arrayOfFloat == null)
    {
      this.mNegativeSum = 0.0F;
      this.mPositiveSum = 0.0F;
      return;
    }
    int i = arrayOfFloat.length;
    int j = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (j < i)
    {
      float f3 = arrayOfFloat[j];
      if (f3 <= 0.0F) {
        f1 += Math.abs(f3);
      } else {
        f2 += f3;
      }
      j++;
    }
    this.mNegativeSum = f1;
    this.mPositiveSum = f2;
  }
  
  private static float calcSum(float[] paramArrayOfFloat)
  {
    float f = 0.0F;
    if (paramArrayOfFloat == null) {
      return 0.0F;
    }
    int i = paramArrayOfFloat.length;
    for (int j = 0; j < i; j++) {
      f += paramArrayOfFloat[j];
    }
    return f;
  }
  
  protected void calcRanges()
  {
    float[] arrayOfFloat = getYVals();
    if ((arrayOfFloat != null) && (arrayOfFloat.length != 0))
    {
      this.mRanges = new Range[arrayOfFloat.length];
      float f1 = -getNegativeSum();
      int i = 0;
      float f2 = 0.0F;
      for (;;)
      {
        Range[] arrayOfRange = this.mRanges;
        if (i >= arrayOfRange.length) {
          break;
        }
        float f3 = arrayOfFloat[i];
        if (f3 < 0.0F)
        {
          f3 = f1 - f3;
          arrayOfRange[i] = new Range(f1, f3);
          f1 = f3;
        }
        else
        {
          f3 += f2;
          arrayOfRange[i] = new Range(f2, f3);
          f2 = f3;
        }
        i++;
      }
    }
  }
  
  public BarEntry copy()
  {
    BarEntry localBarEntry = new BarEntry(getX(), getY(), getData());
    localBarEntry.setVals(this.mYVals);
    return localBarEntry;
  }
  
  @Deprecated
  public float getBelowSum(int paramInt)
  {
    return getSumBelow(paramInt);
  }
  
  public float getNegativeSum()
  {
    return this.mNegativeSum;
  }
  
  public float getPositiveSum()
  {
    return this.mPositiveSum;
  }
  
  public Range[] getRanges()
  {
    return this.mRanges;
  }
  
  public float getSumBelow(int paramInt)
  {
    float[] arrayOfFloat = this.mYVals;
    float f = 0.0F;
    if (arrayOfFloat == null) {
      return 0.0F;
    }
    for (int i = arrayOfFloat.length - 1; (i > paramInt) && (i >= 0); i--) {
      f += this.mYVals[i];
    }
    return f;
  }
  
  public float getY()
  {
    return super.getY();
  }
  
  public float[] getYVals()
  {
    return this.mYVals;
  }
  
  public boolean isStacked()
  {
    boolean bool;
    if (this.mYVals != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setVals(float[] paramArrayOfFloat)
  {
    setY(calcSum(paramArrayOfFloat));
    this.mYVals = paramArrayOfFloat;
    calcPosNegSum();
    calcRanges();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BarEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */