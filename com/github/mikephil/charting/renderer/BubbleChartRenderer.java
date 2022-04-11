package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

public class BubbleChartRenderer
  extends BarLineScatterCandleBubbleRenderer
{
  private float[] _hsvBuffer = new float[3];
  protected BubbleDataProvider mChart;
  private float[] pointBuffer = new float[2];
  private float[] sizeBuffer = new float[4];
  
  public BubbleChartRenderer(BubbleDataProvider paramBubbleDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramBubbleDataProvider;
    this.mRenderPaint.setStyle(Paint.Style.FILL);
    this.mHighlightPaint.setStyle(Paint.Style.STROKE);
    this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5F));
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Iterator localIterator = this.mChart.getBubbleData().getDataSets().iterator();
    while (localIterator.hasNext())
    {
      IBubbleDataSet localIBubbleDataSet = (IBubbleDataSet)localIterator.next();
      if (localIBubbleDataSet.isVisible()) {
        drawDataSet(paramCanvas, localIBubbleDataSet);
      }
    }
  }
  
  protected void drawDataSet(Canvas paramCanvas, IBubbleDataSet paramIBubbleDataSet)
  {
    if (paramIBubbleDataSet.getEntryCount() < 1) {
      return;
    }
    Transformer localTransformer = this.mChart.getTransformer(paramIBubbleDataSet.getAxisDependency());
    float f1 = this.mAnimator.getPhaseY();
    this.mXBounds.set(this.mChart, paramIBubbleDataSet);
    Object localObject = this.sizeBuffer;
    localObject[0] = 0.0F;
    localObject[2] = 1.0F;
    localTransformer.pointValuesToPixel((float[])localObject);
    boolean bool = paramIBubbleDataSet.isNormalizeSizeEnabled();
    localObject = this.sizeBuffer;
    float f2 = Math.abs(localObject[2] - localObject[0]);
    float f3 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), f2);
    for (int i = this.mXBounds.min;; i++)
    {
      localObject = this.mXBounds;
      if (i > ((BarLineScatterCandleBubbleRenderer.XBounds)localObject).range + ((BarLineScatterCandleBubbleRenderer.XBounds)localObject).min) {
        break;
      }
      localObject = (BubbleEntry)paramIBubbleDataSet.getEntryForIndex(i);
      this.pointBuffer[0] = ((Entry)localObject).getX();
      this.pointBuffer[1] = (((BaseEntry)localObject).getY() * f1);
      localTransformer.pointValuesToPixel(this.pointBuffer);
      f2 = getShapeSize(((BubbleEntry)localObject).getSize(), paramIBubbleDataSet.getMaxSize(), f3, bool) / 2.0F;
      if ((this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + f2)) && (this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - f2)) && (this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + f2)))
      {
        if (!this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - f2)) {
          break;
        }
        int j = paramIBubbleDataSet.getColor((int)((Entry)localObject).getX());
        this.mRenderPaint.setColor(j);
        localObject = this.pointBuffer;
        paramCanvas.drawCircle(localObject[0], localObject[1], f2, this.mRenderPaint);
      }
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    BubbleData localBubbleData = this.mChart.getBubbleData();
    float f1 = this.mAnimator.getPhaseY();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject1 = paramArrayOfHighlight[j];
      Object localObject2 = (IBubbleDataSet)localBubbleData.getDataSetByIndex(((Highlight)localObject1).getDataSetIndex());
      if ((localObject2 != null) && (((IDataSet)localObject2).isHighlightEnabled()))
      {
        BubbleEntry localBubbleEntry = (BubbleEntry)((IDataSet)localObject2).getEntryForXValue(((Highlight)localObject1).getX(), ((Highlight)localObject1).getY());
        if ((localBubbleEntry.getY() == ((Highlight)localObject1).getY()) && (isInBoundsX(localBubbleEntry, (IBarLineScatterCandleBubbleDataSet)localObject2)))
        {
          Object localObject3 = this.mChart.getTransformer(((IDataSet)localObject2).getAxisDependency());
          float[] arrayOfFloat = this.sizeBuffer;
          arrayOfFloat[0] = 0.0F;
          arrayOfFloat[2] = 1.0F;
          ((Transformer)localObject3).pointValuesToPixel(arrayOfFloat);
          boolean bool = ((IBubbleDataSet)localObject2).isNormalizeSizeEnabled();
          arrayOfFloat = this.sizeBuffer;
          float f2 = Math.abs(arrayOfFloat[2] - arrayOfFloat[0]);
          f2 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), f2);
          this.pointBuffer[0] = localBubbleEntry.getX();
          this.pointBuffer[1] = (localBubbleEntry.getY() * f1);
          ((Transformer)localObject3).pointValuesToPixel(this.pointBuffer);
          localObject3 = this.pointBuffer;
          ((Highlight)localObject1).setDraw(localObject3[0], localObject3[1]);
          f2 = getShapeSize(localBubbleEntry.getSize(), ((IBubbleDataSet)localObject2).getMaxSize(), f2, bool) / 2.0F;
          if ((this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + f2)) && (this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - f2)) && (this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + f2)))
          {
            if (!this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - f2)) {
              break;
            }
            int k = ((IDataSet)localObject2).getColor((int)localBubbleEntry.getX());
            Color.RGBToHSV(Color.red(k), Color.green(k), Color.blue(k), this._hsvBuffer);
            localObject1 = this._hsvBuffer;
            localObject1[2] *= 0.5F;
            k = Color.HSVToColor(Color.alpha(k), this._hsvBuffer);
            this.mHighlightPaint.setColor(k);
            this.mHighlightPaint.setStrokeWidth(((IBubbleDataSet)localObject2).getHighlightCircleWidth());
            localObject2 = this.pointBuffer;
            paramCanvas.drawCircle(localObject2[0], localObject2[1], f2, this.mHighlightPaint);
          }
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
    Object localObject1 = this.mChart.getBubbleData();
    if (localObject1 == null) {
      return;
    }
    if (isDrawingValuesAllowed(this.mChart))
    {
      List localList = ((ChartData)localObject1).getDataSets();
      float f1 = Utils.calcTextHeight(this.mValuePaint, "1");
      for (int i = 0; i < localList.size(); i++)
      {
        IBubbleDataSet localIBubbleDataSet = (IBubbleDataSet)localList.get(i);
        if ((shouldDrawValues(localIBubbleDataSet)) && (localIBubbleDataSet.getEntryCount() >= 1))
        {
          applyValueTextStyle(localIBubbleDataSet);
          float f2 = Math.max(0.0F, Math.min(1.0F, this.mAnimator.getPhaseX()));
          float f3 = this.mAnimator.getPhaseY();
          this.mXBounds.set(this.mChart, localIBubbleDataSet);
          localObject1 = this.mChart.getTransformer(localIBubbleDataSet.getAxisDependency());
          Object localObject2 = this.mXBounds;
          float[] arrayOfFloat = ((Transformer)localObject1).generateTransformedValuesBubble(localIBubbleDataSet, f3, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).min, ((BarLineScatterCandleBubbleRenderer.XBounds)localObject2).max);
          if (f2 != 1.0F) {
            f3 = f2;
          }
          localObject2 = localIBubbleDataSet.getValueFormatter();
          MPPointF localMPPointF = MPPointF.getInstance(localIBubbleDataSet.getIconsOffset());
          localMPPointF.x = Utils.convertDpToPixel(localMPPointF.x);
          localMPPointF.y = Utils.convertDpToPixel(localMPPointF.y);
          for (int j = 0; j < arrayOfFloat.length; j += 2)
          {
            int k = j / 2;
            int m = localIBubbleDataSet.getValueTextColor(this.mXBounds.min + k);
            m = Color.argb(Math.round(255.0F * f3), Color.red(m), Color.green(m), Color.blue(m));
            float f4 = arrayOfFloat[j];
            f2 = arrayOfFloat[(j + 1)];
            if (!this.mViewPortHandler.isInBoundsRight(f4)) {
              break;
            }
            if ((this.mViewPortHandler.isInBoundsLeft(f4)) && (this.mViewPortHandler.isInBoundsY(f2)))
            {
              localObject1 = (BubbleEntry)localIBubbleDataSet.getEntryForIndex(k + this.mXBounds.min);
              if (localIBubbleDataSet.isDrawValuesEnabled()) {
                drawValue(paramCanvas, ((ValueFormatter)localObject2).getBubbleLabel((BubbleEntry)localObject1), f4, f2 + 0.5F * f1, m);
              }
              if ((((BaseEntry)localObject1).getIcon() != null) && (localIBubbleDataSet.isDrawIconsEnabled()))
              {
                localObject1 = ((BaseEntry)localObject1).getIcon();
                Utils.drawImage(paramCanvas, (Drawable)localObject1, (int)(f4 + localMPPointF.x), (int)(f2 + localMPPointF.y), ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
              }
            }
          }
          MPPointF.recycleInstance(localMPPointF);
        }
      }
    }
  }
  
  protected float getShapeSize(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      if (paramFloat2 == 0.0F) {
        f = 1.0F;
      } else {
        f = (float)Math.sqrt(paramFloat1 / paramFloat2);
      }
    }
    return paramFloat3 * f;
  }
  
  public void initBuffers() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\BubbleChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */