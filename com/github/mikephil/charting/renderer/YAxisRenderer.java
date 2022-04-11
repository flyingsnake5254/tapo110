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

public class YAxisRenderer
  extends AxisRenderer
{
  protected Path mDrawZeroLinePath = new Path();
  protected float[] mGetTransformedPositionsBuffer = new float[2];
  protected RectF mGridClippingRect = new RectF();
  protected RectF mLimitLineClippingRect = new RectF();
  protected Path mRenderGridLinesPath = new Path();
  protected Path mRenderLimitLines = new Path();
  protected float[] mRenderLimitLinesBuffer = new float[2];
  protected YAxis mYAxis;
  protected RectF mZeroLineClippingRect = new RectF();
  protected Paint mZeroLinePaint;
  
  public YAxisRenderer(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramTransformer, paramYAxis);
    this.mYAxis = paramYAxis;
    if (this.mViewPortHandler != null)
    {
      this.mAxisLabelPaint.setColor(-16777216);
      this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0F));
      paramViewPortHandler = new Paint(1);
      this.mZeroLinePaint = paramViewPortHandler;
      paramViewPortHandler.setColor(-7829368);
      this.mZeroLinePaint.setStrokeWidth(1.0F);
      this.mZeroLinePaint.setStyle(Paint.Style.STROKE);
    }
  }
  
  protected void drawYLabels(Canvas paramCanvas, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2)
  {
    int i = this.mYAxis.isDrawBottomYLabelEntryEnabled() ^ true;
    int j;
    if (this.mYAxis.isDrawTopYLabelEntryEnabled()) {
      j = this.mYAxis.mEntryCount;
    } else {
      j = this.mYAxis.mEntryCount - 1;
    }
    while (i < j)
    {
      paramCanvas.drawText(this.mYAxis.getFormattedLabel(i), paramFloat1, paramArrayOfFloat[(i * 2 + 1)] + paramFloat2, this.mAxisLabelPaint);
      i++;
    }
  }
  
  protected void drawZeroLine(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
    this.mZeroLineClippingRect.inset(0.0F, -this.mYAxis.getZeroLineWidth());
    paramCanvas.clipRect(this.mZeroLineClippingRect);
    MPPointD localMPPointD = this.mTrans.getPixelForValues(0.0F, 0.0F);
    this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
    this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
    Path localPath = this.mDrawZeroLinePath;
    localPath.reset();
    localPath.moveTo(this.mViewPortHandler.contentLeft(), (float)localMPPointD.y);
    localPath.lineTo(this.mViewPortHandler.contentRight(), (float)localMPPointD.y);
    paramCanvas.drawPath(localPath, this.mZeroLinePaint);
    paramCanvas.restoreToCount(i);
  }
  
  public RectF getGridClippingRect()
  {
    this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
    this.mGridClippingRect.inset(0.0F, -this.mAxis.getGridLineWidth());
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
    for (j = 0; j < arrayOfFloat.length; j += 2) {
      arrayOfFloat[(j + 1)] = this.mYAxis.mEntries[(j / 2)];
    }
    this.mTrans.pointValuesToPixel(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected Path linePath(Path paramPath, int paramInt, float[] paramArrayOfFloat)
  {
    float f = this.mViewPortHandler.offsetLeft();
    paramInt++;
    paramPath.moveTo(f, paramArrayOfFloat[paramInt]);
    paramPath.lineTo(this.mViewPortHandler.contentRight(), paramArrayOfFloat[paramInt]);
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
      float f1 = this.mYAxis.getXOffset();
      float f2 = Utils.calcTextHeight(this.mAxisLabelPaint, "A") / 2.5F;
      float f3 = this.mYAxis.getYOffset();
      YAxis.AxisDependency localAxisDependency = this.mYAxis.getAxisDependency();
      YAxis.YAxisLabelPosition localYAxisLabelPosition = this.mYAxis.getLabelPosition();
      if (localAxisDependency == YAxis.AxisDependency.LEFT)
      {
        if (localYAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        {
          this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
          f4 = this.mViewPortHandler.offsetLeft();
          break label236;
        }
        this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
        f4 = this.mViewPortHandler.offsetLeft();
      }
      else
      {
        if (localYAxisLabelPosition != YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
          break label217;
        }
        this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
        f4 = this.mViewPortHandler.contentRight();
      }
      f4 += f1;
      break label242;
      label217:
      this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
      float f4 = this.mViewPortHandler.contentRight();
      label236:
      f4 -= f1;
      label242:
      drawYLabels(paramCanvas, f4, arrayOfFloat, f2 + f3);
    }
  }
  
  public void renderAxisLine(Canvas paramCanvas)
  {
    if ((this.mYAxis.isEnabled()) && (this.mYAxis.isDrawAxisLineEnabled()))
    {
      this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
      this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
      if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
        paramCanvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
      } else {
        paramCanvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
      }
    }
  }
  
  public void renderGridLines(Canvas paramCanvas)
  {
    if (!this.mYAxis.isEnabled()) {
      return;
    }
    if (this.mYAxis.isDrawGridLinesEnabled())
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getGridClippingRect());
      float[] arrayOfFloat = getTransformedPositions();
      this.mGridPaint.setColor(this.mYAxis.getGridColor());
      this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
      this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
      Path localPath = this.mRenderGridLinesPath;
      localPath.reset();
      for (int j = 0; j < arrayOfFloat.length; j += 2)
      {
        paramCanvas.drawPath(linePath(localPath, j, arrayOfFloat), this.mGridPaint);
        localPath.reset();
      }
      paramCanvas.restoreToCount(i);
    }
    if (this.mYAxis.isDrawZeroLineEnabled()) {
      drawZeroLine(paramCanvas);
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = this.mYAxis.getLimitLines();
    if ((localList != null) && (localList.size() > 0))
    {
      float[] arrayOfFloat = this.mRenderLimitLinesBuffer;
      int i = 0;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      Path localPath = this.mRenderLimitLines;
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
            this.mLimitLinePaint.setTypeface(((ComponentBase)localObject).getTypeface());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\YAxisRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */