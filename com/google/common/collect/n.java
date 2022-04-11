package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class n<K, V>
  extends p<K, V>
{
  n(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap);
  }
  
  public SortedMap<K, Collection<V>> asMap()
  {
    return (SortedMap)super.asMap();
  }
  
  SortedMap<K, Collection<V>> backingMap()
  {
    return (SortedMap)super.backingMap();
  }
  
  Set<K> createKeySet()
  {
    return createMaybeNavigableKeySet();
  }
  
  public SortedSet<K> keySet()
  {
    return (SortedSet)super.keySet();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */