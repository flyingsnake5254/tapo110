package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzaz
  extends zzav<Boolean>
  implements zzcn<Boolean>, RandomAccess
{
  private static final zzaz zzfg;
  private int size;
  private boolean[] zzfh;
  
  static
  {
    zzaz localzzaz = new zzaz();
    zzfg = localzzaz;
    localzzaz.zzv();
  }
  
  zzaz()
  {
    this(new boolean[10], 0);
  }
  
  private zzaz(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.zzfh = paramArrayOfBoolean;
    this.size = paramInt;
  }
  
  private final void zza(int paramInt, boolean paramBoolean)
  {
    zzw();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        boolean[] arrayOfBoolean1 = this.zzfh;
        if (i < arrayOfBoolean1.length)
        {
          System.arraycopy(arrayOfBoolean1, paramInt, arrayOfBoolean1, paramInt + 1, i - paramInt);
        }
        else
        {
          boolean[] arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, paramInt);
          System.arraycopy(this.zzfh, paramInt, arrayOfBoolean2, paramInt + 1, this.size - paramInt);
          this.zzfh = arrayOfBoolean2;
        }
        this.zzfh[paramInt] = paramBoolean;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzaz)) {
      return super.addAll(paramCollection);
    }
    zzaz localzzaz = (zzaz)paramCollection;
    int i = localzzaz.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      paramCollection = this.zzfh;
      if (j > paramCollection.length) {
        this.zzfh = Arrays.copyOf(paramCollection, j);
      }
      System.arraycopy(localzzaz.zzfh, 0, this.zzfh, this.size, localzzaz.size);
      this.size = j;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final void addBoolean(boolean paramBoolean)
  {
    zza(this.size, paramBoolean);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaz)) {
      return super.equals(paramObject);
    }
    paramObject = (zzaz)paramObject;
    if (this.size != ((zzaz)paramObject).size) {
      return false;
    }
    paramObject = ((zzaz)paramObject).zzfh;
    for (int i = 0; i < this.size; i++) {
      if (this.zzfh[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + zzci.zzc(this.zzfh[j]);
    }
    return i;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzw();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Boolean.valueOf(this.zzfh[i])))
      {
        paramObject = this.zzfh;
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
      boolean[] arrayOfBoolean = this.zzfh;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */