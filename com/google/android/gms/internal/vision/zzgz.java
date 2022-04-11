package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgz
  extends zzfc<Integer>
  implements zzhe<Integer>, zzit, RandomAccess
{
  private static final zzgz zzxu;
  private int size;
  private int[] zzxv;
  
  static
  {
    zzgz localzzgz = new zzgz(new int[0], 0);
    zzxu = localzzgz;
    localzzgz.zzdq();
  }
  
  zzgz()
  {
    this(new int[10], 0);
  }
  
  private zzgz(int[] paramArrayOfInt, int paramInt)
  {
    this.zzxv = paramArrayOfInt;
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
  
  public static zzgz zzgm()
  {
    return zzxu;
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzdr();
    zzgy.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzgz)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzgz)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = this.zzxv;
      if (i > arrayOfInt.length) {
        this.zzxv = Arrays.copyOf(arrayOfInt, i);
      }
      System.arraycopy(paramCollection.zzxv, 0, this.zzxv, this.size, paramCollection.size);
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
    if (!(paramObject instanceof zzgz)) {
      return super.equals(paramObject);
    }
    paramObject = (zzgz)paramObject;
    if (this.size != ((zzgz)paramObject).size) {
      return false;
    }
    paramObject = ((zzgz)paramObject).zzxv;
    for (int i = 0; i < this.size; i++) {
      if (this.zzxv[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int getInt(int paramInt)
  {
    zzaf(paramInt);
    return this.zzxv[paramInt];
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + this.zzxv[j];
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return -1;
    }
    int i = ((Integer)paramObject).intValue();
    int j = size();
    for (int k = 0; k < j; k++) {
      if (this.zzxv[k] == i) {
        return k;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzdr();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Integer.valueOf(this.zzxv[i])))
      {
        paramObject = this.zzxv;
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
      int[] arrayOfInt = this.zzxv;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.size - paramInt2);
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
  
  public final void zzbm(int paramInt)
  {
    zzdr();
    int i = this.size;
    int[] arrayOfInt1 = this.zzxv;
    if (i == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      this.zzxv = arrayOfInt2;
    }
    arrayOfInt1 = this.zzxv;
    i = this.size;
    this.size = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */