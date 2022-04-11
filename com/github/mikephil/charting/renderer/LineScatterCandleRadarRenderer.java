package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineScatterCandleRadarRenderer
  extends BarLineScatterCandleBubbleRenderer
{
  private Path mHighlightLinePath = new Path();
  
  public LineScatterCandleRadarRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  protected void drawHighlightLines(Canvas paramCanvas, float paramFloat1, float paramFloat2, ILineScatterCandleRadarDataSet paramILineScatterCandleRadarDataSet)
  {
    this.mHighlightPaint.setColor(paramILineScatterCandleRadarDataSet.getHighLightColor());
    this.mHighlightPaint.setStrokeWidth(paramILineScatterCandleRadarDataSet.getHighlightLineWidth());
    this.mHighlightPaint.setPathEffect(paramILineScatterCandleRadarDataSet.getDashPathEffectHighlight());
    if (paramILineScatterCandleRadarDataSet.isVerticalHighlightIndicatorEnabled())
    {
      this.mHighlightLinePath.reset();
      this.mHighlightLinePath.moveTo(paramFloat1, this.mViewPortHandler.contentTop());
      this.mHighlightLinePath.lineTo(paramFloat1, this.mViewPortHandler.contentBottom());
      paramCanvas.drawPath(this.mHighlightLinePath, this.mHighlightPaint);
    }
    if (paramILineScatterCandleRadarDataSet.isHorizontalHighlightIndicatorEnabled())
    {
      this.mHighlightLinePath.reset();
      this.mHighlightLinePath.moveTo(this.mViewPortHandler.contentLeft(), paramFloat2);
      this.mHighlightLinePath.lineTo(this.mViewPortHandler.contentRight(), paramFloat2);
      paramCanvas.drawPath(this.mHighlightLinePath, this.mHighlightPaint);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\renderer\LineScatterCandleRadarRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */