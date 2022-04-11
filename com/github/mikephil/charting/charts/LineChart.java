package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

public class LineChart
  extends BarLineChartBase<LineData>
  implements LineDataProvider
{
  public LineChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public LineChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LineChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public LineData getLineData()
  {
    return (LineData)this.mData;
  }
  
  protected void init()
  {
    super.init();
    this.mRenderer = new LineChartRenderer(this, this.mAnimator, this.mViewPortHandler);
  }
  
  protected void onDetachedFromWindow()
  {
    DataRenderer localDataRenderer = this.mRenderer;
    if ((localDataRenderer != null) && ((localDataRenderer instanceof LineChartRenderer))) {
      ((LineChartRenderer)localDataRenderer).releaseBitmap();
    }
    super.onDetachedFromWindow();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\LineChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */