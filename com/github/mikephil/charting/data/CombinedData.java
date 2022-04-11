package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinedData
  extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>>
{
  private BarData mBarData;
  private BubbleData mBubbleData;
  private CandleData mCandleData;
  private LineData mLineData;
  private ScatterData mScatterData;
  
  public void calcMinMax()
  {
    if (this.mDataSets == null) {
      this.mDataSets = new ArrayList();
    }
    this.mDataSets.clear();
    this.mYMax = -3.4028235E38F;
    this.mYMin = Float.MAX_VALUE;
    this.mXMax = -3.4028235E38F;
    this.mXMin = Float.MAX_VALUE;
    this.mLeftAxisMax = -3.4028235E38F;
    this.mLeftAxisMin = Float.MAX_VALUE;
    this.mRightAxisMax = -3.4028235E38F;
    this.mRightAxisMin = Float.MAX_VALUE;
    Iterator localIterator = getAllData().iterator();
    while (localIterator.hasNext())
    {
      ChartData localChartData = (ChartData)localIterator.next();
      localChartData.calcMinMax();
      List localList = localChartData.getDataSets();
      this.mDataSets.addAll(localList);
      if (localChartData.getYMax() > this.mYMax) {
        this.mYMax = localChartData.getYMax();
      }
      if (localChartData.getYMin() < this.mYMin) {
        this.mYMin = localChartData.getYMin();
      }
      if (localChartData.getXMax() > this.mXMax) {
        this.mXMax = localChartData.getXMax();
      }
      if (localChartData.getXMin() < this.mXMin) {
        this.mXMin = localChartData.getXMin();
      }
      float f = localChartData.mLeftAxisMax;
      if (f > this.mLeftAxisMax) {
        this.mLeftAxisMax = f;
      }
      f = localChartData.mLeftAxisMin;
      if (f < this.mLeftAxisMin) {
        this.mLeftAxisMin = f;
      }
      f = localChartData.mRightAxisMax;
      if (f > this.mRightAxisMax) {
        this.mRightAxisMax = f;
      }
      f = localChartData.mRightAxisMin;
      if (f < this.mRightAxisMin) {
        this.mRightAxisMin = f;
      }
    }
  }
  
  public List<BarLineScatterCandleBubbleData> getAllData()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mLineData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.mBarData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.mScatterData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.mCandleData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.mBubbleData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  public BarData getBarData()
  {
    return this.mBarData;
  }
  
  public BubbleData getBubbleData()
  {
    return this.mBubbleData;
  }
  
  public CandleData getCandleData()
  {
    return this.mCandleData;
  }
  
  public BarLineScatterCandleBubbleData getDataByIndex(int paramInt)
  {
    return (BarLineScatterCandleBubbleData)getAllData().get(paramInt);
  }
  
  public int getDataIndex(ChartData paramChartData)
  {
    return getAllData().indexOf(paramChartData);
  }
  
  public IBarLineScatterCandleBubbleDataSet<? extends Entry> getDataSetByHighlight(Highlight paramHighlight)
  {
    if (paramHighlight.getDataIndex() >= getAllData().size()) {
      return null;
    }
    BarLineScatterCandleBubbleData localBarLineScatterCandleBubbleData = getDataByIndex(paramHighlight.getDataIndex());
    if (paramHighlight.getDataSetIndex() >= localBarLineScatterCandleBubbleData.getDataSetCount()) {
      return null;
    }
    return (IBarLineScatterCandleBubbleDataSet)localBarLineScatterCandleBubbleData.getDataSets().get(paramHighlight.getDataSetIndex());
  }
  
  public Entry getEntryForHighlight(Highlight paramHighlight)
  {
    if (paramHighlight.getDataIndex() >= getAllData().size()) {
      return null;
    }
    Object localObject = getDataByIndex(paramHighlight.getDataIndex());
    if (paramHighlight.getDataSetIndex() >= ((ChartData)localObject).getDataSetCount()) {
      return null;
    }
    localObject = ((ChartData)localObject).getDataSetByIndex(paramHighlight.getDataSetIndex()).getEntriesForXValue(paramHighlight.getX()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entry localEntry = (Entry)((Iterator)localObject).next();
      if ((localEntry.getY() == paramHighlight.getY()) || (Float.isNaN(paramHighlight.getY()))) {
        return localEntry;
      }
    }
    return null;
  }
  
  public LineData getLineData()
  {
    return this.mLineData;
  }
  
  public ScatterData getScatterData()
  {
    return this.mScatterData;
  }
  
  public void notifyDataChanged()
  {
    Object localObject = this.mLineData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = this.mBarData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = this.mCandleData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = this.mScatterData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = this.mBubbleData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    calcMinMax();
  }
  
  @Deprecated
  public boolean removeDataSet(int paramInt)
  {
    Log.e("MPAndroidChart", "removeDataSet(int index) not supported for CombinedData");
    return false;
  }
  
  public boolean removeDataSet(IBarLineScatterCandleBubbleDataSet<? extends Entry> paramIBarLineScatterCandleBubbleDataSet)
  {
    Iterator localIterator = getAllData().iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      boolean bool2 = ((ChartData)localIterator.next()).removeDataSet(paramIBarLineScatterCandleBubbleDataSet);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  @Deprecated
  public boolean removeEntry(float paramFloat, int paramInt)
  {
    Log.e("MPAndroidChart", "removeEntry(...) not supported for CombinedData");
    return false;
  }
  
  @Deprecated
  public boolean removeEntry(Entry paramEntry, int paramInt)
  {
    Log.e("MPAndroidChart", "removeEntry(...) not supported for CombinedData");
    return false;
  }
  
  public void setData(BarData paramBarData)
  {
    this.mBarData = paramBarData;
    notifyDataChanged();
  }
  
  public void setData(BubbleData paramBubbleData)
  {
    this.mBubbleData = paramBubbleData;
    notifyDataChanged();
  }
  
  public void setData(CandleData paramCandleData)
  {
    this.mCandleData = paramCandleData;
    notifyDataChanged();
  }
  
  public void setData(LineData paramLineData)
  {
    this.mLineData = paramLineData;
    notifyDataChanged();
  }
  
  public void setData(ScatterData paramScatterData)
  {
    this.mScatterData = paramScatterData;
    notifyDataChanged();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\CombinedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */