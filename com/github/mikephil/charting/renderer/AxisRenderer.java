package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AxisRenderer
  extends Renderer
{
  protected AxisBase mAxis;
  protected Paint mAxisLabelPaint;
  protected Paint mAxisLinePaint;
  protected Paint mGridPaint;
  protected Paint mLimitLinePaint;
  protected Transformer mTrans;
  
  public AxisRenderer(ViewPortHandler paramViewPortHandler, Transformer paramTransformer, AxisBase paramAxisBase)
  {
    super(paramViewPortHandler);
    this.mTrans = paramTransformer;
    this.mAxis = paramAxisBase;
    if (this.mViewPortHandler != null)
    {
      this.mAxisLabelPaint = new Paint(1);
      paramViewPortHandler = new Paint();
      this.mGridPaint = paramViewPortHandler;
      paramViewPortHandler.setColor(-7829368);
      this.mGridPaint.setStrokeWidth(1.0F);
      this.mGridPaint.setStyle(Paint.Style.STROKE);
      this.mGridPaint.setAlpha(90);
      paramViewPortHandler = new Paint();
      this.mAxisLinePaint = paramViewPortHandler;
      paramViewPortHandler.setColor(-16777216);
      this.mAxisLinePaint.setStrokeWidth(1.0F);
      this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
      paramViewPortHandler = new Paint(1);
      this.mLimitLinePaint = paramViewPortHandler;
      paramViewPortHandler.setStyle(Paint.Style.STROKE);
    }
  }
  
  public void computeAxis(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    Object localObject = this.mViewPortHandler;
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (localObject != null)
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (((ViewPortHandler)localObject).contentWidth() > 10.0F)
      {
        f1 = paramFloat1;
        f2 = paramFloat2;
        if (!this.mViewPortHandler.isFullyZoomedOutY())
        {
          MPPointD localMPPointD = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
          localObject = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
          double d;
          if (!paramBoolean)
          {
            paramFloat1 = (float)((MPPointD)localObject).y;
            d = localMPPointD.y;
          }
          else
          {
            paramFloat1 = (float)localMPPointD.y;
            d = ((MPPointD)localObject).y;
          }
          f2 = (float)d;
          MPPointD.recycleInstance(localMPPointD);
          MPPointD.recycleInstance((MPPointD)localObject);
          f1 = paramFloat1;
        }
      }
    }
    computeAxisValues(f1, f2);
  }
  
  protected void computeAxisValues(float paramFloat1, float paramFloat2)
  {
    int i = this.mAxis.getLabelCount();
    double d1 = Math.abs(paramFloat2 - paramFloat1);
    if ((i != 0) && (d1 > 0.0D) && (!Double.isInfinite(d1)))
    {
      double d2 = Utils.roundToNextSignificant(d1 / i);
      double d3 = d2;
      if (this.mAxis.isGranularityEnabled())
      {
        d3 = d2;
        if (d2 < this.mAxis.getGranularity()) {
          d3 = this.mAxis.getGranularity();
        }
      }
      double d4 = Utils.roundToNextSignificant(Math.pow(10.0D, (int)Math.log10(d3)));
      d2 = d3;
      if ((int)(d3 / d4) > 5) {
        d2 = Math.floor(d4 * 10.0D);
      }
      int j = this.mAxis.isCenterAxisLabelsEnabled();
      if (this.mAxis.isForceLabelsEnabled())
      {
        d3 = (float)d1 / (i - 1);
        localAxisBase = this.mAxis;
        localAxisBase.mEntryCount = i;
        if (localAxisBase.mEntries.length < i) {
          localAxisBase.mEntries = new float[i];
        }
        for (j = 0;; j++)
        {
          m = i;
          d2 = d3;
          if (j >= i) {
            break;
          }
          this.mAxis.mEntries[j] = paramFloat1;
          paramFloat1 = (float)(paramFloat1 + d3);
        }
      }
      boolean bool = d2 < 0.0D;
      if (!bool) {
        d1 = 0.0D;
      } else {
        d1 = Math.ceil(paramFloat1 / d2) * d2;
      }
      d3 = d1;
      if (this.mAxis.isCenterAxisLabelsEnabled()) {
        d3 = d1 - d2;
      }
      if (!bool) {
        d1 = 0.0D;
      } else {
        d1 = Utils.nextUp(Math.floor(paramFloat2 / d2) * d2);
      }
      int m = j;
      if (bool) {
        for (d4 = d3;; d4 += d2)
        {
          m = j;
          if (d4 > d1) {
            break;
          }
          j++;
        }
      }
      localAxisBase = this.mAxis;
      localAxisBase.mEntryCount = m;
      if (localAxisBase.mEntries.length < m) {
        localAxisBase.mEntries = new float[m];
      }
      for (int k = 0; k < m; k++)
      {
        d1 = d3;
        if (d3 == 0.0D) {
          d1 = 0.0D;
        }
        this.mAxis.mEntries[k] = ((float)d1);
        d3 = d1 + d2;
      }
      if (d2 < 1.0D) {
        this.mAxis.mDecimals = ((int)Math.ceil(-Math.log10(d2)));
      } else {
        this.mAxis.mDecimals = 0;
      }
      if (this.mAxis.isCenterAxisLabelsEnabled())
      {
        localAxisBase = this.mAxis;
        if (localAxisBase.mCenteredEntries.length < m) {
          localAxisBase.mCenteredEntries = new float[m];
        }
        paramFloat1 = (float)d2 / 2.0F;
        for (k = 0; k < m; k++)
        {
          localAxisBase = this.mAxis;
          localAxisBase.mCenteredEntries[k] = (localAxisBase.mEntries[k] + paramFloat1);
        }
      }
      return;
    }
    AxisBase localAxisBase = this.mAxis;
    localAxisBase.mEntries = new float[0];
    localAxisBase.mCenteredEntries = new float[0];
    localAxisBase.mEntryCount = 0;
  }
  
  public Paint getPaintAxisLabels()
  {
    return this.mAxisLabelPaint;
  }
  
  public Paint getPaintAxisLine()
  {
    return this.mAxisLinePaint;
  }
  
  public Paint getPaintGrid()
  {
    return this.mGridPaint;
  }
  
  public Transformer getTransformer()
  {
    return this.mTrans;
  }
  
  public abstract void renderAxisLabels(Canvas paramCanvas);
  
  public abstract void renderAxisLine(Canvas paramCanvas);
  
  public abstract void renderGridLines(Canvas paramCanvas);
  
  public abstract void renderLimitLines(Canvas paramCanvas);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\AxisRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */