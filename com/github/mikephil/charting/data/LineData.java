package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.List;

public class LineData
  extends BarLineScatterCandleBubbleData<ILineDataSet>
{
  public LineData() {}
  
  public LineData(List<ILineDataSet> paramList)
  {
    super(paramList);
  }
  
  public LineData(ILineDataSet... paramVarArgs)
  {
    super(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\LineData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */