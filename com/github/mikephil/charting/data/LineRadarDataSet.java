package com.github.mikephil.charting.data;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry>
  extends LineScatterCandleRadarDataSet<T>
  implements ILineRadarDataSet<T>
{
  private boolean mDrawFilled = false;
  private int mFillAlpha = 85;
  private int mFillColor = Color.rgb(140, 234, 255);
  protected Drawable mFillDrawable;
  private float mLineWidth = 2.5F;
  
  public LineRadarDataSet(List<T> paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  protected void copy(LineRadarDataSet paramLineRadarDataSet)
  {
    super.copy(paramLineRadarDataSet);
    paramLineRadarDataSet.mDrawFilled = this.mDrawFilled;
    paramLineRadarDataSet.mFillAlpha = this.mFillAlpha;
    paramLineRadarDataSet.mFillColor = this.mFillColor;
    paramLineRadarDataSet.mFillDrawable = this.mFillDrawable;
    paramLineRadarDataSet.mLineWidth = this.mLineWidth;
  }
  
  public int getFillAlpha()
  {
    return this.mFillAlpha;
  }
  
  public int getFillColor()
  {
    return this.mFillColor;
  }
  
  public Drawable getFillDrawable()
  {
    return this.mFillDrawable;
  }
  
  public float getLineWidth()
  {
    return this.mLineWidth;
  }
  
  public boolean isDrawFilledEnabled()
  {
    return this.mDrawFilled;
  }
  
  public void setDrawFilled(boolean paramBoolean)
  {
    this.mDrawFilled = paramBoolean;
  }
  
  public void setFillAlpha(int paramInt)
  {
    this.mFillAlpha = paramInt;
  }
  
  public void setFillColor(int paramInt)
  {
    this.mFillColor = paramInt;
    this.mFillDrawable = null;
  }
  
  @TargetApi(18)
  public void setFillDrawable(Drawable paramDrawable)
  {
    this.mFillDrawable = paramDrawable;
  }
  
  public void setLineWidth(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f > 10.0F) {
      paramFloat = 10.0F;
    }
    this.mLineWidth = Utils.convertDpToPixel(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\LineRadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */