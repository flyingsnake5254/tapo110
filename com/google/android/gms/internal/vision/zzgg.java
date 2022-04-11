package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgg
  extends zzfc<Double>
  implements zzhe<Double>, zzit, RandomAccess
{
  private static final zzgg zzti;
  private int size;
  private double[] zztj;
  
  static
  {
    zzgg localzzgg = new zzgg(new double[0], 0);
    zzti = localzzgg;
    localzzgg.zzdq();
  }
  
  zzgg()
  {
    this(new double[10], 0);
  }
  
  private zzgg(double[] paramArrayOfDouble, int paramInt)
  {
    this.zztj = paramArrayOfDouble;
    this.size = paramInt;
  }
  
  private final void zzaf(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzag(paramInt));
  }
  
  private final String zzag(int paramInt)
  {
    int i = this.size;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Double> paramCollection)
  {
    zzdr();
    zzgy.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzgg)) {
      return super.addAll(paramCollection);
    }
    zzgg localzzgg = (zzgg)paramCollection;
    int i = localzzgg.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      paramCollection = this.zztj;
      if (i > paramCollection.length) {
        this.zztj = Arrays.copyOf(paramCollection, i);
      }
      System.arraycopy(localzzgg.zztj, 0, this.zztj, this.size, localzzgg.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzgg)) {
      return super.equals(paramObject);
    }
    paramObject = (zzgg)paramObject;
    if (this.size != ((zzgg)paramObject).size) {
      return false;
    }
    paramObject = ((zzgg)paramObject).zztj;
    for (int i = 0; i < this.size; i++) {
      if (Double.doubleToLongBits(this.zztj[i]) != Double.doubleToLongBits(paramObject[i])) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + zzgy.zzab(Double.doubleToLongBits(this.zztj[j]));
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Double)) {
      return -1;
    }
    double d = ((Double)paramObject).doubleValue();
    int i = size();
    for (int j = 0; j < i; j++) {
      if (this.zztj[j] == d) {
        return j;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzdr();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Double.valueOf(this.zztj[i])))
      {
        paramObject = this.zztj;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.size - i - 1);
        this.size -= 1;
        this.modCount += 1;
        return true;
      }
    }
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzdr();
    if (paramInt2 >= paramInt1)
    {
      double[] arrayOfDouble = this.zztj;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size()
  {
    return this.size;
  }
  
  public final void zzc(double paramDouble)
  {
    zzdr();
    int i = this.size;
    double[] arrayOfDouble1 = this.zztj;
    if (i == arrayOfDouble1.length)
    {
      double[] arrayOfDouble2 = new double[i * 3 / 2 + 1];
      System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, i);
      this.zztj = arrayOfDouble2;
    }
    arrayOfDouble1 = this.zztj;
    i = this.size;
    this.size = (i + 1);
    arrayOfDouble1[i] = paramDouble;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */