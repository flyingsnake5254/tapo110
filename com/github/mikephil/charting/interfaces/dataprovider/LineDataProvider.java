package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.LineData;

public abstract interface LineDataProvider
  extends BarLineScatterCandleBubbleDataProvider
{
  public abstract YAxis getAxis(YAxis.AxisDependency paramAxisDependency);
  
  public abstract LineData getLineData();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\dataprovider\LineDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */