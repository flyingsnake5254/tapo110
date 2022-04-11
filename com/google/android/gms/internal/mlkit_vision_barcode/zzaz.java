package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzaz<K, V>
  extends AbstractCollection<V>
{
  private final Map<K, V> zza;
  
  zzaz(Map<K, V> paramMap)
  {
    this.zza = ((Map)zzh.zza(paramMap));
  }
  
  public final void clear()
  {
    this.zza.clear();
  }
  
  public final boolean contains(@NullableDecl Object paramObject)
  {
    return this.zza.containsValue(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return this.zza.isEmpty();
  }
  
  public final Iterator<V> iterator()
  {
    return new zzau(this.zza.entrySet().iterator());
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      boolean bool = super.remove(paramObject);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Iterator localIterator = this.zza.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (zze.zza(paramObject, localEntry.getValue()))
        {
          this.zza.remove(localEntry.getKey());
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = super.removeAll((Collection)zzh.zza(paramCollection));
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.zza.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramCollection.contains(localEntry.getValue())) {
          localHashSet.add(localEntry.getKey());
        }
      }
      return this.zza.keySet().removeAll(localHashSet);
    }
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = super.retainAll((Collection)zzh.zza(paramCollection));
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.zza.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramCollection.contains(localEntry.getValue())) {
          localHashSet.add(localEntry.getKey());
        }
      }
      return this.zza.keySet().retainAll(localHashSet);
    }
  }
  
  public final int size()
  {
    return this.zza.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */