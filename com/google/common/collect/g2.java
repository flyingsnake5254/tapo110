package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class g2<C extends Comparable>
  extends ContiguousSet<C>
{
  private final Range<C> c;
  
  g2(Range<C> paramRange, i0<C> parami0)
  {
    super(parami0);
    this.c = paramRange;
  }
  
  private static boolean b(Comparable<?> paramComparable1, @NullableDecl Comparable<?> paramComparable2)
  {
    boolean bool;
    if ((paramComparable2 != null) && (Range.compareOrThrow(paramComparable1, paramComparable2) == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private ContiguousSet<C> f(Range<C> paramRange)
  {
    if (this.c.isConnected(paramRange)) {
      paramRange = ContiguousSet.create(this.c.intersection(paramRange), this.domain);
    } else {
      paramRange = new j0(this.domain);
    }
    return paramRange;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = this.c.contains((Comparable)paramObject);
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return w.b(this, paramCollection);
  }
  
  ImmutableList<C> createAsList()
  {
    if (this.domain.c) {
      return new c();
    }
    return super.createAsList();
  }
  
  public C d()
  {
    return this.c.lowerBound.n(this.domain);
  }
  
  public j3<C> descendingIterator()
  {
    return new b(g());
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g2))
    {
      g2 localg2 = (g2)paramObject;
      if (this.domain.equals(localg2.domain))
      {
        if ((!d().equals(localg2.d())) || (!g().equals(localg2.g()))) {
          bool = false;
        }
        return bool;
      }
    }
    return super.equals(paramObject);
  }
  
  public C g()
  {
    return this.c.upperBound.l(this.domain);
  }
  
  public int hashCode()
  {
    return u2.b(this);
  }
  
  ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean)
  {
    return f(Range.upTo(paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  int indexOf(Object paramObject)
  {
    int i;
    if (contains(paramObject)) {
      i = (int)this.domain.a(d(), (Comparable)paramObject);
    } else {
      i = -1;
    }
    return i;
  }
  
  public ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet)
  {
    n.o(paramContiguousSet);
    n.d(this.domain.equals(paramContiguousSet.domain));
    if (paramContiguousSet.isEmpty()) {
      return paramContiguousSet;
    }
    Comparable localComparable = (Comparable)a2.g().d(d(), paramContiguousSet.first());
    paramContiguousSet = (Comparable)a2.g().f(g(), paramContiguousSet.last());
    if (localComparable.compareTo(paramContiguousSet) <= 0) {
      paramContiguousSet = ContiguousSet.create(Range.closed(localComparable, paramContiguousSet), this.domain);
    } else {
      paramContiguousSet = new j0(this.domain);
    }
    return paramContiguousSet;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public j3<C> iterator()
  {
    return new a(d());
  }
  
  public Range<C> range()
  {
    BoundType localBoundType = BoundType.CLOSED;
    return range(localBoundType, localBoundType);
  }
  
  public Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2)
  {
    return Range.create(this.c.lowerBound.q(paramBoundType1, this.domain), this.c.upperBound.r(paramBoundType2, this.domain));
  }
  
  public int size()
  {
    long l = this.domain.a(d(), g());
    int i;
    if (l >= 2147483647L) {
      i = Integer.MAX_VALUE;
    } else {
      i = (int)l + 1;
    }
    return i;
  }
  
  ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
  {
    if ((paramC1.compareTo(paramC2) == 0) && (!paramBoolean1) && (!paramBoolean2)) {
      return new j0(this.domain);
    }
    return f(Range.range(paramC1, BoundType.forBoolean(paramBoolean1), paramC2, BoundType.forBoolean(paramBoolean2)));
  }
  
  ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean)
  {
    return f(Range.downTo(paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  Object writeReplace()
  {
    return new d(this.c, this.domain, null);
  }
  
  class a
    extends l<C>
  {
    final C d = g2.this.g();
    
    a(Comparable paramComparable)
    {
      super();
    }
    
    protected C b(C paramC)
    {
      if (g2.a(paramC, this.d)) {
        paramC = null;
      } else {
        paramC = g2.this.domain.h(paramC);
      }
      return paramC;
    }
  }
  
  class b
    extends l<C>
  {
    final C d = g2.this.d();
    
    b(Comparable paramComparable)
    {
      super();
    }
    
    protected C b(C paramC)
    {
      if (g2.a(paramC, this.d)) {
        paramC = null;
      } else {
        paramC = g2.this.domain.j(paramC);
      }
      return paramC;
    }
  }
  
  class c
    extends z0<C>
  {
    c() {}
    
    ImmutableSortedSet<C> b()
    {
      return g2.this;
    }
    
    public C d(int paramInt)
    {
      n.m(paramInt, size());
      g2 localg2 = g2.this;
      return localg2.domain.i(localg2.d(), paramInt);
    }
  }
  
  private static final class d<C extends Comparable>
    implements Serializable
  {
    final Range<C> c;
    final i0<C> d;
    
    private d(Range<C> paramRange, i0<C> parami0)
    {
      this.c = paramRange;
      this.d = parami0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\g2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */