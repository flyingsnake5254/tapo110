package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzan<E>
  extends AbstractCollection<E>
  implements Serializable
{
  private static final Object[] zza = new Object[0];
  
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
    return toArray(zza);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    zzh.zza(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i)
    {
      localObject = zzb();
      if (localObject != null) {
        return Arrays.copyOfRange((Object[])localObject, zzc(), zzd(), paramArrayOfT.getClass());
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
    zzbh localzzbh = (zzbh)iterator();
    while (localzzbh.hasNext())
    {
      paramArrayOfObject[paramInt] = localzzbh.next();
      paramInt++;
    }
    return paramInt;
  }
  
  public abstract zzbh<E> zza();
  
  @NullableDecl
  Object[] zzb()
  {
    return null;
  }
  
  int zzc()
  {
    throw new UnsupportedOperationException();
  }
  
  int zzd()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */