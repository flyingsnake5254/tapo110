package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class p<K, V>
  extends m<K, V>
{
  private static final long serialVersionUID = 430848587173315748L;
  
  protected p(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  public Map<K, Collection<V>> asMap()
  {
    return super.asMap();
  }
  
  abstract SortedSet<V> createCollection();
  
  SortedSet<V> createUnmodifiableEmptyCollection()
  {
    return unmodifiableCollectionSubclass(createCollection());
  }
  
  public SortedSet<V> get(@NullableDecl K paramK)
  {
    return (SortedSet)super.get(paramK);
  }
  
  @CanIgnoreReturnValue
  public SortedSet<V> removeAll(@NullableDecl Object paramObject)
  {
    return (SortedSet)super.removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public SortedSet<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    return (SortedSet)super.replaceValues(paramK, paramIterable);
  }
  
  <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> paramCollection)
  {
    if ((paramCollection instanceof NavigableSet)) {
      return u2.i((NavigableSet)paramCollection);
    }
    return Collections.unmodifiableSortedSet((SortedSet)paramCollection);
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  Collection<V> wrapCollection(K paramK, Collection<V> paramCollection)
  {
    if ((paramCollection instanceof NavigableSet)) {
      return new e.m(this, paramK, (NavigableSet)paramCollection, null);
    }
    return new e.o(this, paramK, (SortedSet)paramCollection, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */