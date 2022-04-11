package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.AbstractBuffer;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class HorizontalBarChartRenderer
  extends BarChartRenderer
{
  private RectF mBarShadowRectBuffer = new RectF();
  
  public HorizontalBarChartRenderer(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramBarDataProvider, paramChartAnimator, paramViewPortHandler);
    this.mValuePaint.setTextAlign(Paint.Align.LEFT);
  }
  
  protected void drawDataSet(Canvas paramCanvas, IBarDataSet paramIBarDataSet, int paramInt)
  {
    Object localObject1 = this.mChart.getTransformer(paramIBarDataSet.getAxisDependency());
    this.mBarBorderPaint.setColor(paramIBarDataSet.getBarBorderColor());
    this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(paramIBarDataSet.getBarBorderWidth()));
    float f1 = paramIBarDataSet.getBarBorderWidth();
    int i = 0;
    int j = 1;
    int k;
    if (f1 > 0.0F) {
      k = 1;
    } else {
      k = 0;
    }
    float f2 = this.mAnimator.getPhaseX();
    float f3 = this.mAnimator.getPhaseY();
    float f4;
    int m;
    if (this.mChart.isDrawBarShadowEnabled())
    {
      this.mShadowPaint.setColor(paramIBarDataSet.getBarShadowColor());
      f4 = this.mChart.getBarData().getBarWidth() / 2.0F;
      m = Math.min((int)Math.ceil(paramIBarDataSet.getEntryCount() * f2), paramIBarDataSet.getEntryCount());
      for (n = 0; n < m; n++)
      {
        f1 = ((BarEntry)paramIBarDataSet.getEntryForIndex(n)).getX();
        localObject2 = this.mBarShadowRectBuffer;
        ((RectF)localObject2).top = (f1 - f4);
        ((RectF)localObject2).bottom = (f1 + f4);
        ((Transformer)localObject1).rectValueToPixel((RectF)localObject2);
        if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom))
        {
          if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
            break;
          }
          this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
          this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
          paramCanvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
        }
      }
    }
    Object localObject2 = this.mBarBuffers[paramInt];
    ((AbstractBuffer)localObject2).setPhases(f2, f3);
    ((BarBuffer)localObject2).setDataSet(paramInt);
    ((BarBuffer)localObject2).setInverted(this.mChart.isInverted(paramIBarDataSet.getAxisDependency()));
    ((BarBuffer)localObject2).setBarWidth(this.mChart.getBarData().getBarWidth());
    ((BarBuffer)localObject2).feed(paramIBarDataSet);
    ((Transformer)localObject1).pointValuesToPixel(((AbstractBuffer)localObject2).buffer);
    if (paramIBarDataSet.getColors().size() == 1) {
      paramInt = j;
    } else {
      paramInt = 0;
    }
    int n = i;
    if (paramInt != 0) {
      this.mRenderPaint.setColor(paramIBarDataSet.getColor());
    }
    for (n = i; n < ((AbstractBuffer)localObject2).size(); n += 4)
    {
      ViewPortHandler localViewPortHandler = this.mViewPortHandler;
      localObject1 = ((AbstractBuffer)localObject2).buffer;
      m = n + 3;
      if (!localViewPortHandler.isInBoundsTop(localObject1[m])) {
        break;
      }
      localViewPortHandler = this.mViewPortHandler;
      localObject1 = ((AbstractBuffer)localObject2).buffer;
      j = n + 1;
      if (localViewPortHandler.isInBoundsBottom(localObject1[j]))
      {
        if (paramInt == 0) {
          this.mRenderPaint.setColor(paramIBarDataSet.getColor(n / 4));
        }
        localObject1 = ((AbstractBuffer)localObject2).buffer;
        f1 = localObject1[n];
        f4 = localObject1[j];
        i = n + 2;
        paramCanvas.drawRect(f1, f4, localObject1[i], localObject1[m], this.mRenderPaint);
        if (k != 0)
        {
          localObject1 = ((AbstractBuffer)localObject2).buffer;
          paramCanvas.drawRect(localObject1[n], localObject1[j], localObject1[i], localObject1[m], this.mBarBorderPaint);
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
      Object localObject1 = this.mChart.getBarData().getDataSets();
      float f1 = Utils.convertDpToPixel(5.0F);
      boolean bool1 = this.mChart.isDrawValueAboveBarEnabled();
      for (int i = 0; i < this.mChart.getBarData().getDataSetCount(); i++)
      {
        IBarDataSet localIBarDataSet = (IBarDataSet)((List)localObject1).get(i);
        if (shouldDrawValues(localIBarDataSet))
        {
          boolean bool2 = this.mChart.isInverted(localIBarDataSet.getAxisDependency());
          applyValueTextStyle(localIBarDataSet);
          float f2 = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0F;
          ValueFormatter localValueFormatter = localIBarDataSet.getValueFormatter();
          Object localObject2 = this.mBarBuffers[i];
          float f3 = this.mAnimator.getPhaseY();
          Object localObject3 = MPPointF.getInstance(localIBarDataSet.getIconsOffset());
          ((MPPointF)localObject3).x = Utils.convertDpToPixel(((MPPointF)localObject3).x);
          ((MPPointF)localObject3).y = Utils.convertDpToPixel(((MPPointF)localObject3).y);
          int j;
          float f4;
          Object localObject4;
          Object localObject5;
          Object localObject6;
          int k;
          float f5;
          float f6;
          float f7;
          float f8;
          float f9;
          if (!localIBarDataSet.isStacked())
          {
            j = 0;
            f4 = f2;
            localObject4 = localObject1;
            localObject5 = localValueFormatter;
            localObject6 = localObject2;
            localObject1 = localObject3;
            while (j < ((AbstractBuffer)localObject6).buffer.length * this.mAnimator.getPhaseX())
            {
              localObject3 = ((AbstractBuffer)localObject6).buffer;
              k = j + 1;
              f5 = (localObject3[k] + localObject3[(j + 3)]) / 2.0F;
              if (!this.mViewPortHandler.isInBoundsTop(localObject3[k])) {
                break;
              }
              if (this.mViewPortHandler.isInBoundsX(localObject6.buffer[j]))
              {
                while (!this.mViewPortHandler.isInBoundsBottom(localObject6.buffer[k])) {}
                localObject2 = (BarEntry)localIBarDataSet.getEntryForIndex(j / 4);
                f2 = ((BarEntry)localObject2).getY();
                localObject3 = ((ValueFormatter)localObject5).getBarLabel((BarEntry)localObject2);
                f3 = Utils.calcTextWidth(this.mValuePaint, (String)localObject3);
                if (bool1) {
                  f6 = f1;
                } else {
                  f6 = -(f3 + f1);
                }
                if (bool1) {
                  f7 = -(f3 + f1);
                } else {
                  f7 = f1;
                }
                f8 = f6;
                f9 = f7;
                if (bool2)
                {
                  f8 = -f6 - f3;
                  f9 = -f7 - f3;
                }
                f6 = f8;
                if (localIBarDataSet.isDrawValuesEnabled())
                {
                  f8 = localObject6.buffer[(j + 2)];
                  if (f2 >= 0.0F) {
                    f7 = f6;
                  } else {
                    f7 = f9;
                  }
                  drawValue(paramCanvas, (String)localObject3, f8 + f7, f5 + f4, localIBarDataSet.getValueTextColor(j / 2));
                }
                localObject3 = localObject1;
                if ((((BaseEntry)localObject2).getIcon() != null) && (localIBarDataSet.isDrawIconsEnabled()))
                {
                  localObject2 = ((BaseEntry)localObject2).getIcon();
                  f7 = localObject6.buffer[(j + 2)];
                  if (f2 < 0.0F) {
                    f6 = f9;
                  }
                  f8 = ((MPPointF)localObject3).x;
                  f9 = ((MPPointF)localObject3).y;
                  Utils.drawImage(paramCanvas, (Drawable)localObject2, (int)(f7 + f6 + f8), (int)(f5 + f9), ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
                }
              }
              j += 4;
            }
            localObject6 = localObject1;
            localObject1 = localObject4;
          }
          else
          {
            localObject4 = localObject1;
            j = i;
            localObject5 = localObject3;
            Transformer localTransformer = this.mChart.getTransformer(localIBarDataSet.getAxisDependency());
            k = 0;
            for (int m = 0;; m = i)
            {
              int n;
              Object localObject7;
              do
              {
                localObject6 = localObject5;
                localObject1 = localObject4;
                i = j;
                if (k >= localIBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                  break label1600;
                }
                localObject3 = (BarEntry)localIBarDataSet.getEntryForIndex(k);
                n = localIBarDataSet.getValueTextColor(k);
                localObject1 = ((BarEntry)localObject3).getYVals();
                if (localObject1 != null) {
                  break;
                }
                localObject7 = this.mViewPortHandler;
                localObject6 = ((AbstractBuffer)localObject2).buffer;
                i = m + 1;
                if (!((ViewPortHandler)localObject7).isInBoundsTop(localObject6[i]))
                {
                  localObject6 = localObject5;
                  localObject1 = localObject4;
                  i = j;
                  break label1600;
                }
              } while ((!this.mViewPortHandler.isInBoundsX(localObject2.buffer[m])) || (!this.mViewPortHandler.isInBoundsBottom(localObject2.buffer[i])));
              localObject6 = localValueFormatter.getBarLabel((BarEntry)localObject3);
              f4 = Utils.calcTextWidth(this.mValuePaint, (String)localObject6);
              if (bool1) {
                f6 = f1;
              } else {
                f6 = -(f4 + f1);
              }
              if (bool1) {
                f7 = -(f4 + f1);
              } else {
                f7 = f1;
              }
              f8 = f6;
              f9 = f7;
              if (bool2)
              {
                f8 = -f6 - f4;
                f9 = -f7 - f4;
              }
              f6 = f8;
              if (localIBarDataSet.isDrawValuesEnabled())
              {
                f8 = localObject2.buffer[(m + 2)];
                if (((BarEntry)localObject3).getY() >= 0.0F) {
                  f7 = f6;
                } else {
                  f7 = f9;
                }
                drawValue(paramCanvas, (String)localObject6, f8 + f7, localObject2.buffer[i] + f2, n);
              }
              if ((((BaseEntry)localObject3).getIcon() != null) && (localIBarDataSet.isDrawIconsEnabled()))
              {
                localObject6 = ((BaseEntry)localObject3).getIcon();
                f7 = localObject2.buffer[(m + 2)];
                if (((BarEntry)localObject3).getY() < 0.0F) {
                  f6 = f9;
                }
                f4 = localObject2.buffer[i];
                f8 = ((MPPointF)localObject5).x;
                f9 = ((MPPointF)localObject5).y;
                Utils.drawImage(paramCanvas, (Drawable)localObject6, (int)(f7 + f6 + f8), (int)(f4 + f9), ((Drawable)localObject6).getIntrinsicWidth(), ((Drawable)localObject6).getIntrinsicHeight());
                break label1568;
                localObject7 = localObject1;
                int i1 = localObject7.length * 2;
                localObject6 = new float[i1];
                f9 = -((BarEntry)localObject3).getNegativeSum();
                int i2 = 0;
                i = 0;
                f5 = 0.0F;
                while (i2 < i1)
                {
                  f6 = localObject7[i];
                  boolean bool3 = f6 < 0.0F;
                  if ((bool3) || ((f5 == 0.0F) || (f9 != 0.0F))) {
                    if (!bool3)
                    {
                      f5 += f6;
                      f6 = f5;
                    }
                    else
                    {
                      f7 = f9 - f6;
                      f6 = f9;
                      f9 = f7;
                    }
                  }
                  localObject6[i2] = (f6 * f3);
                  i2 += 2;
                  i++;
                }
                localTransformer.pointValuesToPixel((float[])localObject6);
                i2 = 0;
                i = i1;
                while (i2 < i)
                {
                  float f10 = localObject7[(i2 / 2)];
                  Object localObject8 = localValueFormatter.getBarStackedLabel(f10, (BarEntry)localObject3);
                  float f11 = Utils.calcTextWidth(this.mValuePaint, (String)localObject8);
                  if (bool1) {
                    f7 = f1;
                  } else {
                    f7 = -(f11 + f1);
                  }
                  if (bool1) {
                    f4 = -(f11 + f1);
                  } else {
                    f4 = f1;
                  }
                  f8 = f7;
                  f6 = f4;
                  if (bool2)
                  {
                    f8 = -f7 - f11;
                    f6 = -f4 - f11;
                  }
                  if (((f10 == 0.0F) && (f9 == 0.0F) && (f5 > 0.0F)) || (f10 < 0.0F)) {
                    i1 = 1;
                  } else {
                    i1 = 0;
                  }
                  f7 = localObject6[i2];
                  if (i1 != 0) {
                    f8 = f6;
                  }
                  f7 += f8;
                  float[] arrayOfFloat = ((AbstractBuffer)localObject2).buffer;
                  f6 = (arrayOfFloat[(m + 1)] + arrayOfFloat[(m + 3)]) / 2.0F;
                  if (!this.mViewPortHandler.isInBoundsTop(f6)) {
                    break;
                  }
                  if (this.mViewPortHandler.isInBoundsX(f7))
                  {
                    while (!this.mViewPortHandler.isInBoundsBottom(f6)) {}
                    if (localIBarDataSet.isDrawValuesEnabled()) {
                      drawValue(paramCanvas, (String)localObject8, f7, f6 + f2, n);
                    }
                    if ((((BaseEntry)localObject3).getIcon() != null) && (localIBarDataSet.isDrawIconsEnabled()))
                    {
                      localObject8 = ((BaseEntry)localObject3).getIcon();
                      Utils.drawImage(paramCanvas, (Drawable)localObject8, (int)(f7 + ((MPPointF)localObject5).x), (int)(f6 + ((MPPointF)localObject5).y), ((Drawable)localObject8).getIntrinsicWidth(), ((Drawable)localObject8).getIntrinsicHeight());
                    }
                  }
                  i2 += 2;
                }
              }
              label1568:
              if (localObject1 == null) {
                i = m + 4;
              } else {
                i = m + localObject1.length * 4;
              }
              k++;
            }
          }
          label1600:
          MPPointF.recycleInstance((MPPointF)localObject6);
        }
      }
    }
  }
  
  public void initBuffers()
  {
    BarData localBarData = this.mChart.getBarData();
    this.mBarBuffers = new HorizontalBarBuffer[localBarData.getDataSetCount()];
    for (int i = 0; i < this.mBarBuffers.length; i++)
    {
      IBarDataSet localIBarDataSet = (IBarDataSet)localBarData.getDataSetByIndex(i);
      BarBuffer[] arrayOfBarBuffer = this.mBarBuffers;
      int j = localIBarDataSet.getEntryCount();
      int k;
      if (localIBarDataSet.isStacked()) {
        k = localIBarDataSet.getStackSize();
      } else {
        k = 1;
      }
      arrayOfBarBuffer[i] = new HorizontalBarBuffer(j * 4 * k, localBarData.getDataSetCount(), localIBarDataSet.isStacked());
    }
  }
  
  protected boolean isDrawingValuesAllowed(ChartInterface paramChartInterface)
  {
    boolean bool;
    if (paramChartInterface.getData().getEntryCount() < paramChartInterface.getMaxVisibleCount() * this.mViewPortHandler.getScaleY()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void prepareBarHighlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer)
  {
    this.mBarRect.set(paramFloat2, paramFloat1 - paramFloat4, paramFloat3, paramFloat1 + paramFloat4);
    paramTransformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
  }
  
  protected void setHighlightDrawPos(Highlight paramHighlight, RectF paramRectF)
  {
    paramHighlight.setDraw(paramRectF.centerY(), paramRectF.right);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\HorizontalBarChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */