package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.renderer.CandleStickChartRenderer;

public class CandleStickChart
  extends BarLineChartBase<CandleData>
  implements CandleDataProvider
{
  public CandleStickChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public CandleStickChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CandleStickChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public CandleData getCandleData()
  {
    return (CandleData)this.mData;
  }
  
  protected void init()
  {
    super.init();
    this.mRenderer = new CandleStickChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    getXAxis().setSpaceMin(0.5F);
    getXAxis().setSpaceMax(0.5F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\CandleStickChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */