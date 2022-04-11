package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;

public class BubbleChart
  extends BarLineChartBase<BubbleData>
  implements BubbleDataProvider
{
  public BubbleChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public BubbleData getBubbleData()
  {
    return (BubbleData)this.mData;
  }
  
  protected void init()
  {
    super.init();
    this.mRenderer = new BubbleChartRenderer(this, this.mAnimator, this.mViewPortHandler);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\BubbleChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */