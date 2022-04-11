package com.google.android.gms.internal.vision;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdk<E>
  extends zzdh<E>
  implements List<E>, RandomAccess
{
  private static final zzdv<Object> zzma = new zzdj(zzdn.zzmg, 0);
  
  static <E> zzdk<E> zza(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i == 0) {
      return zzdn.zzmg;
    }
    return new zzdn(paramArrayOfObject, i);
  }
  
  public static <E> zzdk<E> zzce()
  {
    return zzdn.zzmg;
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == zzcy.checkNotNull(this)) {
      return true;
    }
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      int i = size();
      if (i == ((List)paramObject).size())
      {
        if ((paramObject instanceof RandomAccess))
        {
          for (j = 0; j < i; j++) {
            if (!zzct.equal(get(j), ((List)paramObject).get(j))) {
              break label151;
            }
          }
          return true;
        }
        i = size();
        Iterator localIterator = ((List)paramObject).iterator();
        int j = 0;
        while (j < i)
        {
          if (!localIterator.hasNext()) {
            break label151;
          }
          paramObject = get(j);
          j++;
          if (!zzct.equal(paramObject, localIterator.next())) {
            break label151;
          }
        }
        if (!localIterator.hasNext()) {
          return true;
        }
      }
    }
    label151:
    return false;
  }
  
  public int hashCode()
  {
    int i = size();
    int j = 1;
    for (int k = 0; k < i; k++) {
      j = j * 31 + get(k).hashCode() ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
    return j;
  }
  
  public int indexOf(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    int i = size();
    for (int j = 0; j < i; j++) {
      if (paramObject.equals(get(j))) {
        return j;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    for (int i = size() - 1; i >= 0; i--) {
      if (paramObject.equals(get(i))) {
        return i;
      }
    }
    return -1;
  }
  
  @Deprecated
  public final E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  int zza(Object[] paramArrayOfObject, int paramInt)
  {
    int i = size();
    for (int j = 0; j < i; j++) {
      paramArrayOfObject[(paramInt + j)] = get(j);
    }
    return paramInt + i;
  }
  
  public final zzdw<E> zzbz()
  {
    return (zzdv)listIterator();
  }
  
  public final zzdk<E> zzcd()
  {
    return this;
  }
  
  public zzdk<E> zzf(int paramInt1, int paramInt2)
  {
    zzcy.zza(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    if (paramInt2 == size()) {
      return this;
    }
    if (paramInt2 == 0) {
      return zzdn.zzmg;
    }
    return new zzdm(this, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */