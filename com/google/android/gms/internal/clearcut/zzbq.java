package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbq
  extends zzav<Double>
  implements zzcn<Double>, RandomAccess
{
  private static final zzbq zzgj;
  private int size;
  private double[] zzgk;
  
  static
  {
    zzbq localzzbq = new zzbq();
    zzgj = localzzbq;
    localzzbq.zzv();
  }
  
  zzbq()
  {
    this(new double[10], 0);
  }
  
  private zzbq(double[] paramArrayOfDouble, int paramInt)
  {
    this.zzgk = paramArrayOfDouble;
    this.size = paramInt;
  }
  
  private final void zzc(int paramInt, double paramDouble)
  {
    zzw();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        double[] arrayOfDouble1 = this.zzgk;
        if (i < arrayOfDouble1.length)
        {
          System.arraycopy(arrayOfDouble1, paramInt, arrayOfDouble1, paramInt + 1, i - paramInt);
        }
        else
        {
          double[] arrayOfDouble2 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, paramInt);
          System.arraycopy(this.zzgk, paramInt, arrayOfDouble2, paramInt + 1, this.size - paramInt);
          this.zzgk = arrayOfDouble2;
        }
        this.zzgk[paramInt] = paramDouble;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  private final void zzg(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  private final String zzh(int paramInt)
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
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzbq)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzbq)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      double[] arrayOfDouble = this.zzgk;
      if (j > arrayOfDouble.length) {
        this.zzgk = Arrays.copyOf(arrayOfDouble, j);
      }
      System.arraycopy(paramCollection.zzgk, 0, this.zzgk, this.size, paramCollection.size);
      this.size = j;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzbq)) {
      return super.equals(paramObject);
    }
    paramObject = (zzbq)paramObject;
    if (this.size != ((zzbq)paramObject).size) {
      return false;
    }
    paramObject = ((zzbq)paramObject).zzgk;
    for (int i = 0; i < this.size; i++) {
      if (this.zzgk[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + zzci.zzl(Double.doubleToLongBits(this.zzgk[j]));
    }
    return i;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzw();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Double.valueOf(this.zzgk[i])))
      {
        paramObject = this.zzgk;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.size - i);
        this.size -= 1;
        this.modCount += 1;
        return true;
      }
    }
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzw();
    if (paramInt2 >= paramInt1)
    {
      double[] arrayOfDouble = this.zzgk;
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
    zzc(this.size, paramDouble);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */