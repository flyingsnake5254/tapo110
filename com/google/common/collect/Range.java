package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.o;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Range<C extends Comparable>
  extends d2
  implements o<C>, Serializable
{
  private static final Range<Comparable> ALL = new Range(d0.d(), d0.a());
  private static final long serialVersionUID = 0L;
  final d0<C> lowerBound;
  final d0<C> upperBound;
  
  private Range(d0<C> paramd01, d0<C> paramd02)
  {
    this.lowerBound = ((d0)n.o(paramd01));
    this.upperBound = ((d0)n.o(paramd02));
    if ((paramd01.h(paramd02) <= 0) && (paramd01 != d0.a()) && (paramd02 != d0.d())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid range: ");
    localStringBuilder.append(toString(paramd01, paramd02));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static <C extends Comparable<?>> Range<C> all()
  {
    return ALL;
  }
  
  public static <C extends Comparable<?>> Range<C> atLeast(C paramC)
  {
    return create(d0.f(paramC), d0.a());
  }
  
  public static <C extends Comparable<?>> Range<C> atMost(C paramC)
  {
    return create(d0.d(), d0.b(paramC));
  }
  
  private static <T> SortedSet<T> cast(Iterable<T> paramIterable)
  {
    return (SortedSet)paramIterable;
  }
  
  public static <C extends Comparable<?>> Range<C> closed(C paramC1, C paramC2)
  {
    return create(d0.f(paramC1), d0.b(paramC2));
  }
  
  public static <C extends Comparable<?>> Range<C> closedOpen(C paramC1, C paramC2)
  {
    return create(d0.f(paramC1), d0.f(paramC2));
  }
  
  static int compareOrThrow(Comparable paramComparable1, Comparable paramComparable2)
  {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  static <C extends Comparable<?>> Range<C> create(d0<C> paramd01, d0<C> paramd02)
  {
    return new Range(paramd01, paramd02);
  }
  
  public static <C extends Comparable<?>> Range<C> downTo(C paramC, BoundType paramBoundType)
  {
    int i = a.a[paramBoundType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return atLeast(paramC);
      }
      throw new AssertionError();
    }
    return greaterThan(paramC);
  }
  
  public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> paramIterable)
  {
    n.o(paramIterable);
    if ((paramIterable instanceof SortedSet))
    {
      localObject1 = cast(paramIterable);
      localObject2 = ((SortedSet)localObject1).comparator();
      if ((a2.g().equals(localObject2)) || (localObject2 == null)) {
        return closed((Comparable)((SortedSet)localObject1).first(), (Comparable)((SortedSet)localObject1).last());
      }
    }
    Object localObject2 = paramIterable.iterator();
    Object localObject1 = (Comparable)n.o(((Iterator)localObject2).next());
    Comparable localComparable;
    for (paramIterable = (Iterable<C>)localObject1; ((Iterator)localObject2).hasNext(); paramIterable = (Comparable)a2.g().d(paramIterable, localComparable))
    {
      localComparable = (Comparable)n.o(((Iterator)localObject2).next());
      localObject1 = (Comparable)a2.g().f(localObject1, localComparable);
    }
    return closed((Comparable)localObject1, paramIterable);
  }
  
  public static <C extends Comparable<?>> Range<C> greaterThan(C paramC)
  {
    return create(d0.b(paramC), d0.a());
  }
  
  public static <C extends Comparable<?>> Range<C> lessThan(C paramC)
  {
    return create(d0.d(), d0.f(paramC));
  }
  
  static <C extends Comparable<?>> h<Range<C>, d0<C>> lowerBoundFn()
  {
    return b.c;
  }
  
  public static <C extends Comparable<?>> Range<C> open(C paramC1, C paramC2)
  {
    return create(d0.b(paramC1), d0.f(paramC2));
  }
  
  public static <C extends Comparable<?>> Range<C> openClosed(C paramC1, C paramC2)
  {
    return create(d0.b(paramC1), d0.b(paramC2));
  }
  
  public static <C extends Comparable<?>> Range<C> range(C paramC1, BoundType paramBoundType1, C paramC2, BoundType paramBoundType2)
  {
    n.o(paramBoundType1);
    n.o(paramBoundType2);
    BoundType localBoundType = BoundType.OPEN;
    if (paramBoundType1 == localBoundType) {
      paramC1 = d0.b(paramC1);
    } else {
      paramC1 = d0.f(paramC1);
    }
    if (paramBoundType2 == localBoundType) {
      paramBoundType1 = d0.f(paramC2);
    } else {
      paramBoundType1 = d0.b(paramC2);
    }
    return create(paramC1, paramBoundType1);
  }
  
  static <C extends Comparable<?>> a2<Range<C>> rangeLexOrdering()
  {
    return c.c;
  }
  
  public static <C extends Comparable<?>> Range<C> singleton(C paramC)
  {
    return closed(paramC, paramC);
  }
  
  private static String toString(d0<?> paramd01, d0<?> paramd02)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    paramd01.i(localStringBuilder);
    localStringBuilder.append("..");
    paramd02.j(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static <C extends Comparable<?>> Range<C> upTo(C paramC, BoundType paramBoundType)
  {
    int i = a.a[paramBoundType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return atMost(paramC);
      }
      throw new AssertionError();
    }
    return lessThan(paramC);
  }
  
  static <C extends Comparable<?>> h<Range<C>, d0<C>> upperBoundFn()
  {
    return d.c;
  }
  
  @Deprecated
  public boolean apply(C paramC)
  {
    return contains(paramC);
  }
  
  public Range<C> canonical(i0<C> parami0)
  {
    n.o(parami0);
    d0 locald0 = this.lowerBound.g(parami0);
    parami0 = this.upperBound.g(parami0);
    if ((locald0 == this.lowerBound) && (parami0 == this.upperBound)) {
      parami0 = this;
    } else {
      parami0 = create(locald0, parami0);
    }
    return parami0;
  }
  
  public boolean contains(C paramC)
  {
    n.o(paramC);
    boolean bool;
    if ((this.lowerBound.m(paramC)) && (!this.upperBound.m(paramC))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsAll(Iterable<? extends C> paramIterable)
  {
    boolean bool1 = j1.j(paramIterable);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    if ((paramIterable instanceof SortedSet))
    {
      SortedSet localSortedSet = cast(paramIterable);
      Comparator localComparator = localSortedSet.comparator();
      if ((a2.g().equals(localComparator)) || (localComparator == null))
      {
        if ((!contains((Comparable)localSortedSet.first())) || (!contains((Comparable)localSortedSet.last()))) {
          bool2 = false;
        }
        return bool2;
      }
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!contains((Comparable)paramIterable.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean encloses(Range<C> paramRange)
  {
    boolean bool;
    if ((this.lowerBound.h(paramRange.lowerBound) <= 0) && (this.upperBound.h(paramRange.upperBound) >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof Range;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (Range)paramObject;
      bool3 = bool2;
      if (this.lowerBound.equals(((Range)paramObject).lowerBound))
      {
        bool3 = bool2;
        if (this.upperBound.equals(((Range)paramObject).upperBound)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public Range<C> gap(Range<C> paramRange)
  {
    int i;
    if (this.lowerBound.h(paramRange.lowerBound) < 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (i != 0) {
      localObject = this;
    } else {
      localObject = paramRange;
    }
    if (i == 0) {
      paramRange = this;
    }
    return create(((Range)localObject).upperBound, paramRange.lowerBound);
  }
  
  public boolean hasLowerBound()
  {
    boolean bool;
    if (this.lowerBound != d0.d()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean hasUpperBound()
  {
    boolean bool;
    if (this.upperBound != d0.a()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.lowerBound.hashCode() * 31 + this.upperBound.hashCode();
  }
  
  public Range<C> intersection(Range<C> paramRange)
  {
    int i = this.lowerBound.h(paramRange.lowerBound);
    int j = this.upperBound.h(paramRange.upperBound);
    if ((i >= 0) && (j <= 0)) {
      return this;
    }
    if ((i <= 0) && (j >= 0)) {
      return paramRange;
    }
    d0 locald0;
    if (i >= 0) {
      locald0 = this.lowerBound;
    } else {
      locald0 = paramRange.lowerBound;
    }
    if (j <= 0) {
      paramRange = this.upperBound;
    } else {
      paramRange = paramRange.upperBound;
    }
    return create(locald0, paramRange);
  }
  
  public boolean isConnected(Range<C> paramRange)
  {
    boolean bool;
    if ((this.lowerBound.h(paramRange.upperBound) <= 0) && (paramRange.lowerBound.h(this.upperBound) <= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEmpty()
  {
    return this.lowerBound.equals(this.upperBound);
  }
  
  public BoundType lowerBoundType()
  {
    return this.lowerBound.o();
  }
  
  public C lowerEndpoint()
  {
    return this.lowerBound.k();
  }
  
  Object readResolve()
  {
    if (equals(ALL)) {
      return all();
    }
    return this;
  }
  
  public Range<C> span(Range<C> paramRange)
  {
    int i = this.lowerBound.h(paramRange.lowerBound);
    int j = this.upperBound.h(paramRange.upperBound);
    if ((i <= 0) && (j >= 0)) {
      return this;
    }
    if ((i >= 0) && (j <= 0)) {
      return paramRange;
    }
    d0 locald0;
    if (i <= 0) {
      locald0 = this.lowerBound;
    } else {
      locald0 = paramRange.lowerBound;
    }
    if (j >= 0) {
      paramRange = this.upperBound;
    } else {
      paramRange = paramRange.upperBound;
    }
    return create(locald0, paramRange);
  }
  
  public String toString()
  {
    return toString(this.lowerBound, this.upperBound);
  }
  
  public BoundType upperBoundType()
  {
    return this.upperBound.p();
  }
  
  public C upperEndpoint()
  {
    return this.upperBound.k();
  }
  
  static class b
    implements h<Range, d0>
  {
    static final b c = new b();
    
    public d0 a(Range paramRange)
    {
      return paramRange.lowerBound;
    }
  }
  
  private static class c
    extends a2<Range<?>>
    implements Serializable
  {
    static final a2<Range<?>> c = new c();
    
    public int k(Range<?> paramRange1, Range<?> paramRange2)
    {
      return c0.k().f(paramRange1.lowerBound, paramRange2.lowerBound).f(paramRange1.upperBound, paramRange2.upperBound).j();
    }
  }
  
  static class d
    implements h<Range, d0>
  {
    static final d c = new d();
    
    public d0 a(Range paramRange)
    {
      return paramRange.upperBound;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */