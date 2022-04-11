package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.ArrayList;
import java.util.List;

public class RadarDataSet
  extends LineRadarDataSet<RadarEntry>
  implements IRadarDataSet
{
  protected boolean mDrawHighlightCircleEnabled = false;
  protected int mHighlightCircleFillColor = -1;
  protected float mHighlightCircleInnerRadius = 3.0F;
  protected float mHighlightCircleOuterRadius = 4.0F;
  protected int mHighlightCircleStrokeAlpha = 76;
  protected int mHighlightCircleStrokeColor = 1122867;
  protected float mHighlightCircleStrokeWidth = 2.0F;
  
  public RadarDataSet(List<RadarEntry> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  public DataSet<RadarEntry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((RadarEntry)this.mValues.get(i)).copy());
    }
    localObject = new RadarDataSet((List)localObject, getLabel());
    copy((RadarDataSet)localObject);
    return (DataSet<RadarEntry>)localObject;
  }
  
  protected void copy(RadarDataSet paramRadarDataSet)
  {
    super.copy(paramRadarDataSet);
    paramRadarDataSet.mDrawHighlightCircleEnabled = this.mDrawHighlightCircleEnabled;
    paramRadarDataSet.mHighlightCircleFillColor = this.mHighlightCircleFillColor;
    paramRadarDataSet.mHighlightCircleInnerRadius = this.mHighlightCircleInnerRadius;
    paramRadarDataSet.mHighlightCircleStrokeAlpha = this.mHighlightCircleStrokeAlpha;
    paramRadarDataSet.mHighlightCircleStrokeColor = this.mHighlightCircleStrokeColor;
    paramRadarDataSet.mHighlightCircleStrokeWidth = this.mHighlightCircleStrokeWidth;
  }
  
  public int getHighlightCircleFillColor()
  {
    return this.mHighlightCircleFillColor;
  }
  
  public float getHighlightCircleInnerRadius()
  {
    return this.mHighlightCircleInnerRadius;
  }
  
  public float getHighlightCircleOuterRadius()
  {
    return this.mHighlightCircleOuterRadius;
  }
  
  public int getHighlightCircleStrokeAlpha()
  {
    return this.mHighlightCircleStrokeAlpha;
  }
  
  public int getHighlightCircleStrokeColor()
  {
    return this.mHighlightCircleStrokeColor;
  }
  
  public float getHighlightCircleStrokeWidth()
  {
    return this.mHighlightCircleStrokeWidth;
  }
  
  public boolean isDrawHighlightCircleEnabled()
  {
    return this.mDrawHighlightCircleEnabled;
  }
  
  public void setDrawHighlightCircleEnabled(boolean paramBoolean)
  {
    this.mDrawHighlightCircleEnabled = paramBoolean;
  }
  
  public void setHighlightCircleFillColor(int paramInt)
  {
    this.mHighlightCircleFillColor = paramInt;
  }
  
  public void setHighlightCircleInnerRadius(float paramFloat)
  {
    this.mHighlightCircleInnerRadius = paramFloat;
  }
  
  public void setHighlightCircleOuterRadius(float paramFloat)
  {
    this.mHighlightCircleOuterRadius = paramFloat;
  }
  
  public void setHighlightCircleStrokeAlpha(int paramInt)
  {
    this.mHighlightCircleStrokeAlpha = paramInt;
  }
  
  public void setHighlightCircleStrokeColor(int paramInt)
  {
    this.mHighlightCircleStrokeColor = paramInt;
  }
  
  public void setHighlightCircleStrokeWidth(float paramFloat)
  {
    this.mHighlightCircleStrokeWidth = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\RadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */