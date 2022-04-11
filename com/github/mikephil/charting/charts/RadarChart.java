package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class RadarChart
  extends PieRadarChartBase<RadarData>
{
  private boolean mDrawWeb = true;
  private float mInnerWebLineWidth = 1.5F;
  private int mSkipWebLineCount = 0;
  private int mWebAlpha = 150;
  private int mWebColor = Color.rgb(122, 122, 122);
  private int mWebColorInner = Color.rgb(122, 122, 122);
  private float mWebLineWidth = 2.5F;
  protected XAxisRendererRadarChart mXAxisRenderer;
  private YAxis mYAxis;
  protected YAxisRendererRadarChart mYAxisRenderer;
  
  public RadarChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void calcMinMax()
  {
    super.calcMinMax();
    YAxis localYAxis = this.mYAxis;
    RadarData localRadarData = (RadarData)this.mData;
    YAxis.AxisDependency localAxisDependency = YAxis.AxisDependency.LEFT;
    localYAxis.calculate(localRadarData.getYMin(localAxisDependency), ((RadarData)this.mData).getYMax(localAxisDependency));
    this.mXAxis.calculate(0.0F, ((IRadarDataSet)((RadarData)this.mData).getMaxEntryCountSet()).getEntryCount());
  }
  
  public float getFactor()
  {
    RectF localRectF = this.mViewPortHandler.getContentRect();
    return Math.min(localRectF.width() / 2.0F, localRectF.height() / 2.0F) / this.mYAxis.mAxisRange;
  }
  
  public int getIndexForAngle(float paramFloat)
  {
    paramFloat = Utils.getNormalizedAngle(paramFloat - getRotationAngle());
    float f = getSliceAngle();
    int i = ((IRadarDataSet)((RadarData)this.mData).getMaxEntryCountSet()).getEntryCount();
    int j = 0;
    int m;
    for (int k = 0;; k = m)
    {
      m = j;
      if (k >= i) {
        break;
      }
      m = k + 1;
      if (m * f - f / 2.0F > paramFloat)
      {
        m = k;
        break;
      }
    }
    return m;
  }
  
  public float getRadius()
  {
    RectF localRectF = this.mViewPortHandler.getContentRect();
    return Math.min(localRectF.width() / 2.0F, localRectF.height() / 2.0F);
  }
  
  protected float getRequiredBaseOffset()
  {
    float f;
    if ((this.mXAxis.isEnabled()) && (this.mXAxis.isDrawLabelsEnabled())) {
      f = this.mXAxis.mLabelRotatedWidth;
    } else {
      f = Utils.convertDpToPixel(10.0F);
    }
    return f;
  }
  
  protected float getRequiredLegendOffset()
  {
    return this.mLegendRenderer.getLabelPaint().getTextSize() * 4.0F;
  }
  
  public int getSkipWebLineCount()
  {
    return this.mSkipWebLineCount;
  }
  
  public float getSliceAngle()
  {
    return 360.0F / ((IRadarDataSet)((RadarData)this.mData).getMaxEntryCountSet()).getEntryCount();
  }
  
  public int getWebAlpha()
  {
    return this.mWebAlpha;
  }
  
  public int getWebColor()
  {
    return this.mWebColor;
  }
  
  public int getWebColorInner()
  {
    return this.mWebColorInner;
  }
  
  public float getWebLineWidth()
  {
    return this.mWebLineWidth;
  }
  
  public float getWebLineWidthInner()
  {
    return this.mInnerWebLineWidth;
  }
  
  public YAxis getYAxis()
  {
    return this.mYAxis;
  }
  
  public float getYChartMax()
  {
    return this.mYAxis.mAxisMaximum;
  }
  
  public float getYChartMin()
  {
    return this.mYAxis.mAxisMinimum;
  }
  
  public float getYRange()
  {
    return this.mYAxis.mAxisRange;
  }
  
  protected void init()
  {
    super.init();
    this.mYAxis = new YAxis(YAxis.AxisDependency.LEFT);
    this.mWebLineWidth = Utils.convertDpToPixel(1.5F);
    this.mInnerWebLineWidth = Utils.convertDpToPixel(0.75F);
    this.mRenderer = new RadarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    this.mYAxisRenderer = new YAxisRendererRadarChart(this.mViewPortHandler, this.mYAxis, this);
    this.mXAxisRenderer = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this);
    this.mHighlighter = new RadarHighlighter(this);
  }
  
  public void notifyDataSetChanged()
  {
    if (this.mData == null) {
      return;
    }
    calcMinMax();
    Object localObject1 = this.mYAxisRenderer;
    Object localObject2 = this.mYAxis;
    ((AxisRenderer)localObject1).computeAxis(((AxisBase)localObject2).mAxisMinimum, ((AxisBase)localObject2).mAxisMaximum, ((YAxis)localObject2).isInverted());
    localObject2 = this.mXAxisRenderer;
    localObject1 = this.mXAxis;
    ((XAxisRenderer)localObject2).computeAxis(((AxisBase)localObject1).mAxisMinimum, ((AxisBase)localObject1).mAxisMaximum, false);
    localObject2 = this.mLegend;
    if ((localObject2 != null) && (!((Legend)localObject2).isLegendCustom())) {
      this.mLegendRenderer.computeLegend(this.mData);
    }
    calculateOffsets();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mData == null) {
      return;
    }
    if (this.mXAxis.isEnabled())
    {
      XAxisRendererRadarChart localXAxisRendererRadarChart = this.mXAxisRenderer;
      XAxis localXAxis = this.mXAxis;
      localXAxisRendererRadarChart.computeAxis(localXAxis.mAxisMinimum, localXAxis.mAxisMaximum, false);
    }
    this.mXAxisRenderer.renderAxisLabels(paramCanvas);
    if (this.mDrawWeb) {
      this.mRenderer.drawExtras(paramCanvas);
    }
    if ((this.mYAxis.isEnabled()) && (this.mYAxis.isDrawLimitLinesBehindDataEnabled())) {
      this.mYAxisRenderer.renderLimitLines(paramCanvas);
    }
    this.mRenderer.drawData(paramCanvas);
    if (valuesToHighlight()) {
      this.mRenderer.drawHighlighted(paramCanvas, this.mIndicesToHighlight);
    }
    if ((this.mYAxis.isEnabled()) && (!this.mYAxis.isDrawLimitLinesBehindDataEnabled())) {
      this.mYAxisRenderer.renderLimitLines(paramCanvas);
    }
    this.mYAxisRenderer.renderAxisLabels(paramCanvas);
    this.mRenderer.drawValues(paramCanvas);
    this.mLegendRenderer.renderLegend(paramCanvas);
    drawDescription(paramCanvas);
    drawMarkers(paramCanvas);
  }
  
  public void setDrawWeb(boolean paramBoolean)
  {
    this.mDrawWeb = paramBoolean;
  }
  
  public void setSkipWebLineCount(int paramInt)
  {
    this.mSkipWebLineCount = Math.max(0, paramInt);
  }
  
  public void setWebAlpha(int paramInt)
  {
    this.mWebAlpha = paramInt;
  }
  
  public void setWebColor(int paramInt)
  {
    this.mWebColor = paramInt;
  }
  
  public void setWebColorInner(int paramInt)
  {
    this.mWebColorInner = paramInt;
  }
  
  public void setWebLineWidth(float paramFloat)
  {
    this.mWebLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setWebLineWidthInner(float paramFloat)
  {
    this.mInnerWebLineWidth = Utils.convertDpToPixel(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\RadarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */