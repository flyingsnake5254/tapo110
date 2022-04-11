package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.Iterator;
import java.util.List;

public class BarData
  extends BarLineScatterCandleBubbleData<IBarDataSet>
{
  private float mBarWidth = 0.85F;
  
  public BarData() {}
  
  public BarData(List<IBarDataSet> paramList)
  {
    super(paramList);
  }
  
  public BarData(IBarDataSet... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public float getBarWidth()
  {
    return this.mBarWidth;
  }
  
  public float getGroupWidth(float paramFloat1, float paramFloat2)
  {
    return this.mDataSets.size() * (this.mBarWidth + paramFloat2) + paramFloat1;
  }
  
  public void groupBars(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mDataSets.size() > 1)
    {
      int i = ((IBarDataSet)getMaxEntryCountSet()).getEntryCount();
      float f1 = paramFloat2 / 2.0F;
      float f2 = paramFloat3 / 2.0F;
      float f3 = this.mBarWidth / 2.0F;
      paramFloat3 = getGroupWidth(paramFloat2, paramFloat3);
      for (int j = 0; j < i; j++)
      {
        paramFloat2 = paramFloat1 + f1;
        Iterator localIterator = this.mDataSets.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (IBarDataSet)localIterator.next();
          paramFloat2 = paramFloat2 + f2 + f3;
          if (j < ((IDataSet)localObject).getEntryCount())
          {
            localObject = (BarEntry)((IDataSet)localObject).getEntryForIndex(j);
            if (localObject != null) {
              ((Entry)localObject).setX(paramFloat2);
            }
          }
          paramFloat2 = paramFloat2 + f3 + f2;
        }
        paramFloat2 += f1;
        float f4 = paramFloat3 - (paramFloat2 - paramFloat1);
        if (f4 <= 0.0F)
        {
          paramFloat1 = paramFloat2;
          if (f4 >= 0.0F) {}
        }
        else
        {
          paramFloat1 = paramFloat2 + f4;
        }
      }
      notifyDataChanged();
      return;
    }
    throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
  }
  
  public void setBarWidth(float paramFloat)
  {
    this.mBarWidth = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BarData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */