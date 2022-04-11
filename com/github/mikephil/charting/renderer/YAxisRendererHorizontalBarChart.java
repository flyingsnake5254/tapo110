package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererHorizontalBarChart
  extends YAxisRenderer
{
  protected Path mDrawZeroLinePathBuffer = new Path();
  protected float[] mRenderLimitLinesBuffer = new float[4];
  protected Path mRenderLimitLinesPathBuffer = new Path();
  
  public YAxisRendererHorizontalBarChart(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramYAxis, paramTransformer);
    this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
  }
  
  public void computeAxis(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (this.mViewPortHandler.contentHeight() > 10.0F)
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (!this.mViewPortHandler.isFullyZoomedOutX())
      {
        MPPointD localMPPointD1 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        MPPointD localMPPointD2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
        double d;
        if (!paramBoolean)
        {
          paramFloat1 = (float)localMPPointD1.x;
          d = localMPPointD2.x;
        }
        else
        {
          paramFloat1 = (float)localMPPointD2.x;
          d = localMPPointD1.x;
        }
        f2 = (float)d;
        MPPointD.recycleInstance(localMPPointD1);
        MPPointD.recycleInstance(localMPPointD2);
        f1 = paramFloat1;
      }
    }
    computeAxisValues(f1, f2);
  }
  
  protected void drawYLabels(Canvas paramCanvas, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2)
  {
    this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
    this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
    this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
    int i = this.mYAxis.isDrawBottomYLabelEntryEnabled() ^ true;
    int j;
    if (this.mYAxis.isDrawTopYLabelEntryEnabled()) {
      j = this.mYAxis.mEntryCount;
    } else {
      j = this.mYAxis.mEntryCount - 1;
    }
    while (i < j)
    {
      paramCanvas.drawText(this.mYAxis.getFormattedLabel(i), paramArrayOfFloat[(i * 2)], paramFloat1 - paramFloat2, this.mAxisLabelPaint);
      i++;
    }
  }
  
  protected void drawZeroLine(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
    this.mZeroLineClippingRect.inset(-this.mYAxis.getZeroLineWidth(), 0.0F);
    paramCanvas.clipRect(this.mLimitLineClippingRect);
    MPPointD localMPPointD = this.mTrans.getPixelForValues(0.0F, 0.0F);
    this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
    this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
    Path localPath = this.mDrawZeroLinePathBuffer;
    localPath.reset();
    localPath.moveTo((float)localMPPointD.x - 1.0F, this.mViewPortHandler.contentTop());
    localPath.lineTo((float)localMPPointD.x - 1.0F, this.mViewPortHandler.contentBottom());
    paramCanvas.drawPath(localPath, this.mZeroLinePaint);
    paramCanvas.restoreToCount(i);
  }
  
  public RectF getGridClippingRect()
  {
    this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
    this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0F);
    return this.mGridClippingRect;
  }
  
  protected float[] getTransformedPositions()
  {
    int i = this.mGetTransformedPositionsBuffer.length;
    int j = this.mYAxis.mEntryCount;
    if (i != j * 2) {
      this.mGetTransformedPositionsBuffer = new float[j * 2];
    }
    float[] arrayOfFloat = this.mGetTransformedPositionsBuffer;
    for (i = 0; i < arrayOfFloat.length; i += 2) {
      arrayOfFloat[i] = this.mYAxis.mEntries[(i / 2)];
    }
    this.mTrans.pointValuesToPixel(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected Path linePath(Path paramPath, int paramInt, float[] paramArrayOfFloat)
  {
    paramPath.moveTo(paramArrayOfFloat[paramInt], this.mViewPortHandler.contentTop());
    paramPath.lineTo(paramArrayOfFloat[paramInt], this.mViewPortHandler.contentBottom());
    return paramPath;
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if ((this.mYAxis.isEnabled()) && (this.mYAxis.isDrawLabelsEnabled()))
    {
      float[] arrayOfFloat = getTransformedPositions();
      this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
      this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
      this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
      this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
      float f1 = Utils.convertDpToPixel(2.5F);
      float f2 = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
      YAxis.AxisDependency localAxisDependency = this.mYAxis.getAxisDependency();
      YAxis.YAxisLabelPosition localYAxisLabelPosition = this.mYAxis.getLabelPosition();
      float f3;
      if (localAxisDependency == YAxis.AxisDependency.LEFT)
      {
        if (localYAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
          f3 = this.mViewPortHandler.contentTop();
        } else {
          f3 = this.mViewPortHandler.contentTop();
        }
        f3 -= f1;
      }
      else
      {
        if (localYAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
          f3 = this.mViewPortHandler.contentBottom();
        } else {
          f3 = this.mViewPortHandler.contentBottom();
        }
        f3 = f3 + f2 + f1;
      }
      drawYLabels(paramCanvas, f3, arrayOfFloat, this.mYAxis.getYOffset());
    }
  }
  
  public void renderAxisLine(Canvas paramCanvas)
  {
    if ((this.mYAxis.isEnabled()) && (this.mYAxis.isDrawAxisLineEnabled()))
    {
      this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
      this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
      if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
        paramCanvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
      } else {
        paramCanvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
      }
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = this.mYAxis.getLimitLines();
    if ((localList != null) && (localList.size() > 0))
    {
      float[] arrayOfFloat = this.mRenderLimitLinesBuffer;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = 0.0F;
      arrayOfFloat[3] = 0.0F;
      Path localPath = this.mRenderLimitLinesPathBuffer;
      localPath.reset();
      for (int i = 0; i < localList.size(); i++)
      {
        Object localObject = (LimitLine)localList.get(i);
        if (((ComponentBase)localObject).isEnabled())
        {
          int j = paramCanvas.save();
          this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
          this.mLimitLineClippingRect.inset(-((LimitLine)localObject).getLineWidth(), 0.0F);
          paramCanvas.clipRect(this.mLimitLineClippingRect);
          arrayOfFloat[0] = ((LimitLine)localObject).getLimit();
          arrayOfFloat[2] = ((LimitLine)localObject).getLimit();
          this.mTrans.pointValuesToPixel(arrayOfFloat);
          arrayOfFloat[1] = this.mViewPortHandler.contentTop();
          arrayOfFloat[3] = this.mViewPortHandler.contentBottom();
          localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
          localPath.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
          this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
          this.mLimitLinePaint.setColor(((LimitLine)localObject).getLineColor());
          this.mLimitLinePaint.setPathEffect(((LimitLine)localObject).getDashPathEffect());
          this.mLimitLinePaint.setStrokeWidth(((LimitLine)localObject).getLineWidth());
          paramCanvas.drawPath(localPath, this.mLimitLinePaint);
          localPath.reset();
          String str = ((LimitLine)localObject).getLabel();
          if ((str != null) && (!str.equals("")))
          {
            this.mLimitLinePaint.setStyle(((LimitLine)localObject).getTextStyle());
            this.mLimitLinePaint.setPathEffect(null);
            this.mLimitLinePaint.setColor(((ComponentBase)localObject).getTextColor());
            this.mLimitLinePaint.setTypeface(((ComponentBase)localObject).getTypeface());
            this.mLimitLinePaint.setStrokeWidth(0.5F);
            this.mLimitLinePaint.setTextSize(((ComponentBase)localObject).getTextSize());
            float f1 = ((LimitLine)localObject).getLineWidth() + ((ComponentBase)localObject).getXOffset();
            float f2 = Utils.convertDpToPixel(2.0F) + ((ComponentBase)localObject).getYOffset();
            localObject = ((LimitLine)localObject).getLabelPosition();
            float f3;
            if (localObject == LimitLine.LimitLabelPosition.RIGHT_TOP)
            {
              f3 = Utils.calcTextHeight(this.mLimitLinePaint, str);
              this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, arrayOfFloat[0] + f1, this.mViewPortHandler.contentTop() + f2 + f3, this.mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.RIGHT_BOTTOM)
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, arrayOfFloat[0] + f1, this.mViewPortHandler.contentBottom() - f2, this.mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.LEFT_TOP)
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              f3 = Utils.calcTextHeight(this.mLimitLinePaint, str);
              paramCanvas.drawText(str, arrayOfFloat[0] - f1, this.mViewPortHandler.contentTop() + f2 + f3, this.mLimitLinePaint);
            }
            else
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, arrayOfFloat[0] - f1, this.mViewPortHandler.contentBottom() - f2, this.mLimitLinePaint);
            }
          }
          paramCanvas.restoreToCount(j);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\YAxisRendererHorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */