package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;

public abstract interface ILineScatterCandleRadarDataSet<T extends Entry>
  extends IBarLineScatterCandleBubbleDataSet<T>
{
  public abstract DashPathEffect getDashPathEffectHighlight();
  
  public abstract float getHighlightLineWidth();
  
  public abstract boolean isHorizontalHighlightIndicatorEnabled();
  
  public abstract boolean isVerticalHighlightIndicatorEnabled();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\datasets\ILineScatterCandleRadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */