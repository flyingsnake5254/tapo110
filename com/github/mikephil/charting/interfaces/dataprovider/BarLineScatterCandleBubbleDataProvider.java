package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.utils.Transformer;

public abstract interface BarLineScatterCandleBubbleDataProvider
  extends ChartInterface
{
  public abstract BarLineScatterCandleBubbleData getData();
  
  public abstract float getHighestVisibleX();
  
  public abstract float getLowestVisibleX();
  
  public abstract Transformer getTransformer(YAxis.AxisDependency paramAxisDependency);
  
  public abstract boolean isInverted(YAxis.AxisDependency paramAxisDependency);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\dataprovider\BarLineScatterCandleBubbleDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */