package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

public class PercentFormatter
  extends ValueFormatter
{
  public DecimalFormat mFormat = new DecimalFormat("###,###,##0.0");
  private PieChart pieChart;
  
  public PercentFormatter() {}
  
  public PercentFormatter(PieChart paramPieChart)
  {
    this();
    this.pieChart = paramPieChart;
  }
  
  public String getFormattedValue(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mFormat.format(paramFloat));
    localStringBuilder.append(" %");
    return localStringBuilder.toString();
  }
  
  public String getPieLabel(float paramFloat, PieEntry paramPieEntry)
  {
    paramPieEntry = this.pieChart;
    if ((paramPieEntry != null) && (paramPieEntry.isUsePercentValuesEnabled())) {
      return getFormattedValue(paramFloat);
    }
    return this.mFormat.format(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\PercentFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */