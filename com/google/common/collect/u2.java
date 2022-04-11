package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class u2
{
  static boolean a(Set<?> paramSet, @NullableDecl Object paramObject)
  {
    boolean bool1 = true;
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        boolean bool2 = paramSet.containsAll((Collection)paramObject);
        if (bool2) {}
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    catch (NullPointerException|ClassCastException paramSet)
    {
      for (;;) {}
    }
    return false;
  }
  
  static int b(Set<?> paramSet)
  {
    paramSet = paramSet.iterator();
    int j;
    for (int i = 0; paramSet.hasNext(); i = i + j ^ 0xFFFFFFFF ^ 0xFFFFFFFF)
    {
      Object localObject = paramSet.next();
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
    }
    return i;
  }
  
  public static <E> c<E> c(Set<E> paramSet, final Set<?> paramSet1)
  {
    n.p(paramSet, "set1");
    n.p(paramSet1, "set2");
    return new a(paramSet, paramSet1);
  }
  
  public static <E> HashSet<E> d()
  {
    return new HashSet();
  }
  
  public static <E> HashSet<E> e(int paramInt)
  {
    return new HashSet(q1.d(paramInt));
  }
  
  public static <E> Set<E> f()
  {
    return Collections.newSetFromMap(q1.q());
  }
  
  static boolean g(Set<?> paramSet, Collection<?> paramCollection)
  {
    n.o(paramCollection);
    Object localObject = paramCollection;
    if ((paramCollection instanceof u1)) {
      localObject = ((u1)paramCollection).elementSet();
    }
    if (((localObject instanceof Set)) && (((Collection)localObject).size() > paramSet.size())) {
      return k1.s(paramSet.iterator(), (Collection)localObject);
    }
    return h(paramSet, ((Collection)localObject).iterator());
  }
  
  static boolean h(Set<?> paramSet, Iterator<?> paramIterator)
  {
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramSet.remove(paramIterator.next());
    }
    return bool;
  }
  
  public static <E> NavigableSet<E> i(NavigableSet<E> paramNavigableSet)
  {
    if ((!(paramNavigableSet instanceof ImmutableCollection)) && (!(paramNavigableSet instanceof d))) {
      return new d(paramNavigableSet);
    }
    return paramNavigableSet;
  }
  
  static final class a
    extends u2.c<E>
  {
    a(Set paramSet1, Set paramSet2)
    {
      super();
    }
    
    public j3<E> a()
    {
      return new a();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if ((this.c.contains(paramObject)) && (paramSet1.contains(paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      boolean bool;
      if ((this.c.containsAll(paramCollection)) && (paramSet1.containsAll(paramCollection))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isEmpty()
    {
      return Collections.disjoint(paramSet1, this.c);
    }
    
    public int size()
    {
      Iterator localIterator = this.c.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (paramSet1.contains(localObject)) {
          i++;
        }
      }
      return i;
    }
    
    class a
      extends c<E>
    {
      final Iterator<E> f = u2.a.this.c.iterator();
      
      a() {}
      
      protected E a()
      {
        while (this.f.hasNext())
        {
          Object localObject = this.f.next();
          if (u2.a.this.d.contains(localObject)) {
            return (E)localObject;
          }
        }
        return (E)b();
      }
    }
  }
  
  static abstract class b<E>
    extends AbstractSet<E>
  {
    public boolean removeAll(Collection<?> paramCollection)
    {
      return u2.g(this, paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return super.retainAll((Collection)n.o(paramCollection));
    }
  }
  
  public static abstract class c<E>
    extends AbstractSet<E>
  {
    @Deprecated
    @CanIgnoreReturnValue
    public final boolean add(E paramE)
    {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public final void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @CanIgnoreReturnValue
    public final boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class d<E>
    extends v0<E>
    implements NavigableSet<E>, Serializable
  {
    private final NavigableSet<E> c;
    private final SortedSet<E> d;
    @MonotonicNonNullDecl
    private transient d<E> f;
    
    d(NavigableSet<E> paramNavigableSet)
    {
      this.c = ((NavigableSet)n.o(paramNavigableSet));
      this.d = Collections.unmodifiableSortedSet(paramNavigableSet);
    }
    
    protected SortedSet<E> a()
    {
      return this.d;
    }
    
    public E ceiling(E paramE)
    {
      return (E)this.c.ceiling(paramE);
    }
    
    public Iterator<E> descendingIterator()
    {
      return k1.y(this.c.descendingIterator());
    }
    
    public NavigableSet<E> descendingSet()
    {
      d locald1 = this.f;
      d locald2 = locald1;
      if (locald1 == null)
      {
        locald2 = new d(this.c.descendingSet());
        this.f = locald2;
        locald2.f = this;
      }
      return locald2;
    }
    
    public E floor(E paramE)
    {
      return (E)this.c.floor(paramE);
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return u2.i(this.c.headSet(paramE, paramBoolean));
    }
    
    public E higher(E paramE)
    {
      return (E)this.c.higher(paramE);
    }
    
    public E lower(E paramE)
    {
      return (E)this.c.lower(paramE);
    }
    
    public E pollFirst()
    {
      throw new UnsupportedOperationException();
    }
    
    public E pollLast()
    {
      throw new UnsupportedOperationException();
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return u2.i(this.c.subSet(paramE1, paramBoolean1, paramE2, paramBoolean2));
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return u2.i(this.c.tailSet(paramE, paramBoolean));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\u2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */