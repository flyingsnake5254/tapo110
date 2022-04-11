package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.Iterator;
import java.util.List;

public class CombinedHighlighter
  extends ChartHighlighter<CombinedDataProvider>
  implements IHighlighter
{
  protected BarHighlighter barHighlighter;
  
  public CombinedHighlighter(CombinedDataProvider paramCombinedDataProvider, BarDataProvider paramBarDataProvider)
  {
    super(paramCombinedDataProvider);
    if (paramBarDataProvider.getBarData() == null) {
      paramCombinedDataProvider = null;
    } else {
      paramCombinedDataProvider = new BarHighlighter(paramBarDataProvider);
    }
    this.barHighlighter = paramCombinedDataProvider;
  }
  
  protected List<Highlight> getHighlightsAtXValue(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mHighlightBuffer.clear();
    List localList = ((CombinedDataProvider)this.mChart).getCombinedData().getAllData();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject1 = (ChartData)localList.get(i);
      Object localObject2 = this.barHighlighter;
      if ((localObject2 != null) && ((localObject1 instanceof BarData)))
      {
        localObject2 = ((BarHighlighter)localObject2).getHighlight(paramFloat2, paramFloat3);
        if (localObject2 != null)
        {
          ((Highlight)localObject2).setDataIndex(i);
          this.mHighlightBuffer.add(localObject2);
        }
      }
      else
      {
        int j = ((ChartData)localObject1).getDataSetCount();
        for (int k = 0; k < j; k++)
        {
          localObject2 = ((BarLineScatterCandleBubbleData)localList.get(i)).getDataSetByIndex(k);
          if (((IDataSet)localObject2).isHighlightEnabled())
          {
            localObject2 = buildHighlights((IDataSet)localObject2, k, paramFloat1, DataSet.Rounding.CLOSEST).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject1 = (Highlight)((Iterator)localObject2).next();
              ((Highlight)localObject1).setDataIndex(i);
              this.mHighlightBuffer.add(localObject1);
            }
          }
        }
      }
    }
    return this.mHighlightBuffer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\CombinedHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */