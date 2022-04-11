package io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LongCollections
{
  private static final LongObjectMap<Object> EMPTY_MAP = new EmptyMap(null);
  
  public static <V> LongObjectMap<V> emptyMap()
  {
    return EMPTY_MAP;
  }
  
  public static <V> LongObjectMap<V> unmodifiableMap(LongObjectMap<V> paramLongObjectMap)
  {
    return new UnmodifiableMap(paramLongObjectMap);
  }
  
  private static final class EmptyMap
    implements LongObjectMap<Object>
  {
    public void clear() {}
    
    public boolean containsKey(long paramLong)
    {
      return false;
    }
    
    public boolean containsKey(Object paramObject)
    {
      return false;
    }
    
    public boolean containsValue(Object paramObject)
    {
      return false;
    }
    
    public Iterable<LongObjectMap.PrimitiveEntry<Object>> entries()
    {
      return Collections.emptySet();
    }
    
    public Set<Map.Entry<Long, Object>> entrySet()
    {
      return Collections.emptySet();
    }
    
    public Object get(long paramLong)
    {
      return null;
    }
    
    public Object get(Object paramObject)
    {
      return null;
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public Set<Long> keySet()
    {
      return Collections.emptySet();
    }
    
    public Object put(long paramLong, Object paramObject)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public Object put(Long paramLong, Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Map<? extends Long, ?> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object remove(long paramLong)
    {
      return null;
    }
    
    public Object remove(Object paramObject)
    {
      return null;
    }
    
    public int size()
    {
      return 0;
    }
    
    public Collection<Object> values()
    {
      return Collections.emptyList();
    }
  }
  
  private static final class UnmodifiableMap<V>
    implements LongObjectMap<V>
  {
    private Iterable<LongObjectMap.PrimitiveEntry<V>> entries;
    private Set<Map.Entry<Long, V>> entrySet;
    private Set<Long> keySet;
    private final LongObjectMap<V> map;
    private Collection<V> values;
    
    UnmodifiableMap(LongObjectMap<V> paramLongObjectMap)
    {
      this.map = paramLongObjectMap;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException("clear");
    }
    
    public boolean containsKey(long paramLong)
    {
      return this.map.containsKey(paramLong);
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    public Iterable<LongObjectMap.PrimitiveEntry<V>> entries()
    {
      if (this.entries == null) {
        this.entries = new Iterable()
        {
          public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator()
          {
            LongCollections.UnmodifiableMap localUnmodifiableMap = LongCollections.UnmodifiableMap.this;
            return new LongCollections.UnmodifiableMap.IteratorImpl(localUnmodifiableMap, localUnmodifiableMap.map.entries().iterator());
          }
        };
      }
      return this.entries;
    }
    
    public Set<Map.Entry<Long, V>> entrySet()
    {
      if (this.entrySet == null) {
        this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
      }
      return this.entrySet;
    }
    
    public V get(long paramLong)
    {
      return (V)this.map.get(paramLong);
    }
    
    public V get(Object paramObject)
    {
      return (V)this.map.get(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public Set<Long> keySet()
    {
      if (this.keySet == null) {
        this.keySet = Collections.unmodifiableSet(this.map.keySet());
      }
      return this.keySet;
    }
    
    public V put(long paramLong, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public V put(Long paramLong, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public void putAll(Map<? extends Long, ? extends V> paramMap)
    {
      throw new UnsupportedOperationException("putAll");
    }
    
    public V remove(long paramLong)
    {
      throw new UnsupportedOperationException("remove");
    }
    
    public V remove(Object paramObject)
    {
      throw new UnsupportedOperationException("remove");
    }
    
    public int size()
    {
      return this.map.size();
    }
    
    public Collection<V> values()
    {
      if (this.values == null) {
        this.values = Collections.unmodifiableCollection(this.map.values());
      }
      return this.values;
    }
    
    private class EntryImpl
      implements LongObjectMap.PrimitiveEntry<V>
    {
      private final LongObjectMap.PrimitiveEntry<V> entry;
      
      EntryImpl()
      {
        LongObjectMap.PrimitiveEntry localPrimitiveEntry;
        this.entry = localPrimitiveEntry;
      }
      
      public long key()
      {
        return this.entry.key();
      }
      
      public void setValue(V paramV)
      {
        throw new UnsupportedOperationException("setValue");
      }
      
      public V value()
      {
        return (V)this.entry.value();
      }
    }
    
    private class IteratorImpl
      implements Iterator<LongObjectMap.PrimitiveEntry<V>>
    {
      final Iterator<LongObjectMap.PrimitiveEntry<V>> iter;
      
      IteratorImpl()
      {
        Iterator localIterator;
        this.iter = localIterator;
      }
      
      public boolean hasNext()
      {
        return this.iter.hasNext();
      }
      
      public LongObjectMap.PrimitiveEntry<V> next()
      {
        if (hasNext()) {
          return new LongCollections.UnmodifiableMap.EntryImpl(LongCollections.UnmodifiableMap.this, (LongObjectMap.PrimitiveEntry)this.iter.next());
        }
        throw new NoSuchElementException();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("remove");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\LongCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */