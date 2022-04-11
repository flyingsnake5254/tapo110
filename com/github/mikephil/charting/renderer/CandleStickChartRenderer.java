package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

public class CandleStickChartRenderer
  extends LineScatterCandleRadarRenderer
{
  private float[] mBodyBuffers = new float[4];
  protected CandleDataProvider mChart;
  private float[] mCloseBuffers = new float[4];
  private float[] mOpenBuffers = new float[4];
  private float[] mRangeBuffers = new float[4];
  private float[] mShadowBuffers = new float[8];
  
  public CandleStickChartRenderer(CandleDataProvider paramCandleDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramCandleDataProvider;
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Iterator localIterator = this.mChart.getCandleData().getDataSets().iterator();
    while (localIterator.hasNext())
    {
      ICandleDataSet localICandleDataSet = (ICandleDataSet)localIterator.next();
      if (localICandleDataSet.isVisible()) {
        drawDataSet(paramCanvas, localICandleDataSet);
      }
    }
  }
  
  protected void drawDataSet(Canvas paramCanvas, ICandleDataSet paramICandleDataSet)
  {
    Transformer localTransformer = this.mChart.getTransformer(paramICandleDataSet.getAxisDependency());
    float f1 = this.mAnimator.getPhaseY();
    float f2 = paramICandleDataSet.getBarSpace();
    boolean bool1 = paramICandleDataSet.getShowCandleBar();
    this.mXBounds.set(this.mChart, paramICandleDataSet);
    this.mRenderPaint.setStrokeWidth(paramICandleDataSet.getShadowWidth());
    for (int i = this.mXBounds.min;; i++)
    {
      Object localObject = this.mXBounds;
      if (i > ((BarLineScatterCandleBubbleRenderer.XBounds)localObject).range + ((BarLineScatterCandleBubbleRenderer.XBounds)localObject).min) {
        break;
      }
      localObject = (CandleEntry)paramICandleDataSet.getEntryForIndex(i);
      if (localObject != null)
      {
        float f3 = ((Entry)localObject).getX();
        float f4 = ((CandleEntry)localObject).getOpen();
        float f5 = ((CandleEntry)localObject).getClose();
        float f6 = ((CandleEntry)localObject).getHigh();
        float f7 = ((CandleEntry)localObject).getLow();
        int j;
        if (bool1)
        {
          localObject = this.mShadowBuffers;
          localObject[0] = f3;
          localObject[2] = f3;
          localObject[4] = f3;
          localObject[6] = f3;
          boolean bool2 = f4 < f5;
          if (bool2)
          {
            localObject[1] = (f6 * f1);
            localObject[3] = (f4 * f1);
            localObject[5] = (f7 * f1);
            localObject[7] = (f5 * f1);
          }
          else if (f4 < f5)
          {
            localObject[1] = (f6 * f1);
            localObject[3] = (f5 * f1);
            localObject[5] = (f7 * f1);
            localObject[7] = (f4 * f1);
          }
          else
          {
            localObject[1] = (f6 * f1);
            localObject[3] = (f4 * f1);
            localObject[5] = (f7 * f1);
            localObject[7] = localObject[3];
          }
          localTransformer.pointValuesToPixel((float[])localObject);
          if (paramICandleDataSet.getShadowColorSameAsCandle())
          {
            if (bool2)
            {
              localObject = this.mRenderPaint;
              if (paramICandleDataSet.getDecreasingColor() == 1122867) {
                j = paramICandleDataSet.getColor(i);
              } else {
                j = paramICandleDataSet.getDecreasingColor();
              }
              ((Paint)localObject).setColor(j);
            }
            else if (f4 < f5)
            {
              localObject = this.mRenderPaint;
              if (paramICandleDataSet.getIncreasingColor() == 1122867) {
                j = paramICandleDataSet.getColor(i);
              } else {
                j = paramICandleDataSet.getIncreasingColor();
              }
              ((Paint)localObject).setColor(j);
            }
            else
            {
              localObject = this.mRenderPaint;
              if (paramICandleDataSet.getNeutralColor() == 1122867) {
                j = paramICandleDataSet.getColor(i);
              } else {
                j = paramICandleDataSet.getNeutralColor();
              }
              ((Paint)localObject).setColor(j);
            }
          }
          else
          {
            localObject = this.mRenderPaint;
            if (paramICandleDataSet.getShadowColor() == 1122867) {
              j = paramICandleDataSet.getColor(i);
            } else {
              j = paramICandleDataSet.getShadowColor();
            }
            ((Paint)localObject).setColor(j);
          }
          this.mRenderPaint.setStyle(Paint.Style.STROKE);
          paramCanvas.drawLines(this.mShadowBuffers, this.mRenderPaint);
          localObject = this.mBodyBuffers;
          localObject[0] = (f3 - 0.5F + f2);
          localObject[1] = (f5 * f1);
          localObject[2] = (f3 + 0.5F - f2);
          localObject[3] = (f4 * f1);
          localTransformer.pointValuesToPixel((float[])localObject);
          if (bool2)
          {
            if (paramICandleDataSet.getDecreasingColor() == 1122867) {
              this.mRenderPaint.setColor(paramICandleDataSet.getColor(i));
            } else {
              this.mRenderPaint.setColor(paramICandleDataSet.getDecreasingColor());
            }
            this.mRenderPaint.setStyle(paramICandleDataSet.getDecreasingPaintStyle());
            localObject = this.mBodyBuffers;
            paramCanvas.drawRect(localObject[0], localObject[3], localObject[2], localObject[1], this.mRenderPaint);
          }
          else if (f4 < f5)
          {
            if (paramICandleDataSet.getIncreasingColor() == 1122867) {
              this.mRenderPaint.setColor(paramICandleDataSet.getColor(i));
            } else {
              this.mRenderPaint.setColor(paramICandleDataSet.getIncreasingColor());
            }
            this.mRenderPaint.setStyle(paramICandleDataSet.getIncreasingPaintStyle());
            localObject = this.mBodyBuffers;
            paramCanvas.drawRect(localObject[0], localObject[1], localObject[2], localObject[3], this.mRenderPaint);
          }
          else
          {
            if (paramICandleDataSet.getNeutralColor() == 1122867) {
              this.mRenderPaint.setColor(paramICandleDataSet.getColor(i));
            } else {
              this.mRenderPaint.setColor(paramICandleDataSet.getNeutralColor());
            }
            localObject = this.mBodyBuffers;
            paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], this.mRenderPaint);
          }
        }
        else
        {
          localObject = this.mRangeBuffers;
          localObject[0] = f3;
          localObject[1] = (f6 * f1);
          localObject[2] = f3;
          localObject[3] = (f7 * f1);
          float[] arrayOfFloat = this.mOpenBuffers;
          arrayOfFloat[0] = (f3 - 0.5F + f2);
          f7 = f4 * f1;
          arrayOfFloat[1] = f7;
          arrayOfFloat[2] = f3;
          arrayOfFloat[3] = f7;
          arrayOfFloat = this.mCloseBuffers;
          arrayOfFloat[0] = (0.5F + f3 - f2);
          f7 = f5 * f1;
          arrayOfFloat[1] = f7;
          arrayOfFloat[2] = f3;
          arrayOfFloat[3] = f7;
          localTransformer.pointValuesToPixel((float[])localObject);
          localTransformer.pointValuesToPixel(this.mOpenBuffers);
          localTransformer.pointValuesToPixel(this.mCloseBuffers);
          if (f4 > f5)
          {
            if (paramICandleDataSet.getDecreasingColor() == 1122867) {
              j = paramICandleDataSet.getColor(i);
            } else {
              j = paramICandleDataSet.getDecreasingColor();
            }
          }
          else if (f4 < f5)
          {
            if (paramICandleDataSet.getIncreasingColor() == 1122867) {
              j = paramICandleDataSet.getColor(i);
            } else {
              j = paramICandleDataSet.getIncreasingColor();
            }
          }
          else if (paramICandleDataSet.getNeutralColor() == 1122867) {
            j = paramICandleDataSet.getColor(i);
          } else {
            j = paramICandleDataSet.getNeutralColor();
          }
          this.mRenderPaint.setColor(j);
          localObject = this.mRangeBuffers;
          paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], this.mRenderPaint);
          localObject = this.mOpenBuffers;
          paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], this.mRenderPaint);
          localObject = this.mCloseBuffers;
          paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], this.mRenderPaint);
        }
      }
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    CandleData localCandleData = this.mChart.getCandleData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      ICandleDataSet localICandleDataSet = (ICandleDataSet)localCandleData.getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localICandleDataSet != null) && (localICandleDataSet.isHighlightEnabled()))
      {
        Object localObject = (CandleEntry)localICandleDataSet.getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX((Entry)localObject, localICandleDataSet))
        {
          float f = (((CandleEntry)localObject).getLow() * this.mAnimator.getPhaseY() + ((CandleEntry)localObject).getHigh() * this.mAnimator.getPhaseY()) / 2.0F;
          localObject = this.mChart.getTransformer(localICandleDataSet.getAxisDependency()).getPixelForValues(((Entry)localObject).getX(), f);
          localHighlight.setDraw((float)((MPPointD)localObject).x, (float)((MPPointD)localObject).y);
          drawHighlightLines(paramCanvas, (float)((MPPointD)localObject).x, (float)((MPPointD)localObject).y, localICandleDataSet);
        }
      }
    }
  }
  
  public void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.mValuePaint.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mValuePaint);
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    if (isDrawingValuesAllowed(this.mChart))
    {
      List localList = this.mChart.getCandleData().getDataSets();
      for (int i = 0; i < localList.size(); i++)
      {
        ICandleDataSet localICandleDataSet = (ICandleDataSet)localList.get(i);
        if ((shouldDrawValues(localICandleDataSet)) && (localICandleDataSet.getEntryCount() >= 1))
        {
          applyValueTextStyle(localICandleDataSet);
          Object localObject1 = this.mChart.getTransformer(localICandleDataSet.getAxisDependency());
          this.mXBounds.set(this.mChart, localICandleDataSet);
          float f1 = this.mAnimator.getPhaseX();
          float f2 = this.mAnimator.getPhaseY();
          Object localObject2 = this.mXBounds;
          float[] arrayOfFloat = ((Transformer)localObject1).generateTransformedValuesCandle(localICandleDataSet, f1, f2, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).min, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).max);
          float f3 = Utils.convertDpToPixel(5.0F);
          ValueFormatter localValueFormatter = localICandleDataSet.getValueFormatter();
          localObject1 = MPPointF.getInstance(localICandleDataSet.getIconsOffset());
          ((MPPointF)localObject1).x = Utils.convertDpToPixel(((MPPointF)localObject1).x);
          ((MPPointF)localObject1).y = Utils.convertDpToPixel(((MPPointF)localObject1).y);
          for (int j = 0; j < arrayOfFloat.length; j += 2)
          {
            f2 = arrayOfFloat[j];
            f1 = arrayOfFloat[(j + 1)];
            if (!this.mViewPortHandler.isInBoundsRight(f2)) {
              break;
            }
            if ((this.mViewPortHandler.isInBoundsLeft(f2)) && (this.mViewPortHandler.isInBoundsY(f1)))
            {
              int k = j / 2;
              localObject2 = (CandleEntry)localICandleDataSet.getEntryForIndex(this.mXBounds.min + k);
              if (localICandleDataSet.isDrawValuesEnabled()) {
                drawValue(paramCanvas, localValueFormatter.getCandleLabel((CandleEntry)localObject2), f2, f1 - f3, localICandleDataSet.getValueTextColor(k));
              }
              if ((((BaseEntry)localObject2).getIcon() != null) && (localICandleDataSet.isDrawIconsEnabled()))
              {
                localObject2 = ((BaseEntry)localObject2).getIcon();
                Utils.drawImage(paramCanvas, (Drawable)localObject2, (int)(f2 + ((MPPointF)localObject1).x), (int)(f1 + ((MPPointF)localObject1).y), ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
              }
            }
          }
          MPPointF.recycleInstance((MPPointF)localObject1);
        }
      }
    }
  }
  
  public void initBuffers() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\CandleStickChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */