package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ValueFormatter
  implements IAxisValueFormatter, IValueFormatter
{
  public String getAxisLabel(float paramFloat, AxisBase paramAxisBase)
  {
    return getFormattedValue(paramFloat);
  }
  
  public String getBarLabel(BarEntry paramBarEntry)
  {
    return getFormattedValue(paramBarEntry.getY());
  }
  
  public String getBarStackedLabel(float paramFloat, BarEntry paramBarEntry)
  {
    return getFormattedValue(paramFloat);
  }
  
  public String getBubbleLabel(BubbleEntry paramBubbleEntry)
  {
    return getFormattedValue(paramBubbleEntry.getSize());
  }
  
  public String getCandleLabel(CandleEntry paramCandleEntry)
  {
    return getFormattedValue(paramCandleEntry.getHigh());
  }
  
  public String getFormattedValue(float paramFloat)
  {
    return String.valueOf(paramFloat);
  }
  
  @Deprecated
  public String getFormattedValue(float paramFloat, AxisBase paramAxisBase)
  {
    return getFormattedValue(paramFloat);
  }
  
  @Deprecated
  public String getFormattedValue(float paramFloat, Entry paramEntry, int paramInt, ViewPortHandler paramViewPortHandler)
  {
    return getFormattedValue(paramFloat);
  }
  
  public String getPieLabel(float paramFloat, PieEntry paramPieEntry)
  {
    return getFormattedValue(paramFloat);
  }
  
  public String getPointLabel(Entry paramEntry)
  {
    return getFormattedValue(paramEntry.getY());
  }
  
  public String getRadarLabel(RadarEntry paramRadarEntry)
  {
    return getFormattedValue(paramRadarEntry.getY());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\ValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */