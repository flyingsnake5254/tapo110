package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdc
  extends zzav<Long>
  implements zzcn<Long>, RandomAccess
{
  private static final zzdc zzlw;
  private int size;
  private long[] zzlx;
  
  static
  {
    zzdc localzzdc = new zzdc();
    zzlw = localzzdc;
    localzzdc.zzv();
  }
  
  zzdc()
  {
    this(new long[10], 0);
  }
  
  private zzdc(long[] paramArrayOfLong, int paramInt)
  {
    this.zzlx = paramArrayOfLong;
    this.size = paramInt;
  }
  
  public static zzdc zzbx()
  {
    return zzlw;
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
  
  private final void zzk(int paramInt, long paramLong)
  {
    zzw();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        long[] arrayOfLong1 = this.zzlx;
        if (i < arrayOfLong1.length)
        {
          System.arraycopy(arrayOfLong1, paramInt, arrayOfLong1, paramInt + 1, i - paramInt);
        }
        else
        {
          long[] arrayOfLong2 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, paramInt);
          System.arraycopy(this.zzlx, paramInt, arrayOfLong2, paramInt + 1, this.size - paramInt);
          this.zzlx = arrayOfLong2;
        }
        this.zzlx[paramInt] = paramLong;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzdc)) {
      return super.addAll(paramCollection);
    }
    zzdc localzzdc = (zzdc)paramCollection;
    int i = localzzdc.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      paramCollection = this.zzlx;
      if (j > paramCollection.length) {
        this.zzlx = Arrays.copyOf(paramCollection, j);
      }
      System.arraycopy(localzzdc.zzlx, 0, this.zzlx, this.size, localzzdc.size);
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
    if (!(paramObject instanceof zzdc)) {
      return super.equals(paramObject);
    }
    paramObject = (zzdc)paramObject;
    if (this.size != ((zzdc)paramObject).size) {
      return false;
    }
    paramObject = ((zzdc)paramObject).zzlx;
    for (int i = 0; i < this.size; i++) {
      if (this.zzlx[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final long getLong(int paramInt)
  {
    zzg(paramInt);
    return this.zzlx[paramInt];
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + zzci.zzl(this.zzlx[j]);
    }
    return i;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzw();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Long.valueOf(this.zzlx[i])))
      {
        paramObject = this.zzlx;
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
      long[] arrayOfLong = this.zzlx;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.size - paramInt2);
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
  
  public final void zzm(long paramLong)
  {
    zzk(this.size, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */