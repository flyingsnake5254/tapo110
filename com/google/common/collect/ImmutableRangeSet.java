package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ImmutableRangeSet<C extends Comparable>
  extends k<C>
  implements Serializable
{
  private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
  private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet(ImmutableList.of());
  @LazyInit
  private transient ImmutableRangeSet<C> complement;
  private final transient ImmutableList<Range<C>> ranges;
  
  ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList)
  {
    this.ranges = paramImmutableList;
  }
  
  private ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList, ImmutableRangeSet<C> paramImmutableRangeSet)
  {
    this.ranges = paramImmutableList;
    this.complement = paramImmutableRangeSet;
  }
  
  static <C extends Comparable> ImmutableRangeSet<C> all()
  {
    return ALL;
  }
  
  public static <C extends Comparable<?>> d<C> builder()
  {
    return new d();
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> copyOf(f2<C> paramf2)
  {
    n.o(paramf2);
    if (paramf2.isEmpty()) {
      return of();
    }
    if (paramf2.encloses(Range.all())) {
      return all();
    }
    if ((paramf2 instanceof ImmutableRangeSet))
    {
      ImmutableRangeSet localImmutableRangeSet = (ImmutableRangeSet)paramf2;
      if (!localImmutableRangeSet.isPartialView()) {
        return localImmutableRangeSet;
      }
    }
    return new ImmutableRangeSet(ImmutableList.copyOf(paramf2.asRanges()));
  }
  
  public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> paramIterable)
  {
    return new d().b(paramIterable).c();
  }
  
  private ImmutableList<Range<C>> intersectRanges(final Range<C> paramRange)
  {
    if ((!this.ranges.isEmpty()) && (!paramRange.isEmpty()))
    {
      if (paramRange.encloses(span())) {
        return this.ranges;
      }
      final int i;
      if (paramRange.hasLowerBound()) {
        i = z2.a(this.ranges, Range.upperBoundFn(), paramRange.lowerBound, z2.c.q, z2.b.d);
      } else {
        i = 0;
      }
      final int j;
      if (paramRange.hasUpperBound()) {
        j = z2.a(this.ranges, Range.lowerBoundFn(), paramRange.upperBound, z2.c.f, z2.b.d);
      } else {
        j = this.ranges.size();
      }
      j -= i;
      if (j == 0) {
        return ImmutableList.of();
      }
      return new a(j, i, paramRange);
    }
    return ImmutableList.of();
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> of()
  {
    return EMPTY;
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> paramRange)
  {
    n.o(paramRange);
    if (paramRange.isEmpty()) {
      return of();
    }
    if (paramRange.equals(Range.all())) {
      return all();
    }
    return new ImmutableRangeSet(ImmutableList.of(paramRange));
  }
  
  public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> paramIterable)
  {
    return copyOf(TreeRangeSet.create(paramIterable));
  }
  
  @Deprecated
  public void add(Range<C> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void addAll(f2<C> paramf2)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void addAll(Iterable<Range<C>> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSet<Range<C>> asDescendingSetOfRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableSet.of();
    }
    return new n2(this.ranges.reverse(), Range.rangeLexOrdering().j());
  }
  
  public ImmutableSet<Range<C>> asRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableSet.of();
    }
    return new n2(this.ranges, Range.rangeLexOrdering());
  }
  
  public ImmutableSortedSet<C> asSet(i0<C> parami0)
  {
    n.o(parami0);
    if (isEmpty()) {
      return ImmutableSortedSet.of();
    }
    Range localRange = span().canonical(parami0);
    if (localRange.hasLowerBound())
    {
      if (!localRange.hasUpperBound()) {
        try
        {
          parami0.f();
        }
        catch (NoSuchElementException parami0)
        {
          throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
        }
      }
      return new b(parami0);
    }
    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
  }
  
  public ImmutableRangeSet<C> complement()
  {
    ImmutableRangeSet localImmutableRangeSet = this.complement;
    if (localImmutableRangeSet != null) {
      return localImmutableRangeSet;
    }
    if (this.ranges.isEmpty())
    {
      localImmutableRangeSet = all();
      this.complement = localImmutableRangeSet;
      return localImmutableRangeSet;
    }
    if ((this.ranges.size() == 1) && (((Range)this.ranges.get(0)).equals(Range.all())))
    {
      localImmutableRangeSet = of();
      this.complement = localImmutableRangeSet;
      return localImmutableRangeSet;
    }
    localImmutableRangeSet = new ImmutableRangeSet(new e(), this);
    this.complement = localImmutableRangeSet;
    return localImmutableRangeSet;
  }
  
  public ImmutableRangeSet<C> difference(f2<C> paramf2)
  {
    TreeRangeSet localTreeRangeSet = TreeRangeSet.create(this);
    localTreeRangeSet.removeAll(paramf2);
    return copyOf(localTreeRangeSet);
  }
  
  public boolean encloses(Range<C> paramRange)
  {
    int i = z2.b(this.ranges, Range.lowerBoundFn(), paramRange.lowerBound, a2.g(), z2.c.c, z2.b.c);
    boolean bool;
    if ((i != -1) && (((Range)this.ranges.get(i)).encloses(paramRange))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ImmutableRangeSet<C> intersection(f2<C> paramf2)
  {
    TreeRangeSet localTreeRangeSet = TreeRangeSet.create(this);
    localTreeRangeSet.removeAll(paramf2.complement());
    return copyOf(localTreeRangeSet);
  }
  
  public boolean intersects(Range<C> paramRange)
  {
    int i = z2.b(this.ranges, Range.lowerBoundFn(), paramRange.lowerBound, a2.g(), z2.c.c, z2.b.d);
    int j = this.ranges.size();
    boolean bool = true;
    if ((i < j) && (((Range)this.ranges.get(i)).isConnected(paramRange)) && (!((Range)this.ranges.get(i)).intersection(paramRange).isEmpty())) {
      return true;
    }
    if (i > 0)
    {
      ImmutableList localImmutableList = this.ranges;
      i--;
      if ((((Range)localImmutableList.get(i)).isConnected(paramRange)) && (!((Range)this.ranges.get(i)).intersection(paramRange).isEmpty())) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEmpty()
  {
    return this.ranges.isEmpty();
  }
  
  boolean isPartialView()
  {
    return this.ranges.isPartialView();
  }
  
  public Range<C> rangeContaining(C paramC)
  {
    int i = z2.b(this.ranges, Range.lowerBoundFn(), d0.f(paramC), a2.g(), z2.c.c, z2.b.c);
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (i != -1)
    {
      Range localRange = (Range)this.ranges.get(i);
      localObject2 = localObject1;
      if (localRange.contains(paramC)) {
        localObject2 = localRange;
      }
    }
    return (Range<C>)localObject2;
  }
  
  @Deprecated
  public void remove(Range<C> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void removeAll(f2<C> paramf2)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void removeAll(Iterable<Range<C>> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public Range<C> span()
  {
    if (!this.ranges.isEmpty())
    {
      d0 locald0 = ((Range)this.ranges.get(0)).lowerBound;
      ImmutableList localImmutableList = this.ranges;
      return Range.create(locald0, ((Range)localImmutableList.get(localImmutableList.size() - 1)).upperBound);
    }
    throw new NoSuchElementException();
  }
  
  public ImmutableRangeSet<C> subRangeSet(Range<C> paramRange)
  {
    if (!isEmpty())
    {
      Range localRange = span();
      if (paramRange.encloses(localRange)) {
        return this;
      }
      if (paramRange.isConnected(localRange)) {
        return new ImmutableRangeSet(intersectRanges(paramRange));
      }
    }
    return of();
  }
  
  public ImmutableRangeSet<C> union(f2<C> paramf2)
  {
    return unionOf(j1.c(asRanges(), paramf2.asRanges()));
  }
  
  Object writeReplace()
  {
    return new f(this.ranges);
  }
  
  class a
    extends ImmutableList<Range<C>>
  {
    a(int paramInt1, int paramInt2, Range paramRange) {}
    
    public Range<C> a(int paramInt)
    {
      n.m(paramInt, j);
      if ((paramInt != 0) && (paramInt != j - 1)) {
        return (Range)ImmutableRangeSet.this.ranges.get(paramInt + i);
      }
      return ((Range)ImmutableRangeSet.this.ranges.get(paramInt + i)).intersection(paramRange);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return j;
    }
  }
  
  private final class b
    extends ImmutableSortedSet<C>
  {
    private final i0<C> c;
    @MonotonicNonNullDecl
    private transient Integer d;
    
    b()
    {
      super();
      i0 locali0;
      this.c = locali0;
    }
    
    ImmutableSortedSet<C> b(C paramC, boolean paramBoolean)
    {
      return d(Range.upTo(paramC, BoundType.forBoolean(paramBoolean)));
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      if (paramObject == null) {
        return false;
      }
      try
      {
        paramObject = (Comparable)paramObject;
        boolean bool = ImmutableRangeSet.this.contains((Comparable)paramObject);
        return bool;
      }
      catch (ClassCastException paramObject) {}
      return false;
    }
    
    ImmutableSortedSet<C> createDescendingSet()
    {
      return new g0(this);
    }
    
    ImmutableSortedSet<C> d(Range<C> paramRange)
    {
      return ImmutableRangeSet.this.subRangeSet(paramRange).asSet(this.c);
    }
    
    public j3<C> descendingIterator()
    {
      return new b();
    }
    
    ImmutableSortedSet<C> f(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
    {
      if ((!paramBoolean1) && (!paramBoolean2) && (Range.compareOrThrow(paramC1, paramC2) == 0)) {
        return ImmutableSortedSet.of();
      }
      return d(Range.range(paramC1, BoundType.forBoolean(paramBoolean1), paramC2, BoundType.forBoolean(paramBoolean2)));
    }
    
    ImmutableSortedSet<C> g(C paramC, boolean paramBoolean)
    {
      return d(Range.downTo(paramC, BoundType.forBoolean(paramBoolean)));
    }
    
    int indexOf(Object paramObject)
    {
      if (contains(paramObject))
      {
        paramObject = (Comparable)paramObject;
        long l = 0L;
        j3 localj3 = ImmutableRangeSet.this.ranges.iterator();
        while (localj3.hasNext())
        {
          Range localRange = (Range)localj3.next();
          if (localRange.contains((Comparable)paramObject)) {
            return d.i(l + ContiguousSet.create(localRange, this.c).indexOf(paramObject));
          }
          l += ContiguousSet.create(localRange, this.c).size();
        }
        throw new AssertionError("impossible");
      }
      return -1;
    }
    
    boolean isPartialView()
    {
      return ImmutableRangeSet.this.ranges.isPartialView();
    }
    
    public j3<C> iterator()
    {
      return new a();
    }
    
    public int size()
    {
      Integer localInteger = this.d;
      Object localObject = localInteger;
      if (localInteger == null)
      {
        long l1 = 0L;
        localObject = ImmutableRangeSet.this.ranges.iterator();
        long l2;
        do
        {
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          l2 = l1 + ContiguousSet.create((Range)((Iterator)localObject).next(), this.c).size();
          l1 = l2;
        } while (l2 < 2147483647L);
        localObject = Integer.valueOf(d.i(l2));
        this.d = ((Integer)localObject);
      }
      return ((Integer)localObject).intValue();
    }
    
    public String toString()
    {
      return ImmutableRangeSet.this.ranges.toString();
    }
    
    Object writeReplace()
    {
      return new ImmutableRangeSet.c(ImmutableRangeSet.this.ranges, this.c);
    }
    
    class a
      extends c<C>
    {
      final Iterator<Range<C>> f = ImmutableRangeSet.this.ranges.iterator();
      Iterator<C> q = k1.h();
      
      a() {}
      
      protected C d()
      {
        while (!this.q.hasNext()) {
          if (this.f.hasNext()) {
            this.q = ContiguousSet.create((Range)this.f.next(), ImmutableRangeSet.b.a(ImmutableRangeSet.b.this)).iterator();
          } else {
            return (Comparable)b();
          }
        }
        return (Comparable)this.q.next();
      }
    }
    
    class b
      extends c<C>
    {
      final Iterator<Range<C>> f = ImmutableRangeSet.this.ranges.reverse().iterator();
      Iterator<C> q = k1.h();
      
      b() {}
      
      protected C d()
      {
        while (!this.q.hasNext()) {
          if (this.f.hasNext()) {
            this.q = ContiguousSet.create((Range)this.f.next(), ImmutableRangeSet.b.a(ImmutableRangeSet.b.this)).descendingIterator();
          } else {
            return (Comparable)b();
          }
        }
        return (Comparable)this.q.next();
      }
    }
  }
  
  private static class c<C extends Comparable>
    implements Serializable
  {
    private final ImmutableList<Range<C>> c;
    private final i0<C> d;
    
    c(ImmutableList<Range<C>> paramImmutableList, i0<C> parami0)
    {
      this.c = paramImmutableList;
      this.d = parami0;
    }
  }
  
  public static class d<C extends Comparable<?>>
  {
    private final List<Range<C>> a = n1.h();
    
    @CanIgnoreReturnValue
    public d<C> a(Range<C> paramRange)
    {
      n.j(paramRange.isEmpty() ^ true, "range must not be empty, but was %s", paramRange);
      this.a.add(paramRange);
      return this;
    }
    
    @CanIgnoreReturnValue
    public d<C> b(Iterable<Range<C>> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((Range)paramIterable.next());
      }
      return this;
    }
    
    public ImmutableRangeSet<C> c()
    {
      ImmutableList.a locala = new ImmutableList.a(this.a.size());
      Collections.sort(this.a, Range.rangeLexOrdering());
      b2 localb2 = k1.q(this.a.iterator());
      while (localb2.hasNext())
      {
        for (localObject = (Range)localb2.next(); localb2.hasNext(); localObject = ((Range)localObject).span((Range)localb2.next()))
        {
          Range localRange = (Range)localb2.peek();
          if (!((Range)localObject).isConnected(localRange)) {
            break;
          }
          n.k(((Range)localObject).intersection(localRange).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", localObject, localRange);
        }
        locala.h(localObject);
      }
      Object localObject = locala.j();
      if (((AbstractCollection)localObject).isEmpty()) {
        return ImmutableRangeSet.of();
      }
      if ((((AbstractCollection)localObject).size() == 1) && (((Range)j1.i((Iterable)localObject)).equals(Range.all()))) {
        return ImmutableRangeSet.all();
      }
      return new ImmutableRangeSet((ImmutableList)localObject);
    }
  }
  
  private final class e
    extends ImmutableList<Range<C>>
  {
    private final boolean c;
    private final boolean d;
    private final int f;
    
    e()
    {
      boolean bool1 = ((Range)ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
      this.c = bool1;
      boolean bool2 = ((Range)j1.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
      this.d = bool2;
      int i = ImmutableRangeSet.this.ranges.size() - 1;
      int j = i;
      if (bool1) {
        j = i + 1;
      }
      i = j;
      if (bool2) {
        i = j + 1;
      }
      this.f = i;
    }
    
    public Range<C> a(int paramInt)
    {
      n.m(paramInt, this.f);
      d0 locald01;
      if (this.c)
      {
        if (paramInt == 0) {
          locald01 = d0.d();
        } else {
          locald01 = ((Range)ImmutableRangeSet.this.ranges.get(paramInt - 1)).upperBound;
        }
      }
      else {
        locald01 = ((Range)ImmutableRangeSet.this.ranges.get(paramInt)).upperBound;
      }
      d0 locald02;
      if ((this.d) && (paramInt == this.f - 1)) {
        locald02 = d0.a();
      } else {
        locald02 = ((Range)ImmutableRangeSet.this.ranges.get(paramInt + (this.c ^ true))).lowerBound;
      }
      return Range.create(locald01, locald02);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.f;
    }
  }
  
  private static final class f<C extends Comparable>
    implements Serializable
  {
    private final ImmutableList<Range<C>> c;
    
    f(ImmutableList<Range<C>> paramImmutableList)
    {
      this.c = paramImmutableList;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */