package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class zzax<K, V>
  extends zzbf<Map.Entry<K, V>>
{
  public void clear()
  {
    zza().clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      Map.Entry localEntry = (Map.Entry)paramObject;
      Object localObject = localEntry.getKey();
      paramObject = zzas.zza(zza(), localObject);
      if ((zze.zza(paramObject, localEntry.getValue())) && ((paramObject != null) || (zza().containsKey(localObject)))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    return zza().isEmpty();
  }
  
  public boolean remove(Object paramObject)
  {
    if (contains(paramObject))
    {
      paramObject = (Map.Entry)paramObject;
      return zza().keySet().remove(((Map.Entry)paramObject).getKey());
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = super.removeAll((Collection)zzh.zza(paramCollection));
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
    return zzbc.zza(this, paramCollection.iterator());
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = super.retainAll((Collection)zzh.zza(paramCollection));
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      int i = paramCollection.size();
      if (i < 3)
      {
        zzy.zza(i, "expectedSize");
        i++;
      }
      else if (i < 1073741824)
      {
        i = (int)(i / 0.75F + 1.0F);
      }
      else
      {
        i = Integer.MAX_VALUE;
      }
      HashSet localHashSet = new HashSet(i);
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        paramCollection = localIterator.next();
        if (contains(paramCollection)) {
          localHashSet.add(((Map.Entry)paramCollection).getKey());
        }
      }
      return zza().keySet().retainAll(localHashSet);
    }
  }
  
  public int size()
  {
    return zza().size();
  }
  
  abstract Map<K, V> zza();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */