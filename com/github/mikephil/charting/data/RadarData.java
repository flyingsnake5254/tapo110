package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.Arrays;
import java.util.List;

public class RadarData
  extends ChartData<IRadarDataSet>
{
  private List<String> mLabels;
  
  public RadarData() {}
  
  public RadarData(List<IRadarDataSet> paramList)
  {
    super(paramList);
  }
  
  public RadarData(IRadarDataSet... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public Entry getEntryForHighlight(Highlight paramHighlight)
  {
    return ((IRadarDataSet)getDataSetByIndex(paramHighlight.getDataSetIndex())).getEntryForIndex((int)paramHighlight.getX());
  }
  
  public List<String> getLabels()
  {
    return this.mLabels;
  }
  
  public void setLabels(List<String> paramList)
  {
    this.mLabels = paramList;
  }
  
  public void setLabels(String... paramVarArgs)
  {
    this.mLabels = Arrays.asList(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\RadarData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */