package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import java.util.List;

public class CandleData
  extends BarLineScatterCandleBubbleData<ICandleDataSet>
{
  public CandleData() {}
  
  public CandleData(List<ICandleDataSet> paramList)
  {
    super(paramList);
  }
  
  public CandleData(ICandleDataSet... paramVarArgs)
  {
    super(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\CandleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */