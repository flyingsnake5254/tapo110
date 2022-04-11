package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class m<K, V>
  extends e<K, V>
  implements s2<K, V>
{
  private static final long serialVersionUID = 7431625294878419160L;
  
  protected m(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  public Map<K, Collection<V>> asMap()
  {
    return super.asMap();
  }
  
  abstract Set<V> createCollection();
  
  Set<V> createUnmodifiableEmptyCollection()
  {
    return Collections.emptySet();
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return (Set)super.entries();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Set<V> get(@NullableDecl K paramK)
  {
    return (Set)super.get(paramK);
  }
  
  @CanIgnoreReturnValue
  public boolean put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return super.put(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public Set<V> removeAll(@NullableDecl Object paramObject)
  {
    return (Set)super.removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    return (Set)super.replaceValues(paramK, paramIterable);
  }
  
  <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> paramCollection)
  {
    return Collections.unmodifiableSet((Set)paramCollection);
  }
  
  Collection<V> wrapCollection(K paramK, Collection<V> paramCollection)
  {
    return new e.n(this, paramK, (Set)paramCollection);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */