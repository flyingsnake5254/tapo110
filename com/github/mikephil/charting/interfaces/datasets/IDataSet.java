package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

public abstract interface IDataSet<T extends Entry>
{
  public abstract boolean addEntry(T paramT);
  
  public abstract void addEntryOrdered(T paramT);
  
  public abstract void calcMinMax();
  
  public abstract void calcMinMaxY(float paramFloat1, float paramFloat2);
  
  public abstract void clear();
  
  public abstract boolean contains(T paramT);
  
  public abstract YAxis.AxisDependency getAxisDependency();
  
  public abstract int getColor();
  
  public abstract int getColor(int paramInt);
  
  public abstract List<Integer> getColors();
  
  public abstract List<T> getEntriesForXValue(float paramFloat);
  
  public abstract int getEntryCount();
  
  public abstract T getEntryForIndex(int paramInt);
  
  public abstract T getEntryForXValue(float paramFloat1, float paramFloat2);
  
  public abstract T getEntryForXValue(float paramFloat1, float paramFloat2, DataSet.Rounding paramRounding);
  
  public abstract int getEntryIndex(float paramFloat1, float paramFloat2, DataSet.Rounding paramRounding);
  
  public abstract int getEntryIndex(T paramT);
  
  public abstract Legend.LegendForm getForm();
  
  public abstract DashPathEffect getFormLineDashEffect();
  
  public abstract float getFormLineWidth();
  
  public abstract float getFormSize();
  
  public abstract GradientColor getGradientColor();
  
  public abstract GradientColor getGradientColor(int paramInt);
  
  public abstract List<GradientColor> getGradientColors();
  
  public abstract MPPointF getIconsOffset();
  
  public abstract int getIndexInEntries(int paramInt);
  
  public abstract String getLabel();
  
  public abstract ValueFormatter getValueFormatter();
  
  public abstract int getValueTextColor();
  
  public abstract int getValueTextColor(int paramInt);
  
  public abstract float getValueTextSize();
  
  public abstract Typeface getValueTypeface();
  
  public abstract float getXMax();
  
  public abstract float getXMin();
  
  public abstract float getYMax();
  
  public abstract float getYMin();
  
  public abstract boolean isDrawIconsEnabled();
  
  public abstract boolean isDrawValuesEnabled();
  
  public abstract boolean isHighlightEnabled();
  
  public abstract boolean isVisible();
  
  public abstract boolean needsFormatter();
  
  public abstract boolean removeEntry(int paramInt);
  
  public abstract boolean removeEntry(T paramT);
  
  public abstract boolean removeEntryByXValue(float paramFloat);
  
  public abstract boolean removeFirst();
  
  public abstract boolean removeLast();
  
  public abstract void setAxisDependency(YAxis.AxisDependency paramAxisDependency);
  
  public abstract void setDrawIcons(boolean paramBoolean);
  
  public abstract void setDrawValues(boolean paramBoolean);
  
  public abstract void setHighlightEnabled(boolean paramBoolean);
  
  public abstract void setIconsOffset(MPPointF paramMPPointF);
  
  public abstract void setLabel(String paramString);
  
  public abstract void setValueFormatter(ValueFormatter paramValueFormatter);
  
  public abstract void setValueTextColor(int paramInt);
  
  public abstract void setValueTextColors(List<Integer> paramList);
  
  public abstract void setValueTextSize(float paramFloat);
  
  public abstract void setValueTypeface(Typeface paramTypeface);
  
  public abstract void setVisible(boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\interfaces\datasets\IDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */