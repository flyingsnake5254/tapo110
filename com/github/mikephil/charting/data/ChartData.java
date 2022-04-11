package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>>
{
  protected List<T> mDataSets;
  protected float mLeftAxisMax = -3.4028235E38F;
  protected float mLeftAxisMin = Float.MAX_VALUE;
  protected float mRightAxisMax = -3.4028235E38F;
  protected float mRightAxisMin = Float.MAX_VALUE;
  protected float mXMax = -3.4028235E38F;
  protected float mXMin = Float.MAX_VALUE;
  protected float mYMax = -3.4028235E38F;
  protected float mYMin = Float.MAX_VALUE;
  
  public ChartData()
  {
    this.mDataSets = new ArrayList();
  }
  
  public ChartData(List<T> paramList)
  {
    this.mDataSets = paramList;
    notifyDataChanged();
  }
  
  public ChartData(T... paramVarArgs)
  {
    this.mDataSets = arrayToList(paramVarArgs);
    notifyDataChanged();
  }
  
  private List<T> arrayToList(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(paramArrayOfT[j]);
    }
    return localArrayList;
  }
  
  public void addDataSet(T paramT)
  {
    if (paramT == null) {
      return;
    }
    calcMinMax(paramT);
    this.mDataSets.add(paramT);
  }
  
  public void addEntry(Entry paramEntry, int paramInt)
  {
    if ((this.mDataSets.size() > paramInt) && (paramInt >= 0))
    {
      IDataSet localIDataSet = (IDataSet)this.mDataSets.get(paramInt);
      if (!localIDataSet.addEntry(paramEntry)) {
        return;
      }
      calcMinMax(paramEntry, localIDataSet.getAxisDependency());
    }
    else
    {
      Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
    }
  }
  
  protected void calcMinMax()
  {
    Object localObject1 = this.mDataSets;
    if (localObject1 == null) {
      return;
    }
    this.mYMax = -3.4028235E38F;
    this.mYMin = Float.MAX_VALUE;
    this.mXMax = -3.4028235E38F;
    this.mXMin = Float.MAX_VALUE;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      calcMinMax((IDataSet)((Iterator)localObject1).next());
    }
    this.mLeftAxisMax = -3.4028235E38F;
    this.mLeftAxisMin = Float.MAX_VALUE;
    this.mRightAxisMax = -3.4028235E38F;
    this.mRightAxisMin = Float.MAX_VALUE;
    localObject1 = getFirstLeft(this.mDataSets);
    Object localObject2;
    if (localObject1 != null)
    {
      this.mLeftAxisMax = ((IDataSet)localObject1).getYMax();
      this.mLeftAxisMin = ((IDataSet)localObject1).getYMin();
      localObject2 = this.mDataSets.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (IDataSet)((Iterator)localObject2).next();
        if (((IDataSet)localObject1).getAxisDependency() == YAxis.AxisDependency.LEFT)
        {
          if (((IDataSet)localObject1).getYMin() < this.mLeftAxisMin) {
            this.mLeftAxisMin = ((IDataSet)localObject1).getYMin();
          }
          if (((IDataSet)localObject1).getYMax() > this.mLeftAxisMax) {
            this.mLeftAxisMax = ((IDataSet)localObject1).getYMax();
          }
        }
      }
    }
    localObject1 = getFirstRight(this.mDataSets);
    if (localObject1 != null)
    {
      this.mRightAxisMax = ((IDataSet)localObject1).getYMax();
      this.mRightAxisMin = ((IDataSet)localObject1).getYMin();
      localObject1 = this.mDataSets.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IDataSet)((Iterator)localObject1).next();
        if (((IDataSet)localObject2).getAxisDependency() == YAxis.AxisDependency.RIGHT)
        {
          if (((IDataSet)localObject2).getYMin() < this.mRightAxisMin) {
            this.mRightAxisMin = ((IDataSet)localObject2).getYMin();
          }
          if (((IDataSet)localObject2).getYMax() > this.mRightAxisMax) {
            this.mRightAxisMax = ((IDataSet)localObject2).getYMax();
          }
        }
      }
    }
  }
  
  protected void calcMinMax(Entry paramEntry, YAxis.AxisDependency paramAxisDependency)
  {
    if (this.mYMax < paramEntry.getY()) {
      this.mYMax = paramEntry.getY();
    }
    if (this.mYMin > paramEntry.getY()) {
      this.mYMin = paramEntry.getY();
    }
    if (this.mXMax < paramEntry.getX()) {
      this.mXMax = paramEntry.getX();
    }
    if (this.mXMin > paramEntry.getX()) {
      this.mXMin = paramEntry.getX();
    }
    if (paramAxisDependency == YAxis.AxisDependency.LEFT)
    {
      if (this.mLeftAxisMax < paramEntry.getY()) {
        this.mLeftAxisMax = paramEntry.getY();
      }
      if (this.mLeftAxisMin > paramEntry.getY()) {
        this.mLeftAxisMin = paramEntry.getY();
      }
    }
    else
    {
      if (this.mRightAxisMax < paramEntry.getY()) {
        this.mRightAxisMax = paramEntry.getY();
      }
      if (this.mRightAxisMin > paramEntry.getY()) {
        this.mRightAxisMin = paramEntry.getY();
      }
    }
  }
  
  protected void calcMinMax(T paramT)
  {
    if (this.mYMax < paramT.getYMax()) {
      this.mYMax = paramT.getYMax();
    }
    if (this.mYMin > paramT.getYMin()) {
      this.mYMin = paramT.getYMin();
    }
    if (this.mXMax < paramT.getXMax()) {
      this.mXMax = paramT.getXMax();
    }
    if (this.mXMin > paramT.getXMin()) {
      this.mXMin = paramT.getXMin();
    }
    if (paramT.getAxisDependency() == YAxis.AxisDependency.LEFT)
    {
      if (this.mLeftAxisMax < paramT.getYMax()) {
        this.mLeftAxisMax = paramT.getYMax();
      }
      if (this.mLeftAxisMin > paramT.getYMin()) {
        this.mLeftAxisMin = paramT.getYMin();
      }
    }
    else
    {
      if (this.mRightAxisMax < paramT.getYMax()) {
        this.mRightAxisMax = paramT.getYMax();
      }
      if (this.mRightAxisMin > paramT.getYMin()) {
        this.mRightAxisMin = paramT.getYMin();
      }
    }
  }
  
  public void calcMinMaxY(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).calcMinMaxY(paramFloat1, paramFloat2);
    }
    calcMinMax();
  }
  
  public void clearValues()
  {
    List localList = this.mDataSets;
    if (localList != null) {
      localList.clear();
    }
    notifyDataChanged();
  }
  
  public boolean contains(T paramT)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      if (((IDataSet)localIterator.next()).equals(paramT)) {
        return true;
      }
    }
    return false;
  }
  
  public int[] getColors()
  {
    if (this.mDataSets == null) {
      return null;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < this.mDataSets.size())
    {
      k += ((IDataSet)this.mDataSets.get(j)).getColors().size();
      j++;
    }
    int[] arrayOfInt = new int[k];
    k = 0;
    for (j = i; j < this.mDataSets.size(); j++)
    {
      Iterator localIterator = ((IDataSet)this.mDataSets.get(j)).getColors().iterator();
      while (localIterator.hasNext())
      {
        arrayOfInt[k] = ((Integer)localIterator.next()).intValue();
        k++;
      }
    }
    return arrayOfInt;
  }
  
  public T getDataSetByIndex(int paramInt)
  {
    List localList = this.mDataSets;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (IDataSet)this.mDataSets.get(paramInt);
    }
    return null;
  }
  
  public T getDataSetByLabel(String paramString, boolean paramBoolean)
  {
    int i = getDataSetIndexByLabel(this.mDataSets, paramString, paramBoolean);
    if ((i >= 0) && (i < this.mDataSets.size())) {
      return (IDataSet)this.mDataSets.get(i);
    }
    return null;
  }
  
  public int getDataSetCount()
  {
    List localList = this.mDataSets;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public T getDataSetForEntry(Entry paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    for (int i = 0; i < this.mDataSets.size(); i++)
    {
      IDataSet localIDataSet = (IDataSet)this.mDataSets.get(i);
      for (int j = 0; j < localIDataSet.getEntryCount(); j++) {
        if (paramEntry.equalTo(localIDataSet.getEntryForXValue(paramEntry.getX(), paramEntry.getY()))) {
          return localIDataSet;
        }
      }
    }
    return null;
  }
  
  protected int getDataSetIndexByLabel(List<T> paramList, String paramString, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean) {
      for (i = j; i < paramList.size(); i++) {
        if (paramString.equalsIgnoreCase(((IDataSet)paramList.get(i)).getLabel())) {
          return i;
        }
      }
    }
    while (i < paramList.size())
    {
      if (paramString.equals(((IDataSet)paramList.get(i)).getLabel())) {
        return i;
      }
      i++;
    }
    return -1;
  }
  
  public String[] getDataSetLabels()
  {
    String[] arrayOfString = new String[this.mDataSets.size()];
    for (int i = 0; i < this.mDataSets.size(); i++) {
      arrayOfString[i] = ((IDataSet)this.mDataSets.get(i)).getLabel();
    }
    return arrayOfString;
  }
  
  public List<T> getDataSets()
  {
    return this.mDataSets;
  }
  
  public int getEntryCount()
  {
    Iterator localIterator = this.mDataSets.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((IDataSet)localIterator.next()).getEntryCount();
    }
    return i;
  }
  
  public Entry getEntryForHighlight(Highlight paramHighlight)
  {
    if (paramHighlight.getDataSetIndex() >= this.mDataSets.size()) {
      return null;
    }
    return ((IDataSet)this.mDataSets.get(paramHighlight.getDataSetIndex())).getEntryForXValue(paramHighlight.getX(), paramHighlight.getY());
  }
  
  protected T getFirstLeft(List<T> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (IDataSet)localIterator.next();
      if (paramList.getAxisDependency() == YAxis.AxisDependency.LEFT) {
        return paramList;
      }
    }
    return null;
  }
  
  public T getFirstRight(List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IDataSet localIDataSet = (IDataSet)paramList.next();
      if (localIDataSet.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
        return localIDataSet;
      }
    }
    return null;
  }
  
  public int getIndexOfDataSet(T paramT)
  {
    return this.mDataSets.indexOf(paramT);
  }
  
  public T getMaxEntryCountSet()
  {
    Object localObject = this.mDataSets;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (IDataSet)this.mDataSets.get(0);
      Iterator localIterator = this.mDataSets.iterator();
      while (localIterator.hasNext())
      {
        IDataSet localIDataSet = (IDataSet)localIterator.next();
        if (localIDataSet.getEntryCount() > ((IDataSet)localObject).getEntryCount()) {
          localObject = localIDataSet;
        }
      }
      return (T)localObject;
    }
    return null;
  }
  
  public float getXMax()
  {
    return this.mXMax;
  }
  
  public float getXMin()
  {
    return this.mXMin;
  }
  
  public float getYMax()
  {
    return this.mYMax;
  }
  
  public float getYMax(YAxis.AxisDependency paramAxisDependency)
  {
    if (paramAxisDependency == YAxis.AxisDependency.LEFT)
    {
      f1 = this.mLeftAxisMax;
      f2 = f1;
      if (f1 == -3.4028235E38F) {
        f2 = this.mRightAxisMax;
      }
      return f2;
    }
    float f1 = this.mRightAxisMax;
    float f2 = f1;
    if (f1 == -3.4028235E38F) {
      f2 = this.mLeftAxisMax;
    }
    return f2;
  }
  
  public float getYMin()
  {
    return this.mYMin;
  }
  
  public float getYMin(YAxis.AxisDependency paramAxisDependency)
  {
    if (paramAxisDependency == YAxis.AxisDependency.LEFT)
    {
      f1 = this.mLeftAxisMin;
      f2 = f1;
      if (f1 == Float.MAX_VALUE) {
        f2 = this.mRightAxisMin;
      }
      return f2;
    }
    float f1 = this.mRightAxisMin;
    float f2 = f1;
    if (f1 == Float.MAX_VALUE) {
      f2 = this.mLeftAxisMin;
    }
    return f2;
  }
  
  public boolean isHighlightEnabled()
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      if (!((IDataSet)localIterator.next()).isHighlightEnabled()) {
        return false;
      }
    }
    return true;
  }
  
  public void notifyDataChanged()
  {
    calcMinMax();
  }
  
  public boolean removeDataSet(int paramInt)
  {
    if ((paramInt < this.mDataSets.size()) && (paramInt >= 0)) {
      return removeDataSet((IDataSet)this.mDataSets.get(paramInt));
    }
    return false;
  }
  
  public boolean removeDataSet(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    boolean bool = this.mDataSets.remove(paramT);
    if (bool) {
      calcMinMax();
    }
    return bool;
  }
  
  public boolean removeEntry(float paramFloat, int paramInt)
  {
    if (paramInt >= this.mDataSets.size()) {
      return false;
    }
    Entry localEntry = ((IDataSet)this.mDataSets.get(paramInt)).getEntryForXValue(paramFloat, NaN.0F);
    if (localEntry == null) {
      return false;
    }
    return removeEntry(localEntry, paramInt);
  }
  
  public boolean removeEntry(Entry paramEntry, int paramInt)
  {
    if ((paramEntry != null) && (paramInt < this.mDataSets.size()))
    {
      IDataSet localIDataSet = (IDataSet)this.mDataSets.get(paramInt);
      if (localIDataSet != null)
      {
        boolean bool = localIDataSet.removeEntry(paramEntry);
        if (bool) {
          calcMinMax();
        }
        return bool;
      }
    }
    return false;
  }
  
  public void setDrawValues(boolean paramBoolean)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setDrawValues(paramBoolean);
    }
  }
  
  public void setHighlightEnabled(boolean paramBoolean)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setHighlightEnabled(paramBoolean);
    }
  }
  
  public void setValueFormatter(ValueFormatter paramValueFormatter)
  {
    if (paramValueFormatter == null) {
      return;
    }
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setValueFormatter(paramValueFormatter);
    }
  }
  
  public void setValueTextColor(int paramInt)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setValueTextColor(paramInt);
    }
  }
  
  public void setValueTextColors(List<Integer> paramList)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setValueTextColors(paramList);
    }
  }
  
  public void setValueTextSize(float paramFloat)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setValueTextSize(paramFloat);
    }
  }
  
  public void setValueTypeface(Typeface paramTypeface)
  {
    Iterator localIterator = this.mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IDataSet)localIterator.next()).setValueTypeface(paramTypeface);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\ChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */