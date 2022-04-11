package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererRadarChart
  extends XAxisRenderer
{
  private RadarChart mChart;
  
  public XAxisRendererRadarChart(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, RadarChart paramRadarChart)
  {
    super(paramViewPortHandler, paramXAxis, null);
    this.mChart = paramRadarChart;
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if ((this.mXAxis.isEnabled()) && (this.mXAxis.isDrawLabelsEnabled()))
    {
      float f1 = this.mXAxis.getLabelRotationAngle();
      MPPointF localMPPointF1 = MPPointF.getInstance(0.5F, 0.25F);
      this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
      this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
      this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
      float f2 = this.mChart.getSliceAngle();
      float f3 = this.mChart.getFactor();
      MPPointF localMPPointF2 = this.mChart.getCenterOffsets();
      MPPointF localMPPointF3 = MPPointF.getInstance(0.0F, 0.0F);
      for (int i = 0; i < ((IRadarDataSet)((RadarData)this.mChart.getData()).getMaxEntryCountSet()).getEntryCount(); i++)
      {
        Object localObject = this.mXAxis.getValueFormatter();
        float f4 = i;
        localObject = ((ValueFormatter)localObject).getAxisLabel(f4, this.mXAxis);
        float f5 = this.mChart.getRotationAngle();
        Utils.getPosition(localMPPointF2, this.mChart.getYRange() * f3 + this.mXAxis.mLabelRotatedWidth / 2.0F, (f4 * f2 + f5) % 360.0F, localMPPointF3);
        drawLabel(paramCanvas, (String)localObject, localMPPointF3.x, localMPPointF3.y - this.mXAxis.mLabelRotatedHeight / 2.0F, localMPPointF1, f1);
      }
      MPPointF.recycleInstance(localMPPointF2);
      MPPointF.recycleInstance(localMPPointF3);
      MPPointF.recycleInstance(localMPPointF1);
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\XAxisRendererRadarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */