package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class d<K, V>
  extends e<K, V>
  implements m1<K, V>
{
  private static final long serialVersionUID = 6588350623831699109L;
  
  protected d(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  public Map<K, Collection<V>> asMap()
  {
    return super.asMap();
  }
  
  abstract List<V> createCollection();
  
  List<V> createUnmodifiableEmptyCollection()
  {
    return Collections.emptyList();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public List<V> get(@NullableDecl K paramK)
  {
    return (List)super.get(paramK);
  }
  
  @CanIgnoreReturnValue
  public boolean put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return super.put(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public List<V> removeAll(@NullableDecl Object paramObject)
  {
    return (List)super.removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public List<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    return (List)super.replaceValues(paramK, paramIterable);
  }
  
  <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> paramCollection)
  {
    return Collections.unmodifiableList((List)paramCollection);
  }
  
  Collection<V> wrapCollection(K paramK, Collection<V> paramCollection)
  {
    return wrapList(paramK, (List)paramCollection, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */