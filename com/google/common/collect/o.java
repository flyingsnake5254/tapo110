package com.google.common.collect;

import com.google.common.base.n;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class o<E>
  extends i<E>
  implements a3<E>
{
  final Comparator<? super E> comparator;
  @MonotonicNonNullDecl
  private transient a3<E> descendingMultiset;
  
  o()
  {
    this(a2.g());
  }
  
  o(Comparator<? super E> paramComparator)
  {
    this.comparator = ((Comparator)n.o(paramComparator));
  }
  
  public Comparator<? super E> comparator()
  {
    return this.comparator;
  }
  
  a3<E> createDescendingMultiset()
  {
    return new a();
  }
  
  NavigableSet<E> createElementSet()
  {
    return new b3.b(this);
  }
  
  abstract Iterator<u1.a<E>> descendingEntryIterator();
  
  Iterator<E> descendingIterator()
  {
    return v1.i(descendingMultiset());
  }
  
  public a3<E> descendingMultiset()
  {
    a3 locala31 = this.descendingMultiset;
    a3 locala32 = locala31;
    if (locala31 == null)
    {
      locala32 = createDescendingMultiset();
      this.descendingMultiset = locala32;
    }
    return locala32;
  }
  
  public NavigableSet<E> elementSet()
  {
    return (NavigableSet)super.elementSet();
  }
  
  public u1.a<E> firstEntry()
  {
    Object localObject = entryIterator();
    if (((Iterator)localObject).hasNext()) {
      localObject = (u1.a)((Iterator)localObject).next();
    } else {
      localObject = null;
    }
    return (u1.a<E>)localObject;
  }
  
  public u1.a<E> lastEntry()
  {
    Object localObject = descendingEntryIterator();
    if (((Iterator)localObject).hasNext()) {
      localObject = (u1.a)((Iterator)localObject).next();
    } else {
      localObject = null;
    }
    return (u1.a<E>)localObject;
  }
  
  public u1.a<E> pollFirstEntry()
  {
    Iterator localIterator = entryIterator();
    if (localIterator.hasNext())
    {
      u1.a locala = (u1.a)localIterator.next();
      locala = v1.g(locala.a(), locala.getCount());
      localIterator.remove();
      return locala;
    }
    return null;
  }
  
  public u1.a<E> pollLastEntry()
  {
    Iterator localIterator = descendingEntryIterator();
    if (localIterator.hasNext())
    {
      u1.a locala = (u1.a)localIterator.next();
      locala = v1.g(locala.a(), locala.getCount());
      localIterator.remove();
      return locala;
    }
    return null;
  }
  
  public a3<E> subMultiset(@NullableDecl E paramE1, BoundType paramBoundType1, @NullableDecl E paramE2, BoundType paramBoundType2)
  {
    n.o(paramBoundType1);
    n.o(paramBoundType2);
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
  
  class a
    extends h0<E>
  {
    a() {}
    
    Iterator<u1.a<E>> d()
    {
      return o.this.descendingEntryIterator();
    }
    
    a3<E> f()
    {
      return o.this;
    }
    
    public Iterator<E> iterator()
    {
      return o.this.descendingIterator();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */