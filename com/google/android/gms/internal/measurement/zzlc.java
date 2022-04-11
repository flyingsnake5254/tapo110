package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzlc<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzlc zzb;
  private boolean zza = true;
  
  static
  {
    zzlc localzzlc = new zzlc();
    zzb = localzzlc;
    localzzlc.zza = false;
  }
  
  private zzlc() {}
  
  private zzlc(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  public static <K, V> zzlc<K, V> zza()
  {
    return zzb;
  }
  
  private static int zzf(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzkl.zzg((byte[])paramObject);
    }
    if (!(paramObject instanceof zzkf)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  private final void zzg()
  {
    if (this.zza) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    zzg();
    super.clear();
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet;
    if (isEmpty()) {
      localSet = Collections.emptySet();
    } else {
      localSet = super.entrySet();
    }
    return localSet;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      if (this != localMap)
      {
        if (size() == localMap.size())
        {
          Iterator localIterator = entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if (!localMap.containsKey(((Map.Entry)localObject).getKey())) {
              break label159;
            }
            paramObject = ((Map.Entry)localObject).getValue();
            localObject = localMap.get(((Map.Entry)localObject).getKey());
            boolean bool;
            if (((paramObject instanceof byte[])) && ((localObject instanceof byte[]))) {
              bool = Arrays.equals((byte[])paramObject, (byte[])localObject);
            } else {
              bool = paramObject.equals(localObject);
            }
            if (!bool) {
              break label159;
            }
          }
        }
      }
      else {
        return true;
      }
    }
    label159:
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
  
  public final V put(K paramK, V paramV)
  {
    zzg();
    zzkl.zza(paramK);
    zzkl.zza(paramV);
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzg();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzkl.zza(localObject);
      zzkl.zza(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    zzg();
    return (V)super.remove(paramObject);
  }
  
  public final void zzb(zzlc<K, V> paramzzlc)
  {
    zzg();
    if (!paramzzlc.isEmpty()) {
      putAll(paramzzlc);
    }
  }
  
  public final zzlc<K, V> zzc()
  {
    zzlc localzzlc;
    if (isEmpty()) {
      localzzlc = new zzlc();
    } else {
      localzzlc = new zzlc(this);
    }
    return localzzlc;
  }
  
  public final void zzd()
  {
    this.zza = false;
  }
  
  public final boolean zze()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */