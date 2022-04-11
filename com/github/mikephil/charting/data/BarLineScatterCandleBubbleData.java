package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

public abstract class BarLineScatterCandleBubbleData<T extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>
  extends ChartData<T>
{
  public BarLineScatterCandleBubbleData() {}
  
  public BarLineScatterCandleBubbleData(List<T> paramList)
  {
    super(paramList);
  }
  
  public BarLineScatterCandleBubbleData(T... paramVarArgs)
  {
    super(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BarLineScatterCandleBubbleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */