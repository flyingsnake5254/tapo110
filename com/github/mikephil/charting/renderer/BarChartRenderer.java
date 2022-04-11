package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.AbstractBuffer;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer
  extends BarLineScatterCandleBubbleRenderer
{
  protected Paint mBarBorderPaint;
  protected BarBuffer[] mBarBuffers;
  protected RectF mBarRect = new RectF();
  private RectF mBarShadowRectBuffer = new RectF();
  protected BarDataProvider mChart;
  protected Paint mShadowPaint;
  
  public BarChartRenderer(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramBarDataProvider;
    paramBarDataProvider = new Paint(1);
    this.mHighlightPaint = paramBarDataProvider;
    paramBarDataProvider.setStyle(Paint.Style.FILL);
    this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
    this.mHighlightPaint.setAlpha(120);
    paramBarDataProvider = new Paint(1);
    this.mShadowPaint = paramBarDataProvider;
    paramBarDataProvider.setStyle(Paint.Style.FILL);
    paramBarDataProvider = new Paint(1);
    this.mBarBorderPaint = paramBarDataProvider;
    paramBarDataProvider.setStyle(Paint.Style.STROKE);
  }
  
  public void drawData(Canvas paramCanvas)
  {
    BarData localBarData = this.mChart.getBarData();
    for (int i = 0; i < localBarData.getDataSetCount(); i++)
    {
      IBarDataSet localIBarDataSet = (IBarDataSet)localBarData.getDataSetByIndex(i);
      if (localIBarDataSet.isVisible()) {
        drawDataSet(paramCanvas, localIBarDataSet, i);
      }
    }
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
    f1 = this.mAnimator.getPhaseY();
    float f3;
    int m;
    float f4;
    if (this.mChart.isDrawBarShadowEnabled())
    {
      this.mShadowPaint.setColor(paramIBarDataSet.getBarShadowColor());
      f3 = this.mChart.getBarData().getBarWidth() / 2.0F;
      m = Math.min((int)Math.ceil(paramIBarDataSet.getEntryCount() * f2), paramIBarDataSet.getEntryCount());
      for (n = 0; n < m; n++)
      {
        f4 = ((BarEntry)paramIBarDataSet.getEntryForIndex(n)).getX();
        localObject2 = this.mBarShadowRectBuffer;
        ((RectF)localObject2).left = (f4 - f3);
        ((RectF)localObject2).right = (f4 + f3);
        ((Transformer)localObject1).rectValueToPixel((RectF)localObject2);
        if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right))
        {
          if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
            break;
          }
          this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
          this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
          paramCanvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
        }
      }
    }
    Object localObject2 = this.mBarBuffers[paramInt];
    ((AbstractBuffer)localObject2).setPhases(f2, f1);
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
      Object localObject3 = this.mViewPortHandler;
      localObject1 = ((AbstractBuffer)localObject2).buffer;
      i = n + 2;
      if (((ViewPortHandler)localObject3).isInBoundsLeft(localObject1[i]))
      {
        if (!this.mViewPortHandler.isInBoundsRight(localObject2.buffer[n])) {
          break;
        }
        if (paramInt == 0) {
          this.mRenderPaint.setColor(paramIBarDataSet.getColor(n / 4));
        }
        if (paramIBarDataSet.getGradientColor() != null)
        {
          GradientColor localGradientColor = paramIBarDataSet.getGradientColor();
          localObject1 = this.mRenderPaint;
          localObject3 = ((AbstractBuffer)localObject2).buffer;
          ((Paint)localObject1).setShader(new LinearGradient(localObject3[n], localObject3[(n + 3)], localObject3[n], localObject3[(n + 1)], localGradientColor.getStartColor(), localGradientColor.getEndColor(), Shader.TileMode.MIRROR));
        }
        if (paramIBarDataSet.getGradientColors() != null)
        {
          localObject1 = this.mRenderPaint;
          localObject3 = ((AbstractBuffer)localObject2).buffer;
          f1 = localObject3[n];
          f4 = localObject3[(n + 3)];
          f2 = localObject3[n];
          f3 = localObject3[(n + 1)];
          j = n / 4;
          ((Paint)localObject1).setShader(new LinearGradient(f1, f4, f2, f3, paramIBarDataSet.getGradientColor(j).getStartColor(), paramIBarDataSet.getGradientColor(j).getEndColor(), Shader.TileMode.MIRROR));
        }
        localObject1 = ((AbstractBuffer)localObject2).buffer;
        f2 = localObject1[n];
        j = n + 1;
        f4 = localObject1[j];
        f1 = localObject1[i];
        m = n + 3;
        paramCanvas.drawRect(f2, f4, f1, localObject1[m], this.mRenderPaint);
        if (k != 0)
        {
          localObject1 = ((AbstractBuffer)localObject2).buffer;
          paramCanvas.drawRect(localObject1[n], localObject1[j], localObject1[i], localObject1[m], this.mBarBorderPaint);
        }
      }
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    BarData localBarData = this.mChart.getBarData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      Object localObject = (IBarDataSet)localBarData.getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localObject != null) && (((IDataSet)localObject).isHighlightEnabled()))
      {
        BarEntry localBarEntry = (BarEntry)((IDataSet)localObject).getEntryForXValue(localHighlight.getX(), localHighlight.getY());
        if (isInBoundsX(localBarEntry, (IBarLineScatterCandleBubbleDataSet)localObject))
        {
          Transformer localTransformer = this.mChart.getTransformer(((IDataSet)localObject).getAxisDependency());
          this.mHighlightPaint.setColor(((IBarLineScatterCandleBubbleDataSet)localObject).getHighLightColor());
          this.mHighlightPaint.setAlpha(((IBarDataSet)localObject).getHighLightAlpha());
          int k;
          if ((localHighlight.getStackIndex() >= 0) && (localBarEntry.isStacked())) {
            k = 1;
          } else {
            k = 0;
          }
          float f1;
          float f2;
          if (k != 0)
          {
            if (this.mChart.isHighlightFullBarEnabled())
            {
              f1 = localBarEntry.getPositiveSum();
              f2 = -localBarEntry.getNegativeSum();
            }
            else
            {
              localObject = localBarEntry.getRanges()[localHighlight.getStackIndex()];
              f1 = ((Range)localObject).from;
              f2 = ((Range)localObject).to;
            }
          }
          else
          {
            f1 = localBarEntry.getY();
            f2 = 0.0F;
          }
          prepareBarHighlight(localBarEntry.getX(), f1, f2, localBarData.getBarWidth() / 2.0F, localTransformer);
          setHighlightDrawPos(localHighlight, this.mBarRect);
          paramCanvas.drawRect(this.mBarRect, this.mHighlightPaint);
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
      float f1 = Utils.convertDpToPixel(4.5F);
      boolean bool1 = this.mChart.isDrawValueAboveBarEnabled();
      int i = 0;
      while (i < this.mChart.getBarData().getDataSetCount())
      {
        IBarDataSet localIBarDataSet = (IBarDataSet)((List)localObject1).get(i);
        float f2;
        Object localObject2;
        if (!shouldDrawValues(localIBarDataSet))
        {
          f2 = f1;
          localObject2 = localObject1;
        }
        else
        {
          applyValueTextStyle(localIBarDataSet);
          boolean bool2 = this.mChart.isInverted(localIBarDataSet.getAxisDependency());
          float f3 = Utils.calcTextHeight(this.mValuePaint, "8");
          float f4;
          if (bool1) {
            f4 = -f1;
          } else {
            f4 = f3 + f1;
          }
          float f5;
          if (bool1) {
            f5 = f3 + f1;
          } else {
            f5 = -f1;
          }
          float f6 = f4;
          f2 = f5;
          if (bool2)
          {
            f6 = -f4 - f3;
            f2 = -f5 - f3;
          }
          BarBuffer localBarBuffer = this.mBarBuffers[i];
          float f7 = this.mAnimator.getPhaseY();
          ValueFormatter localValueFormatter = localIBarDataSet.getValueFormatter();
          Object localObject3 = MPPointF.getInstance(localIBarDataSet.getIconsOffset());
          ((MPPointF)localObject3).x = Utils.convertDpToPixel(((MPPointF)localObject3).x);
          ((MPPointF)localObject3).y = Utils.convertDpToPixel(((MPPointF)localObject3).y);
          int j;
          Object localObject4;
          Object localObject5;
          int k;
          int m;
          Object localObject6;
          float f8;
          if (!localIBarDataSet.isStacked())
          {
            j = 0;
            localObject2 = localObject1;
            localObject4 = localValueFormatter;
            localObject1 = localObject3;
            while (j < localBarBuffer.buffer.length * this.mAnimator.getPhaseX())
            {
              localObject3 = localBarBuffer.buffer;
              f5 = (localObject3[j] + localObject3[(j + 2)]) / 2.0F;
              if (!this.mViewPortHandler.isInBoundsRight(f5)) {
                break;
              }
              localObject5 = this.mViewPortHandler;
              localObject3 = localBarBuffer.buffer;
              k = j + 1;
              if ((((ViewPortHandler)localObject5).isInBoundsY(localObject3[k])) && (this.mViewPortHandler.isInBoundsLeft(f5)))
              {
                m = j / 4;
                localObject3 = (BarEntry)localIBarDataSet.getEntryForIndex(m);
                f3 = ((BarEntry)localObject3).getY();
                if (localIBarDataSet.isDrawValuesEnabled())
                {
                  localObject5 = ((ValueFormatter)localObject4).getBarLabel((BarEntry)localObject3);
                  localObject6 = localBarBuffer.buffer;
                  if (f3 >= 0.0F) {
                    f4 = localObject6[k] + f6;
                  } else {
                    f4 = localObject6[(j + 3)] + f2;
                  }
                  drawValue(paramCanvas, (String)localObject5, f5, f4, localIBarDataSet.getValueTextColor(m));
                }
                localObject5 = localObject3;
                localObject3 = localObject1;
                if ((((BaseEntry)localObject5).getIcon() != null) && (localIBarDataSet.isDrawIconsEnabled()))
                {
                  localObject5 = ((BaseEntry)localObject5).getIcon();
                  if (f3 >= 0.0F) {
                    f4 = localBarBuffer.buffer[k] + f6;
                  } else {
                    f4 = localBarBuffer.buffer[(j + 3)] + f2;
                  }
                  f8 = ((MPPointF)localObject3).x;
                  f3 = ((MPPointF)localObject3).y;
                  Utils.drawImage(paramCanvas, (Drawable)localObject5, (int)(f5 + f8), (int)(f4 + f3), ((Drawable)localObject5).getIntrinsicWidth(), ((Drawable)localObject5).getIntrinsicHeight());
                }
              }
              j += 4;
            }
            localObject5 = localObject1;
            bool2 = bool1;
          }
          else
          {
            localObject4 = localObject1;
            localObject1 = this.mChart.getTransformer(localIBarDataSet.getAxisDependency());
            j = 0;
            m = 0;
            f4 = f1;
            for (;;)
            {
              localObject5 = localObject3;
              f1 = f4;
              bool2 = bool1;
              localObject2 = localObject4;
              if (j >= localIBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                break;
              }
              localObject2 = (BarEntry)localIBarDataSet.getEntryForIndex(j);
              localObject5 = ((BarEntry)localObject2).getYVals();
              localObject6 = localBarBuffer.buffer;
              f8 = (localObject6[m] + localObject6[(m + 2)]) / 2.0F;
              int n = localIBarDataSet.getValueTextColor(j);
              Object localObject7;
              float f9;
              if (localObject5 == null)
              {
                if (!this.mViewPortHandler.isInBoundsRight(f8))
                {
                  localObject5 = localObject3;
                  f1 = f4;
                  bool2 = bool1;
                  localObject2 = localObject4;
                  break;
                }
                localObject6 = this.mViewPortHandler;
                localObject7 = localBarBuffer.buffer;
                k = m + 1;
                if ((((ViewPortHandler)localObject6).isInBoundsY(localObject7[k])) && (this.mViewPortHandler.isInBoundsLeft(f8)))
                {
                  if (localIBarDataSet.isDrawValuesEnabled())
                  {
                    localObject6 = localValueFormatter.getBarLabel((BarEntry)localObject2);
                    f5 = localBarBuffer.buffer[k];
                    if (((BarEntry)localObject2).getY() >= 0.0F) {
                      f1 = f6;
                    } else {
                      f1 = f2;
                    }
                    drawValue(paramCanvas, (String)localObject6, f8, f5 + f1, n);
                  }
                  if ((((BaseEntry)localObject2).getIcon() == null) || (!localIBarDataSet.isDrawIconsEnabled())) {
                    break label1375;
                  }
                  localObject6 = ((BaseEntry)localObject2).getIcon();
                  f5 = localBarBuffer.buffer[k];
                  if (((BarEntry)localObject2).getY() >= 0.0F) {
                    f1 = f6;
                  } else {
                    f1 = f2;
                  }
                  f3 = ((MPPointF)localObject3).x;
                  f9 = ((MPPointF)localObject3).y;
                  Utils.drawImage(paramCanvas, (Drawable)localObject6, (int)(f3 + f8), (int)(f5 + f1 + f9), ((Drawable)localObject6).getIntrinsicWidth(), ((Drawable)localObject6).getIntrinsicHeight());
                }
              }
              else
              {
                localObject7 = localObject5;
                int i1 = localObject7.length * 2;
                localObject6 = new float[i1];
                f1 = -((BarEntry)localObject2).getNegativeSum();
                int i2 = 0;
                k = 0;
                f3 = 0.0F;
                while (i2 < i1)
                {
                  f5 = localObject7[k];
                  boolean bool3 = f5 < 0.0F;
                  if ((bool3) || ((f3 == 0.0F) || (f1 != 0.0F))) {
                    if (!bool3)
                    {
                      f3 += f5;
                      f5 = f3;
                    }
                    else
                    {
                      f9 = f1 - f5;
                      f5 = f1;
                      f1 = f9;
                    }
                  }
                  localObject6[(i2 + 1)] = (f5 * f7);
                  i2 += 2;
                  k++;
                }
                ((Transformer)localObject1).pointValuesToPixel((float[])localObject6);
                i2 = 0;
                k = i1;
                while (i2 < k)
                {
                  f9 = localObject7[(i2 / 2)];
                  if (((f9 == 0.0F) && (f1 == 0.0F) && (f3 > 0.0F)) || (f9 < 0.0F)) {
                    i1 = 1;
                  } else {
                    i1 = 0;
                  }
                  float f10 = localObject6[(i2 + 1)];
                  if (i1 != 0) {
                    f5 = f2;
                  } else {
                    f5 = f6;
                  }
                  f5 = f10 + f5;
                  if (!this.mViewPortHandler.isInBoundsRight(f8)) {
                    break;
                  }
                  if ((this.mViewPortHandler.isInBoundsY(f5)) && (this.mViewPortHandler.isInBoundsLeft(f8)))
                  {
                    if (localIBarDataSet.isDrawValuesEnabled()) {
                      drawValue(paramCanvas, localValueFormatter.getBarStackedLabel(f9, (BarEntry)localObject2), f8, f5, n);
                    }
                    Object localObject8 = localObject2;
                    if ((((BaseEntry)localObject8).getIcon() != null) && (localIBarDataSet.isDrawIconsEnabled()))
                    {
                      localObject8 = ((BaseEntry)localObject8).getIcon();
                      Utils.drawImage(paramCanvas, (Drawable)localObject8, (int)(f8 + ((MPPointF)localObject3).x), (int)(f5 + ((MPPointF)localObject3).y), ((Drawable)localObject8).getIntrinsicWidth(), ((Drawable)localObject8).getIntrinsicHeight());
                    }
                  }
                  i2 += 2;
                }
              }
              label1375:
              if (localObject5 == null) {
                m += 4;
              } else {
                m += localObject5.length * 4;
              }
              j++;
            }
          }
          f2 = f1;
          bool1 = bool2;
          MPPointF.recycleInstance((MPPointF)localObject5);
        }
        i++;
        localObject1 = localObject2;
        f1 = f2;
      }
    }
  }
  
  public void initBuffers()
  {
    BarData localBarData = this.mChart.getBarData();
    this.mBarBuffers = new BarBuffer[localBarData.getDataSetCount()];
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
      arrayOfBarBuffer[i] = new BarBuffer(j * 4 * k, localBarData.getDataSetCount(), localIBarDataSet.isStacked());
    }
  }
  
  protected void prepareBarHighlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer)
  {
    this.mBarRect.set(paramFloat1 - paramFloat4, paramFloat2, paramFloat1 + paramFloat4, paramFloat3);
    paramTransformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
  }
  
  protected void setHighlightDrawPos(Highlight paramHighlight, RectF paramRectF)
  {
    paramHighlight.setDraw(paramRectF.centerX(), paramRectF.top);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\BarChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */