package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class DataRenderer
  extends Renderer
{
  protected ChartAnimator mAnimator;
  protected Paint mDrawPaint;
  protected Paint mHighlightPaint;
  protected Paint mRenderPaint;
  protected Paint mValuePaint;
  
  public DataRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramViewPortHandler);
    this.mAnimator = paramChartAnimator;
    paramChartAnimator = new Paint(1);
    this.mRenderPaint = paramChartAnimator;
    paramChartAnimator.setStyle(Paint.Style.FILL);
    this.mDrawPaint = new Paint(4);
    paramChartAnimator = new Paint(1);
    this.mValuePaint = paramChartAnimator;
    paramChartAnimator.setColor(Color.rgb(63, 63, 63));
    this.mValuePaint.setTextAlign(Paint.Align.CENTER);
    this.mValuePaint.setTextSize(Utils.convertDpToPixel(9.0F));
    paramChartAnimator = new Paint(1);
    this.mHighlightPaint = paramChartAnimator;
    paramChartAnimator.setStyle(Paint.Style.STROKE);
    this.mHighlightPaint.setStrokeWidth(2.0F);
    this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
  }
  
  protected void applyValueTextStyle(IDataSet paramIDataSet)
  {
    this.mValuePaint.setTypeface(paramIDataSet.getValueTypeface());
    this.mValuePaint.setTextSize(paramIDataSet.getValueTextSize());
  }
  
  public abstract void drawData(Canvas paramCanvas);
  
  public abstract void drawExtras(Canvas paramCanvas);
  
  public abstract void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight);
  
  public abstract void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt);
  
  public abstract void drawValues(Canvas paramCanvas);
  
  public Paint getPaintHighlight()
  {
    return this.mHighlightPaint;
  }
  
  public Paint getPaintRender()
  {
    return this.mRenderPaint;
  }
  
  public Paint getPaintValues()
  {
    return this.mValuePaint;
  }
  
  public abstract void initBuffers();
  
  protected boolean isDrawingValuesAllowed(ChartInterface paramChartInterface)
  {
    boolean bool;
    if (paramChartInterface.getData().getEntryCount() < paramChartInterface.getMaxVisibleCount() * this.mViewPortHandler.getScaleX()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\DataRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */