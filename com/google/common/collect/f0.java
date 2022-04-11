package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class f0<E>
  extends ImmutableSortedMultiset<E>
{
  private final transient ImmutableSortedMultiset<E> c;
  
  f0(ImmutableSortedMultiset<E> paramImmutableSortedMultiset)
  {
    this.c = paramImmutableSortedMultiset;
  }
  
  public int count(@NullableDecl Object paramObject)
  {
    return this.c.count(paramObject);
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset()
  {
    return this.c;
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return this.c.elementSet().descendingSet();
  }
  
  public u1.a<E> firstEntry()
  {
    return this.c.lastEntry();
  }
  
  u1.a<E> getEntry(int paramInt)
  {
    return (u1.a)this.c.entrySet().asList().reverse().get(paramInt);
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return this.c.tailMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  boolean isPartialView()
  {
    return this.c.isPartialView();
  }
  
  public u1.a<E> lastEntry()
  {
    return this.c.firstEntry();
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return this.c.headMultiset(paramE, paramBoundType).descendingMultiset();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */