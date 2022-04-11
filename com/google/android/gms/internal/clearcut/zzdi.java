package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdi<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzdi zzme;
  private boolean zzfa = true;
  
  static
  {
    zzdi localzzdi = new zzdi();
    zzme = localzzdi;
    localzzdi.zzfa = false;
  }
  
  private zzdi() {}
  
  private zzdi(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  public static <K, V> zzdi<K, V> zzbz()
  {
    return zzme;
  }
  
  private final void zzcb()
  {
    if (this.zzfa) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private static int zzf(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzci.hashCode((byte[])paramObject);
    }
    if (!(paramObject instanceof zzcj)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    zzcb();
    super.clear();
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      if (this != localMap)
      {
        if (size() != localMap.size()) {}
        for (;;)
        {
          i = 0;
          break label165;
          paramObject = entrySet().iterator();
          boolean bool;
          do
          {
            if (!((Iterator)paramObject).hasNext()) {
              break label163;
            }
            Object localObject1 = (Map.Entry)((Iterator)paramObject).next();
            if (!localMap.containsKey(((Map.Entry)localObject1).getKey())) {
              break;
            }
            Object localObject2 = ((Map.Entry)localObject1).getValue();
            localObject1 = localMap.get(((Map.Entry)localObject1).getKey());
            if (((localObject2 instanceof byte[])) && ((localObject1 instanceof byte[]))) {
              bool = Arrays.equals((byte[])localObject2, (byte[])localObject1);
            } else {
              bool = localObject2.equals(localObject1);
            }
          } while (bool);
        }
      }
      label163:
      int i = 1;
      label165:
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j = zzf(localEntry.getKey());
      i += (zzf(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public final boolean isMutable()
  {
    return this.zzfa;
  }
  
  public final V put(K paramK, V paramV)
  {
    zzcb();
    zzci.checkNotNull(paramK);
    zzci.checkNotNull(paramV);
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzcb();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzci.checkNotNull(localObject);
      zzci.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    zzcb();
    return (V)super.remove(paramObject);
  }
  
  public final void zza(zzdi<K, V> paramzzdi)
  {
    zzcb();
    if (!paramzzdi.isEmpty()) {
      putAll(paramzzdi);
    }
  }
  
  public final zzdi<K, V> zzca()
  {
    if (isEmpty()) {
      return new zzdi();
    }
    return new zzdi(this);
  }
  
  public final void zzv()
  {
    this.zzfa = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */