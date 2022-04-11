package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdh<E>
  extends AbstractCollection<E>
  implements Serializable
{
  private static final Object[] zzly = new Object[0];
  
  @Deprecated
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@NullableDecl Object paramObject);
  
  @Deprecated
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    return toArray(zzly);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    zzcy.checkNotNull(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i)
    {
      localObject = zzca();
      if (localObject != null) {
        return Arrays.copyOfRange((Object[])localObject, zzcb(), zzcc(), paramArrayOfT.getClass());
      }
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    else
    {
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
    zza((Object[])localObject, 0);
    return (T[])localObject;
  }
  
  int zza(Object[] paramArrayOfObject, int paramInt)
  {
    zzdw localzzdw = (zzdw)iterator();
    while (localzzdw.hasNext())
    {
      paramArrayOfObject[paramInt] = localzzdw.next();
      paramInt++;
    }
    return paramInt;
  }
  
  public abstract zzdw<E> zzbz();
  
  @NullableDecl
  Object[] zzca()
  {
    return null;
  }
  
  int zzcb()
  {
    throw new UnsupportedOperationException();
  }
  
  int zzcc()
  {
    throw new UnsupportedOperationException();
  }
  
  public zzdk<E> zzcd()
  {
    if (isEmpty()) {
      return zzdk.zzce();
    }
    return zzdk.zza(toArray());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */