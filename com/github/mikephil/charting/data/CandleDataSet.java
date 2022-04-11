package com.github.mikephil.charting.data;

import android.graphics.Paint.Style;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CandleDataSet
  extends LineScatterCandleRadarDataSet<CandleEntry>
  implements ICandleDataSet
{
  private float mBarSpace = 0.1F;
  protected int mDecreasingColor = 1122868;
  protected Paint.Style mDecreasingPaintStyle = Paint.Style.FILL;
  protected int mIncreasingColor = 1122868;
  protected Paint.Style mIncreasingPaintStyle = Paint.Style.STROKE;
  protected int mNeutralColor = 1122868;
  protected int mShadowColor = 1122868;
  private boolean mShadowColorSameAsCandle = false;
  private float mShadowWidth = 3.0F;
  private boolean mShowCandleBar = true;
  
  public CandleDataSet(List<CandleEntry> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  protected void calcMinMax(CandleEntry paramCandleEntry)
  {
    if (paramCandleEntry.getLow() < this.mYMin) {
      this.mYMin = paramCandleEntry.getLow();
    }
    if (paramCandleEntry.getHigh() > this.mYMax) {
      this.mYMax = paramCandleEntry.getHigh();
    }
    calcMinMaxX(paramCandleEntry);
  }
  
  protected void calcMinMaxY(CandleEntry paramCandleEntry)
  {
    if (paramCandleEntry.getHigh() < this.mYMin) {
      this.mYMin = paramCandleEntry.getHigh();
    }
    if (paramCandleEntry.getHigh() > this.mYMax) {
      this.mYMax = paramCandleEntry.getHigh();
    }
    if (paramCandleEntry.getLow() < this.mYMin) {
      this.mYMin = paramCandleEntry.getLow();
    }
    if (paramCandleEntry.getLow() > this.mYMax) {
      this.mYMax = paramCandleEntry.getLow();
    }
  }
  
  public DataSet<CandleEntry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((CandleEntry)this.mValues.get(i)).copy());
    }
    localObject = new CandleDataSet((List)localObject, getLabel());
    copy((CandleDataSet)localObject);
    return (DataSet<CandleEntry>)localObject;
  }
  
  protected void copy(CandleDataSet paramCandleDataSet)
  {
    super.copy(paramCandleDataSet);
    paramCandleDataSet.mShadowWidth = this.mShadowWidth;
    paramCandleDataSet.mShowCandleBar = this.mShowCandleBar;
    paramCandleDataSet.mBarSpace = this.mBarSpace;
    paramCandleDataSet.mShadowColorSameAsCandle = this.mShadowColorSameAsCandle;
    paramCandleDataSet.mHighLightColor = this.mHighLightColor;
    paramCandleDataSet.mIncreasingPaintStyle = this.mIncreasingPaintStyle;
    paramCandleDataSet.mDecreasingPaintStyle = this.mDecreasingPaintStyle;
    paramCandleDataSet.mNeutralColor = this.mNeutralColor;
    paramCandleDataSet.mIncreasingColor = this.mIncreasingColor;
    paramCandleDataSet.mDecreasingColor = this.mDecreasingColor;
    paramCandleDataSet.mShadowColor = this.mShadowColor;
  }
  
  public float getBarSpace()
  {
    return this.mBarSpace;
  }
  
  public int getDecreasingColor()
  {
    return this.mDecreasingColor;
  }
  
  public Paint.Style getDecreasingPaintStyle()
  {
    return this.mDecreasingPaintStyle;
  }
  
  public int getIncreasingColor()
  {
    return this.mIncreasingColor;
  }
  
  public Paint.Style getIncreasingPaintStyle()
  {
    return this.mIncreasingPaintStyle;
  }
  
  public int getNeutralColor()
  {
    return this.mNeutralColor;
  }
  
  public int getShadowColor()
  {
    return this.mShadowColor;
  }
  
  public boolean getShadowColorSameAsCandle()
  {
    return this.mShadowColorSameAsCandle;
  }
  
  public float getShadowWidth()
  {
    return this.mShadowWidth;
  }
  
  public boolean getShowCandleBar()
  {
    return this.mShowCandleBar;
  }
  
  public void setBarSpace(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f > 0.45F) {
      paramFloat = 0.45F;
    }
    this.mBarSpace = paramFloat;
  }
  
  public void setDecreasingColor(int paramInt)
  {
    this.mDecreasingColor = paramInt;
  }
  
  public void setDecreasingPaintStyle(Paint.Style paramStyle)
  {
    this.mDecreasingPaintStyle = paramStyle;
  }
  
  public void setIncreasingColor(int paramInt)
  {
    this.mIncreasingColor = paramInt;
  }
  
  public void setIncreasingPaintStyle(Paint.Style paramStyle)
  {
    this.mIncreasingPaintStyle = paramStyle;
  }
  
  public void setNeutralColor(int paramInt)
  {
    this.mNeutralColor = paramInt;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.mShadowColor = paramInt;
  }
  
  public void setShadowColorSameAsCandle(boolean paramBoolean)
  {
    this.mShadowColorSameAsCandle = paramBoolean;
  }
  
  public void setShadowWidth(float paramFloat)
  {
    this.mShadowWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setShowCandleBar(boolean paramBoolean)
  {
    this.mShowCandleBar = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\CandleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */