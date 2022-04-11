package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

public class ScatterChartRenderer
  extends LineScatterCandleRadarRenderer
{
  protected ScatterDataProvider mChart;
  float[] mPixelBuffer = new float[2];
  
  public ScatterChartRenderer(ScatterDataProvider paramScatterDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramScatterDataProvider;
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Iterator localIterator = this.mChart.getScatterData().getDataSets().iterator();
    while (localIterator.hasNext())
    {
      IScatterDataSet localIScatterDataSet = (IScatterDataSet)localIterator.next();
      if (localIScatterDataSet.isVisible()) {
        drawDataSet(paramCanvas, localIScatterDataSet);
      }
    }
  }
  
  protected void drawDataSet(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet)
  {
    if (paramIScatterDataSet.getEntryCount() < 1) {
      return;
    }
    ViewPortHandler localViewPortHandler1 = this.mViewPortHandler;
    Transformer localTransformer = this.mChart.getTransformer(paramIScatterDataSet.getAxisDependency());
    float f = this.mAnimator.getPhaseY();
    IShapeRenderer localIShapeRenderer = paramIScatterDataSet.getShapeRenderer();
    if (localIShapeRenderer == null)
    {
      Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
      return;
    }
    int i = (int)Math.min(Math.ceil(paramIScatterDataSet.getEntryCount() * this.mAnimator.getPhaseX()), paramIScatterDataSet.getEntryCount());
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramIScatterDataSet.getEntryForIndex(j);
      this.mPixelBuffer[0] = ((Entry)localObject).getX();
      this.mPixelBuffer[1] = (((BaseEntry)localObject).getY() * f);
      localTransformer.pointValuesToPixel(this.mPixelBuffer);
      if (!localViewPortHandler1.isInBoundsRight(this.mPixelBuffer[0])) {
        break;
      }
      if ((localViewPortHandler1.isInBoundsLeft(this.mPixelBuffer[0])) && (localViewPortHandler1.isInBoundsY(this.mPixelBuffer[1])))
      {
        this.mRenderPaint.setColor(paramIScatterDataSet.getColor(j / 2));
        ViewPortHandler localViewPortHandler2 = this.mViewPortHandler;
        localObject = this.mPixelBuffer;
        localIShapeRenderer.renderShape(paramCanvas, paramIScatterDataSet, localViewPortHandler2, localObject[0], localObject[1], this.mRenderPaint);
      }
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    ScatterData localScatterData = this.mChart.getScatterData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      IScatterDataSet localIScatterDataSet = (IScatterDataSet)localScatterData.getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localIScatterDataSet != null) && (localIScatterDataSet.isHighlightEnabled()))
      {
        Object localObject = localIScatterDataSet.getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX((Entry)localObject, localIScatterDataSet))
        {
          localObject = this.mChart.getTransformer(localIScatterDataSet.getAxisDependency()).getPixelForValues(((Entry)localObject).getX(), ((BaseEntry)localObject).getY() * this.mAnimator.getPhaseY());
          localHighlight.setDraw((float)((MPPointD)localObject).x, (float)((MPPointD)localObject).y);
          drawHighlightLines(paramCanvas, (float)((MPPointD)localObject).x, (float)((MPPointD)localObject).y, localIScatterDataSet);
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
      List localList = this.mChart.getScatterData().getDataSets();
      for (int i = 0; i < this.mChart.getScatterData().getDataSetCount(); i++)
      {
        IScatterDataSet localIScatterDataSet = (IScatterDataSet)localList.get(i);
        if ((shouldDrawValues(localIScatterDataSet)) && (localIScatterDataSet.getEntryCount() >= 1))
        {
          applyValueTextStyle(localIScatterDataSet);
          this.mXBounds.set(this.mChart, localIScatterDataSet);
          Object localObject1 = this.mChart.getTransformer(localIScatterDataSet.getAxisDependency());
          float f1 = this.mAnimator.getPhaseX();
          float f2 = this.mAnimator.getPhaseY();
          Object localObject2 = this.mXBounds;
          localObject1 = ((Transformer)localObject1).generateTransformedValuesScatter(localIScatterDataSet, f1, f2, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).min, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).max);
          f1 = Utils.convertDpToPixel(localIScatterDataSet.getScatterShapeSize());
          ValueFormatter localValueFormatter = localIScatterDataSet.getValueFormatter();
          MPPointF localMPPointF = MPPointF.getInstance(localIScatterDataSet.getIconsOffset());
          localMPPointF.x = Utils.convertDpToPixel(localMPPointF.x);
          localMPPointF.y = Utils.convertDpToPixel(localMPPointF.y);
          for (int j = 0; (j < localObject1.length) && (this.mViewPortHandler.isInBoundsRight(localObject1[j])); j += 2) {
            if (this.mViewPortHandler.isInBoundsLeft(localObject1[j]))
            {
              localObject2 = this.mViewPortHandler;
              int k = j + 1;
              if (((ViewPortHandler)localObject2).isInBoundsY(localObject1[k]))
              {
                int m = j / 2;
                localObject2 = localIScatterDataSet.getEntryForIndex(this.mXBounds.min + m);
                if (localIScatterDataSet.isDrawValuesEnabled()) {
                  drawValue(paramCanvas, localValueFormatter.getPointLabel((Entry)localObject2), localObject1[j], localObject1[k] - f1, localIScatterDataSet.getValueTextColor(m + this.mXBounds.min));
                }
                if ((((BaseEntry)localObject2).getIcon() != null) && (localIScatterDataSet.isDrawIconsEnabled()))
                {
                  localObject2 = ((BaseEntry)localObject2).getIcon();
                  Utils.drawImage(paramCanvas, (Drawable)localObject2, (int)(localObject1[j] + localMPPointF.x), (int)(localObject1[k] + localMPPointF.y), ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
                }
              }
            }
          }
          MPPointF.recycleInstance(localMPPointF);
        }
      }
    }
  }
  
  public void initBuffers() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\ScatterChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */