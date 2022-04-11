package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class DataSet<T extends Entry>
  extends BaseDataSet<T>
{
  protected List<T> mValues = null;
  protected float mXMax = -3.4028235E38F;
  protected float mXMin = Float.MAX_VALUE;
  protected float mYMax = -3.4028235E38F;
  protected float mYMin = Float.MAX_VALUE;
  
  public DataSet(List<T> paramList, String paramString)
  {
    super(paramString);
    this.mValues = paramList;
    if (paramList == null) {
      this.mValues = new ArrayList();
    }
    calcMinMax();
  }
  
  public boolean addEntry(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    List localList = getValues();
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    calcMinMax(paramT);
    return ((List)localObject).add(paramT);
  }
  
  public void addEntryOrdered(T paramT)
  {
    if (paramT == null) {
      return;
    }
    if (this.mValues == null) {
      this.mValues = new ArrayList();
    }
    calcMinMax(paramT);
    if (this.mValues.size() > 0)
    {
      List localList = this.mValues;
      if (((Entry)localList.get(localList.size() - 1)).getX() > paramT.getX())
      {
        int i = getEntryIndex(paramT.getX(), paramT.getY(), Rounding.UP);
        this.mValues.add(i, paramT);
        return;
      }
    }
    this.mValues.add(paramT);
  }
  
  public void calcMinMax()
  {
    Object localObject = this.mValues;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.mYMax = -3.4028235E38F;
      this.mYMin = Float.MAX_VALUE;
      this.mXMax = -3.4028235E38F;
      this.mXMin = Float.MAX_VALUE;
      localObject = this.mValues.iterator();
      while (((Iterator)localObject).hasNext()) {
        calcMinMax((Entry)((Iterator)localObject).next());
      }
    }
  }
  
  protected void calcMinMax(T paramT)
  {
    if (paramT == null) {
      return;
    }
    calcMinMaxX(paramT);
    calcMinMaxY(paramT);
  }
  
  protected void calcMinMaxX(T paramT)
  {
    if (paramT.getX() < this.mXMin) {
      this.mXMin = paramT.getX();
    }
    if (paramT.getX() > this.mXMax) {
      this.mXMax = paramT.getX();
    }
  }
  
  public void calcMinMaxY(float paramFloat1, float paramFloat2)
  {
    List localList = this.mValues;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.mYMax = -3.4028235E38F;
      this.mYMin = Float.MAX_VALUE;
      int i = getEntryIndex(paramFloat1, NaN.0F, Rounding.DOWN);
      int j = getEntryIndex(paramFloat2, NaN.0F, Rounding.UP);
      while (i <= j)
      {
        calcMinMaxY((Entry)this.mValues.get(i));
        i++;
      }
    }
  }
  
  protected void calcMinMaxY(T paramT)
  {
    if (paramT.getY() < this.mYMin) {
      this.mYMin = paramT.getY();
    }
    if (paramT.getY() > this.mYMax) {
      this.mYMax = paramT.getY();
    }
  }
  
  public void clear()
  {
    this.mValues.clear();
    notifyDataSetChanged();
  }
  
  public abstract DataSet<T> copy();
  
  protected void copy(DataSet paramDataSet)
  {
    super.copy(paramDataSet);
  }
  
  public List<T> getEntriesForXValue(float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.mValues.size() - 1;
    int j = 0;
    while (j <= i)
    {
      int k = (i + j) / 2;
      Entry localEntry = (Entry)this.mValues.get(k);
      if (paramFloat == localEntry.getX())
      {
        for (j = k; (j > 0) && (((Entry)this.mValues.get(j - 1)).getX() == paramFloat); j--) {}
        i = this.mValues.size();
        while (j < i)
        {
          localEntry = (Entry)this.mValues.get(j);
          if (localEntry.getX() != paramFloat) {
            break;
          }
          localArrayList.add(localEntry);
          j++;
        }
      }
      if (paramFloat > localEntry.getX()) {
        j = k + 1;
      } else {
        i = k - 1;
      }
    }
    return localArrayList;
  }
  
  public int getEntryCount()
  {
    return this.mValues.size();
  }
  
  public T getEntryForIndex(int paramInt)
  {
    return (Entry)this.mValues.get(paramInt);
  }
  
  public T getEntryForXValue(float paramFloat1, float paramFloat2)
  {
    return getEntryForXValue(paramFloat1, paramFloat2, Rounding.CLOSEST);
  }
  
  public T getEntryForXValue(float paramFloat1, float paramFloat2, Rounding paramRounding)
  {
    int i = getEntryIndex(paramFloat1, paramFloat2, paramRounding);
    if (i > -1) {
      return (Entry)this.mValues.get(i);
    }
    return null;
  }
  
  public int getEntryIndex(float paramFloat1, float paramFloat2, Rounding paramRounding)
  {
    List localList = this.mValues;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      int j = this.mValues.size() - 1;
      float f3;
      if (i < j)
      {
        int k = (i + j) / 2;
        float f1 = ((Entry)this.mValues.get(k)).getX() - paramFloat1;
        localList = this.mValues;
        m = k + 1;
        float f2 = ((Entry)localList.get(m)).getX();
        f3 = Math.abs(f1);
        f2 = Math.abs(f2 - paramFloat1);
        if (f2 < f3) {}
        for (;;)
        {
          i = m;
          break;
          double d;
          if (f3 >= f2)
          {
            d = f1;
            if (d < 0.0D) {}
          }
          else
          {
            j = k;
            break;
          }
          if (d >= 0.0D) {
            break;
          }
        }
      }
      int m = j;
      if (j != -1)
      {
        f3 = ((Entry)this.mValues.get(j)).getX();
        if (paramRounding == Rounding.UP)
        {
          i = j;
          if (f3 < paramFloat1)
          {
            i = j;
            if (j < this.mValues.size() - 1) {
              i = j + 1;
            }
          }
        }
        else
        {
          i = j;
          if (paramRounding == Rounding.DOWN)
          {
            i = j;
            if (f3 > paramFloat1)
            {
              i = j;
              if (j > 0) {
                i = j - 1;
              }
            }
          }
        }
        m = i;
        if (!Float.isNaN(paramFloat2))
        {
          while ((i > 0) && (((Entry)this.mValues.get(i - 1)).getX() == f3)) {
            i--;
          }
          paramFloat1 = ((Entry)this.mValues.get(i)).getY();
          for (;;)
          {
            j = i;
            do
            {
              m = j + 1;
              if (m < this.mValues.size())
              {
                paramRounding = (Entry)this.mValues.get(m);
                if (paramRounding.getX() == f3) {}
              }
              else
              {
                m = i;
                break;
              }
              j = m;
            } while (Math.abs(paramRounding.getY() - paramFloat2) >= Math.abs(paramFloat1 - paramFloat2));
            paramFloat1 = paramFloat2;
            i = m;
          }
        }
      }
      return m;
    }
    return -1;
  }
  
  public int getEntryIndex(Entry paramEntry)
  {
    return this.mValues.indexOf(paramEntry);
  }
  
  public List<T> getValues()
  {
    return this.mValues;
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
  
  public float getYMin()
  {
    return this.mYMin;
  }
  
  public boolean removeEntry(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    List localList = this.mValues;
    if (localList == null) {
      return false;
    }
    boolean bool = localList.remove(paramT);
    if (bool) {
      calcMinMax();
    }
    return bool;
  }
  
  public void setValues(List<T> paramList)
  {
    this.mValues = paramList;
    notifyDataSetChanged();
  }
  
  public String toSimpleString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataSet, label: ");
    String str;
    if (getLabel() == null) {
      str = "";
    } else {
      str = getLabel();
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", entries: ");
    localStringBuilder.append(this.mValues.size());
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(toSimpleString());
    for (int i = 0; i < this.mValues.size(); i++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Entry)this.mValues.get(i)).toString());
      localStringBuilder.append(" ");
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static enum Rounding
  {
    static
    {
      Rounding localRounding1 = new Rounding("UP", 0);
      UP = localRounding1;
      Rounding localRounding2 = new Rounding("DOWN", 1);
      DOWN = localRounding2;
      Rounding localRounding3 = new Rounding("CLOSEST", 2);
      CLOSEST = localRounding3;
      $VALUES = new Rounding[] { localRounding1, localRounding2, localRounding3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */