package io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ByteCollections
{
  private static final ByteObjectMap<Object> EMPTY_MAP = new EmptyMap(null);
  
  public static <V> ByteObjectMap<V> emptyMap()
  {
    return EMPTY_MAP;
  }
  
  public static <V> ByteObjectMap<V> unmodifiableMap(ByteObjectMap<V> paramByteObjectMap)
  {
    return new UnmodifiableMap(paramByteObjectMap);
  }
  
  private static final class EmptyMap
    implements ByteObjectMap<Object>
  {
    public void clear() {}
    
    public boolean containsKey(byte paramByte)
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
    
    public Iterable<ByteObjectMap.PrimitiveEntry<Object>> entries()
    {
      return Collections.emptySet();
    }
    
    public Set<Map.Entry<Byte, Object>> entrySet()
    {
      return Collections.emptySet();
    }
    
    public Object get(byte paramByte)
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
    
    public Set<Byte> keySet()
    {
      return Collections.emptySet();
    }
    
    public Object put(byte paramByte, Object paramObject)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public Object put(Byte paramByte, Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Map<? extends Byte, ?> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object remove(byte paramByte)
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
    implements ByteObjectMap<V>
  {
    private Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
    private Set<Map.Entry<Byte, V>> entrySet;
    private Set<Byte> keySet;
    private final ByteObjectMap<V> map;
    private Collection<V> values;
    
    UnmodifiableMap(ByteObjectMap<V> paramByteObjectMap)
    {
      this.map = paramByteObjectMap;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException("clear");
    }
    
    public boolean containsKey(byte paramByte)
    {
      return this.map.containsKey(paramByte);
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries()
    {
      if (this.entries == null) {
        this.entries = new Iterable()
        {
          public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator()
          {
            ByteCollections.UnmodifiableMap localUnmodifiableMap = ByteCollections.UnmodifiableMap.this;
            return new ByteCollections.UnmodifiableMap.IteratorImpl(localUnmodifiableMap, localUnmodifiableMap.map.entries().iterator());
          }
        };
      }
      return this.entries;
    }
    
    public Set<Map.Entry<Byte, V>> entrySet()
    {
      if (this.entrySet == null) {
        this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
      }
      return this.entrySet;
    }
    
    public V get(byte paramByte)
    {
      return (V)this.map.get(paramByte);
    }
    
    public V get(Object paramObject)
    {
      return (V)this.map.get(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public Set<Byte> keySet()
    {
      if (this.keySet == null) {
        this.keySet = Collections.unmodifiableSet(this.map.keySet());
      }
      return this.keySet;
    }
    
    public V put(byte paramByte, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public V put(Byte paramByte, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public void putAll(Map<? extends Byte, ? extends V> paramMap)
    {
      throw new UnsupportedOperationException("putAll");
    }
    
    public V remove(byte paramByte)
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
      implements ByteObjectMap.PrimitiveEntry<V>
    {
      private final ByteObjectMap.PrimitiveEntry<V> entry;
      
      EntryImpl()
      {
        ByteObjectMap.PrimitiveEntry localPrimitiveEntry;
        this.entry = localPrimitiveEntry;
      }
      
      public byte key()
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
      implements Iterator<ByteObjectMap.PrimitiveEntry<V>>
    {
      final Iterator<ByteObjectMap.PrimitiveEntry<V>> iter;
      
      IteratorImpl()
      {
        Iterator localIterator;
        this.iter = localIterator;
      }
      
      public boolean hasNext()
      {
        return this.iter.hasNext();
      }
      
      public ByteObjectMap.PrimitiveEntry<V> next()
      {
        if (hasNext()) {
          return new ByteCollections.UnmodifiableMap.EntryImpl(ByteCollections.UnmodifiableMap.this, (ByteObjectMap.PrimitiveEntry)this.iter.next());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\ByteCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */