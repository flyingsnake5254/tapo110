package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class h<K, V>
  implements r1<K, V>
{
  @MonotonicNonNullDecl
  private transient Map<K, Collection<V>> asMap;
  @MonotonicNonNullDecl
  private transient Collection<Map.Entry<K, V>> entries;
  @MonotonicNonNullDecl
  private transient Set<K> keySet;
  @MonotonicNonNullDecl
  private transient u1<K> keys;
  @MonotonicNonNullDecl
  private transient Collection<V> values;
  
  public Map<K, Collection<V>> asMap()
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
  
  public boolean containsEntry(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Collection)asMap().get(paramObject1);
    boolean bool;
    if ((paramObject1 != null) && (((Collection)paramObject1).contains(paramObject2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    Iterator localIterator = asMap().values().iterator();
    while (localIterator.hasNext()) {
      if (((Collection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  abstract Map<K, Collection<V>> createAsMap();
  
  abstract Collection<Map.Entry<K, V>> createEntries();
  
  abstract Set<K> createKeySet();
  
  abstract u1<K> createKeys();
  
  abstract Collection<V> createValues();
  
  public Collection<Map.Entry<K, V>> entries()
  {
    Collection localCollection1 = this.entries;
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null)
    {
      localCollection2 = createEntries();
      this.entries = localCollection2;
    }
    return localCollection2;
  }
  
  abstract Iterator<Map.Entry<K, V>> entryIterator();
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return t1.a(this, paramObject);
  }
  
  public int hashCode()
  {
    return asMap().hashCode();
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<K> keySet()
  {
    Set localSet1 = this.keySet;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = createKeySet();
      this.keySet = localSet2;
    }
    return localSet2;
  }
  
  public u1<K> keys()
  {
    u1 localu11 = this.keys;
    u1 localu12 = localu11;
    if (localu11 == null)
    {
      localu12 = createKeys();
      this.keys = localu12;
    }
    return localu12;
  }
  
  @CanIgnoreReturnValue
  public abstract boolean put(@NullableDecl K paramK, @NullableDecl V paramV);
  
  @CanIgnoreReturnValue
  public boolean putAll(r1<? extends K, ? extends V> paramr1)
  {
    paramr1 = paramr1.entries().iterator();
    boolean bool = false;
    while (paramr1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramr1.next();
      bool |= put(localEntry.getKey(), localEntry.getValue());
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public boolean putAll(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    n.o(paramIterable);
    boolean bool1 = paramIterable instanceof Collection;
    boolean bool2 = true;
    boolean bool3 = true;
    if (bool1)
    {
      paramIterable = (Collection)paramIterable;
      if ((paramIterable.isEmpty()) || (!get(paramK).addAll(paramIterable))) {
        bool3 = false;
      }
      return bool3;
    }
    paramIterable = paramIterable.iterator();
    if ((paramIterable.hasNext()) && (k1.a(get(paramK), paramIterable))) {
      bool3 = bool2;
    } else {
      bool3 = false;
    }
    return bool3;
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Collection)asMap().get(paramObject1);
    boolean bool;
    if ((paramObject1 != null) && (((Collection)paramObject1).remove(paramObject2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public abstract Collection<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable);
  
  public String toString()
  {
    return asMap().toString();
  }
  
  Iterator<V> valueIterator()
  {
    return q1.D(entries().iterator());
  }
  
  public Collection<V> values()
  {
    Collection localCollection1 = this.values;
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null)
    {
      localCollection2 = createValues();
      this.values = localCollection2;
    }
    return localCollection2;
  }
  
  class a
    extends t1.c<K, V>
  {
    a() {}
    
    r1<K, V> a()
    {
      return h.this;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return h.this.entryIterator();
    }
  }
  
  class b
    extends h<K, V>.a
    implements Set<Map.Entry<K, V>>
  {
    b()
    {
      super();
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      return u2.a(this, paramObject);
    }
    
    public int hashCode()
    {
      return u2.b(this);
    }
  }
  
  class c
    extends AbstractCollection<V>
  {
    c() {}
    
    public void clear()
    {
      h.this.clear();
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return h.this.containsValue(paramObject);
    }
    
    public Iterator<V> iterator()
    {
      return h.this.valueIterator();
    }
    
    public int size()
    {
      return h.this.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */