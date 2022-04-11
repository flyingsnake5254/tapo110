package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

public class ScatterChart
  extends BarLineChartBase<ScatterData>
  implements ScatterDataProvider
{
  public ScatterChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScatterChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScatterChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ScatterData getScatterData()
  {
    return (ScatterData)this.mData;
  }
  
  protected void init()
  {
    super.init();
    this.mRenderer = new ScatterChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    getXAxis().setSpaceMin(0.5F);
    getXAxis().setSpaceMax(0.5F);
  }
  
  public static enum ScatterShape
  {
    private final String shapeIdentifier;
    
    static
    {
      ScatterShape localScatterShape1 = new ScatterShape("SQUARE", 0, "SQUARE");
      SQUARE = localScatterShape1;
      ScatterShape localScatterShape2 = new ScatterShape("CIRCLE", 1, "CIRCLE");
      CIRCLE = localScatterShape2;
      ScatterShape localScatterShape3 = new ScatterShape("TRIANGLE", 2, "TRIANGLE");
      TRIANGLE = localScatterShape3;
      ScatterShape localScatterShape4 = new ScatterShape("CROSS", 3, "CROSS");
      CROSS = localScatterShape4;
      ScatterShape localScatterShape5 = new ScatterShape("X", 4, "X");
      X = localScatterShape5;
      ScatterShape localScatterShape6 = new ScatterShape("CHEVRON_UP", 5, "CHEVRON_UP");
      CHEVRON_UP = localScatterShape6;
      ScatterShape localScatterShape7 = new ScatterShape("CHEVRON_DOWN", 6, "CHEVRON_DOWN");
      CHEVRON_DOWN = localScatterShape7;
      $VALUES = new ScatterShape[] { localScatterShape1, localScatterShape2, localScatterShape3, localScatterShape4, localScatterShape5, localScatterShape6, localScatterShape7 };
    }
    
    private ScatterShape(String paramString)
    {
      this.shapeIdentifier = paramString;
    }
    
    public static ScatterShape[] getAllDefaultShapes()
    {
      return new ScatterShape[] { SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN };
    }
    
    public String toString()
    {
      return this.shapeIdentifier;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\ScatterChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */