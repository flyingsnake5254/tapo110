package com.google.common.collect;

import com.google.common.base.n;
import java.util.Comparator;
import java.util.NoSuchElementException;

public abstract class ContiguousSet<C extends Comparable>
  extends ImmutableSortedSet<C>
{
  final i0<C> domain;
  
  ContiguousSet(i0<C> parami0)
  {
    super(a2.g());
    this.domain = parami0;
  }
  
  @Deprecated
  public static <E> ImmutableSortedSet.a<E> builder()
  {
    throw new UnsupportedOperationException();
  }
  
  public static ContiguousSet<Integer> closed(int paramInt1, int paramInt2)
  {
    return create(Range.closed(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)), i0.b());
  }
  
  public static ContiguousSet<Long> closed(long paramLong1, long paramLong2)
  {
    return create(Range.closed(Long.valueOf(paramLong1), Long.valueOf(paramLong2)), i0.d());
  }
  
  public static ContiguousSet<Integer> closedOpen(int paramInt1, int paramInt2)
  {
    return create(Range.closedOpen(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)), i0.b());
  }
  
  public static ContiguousSet<Long> closedOpen(long paramLong1, long paramLong2)
  {
    return create(Range.closedOpen(Long.valueOf(paramLong1), Long.valueOf(paramLong2)), i0.d());
  }
  
  public static <C extends Comparable> ContiguousSet<C> create(Range<C> paramRange, i0<C> parami0)
  {
    n.o(paramRange);
    n.o(parami0);
    try
    {
      Object localObject1;
      if (!paramRange.hasLowerBound()) {
        localObject1 = paramRange.intersection(Range.atLeast(parami0.g()));
      } else {
        localObject1 = paramRange;
      }
      Object localObject2 = localObject1;
      if (!paramRange.hasUpperBound()) {
        localObject2 = ((Range)localObject1).intersection(Range.atMost(parami0.f()));
      }
      int i;
      if ((!((Range)localObject2).isEmpty()) && (Range.compareOrThrow(paramRange.lowerBound.n(parami0), paramRange.upperBound.l(parami0)) <= 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        paramRange = new j0(parami0);
      } else {
        paramRange = new g2((Range)localObject2, parami0);
      }
      return paramRange;
    }
    catch (NoSuchElementException paramRange)
    {
      throw new IllegalArgumentException(paramRange);
    }
  }
  
  ImmutableSortedSet<C> createDescendingSet()
  {
    return new g0(this);
  }
  
  public ContiguousSet<C> headSet(C paramC)
  {
    return headSetImpl((Comparable)n.o(paramC), false);
  }
  
  public ContiguousSet<C> headSet(C paramC, boolean paramBoolean)
  {
    return headSetImpl((Comparable)n.o(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean);
  
  public abstract ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet);
  
  public abstract Range<C> range();
  
  public abstract Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2);
  
  public ContiguousSet<C> subSet(C paramC1, C paramC2)
  {
    n.o(paramC1);
    n.o(paramC2);
    boolean bool;
    if (comparator().compare(paramC1, paramC2) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    return subSetImpl(paramC1, true, paramC2, false);
  }
  
  public ContiguousSet<C> subSet(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
  {
    n.o(paramC1);
    n.o(paramC2);
    boolean bool;
    if (comparator().compare(paramC1, paramC2) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    return subSetImpl(paramC1, paramBoolean1, paramC2, paramBoolean2);
  }
  
  abstract ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2);
  
  public ContiguousSet<C> tailSet(C paramC)
  {
    return tailSetImpl((Comparable)n.o(paramC), true);
  }
  
  public ContiguousSet<C> tailSet(C paramC, boolean paramBoolean)
  {
    return tailSetImpl((Comparable)n.o(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean);
  
  public String toString()
  {
    return range().toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */