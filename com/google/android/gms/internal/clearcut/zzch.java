package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzch
  extends zzav<Integer>
  implements zzcn<Integer>, RandomAccess
{
  private static final zzch zzkr;
  private int size;
  private int[] zzks;
  
  static
  {
    zzch localzzch = new zzch();
    zzkr = localzzch;
    localzzch.zzv();
  }
  
  zzch()
  {
    this(new int[10], 0);
  }
  
  private zzch(int[] paramArrayOfInt, int paramInt)
  {
    this.zzks = paramArrayOfInt;
    this.size = paramInt;
  }
  
  public static zzch zzbk()
  {
    return zzkr;
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
  
  private final void zzo(int paramInt1, int paramInt2)
  {
    zzw();
    if (paramInt1 >= 0)
    {
      int i = this.size;
      if (paramInt1 <= i)
      {
        int[] arrayOfInt1 = this.zzks;
        if (i < arrayOfInt1.length)
        {
          System.arraycopy(arrayOfInt1, paramInt1, arrayOfInt1, paramInt1 + 1, i - paramInt1);
        }
        else
        {
          int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt1);
          System.arraycopy(this.zzks, paramInt1, arrayOfInt2, paramInt1 + 1, this.size - paramInt1);
          this.zzks = arrayOfInt2;
        }
        this.zzks[paramInt1] = paramInt2;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzh(paramInt1));
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzch)) {
      return super.addAll(paramCollection);
    }
    zzch localzzch = (zzch)paramCollection;
    int i = localzzch.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      paramCollection = this.zzks;
      if (j > paramCollection.length) {
        this.zzks = Arrays.copyOf(paramCollection, j);
      }
      System.arraycopy(localzzch.zzks, 0, this.zzks, this.size, localzzch.size);
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
    if (!(paramObject instanceof zzch)) {
      return super.equals(paramObject);
    }
    paramObject = (zzch)paramObject;
    if (this.size != ((zzch)paramObject).size) {
      return false;
    }
    paramObject = ((zzch)paramObject).zzks;
    for (int i = 0; i < this.size; i++) {
      if (this.zzks[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int getInt(int paramInt)
  {
    zzg(paramInt);
    return this.zzks[paramInt];
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + this.zzks[j];
    }
    return i;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzw();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Integer.valueOf(this.zzks[i])))
      {
        paramObject = this.zzks;
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
      int[] arrayOfInt = this.zzks;
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
  
  public final void zzac(int paramInt)
  {
    zzo(this.size, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */