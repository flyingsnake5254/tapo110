package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzgb<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzgb zzb;
  private boolean zza = true;
  
  static
  {
    zzgb localzzgb = new zzgb();
    zzb = localzzgb;
    localzzgb.zza = false;
  }
  
  private zzgb() {}
  
  private zzgb(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private static int zza(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzfc.zzc((byte[])paramObject);
    }
    if (!(paramObject instanceof zzfb)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  private final void zzd()
  {
    if (this.zza) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    zzd();
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
      int j = zza(localEntry.getKey());
      i += (zza(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public final V put(K paramK, V paramV)
  {
    zzd();
    zzfc.zza(paramK);
    zzfc.zza(paramV);
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzd();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzfc.zza(localObject);
      zzfc.zza(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    zzd();
    return (V)super.remove(paramObject);
  }
  
  public final zzgb<K, V> zza()
  {
    if (isEmpty()) {
      return new zzgb();
    }
    return new zzgb(this);
  }
  
  public final void zza(zzgb<K, V> paramzzgb)
  {
    zzd();
    if (!paramzzgb.isEmpty()) {
      putAll(paramzzgb);
    }
  }
  
  public final void zzb()
  {
    this.zza = false;
  }
  
  public final boolean zzc()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */