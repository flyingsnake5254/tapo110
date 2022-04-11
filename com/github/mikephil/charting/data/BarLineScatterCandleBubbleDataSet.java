package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry>
  extends DataSet<T>
  implements IBarLineScatterCandleBubbleDataSet<T>
{
  protected int mHighLightColor = Color.rgb(255, 187, 115);
  
  public BarLineScatterCandleBubbleDataSet(List<T> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  protected void copy(BarLineScatterCandleBubbleDataSet paramBarLineScatterCandleBubbleDataSet)
  {
    super.copy(paramBarLineScatterCandleBubbleDataSet);
    paramBarLineScatterCandleBubbleDataSet.mHighLightColor = this.mHighLightColor;
  }
  
  public int getHighLightColor()
  {
    return this.mHighLightColor;
  }
  
  public void setHighLightColor(int paramInt)
  {
    this.mHighLightColor = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BarLineScatterCandleBubbleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */