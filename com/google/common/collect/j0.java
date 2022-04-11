package com.google.common.collect;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class j0<C extends Comparable>
  extends ContiguousSet<C>
{
  j0(i0<C> parami0)
  {
    super(parami0);
  }
  
  public C a()
  {
    throw new NoSuchElementException();
  }
  
  public ImmutableList<C> asList()
  {
    return ImmutableList.of();
  }
  
  public C b()
  {
    throw new NoSuchElementException();
  }
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  ImmutableSortedSet<C> createDescendingSet()
  {
    return ImmutableSortedSet.emptySet(a2.g().j());
  }
  
  public j3<C> descendingIterator()
  {
    return k1.h();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof Set)) {
      return ((Set)paramObject).isEmpty();
    }
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean)
  {
    return this;
  }
  
  int indexOf(Object paramObject)
  {
    return -1;
  }
  
  public ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet)
  {
    return this;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public j3<C> iterator()
  {
    return k1.h();
  }
  
  public Range<C> range()
  {
    throw new NoSuchElementException();
  }
  
  public Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2)
  {
    throw new NoSuchElementException();
  }
  
  public int size()
  {
    return 0;
  }
  
  ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
  {
    return this;
  }
  
  ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean)
  {
    return this;
  }
  
  public String toString()
  {
    return "[]";
  }
  
  Object writeReplace()
  {
    return new b(this.domain, null);
  }
  
  private static final class b<C extends Comparable>
    implements Serializable
  {
    private final i0<C> c;
    
    private b(i0<C> parami0)
    {
      this.c = parami0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */