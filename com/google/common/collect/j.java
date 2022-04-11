package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class j<K, V>
  extends q1.l<K, V>
  implements NavigableMap<K, V>
{
  abstract Iterator<Map.Entry<K, V>> b();
  
  @NullableDecl
  public Map.Entry<K, V> ceilingEntry(K paramK)
  {
    return tailMap(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK)
  {
    return (K)q1.m(ceilingEntry(paramK));
  }
  
  public NavigableSet<K> descendingKeySet()
  {
    return descendingMap().navigableKeySet();
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    return new b(null);
  }
  
  @NullableDecl
  public Map.Entry<K, V> firstEntry()
  {
    return (Map.Entry)k1.n(a(), null);
  }
  
  public K firstKey()
  {
    Map.Entry localEntry = firstEntry();
    if (localEntry != null) {
      return (K)localEntry.getKey();
    }
    throw new NoSuchElementException();
  }
  
  @NullableDecl
  public Map.Entry<K, V> floorEntry(K paramK)
  {
    return headMap(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK)
  {
    return (K)q1.m(floorEntry(paramK));
  }
  
  public SortedMap<K, V> headMap(K paramK)
  {
    return headMap(paramK, false);
  }
  
  @NullableDecl
  public Map.Entry<K, V> higherEntry(K paramK)
  {
    return tailMap(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK)
  {
    return (K)q1.m(higherEntry(paramK));
  }
  
  public Set<K> keySet()
  {
    return navigableKeySet();
  }
  
  @NullableDecl
  public Map.Entry<K, V> lastEntry()
  {
    return (Map.Entry)k1.n(b(), null);
  }
  
  public K lastKey()
  {
    Map.Entry localEntry = lastEntry();
    if (localEntry != null) {
      return (K)localEntry.getKey();
    }
    throw new NoSuchElementException();
  }
  
  @NullableDecl
  public Map.Entry<K, V> lowerEntry(K paramK)
  {
    return headMap(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK)
  {
    return (K)q1.m(lowerEntry(paramK));
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return new q1.n(this);
  }
  
  @NullableDecl
  public Map.Entry<K, V> pollFirstEntry()
  {
    return (Map.Entry)k1.r(a());
  }
  
  @NullableDecl
  public Map.Entry<K, V> pollLastEntry()
  {
    return (Map.Entry)k1.r(b());
  }
  
  public SortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return subMap(paramK1, true, paramK2, false);
  }
  
  public SortedMap<K, V> tailMap(K paramK)
  {
    return tailMap(paramK, true);
  }
  
  private final class b
    extends q1.h<K, V>
  {
    private b() {}
    
    Iterator<Map.Entry<K, V>> b()
    {
      return j.this.b();
    }
    
    NavigableMap<K, V> d()
    {
      return j.this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */