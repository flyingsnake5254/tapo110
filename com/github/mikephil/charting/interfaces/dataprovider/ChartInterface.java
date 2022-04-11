package com.github.mikephil.charting.interfaces.dataprovider;

import android.graphics.RectF;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.MPPointF;

public abstract interface ChartInterface
{
  public abstract MPPointF getCenterOfView();
  
  public abstract MPPointF getCenterOffsets();
  
  public abstract RectF getContentRect();
  
  public abstract ChartData getData();
  
  public abstract ValueFormatter getDefaultValueFormatter();
  
  public abstract int getHeight();
  
  public abstract float getMaxHighlightDistance();
  
  public abstract int getMaxVisibleCount();
  
  public abstract int getWidth();
  
  public abstract float getXChartMax();
  
  public abstract float getXChartMin();
  
  public abstract float getXRange();
  
  public abstract float getYChartMax();
  
  public abstract float getYChartMin();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\dataprovider\ChartInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */