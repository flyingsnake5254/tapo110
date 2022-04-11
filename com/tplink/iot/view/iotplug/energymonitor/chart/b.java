package com.tplink.iot.view.iotplug.energymonitor.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class b
  extends LineChartRenderer
{
  private final String a = "MyLineChartRenderer";
  private final Paint b;
  
  public b(LineDataProvider paramLineDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramLineDataProvider, paramChartAnimator, paramViewPortHandler);
    paramChartAnimator = new Paint();
    paramChartAnimator.setFlags(1);
    paramChartAnimator.setColor((int)4279946239L);
    paramChartAnimator.setStyle(Paint.Style.FILL_AND_STROKE);
    paramChartAnimator.setStrokeWidth(4.0F);
    paramChartAnimator.setPathEffect(new DashPathEffect(new float[] { 12.0F, 10.0F }, 0.0F));
    paramLineDataProvider = p.a;
    this.b = paramChartAnimator;
  }
  
  protected void drawHighlightLines(Canvas paramCanvas, float paramFloat1, float paramFloat2, ILineScatterCandleRadarDataSet<?> paramILineScatterCandleRadarDataSet)
  {
    j.e(paramCanvas, "c");
    j.e(paramILineScatterCandleRadarDataSet, "set");
    paramCanvas.drawLine(paramFloat1, this.mViewPortHandler.contentTop(), paramFloat1, paramFloat2, this.b);
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    j.e(paramCanvas, "c");
    j.e(paramArrayOfHighlight, "indices");
    Object localObject1 = this.mChart;
    j.d(localObject1, "mChart");
    localObject1 = ((LineDataProvider)localObject1).getLineData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      ILineDataSet localILineDataSet = (ILineDataSet)((ChartData)localObject1).getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localILineDataSet != null) && (localILineDataSet.isHighlightEnabled()))
      {
        Object localObject2 = localILineDataSet.getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX((Entry)localObject2, localILineDataSet))
        {
          Object localObject3 = this.mChart.getTransformer(localILineDataSet.getAxisDependency());
          j.d(localObject2, "e");
          float f1 = ((Entry)localObject2).getX();
          float f2 = ((BaseEntry)localObject2).getY();
          localObject2 = this.mAnimator;
          j.d(localObject2, "mAnimator");
          localObject3 = ((Transformer)localObject3).getPixelForValues(f1, f2 * ((ChartAnimator)localObject2).getPhaseY());
          localHighlight.setDraw((float)((MPPointD)localObject3).x, (float)((MPPointD)localObject3).y);
          drawHighlightLines(paramCanvas, (float)((MPPointD)localObject3).x, (float)((MPPointD)localObject3).y, localILineDataSet);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\energymonitor\chart\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */