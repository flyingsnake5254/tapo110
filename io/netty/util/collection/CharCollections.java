package io.netty.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class CharCollections
{
  private static final CharObjectMap<Object> EMPTY_MAP = new EmptyMap(null);
  
  public static <V> CharObjectMap<V> emptyMap()
  {
    return EMPTY_MAP;
  }
  
  public static <V> CharObjectMap<V> unmodifiableMap(CharObjectMap<V> paramCharObjectMap)
  {
    return new UnmodifiableMap(paramCharObjectMap);
  }
  
  private static final class EmptyMap
    implements CharObjectMap<Object>
  {
    public void clear() {}
    
    public boolean containsKey(char paramChar)
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
    
    public Iterable<CharObjectMap.PrimitiveEntry<Object>> entries()
    {
      return Collections.emptySet();
    }
    
    public Set<Map.Entry<Character, Object>> entrySet()
    {
      return Collections.emptySet();
    }
    
    public Object get(char paramChar)
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
    
    public Set<Character> keySet()
    {
      return Collections.emptySet();
    }
    
    public Object put(char paramChar, Object paramObject)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public Object put(Character paramCharacter, Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Map<? extends Character, ?> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object remove(char paramChar)
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
    implements CharObjectMap<V>
  {
    private Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
    private Set<Map.Entry<Character, V>> entrySet;
    private Set<Character> keySet;
    private final CharObjectMap<V> map;
    private Collection<V> values;
    
    UnmodifiableMap(CharObjectMap<V> paramCharObjectMap)
    {
      this.map = paramCharObjectMap;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException("clear");
    }
    
    public boolean containsKey(char paramChar)
    {
      return this.map.containsKey(paramChar);
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    public Iterable<CharObjectMap.PrimitiveEntry<V>> entries()
    {
      if (this.entries == null) {
        this.entries = new Iterable()
        {
          public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator()
          {
            CharCollections.UnmodifiableMap localUnmodifiableMap = CharCollections.UnmodifiableMap.this;
            return new CharCollections.UnmodifiableMap.IteratorImpl(localUnmodifiableMap, localUnmodifiableMap.map.entries().iterator());
          }
        };
      }
      return this.entries;
    }
    
    public Set<Map.Entry<Character, V>> entrySet()
    {
      if (this.entrySet == null) {
        this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
      }
      return this.entrySet;
    }
    
    public V get(char paramChar)
    {
      return (V)this.map.get(paramChar);
    }
    
    public V get(Object paramObject)
    {
      return (V)this.map.get(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.map.isEmpty();
    }
    
    public Set<Character> keySet()
    {
      if (this.keySet == null) {
        this.keySet = Collections.unmodifiableSet(this.map.keySet());
      }
      return this.keySet;
    }
    
    public V put(char paramChar, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public V put(Character paramCharacter, V paramV)
    {
      throw new UnsupportedOperationException("put");
    }
    
    public void putAll(Map<? extends Character, ? extends V> paramMap)
    {
      throw new UnsupportedOperationException("putAll");
    }
    
    public V remove(char paramChar)
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
      implements CharObjectMap.PrimitiveEntry<V>
    {
      private final CharObjectMap.PrimitiveEntry<V> entry;
      
      EntryImpl()
      {
        CharObjectMap.PrimitiveEntry localPrimitiveEntry;
        this.entry = localPrimitiveEntry;
      }
      
      public char key()
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
      implements Iterator<CharObjectMap.PrimitiveEntry<V>>
    {
      final Iterator<CharObjectMap.PrimitiveEntry<V>> iter;
      
      IteratorImpl()
      {
        Iterator localIterator;
        this.iter = localIterator;
      }
      
      public boolean hasNext()
      {
        return this.iter.hasNext();
      }
      
      public CharObjectMap.PrimitiveEntry<V> next()
      {
        if (hasNext()) {
          return new CharCollections.UnmodifiableMap.EntryImpl(CharCollections.UnmodifiableMap.this, (CharObjectMap.PrimitiveEntry)this.iter.next());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\collection\CharCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */