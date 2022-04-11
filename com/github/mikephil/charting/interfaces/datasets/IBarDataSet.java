package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.BarEntry;

public abstract interface IBarDataSet
  extends IBarLineScatterCandleBubbleDataSet<BarEntry>
{
  public abstract int getBarBorderColor();
  
  public abstract float getBarBorderWidth();
  
  public abstract int getBarShadowColor();
  
  public abstract int getHighLightAlpha();
  
  public abstract String[] getStackLabels();
  
  public abstract int getStackSize();
  
  public abstract boolean isStacked();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\datasets\IBarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */