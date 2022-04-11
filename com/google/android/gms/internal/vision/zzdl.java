package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdl<K, V>
  implements Serializable, Map<K, V>
{
  private static final Map.Entry<?, ?>[] zzmb = new Map.Entry[0];
  private transient zzdo<Map.Entry<K, V>> zzmc;
  private transient zzdo<K> zzmd;
  private transient zzdh<V> zzme;
  
  public static <K, V> zzdl<K, V> zza(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    zzdf.zza(paramK1, paramV1);
    zzdf.zza(paramK2, paramV2);
    zzdf.zza(paramK3, paramV3);
    zzdf.zza(paramK4, paramV4);
    return zzdq.zza(4, new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4 });
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return ((zzdh)values()).contains(paramObject);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      return entrySet().equals(((Map)paramObject).entrySet());
    }
    return false;
  }
  
  public abstract V get(@NullableDecl Object paramObject);
  
  public final V getOrDefault(@NullableDecl Object paramObject, @NullableDecl V paramV)
  {
    paramObject = get(paramObject);
    if (paramObject != null) {
      return (V)paramObject;
    }
    return paramV;
  }
  
  public int hashCode()
  {
    return zzdt.zza((zzdo)entrySet());
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  @Deprecated
  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    int i = size();
    if (i >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder((int)Math.min(i << 3, 1073741824L));
      localStringBuilder.append('{');
      i = 1;
      localObject = entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (i == 0) {
          localStringBuilder.append(", ");
        }
        i = 0;
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append(localEntry.getValue());
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    Object localObject = new StringBuilder("size".length() + 40);
    ((StringBuilder)localObject).append("size");
    ((StringBuilder)localObject).append(" cannot be negative but was: ");
    ((StringBuilder)localObject).append(i);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  abstract zzdo<Map.Entry<K, V>> zzcf();
  
  abstract zzdo<K> zzcg();
  
  abstract zzdh<V> zzch();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */