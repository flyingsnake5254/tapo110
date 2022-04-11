package com.tplink.iot.devices.trv.view.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer.XBounds;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class a
  extends LineChartRenderer
{
  private final float a = 20.0F;
  private final int b = (int)2533304660L;
  private final int c = (int)2533337600L;
  private final int d = 808661811;
  private final Paint e;
  
  public a(LineDataProvider paramLineDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramLineDataProvider, paramChartAnimator, paramViewPortHandler);
    paramChartAnimator = new Paint();
    paramChartAnimator.setFlags(1);
    paramChartAnimator.setColor((int)4279946239L);
    paramChartAnimator.setStyle(Paint.Style.FILL_AND_STROKE);
    paramChartAnimator.setStrokeWidth(4.0F);
    paramChartAnimator.setPathEffect(new DashPathEffect(new float[] { 12.0F, 10.0F }, 0.0F));
    paramLineDataProvider = p.a;
    this.e = paramChartAnimator;
  }
  
  protected void drawDataSet(Canvas paramCanvas, ILineDataSet paramILineDataSet)
  {
    j.e(paramCanvas, "canvas");
    j.e(paramILineDataSet, "dataSet");
    super.drawDataSet(paramCanvas, paramILineDataSet);
    if (paramILineDataSet.getEntryCount() < 1) {
      return;
    }
    Transformer localTransformer = this.mChart.getTransformer(paramILineDataSet.getAxisDependency());
    Object localObject1 = this.mRenderPaint;
    j.d(localObject1, "mRenderPaint");
    ((Paint)localObject1).setStyle(Paint.Style.FILL);
    localObject1 = this.mRenderPaint;
    j.d(localObject1, "mRenderPaint");
    ((Paint)localObject1).setColor(-65536);
    this.mXBounds.set(this.mChart, paramILineDataSet);
    float[] arrayOfFloat = new float[4];
    localObject1 = this.mChart;
    j.d(localObject1, "mChart");
    float f = ((ChartInterface)localObject1).getContentRect().bottom;
    if (paramILineDataSet.getEntryForIndex(this.mXBounds.min) != null)
    {
      localObject1 = this.mXBounds;
      int i = ((BarLineScatterCandleBubbleRenderer.XBounds)localObject1).min;
      int j = ((BarLineScatterCandleBubbleRenderer.XBounds)localObject1).range + i;
      if (i <= j) {
        for (;;)
        {
          int k;
          if (i == 0) {
            k = 0;
          } else {
            k = i - 1;
          }
          Object localObject2 = paramILineDataSet.getEntryForIndex(k);
          localObject1 = paramILineDataSet.getEntryForIndex(i);
          if ((localObject2 != null) && (localObject1 != null))
          {
            arrayOfFloat[0] = ((Entry)localObject2).getX();
            arrayOfFloat[1] = ((BaseEntry)localObject2).getY();
            arrayOfFloat[2] = ((Entry)localObject1).getX();
            arrayOfFloat[3] = ((BaseEntry)localObject1).getY();
            localTransformer.pointValuesToPixel(arrayOfFloat);
            Paint localPaint = this.mRenderPaint;
            j.d(localPaint, "mRenderPaint");
            localObject2 = ((BaseEntry)localObject1).getData();
            localObject1 = localObject2;
            if (!(localObject2 instanceof Integer)) {
              localObject1 = null;
            }
            localObject1 = (Integer)localObject1;
            if ((localObject1 != null) && (((Integer)localObject1).intValue() == 1)) {
              k = this.c;
            } else if ((localObject1 != null) && (((Integer)localObject1).intValue() == 2)) {
              k = this.b;
            } else {
              k = this.d;
            }
            localPaint.setColor(k);
            paramCanvas.drawRect(arrayOfFloat[0], f - this.a, arrayOfFloat[2], f, this.mRenderPaint);
          }
          if (i == j) {
            break;
          }
          i++;
        }
      }
    }
  }
  
  protected void drawHighlightLines(Canvas paramCanvas, float paramFloat1, float paramFloat2, ILineScatterCandleRadarDataSet<?> paramILineScatterCandleRadarDataSet)
  {
    j.e(paramCanvas, "c");
    j.e(paramILineScatterCandleRadarDataSet, "set");
    paramCanvas.drawLine(paramFloat1, this.mViewPortHandler.contentTop(), paramFloat1, this.mViewPortHandler.contentBottom(), this.e);
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    j.e(paramCanvas, "c");
    j.e(paramArrayOfHighlight, "indices");
    Object localObject1 = this.mChart;
    j.d(localObject1, "mChart");
    LineData localLineData = ((LineDataProvider)localObject1).getLineData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      localObject1 = (ILineDataSet)localLineData.getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localObject1 != null) && (((IDataSet)localObject1).isHighlightEnabled()))
      {
        Object localObject2 = ((IDataSet)localObject1).getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX((Entry)localObject2, (IBarLineScatterCandleBubbleDataSet)localObject1))
        {
          Object localObject3 = this.mChart.getTransformer(((IDataSet)localObject1).getAxisDependency());
          j.d(localObject2, "e");
          float f1 = ((Entry)localObject2).getX();
          float f2 = ((BaseEntry)localObject2).getY();
          localObject2 = this.mAnimator;
          j.d(localObject2, "mAnimator");
          localObject3 = ((Transformer)localObject3).getPixelForValues(f1, f2 * ((ChartAnimator)localObject2).getPhaseY());
          localHighlight.setDraw((float)((MPPointD)localObject3).x, (float)((MPPointD)localObject3).y);
          drawHighlightLines(paramCanvas, (float)((MPPointD)localObject3).x, (float)((MPPointD)localObject3).y, (ILineScatterCandleRadarDataSet)localObject1);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\chart\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */