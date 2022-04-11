package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class HorizontalBarChart
  extends BarChart
{
  protected float[] mGetPositionBuffer = new float[2];
  private RectF mOffsetsBuffer = new RectF();
  
  public HorizontalBarChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalBarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalBarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void calculateOffsets()
  {
    calculateLegendOffsets(this.mOffsetsBuffer);
    Object localObject = this.mOffsetsBuffer;
    float f1 = ((RectF)localObject).left + 0.0F;
    float f2 = ((RectF)localObject).top + 0.0F;
    float f3 = ((RectF)localObject).right + 0.0F;
    float f4 = ((RectF)localObject).bottom + 0.0F;
    float f5 = f2;
    if (this.mAxisLeft.needsOffset()) {
      f5 = f2 + this.mAxisLeft.getRequiredHeightSpace(this.mAxisRendererLeft.getPaintAxisLabels());
    }
    f2 = f4;
    if (this.mAxisRight.needsOffset()) {
      f2 = f4 + this.mAxisRight.getRequiredHeightSpace(this.mAxisRendererRight.getPaintAxisLabels());
    }
    localObject = this.mXAxis;
    float f6 = ((XAxis)localObject).mLabelRotatedWidth;
    f4 = f1;
    float f7 = f3;
    if (((ComponentBase)localObject).isEnabled()) {
      if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
      {
        f4 = f1 + f6;
        f7 = f3;
      }
      else
      {
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {}
        for (f4 = f1;; f4 = f1 + f6)
        {
          f7 = f3 + f6;
          break;
          f4 = f1;
          f7 = f3;
          if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) {
            break;
          }
        }
      }
    }
    f5 += getExtraTopOffset();
    f1 = f7 + getExtraRightOffset();
    f2 += getExtraBottomOffset();
    f7 = f4 + getExtraLeftOffset();
    f4 = Utils.convertDpToPixel(this.mMinOffset);
    this.mViewPortHandler.restrainViewPort(Math.max(f4, f7), Math.max(f4, f5), Math.max(f4, f1), Math.max(f4, f2));
    if (this.mLogEnabled)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("offsetLeft: ");
      ((StringBuilder)localObject).append(f7);
      ((StringBuilder)localObject).append(", offsetTop: ");
      ((StringBuilder)localObject).append(f5);
      ((StringBuilder)localObject).append(", offsetRight: ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", offsetBottom: ");
      ((StringBuilder)localObject).append(f2);
      Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Content: ");
      ((StringBuilder)localObject).append(this.mViewPortHandler.getContentRect().toString());
      Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
    }
    prepareOffsetMatrix();
    prepareValuePxMatrix();
  }
  
  public void getBarBounds(BarEntry paramBarEntry, RectF paramRectF)
  {
    IBarDataSet localIBarDataSet = (IBarDataSet)((BarData)this.mData).getDataSetForEntry(paramBarEntry);
    if (localIBarDataSet == null)
    {
      paramRectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
      return;
    }
    float f1 = paramBarEntry.getY();
    float f2 = paramBarEntry.getX();
    float f3 = ((BarData)this.mData).getBarWidth() / 2.0F;
    float f4;
    if (f1 >= 0.0F) {
      f4 = f1;
    } else {
      f4 = 0.0F;
    }
    if (f1 > 0.0F) {
      f1 = 0.0F;
    }
    paramRectF.set(f4, f2 - f3, f1, f2 + f3);
    getTransformer(localIBarDataSet.getAxisDependency()).rectValueToPixel(paramRectF);
  }
  
  public float getHighestVisibleX()
  {
    getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.posForGetHighestVisibleX);
    return (float)Math.min(this.mXAxis.mAxisMaximum, this.posForGetHighestVisibleX.y);
  }
  
  public Highlight getHighlightByTouchPoint(float paramFloat1, float paramFloat2)
  {
    if (this.mData == null)
    {
      if (this.mLogEnabled) {
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
      }
      return null;
    }
    return getHighlighter().getHighlight(paramFloat2, paramFloat1);
  }
  
  public float getLowestVisibleX()
  {
    getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.posForGetLowestVisibleX);
    return (float)Math.max(this.mXAxis.mAxisMinimum, this.posForGetLowestVisibleX.y);
  }
  
  protected float[] getMarkerPosition(Highlight paramHighlight)
  {
    return new float[] { paramHighlight.getDrawY(), paramHighlight.getDrawX() };
  }
  
  public MPPointF getPosition(Entry paramEntry, YAxis.AxisDependency paramAxisDependency)
  {
    if (paramEntry == null) {
      return null;
    }
    float[] arrayOfFloat = this.mGetPositionBuffer;
    arrayOfFloat[0] = paramEntry.getY();
    arrayOfFloat[1] = paramEntry.getX();
    getTransformer(paramAxisDependency).pointValuesToPixel(arrayOfFloat);
    return MPPointF.getInstance(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  protected void init()
  {
    this.mViewPortHandler = new HorizontalViewPortHandler();
    super.init();
    this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
    this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
    this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    setHighlighter(new HorizontalBarHighlighter(this));
    this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
    this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
    this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
  }
  
  protected void prepareValuePxMatrix()
  {
    Transformer localTransformer = this.mRightAxisTransformer;
    Object localObject = this.mAxisRight;
    float f1 = ((AxisBase)localObject).mAxisMinimum;
    float f2 = ((AxisBase)localObject).mAxisRange;
    localObject = this.mXAxis;
    localTransformer.prepareMatrixValuePx(f1, f2, ((AxisBase)localObject).mAxisRange, ((AxisBase)localObject).mAxisMinimum);
    localTransformer = this.mLeftAxisTransformer;
    localObject = this.mAxisLeft;
    f2 = ((AxisBase)localObject).mAxisMinimum;
    f1 = ((AxisBase)localObject).mAxisRange;
    localObject = this.mXAxis;
    localTransformer.prepareMatrixValuePx(f2, f1, ((AxisBase)localObject).mAxisRange, ((AxisBase)localObject).mAxisMinimum);
  }
  
  public void setVisibleXRange(float paramFloat1, float paramFloat2)
  {
    float f = this.mXAxis.mAxisRange;
    paramFloat1 = f / paramFloat1;
    paramFloat2 = f / paramFloat2;
    this.mViewPortHandler.setMinMaxScaleY(paramFloat1, paramFloat2);
  }
  
  public void setVisibleXRangeMaximum(float paramFloat)
  {
    paramFloat = this.mXAxis.mAxisRange / paramFloat;
    this.mViewPortHandler.setMinimumScaleY(paramFloat);
  }
  
  public void setVisibleXRangeMinimum(float paramFloat)
  {
    paramFloat = this.mXAxis.mAxisRange / paramFloat;
    this.mViewPortHandler.setMaximumScaleY(paramFloat);
  }
  
  public void setVisibleYRange(float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency)
  {
    paramFloat1 = getAxisRange(paramAxisDependency) / paramFloat1;
    paramFloat2 = getAxisRange(paramAxisDependency) / paramFloat2;
    this.mViewPortHandler.setMinMaxScaleX(paramFloat1, paramFloat2);
  }
  
  public void setVisibleYRangeMaximum(float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    paramFloat = getAxisRange(paramAxisDependency) / paramFloat;
    this.mViewPortHandler.setMinimumScaleX(paramFloat);
  }
  
  public void setVisibleYRangeMinimum(float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    paramFloat = getAxisRange(paramAxisDependency) / paramFloat;
    this.mViewPortHandler.setMaximumScaleX(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\HorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */