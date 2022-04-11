package com.google.common.util.concurrent;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.collect.q1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

public final class AtomicLongMap<K>
  implements Serializable
{
  @MonotonicNonNullDecl
  private transient Map<K, Long> asMap;
  private final ConcurrentHashMap<K, AtomicLong> map;
  
  private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> paramConcurrentHashMap)
  {
    this.map = ((ConcurrentHashMap)n.o(paramConcurrentHashMap));
  }
  
  public static <K> AtomicLongMap<K> create()
  {
    return new AtomicLongMap(new ConcurrentHashMap());
  }
  
  public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> paramMap)
  {
    AtomicLongMap localAtomicLongMap = create();
    localAtomicLongMap.putAll(paramMap);
    return localAtomicLongMap;
  }
  
  private Map<K, Long> createAsMap()
  {
    return Collections.unmodifiableMap(q1.A(this.map, new a()));
  }
  
  @CanIgnoreReturnValue
  public long addAndGet(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong1 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong2 = localAtomicLong1;
    if (localAtomicLong1 == null)
    {
      localAtomicLong1 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong2 = localAtomicLong1;
      if (localAtomicLong1 == null) {
        return paramLong;
      }
    }
    long l1;
    long l2;
    do
    {
      l1 = localAtomicLong2.get();
      if (l1 == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong2, new AtomicLong(paramLong))) {
          break;
        }
        return paramLong;
      }
      l2 = l1 + paramLong;
    } while (!localAtomicLong2.compareAndSet(l1, l2));
    return l2;
  }
  
  public Map<K, Long> asMap()
  {
    Map localMap1 = this.asMap;
    Map localMap2 = localMap1;
    if (localMap1 == null)
    {
      localMap2 = createAsMap();
      this.asMap = localMap2;
    }
    return localMap2;
  }
  
  public void clear()
  {
    this.map.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  @CanIgnoreReturnValue
  public long decrementAndGet(K paramK)
  {
    return addAndGet(paramK, -1L);
  }
  
  public long get(K paramK)
  {
    paramK = (AtomicLong)this.map.get(paramK);
    long l;
    if (paramK == null) {
      l = 0L;
    } else {
      l = paramK.get();
    }
    return l;
  }
  
  @CanIgnoreReturnValue
  public long getAndAdd(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong1 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong2 = localAtomicLong1;
    if (localAtomicLong1 == null)
    {
      localAtomicLong1 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong2 = localAtomicLong1;
      if (localAtomicLong1 == null) {
        return 0L;
      }
    }
    long l;
    do
    {
      l = localAtomicLong2.get();
      if (l == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong2, new AtomicLong(paramLong))) {
          break;
        }
        return 0L;
      }
    } while (!localAtomicLong2.compareAndSet(l, l + paramLong));
    return l;
  }
  
  @CanIgnoreReturnValue
  public long getAndDecrement(K paramK)
  {
    return getAndAdd(paramK, -1L);
  }
  
  @CanIgnoreReturnValue
  public long getAndIncrement(K paramK)
  {
    return getAndAdd(paramK, 1L);
  }
  
  @CanIgnoreReturnValue
  public long incrementAndGet(K paramK)
  {
    return addAndGet(paramK, 1L);
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public long put(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong1 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong2 = localAtomicLong1;
    if (localAtomicLong1 == null)
    {
      localAtomicLong1 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong2 = localAtomicLong1;
      if (localAtomicLong1 == null) {
        return 0L;
      }
    }
    long l;
    do
    {
      l = localAtomicLong2.get();
      if (l == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong2, new AtomicLong(paramLong))) {
          break;
        }
        return 0L;
      }
    } while (!localAtomicLong2.compareAndSet(l, paramLong));
    return l;
  }
  
  public void putAll(Map<? extends K, ? extends Long> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
    }
  }
  
  long putIfAbsent(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2;
    long l;
    do
    {
      AtomicLong localAtomicLong1 = (AtomicLong)this.map.get(paramK);
      localAtomicLong2 = localAtomicLong1;
      if (localAtomicLong1 == null)
      {
        localAtomicLong1 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        localAtomicLong2 = localAtomicLong1;
        if (localAtomicLong1 == null) {
          return 0L;
        }
      }
      l = localAtomicLong2.get();
      if (l != 0L) {
        break;
      }
    } while (!this.map.replace(paramK, localAtomicLong2, new AtomicLong(paramLong)));
    return 0L;
    return l;
  }
  
  @CanIgnoreReturnValue
  public long remove(K paramK)
  {
    AtomicLong localAtomicLong = (AtomicLong)this.map.get(paramK);
    if (localAtomicLong == null) {
      return 0L;
    }
    long l;
    do
    {
      l = localAtomicLong.get();
    } while ((l != 0L) && (!localAtomicLong.compareAndSet(l, 0L)));
    this.map.remove(paramK, localAtomicLong);
    return l;
  }
  
  boolean remove(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong = (AtomicLong)this.map.get(paramK);
    if (localAtomicLong == null) {
      return false;
    }
    long l = localAtomicLong.get();
    if (l != paramLong) {
      return false;
    }
    if ((l != 0L) && (!localAtomicLong.compareAndSet(l, 0L))) {
      return false;
    }
    this.map.remove(paramK, localAtomicLong);
    return true;
  }
  
  public void removeAllZeros()
  {
    Iterator localIterator = this.map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AtomicLong localAtomicLong = (AtomicLong)((Map.Entry)localIterator.next()).getValue();
      if ((localAtomicLong != null) && (localAtomicLong.get() == 0L)) {
        localIterator.remove();
      }
    }
  }
  
  @CanIgnoreReturnValue
  public boolean removeIfZero(K paramK)
  {
    return remove(paramK, 0L);
  }
  
  boolean replace(K paramK, long paramLong1, long paramLong2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramLong1 == 0L)
    {
      if (putIfAbsent(paramK, paramLong2) == 0L) {
        bool2 = true;
      }
      return bool2;
    }
    paramK = (AtomicLong)this.map.get(paramK);
    if (paramK == null) {
      bool2 = bool1;
    } else {
      bool2 = paramK.compareAndSet(paramLong1, paramLong2);
    }
    return bool2;
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  public long sum()
  {
    Iterator localIterator = this.map.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((AtomicLong)localIterator.next()).get()) {}
    return l;
  }
  
  public String toString()
  {
    return this.map.toString();
  }
  
  class a
    implements h<AtomicLong, Long>
  {
    a() {}
    
    public Long a(AtomicLong paramAtomicLong)
    {
      return Long.valueOf(paramAtomicLong.get());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\AtomicLongMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */