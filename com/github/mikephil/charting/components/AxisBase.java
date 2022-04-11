package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase
  extends ComponentBase
{
  private int mAxisLineColor = -7829368;
  private DashPathEffect mAxisLineDashPathEffect = null;
  private float mAxisLineWidth = 1.0F;
  public float mAxisMaximum = 0.0F;
  public float mAxisMinimum = 0.0F;
  public float mAxisRange = 0.0F;
  protected ValueFormatter mAxisValueFormatter;
  protected boolean mCenterAxisLabels = false;
  public float[] mCenteredEntries = new float[0];
  protected boolean mCustomAxisMax = false;
  protected boolean mCustomAxisMin = false;
  public int mDecimals;
  protected boolean mDrawAxisLine = true;
  protected boolean mDrawGridLines = true;
  protected boolean mDrawGridLinesBehindData = true;
  protected boolean mDrawLabels = true;
  protected boolean mDrawLimitLineBehindData = false;
  public float[] mEntries = new float[0];
  public int mEntryCount;
  protected boolean mForceLabels = false;
  protected float mGranularity = 1.0F;
  protected boolean mGranularityEnabled = false;
  private int mGridColor = -7829368;
  private DashPathEffect mGridDashPathEffect = null;
  private float mGridLineWidth = 1.0F;
  private int mLabelCount = 6;
  protected List<LimitLine> mLimitLines;
  protected float mSpaceMax = 0.0F;
  protected float mSpaceMin = 0.0F;
  
  public AxisBase()
  {
    this.mTextSize = Utils.convertDpToPixel(10.0F);
    this.mXOffset = Utils.convertDpToPixel(5.0F);
    this.mYOffset = Utils.convertDpToPixel(5.0F);
    this.mLimitLines = new ArrayList();
  }
  
  public void addLimitLine(LimitLine paramLimitLine)
  {
    this.mLimitLines.add(paramLimitLine);
    if (this.mLimitLines.size() > 6) {
      Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
    }
  }
  
  public void calculate(float paramFloat1, float paramFloat2)
  {
    if (this.mCustomAxisMin) {
      paramFloat1 = this.mAxisMinimum;
    } else {
      paramFloat1 -= this.mSpaceMin;
    }
    if (this.mCustomAxisMax) {
      paramFloat2 = this.mAxisMaximum;
    } else {
      paramFloat2 += this.mSpaceMax;
    }
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (Math.abs(paramFloat2 - paramFloat1) == 0.0F)
    {
      f2 = paramFloat2 + 1.0F;
      f1 = paramFloat1 - 1.0F;
    }
    this.mAxisMinimum = f1;
    this.mAxisMaximum = f2;
    this.mAxisRange = Math.abs(f2 - f1);
  }
  
  public void disableAxisLineDashedLine()
  {
    this.mAxisLineDashPathEffect = null;
  }
  
  public void disableGridDashedLine()
  {
    this.mGridDashPathEffect = null;
  }
  
  public void enableAxisLineDashedLine(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mAxisLineDashPathEffect = new DashPathEffect(new float[] { paramFloat1, paramFloat2 }, paramFloat3);
  }
  
  public void enableGridDashedLine(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mGridDashPathEffect = new DashPathEffect(new float[] { paramFloat1, paramFloat2 }, paramFloat3);
  }
  
  public int getAxisLineColor()
  {
    return this.mAxisLineColor;
  }
  
  public DashPathEffect getAxisLineDashPathEffect()
  {
    return this.mAxisLineDashPathEffect;
  }
  
  public float getAxisLineWidth()
  {
    return this.mAxisLineWidth;
  }
  
  public float getAxisMaximum()
  {
    return this.mAxisMaximum;
  }
  
  public float getAxisMinimum()
  {
    return this.mAxisMinimum;
  }
  
  public String getFormattedLabel(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mEntries.length)) {
      return getValueFormatter().getAxisLabel(this.mEntries[paramInt], this);
    }
    return "";
  }
  
  public float getGranularity()
  {
    return this.mGranularity;
  }
  
  public int getGridColor()
  {
    return this.mGridColor;
  }
  
  public DashPathEffect getGridDashPathEffect()
  {
    return this.mGridDashPathEffect;
  }
  
  public float getGridLineWidth()
  {
    return this.mGridLineWidth;
  }
  
  public int getLabelCount()
  {
    return this.mLabelCount;
  }
  
  public List<LimitLine> getLimitLines()
  {
    return this.mLimitLines;
  }
  
  public String getLongestLabel()
  {
    Object localObject1 = "";
    int i = 0;
    while (i < this.mEntries.length)
    {
      String str = getFormattedLabel(i);
      Object localObject2 = localObject1;
      if (str != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() < str.length()) {
          localObject2 = str;
        }
      }
      i++;
      localObject1 = localObject2;
    }
    return (String)localObject1;
  }
  
  public float getSpaceMax()
  {
    return this.mSpaceMax;
  }
  
  public float getSpaceMin()
  {
    return this.mSpaceMin;
  }
  
  public ValueFormatter getValueFormatter()
  {
    ValueFormatter localValueFormatter = this.mAxisValueFormatter;
    if ((localValueFormatter == null) || (((localValueFormatter instanceof DefaultAxisValueFormatter)) && (((DefaultAxisValueFormatter)localValueFormatter).getDecimalDigits() != this.mDecimals))) {
      this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
    }
    return this.mAxisValueFormatter;
  }
  
  public boolean isAxisLineDashedLineEnabled()
  {
    boolean bool;
    if (this.mAxisLineDashPathEffect == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isAxisMaxCustom()
  {
    return this.mCustomAxisMax;
  }
  
  public boolean isAxisMinCustom()
  {
    return this.mCustomAxisMin;
  }
  
  public boolean isCenterAxisLabelsEnabled()
  {
    boolean bool;
    if ((this.mCenterAxisLabels) && (this.mEntryCount > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isDrawAxisLineEnabled()
  {
    return this.mDrawAxisLine;
  }
  
  public boolean isDrawGridLinesBehindDataEnabled()
  {
    return this.mDrawGridLinesBehindData;
  }
  
  public boolean isDrawGridLinesEnabled()
  {
    return this.mDrawGridLines;
  }
  
  public boolean isDrawLabelsEnabled()
  {
    return this.mDrawLabels;
  }
  
  public boolean isDrawLimitLinesBehindDataEnabled()
  {
    return this.mDrawLimitLineBehindData;
  }
  
  public boolean isForceLabelsEnabled()
  {
    return this.mForceLabels;
  }
  
  public boolean isGranularityEnabled()
  {
    return this.mGranularityEnabled;
  }
  
  public boolean isGridDashedLineEnabled()
  {
    boolean bool;
    if (this.mGridDashPathEffect == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void removeAllLimitLines()
  {
    this.mLimitLines.clear();
  }
  
  public void removeLimitLine(LimitLine paramLimitLine)
  {
    this.mLimitLines.remove(paramLimitLine);
  }
  
  public void resetAxisMaximum()
  {
    this.mCustomAxisMax = false;
  }
  
  public void resetAxisMinimum()
  {
    this.mCustomAxisMin = false;
  }
  
  public void setAxisLineColor(int paramInt)
  {
    this.mAxisLineColor = paramInt;
  }
  
  public void setAxisLineDashedLine(DashPathEffect paramDashPathEffect)
  {
    this.mAxisLineDashPathEffect = paramDashPathEffect;
  }
  
  public void setAxisLineWidth(float paramFloat)
  {
    this.mAxisLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  @Deprecated
  public void setAxisMaxValue(float paramFloat)
  {
    setAxisMaximum(paramFloat);
  }
  
  public void setAxisMaximum(float paramFloat)
  {
    this.mCustomAxisMax = true;
    this.mAxisMaximum = paramFloat;
    this.mAxisRange = Math.abs(paramFloat - this.mAxisMinimum);
  }
  
  @Deprecated
  public void setAxisMinValue(float paramFloat)
  {
    setAxisMinimum(paramFloat);
  }
  
  public void setAxisMinimum(float paramFloat)
  {
    this.mCustomAxisMin = true;
    this.mAxisMinimum = paramFloat;
    this.mAxisRange = Math.abs(this.mAxisMaximum - paramFloat);
  }
  
  public void setCenterAxisLabels(boolean paramBoolean)
  {
    this.mCenterAxisLabels = paramBoolean;
  }
  
  public void setDrawAxisLine(boolean paramBoolean)
  {
    this.mDrawAxisLine = paramBoolean;
  }
  
  public void setDrawGridLines(boolean paramBoolean)
  {
    this.mDrawGridLines = paramBoolean;
  }
  
  public void setDrawGridLinesBehindData(boolean paramBoolean)
  {
    this.mDrawGridLinesBehindData = paramBoolean;
  }
  
  public void setDrawLabels(boolean paramBoolean)
  {
    this.mDrawLabels = paramBoolean;
  }
  
  public void setDrawLimitLinesBehindData(boolean paramBoolean)
  {
    this.mDrawLimitLineBehindData = paramBoolean;
  }
  
  public void setGranularity(float paramFloat)
  {
    this.mGranularity = paramFloat;
    this.mGranularityEnabled = true;
  }
  
  public void setGranularityEnabled(boolean paramBoolean)
  {
    this.mGranularityEnabled = paramBoolean;
  }
  
  public void setGridColor(int paramInt)
  {
    this.mGridColor = paramInt;
  }
  
  public void setGridDashedLine(DashPathEffect paramDashPathEffect)
  {
    this.mGridDashPathEffect = paramDashPathEffect;
  }
  
  public void setGridLineWidth(float paramFloat)
  {
    this.mGridLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setLabelCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 25) {
      i = 25;
    }
    paramInt = i;
    if (i < 2) {
      paramInt = 2;
    }
    this.mLabelCount = paramInt;
    this.mForceLabels = false;
  }
  
  public void setLabelCount(int paramInt, boolean paramBoolean)
  {
    setLabelCount(paramInt);
    this.mForceLabels = paramBoolean;
  }
  
  public void setSpaceMax(float paramFloat)
  {
    this.mSpaceMax = paramFloat;
  }
  
  public void setSpaceMin(float paramFloat)
  {
    this.mSpaceMin = paramFloat;
  }
  
  public void setValueFormatter(ValueFormatter paramValueFormatter)
  {
    if (paramValueFormatter == null) {
      this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
    } else {
      this.mAxisValueFormatter = paramValueFormatter;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\AxisBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */