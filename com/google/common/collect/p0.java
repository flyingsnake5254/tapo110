package com.google.common.collect;

import com.google.common.base.k;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class p0<K, V>
  extends s0
  implements Map<K, V>
{
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    return delegate().containsKey(paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return delegate().containsValue(paramObject);
  }
  
  protected abstract Map<K, V> delegate();
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return delegate().entrySet();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && (!delegate().equals(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public V get(@NullableDecl Object paramObject)
  {
    return (V)delegate().get(paramObject);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public Set<K> keySet()
  {
    return delegate().keySet();
  }
  
  @CanIgnoreReturnValue
  public V put(K paramK, V paramV)
  {
    return (V)delegate().put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    delegate().putAll(paramMap);
  }
  
  @CanIgnoreReturnValue
  public V remove(Object paramObject)
  {
    return (V)delegate().remove(paramObject);
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  protected void standardClear()
  {
    k1.d(entrySet().iterator());
  }
  
  protected boolean standardContainsKey(@NullableDecl Object paramObject)
  {
    return q1.f(this, paramObject);
  }
  
  protected boolean standardContainsValue(@NullableDecl Object paramObject)
  {
    return q1.g(this, paramObject);
  }
  
  protected boolean standardEquals(@NullableDecl Object paramObject)
  {
    return q1.h(this, paramObject);
  }
  
  protected int standardHashCode()
  {
    return u2.b(entrySet());
  }
  
  protected boolean standardIsEmpty()
  {
    return entrySet().iterator().hasNext() ^ true;
  }
  
  protected void standardPutAll(Map<? extends K, ? extends V> paramMap)
  {
    q1.t(this, paramMap);
  }
  
  protected V standardRemove(@NullableDecl Object paramObject)
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (k.a(localEntry.getKey(), paramObject))
      {
        paramObject = localEntry.getValue();
        localIterator.remove();
        return (V)paramObject;
      }
    }
    return null;
  }
  
  protected String standardToString()
  {
    return q1.x(this);
  }
  
  public Collection<V> values()
  {
    return delegate().values();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */