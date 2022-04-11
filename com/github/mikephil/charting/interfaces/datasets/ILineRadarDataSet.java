package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;

public abstract interface ILineRadarDataSet<T extends Entry>
  extends ILineScatterCandleRadarDataSet<T>
{
  public abstract int getFillAlpha();
  
  public abstract int getFillColor();
  
  public abstract Drawable getFillDrawable();
  
  public abstract float getLineWidth();
  
  public abstract boolean isDrawFilledEnabled();
  
  public abstract void setDrawFilled(boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\datasets\ILineRadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */