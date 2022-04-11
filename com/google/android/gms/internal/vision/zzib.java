package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzib<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzib zzze;
  private boolean zzry = true;
  
  static
  {
    zzib localzzib = new zzib();
    zzze = localzzib;
    localzzib.zzry = false;
  }
  
  private zzib() {}
  
  private zzib(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  public static <K, V> zzib<K, V> zzhd()
  {
    return zzze;
  }
  
  private final void zzhf()
  {
    if (this.zzry) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private static int zzr(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzgy.hashCode((byte[])paramObject);
    }
    if (!(paramObject instanceof zzhb)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    zzhf();
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
      paramObject = (Map)paramObject;
      if (this != paramObject)
      {
        if (size() != ((Map)paramObject).size()) {}
        for (;;)
        {
          i = 0;
          break label165;
          Iterator localIterator = entrySet().iterator();
          boolean bool;
          do
          {
            if (!localIterator.hasNext()) {
              break label163;
            }
            Object localObject1 = (Map.Entry)localIterator.next();
            if (!((Map)paramObject).containsKey(((Map.Entry)localObject1).getKey())) {
              break;
            }
            Object localObject2 = ((Map.Entry)localObject1).getValue();
            localObject1 = ((Map)paramObject).get(((Map.Entry)localObject1).getKey());
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
      int j = zzr(localEntry.getKey());
      i += (zzr(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public final boolean isMutable()
  {
    return this.zzry;
  }
  
  public final V put(K paramK, V paramV)
  {
    zzhf();
    zzgy.checkNotNull(paramK);
    zzgy.checkNotNull(paramV);
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzhf();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzgy.checkNotNull(localObject);
      zzgy.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    zzhf();
    return (V)super.remove(paramObject);
  }
  
  public final void zza(zzib<K, V> paramzzib)
  {
    zzhf();
    if (!paramzzib.isEmpty()) {
      putAll(paramzzib);
    }
  }
  
  public final void zzdq()
  {
    this.zzry = false;
  }
  
  public final zzib<K, V> zzhe()
  {
    if (isEmpty()) {
      return new zzib();
    }
    return new zzib(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */