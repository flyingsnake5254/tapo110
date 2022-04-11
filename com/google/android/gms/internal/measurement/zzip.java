package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzip<E>
  extends AbstractList<E>
  implements zzkk<E>
{
  private boolean zza = true;
  
  public void add(int paramInt, E paramE)
  {
    zzbM();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    zzbM();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    zzbM();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    zzbM();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    zzbM();
    super.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    if (!(paramObject instanceof RandomAccess)) {
      return super.equals(paramObject);
    }
    paramObject = (List)paramObject;
    int i = size();
    if (i == ((List)paramObject).size())
    {
      for (int j = 0; j < i; j++) {
        if (!get(j).equals(((List)paramObject).get(j))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = size();
    int j = 1;
    for (int k = 0; k < i; k++) {
      j = j * 31 + get(k).hashCode();
    }
    return j;
  }
  
  public E remove(int paramInt)
  {
    zzbM();
    return (E)super.remove(paramInt);
  }
  
  public final boolean remove(Object paramObject)
  {
    zzbM();
    int i = indexOf(paramObject);
    if (i == -1) {
      return false;
    }
    remove(i);
    return true;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    zzbM();
    return super.removeAll(paramCollection);
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    zzbM();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    zzbM();
    return (E)super.set(paramInt, paramE);
  }
  
  public final boolean zza()
  {
    return this.zza;
  }
  
  public final void zzb()
  {
    this.zza = false;
  }
  
  protected final void zzbM()
  {
    if (this.zza) {
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */