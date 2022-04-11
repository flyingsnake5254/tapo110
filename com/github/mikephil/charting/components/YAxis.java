package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis
  extends AxisBase
{
  private AxisDependency mAxisDependency;
  private boolean mDrawBottomYLabelEntry = true;
  private boolean mDrawTopYLabelEntry = true;
  protected boolean mDrawZeroLine = false;
  protected boolean mInverted = false;
  protected float mMaxWidth = Float.POSITIVE_INFINITY;
  protected float mMinWidth = 0.0F;
  private YAxisLabelPosition mPosition = YAxisLabelPosition.OUTSIDE_CHART;
  protected float mSpacePercentBottom = 10.0F;
  protected float mSpacePercentTop = 10.0F;
  private boolean mUseAutoScaleRestrictionMax = false;
  private boolean mUseAutoScaleRestrictionMin = false;
  protected int mZeroLineColor = -7829368;
  protected float mZeroLineWidth = 1.0F;
  
  public YAxis()
  {
    this.mAxisDependency = AxisDependency.LEFT;
    this.mYOffset = 0.0F;
  }
  
  public YAxis(AxisDependency paramAxisDependency)
  {
    this.mAxisDependency = paramAxisDependency;
    this.mYOffset = 0.0F;
  }
  
  public void calculate(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (Math.abs(paramFloat2 - paramFloat1) == 0.0F)
    {
      f2 = paramFloat2 + 1.0F;
      f1 = paramFloat1 - 1.0F;
    }
    paramFloat2 = Math.abs(f2 - f1);
    if (this.mCustomAxisMin) {
      paramFloat1 = this.mAxisMinimum;
    } else {
      paramFloat1 = f1 - paramFloat2 / 100.0F * getSpaceBottom();
    }
    this.mAxisMinimum = paramFloat1;
    if (this.mCustomAxisMax) {
      paramFloat1 = this.mAxisMaximum;
    } else {
      paramFloat1 = f2 + paramFloat2 / 100.0F * getSpaceTop();
    }
    this.mAxisMaximum = paramFloat1;
    this.mAxisRange = Math.abs(this.mAxisMinimum - paramFloat1);
  }
  
  public AxisDependency getAxisDependency()
  {
    return this.mAxisDependency;
  }
  
  public YAxisLabelPosition getLabelPosition()
  {
    return this.mPosition;
  }
  
  public float getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public float getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public float getRequiredHeightSpace(Paint paramPaint)
  {
    paramPaint.setTextSize(this.mTextSize);
    return Utils.calcTextHeight(paramPaint, getLongestLabel()) + getYOffset() * 2.0F;
  }
  
  public float getRequiredWidthSpace(Paint paramPaint)
  {
    paramPaint.setTextSize(this.mTextSize);
    float f1 = Utils.calcTextWidth(paramPaint, getLongestLabel()) + getXOffset() * 2.0F;
    float f2 = getMinWidth();
    float f3 = getMaxWidth();
    float f4 = f2;
    if (f2 > 0.0F) {
      f4 = Utils.convertDpToPixel(f2);
    }
    f2 = f3;
    if (f3 > 0.0F)
    {
      f2 = f3;
      if (f3 != Float.POSITIVE_INFINITY) {
        f2 = Utils.convertDpToPixel(f3);
      }
    }
    if (f2 <= 0.0D) {
      f2 = f1;
    }
    return Math.max(f4, Math.min(f1, f2));
  }
  
  public float getSpaceBottom()
  {
    return this.mSpacePercentBottom;
  }
  
  public float getSpaceTop()
  {
    return this.mSpacePercentTop;
  }
  
  public int getZeroLineColor()
  {
    return this.mZeroLineColor;
  }
  
  public float getZeroLineWidth()
  {
    return this.mZeroLineWidth;
  }
  
  public boolean isDrawBottomYLabelEntryEnabled()
  {
    return this.mDrawBottomYLabelEntry;
  }
  
  public boolean isDrawTopYLabelEntryEnabled()
  {
    return this.mDrawTopYLabelEntry;
  }
  
  public boolean isDrawZeroLineEnabled()
  {
    return this.mDrawZeroLine;
  }
  
  public boolean isInverted()
  {
    return this.mInverted;
  }
  
  @Deprecated
  public boolean isUseAutoScaleMaxRestriction()
  {
    return this.mUseAutoScaleRestrictionMax;
  }
  
  @Deprecated
  public boolean isUseAutoScaleMinRestriction()
  {
    return this.mUseAutoScaleRestrictionMin;
  }
  
  public boolean needsOffset()
  {
    return (isEnabled()) && (isDrawLabelsEnabled()) && (getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART);
  }
  
  public void setDrawTopYLabelEntry(boolean paramBoolean)
  {
    this.mDrawTopYLabelEntry = paramBoolean;
  }
  
  public void setDrawZeroLine(boolean paramBoolean)
  {
    this.mDrawZeroLine = paramBoolean;
  }
  
  public void setInverted(boolean paramBoolean)
  {
    this.mInverted = paramBoolean;
  }
  
  public void setMaxWidth(float paramFloat)
  {
    this.mMaxWidth = paramFloat;
  }
  
  public void setMinWidth(float paramFloat)
  {
    this.mMinWidth = paramFloat;
  }
  
  public void setPosition(YAxisLabelPosition paramYAxisLabelPosition)
  {
    this.mPosition = paramYAxisLabelPosition;
  }
  
  public void setSpaceBottom(float paramFloat)
  {
    this.mSpacePercentBottom = paramFloat;
  }
  
  public void setSpaceTop(float paramFloat)
  {
    this.mSpacePercentTop = paramFloat;
  }
  
  @Deprecated
  public void setStartAtZero(boolean paramBoolean)
  {
    if (paramBoolean) {
      setAxisMinimum(0.0F);
    } else {
      resetAxisMinimum();
    }
  }
  
  @Deprecated
  public void setUseAutoScaleMaxRestriction(boolean paramBoolean)
  {
    this.mUseAutoScaleRestrictionMax = paramBoolean;
  }
  
  @Deprecated
  public void setUseAutoScaleMinRestriction(boolean paramBoolean)
  {
    this.mUseAutoScaleRestrictionMin = paramBoolean;
  }
  
  public void setZeroLineColor(int paramInt)
  {
    this.mZeroLineColor = paramInt;
  }
  
  public void setZeroLineWidth(float paramFloat)
  {
    this.mZeroLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public static enum AxisDependency
  {
    static
    {
      AxisDependency localAxisDependency1 = new AxisDependency("LEFT", 0);
      LEFT = localAxisDependency1;
      AxisDependency localAxisDependency2 = new AxisDependency("RIGHT", 1);
      RIGHT = localAxisDependency2;
      $VALUES = new AxisDependency[] { localAxisDependency1, localAxisDependency2 };
    }
  }
  
  public static enum YAxisLabelPosition
  {
    static
    {
      YAxisLabelPosition localYAxisLabelPosition1 = new YAxisLabelPosition("OUTSIDE_CHART", 0);
      OUTSIDE_CHART = localYAxisLabelPosition1;
      YAxisLabelPosition localYAxisLabelPosition2 = new YAxisLabelPosition("INSIDE_CHART", 1);
      INSIDE_CHART = localYAxisLabelPosition2;
      $VALUES = new YAxisLabelPosition[] { localYAxisLabelPosition1, localYAxisLabelPosition2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\YAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */