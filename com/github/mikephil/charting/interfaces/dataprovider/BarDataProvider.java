package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.data.BarData;

public abstract interface BarDataProvider
  extends BarLineScatterCandleBubbleDataProvider
{
  public abstract BarData getBarData();
  
  public abstract boolean isDrawBarShadowEnabled();
  
  public abstract boolean isDrawValueAboveBarEnabled();
  
  public abstract boolean isHighlightFullBarEnabled();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\dataprovider\BarDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */