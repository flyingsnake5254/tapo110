package com.tplink.iot.view.iotplug.energymonitor.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.AbstractBuffer;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.Renderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class a
  extends BarChartRenderer
{
  private final String a = "MyBarChartRenderer";
  private final Paint b;
  private final Paint c;
  private final RectF d;
  private final float e;
  
  public a(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramBarDataProvider, paramChartAnimator, paramViewPortHandler);
    paramChartAnimator = new Paint();
    paramChartAnimator.setFlags(1);
    paramChartAnimator.setColor((int)4279946239L);
    paramChartAnimator.setStyle(Paint.Style.FILL_AND_STROKE);
    paramChartAnimator.setStrokeWidth(4.0F);
    paramChartAnimator.setPathEffect(new DashPathEffect(new float[] { 12.0F, 10.0F }, 0.0F));
    paramBarDataProvider = p.a;
    this.b = paramChartAnimator;
    paramBarDataProvider = new Paint();
    paramBarDataProvider.setFlags(1);
    paramBarDataProvider.setColor((int)4292335833L);
    paramBarDataProvider.setStyle(Paint.Style.FILL_AND_STROKE);
    paramBarDataProvider.setStrokeWidth(2.0F);
    paramBarDataProvider.setPathEffect(new DashPathEffect(new float[] { 16.0F, 12.0F }, 0.0F));
    this.c = paramBarDataProvider;
    this.d = new RectF();
    this.e = 16.0F;
  }
  
  protected void drawDataSet(Canvas paramCanvas, IBarDataSet paramIBarDataSet, int paramInt)
  {
    j.e(paramCanvas, "c");
    j.e(paramIBarDataSet, "dataSet");
    Object localObject1 = this.mChart.getTransformer(paramIBarDataSet.getAxisDependency());
    Object localObject2 = this.mBarBorderPaint;
    j.d(localObject2, "mBarBorderPaint");
    ((Paint)localObject2).setColor(paramIBarDataSet.getBarBorderColor());
    localObject2 = this.mBarBorderPaint;
    j.d(localObject2, "mBarBorderPaint");
    ((Paint)localObject2).setStrokeWidth(Utils.convertDpToPixel(paramIBarDataSet.getBarBorderWidth()));
    int i;
    if (paramIBarDataSet.getBarBorderWidth() > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    localObject2 = this.mAnimator;
    j.d(localObject2, "mAnimator");
    float f1 = ((ChartAnimator)localObject2).getPhaseX();
    localObject2 = this.mAnimator;
    j.d(localObject2, "mAnimator");
    float f2 = ((ChartAnimator)localObject2).getPhaseY();
    localObject2 = this.mChart;
    j.d(localObject2, "mChart");
    float f3;
    int j;
    int k;
    float f4;
    if (((BarDataProvider)localObject2).isDrawBarShadowEnabled())
    {
      localObject2 = this.mShadowPaint;
      j.d(localObject2, "mShadowPaint");
      ((Paint)localObject2).setColor(paramIBarDataSet.getBarShadowColor());
      localObject2 = this.mChart;
      j.d(localObject2, "mChart");
      localObject2 = ((BarDataProvider)localObject2).getBarData();
      j.d(localObject2, "barData");
      f3 = ((BarData)localObject2).getBarWidth() / 2.0F;
      j = Math.min((int)Math.ceil(paramIBarDataSet.getEntryCount() * f1), paramIBarDataSet.getEntryCount());
      k = 0;
      if (k < j)
      {
        localObject2 = (BarEntry)paramIBarDataSet.getEntryForIndex(k);
        j.d(localObject2, "e");
        f4 = ((Entry)localObject2).getX();
        localObject2 = this.d;
        ((RectF)localObject2).left = (f4 - f3);
        ((RectF)localObject2).right = (f4 + f3);
        ((Transformer)localObject1).rectValueToPixel((RectF)localObject2);
        if (!this.mViewPortHandler.isInBoundsLeft(this.d.right)) {}
        for (;;)
        {
          k++;
          break;
          if (!this.mViewPortHandler.isInBoundsRight(this.d.left)) {
            break label408;
          }
          this.d.top = this.mViewPortHandler.contentTop();
          this.d.bottom = this.mViewPortHandler.contentBottom();
          paramCanvas.drawRect(this.d, this.mShadowPaint);
        }
      }
    }
    label408:
    localObject2 = this.mBarBuffers[paramInt];
    ((AbstractBuffer)localObject2).setPhases(f1, f2);
    ((BarBuffer)localObject2).setDataSet(paramInt);
    ((BarBuffer)localObject2).setInverted(this.mChart.isInverted(paramIBarDataSet.getAxisDependency()));
    Object localObject3 = this.mChart;
    j.d(localObject3, "mChart");
    localObject3 = ((BarDataProvider)localObject3).getBarData();
    j.d(localObject3, "mChart.barData");
    ((BarBuffer)localObject2).setBarWidth(((BarData)localObject3).getBarWidth());
    ((BarBuffer)localObject2).feed(paramIBarDataSet);
    ((Transformer)localObject1).pointValuesToPixel(((AbstractBuffer)localObject2).buffer);
    if (paramIBarDataSet.getColors().size() == 1) {
      k = 1;
    } else {
      k = 0;
    }
    localObject1 = "mRenderPaint";
    if (k != 0)
    {
      localObject3 = this.mRenderPaint;
      j.d(localObject3, "mRenderPaint");
      ((Paint)localObject3).setColor(paramIBarDataSet.getColor());
    }
    paramInt = 0;
    while (paramInt < ((AbstractBuffer)localObject2).size())
    {
      Object localObject4 = this.mViewPortHandler;
      localObject3 = ((AbstractBuffer)localObject2).buffer;
      int m = paramInt + 2;
      if (!((ViewPortHandler)localObject4).isInBoundsLeft(localObject3[m]))
      {
        paramInt += 4;
      }
      else
      {
        if (!this.mViewPortHandler.isInBoundsRight(localObject2.buffer[paramInt])) {
          break;
        }
        if (k == 0)
        {
          localObject3 = this.mRenderPaint;
          j.d(localObject3, (String)localObject1);
          ((Paint)localObject3).setColor(paramIBarDataSet.getColor(paramInt / 4));
        }
        if (paramIBarDataSet.getGradientColor() != null)
        {
          GradientColor localGradientColor = paramIBarDataSet.getGradientColor();
          localObject4 = this.mRenderPaint;
          j.d(localObject4, (String)localObject1);
          localObject3 = ((AbstractBuffer)localObject2).buffer;
          f4 = localObject3[paramInt];
          f1 = localObject3[(paramInt + 3)];
          f2 = localObject3[paramInt];
          f3 = localObject3[(paramInt + 1)];
          j.d(localGradientColor, "gradientColor");
          ((Paint)localObject4).setShader(new LinearGradient(f4, f1, f2, f3, localGradientColor.getStartColor(), localGradientColor.getEndColor(), Shader.TileMode.MIRROR));
        }
        if (paramIBarDataSet.getGradientColors() != null)
        {
          localObject3 = this.mRenderPaint;
          j.d(localObject3, (String)localObject1);
          localObject4 = ((AbstractBuffer)localObject2).buffer;
          f1 = localObject4[paramInt];
          f3 = localObject4[(paramInt + 3)];
          f4 = localObject4[paramInt];
          f2 = localObject4[(paramInt + 1)];
          j = paramInt / 4;
          localObject4 = paramIBarDataSet.getGradientColor(j);
          j.d(localObject4, "dataSet.getGradientColor(j / 4)");
          int n = ((GradientColor)localObject4).getStartColor();
          localObject4 = paramIBarDataSet.getGradientColor(j);
          j.d(localObject4, "dataSet.getGradientColor(j / 4)");
          ((Paint)localObject3).setShader(new LinearGradient(f1, f3, f4, f2, n, ((GradientColor)localObject4).getEndColor(), Shader.TileMode.MIRROR));
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject3 = ((AbstractBuffer)localObject2).buffer;
          float f5 = localObject3[paramInt];
          f3 = localObject3[(paramInt + 1)];
          f2 = localObject3[m];
          f1 = localObject3[(paramInt + 3)];
          f4 = this.e;
          paramCanvas.drawRoundRect(f5, f3, f2, f1 + f4, f4, f4, this.mRenderPaint);
        }
        else
        {
          j = paramInt;
          localObject3 = ((AbstractBuffer)localObject2).buffer;
          f2 = localObject3[j];
          f1 = localObject3[(j + 1)];
          f3 = localObject3[m];
          f4 = localObject3[(j + 3)];
          paramCanvas.drawRect(f2, f1, f3, this.e + f4, this.mRenderPaint);
        }
        if (i != 0)
        {
          localObject3 = ((AbstractBuffer)localObject2).buffer;
          paramCanvas.drawRect(localObject3[paramInt], localObject3[(paramInt + 1)], localObject3[m], localObject3[(paramInt + 3)], this.mBarBorderPaint);
        }
        localObject3 = ((AbstractBuffer)localObject2).buffer;
        if (paramInt + 7 < localObject3.length)
        {
          f1 = (localObject3[m] + localObject3[(paramInt + 4)]) / 2.0F;
          localObject3 = this.mChart;
          j.d(localObject3, "mChart");
          paramCanvas.drawLine(f1, 0.0F, f1, ((ChartInterface)localObject3).getContentRect().bottom, this.c);
        }
        paramInt += 4;
      }
    }
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    j.e(paramCanvas, "c");
    j.e(paramArrayOfHighlight, "indices");
    Object localObject1 = this.mChart;
    j.d(localObject1, "mChart");
    localObject1 = ((BarDataProvider)localObject1).getBarData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      Object localObject2 = (IBarDataSet)((ChartData)localObject1).getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localObject2 != null) && (((IDataSet)localObject2).isHighlightEnabled()))
      {
        BarEntry localBarEntry = (BarEntry)((IDataSet)localObject2).getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX(localBarEntry, (IBarLineScatterCandleBubbleDataSet)localObject2))
        {
          Object localObject3 = this.mChart.getTransformer(((IDataSet)localObject2).getAxisDependency());
          Paint localPaint = this.mHighlightPaint;
          j.d(localPaint, "mHighlightPaint");
          localPaint.setColor(((IBarLineScatterCandleBubbleDataSet)localObject2).getHighLightColor());
          localPaint = this.mHighlightPaint;
          j.d(localPaint, "mHighlightPaint");
          localPaint.setAlpha(((IBarDataSet)localObject2).getHighLightAlpha());
          if (localHighlight.getStackIndex() >= 0)
          {
            j.d(localBarEntry, "e");
            if (localBarEntry.isStacked())
            {
              k = 1;
              break label221;
            }
          }
          int k = 0;
          label221:
          float f2;
          if (k != 0)
          {
            localObject2 = this.mChart;
            j.d(localObject2, "mChart");
            if (((BarDataProvider)localObject2).isHighlightFullBarEnabled())
            {
              j.d(localBarEntry, "e");
              f1 = localBarEntry.getPositiveSum();
              f2 = -localBarEntry.getNegativeSum();
            }
            else
            {
              j.d(localBarEntry, "e");
              localObject2 = localBarEntry.getRanges()[localHighlight.getStackIndex()];
              f1 = ((Range)localObject2).from;
              f2 = ((Range)localObject2).to;
            }
          }
          else
          {
            j.d(localBarEntry, "e");
            f1 = localBarEntry.getY();
            f2 = 0.0F;
          }
          float f3 = localBarEntry.getX();
          j.d(localObject1, "barData");
          prepareBarHighlight(f3, f1, f2, ((BarData)localObject1).getBarWidth() / 2.0F, (Transformer)localObject3);
          setHighlightDrawPos(localHighlight, this.mBarRect);
          float f1 = this.mBarRect.centerX();
          localObject3 = this.mBarRect;
          paramCanvas.drawLine(f1, ((RectF)localObject3).top, ((RectF)localObject3).centerX(), 0.0F, this.b);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\energymonitor\chart\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */