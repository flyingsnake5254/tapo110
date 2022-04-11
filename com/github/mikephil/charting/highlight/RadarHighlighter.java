package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class RadarHighlighter
  extends PieRadarHighlighter<RadarChart>
{
  public RadarHighlighter(RadarChart paramRadarChart)
  {
    super(paramRadarChart);
  }
  
  protected Highlight getClosestHighlight(int paramInt, float paramFloat1, float paramFloat2)
  {
    List localList = getHighlightsAtIndex(paramInt);
    float f1 = ((RadarChart)this.mChart).distanceToCenter(paramFloat1, paramFloat2) / ((RadarChart)this.mChart).getFactor();
    Object localObject = null;
    paramFloat1 = Float.MAX_VALUE;
    paramInt = 0;
    while (paramInt < localList.size())
    {
      Highlight localHighlight = (Highlight)localList.get(paramInt);
      float f2 = Math.abs(localHighlight.getY() - f1);
      paramFloat2 = paramFloat1;
      if (f2 < paramFloat1)
      {
        localObject = localHighlight;
        paramFloat2 = f2;
      }
      paramInt++;
      paramFloat1 = paramFloat2;
    }
    return (Highlight)localObject;
  }
  
  protected List<Highlight> getHighlightsAtIndex(int paramInt)
  {
    this.mHighlightBuffer.clear();
    float f1 = ((RadarChart)this.mChart).getAnimator().getPhaseX();
    float f2 = ((RadarChart)this.mChart).getAnimator().getPhaseY();
    float f3 = ((RadarChart)this.mChart).getSliceAngle();
    float f4 = ((RadarChart)this.mChart).getFactor();
    MPPointF localMPPointF1 = MPPointF.getInstance(0.0F, 0.0F);
    for (int i = 0;; i++)
    {
      int j = paramInt;
      if (i >= ((RadarData)((RadarChart)this.mChart).getData()).getDataSetCount()) {
        break;
      }
      IDataSet localIDataSet = ((RadarData)((RadarChart)this.mChart).getData()).getDataSetByIndex(i);
      Entry localEntry = localIDataSet.getEntryForIndex(j);
      float f5 = localEntry.getY();
      float f6 = ((RadarChart)this.mChart).getYChartMin();
      MPPointF localMPPointF2 = ((RadarChart)this.mChart).getCenterOffsets();
      float f7 = j;
      Utils.getPosition(localMPPointF2, (f5 - f6) * f4 * f2, f3 * f7 * f1 + ((RadarChart)this.mChart).getRotationAngle(), localMPPointF1);
      this.mHighlightBuffer.add(new Highlight(f7, localEntry.getY(), localMPPointF1.x, localMPPointF1.y, i, localIDataSet.getAxisDependency()));
    }
    return this.mHighlightBuffer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\RadarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */