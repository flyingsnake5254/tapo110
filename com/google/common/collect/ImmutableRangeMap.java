package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableRangeMap<K extends Comparable<?>, V>
  implements e2<K, V>, Serializable
{
  private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
  private static final long serialVersionUID = 0L;
  private final transient ImmutableList<Range<K>> ranges;
  private final transient ImmutableList<V> values;
  
  ImmutableRangeMap(ImmutableList<Range<K>> paramImmutableList, ImmutableList<V> paramImmutableList1)
  {
    this.ranges = paramImmutableList;
    this.values = paramImmutableList1;
  }
  
  public static <K extends Comparable<?>, V> c<K, V> builder()
  {
    return new c();
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(e2<K, ? extends V> parame2)
  {
    if ((parame2 instanceof ImmutableRangeMap)) {
      return (ImmutableRangeMap)parame2;
    }
    Object localObject = parame2.asMapOfRanges();
    parame2 = new ImmutableList.a(((Map)localObject).size());
    ImmutableList.a locala = new ImmutableList.a(((Map)localObject).size());
    Iterator localIterator = ((Map)localObject).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      parame2.h(((Map.Entry)localObject).getKey());
      locala.h(((Map.Entry)localObject).getValue());
    }
    return new ImmutableRangeMap(parame2.j(), locala.j());
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of()
  {
    return EMPTY;
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> paramRange, V paramV)
  {
    return new ImmutableRangeMap(ImmutableList.of(paramRange), ImmutableList.of(paramV));
  }
  
  public ImmutableMap<Range<K>, V> asDescendingMapOfRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableMap.of();
    }
    return new ImmutableSortedMap(new n2(this.ranges.reverse(), Range.rangeLexOrdering().j()), this.values.reverse());
  }
  
  public ImmutableMap<Range<K>, V> asMapOfRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableMap.of();
    }
    return new ImmutableSortedMap(new n2(this.ranges, Range.rangeLexOrdering()), this.values);
  }
  
  @Deprecated
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof e2))
    {
      paramObject = (e2)paramObject;
      return asMapOfRanges().equals(((e2)paramObject).asMapOfRanges());
    }
    return false;
  }
  
  @NullableDecl
  public V get(K paramK)
  {
    int i = z2.a(this.ranges, Range.lowerBoundFn(), d0.f(paramK), z2.c.c, z2.b.c);
    Object localObject = null;
    if (i == -1) {
      return null;
    }
    if (((Range)this.ranges.get(i)).contains(paramK)) {
      localObject = this.values.get(i);
    }
    return (V)localObject;
  }
  
  @NullableDecl
  public Map.Entry<Range<K>, V> getEntry(K paramK)
  {
    int i = z2.a(this.ranges, Range.lowerBoundFn(), d0.f(paramK), z2.c.c, z2.b.c);
    Map.Entry localEntry = null;
    if (i == -1) {
      return null;
    }
    Range localRange = (Range)this.ranges.get(i);
    if (localRange.contains(paramK)) {
      localEntry = q1.i(localRange, this.values.get(i));
    }
    return localEntry;
  }
  
  public int hashCode()
  {
    return asMapOfRanges().hashCode();
  }
  
  @Deprecated
  public void put(Range<K> paramRange, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void putAll(e2<K, V> parame2)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void putCoalescing(Range<K> paramRange, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void remove(Range<K> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public Range<K> span()
  {
    if (!this.ranges.isEmpty())
    {
      Range localRange = (Range)this.ranges.get(0);
      Object localObject = this.ranges;
      localObject = (Range)((List)localObject).get(((AbstractCollection)localObject).size() - 1);
      return Range.create(localRange.lowerBound, ((Range)localObject).upperBound);
    }
    throw new NoSuchElementException();
  }
  
  public ImmutableRangeMap<K, V> subRangeMap(final Range<K> paramRange)
  {
    if (((Range)n.o(paramRange)).isEmpty()) {
      return of();
    }
    if ((!this.ranges.isEmpty()) && (!paramRange.encloses(span())))
    {
      ImmutableList localImmutableList = this.ranges;
      h localh = Range.upperBoundFn();
      d0 locald0 = paramRange.lowerBound;
      z2.c localc = z2.c.q;
      z2.b localb = z2.b.d;
      final int i = z2.a(localImmutableList, localh, locald0, localc, localb);
      int j = z2.a(this.ranges, Range.lowerBoundFn(), paramRange.upperBound, z2.c.c, localb);
      if (i >= j) {
        return of();
      }
      return new b(new a(j - i, i, paramRange), this.values.subList(i, j), paramRange, this);
    }
    return this;
  }
  
  public String toString()
  {
    return asMapOfRanges().toString();
  }
  
  Object writeReplace()
  {
    return new d(asMapOfRanges());
  }
  
  class a
    extends ImmutableList<Range<K>>
  {
    a(int paramInt1, int paramInt2, Range paramRange) {}
    
    public Range<K> a(int paramInt)
    {
      n.m(paramInt, this.c);
      if ((paramInt != 0) && (paramInt != this.c - 1)) {
        return (Range)ImmutableRangeMap.this.ranges.get(paramInt + i);
      }
      return ((Range)ImmutableRangeMap.this.ranges.get(paramInt + i)).intersection(paramRange);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.c;
    }
  }
  
  class b
    extends ImmutableRangeMap<K, V>
  {
    b(ImmutableList paramImmutableList1, ImmutableList paramImmutableList2, Range paramRange, ImmutableRangeMap paramImmutableRangeMap)
    {
      super(paramImmutableList2);
    }
    
    public ImmutableRangeMap<K, V> subRangeMap(Range<K> paramRange)
    {
      if (paramRange.isConnected(paramRange)) {
        return jdField_this.subRangeMap(paramRange.intersection(paramRange));
      }
      return ImmutableRangeMap.of();
    }
  }
  
  public static final class c<K extends Comparable<?>, V>
  {
    private final List<Map.Entry<Range<K>, V>> a = n1.h();
  }
  
  private static class d<K extends Comparable<?>, V>
    implements Serializable
  {
    private final ImmutableMap<Range<K>, V> c;
    
    d(ImmutableMap<Range<K>, V> paramImmutableMap)
    {
      this.c = paramImmutableMap;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableRangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */