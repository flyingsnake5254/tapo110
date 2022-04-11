package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

public class HorizontalBarBuffer
  extends BarBuffer
{
  public HorizontalBarBuffer(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramBoolean);
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
          float f9;
          if (f7 >= 0.0F)
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
            f8 = f6;
            f6 = f5;
            f5 = f8;
          }
          float f8 = this.phaseY;
          addBar(f6 * f8, f4 + f3, f5 * f8, f4 - f3);
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
            f7 = f5;
            f5 = f8;
            f8 = f7;
          }
          if (f5 > 0.0F) {
            f5 *= this.phaseY;
          } else {
            f8 *= this.phaseY;
          }
          addBar(f8, f4 + f3, f5, f4 - f3);
        }
      }
    }
    reset();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\buffer\HorizontalBarBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */