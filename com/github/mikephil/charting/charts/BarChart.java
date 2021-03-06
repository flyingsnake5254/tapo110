package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.Transformer;

public class BarChart
  extends BarLineChartBase<BarData>
  implements BarDataProvider
{
  private boolean mDrawBarShadow = false;
  private boolean mDrawValueAboveBar = true;
  private boolean mFitBars = false;
  protected boolean mHighlightFullBarEnabled = false;
  
  public BarChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public BarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void calcMinMax()
  {
    if (this.mFitBars) {
      this.mXAxis.calculate(((BarData)this.mData).getXMin() - ((BarData)this.mData).getBarWidth() / 2.0F, ((BarData)this.mData).getXMax() + ((BarData)this.mData).getBarWidth() / 2.0F);
    } else {
      this.mXAxis.calculate(((BarData)this.mData).getXMin(), ((BarData)this.mData).getXMax());
    }
    YAxis localYAxis = this.mAxisLeft;
    Object localObject1 = (BarData)this.mData;
    Object localObject2 = YAxis.AxisDependency.LEFT;
    localYAxis.calculate(((ChartData)localObject1).getYMin((YAxis.AxisDependency)localObject2), ((BarData)this.mData).getYMax((YAxis.AxisDependency)localObject2));
    localYAxis = this.mAxisRight;
    localObject2 = (BarData)this.mData;
    localObject1 = YAxis.AxisDependency.RIGHT;
    localYAxis.calculate(((ChartData)localObject2).getYMin((YAxis.AxisDependency)localObject1), ((BarData)this.mData).getYMax((YAxis.AxisDependency)localObject1));
  }
  
  public RectF getBarBounds(BarEntry paramBarEntry)
  {
    RectF localRectF = new RectF();
    getBarBounds(paramBarEntry, localRectF);
    return localRectF;
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
    paramRectF.set(f2 - f3, f4, f2 + f3, f1);
    getTransformer(localIBarDataSet.getAxisDependency()).rectValueToPixel(paramRectF);
  }
  
  public BarData getBarData()
  {
    return (BarData)this.mData;
  }
  
  public Highlight getHighlightByTouchPoint(float paramFloat1, float paramFloat2)
  {
    if (this.mData == null)
    {
      Log.e("MPAndroidChart", "Can't select by touch. No data set.");
      return null;
    }
    Highlight localHighlight = getHighlighter().getHighlight(paramFloat1, paramFloat2);
    if ((localHighlight != null) && (isHighlightFullBarEnabled())) {
      return new Highlight(localHighlight.getX(), localHighlight.getY(), localHighlight.getXPx(), localHighlight.getYPx(), localHighlight.getDataSetIndex(), -1, localHighlight.getAxis());
    }
    return localHighlight;
  }
  
  public void groupBars(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (getBarData() != null)
    {
      getBarData().groupBars(paramFloat1, paramFloat2, paramFloat3);
      notifyDataSetChanged();
      return;
    }
    throw new RuntimeException("You need to set data for the chart before grouping bars.");
  }
  
  public void highlightValue(float paramFloat, int paramInt1, int paramInt2)
  {
    highlightValue(new Highlight(paramFloat, paramInt1, paramInt2), false);
  }
  
  protected void init()
  {
    super.init();
    this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    setHighlighter(new BarHighlighter(this));
    getXAxis().setSpaceMin(0.5F);
    getXAxis().setSpaceMax(0.5F);
  }
  
  public boolean isDrawBarShadowEnabled()
  {
    return this.mDrawBarShadow;
  }
  
  public boolean isDrawValueAboveBarEnabled()
  {
    return this.mDrawValueAboveBar;
  }
  
  public boolean isHighlightFullBarEnabled()
  {
    return this.mHighlightFullBarEnabled;
  }
  
  public void setDrawBarShadow(boolean paramBoolean)
  {
    this.mDrawBarShadow = paramBoolean;
  }
  
  public void setDrawValueAboveBar(boolean paramBoolean)
  {
    this.mDrawValueAboveBar = paramBoolean;
  }
  
  public void setFitBars(boolean paramBoolean)
  {
    this.mFitBars = paramBoolean;
  }
  
  public void setHighlightFullBarEnabled(boolean paramBoolean)
  {
    this.mHighlightFullBarEnabled = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\BarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */