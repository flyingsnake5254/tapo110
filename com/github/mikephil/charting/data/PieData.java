package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import java.util.List;

public class PieData
  extends ChartData<IPieDataSet>
{
  public PieData() {}
  
  public PieData(IPieDataSet paramIPieDataSet)
  {
    super(new IPieDataSet[] { paramIPieDataSet });
  }
  
  public IPieDataSet getDataSet()
  {
    return (IPieDataSet)this.mDataSets.get(0);
  }
  
  public IPieDataSet getDataSetByIndex(int paramInt)
  {
    IPieDataSet localIPieDataSet;
    if (paramInt == 0) {
      localIPieDataSet = getDataSet();
    } else {
      localIPieDataSet = null;
    }
    return localIPieDataSet;
  }
  
  public IPieDataSet getDataSetByLabel(String paramString, boolean paramBoolean)
  {
    IPieDataSet localIPieDataSet = null;
    if (paramBoolean)
    {
      if (paramString.equalsIgnoreCase(((IPieDataSet)this.mDataSets.get(0)).getLabel())) {
        localIPieDataSet = (IPieDataSet)this.mDataSets.get(0);
      }
    }
    else if (paramString.equals(((IPieDataSet)this.mDataSets.get(0)).getLabel())) {
      localIPieDataSet = (IPieDataSet)this.mDataSets.get(0);
    }
    return localIPieDataSet;
  }
  
  public Entry getEntryForHighlight(Highlight paramHighlight)
  {
    return getDataSet().getEntryForIndex((int)paramHighlight.getX());
  }
  
  public float getYValueSum()
  {
    float f = 0.0F;
    for (int i = 0; i < getDataSet().getEntryCount(); i++) {
      f += ((PieEntry)getDataSet().getEntryForIndex(i)).getY();
    }
    return f;
  }
  
  public void setDataSet(IPieDataSet paramIPieDataSet)
  {
    this.mDataSets.clear();
    this.mDataSets.add(paramIPieDataSet);
    notifyDataChanged();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\PieData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */