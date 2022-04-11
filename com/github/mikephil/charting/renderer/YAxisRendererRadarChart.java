package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererRadarChart
  extends YAxisRenderer
{
  private RadarChart mChart;
  private Path mRenderLimitLinesPathBuffer = new Path();
  
  public YAxisRendererRadarChart(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, RadarChart paramRadarChart)
  {
    super(paramViewPortHandler, paramYAxis, null);
    this.mChart = paramRadarChart;
  }
  
  protected void computeAxisValues(float paramFloat1, float paramFloat2)
  {
    int i = this.mAxis.getLabelCount();
    double d1 = Math.abs(paramFloat2 - paramFloat1);
    if ((i != 0) && (d1 > 0.0D) && (!Double.isInfinite(d1)))
    {
      double d2 = Utils.roundToNextSignificant(d1 / i);
      double d3 = d2;
      if (this.mAxis.isGranularityEnabled())
      {
        d3 = d2;
        if (d2 < this.mAxis.getGranularity()) {
          d3 = this.mAxis.getGranularity();
        }
      }
      d2 = Utils.roundToNextSignificant(Math.pow(10.0D, (int)Math.log10(d3)));
      double d4 = d3;
      if ((int)(d3 / d2) > 5) {
        d4 = Math.floor(d2 * 10.0D);
      }
      int j = this.mAxis.isCenterAxisLabelsEnabled();
      if (this.mAxis.isForceLabelsEnabled())
      {
        paramFloat2 = (float)d1 / (i - 1);
        localObject = this.mAxis;
        ((AxisBase)localObject).mEntryCount = i;
        if (((AxisBase)localObject).mEntries.length < i) {
          ((AxisBase)localObject).mEntries = new float[i];
        }
        for (k = 0;; k++)
        {
          int m = i;
          if (k >= i) {
            break;
          }
          this.mAxis.mEntries[k] = paramFloat1;
          paramFloat1 += paramFloat2;
        }
      }
      int n = d4 < 0.0D;
      if (n == 0) {
        d2 = 0.0D;
      } else {
        d2 = Math.ceil(paramFloat1 / d4) * d4;
      }
      d3 = d2;
      if (j != 0) {
        d3 = d2 - d4;
      }
      if (n == 0) {
        d2 = 0.0D;
      } else {
        d2 = Utils.nextUp(Math.floor(paramFloat2 / d4) * d4);
      }
      if (n != 0)
      {
        d1 = d3;
        n = j;
        for (;;)
        {
          k = n;
          if (d1 > d2) {
            break;
          }
          n++;
          d1 += d4;
        }
      }
      int k = j;
      k++;
      localObject = this.mAxis;
      ((AxisBase)localObject).mEntryCount = k;
      if (((AxisBase)localObject).mEntries.length < k) {
        ((AxisBase)localObject).mEntries = new float[k];
      }
      for (n = 0; n < k; n++)
      {
        d2 = d3;
        if (d3 == 0.0D) {
          d2 = 0.0D;
        }
        this.mAxis.mEntries[n] = ((float)d2);
        d3 = d2 + d4;
      }
      n = k;
      if (d4 < 1.0D) {
        this.mAxis.mDecimals = ((int)Math.ceil(-Math.log10(d4)));
      } else {
        this.mAxis.mDecimals = 0;
      }
      if (j != 0)
      {
        localObject = this.mAxis;
        if (((AxisBase)localObject).mCenteredEntries.length < n) {
          ((AxisBase)localObject).mCenteredEntries = new float[n];
        }
        localObject = ((AxisBase)localObject).mEntries;
        paramFloat1 = (localObject[1] - localObject[0]) / 2.0F;
        for (j = 0; j < n; j++)
        {
          localObject = this.mAxis;
          ((AxisBase)localObject).mCenteredEntries[j] = (localObject.mEntries[j] + paramFloat1);
        }
      }
      AxisBase localAxisBase = this.mAxis;
      localObject = localAxisBase.mEntries;
      paramFloat2 = localObject[0];
      localAxisBase.mAxisMinimum = paramFloat2;
      paramFloat1 = localObject[(n - 1)];
      localAxisBase.mAxisMaximum = paramFloat1;
      localAxisBase.mAxisRange = Math.abs(paramFloat1 - paramFloat2);
      return;
    }
    Object localObject = this.mAxis;
    ((AxisBase)localObject).mEntries = new float[0];
    ((AxisBase)localObject).mCenteredEntries = new float[0];
    ((AxisBase)localObject).mEntryCount = 0;
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if ((this.mYAxis.isEnabled()) && (this.mYAxis.isDrawLabelsEnabled()))
    {
      this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
      this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
      this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
      MPPointF localMPPointF1 = this.mChart.getCenterOffsets();
      MPPointF localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
      float f = this.mChart.getFactor();
      int i = this.mYAxis.isDrawBottomYLabelEntryEnabled() ^ true;
      int j;
      if (this.mYAxis.isDrawTopYLabelEntryEnabled()) {
        j = this.mYAxis.mEntryCount;
      } else {
        j = this.mYAxis.mEntryCount - 1;
      }
      while (i < j)
      {
        YAxis localYAxis = this.mYAxis;
        Utils.getPosition(localMPPointF1, (localYAxis.mEntries[i] - localYAxis.mAxisMinimum) * f, this.mChart.getRotationAngle(), localMPPointF2);
        paramCanvas.drawText(this.mYAxis.getFormattedLabel(i), localMPPointF2.x + 10.0F, localMPPointF2.y, this.mAxisLabelPaint);
        i++;
      }
      MPPointF.recycleInstance(localMPPointF1);
      MPPointF.recycleInstance(localMPPointF2);
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = this.mYAxis.getLimitLines();
    if (localList == null) {
      return;
    }
    float f1 = this.mChart.getSliceAngle();
    float f2 = this.mChart.getFactor();
    MPPointF localMPPointF1 = this.mChart.getCenterOffsets();
    MPPointF localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = (LimitLine)localList.get(i);
      if (((ComponentBase)localObject).isEnabled())
      {
        this.mLimitLinePaint.setColor(((LimitLine)localObject).getLineColor());
        this.mLimitLinePaint.setPathEffect(((LimitLine)localObject).getDashPathEffect());
        this.mLimitLinePaint.setStrokeWidth(((LimitLine)localObject).getLineWidth());
        float f3 = ((LimitLine)localObject).getLimit();
        float f4 = this.mChart.getYChartMin();
        localObject = this.mRenderLimitLinesPathBuffer;
        ((Path)localObject).reset();
        for (int j = 0; j < ((IRadarDataSet)((RadarData)this.mChart.getData()).getMaxEntryCountSet()).getEntryCount(); j++)
        {
          Utils.getPosition(localMPPointF1, (f3 - f4) * f2, j * f1 + this.mChart.getRotationAngle(), localMPPointF2);
          if (j == 0) {
            ((Path)localObject).moveTo(localMPPointF2.x, localMPPointF2.y);
          } else {
            ((Path)localObject).lineTo(localMPPointF2.x, localMPPointF2.y);
          }
        }
        ((Path)localObject).close();
        paramCanvas.drawPath((Path)localObject, this.mLimitLinePaint);
      }
    }
    MPPointF.recycleInstance(localMPPointF1);
    MPPointF.recycleInstance(localMPPointF2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\YAxisRendererRadarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */