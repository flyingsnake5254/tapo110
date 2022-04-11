package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class DefaultFillFormatter
  implements IFillFormatter
{
  public float getFillLinePosition(ILineDataSet paramILineDataSet, LineDataProvider paramLineDataProvider)
  {
    float f1 = paramLineDataProvider.getYChartMax();
    float f2 = paramLineDataProvider.getYChartMin();
    paramLineDataProvider = paramLineDataProvider.getLineData();
    float f3 = paramILineDataSet.getYMax();
    float f4 = 0.0F;
    if ((f3 <= 0.0F) || (paramILineDataSet.getYMin() >= 0.0F))
    {
      f4 = f1;
      if (paramLineDataProvider.getYMax() > 0.0F) {
        f4 = 0.0F;
      }
      if (paramLineDataProvider.getYMin() < 0.0F) {
        f2 = 0.0F;
      }
      if (paramILineDataSet.getYMin() >= 0.0F) {
        f4 = f2;
      }
    }
    return f4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\DefaultFillFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */