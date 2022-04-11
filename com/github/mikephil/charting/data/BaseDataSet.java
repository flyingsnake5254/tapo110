package com.github.mikephil.charting.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry>
  implements IDataSet<T>
{
  protected YAxis.AxisDependency mAxisDependency = YAxis.AxisDependency.LEFT;
  protected List<Integer> mColors = null;
  protected boolean mDrawIcons = true;
  protected boolean mDrawValues = true;
  private Legend.LegendForm mForm = Legend.LegendForm.DEFAULT;
  private DashPathEffect mFormLineDashEffect = null;
  private float mFormLineWidth = NaN.0F;
  private float mFormSize = NaN.0F;
  protected GradientColor mGradientColor = null;
  protected List<GradientColor> mGradientColors = null;
  protected boolean mHighlightEnabled = true;
  protected MPPointF mIconsOffset = new MPPointF();
  private String mLabel = "DataSet";
  protected List<Integer> mValueColors = null;
  protected transient ValueFormatter mValueFormatter;
  protected float mValueTextSize = 17.0F;
  protected Typeface mValueTypeface;
  protected boolean mVisible = true;
  
  public BaseDataSet()
  {
    this.mColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    this.mValueColors.add(Integer.valueOf(-16777216));
  }
  
  public BaseDataSet(String paramString)
  {
    this();
    this.mLabel = paramString;
  }
  
  public void addColor(int paramInt)
  {
    if (this.mColors == null) {
      this.mColors = new ArrayList();
    }
    this.mColors.add(Integer.valueOf(paramInt));
  }
  
  public boolean contains(T paramT)
  {
    for (int i = 0; i < getEntryCount(); i++) {
      if (getEntryForIndex(i).equals(paramT)) {
        return true;
      }
    }
    return false;
  }
  
  protected void copy(BaseDataSet paramBaseDataSet)
  {
    paramBaseDataSet.mAxisDependency = this.mAxisDependency;
    paramBaseDataSet.mColors = this.mColors;
    paramBaseDataSet.mDrawIcons = this.mDrawIcons;
    paramBaseDataSet.mDrawValues = this.mDrawValues;
    paramBaseDataSet.mForm = this.mForm;
    paramBaseDataSet.mFormLineDashEffect = this.mFormLineDashEffect;
    paramBaseDataSet.mFormLineWidth = this.mFormLineWidth;
    paramBaseDataSet.mFormSize = this.mFormSize;
    paramBaseDataSet.mGradientColor = this.mGradientColor;
    paramBaseDataSet.mGradientColors = this.mGradientColors;
    paramBaseDataSet.mHighlightEnabled = this.mHighlightEnabled;
    paramBaseDataSet.mIconsOffset = this.mIconsOffset;
    paramBaseDataSet.mValueColors = this.mValueColors;
    paramBaseDataSet.mValueFormatter = this.mValueFormatter;
    paramBaseDataSet.mValueColors = this.mValueColors;
    paramBaseDataSet.mValueTextSize = this.mValueTextSize;
    paramBaseDataSet.mVisible = this.mVisible;
  }
  
  public YAxis.AxisDependency getAxisDependency()
  {
    return this.mAxisDependency;
  }
  
  public int getColor()
  {
    return ((Integer)this.mColors.get(0)).intValue();
  }
  
  public int getColor(int paramInt)
  {
    List localList = this.mColors;
    return ((Integer)localList.get(paramInt % localList.size())).intValue();
  }
  
  public List<Integer> getColors()
  {
    return this.mColors;
  }
  
  public Legend.LegendForm getForm()
  {
    return this.mForm;
  }
  
  public DashPathEffect getFormLineDashEffect()
  {
    return this.mFormLineDashEffect;
  }
  
  public float getFormLineWidth()
  {
    return this.mFormLineWidth;
  }
  
  public float getFormSize()
  {
    return this.mFormSize;
  }
  
  public GradientColor getGradientColor()
  {
    return this.mGradientColor;
  }
  
  public GradientColor getGradientColor(int paramInt)
  {
    List localList = this.mGradientColors;
    return (GradientColor)localList.get(paramInt % localList.size());
  }
  
  public List<GradientColor> getGradientColors()
  {
    return this.mGradientColors;
  }
  
  public MPPointF getIconsOffset()
  {
    return this.mIconsOffset;
  }
  
  public int getIndexInEntries(int paramInt)
  {
    for (int i = 0; i < getEntryCount(); i++) {
      if (paramInt == getEntryForIndex(i).getX()) {
        return i;
      }
    }
    return -1;
  }
  
  public String getLabel()
  {
    return this.mLabel;
  }
  
  public List<Integer> getValueColors()
  {
    return this.mValueColors;
  }
  
  public ValueFormatter getValueFormatter()
  {
    if (needsFormatter()) {
      return Utils.getDefaultValueFormatter();
    }
    return this.mValueFormatter;
  }
  
  public int getValueTextColor()
  {
    return ((Integer)this.mValueColors.get(0)).intValue();
  }
  
  public int getValueTextColor(int paramInt)
  {
    List localList = this.mValueColors;
    return ((Integer)localList.get(paramInt % localList.size())).intValue();
  }
  
  public float getValueTextSize()
  {
    return this.mValueTextSize;
  }
  
  public Typeface getValueTypeface()
  {
    return this.mValueTypeface;
  }
  
  public boolean isDrawIconsEnabled()
  {
    return this.mDrawIcons;
  }
  
  public boolean isDrawValuesEnabled()
  {
    return this.mDrawValues;
  }
  
  public boolean isHighlightEnabled()
  {
    return this.mHighlightEnabled;
  }
  
  public boolean isVisible()
  {
    return this.mVisible;
  }
  
  public boolean needsFormatter()
  {
    boolean bool;
    if (this.mValueFormatter == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void notifyDataSetChanged()
  {
    calcMinMax();
  }
  
  public boolean removeEntry(int paramInt)
  {
    return removeEntry(getEntryForIndex(paramInt));
  }
  
  public boolean removeEntryByXValue(float paramFloat)
  {
    return removeEntry(getEntryForXValue(paramFloat, NaN.0F));
  }
  
  public boolean removeFirst()
  {
    if (getEntryCount() > 0) {
      return removeEntry(getEntryForIndex(0));
    }
    return false;
  }
  
  public boolean removeLast()
  {
    if (getEntryCount() > 0) {
      return removeEntry(getEntryForIndex(getEntryCount() - 1));
    }
    return false;
  }
  
  public void resetColors()
  {
    if (this.mColors == null) {
      this.mColors = new ArrayList();
    }
    this.mColors.clear();
  }
  
  public void setAxisDependency(YAxis.AxisDependency paramAxisDependency)
  {
    this.mAxisDependency = paramAxisDependency;
  }
  
  public void setColor(int paramInt)
  {
    resetColors();
    this.mColors.add(Integer.valueOf(paramInt));
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    setColor(Color.argb(paramInt2, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1)));
  }
  
  public void setColors(List<Integer> paramList)
  {
    this.mColors = paramList;
  }
  
  public void setColors(int... paramVarArgs)
  {
    this.mColors = ColorTemplate.createColors(paramVarArgs);
  }
  
  public void setColors(int[] paramArrayOfInt, int paramInt)
  {
    resetColors();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      addColor(Color.argb(paramInt, Color.red(k), Color.green(k), Color.blue(k)));
    }
  }
  
  public void setColors(int[] paramArrayOfInt, Context paramContext)
  {
    if (this.mColors == null) {
      this.mColors = new ArrayList();
    }
    this.mColors.clear();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      this.mColors.add(Integer.valueOf(paramContext.getResources().getColor(k)));
    }
  }
  
  public void setDrawIcons(boolean paramBoolean)
  {
    this.mDrawIcons = paramBoolean;
  }
  
  public void setDrawValues(boolean paramBoolean)
  {
    this.mDrawValues = paramBoolean;
  }
  
  public void setForm(Legend.LegendForm paramLegendForm)
  {
    this.mForm = paramLegendForm;
  }
  
  public void setFormLineDashEffect(DashPathEffect paramDashPathEffect)
  {
    this.mFormLineDashEffect = paramDashPathEffect;
  }
  
  public void setFormLineWidth(float paramFloat)
  {
    this.mFormLineWidth = paramFloat;
  }
  
  public void setFormSize(float paramFloat)
  {
    this.mFormSize = paramFloat;
  }
  
  public void setGradientColor(int paramInt1, int paramInt2)
  {
    this.mGradientColor = new GradientColor(paramInt1, paramInt2);
  }
  
  public void setGradientColors(List<GradientColor> paramList)
  {
    this.mGradientColors = paramList;
  }
  
  public void setHighlightEnabled(boolean paramBoolean)
  {
    this.mHighlightEnabled = paramBoolean;
  }
  
  public void setIconsOffset(MPPointF paramMPPointF)
  {
    MPPointF localMPPointF = this.mIconsOffset;
    localMPPointF.x = paramMPPointF.x;
    localMPPointF.y = paramMPPointF.y;
  }
  
  public void setLabel(String paramString)
  {
    this.mLabel = paramString;
  }
  
  public void setValueFormatter(ValueFormatter paramValueFormatter)
  {
    if (paramValueFormatter == null) {
      return;
    }
    this.mValueFormatter = paramValueFormatter;
  }
  
  public void setValueTextColor(int paramInt)
  {
    this.mValueColors.clear();
    this.mValueColors.add(Integer.valueOf(paramInt));
  }
  
  public void setValueTextColors(List<Integer> paramList)
  {
    this.mValueColors = paramList;
  }
  
  public void setValueTextSize(float paramFloat)
  {
    this.mValueTextSize = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setValueTypeface(Typeface paramTypeface)
  {
    this.mValueTypeface = paramTypeface;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.mVisible = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BaseDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */