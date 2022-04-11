package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRendererHorizontalBarChart
  extends XAxisRenderer
{
  protected BarChart mChart;
  protected Path mRenderLimitLinesPathBuffer = new Path();
  
  public XAxisRendererHorizontalBarChart(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, Transformer paramTransformer, BarChart paramBarChart)
  {
    super(paramViewPortHandler, paramXAxis, paramTransformer);
    this.mChart = paramBarChart;
  }
  
  public void computeAxis(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (this.mViewPortHandler.contentWidth() > 10.0F)
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (!this.mViewPortHandler.isFullyZoomedOutY())
      {
        MPPointD localMPPointD1 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
        MPPointD localMPPointD2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        double d;
        if (paramBoolean)
        {
          paramFloat1 = (float)localMPPointD2.y;
          d = localMPPointD1.y;
        }
        else
        {
          paramFloat1 = (float)localMPPointD1.y;
          d = localMPPointD2.y;
        }
        f2 = (float)d;
        MPPointD.recycleInstance(localMPPointD1);
        MPPointD.recycleInstance(localMPPointD2);
        f1 = paramFloat1;
      }
    }
    computeAxisValues(f1, f2);
  }
  
  protected void computeSize()
  {
    this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
    this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
    Object localObject = this.mXAxis.getLongestLabel();
    localObject = Utils.calcTextSize(this.mAxisLabelPaint, (String)localObject);
    float f1 = (int)(((FSize)localObject).width + this.mXAxis.getXOffset() * 3.5F);
    float f2 = ((FSize)localObject).height;
    localObject = Utils.getSizeOfRotatedRectangleByDegrees(((FSize)localObject).width, f2, this.mXAxis.getLabelRotationAngle());
    this.mXAxis.mLabelWidth = Math.round(f1);
    this.mXAxis.mLabelHeight = Math.round(f2);
    XAxis localXAxis = this.mXAxis;
    localXAxis.mLabelRotatedWidth = ((int)(((FSize)localObject).width + localXAxis.getXOffset() * 3.5F));
    this.mXAxis.mLabelRotatedHeight = Math.round(((FSize)localObject).height);
    FSize.recycleInstance((FSize)localObject);
  }
  
  protected void drawGridLine(Canvas paramCanvas, float paramFloat1, float paramFloat2, Path paramPath)
  {
    paramPath.moveTo(this.mViewPortHandler.contentRight(), paramFloat2);
    paramPath.lineTo(this.mViewPortHandler.contentLeft(), paramFloat2);
    paramCanvas.drawPath(paramPath, this.mGridPaint);
    paramPath.reset();
  }
  
  protected void drawLabels(Canvas paramCanvas, float paramFloat, MPPointF paramMPPointF)
  {
    float f1 = this.mXAxis.getLabelRotationAngle();
    boolean bool = this.mXAxis.isCenterAxisLabelsEnabled();
    int i = this.mXAxis.mEntryCount * 2;
    float[] arrayOfFloat = new float[i];
    for (int j = 0; j < i; j += 2) {
      if (bool) {
        arrayOfFloat[(j + 1)] = this.mXAxis.mCenteredEntries[(j / 2)];
      } else {
        arrayOfFloat[(j + 1)] = this.mXAxis.mEntries[(j / 2)];
      }
    }
    this.mTrans.pointValuesToPixel(arrayOfFloat);
    for (j = 0; j < i; j += 2)
    {
      float f2 = arrayOfFloat[(j + 1)];
      if (this.mViewPortHandler.isInBoundsY(f2))
      {
        ValueFormatter localValueFormatter = this.mXAxis.getValueFormatter();
        XAxis localXAxis = this.mXAxis;
        drawLabel(paramCanvas, localValueFormatter.getAxisLabel(localXAxis.mEntries[(j / 2)], localXAxis), paramFloat, f2, paramMPPointF, f1);
      }
    }
  }
  
  public RectF getGridClippingRect()
  {
    this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
    this.mGridClippingRect.inset(0.0F, -this.mAxis.getGridLineWidth());
    return this.mGridClippingRect;
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if ((this.mXAxis.isEnabled()) && (this.mXAxis.isDrawLabelsEnabled()))
    {
      float f = this.mXAxis.getXOffset();
      this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
      this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
      this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
      MPPointF localMPPointF = MPPointF.getInstance(0.0F, 0.0F);
      if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP)
      {
        localMPPointF.x = 0.0F;
        localMPPointF.y = 0.5F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentRight() + f, localMPPointF);
      }
      else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE)
      {
        localMPPointF.x = 1.0F;
        localMPPointF.y = 0.5F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentRight() - f, localMPPointF);
      }
      else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
      {
        localMPPointF.x = 1.0F;
        localMPPointF.y = 0.5F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentLeft() - f, localMPPointF);
      }
      else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE)
      {
        localMPPointF.x = 1.0F;
        localMPPointF.y = 0.5F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentLeft() + f, localMPPointF);
      }
      else
      {
        localMPPointF.x = 0.0F;
        localMPPointF.y = 0.5F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentRight() + f, localMPPointF);
        localMPPointF.x = 1.0F;
        localMPPointF.y = 0.5F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentLeft() - f, localMPPointF);
      }
      MPPointF.recycleInstance(localMPPointF);
    }
  }
  
  public void renderAxisLine(Canvas paramCanvas)
  {
    if ((this.mXAxis.isDrawAxisLineEnabled()) && (this.mXAxis.isEnabled()))
    {
      this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
      this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
      if ((this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
      }
      if ((this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
      }
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = this.mXAxis.getLimitLines();
    if ((localList != null) && (localList.size() > 0))
    {
      float[] arrayOfFloat = this.mRenderLimitLinesBuffer;
      int i = 0;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      Path localPath = this.mRenderLimitLinesPathBuffer;
      localPath.reset();
      while (i < localList.size())
      {
        Object localObject = (LimitLine)localList.get(i);
        if (((ComponentBase)localObject).isEnabled())
        {
          int j = paramCanvas.save();
          this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
          this.mLimitLineClippingRect.inset(0.0F, -((LimitLine)localObject).getLineWidth());
          paramCanvas.clipRect(this.mLimitLineClippingRect);
          this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
          this.mLimitLinePaint.setColor(((LimitLine)localObject).getLineColor());
          this.mLimitLinePaint.setStrokeWidth(((LimitLine)localObject).getLineWidth());
          this.mLimitLinePaint.setPathEffect(((LimitLine)localObject).getDashPathEffect());
          arrayOfFloat[1] = ((LimitLine)localObject).getLimit();
          this.mTrans.pointValuesToPixel(arrayOfFloat);
          localPath.moveTo(this.mViewPortHandler.contentLeft(), arrayOfFloat[1]);
          localPath.lineTo(this.mViewPortHandler.contentRight(), arrayOfFloat[1]);
          paramCanvas.drawPath(localPath, this.mLimitLinePaint);
          localPath.reset();
          String str = ((LimitLine)localObject).getLabel();
          if ((str != null) && (!str.equals("")))
          {
            this.mLimitLinePaint.setStyle(((LimitLine)localObject).getTextStyle());
            this.mLimitLinePaint.setPathEffect(null);
            this.mLimitLinePaint.setColor(((ComponentBase)localObject).getTextColor());
            this.mLimitLinePaint.setStrokeWidth(0.5F);
            this.mLimitLinePaint.setTextSize(((ComponentBase)localObject).getTextSize());
            float f1 = Utils.calcTextHeight(this.mLimitLinePaint, str);
            float f2 = Utils.convertDpToPixel(4.0F) + ((ComponentBase)localObject).getXOffset();
            float f3 = ((LimitLine)localObject).getLineWidth() + f1 + ((ComponentBase)localObject).getYOffset();
            localObject = ((LimitLine)localObject).getLabelPosition();
            if (localObject == LimitLine.LimitLabelPosition.RIGHT_TOP)
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, this.mViewPortHandler.contentRight() - f2, arrayOfFloat[1] - f3 + f1, this.mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.RIGHT_BOTTOM)
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, this.mViewPortHandler.contentRight() - f2, arrayOfFloat[1] + f3, this.mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.LEFT_TOP)
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, this.mViewPortHandler.contentLeft() + f2, arrayOfFloat[1] - f3 + f1, this.mLimitLinePaint);
            }
            else
            {
              this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, this.mViewPortHandler.offsetLeft() + f2, arrayOfFloat[1] + f3, this.mLimitLinePaint);
            }
          }
          paramCanvas.restoreToCount(j);
        }
        i++;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\XAxisRendererHorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */