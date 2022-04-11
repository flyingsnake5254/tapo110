package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineScatterCandleRadarDataSet<T extends Entry>
  extends BarLineScatterCandleBubbleDataSet<T>
  implements ILineScatterCandleRadarDataSet<T>
{
  protected boolean mDrawHorizontalHighlightIndicator = true;
  protected boolean mDrawVerticalHighlightIndicator = true;
  protected DashPathEffect mHighlightDashPathEffect = null;
  protected float mHighlightLineWidth = 0.5F;
  
  public LineScatterCandleRadarDataSet(List<T> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  protected void copy(LineScatterCandleRadarDataSet paramLineScatterCandleRadarDataSet)
  {
    super.copy(paramLineScatterCandleRadarDataSet);
    paramLineScatterCandleRadarDataSet.mDrawHorizontalHighlightIndicator = this.mDrawHorizontalHighlightIndicator;
    paramLineScatterCandleRadarDataSet.mDrawVerticalHighlightIndicator = this.mDrawVerticalHighlightIndicator;
    paramLineScatterCandleRadarDataSet.mHighlightLineWidth = this.mHighlightLineWidth;
    paramLineScatterCandleRadarDataSet.mHighlightDashPathEffect = this.mHighlightDashPathEffect;
  }
  
  public void disableDashedHighlightLine()
  {
    this.mHighlightDashPathEffect = null;
  }
  
  public void enableDashedHighlightLine(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mHighlightDashPathEffect = new DashPathEffect(new float[] { paramFloat1, paramFloat2 }, paramFloat3);
  }
  
  public DashPathEffect getDashPathEffectHighlight()
  {
    return this.mHighlightDashPathEffect;
  }
  
  public float getHighlightLineWidth()
  {
    return this.mHighlightLineWidth;
  }
  
  public boolean isDashedHighlightLineEnabled()
  {
    boolean bool;
    if (this.mHighlightDashPathEffect == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isHorizontalHighlightIndicatorEnabled()
  {
    return this.mDrawHorizontalHighlightIndicator;
  }
  
  public boolean isVerticalHighlightIndicatorEnabled()
  {
    return this.mDrawVerticalHighlightIndicator;
  }
  
  public void setDrawHighlightIndicators(boolean paramBoolean)
  {
    setDrawVerticalHighlightIndicator(paramBoolean);
    setDrawHorizontalHighlightIndicator(paramBoolean);
  }
  
  public void setDrawHorizontalHighlightIndicator(boolean paramBoolean)
  {
    this.mDrawHorizontalHighlightIndicator = paramBoolean;
  }
  
  public void setDrawVerticalHighlightIndicator(boolean paramBoolean)
  {
    this.mDrawVerticalHighlightIndicator = paramBoolean;
  }
  
  public void setHighlightLineWidth(float paramFloat)
  {
    this.mHighlightLineWidth = Utils.convertDpToPixel(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\LineScatterCandleRadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */