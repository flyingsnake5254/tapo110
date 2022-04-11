package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhv
  extends zzfc<Long>
  implements zzhe<Long>, zzit, RandomAccess
{
  private static final zzhv zzyy;
  private int size;
  private long[] zzyz;
  
  static
  {
    zzhv localzzhv = new zzhv(new long[0], 0);
    zzyy = localzzhv;
    localzzhv.zzdq();
  }
  
  zzhv()
  {
    this(new long[10], 0);
  }
  
  private zzhv(long[] paramArrayOfLong, int paramInt)
  {
    this.zzyz = paramArrayOfLong;
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
  
  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    zzdr();
    zzgy.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzhv)) {
      return super.addAll(paramCollection);
    }
    zzhv localzzhv = (zzhv)paramCollection;
    int i = localzzhv.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      paramCollection = this.zzyz;
      if (j > paramCollection.length) {
        this.zzyz = Arrays.copyOf(paramCollection, j);
      }
      System.arraycopy(localzzhv.zzyz, 0, this.zzyz, this.size, localzzhv.size);
      this.size = j;
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
    if (!(paramObject instanceof zzhv)) {
      return super.equals(paramObject);
    }
    paramObject = (zzhv)paramObject;
    if (this.size != ((zzhv)paramObject).size) {
      return false;
    }
    paramObject = ((zzhv)paramObject).zzyz;
    for (int i = 0; i < this.size; i++) {
      if (this.zzyz[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final long getLong(int paramInt)
  {
    zzaf(paramInt);
    return this.zzyz[paramInt];
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + zzgy.zzab(this.zzyz[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Long)) {
      return -1;
    }
    long l = ((Long)paramObject).longValue();
    int i = size();
    for (int j = 0; j < i; j++) {
      if (this.zzyz[j] == l) {
        return j;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzdr();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Long.valueOf(this.zzyz[i])))
      {
        paramObject = this.zzyz;
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
      long[] arrayOfLong = this.zzyz;
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
  
  public final void zzac(long paramLong)
  {
    zzdr();
    int i = this.size;
    long[] arrayOfLong1 = this.zzyz;
    if (i == arrayOfLong1.length)
    {
      arrayOfLong2 = new long[i * 3 / 2 + 1];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, i);
      this.zzyz = arrayOfLong2;
    }
    long[] arrayOfLong2 = this.zzyz;
    i = this.size;
    this.size = (i + 1);
    arrayOfLong2[i] = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */