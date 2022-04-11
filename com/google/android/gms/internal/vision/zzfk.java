package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfk
  extends zzfc<Boolean>
  implements zzhe<Boolean>, zzit, RandomAccess
{
  private static final zzfk zzsh;
  private int size;
  private boolean[] zzsi;
  
  static
  {
    zzfk localzzfk = new zzfk(new boolean[0], 0);
    zzsh = localzzfk;
    localzzfk.zzdq();
  }
  
  zzfk()
  {
    this(new boolean[10], 0);
  }
  
  private zzfk(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.zzsi = paramArrayOfBoolean;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    zzdr();
    zzgy.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzfk)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzfk)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      boolean[] arrayOfBoolean = this.zzsi;
      if (j > arrayOfBoolean.length) {
        this.zzsi = Arrays.copyOf(arrayOfBoolean, j);
      }
      System.arraycopy(paramCollection.zzsi, 0, this.zzsi, this.size, paramCollection.size);
      this.size = j;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final void addBoolean(boolean paramBoolean)
  {
    zzdr();
    int i = this.size;
    boolean[] arrayOfBoolean1 = this.zzsi;
    if (i == arrayOfBoolean1.length)
    {
      arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
      System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, i);
      this.zzsi = arrayOfBoolean2;
    }
    boolean[] arrayOfBoolean2 = this.zzsi;
    i = this.size;
    this.size = (i + 1);
    arrayOfBoolean2[i] = paramBoolean;
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
    if (!(paramObject instanceof zzfk)) {
      return super.equals(paramObject);
    }
    paramObject = (zzfk)paramObject;
    if (this.size != ((zzfk)paramObject).size) {
      return false;
    }
    paramObject = ((zzfk)paramObject).zzsi;
    for (int i = 0; i < this.size; i++) {
      if (this.zzsi[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + zzgy.zzm(this.zzsi[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Boolean)) {
      return -1;
    }
    int i = ((Boolean)paramObject).booleanValue();
    int j = size();
    for (int k = 0; k < j; k++) {
      if (this.zzsi[k] == i) {
        return k;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzdr();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Boolean.valueOf(this.zzsi[i])))
      {
        paramObject = this.zzsi;
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
      boolean[] arrayOfBoolean = this.zzsi;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.size - paramInt2);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */