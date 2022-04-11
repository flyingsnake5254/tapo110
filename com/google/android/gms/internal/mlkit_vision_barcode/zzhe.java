package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzhe<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzhe zzb;
  private boolean zza = true;
  
  static
  {
    zzhe localzzhe = new zzhe();
    zzb = localzzhe;
    localzzhe.zza = false;
  }
  
  private zzhe() {}
  
  private zzhe(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private static int zza(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzgc.zzc((byte[])paramObject);
    }
    if (!(paramObject instanceof zzgf)) {
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
          break label164;
          Iterator localIterator = entrySet().iterator();
          boolean bool;
          do
          {
            if (!localIterator.hasNext()) {
              break label162;
            }
            Object localObject = (Map.Entry)localIterator.next();
            if (!localMap.containsKey(((Map.Entry)localObject).getKey())) {
              break;
            }
            paramObject = ((Map.Entry)localObject).getValue();
            localObject = localMap.get(((Map.Entry)localObject).getKey());
            if (((paramObject instanceof byte[])) && ((localObject instanceof byte[]))) {
              bool = Arrays.equals((byte[])paramObject, (byte[])localObject);
            } else {
              bool = paramObject.equals(localObject);
            }
          } while (bool);
        }
      }
      label162:
      int i = 1;
      label164:
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
    zzgc.zza(paramK);
    zzgc.zza(paramV);
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzd();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzgc.zza(localObject);
      zzgc.zza(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    zzd();
    return (V)super.remove(paramObject);
  }
  
  public final zzhe<K, V> zza()
  {
    if (isEmpty()) {
      return new zzhe();
    }
    return new zzhe(this);
  }
  
  public final void zza(zzhe<K, V> paramzzhe)
  {
    zzd();
    if (!paramzzhe.isEmpty()) {
      putAll(paramzzhe);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */