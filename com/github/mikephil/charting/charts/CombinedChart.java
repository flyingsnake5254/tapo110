package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class CombinedChart
  extends BarLineChartBase<CombinedData>
  implements CombinedDataProvider
{
  private boolean mDrawBarShadow = false;
  protected DrawOrder[] mDrawOrder;
  private boolean mDrawValueAboveBar = true;
  protected boolean mHighlightFullBarEnabled = false;
  
  public CombinedChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public CombinedChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CombinedChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawMarkers(Canvas paramCanvas)
  {
    if ((this.mMarker != null) && (isDrawMarkersEnabled()) && (valuesToHighlight())) {
      for (int i = 0;; i++)
      {
        Object localObject1 = this.mIndicesToHighlight;
        if (i >= localObject1.length) {
          break;
        }
        Highlight localHighlight = localObject1[i];
        Object localObject2 = ((CombinedData)this.mData).getDataSetByHighlight(localHighlight);
        localObject1 = ((CombinedData)this.mData).getEntryForHighlight(localHighlight);
        if ((localObject1 != null) && (((IDataSet)localObject2).getEntryIndex((Entry)localObject1) <= ((IDataSet)localObject2).getEntryCount() * this.mAnimator.getPhaseX()))
        {
          localObject2 = getMarkerPosition(localHighlight);
          if (this.mViewPortHandler.isInBounds(localObject2[0], localObject2[1]))
          {
            this.mMarker.refreshContent((Entry)localObject1, localHighlight);
            this.mMarker.draw(paramCanvas, localObject2[0], localObject2[1]);
          }
        }
      }
    }
  }
  
  public BarData getBarData()
  {
    ChartData localChartData = this.mData;
    if (localChartData == null) {
      return null;
    }
    return ((CombinedData)localChartData).getBarData();
  }
  
  public BubbleData getBubbleData()
  {
    ChartData localChartData = this.mData;
    if (localChartData == null) {
      return null;
    }
    return ((CombinedData)localChartData).getBubbleData();
  }
  
  public CandleData getCandleData()
  {
    ChartData localChartData = this.mData;
    if (localChartData == null) {
      return null;
    }
    return ((CombinedData)localChartData).getCandleData();
  }
  
  public CombinedData getCombinedData()
  {
    return (CombinedData)this.mData;
  }
  
  public DrawOrder[] getDrawOrder()
  {
    return this.mDrawOrder;
  }
  
  public Highlight getHighlightByTouchPoint(float paramFloat1, float paramFloat2)
  {
    if (this.mData == null)
    {
      Log.e("MPAndroidChart", "Can't select by touch. No data set.");
      return null;
    }
    Highlight localHighlight = getHighlighter().getHighlight(paramFloat1, paramFloat2);
    if ((localHighlight != null) && (isHighlightFullBarEnabled())) {
      return new Highlight(localHighlight.getX(), localHighlight.getY(), localHighlight.getXPx(), localHighlight.getYPx(), localHighlight.getDataSetIndex(), -1, localHighlight.getAxis());
    }
    return localHighlight;
  }
  
  public LineData getLineData()
  {
    ChartData localChartData = this.mData;
    if (localChartData == null) {
      return null;
    }
    return ((CombinedData)localChartData).getLineData();
  }
  
  public ScatterData getScatterData()
  {
    ChartData localChartData = this.mData;
    if (localChartData == null) {
      return null;
    }
    return ((CombinedData)localChartData).getScatterData();
  }
  
  protected void init()
  {
    super.init();
    this.mDrawOrder = new DrawOrder[] { DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER };
    setHighlighter(new CombinedHighlighter(this, this));
    setHighlightFullBarEnabled(true);
    this.mRenderer = new CombinedChartRenderer(this, this.mAnimator, this.mViewPortHandler);
  }
  
  public boolean isDrawBarShadowEnabled()
  {
    return this.mDrawBarShadow;
  }
  
  public boolean isDrawValueAboveBarEnabled()
  {
    return this.mDrawValueAboveBar;
  }
  
  public boolean isHighlightFullBarEnabled()
  {
    return this.mHighlightFullBarEnabled;
  }
  
  public void setData(CombinedData paramCombinedData)
  {
    super.setData(paramCombinedData);
    setHighlighter(new CombinedHighlighter(this, this));
    ((CombinedChartRenderer)this.mRenderer).createRenderers();
    this.mRenderer.initBuffers();
  }
  
  public void setDrawBarShadow(boolean paramBoolean)
  {
    this.mDrawBarShadow = paramBoolean;
  }
  
  public void setDrawOrder(DrawOrder[] paramArrayOfDrawOrder)
  {
    if ((paramArrayOfDrawOrder != null) && (paramArrayOfDrawOrder.length > 0)) {
      this.mDrawOrder = paramArrayOfDrawOrder;
    }
  }
  
  public void setDrawValueAboveBar(boolean paramBoolean)
  {
    this.mDrawValueAboveBar = paramBoolean;
  }
  
  public void setHighlightFullBarEnabled(boolean paramBoolean)
  {
    this.mHighlightFullBarEnabled = paramBoolean;
  }
  
  public static enum DrawOrder
  {
    static
    {
      DrawOrder localDrawOrder1 = new DrawOrder("BAR", 0);
      BAR = localDrawOrder1;
      DrawOrder localDrawOrder2 = new DrawOrder("BUBBLE", 1);
      BUBBLE = localDrawOrder2;
      DrawOrder localDrawOrder3 = new DrawOrder("LINE", 2);
      LINE = localDrawOrder3;
      DrawOrder localDrawOrder4 = new DrawOrder("CANDLE", 3);
      CANDLE = localDrawOrder4;
      DrawOrder localDrawOrder5 = new DrawOrder("SCATTER", 4);
      SCATTER = localDrawOrder5;
      $VALUES = new DrawOrder[] { localDrawOrder1, localDrawOrder2, localDrawOrder3, localDrawOrder4, localDrawOrder5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\CombinedChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */