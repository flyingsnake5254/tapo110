package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class BarLineScatterCandleBubbleRenderer
  extends DataRenderer
{
  protected XBounds mXBounds = new XBounds();
  
  public BarLineScatterCandleBubbleRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  protected boolean isInBoundsX(Entry paramEntry, IBarLineScatterCandleBubbleDataSet paramIBarLineScatterCandleBubbleDataSet)
  {
    if (paramEntry == null) {
      return false;
    }
    return paramIBarLineScatterCandleBubbleDataSet.getEntryIndex(paramEntry) < paramIBarLineScatterCandleBubbleDataSet.getEntryCount() * this.mAnimator.getPhaseX();
  }
  
  protected boolean shouldDrawValues(IDataSet paramIDataSet)
  {
    boolean bool;
    if ((paramIDataSet.isVisible()) && ((paramIDataSet.isDrawValuesEnabled()) || (paramIDataSet.isDrawIconsEnabled()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected class XBounds
  {
    public int max;
    public int min;
    public int range;
    
    protected XBounds() {}
    
    public void set(BarLineScatterCandleBubbleDataProvider paramBarLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet paramIBarLineScatterCandleBubbleDataSet)
    {
      float f1 = Math.max(0.0F, Math.min(1.0F, BarLineScatterCandleBubbleRenderer.this.mAnimator.getPhaseX()));
      float f2 = paramBarLineScatterCandleBubbleDataProvider.getLowestVisibleX();
      float f3 = paramBarLineScatterCandleBubbleDataProvider.getHighestVisibleX();
      paramBarLineScatterCandleBubbleDataProvider = paramIBarLineScatterCandleBubbleDataSet.getEntryForXValue(f2, NaN.0F, DataSet.Rounding.DOWN);
      Entry localEntry = paramIBarLineScatterCandleBubbleDataSet.getEntryForXValue(f3, NaN.0F, DataSet.Rounding.UP);
      int i = 0;
      int j;
      if (paramBarLineScatterCandleBubbleDataProvider == null) {
        j = 0;
      } else {
        j = paramIBarLineScatterCandleBubbleDataSet.getEntryIndex(paramBarLineScatterCandleBubbleDataProvider);
      }
      this.min = j;
      if (localEntry == null) {
        j = i;
      } else {
        j = paramIBarLineScatterCandleBubbleDataSet.getEntryIndex(localEntry);
      }
      this.max = j;
      this.range = ((int)((j - this.min) * f1));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\BarLineScatterCandleBubbleRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */