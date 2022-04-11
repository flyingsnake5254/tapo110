package io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ShortCollections
{
  private static final ShortObjectMap<Object> EMPTY_MAP = new EmptyMap(null);
  
  public static <V> ShortObjectMap<V> emptyMap()
  {
    return EMPTY_MAP;
  }
  
  public static <V> ShortObjectMap<V> unmodifiableMap(ShortObjectMap<V> paramShortObjectMap)
  {
    return new UnmodifiableMap(paramShortObjectMap);
  }
  
  private static final class EmptyMap
    implements ShortObjectMap<Object>
  {
    public void clear() {}
    
    public boolean containsKey(Object paramObject)
    {
      return false;
    }
    
    public boolean containsKey(short paramShort)
    {
      return false;
    }
    
    public boolean containsValue(Object paramObject)
    {
      return false;
    }
    
    public Iterable<ShortObjectMap.PrimitiveEntry<Object>> entries()
    {
      return Collections.emptySet();
    }
    
    public Set<Map.Entry<Short, Object>> entrySet()
    {
      return Collections.emptySet();
    }
    
    public Object get(Object paramObject)
    {
      return null;
    }
    
    public Object get(short paramShort)
    {
      return null;
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public Set<Short> keySet()
    {
      return Collections.emptySet();
    }
    
    public Object put(Short paramShort, Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object put(short paramShort, Object paramObject)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public void putAll(Map<? extends Short, ?> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object remove(Object paramObject)
    {
      return null;
    }
    
    public Object remove(short paramShort)
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
    implements ShortObjectMap<V>
  {
    private Iterable<ShortObjectMap.PrimitiveEntry<V>> entries;
    private Set<Map.Entry<Short, V>> entrySet;
    private Set<Short> keySet;
    private final ShortObjectMap<V> map;
    private Collection<V> values;
    
    UnmodifiableMap(ShortObjectMap<V> paramShortObjectMap)
    {
      this.map = paramShortObjectMap;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException("clear");
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean containsKey(short paramShort)
    {
      return this.map.containsKey(paramShort);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    public Iterable<ShortObjectMap.PrimitiveEntry<V>> entries()
    {
      if (this.entries == null) {
        this.entries = new Iterable()
        {
          public Iterator<ShortObjectMap.PrimitiveEntry<V>> iterator()
          {
            ShortCollections.UnmodifiableMap localUnmodifiableMap = ShortCollections.UnmodifiableMap.this;
            return new ShortCollections.UnmodifiableMap.IteratorImpl(localUnmodifiableMap, localUnmodifiableMap.map.entries().iterator());
          }
        };
      }
      return this.entries;
    }
    
    public Set<Map.Entry<Short, V>> entrySet()
    {
      if (this.entrySet == null) {
        this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
      }
      return this.entrySet;
    }
    
    public V get(Object paramObject)
    {
      return (V)this.map.get(paramObject);
    }
    
    public V get(short paramShort)
    {
      return (V)this.map.get(paramShort);
    }
    
    public boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public Set<Short> keySet()
    {
      if (this.keySet == null) {
        this.keySet = Collections.unmodifiableSet(this.map.keySet());
      }
      return this.keySet;
    }
    
    public V put(Short paramShort, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public V put(short paramShort, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public void putAll(Map<? extends Short, ? extends V> paramMap)
    {
      throw new UnsupportedOperationException("putAll");
    }
    
    public V remove(Object paramObject)
    {
      throw new UnsupportedOperationException("remove");
    }
    
    public V remove(short paramShort)
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
      implements ShortObjectMap.PrimitiveEntry<V>
    {
      private final ShortObjectMap.PrimitiveEntry<V> entry;
      
      EntryImpl()
      {
        ShortObjectMap.PrimitiveEntry localPrimitiveEntry;
        this.entry = localPrimitiveEntry;
      }
      
      public short key()
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
      implements Iterator<ShortObjectMap.PrimitiveEntry<V>>
    {
      final Iterator<ShortObjectMap.PrimitiveEntry<V>> iter;
      
      IteratorImpl()
      {
        Iterator localIterator;
        this.iter = localIterator;
      }
      
      public boolean hasNext()
      {
        return this.iter.hasNext();
      }
      
      public ShortObjectMap.PrimitiveEntry<V> next()
      {
        if (hasNext()) {
          return new ShortCollections.UnmodifiableMap.EntryImpl(ShortCollections.UnmodifiableMap.this, (ShortObjectMap.PrimitiveEntry)this.iter.next());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\ShortCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */