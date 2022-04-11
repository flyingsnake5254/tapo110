package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzfc<E>
  extends AbstractList<E>
  implements zzhe<E>
{
  private boolean zzry = true;
  
  public void add(int paramInt, E paramE)
  {
    zzdr();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    zzdr();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    zzdr();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    zzdr();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    zzdr();
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
    if (i != ((List)paramObject).size()) {
      return false;
    }
    for (int j = 0; j < i; j++) {
      if (!get(j).equals(((List)paramObject).get(j))) {
        return false;
      }
    }
    return true;
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
    zzdr();
    return (E)super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    zzdr();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    zzdr();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    zzdr();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    zzdr();
    return (E)super.set(paramInt, paramE);
  }
  
  public boolean zzdp()
  {
    return this.zzry;
  }
  
  public final void zzdq()
  {
    this.zzry = false;
  }
  
  protected final void zzdr()
  {
    if (this.zzry) {
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */