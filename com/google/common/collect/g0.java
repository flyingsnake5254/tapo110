package com.google.common.collect;

import java.util.AbstractCollection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class g0<E>
  extends ImmutableSortedSet<E>
{
  private final ImmutableSortedSet<E> c;
  
  g0(ImmutableSortedSet<E> paramImmutableSortedSet)
  {
    super(a2.a(paramImmutableSortedSet.comparator()).j());
    this.c = paramImmutableSortedSet;
  }
  
  public E ceiling(E paramE)
  {
    return (E)this.c.floor(paramE);
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    return this.c.contains(paramObject);
  }
  
  ImmutableSortedSet<E> createDescendingSet()
  {
    throw new AssertionError("should never be called");
  }
  
  public j3<E> descendingIterator()
  {
    return this.c.iterator();
  }
  
  public ImmutableSortedSet<E> descendingSet()
  {
    return this.c;
  }
  
  public E floor(E paramE)
  {
    return (E)this.c.ceiling(paramE);
  }
  
  ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean)
  {
    return this.c.tailSet(paramE, paramBoolean).descendingSet();
  }
  
  public E higher(E paramE)
  {
    return (E)this.c.lower(paramE);
  }
  
  int indexOf(@NullableDecl Object paramObject)
  {
    int i = this.c.indexOf(paramObject);
    if (i == -1) {
      return i;
    }
    return size() - 1 - i;
  }
  
  boolean isPartialView()
  {
    return this.c.isPartialView();
  }
  
  public j3<E> iterator()
  {
    return this.c.descendingIterator();
  }
  
  public E lower(E paramE)
  {
    return (E)this.c.higher(paramE);
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return this.c.subSet(paramE2, paramBoolean2, paramE1, paramBoolean1).descendingSet();
  }
  
  ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean)
  {
    return this.c.headSet(paramE, paramBoolean).descendingSet();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */