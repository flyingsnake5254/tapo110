package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzl<E>
  extends zzm<E>
  implements List<E>, RandomAccess
{
  private static final zzs<Object> zza = new zzo(zzq.zza, 0);
  
  @SafeVarargs
  public static <E> zzl<E> zza(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11, E paramE12, E... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    if (i <= 2147483635) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      int k = paramVarArgs.length + 12;
      Object[] arrayOfObject = new Object[k];
      arrayOfObject[0] = paramE1;
      arrayOfObject[1] = paramE2;
      arrayOfObject[2] = paramE3;
      arrayOfObject[3] = paramE4;
      arrayOfObject[4] = paramE5;
      arrayOfObject[5] = paramE6;
      arrayOfObject[6] = paramE7;
      arrayOfObject[7] = paramE8;
      arrayOfObject[8] = paramE9;
      arrayOfObject[9] = paramE10;
      arrayOfObject[10] = paramE11;
      arrayOfObject[11] = paramE12;
      System.arraycopy(paramVarArgs, 0, arrayOfObject, 12, paramVarArgs.length);
      i = j;
      while (i < k) {
        if (arrayOfObject[i] != null)
        {
          i++;
        }
        else
        {
          paramE1 = new StringBuilder(20);
          paramE1.append("at index ");
          paramE1.append(i);
          throw new NullPointerException(paramE1.toString());
        }
      }
      if (k == 0) {
        return zzq.zza;
      }
      return new zzq(arrayOfObject, k);
    }
    throw new IllegalArgumentException("the total number of elements must fit in an int");
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
    if (paramObject == zzi.zza(this)) {
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
            if (!zzc.zza(get(j), ((List)paramObject).get(j))) {
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
          if (!zzc.zza(paramObject, localIterator.next())) {
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
    for (paramInt = 0; paramInt < i; paramInt++) {
      paramArrayOfObject[paramInt] = get(paramInt);
    }
    return i;
  }
  
  public zzl<E> zza(int paramInt1, int paramInt2)
  {
    zzi.zza(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    if (paramInt2 == size()) {
      return this;
    }
    if (paramInt2 == 0) {
      return zzq.zza;
    }
    return new zzn(this, paramInt1, paramInt2);
  }
  
  public final zzp<E> zza()
  {
    return (zzs)listIterator();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */