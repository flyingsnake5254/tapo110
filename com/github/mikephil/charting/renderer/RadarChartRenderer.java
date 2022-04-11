package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

public class RadarChartRenderer
  extends LineRadarRenderer
{
  protected RadarChart mChart;
  protected Path mDrawDataSetSurfacePathBuffer = new Path();
  protected Path mDrawHighlightCirclePathBuffer = new Path();
  protected Paint mHighlightCirclePaint;
  protected Paint mWebPaint;
  
  public RadarChartRenderer(RadarChart paramRadarChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    this.mChart = paramRadarChart;
    paramRadarChart = new Paint(1);
    this.mHighlightPaint = paramRadarChart;
    paramRadarChart.setStyle(Paint.Style.STROKE);
    this.mHighlightPaint.setStrokeWidth(2.0F);
    this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
    paramRadarChart = new Paint(1);
    this.mWebPaint = paramRadarChart;
    paramRadarChart.setStyle(Paint.Style.STROKE);
    this.mHighlightCirclePaint = new Paint(1);
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Object localObject = (RadarData)this.mChart.getData();
    int i = ((IRadarDataSet)((ChartData)localObject).getMaxEntryCountSet()).getEntryCount();
    localObject = ((ChartData)localObject).getDataSets().iterator();
    while (((Iterator)localObject).hasNext())
    {
      IRadarDataSet localIRadarDataSet = (IRadarDataSet)((Iterator)localObject).next();
      if (localIRadarDataSet.isVisible()) {
        drawDataSet(paramCanvas, localIRadarDataSet, i);
      }
    }
  }
  
  protected void drawDataSet(Canvas paramCanvas, IRadarDataSet paramIRadarDataSet, int paramInt)
  {
    float f1 = this.mAnimator.getPhaseX();
    float f2 = this.mAnimator.getPhaseY();
    float f3 = this.mChart.getSliceAngle();
    float f4 = this.mChart.getFactor();
    MPPointF localMPPointF1 = this.mChart.getCenterOffsets();
    MPPointF localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
    Path localPath = this.mDrawDataSetSurfacePathBuffer;
    localPath.reset();
    int i = 0;
    int j = 0;
    while (i < paramIRadarDataSet.getEntryCount())
    {
      this.mRenderPaint.setColor(paramIRadarDataSet.getColor(i));
      Utils.getPosition(localMPPointF1, (((RadarEntry)paramIRadarDataSet.getEntryForIndex(i)).getY() - this.mChart.getYChartMin()) * f4 * f2, i * f3 * f1 + this.mChart.getRotationAngle(), localMPPointF2);
      if (!Float.isNaN(localMPPointF2.x)) {
        if (j == 0)
        {
          localPath.moveTo(localMPPointF2.x, localMPPointF2.y);
          j = 1;
        }
        else
        {
          localPath.lineTo(localMPPointF2.x, localMPPointF2.y);
        }
      }
      i++;
    }
    if (paramIRadarDataSet.getEntryCount() > paramInt) {
      localPath.lineTo(localMPPointF1.x, localMPPointF1.y);
    }
    localPath.close();
    if (paramIRadarDataSet.isDrawFilledEnabled())
    {
      Drawable localDrawable = paramIRadarDataSet.getFillDrawable();
      if (localDrawable != null) {
        drawFilledPath(paramCanvas, localPath, localDrawable);
      } else {
        drawFilledPath(paramCanvas, localPath, paramIRadarDataSet.getFillColor(), paramIRadarDataSet.getFillAlpha());
      }
    }
    this.mRenderPaint.setStrokeWidth(paramIRadarDataSet.getLineWidth());
    this.mRenderPaint.setStyle(Paint.Style.STROKE);
    if ((!paramIRadarDataSet.isDrawFilledEnabled()) || (paramIRadarDataSet.getFillAlpha() < 255)) {
      paramCanvas.drawPath(localPath, this.mRenderPaint);
    }
    MPPointF.recycleInstance(localMPPointF1);
    MPPointF.recycleInstance(localMPPointF2);
  }
  
  public void drawExtras(Canvas paramCanvas)
  {
    drawWeb(paramCanvas);
  }
  
  public void drawHighlightCircle(Canvas paramCanvas, MPPointF paramMPPointF, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    paramCanvas.save();
    paramFloat2 = Utils.convertDpToPixel(paramFloat2);
    paramFloat1 = Utils.convertDpToPixel(paramFloat1);
    if (paramInt1 != 1122867)
    {
      Path localPath = this.mDrawHighlightCirclePathBuffer;
      localPath.reset();
      localPath.addCircle(paramMPPointF.x, paramMPPointF.y, paramFloat2, Path.Direction.CW);
      if (paramFloat1 > 0.0F) {
        localPath.addCircle(paramMPPointF.x, paramMPPointF.y, paramFloat1, Path.Direction.CCW);
      }
      this.mHighlightCirclePaint.setColor(paramInt1);
      this.mHighlightCirclePaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(localPath, this.mHighlightCirclePaint);
    }
    if (paramInt2 != 1122867)
    {
      this.mHighlightCirclePaint.setColor(paramInt2);
      this.mHighlightCirclePaint.setStyle(Paint.Style.STROKE);
      this.mHighlightCirclePaint.setStrokeWidth(Utils.convertDpToPixel(paramFloat3));
      paramCanvas.drawCircle(paramMPPointF.x, paramMPPointF.y, paramFloat2, this.mHighlightCirclePaint);
    }
    paramCanvas.restore();
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    float f1 = this.mChart.getSliceAngle();
    float f2 = this.mChart.getFactor();
    MPPointF localMPPointF1 = this.mChart.getCenterOffsets();
    MPPointF localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
    RadarData localRadarData = (RadarData)this.mChart.getData();
    int i = paramArrayOfHighlight.length;
    for (int j = 0; j < i; j++)
    {
      Highlight localHighlight = paramArrayOfHighlight[j];
      IRadarDataSet localIRadarDataSet = (IRadarDataSet)localRadarData.getDataSetByIndex(localHighlight.getDataSetIndex());
      if ((localIRadarDataSet != null) && (localIRadarDataSet.isHighlightEnabled()))
      {
        RadarEntry localRadarEntry = (RadarEntry)localIRadarDataSet.getEntryForIndex((int)localHighlight.getX());
        if (isInBoundsX(localRadarEntry, localIRadarDataSet))
        {
          Utils.getPosition(localMPPointF1, (localRadarEntry.getY() - this.mChart.getYChartMin()) * f2 * this.mAnimator.getPhaseY(), localHighlight.getX() * f1 * this.mAnimator.getPhaseX() + this.mChart.getRotationAngle(), localMPPointF2);
          localHighlight.setDraw(localMPPointF2.x, localMPPointF2.y);
          drawHighlightLines(paramCanvas, localMPPointF2.x, localMPPointF2.y, localIRadarDataSet);
          if ((localIRadarDataSet.isDrawHighlightCircleEnabled()) && (!Float.isNaN(localMPPointF2.x)) && (!Float.isNaN(localMPPointF2.y)))
          {
            int k = localIRadarDataSet.getHighlightCircleStrokeColor();
            int m = k;
            if (k == 1122867) {
              m = localIRadarDataSet.getColor(0);
            }
            k = m;
            if (localIRadarDataSet.getHighlightCircleStrokeAlpha() < 255) {
              k = ColorTemplate.colorWithAlpha(m, localIRadarDataSet.getHighlightCircleStrokeAlpha());
            }
            drawHighlightCircle(paramCanvas, localMPPointF2, localIRadarDataSet.getHighlightCircleInnerRadius(), localIRadarDataSet.getHighlightCircleOuterRadius(), localIRadarDataSet.getHighlightCircleFillColor(), k, localIRadarDataSet.getHighlightCircleStrokeWidth());
          }
        }
      }
    }
    MPPointF.recycleInstance(localMPPointF1);
    MPPointF.recycleInstance(localMPPointF2);
  }
  
  public void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.mValuePaint.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.mValuePaint);
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    float f1 = this.mAnimator.getPhaseX();
    float f2 = this.mAnimator.getPhaseY();
    float f3 = this.mChart.getSliceAngle();
    float f4 = this.mChart.getFactor();
    MPPointF localMPPointF1 = this.mChart.getCenterOffsets();
    MPPointF localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
    MPPointF localMPPointF3 = MPPointF.getInstance(0.0F, 0.0F);
    float f5 = Utils.convertDpToPixel(5.0F);
    for (int i = 0; i < ((RadarData)this.mChart.getData()).getDataSetCount(); i++)
    {
      IRadarDataSet localIRadarDataSet = (IRadarDataSet)((RadarData)this.mChart.getData()).getDataSetByIndex(i);
      if (shouldDrawValues(localIRadarDataSet))
      {
        applyValueTextStyle(localIRadarDataSet);
        ValueFormatter localValueFormatter = localIRadarDataSet.getValueFormatter();
        MPPointF localMPPointF4 = MPPointF.getInstance(localIRadarDataSet.getIconsOffset());
        localMPPointF4.x = Utils.convertDpToPixel(localMPPointF4.x);
        localMPPointF4.y = Utils.convertDpToPixel(localMPPointF4.y);
        for (int j = 0; j < localIRadarDataSet.getEntryCount(); j++)
        {
          RadarEntry localRadarEntry = (RadarEntry)localIRadarDataSet.getEntryForIndex(j);
          float f6 = localRadarEntry.getY();
          float f7 = this.mChart.getYChartMin();
          float f8 = j * f3 * f1;
          Utils.getPosition(localMPPointF1, (f6 - f7) * f4 * f2, f8 + this.mChart.getRotationAngle(), localMPPointF2);
          if (localIRadarDataSet.isDrawValuesEnabled()) {
            drawValue(paramCanvas, localValueFormatter.getRadarLabel(localRadarEntry), localMPPointF2.x, localMPPointF2.y - f5, localIRadarDataSet.getValueTextColor(j));
          }
          if ((localRadarEntry.getIcon() != null) && (localIRadarDataSet.isDrawIconsEnabled()))
          {
            Drawable localDrawable = localRadarEntry.getIcon();
            Utils.getPosition(localMPPointF1, localRadarEntry.getY() * f4 * f2 + localMPPointF4.y, f8 + this.mChart.getRotationAngle(), localMPPointF3);
            f6 = localMPPointF3.y + localMPPointF4.x;
            localMPPointF3.y = f6;
            Utils.drawImage(paramCanvas, localDrawable, (int)localMPPointF3.x, (int)f6, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
          }
        }
        MPPointF.recycleInstance(localMPPointF4);
      }
    }
    MPPointF.recycleInstance(localMPPointF1);
    MPPointF.recycleInstance(localMPPointF2);
    MPPointF.recycleInstance(localMPPointF3);
  }
  
  protected void drawWeb(Canvas paramCanvas)
  {
    float f1 = this.mChart.getSliceAngle();
    float f2 = this.mChart.getFactor();
    float f3 = this.mChart.getRotationAngle();
    MPPointF localMPPointF1 = this.mChart.getCenterOffsets();
    this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
    this.mWebPaint.setColor(this.mChart.getWebColor());
    this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
    int i = this.mChart.getSkipWebLineCount();
    int j = ((IRadarDataSet)((RadarData)this.mChart.getData()).getMaxEntryCountSet()).getEntryCount();
    MPPointF localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
    int k = 0;
    while (k < j)
    {
      Utils.getPosition(localMPPointF1, this.mChart.getYRange() * f2, k * f1 + f3, localMPPointF2);
      paramCanvas.drawLine(localMPPointF1.x, localMPPointF1.y, localMPPointF2.x, localMPPointF2.y, this.mWebPaint);
      k += i + 1;
    }
    MPPointF.recycleInstance(localMPPointF2);
    this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
    this.mWebPaint.setColor(this.mChart.getWebColorInner());
    this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
    i = this.mChart.getYAxis().mEntryCount;
    localMPPointF2 = MPPointF.getInstance(0.0F, 0.0F);
    MPPointF localMPPointF3 = MPPointF.getInstance(0.0F, 0.0F);
    for (k = 0; k < i; k++)
    {
      j = 0;
      while (j < ((RadarData)this.mChart.getData()).getEntryCount())
      {
        float f4 = (this.mChart.getYAxis().mEntries[k] - this.mChart.getYChartMin()) * f2;
        Utils.getPosition(localMPPointF1, f4, j * f1 + f3, localMPPointF2);
        j++;
        Utils.getPosition(localMPPointF1, f4, j * f1 + f3, localMPPointF3);
        paramCanvas.drawLine(localMPPointF2.x, localMPPointF2.y, localMPPointF3.x, localMPPointF3.y, this.mWebPaint);
      }
    }
    MPPointF.recycleInstance(localMPPointF2);
    MPPointF.recycleInstance(localMPPointF3);
  }
  
  public Paint getWebPaint()
  {
    return this.mWebPaint;
  }
  
  public void initBuffers() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\RadarChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */