package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class BarDataSet
  extends BarLineScatterCandleBubbleDataSet<BarEntry>
  implements IBarDataSet
{
  private int mBarBorderColor = -16777216;
  private float mBarBorderWidth = 0.0F;
  private int mBarShadowColor = Color.rgb(215, 215, 215);
  private int mEntryCountStacks = 0;
  private int mHighLightAlpha = 120;
  private String[] mStackLabels = { "Stack" };
  private int mStackSize = 1;
  
  public BarDataSet(List<BarEntry> paramList, String paramString)
  {
    super(paramList, paramString);
    this.mHighLightColor = Color.rgb(0, 0, 0);
    calcStackSize(paramList);
    calcEntryCountIncludingStacks(paramList);
  }
  
  private void calcEntryCountIncludingStacks(List<BarEntry> paramList)
  {
    int i = 0;
    this.mEntryCountStacks = 0;
    while (i < paramList.size())
    {
      float[] arrayOfFloat = ((BarEntry)paramList.get(i)).getYVals();
      if (arrayOfFloat == null) {
        this.mEntryCountStacks += 1;
      } else {
        this.mEntryCountStacks += arrayOfFloat.length;
      }
      i++;
    }
  }
  
  private void calcStackSize(List<BarEntry> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      float[] arrayOfFloat = ((BarEntry)paramList.get(i)).getYVals();
      if ((arrayOfFloat != null) && (arrayOfFloat.length > this.mStackSize)) {
        this.mStackSize = arrayOfFloat.length;
      }
    }
  }
  
  protected void calcMinMax(BarEntry paramBarEntry)
  {
    if ((paramBarEntry != null) && (!Float.isNaN(paramBarEntry.getY())))
    {
      if (paramBarEntry.getYVals() == null)
      {
        if (paramBarEntry.getY() < this.mYMin) {
          this.mYMin = paramBarEntry.getY();
        }
        if (paramBarEntry.getY() > this.mYMax) {
          this.mYMax = paramBarEntry.getY();
        }
      }
      else
      {
        if (-paramBarEntry.getNegativeSum() < this.mYMin) {
          this.mYMin = (-paramBarEntry.getNegativeSum());
        }
        if (paramBarEntry.getPositiveSum() > this.mYMax) {
          this.mYMax = paramBarEntry.getPositiveSum();
        }
      }
      calcMinMaxX(paramBarEntry);
    }
  }
  
  public DataSet<BarEntry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((BarEntry)this.mValues.get(i)).copy());
    }
    localObject = new BarDataSet((List)localObject, getLabel());
    copy((BarDataSet)localObject);
    return (DataSet<BarEntry>)localObject;
  }
  
  protected void copy(BarDataSet paramBarDataSet)
  {
    super.copy(paramBarDataSet);
    paramBarDataSet.mStackSize = this.mStackSize;
    paramBarDataSet.mBarShadowColor = this.mBarShadowColor;
    paramBarDataSet.mBarBorderWidth = this.mBarBorderWidth;
    paramBarDataSet.mStackLabels = this.mStackLabels;
    paramBarDataSet.mHighLightAlpha = this.mHighLightAlpha;
  }
  
  public int getBarBorderColor()
  {
    return this.mBarBorderColor;
  }
  
  public float getBarBorderWidth()
  {
    return this.mBarBorderWidth;
  }
  
  public int getBarShadowColor()
  {
    return this.mBarShadowColor;
  }
  
  public int getEntryCountStacks()
  {
    return this.mEntryCountStacks;
  }
  
  public int getHighLightAlpha()
  {
    return this.mHighLightAlpha;
  }
  
  public String[] getStackLabels()
  {
    return this.mStackLabels;
  }
  
  public int getStackSize()
  {
    return this.mStackSize;
  }
  
  public boolean isStacked()
  {
    int i = this.mStackSize;
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    return bool;
  }
  
  public void setBarBorderColor(int paramInt)
  {
    this.mBarBorderColor = paramInt;
  }
  
  public void setBarBorderWidth(float paramFloat)
  {
    this.mBarBorderWidth = paramFloat;
  }
  
  public void setBarShadowColor(int paramInt)
  {
    this.mBarShadowColor = paramInt;
  }
  
  public void setHighLightAlpha(int paramInt)
  {
    this.mHighLightAlpha = paramInt;
  }
  
  public void setStackLabels(String[] paramArrayOfString)
  {
    this.mStackLabels = paramArrayOfString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */