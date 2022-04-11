package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class b3
{
  private static <E> E c(@NullableDecl u1.a<E> parama)
  {
    if (parama == null) {
      parama = null;
    } else {
      parama = parama.a();
    }
    return parama;
  }
  
  private static <E> E d(u1.a<E> parama)
  {
    if (parama != null) {
      return (E)parama.a();
    }
    throw new NoSuchElementException();
  }
  
  static class a<E>
    extends v1.c<E>
    implements SortedSet<E>
  {
    @Weak
    private final a3<E> c;
    
    a(a3<E> parama3)
    {
      this.c = parama3;
    }
    
    public Comparator<? super E> comparator()
    {
      return e().comparator();
    }
    
    final a3<E> e()
    {
      return this.c;
    }
    
    public E first()
    {
      return (E)b3.a(e().firstEntry());
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      return e().headMultiset(paramE, BoundType.OPEN).elementSet();
    }
    
    public Iterator<E> iterator()
    {
      return v1.e(e().entrySet().iterator());
    }
    
    public E last()
    {
      return (E)b3.a(e().lastEntry());
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      return e().subMultiset(paramE1, BoundType.CLOSED, paramE2, BoundType.OPEN).elementSet();
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      return e().tailMultiset(paramE, BoundType.CLOSED).elementSet();
    }
  }
  
  static class b<E>
    extends b3.a<E>
    implements NavigableSet<E>
  {
    b(a3<E> parama3)
    {
      super();
    }
    
    public E ceiling(E paramE)
    {
      return (E)b3.b(e().tailMultiset(paramE, BoundType.CLOSED).firstEntry());
    }
    
    public Iterator<E> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<E> descendingSet()
    {
      return new b(e().descendingMultiset());
    }
    
    public E floor(E paramE)
    {
      return (E)b3.b(e().headMultiset(paramE, BoundType.CLOSED).lastEntry());
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return new b(e().headMultiset(paramE, BoundType.forBoolean(paramBoolean)));
    }
    
    public E higher(E paramE)
    {
      return (E)b3.b(e().tailMultiset(paramE, BoundType.OPEN).firstEntry());
    }
    
    public E lower(E paramE)
    {
      return (E)b3.b(e().headMultiset(paramE, BoundType.OPEN).lastEntry());
    }
    
    public E pollFirst()
    {
      return (E)b3.b(e().pollFirstEntry());
    }
    
    public E pollLast()
    {
      return (E)b3.b(e().pollLastEntry());
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return new b(e().subMultiset(paramE1, BoundType.forBoolean(paramBoolean1), paramE2, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return new b(e().tailMultiset(paramE, BoundType.forBoolean(paramBoolean)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\b3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */