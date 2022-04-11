package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;

public class BarHighlighter
  extends ChartHighlighter<BarDataProvider>
{
  public BarHighlighter(BarDataProvider paramBarDataProvider)
  {
    super(paramBarDataProvider);
  }
  
  protected int getClosestStackIndex(Range[] paramArrayOfRange, float paramFloat)
  {
    int i = 0;
    int j = i;
    if (paramArrayOfRange != null) {
      if (paramArrayOfRange.length == 0)
      {
        j = i;
      }
      else
      {
        int k = paramArrayOfRange.length;
        int m = 0;
        j = 0;
        while (m < k)
        {
          if (paramArrayOfRange[m].contains(paramFloat)) {
            return j;
          }
          j++;
          m++;
        }
        m = Math.max(paramArrayOfRange.length - 1, 0);
        j = i;
        if (paramFloat > paramArrayOfRange[m].to) {
          j = m;
        }
      }
    }
    return j;
  }
  
  protected BarLineScatterCandleBubbleData getData()
  {
    return ((BarDataProvider)this.mChart).getBarData();
  }
  
  protected float getDistance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.abs(paramFloat1 - paramFloat3);
  }
  
  public Highlight getHighlight(float paramFloat1, float paramFloat2)
  {
    Highlight localHighlight = super.getHighlight(paramFloat1, paramFloat2);
    if (localHighlight == null) {
      return null;
    }
    MPPointD localMPPointD = getValsForTouch(paramFloat1, paramFloat2);
    IBarDataSet localIBarDataSet = (IBarDataSet)((BarDataProvider)this.mChart).getBarData().getDataSetByIndex(localHighlight.getDataSetIndex());
    if (localIBarDataSet.isStacked()) {
      return getStackedHighlight(localHighlight, localIBarDataSet, (float)localMPPointD.x, (float)localMPPointD.y);
    }
    MPPointD.recycleInstance(localMPPointD);
    return localHighlight;
  }
  
  public Highlight getStackedHighlight(Highlight paramHighlight, IBarDataSet paramIBarDataSet, float paramFloat1, float paramFloat2)
  {
    BarEntry localBarEntry = (BarEntry)paramIBarDataSet.getEntryForXValue(paramFloat1, paramFloat2);
    if (localBarEntry == null) {
      return null;
    }
    if (localBarEntry.getYVals() == null) {
      return paramHighlight;
    }
    Range[] arrayOfRange = localBarEntry.getRanges();
    if (arrayOfRange.length > 0)
    {
      int i = getClosestStackIndex(arrayOfRange, paramFloat2);
      paramIBarDataSet = ((BarDataProvider)this.mChart).getTransformer(paramIBarDataSet.getAxisDependency()).getPixelForValues(paramHighlight.getX(), arrayOfRange[i].to);
      paramHighlight = new Highlight(localBarEntry.getX(), localBarEntry.getY(), (float)paramIBarDataSet.x, (float)paramIBarDataSet.y, paramHighlight.getDataSetIndex(), i, paramHighlight.getAxis());
      MPPointD.recycleInstance(paramIBarDataSet);
      return paramHighlight;
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\BarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */