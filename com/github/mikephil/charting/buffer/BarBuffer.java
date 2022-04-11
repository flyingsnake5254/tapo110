package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

public class BarBuffer
  extends AbstractBuffer<IBarDataSet>
{
  protected float mBarWidth = 1.0F;
  protected boolean mContainsStacks = false;
  protected int mDataSetCount = 1;
  protected int mDataSetIndex = 0;
  protected boolean mInverted = false;
  
  public BarBuffer(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1);
    this.mDataSetCount = paramInt2;
    this.mContainsStacks = paramBoolean;
  }
  
  protected void addBar(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.buffer;
    int i = this.index;
    int j = i + 1;
    this.index = j;
    arrayOfFloat[i] = paramFloat1;
    i = j + 1;
    this.index = i;
    arrayOfFloat[j] = paramFloat2;
    j = i + 1;
    this.index = j;
    arrayOfFloat[i] = paramFloat3;
    this.index = (j + 1);
    arrayOfFloat[j] = paramFloat4;
  }
  
  public void feed(IBarDataSet paramIBarDataSet)
  {
    float f1 = paramIBarDataSet.getEntryCount();
    float f2 = this.phaseX;
    float f3 = this.mBarWidth / 2.0F;
    for (int i = 0; i < f1 * f2; i++)
    {
      BarEntry localBarEntry = (BarEntry)paramIBarDataSet.getEntryForIndex(i);
      if (localBarEntry != null)
      {
        float f4 = localBarEntry.getX();
        float f5 = localBarEntry.getY();
        float[] arrayOfFloat = localBarEntry.getYVals();
        int j;
        float f6;
        if ((this.mContainsStacks) && (arrayOfFloat != null))
        {
          f5 = -localBarEntry.getNegativeSum();
          j = 0;
          f6 = 0.0F;
        }
        while (j < arrayOfFloat.length)
        {
          float f7 = arrayOfFloat[j];
          boolean bool = f7 < 0.0F;
          float f9;
          if ((!bool) && ((f6 == 0.0F) || (f5 == 0.0F)))
          {
            f8 = f7;
            f7 = f5;
            f5 = f8;
            f9 = f6;
          }
          else if (!bool)
          {
            f8 = f7 + f6;
            f7 = f5;
            f5 = f6;
            f9 = f8;
          }
          else
          {
            f8 = Math.abs(f7) + f5;
            f7 = Math.abs(f7) + f5;
            f9 = f6;
          }
          if (this.mInverted)
          {
            if (f5 >= f8) {
              f6 = f5;
            } else {
              f6 = f8;
            }
            if (f5 > f8) {
              f5 = f8;
            }
          }
          else
          {
            if (f5 >= f8) {
              f6 = f5;
            } else {
              f6 = f8;
            }
            if (f5 > f8) {
              f5 = f8;
            }
            f8 = f5;
            f5 = f6;
            f6 = f8;
          }
          float f8 = this.phaseY;
          addBar(f4 - f3, f5 * f8, f4 + f3, f6 * f8);
          j++;
          f5 = f7;
          f6 = f9;
          continue;
          if (this.mInverted)
          {
            if (f5 >= 0.0F) {
              f8 = f5;
            } else {
              f8 = 0.0F;
            }
            if (f5 > 0.0F) {
              f5 = 0.0F;
            }
          }
          else
          {
            if (f5 >= 0.0F) {
              f8 = f5;
            } else {
              f8 = 0.0F;
            }
            if (f5 > 0.0F) {
              f5 = 0.0F;
            }
            f7 = f8;
            f8 = f5;
            f5 = f7;
          }
          if (f5 > 0.0F) {
            f5 *= this.phaseY;
          } else {
            f8 *= this.phaseY;
          }
          addBar(f4 - f3, f5, f4 + f3, f8);
        }
      }
    }
    reset();
  }
  
  public void setBarWidth(float paramFloat)
  {
    this.mBarWidth = paramFloat;
  }
  
  public void setDataSet(int paramInt)
  {
    this.mDataSetIndex = paramInt;
  }
  
  public void setInverted(boolean paramBoolean)
  {
    this.mInverted = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\buffer\BarBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */