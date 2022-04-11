package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.BubbleEntry;

public abstract interface IBubbleDataSet
  extends IBarLineScatterCandleBubbleDataSet<BubbleEntry>
{
  public abstract float getHighlightCircleWidth();
  
  public abstract float getMaxSize();
  
  public abstract boolean isNormalizeSizeEnabled();
  
  public abstract void setHighlightCircleWidth(float paramFloat);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\datasets\IBubbleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */