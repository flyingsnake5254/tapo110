package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

final class zziv<E>
  extends zzfc<E>
  implements RandomAccess
{
  private static final zziv<Object> zzaaf;
  private int size;
  private E[] zzmh;
  
  static
  {
    zziv localzziv = new zziv(new Object[0], 0);
    zzaaf = localzziv;
    localzziv.zzdq();
  }
  
  zziv()
  {
    this(new Object[10], 0);
  }
  
  private zziv(E[] paramArrayOfE, int paramInt)
  {
    this.zzmh = paramArrayOfE;
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
  
  public static <E> zziv<E> zzhs()
  {
    return zzaaf;
  }
  
  public final void add(int paramInt, E paramE)
  {
    zzdr();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        Object[] arrayOfObject1 = this.zzmh;
        if (i < arrayOfObject1.length)
        {
          System.arraycopy(arrayOfObject1, paramInt, arrayOfObject1, paramInt + 1, i - paramInt);
        }
        else
        {
          Object[] arrayOfObject2 = new Object[i * 3 / 2 + 1];
          System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
          System.arraycopy(this.zzmh, paramInt, arrayOfObject2, paramInt + 1, this.size - paramInt);
          this.zzmh = arrayOfObject2;
        }
        this.zzmh[paramInt] = paramE;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzag(paramInt));
  }
  
  public final boolean add(E paramE)
  {
    zzdr();
    int i = this.size;
    Object[] arrayOfObject = this.zzmh;
    if (i == arrayOfObject.length) {
      this.zzmh = Arrays.copyOf(arrayOfObject, i * 3 / 2 + 1);
    }
    arrayOfObject = this.zzmh;
    i = this.size;
    this.size = (i + 1);
    arrayOfObject[i] = paramE;
    this.modCount += 1;
    return true;
  }
  
  public final E get(int paramInt)
  {
    zzaf(paramInt);
    return (E)this.zzmh[paramInt];
  }
  
  public final E remove(int paramInt)
  {
    zzdr();
    zzaf(paramInt);
    Object[] arrayOfObject = this.zzmh;
    Object localObject = arrayOfObject[paramInt];
    int i = this.size;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt - 1);
    }
    this.size -= 1;
    this.modCount += 1;
    return (E)localObject;
  }
  
  public final E set(int paramInt, E paramE)
  {
    zzdr();
    zzaf(paramInt);
    Object[] arrayOfObject = this.zzmh;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramE;
    this.modCount += 1;
    return (E)localObject;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zziv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */