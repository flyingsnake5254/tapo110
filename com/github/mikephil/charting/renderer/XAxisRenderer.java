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

public class XAxisRenderer
  extends AxisRenderer
{
  protected RectF mGridClippingRect = new RectF();
  protected RectF mLimitLineClippingRect = new RectF();
  private Path mLimitLinePath = new Path();
  float[] mLimitLineSegmentsBuffer = new float[4];
  protected float[] mRenderGridLinesBuffer = new float[2];
  protected Path mRenderGridLinesPath = new Path();
  protected float[] mRenderLimitLinesBuffer = new float[2];
  protected XAxis mXAxis;
  
  public XAxisRenderer(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramTransformer, paramXAxis);
    this.mXAxis = paramXAxis;
    this.mAxisLabelPaint.setColor(-16777216);
    this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
    this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0F));
  }
  
  public void computeAxis(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (this.mViewPortHandler.contentWidth() > 10.0F)
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (!this.mViewPortHandler.isFullyZoomedOutX())
      {
        MPPointD localMPPointD1 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        MPPointD localMPPointD2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
        double d;
        if (paramBoolean)
        {
          paramFloat1 = (float)localMPPointD2.x;
          d = localMPPointD1.x;
        }
        else
        {
          paramFloat1 = (float)localMPPointD1.x;
          d = localMPPointD2.x;
        }
        f2 = (float)d;
        MPPointD.recycleInstance(localMPPointD1);
        MPPointD.recycleInstance(localMPPointD2);
        f1 = paramFloat1;
      }
    }
    computeAxisValues(f1, f2);
  }
  
  protected void computeAxisValues(float paramFloat1, float paramFloat2)
  {
    super.computeAxisValues(paramFloat1, paramFloat2);
    computeSize();
  }
  
  protected void computeSize()
  {
    Object localObject = this.mXAxis.getLongestLabel();
    this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
    this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
    FSize localFSize = Utils.calcTextSize(this.mAxisLabelPaint, (String)localObject);
    float f1 = localFSize.width;
    float f2 = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
    localObject = Utils.getSizeOfRotatedRectangleByDegrees(f1, f2, this.mXAxis.getLabelRotationAngle());
    this.mXAxis.mLabelWidth = Math.round(f1);
    this.mXAxis.mLabelHeight = Math.round(f2);
    this.mXAxis.mLabelRotatedWidth = Math.round(((FSize)localObject).width);
    this.mXAxis.mLabelRotatedHeight = Math.round(((FSize)localObject).height);
    FSize.recycleInstance((FSize)localObject);
    FSize.recycleInstance(localFSize);
  }
  
  protected void drawGridLine(Canvas paramCanvas, float paramFloat1, float paramFloat2, Path paramPath)
  {
    paramPath.moveTo(paramFloat1, this.mViewPortHandler.contentBottom());
    paramPath.lineTo(paramFloat1, this.mViewPortHandler.contentTop());
    paramCanvas.drawPath(paramPath, this.mGridPaint);
    paramPath.reset();
  }
  
  protected void drawLabel(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, MPPointF paramMPPointF, float paramFloat3)
  {
    Utils.drawXAxisValue(paramCanvas, paramString, paramFloat1, paramFloat2, this.mAxisLabelPaint, paramMPPointF, paramFloat3);
  }
  
  protected void drawLabels(Canvas paramCanvas, float paramFloat, MPPointF paramMPPointF)
  {
    float f1 = this.mXAxis.getLabelRotationAngle();
    boolean bool = this.mXAxis.isCenterAxisLabelsEnabled();
    int i = this.mXAxis.mEntryCount * 2;
    float[] arrayOfFloat = new float[i];
    for (int j = 0; j < i; j += 2) {
      if (bool) {
        arrayOfFloat[j] = this.mXAxis.mCenteredEntries[(j / 2)];
      } else {
        arrayOfFloat[j] = this.mXAxis.mEntries[(j / 2)];
      }
    }
    this.mTrans.pointValuesToPixel(arrayOfFloat);
    for (j = 0; j < i; j += 2)
    {
      float f2 = arrayOfFloat[j];
      if (this.mViewPortHandler.isInBoundsX(f2))
      {
        ValueFormatter localValueFormatter = this.mXAxis.getValueFormatter();
        XAxis localXAxis = this.mXAxis;
        Object localObject = localXAxis.mEntries;
        int k = j / 2;
        localObject = localValueFormatter.getAxisLabel(localObject[k], localXAxis);
        float f3 = f2;
        if (this.mXAxis.isAvoidFirstLastClippingEnabled())
        {
          int m = this.mXAxis.mEntryCount;
          if ((k == m - 1) && (m > 1))
          {
            float f4 = Utils.calcTextWidth(this.mAxisLabelPaint, (String)localObject);
            f3 = f2;
            if (f4 > this.mViewPortHandler.offsetRight() * 2.0F)
            {
              f3 = f2;
              if (f2 + f4 > this.mViewPortHandler.getChartWidth()) {
                f3 = f2 - f4 / 2.0F;
              }
            }
          }
          else
          {
            f3 = f2;
            if (j == 0) {
              f3 = f2 + Utils.calcTextWidth(this.mAxisLabelPaint, (String)localObject) / 2.0F;
            }
          }
        }
        drawLabel(paramCanvas, (String)localObject, f3, paramFloat, paramMPPointF, f1);
      }
    }
  }
  
  public RectF getGridClippingRect()
  {
    this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
    this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0F);
    return this.mGridClippingRect;
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if ((this.mXAxis.isEnabled()) && (this.mXAxis.isDrawLabelsEnabled()))
    {
      float f = this.mXAxis.getYOffset();
      this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
      this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
      this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
      MPPointF localMPPointF = MPPointF.getInstance(0.0F, 0.0F);
      if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP)
      {
        localMPPointF.x = 0.5F;
        localMPPointF.y = 1.0F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentTop() - f, localMPPointF);
      }
      else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE)
      {
        localMPPointF.x = 0.5F;
        localMPPointF.y = 1.0F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentTop() + f + this.mXAxis.mLabelRotatedHeight, localMPPointF);
      }
      else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
      {
        localMPPointF.x = 0.5F;
        localMPPointF.y = 0.0F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentBottom() + f, localMPPointF);
      }
      else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE)
      {
        localMPPointF.x = 0.5F;
        localMPPointF.y = 0.0F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentBottom() - f - this.mXAxis.mLabelRotatedHeight, localMPPointF);
      }
      else
      {
        localMPPointF.x = 0.5F;
        localMPPointF.y = 1.0F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentTop() - f, localMPPointF);
        localMPPointF.x = 0.5F;
        localMPPointF.y = 0.0F;
        drawLabels(paramCanvas, this.mViewPortHandler.contentBottom() + f, localMPPointF);
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
      this.mAxisLinePaint.setPathEffect(this.mXAxis.getAxisLineDashPathEffect());
      if ((this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
      }
      if ((this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) || (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
      }
    }
  }
  
  public void renderGridLines(Canvas paramCanvas)
  {
    if ((this.mXAxis.isDrawGridLinesEnabled()) && (this.mXAxis.isEnabled()))
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getGridClippingRect());
      if (this.mRenderGridLinesBuffer.length != this.mAxis.mEntryCount * 2) {
        this.mRenderGridLinesBuffer = new float[this.mXAxis.mEntryCount * 2];
      }
      float[] arrayOfFloat = this.mRenderGridLinesBuffer;
      int j = 0;
      for (int k = 0; k < arrayOfFloat.length; k += 2)
      {
        localObject = this.mXAxis.mEntries;
        int m = k / 2;
        arrayOfFloat[k] = localObject[m];
        arrayOfFloat[(k + 1)] = localObject[m];
      }
      this.mTrans.pointValuesToPixel(arrayOfFloat);
      setupGridPaint();
      Object localObject = this.mRenderGridLinesPath;
      ((Path)localObject).reset();
      for (k = j; k < arrayOfFloat.length; k += 2) {
        drawGridLine(paramCanvas, arrayOfFloat[k], arrayOfFloat[(k + 1)], (Path)localObject);
      }
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void renderLimitLineLabel(Canvas paramCanvas, LimitLine paramLimitLine, float[] paramArrayOfFloat, float paramFloat)
  {
    String str = paramLimitLine.getLabel();
    if ((str != null) && (!str.equals("")))
    {
      this.mLimitLinePaint.setStyle(paramLimitLine.getTextStyle());
      this.mLimitLinePaint.setPathEffect(null);
      this.mLimitLinePaint.setColor(paramLimitLine.getTextColor());
      this.mLimitLinePaint.setStrokeWidth(0.5F);
      this.mLimitLinePaint.setTextSize(paramLimitLine.getTextSize());
      float f1 = paramLimitLine.getLineWidth() + paramLimitLine.getXOffset();
      paramLimitLine = paramLimitLine.getLabelPosition();
      float f2;
      if (paramLimitLine == LimitLine.LimitLabelPosition.RIGHT_TOP)
      {
        f2 = Utils.calcTextHeight(this.mLimitLinePaint, str);
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(str, paramArrayOfFloat[0] + f1, this.mViewPortHandler.contentTop() + paramFloat + f2, this.mLimitLinePaint);
      }
      else if (paramLimitLine == LimitLine.LimitLabelPosition.RIGHT_BOTTOM)
      {
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(str, paramArrayOfFloat[0] + f1, this.mViewPortHandler.contentBottom() - paramFloat, this.mLimitLinePaint);
      }
      else if (paramLimitLine == LimitLine.LimitLabelPosition.LEFT_TOP)
      {
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        f2 = Utils.calcTextHeight(this.mLimitLinePaint, str);
        paramCanvas.drawText(str, paramArrayOfFloat[0] - f1, this.mViewPortHandler.contentTop() + paramFloat + f2, this.mLimitLinePaint);
      }
      else
      {
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(str, paramArrayOfFloat[0] - f1, this.mViewPortHandler.contentBottom() - paramFloat, this.mLimitLinePaint);
      }
    }
  }
  
  public void renderLimitLineLine(Canvas paramCanvas, LimitLine paramLimitLine, float[] paramArrayOfFloat)
  {
    Object localObject = this.mLimitLineSegmentsBuffer;
    localObject[0] = paramArrayOfFloat[0];
    localObject[1] = this.mViewPortHandler.contentTop();
    localObject = this.mLimitLineSegmentsBuffer;
    localObject[2] = paramArrayOfFloat[0];
    localObject[3] = this.mViewPortHandler.contentBottom();
    this.mLimitLinePath.reset();
    localObject = this.mLimitLinePath;
    paramArrayOfFloat = this.mLimitLineSegmentsBuffer;
    ((Path)localObject).moveTo(paramArrayOfFloat[0], paramArrayOfFloat[1]);
    paramArrayOfFloat = this.mLimitLinePath;
    localObject = this.mLimitLineSegmentsBuffer;
    paramArrayOfFloat.lineTo(localObject[2], localObject[3]);
    this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
    this.mLimitLinePaint.setColor(paramLimitLine.getLineColor());
    this.mLimitLinePaint.setStrokeWidth(paramLimitLine.getLineWidth());
    this.mLimitLinePaint.setPathEffect(paramLimitLine.getDashPathEffect());
    paramCanvas.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = this.mXAxis.getLimitLines();
    if ((localList != null) && (localList.size() > 0))
    {
      float[] arrayOfFloat = this.mRenderLimitLinesBuffer;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      for (int i = 0; i < localList.size(); i++)
      {
        LimitLine localLimitLine = (LimitLine)localList.get(i);
        if (localLimitLine.isEnabled())
        {
          int j = paramCanvas.save();
          this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
          this.mLimitLineClippingRect.inset(-localLimitLine.getLineWidth(), 0.0F);
          paramCanvas.clipRect(this.mLimitLineClippingRect);
          arrayOfFloat[0] = localLimitLine.getLimit();
          arrayOfFloat[1] = 0.0F;
          this.mTrans.pointValuesToPixel(arrayOfFloat);
          renderLimitLineLine(paramCanvas, localLimitLine, arrayOfFloat);
          renderLimitLineLabel(paramCanvas, localLimitLine, arrayOfFloat, localLimitLine.getYOffset() + 2.0F);
          paramCanvas.restoreToCount(j);
        }
      }
    }
  }
  
  protected void setupGridPaint()
  {
    this.mGridPaint.setColor(this.mXAxis.getGridColor());
    this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
    this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\XAxisRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */