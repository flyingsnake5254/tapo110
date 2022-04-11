package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzap<E>
  extends zzan<E>
  implements List<E>, RandomAccess
{
  private static final zzbg<Object> zza = new zzao(zzbd.zza, 0);
  
  public static <E> zzap<E> zza(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    Object[] arrayOfObject = new Object[5];
    int i = 0;
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    while (i < 5) {
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
    return new zzbd(arrayOfObject, 5);
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
    if (paramObject == zzh.zza(this)) {
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
            if (!zze.zza(get(j), ((List)paramObject).get(j))) {
              break label149;
            }
          }
          return true;
        }
        i = size();
        paramObject = ((List)paramObject).iterator();
        int j = 0;
        while (j < i)
        {
          if (!((Iterator)paramObject).hasNext()) {
            break label149;
          }
          Object localObject = get(j);
          j++;
          if (!zze.zza(localObject, ((Iterator)paramObject).next())) {
            break label149;
          }
        }
        if (!((Iterator)paramObject).hasNext()) {
          return true;
        }
      }
    }
    label149:
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
  
  public zzap<E> zza(int paramInt1, int paramInt2)
  {
    zzh.zza(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    if (paramInt2 == size()) {
      return this;
    }
    if (paramInt2 == 0) {
      return zzbd.zza;
    }
    return new zzar(this, paramInt1, paramInt2);
  }
  
  public final zzbh<E> zza()
  {
    return (zzbg)listIterator();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */