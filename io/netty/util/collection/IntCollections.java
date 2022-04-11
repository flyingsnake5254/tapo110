package io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class IntCollections
{
  private static final IntObjectMap<Object> EMPTY_MAP = new EmptyMap(null);
  
  public static <V> IntObjectMap<V> emptyMap()
  {
    return EMPTY_MAP;
  }
  
  public static <V> IntObjectMap<V> unmodifiableMap(IntObjectMap<V> paramIntObjectMap)
  {
    return new UnmodifiableMap(paramIntObjectMap);
  }
  
  private static final class EmptyMap
    implements IntObjectMap<Object>
  {
    public void clear() {}
    
    public boolean containsKey(int paramInt)
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
    
    public Iterable<IntObjectMap.PrimitiveEntry<Object>> entries()
    {
      return Collections.emptySet();
    }
    
    public Set<Map.Entry<Integer, Object>> entrySet()
    {
      return Collections.emptySet();
    }
    
    public Object get(int paramInt)
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
    
    public Set<Integer> keySet()
    {
      return Collections.emptySet();
    }
    
    public Object put(int paramInt, Object paramObject)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public Object put(Integer paramInteger, Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Map<? extends Integer, ?> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object remove(int paramInt)
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
    implements IntObjectMap<V>
  {
    private Iterable<IntObjectMap.PrimitiveEntry<V>> entries;
    private Set<Map.Entry<Integer, V>> entrySet;
    private Set<Integer> keySet;
    private final IntObjectMap<V> map;
    private Collection<V> values;
    
    UnmodifiableMap(IntObjectMap<V> paramIntObjectMap)
    {
      this.map = paramIntObjectMap;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException("clear");
    }
    
    public boolean containsKey(int paramInt)
    {
      return this.map.containsKey(paramInt);
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    public Iterable<IntObjectMap.PrimitiveEntry<V>> entries()
    {
      if (this.entries == null) {
        this.entries = new Iterable()
        {
          public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator()
          {
            IntCollections.UnmodifiableMap localUnmodifiableMap = IntCollections.UnmodifiableMap.this;
            return new IntCollections.UnmodifiableMap.IteratorImpl(localUnmodifiableMap, localUnmodifiableMap.map.entries().iterator());
          }
        };
      }
      return this.entries;
    }
    
    public Set<Map.Entry<Integer, V>> entrySet()
    {
      if (this.entrySet == null) {
        this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
      }
      return this.entrySet;
    }
    
    public V get(int paramInt)
    {
      return (V)this.map.get(paramInt);
    }
    
    public V get(Object paramObject)
    {
      return (V)this.map.get(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public Set<Integer> keySet()
    {
      if (this.keySet == null) {
        this.keySet = Collections.unmodifiableSet(this.map.keySet());
      }
      return this.keySet;
    }
    
    public V put(int paramInt, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public V put(Integer paramInteger, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public void putAll(Map<? extends Integer, ? extends V> paramMap)
    {
      throw new UnsupportedOperationException("putAll");
    }
    
    public V remove(int paramInt)
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
      implements IntObjectMap.PrimitiveEntry<V>
    {
      private final IntObjectMap.PrimitiveEntry<V> entry;
      
      EntryImpl()
      {
        IntObjectMap.PrimitiveEntry localPrimitiveEntry;
        this.entry = localPrimitiveEntry;
      }
      
      public int key()
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
      implements Iterator<IntObjectMap.PrimitiveEntry<V>>
    {
      final Iterator<IntObjectMap.PrimitiveEntry<V>> iter;
      
      IteratorImpl()
      {
        Iterator localIterator;
        this.iter = localIterator;
      }
      
      public boolean hasNext()
      {
        return this.iter.hasNext();
      }
      
      public IntObjectMap.PrimitiveEntry<V> next()
      {
        if (hasNext()) {
          return new IntCollections.UnmodifiableMap.EntryImpl(IntCollections.UnmodifiableMap.this, (IntObjectMap.PrimitiveEntry)this.iter.next());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\IntCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */