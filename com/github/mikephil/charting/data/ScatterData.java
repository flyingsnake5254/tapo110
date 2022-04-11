package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.Iterator;
import java.util.List;

public class ScatterData
  extends BarLineScatterCandleBubbleData<IScatterDataSet>
{
  public ScatterData() {}
  
  public ScatterData(List<IScatterDataSet> paramList)
  {
    super(paramList);
  }
  
  public ScatterData(IScatterDataSet... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public float getGreatestShapeSize()
  {
    Iterator localIterator = this.mDataSets.iterator();
    float f1 = 0.0F;
    while (localIterator.hasNext())
    {
      float f2 = ((IScatterDataSet)localIterator.next()).getScatterShapeSize();
      if (f2 > f1) {
        f1 = f2;
      }
    }
    return f1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\ScatterData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */