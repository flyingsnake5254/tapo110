package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class ReferenceMap<K, V>
  implements Map<K, V>
{
  private final Map<K, Reference<V>> delegate;
  
  protected ReferenceMap(Map<K, Reference<V>> paramMap)
  {
    this.delegate = paramMap;
  }
  
  private V unfold(Reference<V> paramReference)
  {
    if (paramReference == null) {
      return null;
    }
    return (V)paramReference.get();
  }
  
  public void clear()
  {
    this.delegate.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.delegate.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    throw new UnsupportedOperationException();
  }
  
  abstract Reference<V> fold(V paramV);
  
  public V get(Object paramObject)
  {
    return (V)unfold((Reference)this.delegate.get(paramObject));
  }
  
  public boolean isEmpty()
  {
    return this.delegate.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return this.delegate.keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    return (V)unfold((Reference)this.delegate.put(paramK, fold(paramV)));
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.delegate.put(localEntry.getKey(), fold(localEntry.getValue()));
    }
  }
  
  public V remove(Object paramObject)
  {
    return (V)unfold((Reference)this.delegate.remove(paramObject));
  }
  
  public int size()
  {
    return this.delegate.size();
  }
  
  public Collection<V> values()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ReferenceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */