package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarHighlighter<T extends PieRadarChartBase>
  implements IHighlighter
{
  protected T mChart;
  protected List<Highlight> mHighlightBuffer = new ArrayList();
  
  public PieRadarHighlighter(T paramT)
  {
    this.mChart = paramT;
  }
  
  protected abstract Highlight getClosestHighlight(int paramInt, float paramFloat1, float paramFloat2);
  
  public Highlight getHighlight(float paramFloat1, float paramFloat2)
  {
    if (this.mChart.distanceToCenter(paramFloat1, paramFloat2) > this.mChart.getRadius()) {
      return null;
    }
    float f1 = this.mChart.getAngleForPoint(paramFloat1, paramFloat2);
    PieRadarChartBase localPieRadarChartBase = this.mChart;
    float f2 = f1;
    if ((localPieRadarChartBase instanceof PieChart)) {
      f2 = f1 / localPieRadarChartBase.getAnimator().getPhaseY();
    }
    int i = this.mChart.getIndexForAngle(f2);
    if ((i >= 0) && (i < this.mChart.getData().getMaxEntryCountSet().getEntryCount())) {
      return getClosestHighlight(i, paramFloat1, paramFloat2);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\PieRadarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */