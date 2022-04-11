package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T>
  extends AbstractDataBuffer<T>
{
  private boolean zame = false;
  private ArrayList<Integer> zamf;
  
  @KeepForSdk
  protected EntityBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private final void zacb()
  {
    try
    {
      if (!this.zame)
      {
        int i = this.mDataHolder.getCount();
        Object localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        this.zamf = ((ArrayList)localObject1);
        if (i > 0)
        {
          ((ArrayList)localObject1).add(Integer.valueOf(0));
          String str1 = getPrimaryDataMarkerColumn();
          int j = this.mDataHolder.getWindowIndex(0);
          localObject1 = this.mDataHolder.getString(str1, 0, j);
          j = 1;
          while (j < i)
          {
            int k = this.mDataHolder.getWindowIndex(j);
            String str2 = this.mDataHolder.getString(str1, j, k);
            Object localObject3;
            if (str2 != null)
            {
              localObject3 = localObject1;
              if (!str2.equals(localObject1))
              {
                this.zamf.add(Integer.valueOf(j));
                localObject3 = str2;
              }
              j++;
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = new java/lang/NullPointerException;
              i = String.valueOf(str1).length();
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>(i + 78);
              ((StringBuilder)localObject3).append("Missing value for markerColumn: ");
              ((StringBuilder)localObject3).append(str1);
              ((StringBuilder)localObject3).append(", at row: ");
              ((StringBuilder)localObject3).append(j);
              ((StringBuilder)localObject3).append(", for window: ");
              ((StringBuilder)localObject3).append(k);
              ((NullPointerException)localObject1).<init>(((StringBuilder)localObject3).toString());
              throw ((Throwable)localObject1);
            }
          }
        }
        this.zame = true;
      }
      return;
    }
    finally {}
  }
  
  private final int zah(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zamf.size())) {
      return ((Integer)this.zamf.get(paramInt)).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder(53);
    localStringBuilder.append("Position ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is out of bounds for this buffer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @KeepForSdk
  public final T get(int paramInt)
  {
    zacb();
    int i = zah(paramInt);
    int j = 0;
    int k = j;
    if (paramInt >= 0) {
      if (paramInt == this.zamf.size())
      {
        k = j;
      }
      else
      {
        int m;
        if (paramInt == this.zamf.size() - 1)
        {
          m = this.mDataHolder.getCount();
          k = ((Integer)this.zamf.get(paramInt)).intValue();
        }
        else
        {
          m = ((Integer)this.zamf.get(paramInt + 1)).intValue();
          k = ((Integer)this.zamf.get(paramInt)).intValue();
        }
        k = m - k;
        if (k == 1)
        {
          paramInt = zah(paramInt);
          m = this.mDataHolder.getWindowIndex(paramInt);
          String str = getChildDataMarkerColumn();
          if ((str != null) && (this.mDataHolder.getString(str, paramInt, m) == null)) {
            k = j;
          }
        }
      }
    }
    return (T)getEntry(i, k);
  }
  
  @KeepForSdk
  protected String getChildDataMarkerColumn()
  {
    return null;
  }
  
  @KeepForSdk
  public int getCount()
  {
    zacb();
    return this.zamf.size();
  }
  
  @KeepForSdk
  protected abstract T getEntry(int paramInt1, int paramInt2);
  
  @KeepForSdk
  protected abstract String getPrimaryDataMarkerColumn();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\EntityBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */