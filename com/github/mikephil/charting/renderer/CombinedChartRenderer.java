package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinedChartRenderer
  extends DataRenderer
{
  protected WeakReference<Chart> mChart;
  protected List<Highlight> mHighlightBuffer = new ArrayList();
  protected List<DataRenderer> mRenderers = new ArrayList(5);
  
  public CombinedChartRenderer(CombinedChart paramCombinedChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = new WeakReference(paramCombinedChart);
    createRenderers();
  }
  
  public void createRenderers()
  {
    this.mRenderers.clear();
    CombinedChart localCombinedChart = (CombinedChart)this.mChart.get();
    if (localCombinedChart == null) {
      return;
    }
    for (CombinedChart.DrawOrder localDrawOrder : localCombinedChart.getDrawOrder())
    {
      int k = 1.$SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[localDrawOrder.ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if ((k == 5) && (localCombinedChart.getScatterData() != null)) {
                this.mRenderers.add(new ScatterChartRenderer(localCombinedChart, this.mAnimator, this.mViewPortHandler));
              }
            }
            else if (localCombinedChart.getCandleData() != null) {
              this.mRenderers.add(new CandleStickChartRenderer(localCombinedChart, this.mAnimator, this.mViewPortHandler));
            }
          }
          else if (localCombinedChart.getLineData() != null) {
            this.mRenderers.add(new LineChartRenderer(localCombinedChart, this.mAnimator, this.mViewPortHandler));
          }
        }
        else if (localCombinedChart.getBubbleData() != null) {
          this.mRenderers.add(new BubbleChartRenderer(localCombinedChart, this.mAnimator, this.mViewPortHandler));
        }
      }
      else if (localCombinedChart.getBarData() != null) {
        this.mRenderers.add(new BarChartRenderer(localCombinedChart, this.mAnimator, this.mViewPortHandler));
      }
    }
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Iterator localIterator = this.mRenderers.iterator();
    while (localIterator.hasNext()) {
      ((DataRenderer)localIterator.next()).drawData(paramCanvas);
    }
  }
  
  public void drawExtras(Canvas paramCanvas)
  {
    Iterator localIterator = this.mRenderers.iterator();
    while (localIterator.hasNext()) {
      ((DataRenderer)localIterator.next()).drawExtras(paramCanvas);
    }
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    Chart localChart = (Chart)this.mChart.get();
    if (localChart == null) {
      return;
    }
    Iterator localIterator = this.mRenderers.iterator();
    while (localIterator.hasNext())
    {
      DataRenderer localDataRenderer = (DataRenderer)localIterator.next();
      Object localObject = null;
      if ((localDataRenderer instanceof BarChartRenderer)) {
        localObject = ((BarChartRenderer)localDataRenderer).mChart.getBarData();
      } else if ((localDataRenderer instanceof LineChartRenderer)) {
        localObject = ((LineChartRenderer)localDataRenderer).mChart.getLineData();
      } else if ((localDataRenderer instanceof CandleStickChartRenderer)) {
        localObject = ((CandleStickChartRenderer)localDataRenderer).mChart.getCandleData();
      } else if ((localDataRenderer instanceof ScatterChartRenderer)) {
        localObject = ((ScatterChartRenderer)localDataRenderer).mChart.getScatterData();
      } else if ((localDataRenderer instanceof BubbleChartRenderer)) {
        localObject = ((BubbleChartRenderer)localDataRenderer).mChart.getBubbleData();
      }
      int i;
      if (localObject == null) {
        i = -1;
      } else {
        i = ((CombinedData)localChart.getData()).getAllData().indexOf(localObject);
      }
      this.mHighlightBuffer.clear();
      int j = paramArrayOfHighlight.length;
      for (int k = 0; k < j; k++)
      {
        localObject = paramArrayOfHighlight[k];
        if ((((Highlight)localObject).getDataIndex() == i) || (((Highlight)localObject).getDataIndex() == -1)) {
          this.mHighlightBuffer.add(localObject);
        }
      }
      localObject = this.mHighlightBuffer;
      localDataRenderer.drawHighlighted(paramCanvas, (Highlight[])((List)localObject).toArray(new Highlight[((List)localObject).size()]));
    }
  }
  
  public void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    Log.e("MPAndroidChart", "Erroneous call to drawValue() in CombinedChartRenderer!");
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    Iterator localIterator = this.mRenderers.iterator();
    while (localIterator.hasNext()) {
      ((DataRenderer)localIterator.next()).drawValues(paramCanvas);
    }
  }
  
  public DataRenderer getSubRenderer(int paramInt)
  {
    if ((paramInt < this.mRenderers.size()) && (paramInt >= 0)) {
      return (DataRenderer)this.mRenderers.get(paramInt);
    }
    return null;
  }
  
  public List<DataRenderer> getSubRenderers()
  {
    return this.mRenderers;
  }
  
  public void initBuffers()
  {
    Iterator localIterator = this.mRenderers.iterator();
    while (localIterator.hasNext()) {
      ((DataRenderer)localIterator.next()).initBuffers();
    }
  }
  
  public void setSubRenderers(List<DataRenderer> paramList)
  {
    this.mRenderers = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\CombinedChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */