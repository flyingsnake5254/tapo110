package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HorizontalBarHighlighter
  extends BarHighlighter
{
  public HorizontalBarHighlighter(BarDataProvider paramBarDataProvider)
  {
    super(paramBarDataProvider);
  }
  
  protected List<Highlight> buildHighlights(IDataSet paramIDataSet, int paramInt, float paramFloat, DataSet.Rounding paramRounding)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramIDataSet.getEntriesForXValue(paramFloat);
    Object localObject2 = localObject1;
    if (((List)localObject1).size() == 0)
    {
      paramRounding = paramIDataSet.getEntryForXValue(paramFloat, NaN.0F, paramRounding);
      localObject2 = localObject1;
      if (paramRounding != null) {
        localObject2 = paramIDataSet.getEntriesForXValue(paramRounding.getX());
      }
    }
    if (((List)localObject2).size() == 0) {
      return localArrayList;
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramRounding = (Entry)((Iterator)localObject2).next();
      localObject1 = ((BarDataProvider)this.mChart).getTransformer(paramIDataSet.getAxisDependency()).getPixelForValues(paramRounding.getY(), paramRounding.getX());
      localArrayList.add(new Highlight(paramRounding.getX(), paramRounding.getY(), (float)((MPPointD)localObject1).x, (float)((MPPointD)localObject1).y, paramInt, paramIDataSet.getAxisDependency()));
    }
    return localArrayList;
  }
  
  protected float getDistance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.abs(paramFloat2 - paramFloat4);
  }
  
  public Highlight getHighlight(float paramFloat1, float paramFloat2)
  {
    Object localObject = ((BarDataProvider)this.mChart).getBarData();
    MPPointD localMPPointD = getValsForTouch(paramFloat2, paramFloat1);
    Highlight localHighlight = getHighlightForX((float)localMPPointD.y, paramFloat2, paramFloat1);
    if (localHighlight == null) {
      return null;
    }
    localObject = (IBarDataSet)((ChartData)localObject).getDataSetByIndex(localHighlight.getDataSetIndex());
    if (((IBarDataSet)localObject).isStacked()) {
      return getStackedHighlight(localHighlight, (IBarDataSet)localObject, (float)localMPPointD.y, (float)localMPPointD.x);
    }
    MPPointD.recycleInstance(localMPPointD);
    return localHighlight;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\HorizontalBarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */