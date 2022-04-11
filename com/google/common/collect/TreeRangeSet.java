package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class TreeRangeSet<C extends Comparable<?>>
  extends k<C>
  implements Serializable
{
  @MonotonicNonNullDecl
  private transient Set<Range<C>> asDescendingSetOfRanges;
  @MonotonicNonNullDecl
  private transient Set<Range<C>> asRanges;
  @MonotonicNonNullDecl
  private transient f2<C> complement;
  final NavigableMap<d0<C>, Range<C>> rangesByLowerBound;
  
  private TreeRangeSet(NavigableMap<d0<C>, Range<C>> paramNavigableMap)
  {
    this.rangesByLowerBound = paramNavigableMap;
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create()
  {
    return new TreeRangeSet(new TreeMap());
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create(f2<C> paramf2)
  {
    TreeRangeSet localTreeRangeSet = create();
    localTreeRangeSet.addAll(paramf2);
    return localTreeRangeSet;
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> paramIterable)
  {
    TreeRangeSet localTreeRangeSet = create();
    localTreeRangeSet.addAll(paramIterable);
    return localTreeRangeSet;
  }
  
  @NullableDecl
  private Range<C> rangeEnclosing(Range<C> paramRange)
  {
    n.o(paramRange);
    Map.Entry localEntry = this.rangesByLowerBound.floorEntry(paramRange.lowerBound);
    if ((localEntry != null) && (((Range)localEntry.getValue()).encloses(paramRange))) {
      paramRange = (Range)localEntry.getValue();
    } else {
      paramRange = null;
    }
    return paramRange;
  }
  
  private void replaceRangeWithSameLowerBound(Range<C> paramRange)
  {
    if (paramRange.isEmpty()) {
      this.rangesByLowerBound.remove(paramRange.lowerBound);
    } else {
      this.rangesByLowerBound.put(paramRange.lowerBound, paramRange);
    }
  }
  
  public void add(Range<C> paramRange)
  {
    n.o(paramRange);
    if (paramRange.isEmpty()) {
      return;
    }
    Object localObject1 = paramRange.lowerBound;
    Object localObject2 = paramRange.upperBound;
    Object localObject3 = this.rangesByLowerBound.lowerEntry(localObject1);
    Object localObject4 = localObject1;
    paramRange = (Range<C>)localObject2;
    if (localObject3 != null)
    {
      localObject3 = (Range)((Map.Entry)localObject3).getValue();
      localObject4 = localObject1;
      paramRange = (Range<C>)localObject2;
      if (((Range)localObject3).upperBound.h((d0)localObject1) >= 0)
      {
        paramRange = (Range<C>)localObject2;
        if (((Range)localObject3).upperBound.h((d0)localObject2) >= 0) {
          paramRange = ((Range)localObject3).upperBound;
        }
        localObject4 = ((Range)localObject3).lowerBound;
      }
    }
    localObject1 = this.rangesByLowerBound.floorEntry(paramRange);
    localObject2 = paramRange;
    if (localObject1 != null)
    {
      localObject1 = (Range)((Map.Entry)localObject1).getValue();
      localObject2 = paramRange;
      if (((Range)localObject1).upperBound.h(paramRange) >= 0) {
        localObject2 = ((Range)localObject1).upperBound;
      }
    }
    this.rangesByLowerBound.subMap(localObject4, localObject2).clear();
    replaceRangeWithSameLowerBound(Range.create((d0)localObject4, (d0)localObject2));
  }
  
  public Set<Range<C>> asDescendingSetOfRanges()
  {
    Set localSet = this.asDescendingSetOfRanges;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new b(this.rangesByLowerBound.descendingMap().values());
      this.asDescendingSetOfRanges = ((Set)localObject);
    }
    return (Set<Range<C>>)localObject;
  }
  
  public Set<Range<C>> asRanges()
  {
    Set localSet = this.asRanges;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new b(this.rangesByLowerBound.values());
      this.asRanges = ((Set)localObject);
    }
    return (Set<Range<C>>)localObject;
  }
  
  public f2<C> complement()
  {
    f2 localf2 = this.complement;
    Object localObject = localf2;
    if (localf2 == null)
    {
      localObject = new c();
      this.complement = ((f2)localObject);
    }
    return (f2<C>)localObject;
  }
  
  public boolean encloses(Range<C> paramRange)
  {
    n.o(paramRange);
    Map.Entry localEntry = this.rangesByLowerBound.floorEntry(paramRange.lowerBound);
    boolean bool;
    if ((localEntry != null) && (((Range)localEntry.getValue()).encloses(paramRange))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean intersects(Range<C> paramRange)
  {
    n.o(paramRange);
    Map.Entry localEntry = this.rangesByLowerBound.ceilingEntry(paramRange.lowerBound);
    boolean bool = true;
    if ((localEntry != null) && (((Range)localEntry.getValue()).isConnected(paramRange)) && (!((Range)localEntry.getValue()).intersection(paramRange).isEmpty())) {
      return true;
    }
    localEntry = this.rangesByLowerBound.lowerEntry(paramRange.lowerBound);
    if ((localEntry == null) || (!((Range)localEntry.getValue()).isConnected(paramRange)) || (((Range)localEntry.getValue()).intersection(paramRange).isEmpty())) {
      bool = false;
    }
    return bool;
  }
  
  @NullableDecl
  public Range<C> rangeContaining(C paramC)
  {
    n.o(paramC);
    Map.Entry localEntry = this.rangesByLowerBound.floorEntry(d0.f(paramC));
    if ((localEntry != null) && (((Range)localEntry.getValue()).contains(paramC))) {
      return (Range)localEntry.getValue();
    }
    return null;
  }
  
  public void remove(Range<C> paramRange)
  {
    n.o(paramRange);
    if (paramRange.isEmpty()) {
      return;
    }
    Object localObject = this.rangesByLowerBound.lowerEntry(paramRange.lowerBound);
    if (localObject != null)
    {
      localObject = (Range)((Map.Entry)localObject).getValue();
      if (((Range)localObject).upperBound.h(paramRange.lowerBound) >= 0)
      {
        if ((paramRange.hasUpperBound()) && (((Range)localObject).upperBound.h(paramRange.upperBound) >= 0)) {
          replaceRangeWithSameLowerBound(Range.create(paramRange.upperBound, ((Range)localObject).upperBound));
        }
        replaceRangeWithSameLowerBound(Range.create(((Range)localObject).lowerBound, paramRange.lowerBound));
      }
    }
    localObject = this.rangesByLowerBound.floorEntry(paramRange.upperBound);
    if (localObject != null)
    {
      localObject = (Range)((Map.Entry)localObject).getValue();
      if ((paramRange.hasUpperBound()) && (((Range)localObject).upperBound.h(paramRange.upperBound) >= 0)) {
        replaceRangeWithSameLowerBound(Range.create(paramRange.upperBound, ((Range)localObject).upperBound));
      }
    }
    this.rangesByLowerBound.subMap(paramRange.lowerBound, paramRange.upperBound).clear();
  }
  
  public Range<C> span()
  {
    Map.Entry localEntry1 = this.rangesByLowerBound.firstEntry();
    Map.Entry localEntry2 = this.rangesByLowerBound.lastEntry();
    if (localEntry1 != null) {
      return Range.create(((Range)localEntry1.getValue()).lowerBound, ((Range)localEntry2.getValue()).upperBound);
    }
    throw new NoSuchElementException();
  }
  
  public f2<C> subRangeSet(Range<C> paramRange)
  {
    if (paramRange.equals(Range.all())) {
      paramRange = this;
    } else {
      paramRange = new f(paramRange);
    }
    return paramRange;
  }
  
  final class b
    extends n0<Range<C>>
    implements Set<Range<C>>
  {
    final Collection<Range<C>> c;
    
    b()
    {
      Collection localCollection;
      this.c = localCollection;
    }
    
    protected Collection<Range<C>> delegate()
    {
      return this.c;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      return u2.a(this, paramObject);
    }
    
    public int hashCode()
    {
      return u2.b(this);
    }
  }
  
  private final class c
    extends TreeRangeSet<C>
  {
    c()
    {
      super(null);
    }
    
    public void add(Range<C> paramRange)
    {
      TreeRangeSet.this.remove(paramRange);
    }
    
    public f2<C> complement()
    {
      return TreeRangeSet.this;
    }
    
    public boolean contains(C paramC)
    {
      return TreeRangeSet.this.contains(paramC) ^ true;
    }
    
    public void remove(Range<C> paramRange)
    {
      TreeRangeSet.this.add(paramRange);
    }
  }
  
  private static final class d<C extends Comparable<?>>
    extends j<d0<C>, Range<C>>
  {
    private final NavigableMap<d0<C>, Range<C>> c;
    private final NavigableMap<d0<C>, Range<C>> d;
    private final Range<d0<C>> f;
    
    d(NavigableMap<d0<C>, Range<C>> paramNavigableMap)
    {
      this(paramNavigableMap, Range.all());
    }
    
    private d(NavigableMap<d0<C>, Range<C>> paramNavigableMap, Range<d0<C>> paramRange)
    {
      this.c = paramNavigableMap;
      this.d = new TreeRangeSet.e(paramNavigableMap);
      this.f = paramRange;
    }
    
    private NavigableMap<d0<C>, Range<C>> g(Range<d0<C>> paramRange)
    {
      if (!this.f.isConnected(paramRange)) {
        return ImmutableSortedMap.of();
      }
      paramRange = paramRange.intersection(this.f);
      return new d(this.c, paramRange);
    }
    
    Iterator<Map.Entry<d0<C>, Range<C>>> a()
    {
      final Object localObject2;
      if (this.f.hasLowerBound())
      {
        localObject1 = this.d;
        localObject2 = this.f.lowerEndpoint();
        boolean bool;
        if (this.f.lowerBoundType() == BoundType.CLOSED) {
          bool = true;
        } else {
          bool = false;
        }
        localObject2 = ((NavigableMap)localObject1).tailMap(localObject2, bool).values();
      }
      else
      {
        localObject2 = this.d.values();
      }
      final Object localObject1 = k1.q(((Collection)localObject2).iterator());
      if ((this.f.contains(d0.d())) && ((!((Iterator)localObject1).hasNext()) || (((Range)((b2)localObject1).peek()).lowerBound != d0.d())))
      {
        localObject2 = d0.d();
      }
      else
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label160;
        }
        localObject2 = ((Range)((b2)localObject1).next()).upperBound;
      }
      return new a((d0)localObject2, (b2)localObject1);
      label160:
      return k1.h();
    }
    
    Iterator<Map.Entry<d0<C>, Range<C>>> b()
    {
      d0 locald0;
      if (this.f.hasUpperBound()) {
        locald0 = (d0)this.f.upperEndpoint();
      } else {
        locald0 = d0.a();
      }
      boolean bool;
      if ((this.f.hasUpperBound()) && (this.f.upperBoundType() == BoundType.CLOSED)) {
        bool = true;
      } else {
        bool = false;
      }
      final b2 localb2 = k1.q(this.d.headMap(locald0, bool).descendingMap().values().iterator());
      if (localb2.hasNext())
      {
        if (((Range)localb2.peek()).upperBound == d0.a()) {
          locald0 = ((Range)localb2.next()).lowerBound;
        } else {
          locald0 = (d0)this.c.higherKey(((Range)localb2.peek()).upperBound);
        }
      }
      else
      {
        if ((!this.f.contains(d0.d())) || (this.c.containsKey(d0.d()))) {
          break label226;
        }
        locald0 = (d0)this.c.higherKey(d0.d());
      }
      return new b((d0)com.google.common.base.j.a(locald0, d0.a()), localb2);
      label226:
      return k1.h();
    }
    
    public Comparator<? super d0<C>> comparator()
    {
      return a2.g();
    }
    
    public boolean containsKey(Object paramObject)
    {
      boolean bool;
      if (d(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @NullableDecl
    public Range<C> d(Object paramObject)
    {
      if ((paramObject instanceof d0)) {}
      try
      {
        paramObject = (d0)paramObject;
        Map.Entry localEntry = h((d0)paramObject, true).firstEntry();
        if ((localEntry != null) && (((d0)localEntry.getKey()).equals(paramObject)))
        {
          paramObject = (Range)localEntry.getValue();
          return (Range<C>)paramObject;
        }
      }
      catch (ClassCastException paramObject)
      {
        for (;;) {}
      }
      return null;
    }
    
    public NavigableMap<d0<C>, Range<C>> e(d0<C> paramd0, boolean paramBoolean)
    {
      return g(Range.upTo(paramd0, BoundType.forBoolean(paramBoolean)));
    }
    
    public NavigableMap<d0<C>, Range<C>> f(d0<C> paramd01, boolean paramBoolean1, d0<C> paramd02, boolean paramBoolean2)
    {
      return g(Range.range(paramd01, BoundType.forBoolean(paramBoolean1), paramd02, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableMap<d0<C>, Range<C>> h(d0<C> paramd0, boolean paramBoolean)
    {
      return g(Range.downTo(paramd0, BoundType.forBoolean(paramBoolean)));
    }
    
    public int size()
    {
      return k1.v(a());
    }
    
    class a
      extends c<Map.Entry<d0<C>, Range<C>>>
    {
      d0<C> f;
      
      a(d0 paramd0, b2 paramb2)
      {
        this.f = paramd0;
      }
      
      protected Map.Entry<d0<C>, Range<C>> d()
      {
        if ((!TreeRangeSet.d.c(TreeRangeSet.d.this).upperBound.m(this.f)) && (this.f != d0.a()))
        {
          Range localRange2;
          if (localObject1.hasNext())
          {
            Range localRange1 = (Range)localObject1.next();
            localRange2 = Range.create(this.f, localRange1.lowerBound);
            this.f = localRange1.upperBound;
          }
          else
          {
            localRange2 = Range.create(this.f, d0.a());
            this.f = d0.a();
          }
          return q1.i(localRange2.lowerBound, localRange2);
        }
        return (Map.Entry)b();
      }
    }
    
    class b
      extends c<Map.Entry<d0<C>, Range<C>>>
    {
      d0<C> f;
      
      b(d0 paramd0, b2 paramb2)
      {
        this.f = paramd0;
      }
      
      protected Map.Entry<d0<C>, Range<C>> d()
      {
        if (this.f == d0.d()) {
          return (Map.Entry)b();
        }
        Range localRange1;
        if (localb2.hasNext())
        {
          localRange1 = (Range)localb2.next();
          Range localRange2 = Range.create(localRange1.upperBound, this.f);
          this.f = localRange1.lowerBound;
          if (TreeRangeSet.d.c(TreeRangeSet.d.this).lowerBound.m(localRange2.lowerBound)) {
            return q1.i(localRange2.lowerBound, localRange2);
          }
        }
        else if (TreeRangeSet.d.c(TreeRangeSet.d.this).lowerBound.m(d0.d()))
        {
          localRange1 = Range.create(d0.d(), this.f);
          this.f = d0.d();
          return q1.i(d0.d(), localRange1);
        }
        return (Map.Entry)b();
      }
    }
  }
  
  static final class e<C extends Comparable<?>>
    extends j<d0<C>, Range<C>>
  {
    private final NavigableMap<d0<C>, Range<C>> c;
    private final Range<d0<C>> d;
    
    e(NavigableMap<d0<C>, Range<C>> paramNavigableMap)
    {
      this.c = paramNavigableMap;
      this.d = Range.all();
    }
    
    private e(NavigableMap<d0<C>, Range<C>> paramNavigableMap, Range<d0<C>> paramRange)
    {
      this.c = paramNavigableMap;
      this.d = paramRange;
    }
    
    private NavigableMap<d0<C>, Range<C>> g(Range<d0<C>> paramRange)
    {
      if (paramRange.isConnected(this.d)) {
        return new e(this.c, paramRange.intersection(this.d));
      }
      return ImmutableSortedMap.of();
    }
    
    Iterator<Map.Entry<d0<C>, Range<C>>> a()
    {
      final Object localObject;
      if (!this.d.hasLowerBound())
      {
        localObject = this.c.values().iterator();
      }
      else
      {
        localObject = this.c.lowerEntry(this.d.lowerEndpoint());
        if (localObject == null) {
          localObject = this.c.values().iterator();
        } else if (this.d.lowerBound.m(((Range)((Map.Entry)localObject).getValue()).upperBound)) {
          localObject = this.c.tailMap(((Map.Entry)localObject).getKey(), true).values().iterator();
        } else {
          localObject = this.c.tailMap(this.d.lowerEndpoint(), true).values().iterator();
        }
      }
      return new a((Iterator)localObject);
    }
    
    Iterator<Map.Entry<d0<C>, Range<C>>> b()
    {
      if (this.d.hasUpperBound()) {
        localObject = this.c.headMap(this.d.upperEndpoint(), false).descendingMap().values();
      } else {
        localObject = this.c.descendingMap().values();
      }
      final Object localObject = k1.q(((Collection)localObject).iterator());
      if ((((Iterator)localObject).hasNext()) && (this.d.upperBound.m(((Range)((b2)localObject).peek()).upperBound))) {
        ((b2)localObject).next();
      }
      return new b((b2)localObject);
    }
    
    public Comparator<? super d0<C>> comparator()
    {
      return a2.g();
    }
    
    public boolean containsKey(@NullableDecl Object paramObject)
    {
      boolean bool;
      if (d(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Range<C> d(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof d0)) {}
      try
      {
        paramObject = (d0)paramObject;
        if (!this.d.contains((Comparable)paramObject)) {
          return null;
        }
        Map.Entry localEntry = this.c.lowerEntry(paramObject);
        if ((localEntry != null) && (((Range)localEntry.getValue()).upperBound.equals(paramObject)))
        {
          paramObject = (Range)localEntry.getValue();
          return (Range<C>)paramObject;
        }
      }
      catch (ClassCastException paramObject)
      {
        for (;;) {}
      }
      return null;
    }
    
    public NavigableMap<d0<C>, Range<C>> e(d0<C> paramd0, boolean paramBoolean)
    {
      return g(Range.upTo(paramd0, BoundType.forBoolean(paramBoolean)));
    }
    
    public NavigableMap<d0<C>, Range<C>> f(d0<C> paramd01, boolean paramBoolean1, d0<C> paramd02, boolean paramBoolean2)
    {
      return g(Range.range(paramd01, BoundType.forBoolean(paramBoolean1), paramd02, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableMap<d0<C>, Range<C>> h(d0<C> paramd0, boolean paramBoolean)
    {
      return g(Range.downTo(paramd0, BoundType.forBoolean(paramBoolean)));
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (this.d.equals(Range.all())) {
        bool = this.c.isEmpty();
      } else if (!a().hasNext()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int size()
    {
      if (this.d.equals(Range.all())) {
        return this.c.size();
      }
      return k1.v(a());
    }
    
    class a
      extends c<Map.Entry<d0<C>, Range<C>>>
    {
      a(Iterator paramIterator) {}
      
      protected Map.Entry<d0<C>, Range<C>> d()
      {
        if (!localObject.hasNext()) {
          return (Map.Entry)b();
        }
        Range localRange = (Range)localObject.next();
        if (TreeRangeSet.e.c(TreeRangeSet.e.this).upperBound.m(localRange.upperBound)) {
          return (Map.Entry)b();
        }
        return q1.i(localRange.upperBound, localRange);
      }
    }
    
    class b
      extends c<Map.Entry<d0<C>, Range<C>>>
    {
      b(b2 paramb2) {}
      
      protected Map.Entry<d0<C>, Range<C>> d()
      {
        if (!localObject.hasNext()) {
          return (Map.Entry)b();
        }
        Object localObject = (Range)localObject.next();
        if (TreeRangeSet.e.c(TreeRangeSet.e.this).lowerBound.m(((Range)localObject).upperBound)) {
          localObject = q1.i(((Range)localObject).upperBound, localObject);
        } else {
          localObject = (Map.Entry)b();
        }
        return (Map.Entry<d0<C>, Range<C>>)localObject;
      }
    }
  }
  
  private final class f
    extends TreeRangeSet<C>
  {
    private final Range<C> c;
    
    f()
    {
      super(null);
      this.c = localRange;
    }
    
    public void add(Range<C> paramRange)
    {
      n.k(this.c.encloses(paramRange), "Cannot add range %s to subRangeSet(%s)", paramRange, this.c);
      super.add(paramRange);
    }
    
    public void clear()
    {
      TreeRangeSet.this.remove(this.c);
    }
    
    public boolean contains(C paramC)
    {
      boolean bool;
      if ((this.c.contains(paramC)) && (TreeRangeSet.this.contains(paramC))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean encloses(Range<C> paramRange)
    {
      boolean bool1 = this.c.isEmpty();
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (!bool1)
      {
        bool3 = bool2;
        if (this.c.encloses(paramRange))
        {
          paramRange = TreeRangeSet.this.rangeEnclosing(paramRange);
          bool3 = bool2;
          if (paramRange != null)
          {
            bool3 = bool2;
            if (!paramRange.intersection(this.c).isEmpty()) {
              bool3 = true;
            }
          }
        }
      }
      return bool3;
    }
    
    @NullableDecl
    public Range<C> rangeContaining(C paramC)
    {
      boolean bool = this.c.contains(paramC);
      Object localObject = null;
      if (!bool) {
        return null;
      }
      paramC = TreeRangeSet.this.rangeContaining(paramC);
      if (paramC == null) {
        paramC = (C)localObject;
      } else {
        paramC = paramC.intersection(this.c);
      }
      return paramC;
    }
    
    public void remove(Range<C> paramRange)
    {
      if (paramRange.isConnected(this.c)) {
        TreeRangeSet.this.remove(paramRange.intersection(this.c));
      }
    }
    
    public f2<C> subRangeSet(Range<C> paramRange)
    {
      if (paramRange.encloses(this.c)) {
        return this;
      }
      if (paramRange.isConnected(this.c)) {
        return new f(this, this.c.intersection(paramRange));
      }
      return ImmutableRangeSet.of();
    }
  }
  
  private static final class g<C extends Comparable<?>>
    extends j<d0<C>, Range<C>>
  {
    private final Range<d0<C>> c;
    private final Range<C> d;
    private final NavigableMap<d0<C>, Range<C>> f;
    private final NavigableMap<d0<C>, Range<C>> q;
    
    private g(Range<d0<C>> paramRange, Range<C> paramRange1, NavigableMap<d0<C>, Range<C>> paramNavigableMap)
    {
      this.c = ((Range)n.o(paramRange));
      this.d = ((Range)n.o(paramRange1));
      this.f = ((NavigableMap)n.o(paramNavigableMap));
      this.q = new TreeRangeSet.e(paramNavigableMap);
    }
    
    private NavigableMap<d0<C>, Range<C>> h(Range<d0<C>> paramRange)
    {
      if (!paramRange.isConnected(this.c)) {
        return ImmutableSortedMap.of();
      }
      return new g(this.c.intersection(paramRange), this.d, this.f);
    }
    
    Iterator<Map.Entry<d0<C>, Range<C>>> a()
    {
      if (this.d.isEmpty()) {
        return k1.h();
      }
      if (this.c.upperBound.m(this.d.lowerBound)) {
        return k1.h();
      }
      boolean bool1 = this.c.lowerBound.m(this.d.lowerBound);
      boolean bool2 = false;
      final Object localObject;
      if (bool1)
      {
        localObject = this.q.tailMap(this.d.lowerBound, false).values().iterator();
      }
      else
      {
        localObject = this.f;
        Comparable localComparable = this.c.lowerBound.k();
        if (this.c.lowerBoundType() == BoundType.CLOSED) {
          bool2 = true;
        }
        localObject = ((NavigableMap)localObject).tailMap(localComparable, bool2).values().iterator();
      }
      return new a((Iterator)localObject, (d0)a2.g().f(this.c.upperBound, d0.f(this.d.upperBound)));
    }
    
    Iterator<Map.Entry<d0<C>, Range<C>>> b()
    {
      if (this.d.isEmpty()) {
        return k1.h();
      }
      d0 locald0 = (d0)a2.g().f(this.c.upperBound, d0.f(this.d.upperBound));
      NavigableMap localNavigableMap = this.f;
      Comparable localComparable = locald0.k();
      boolean bool;
      if (locald0.p() == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      }
      return new b(localNavigableMap.headMap(localComparable, bool).descendingMap().values().iterator());
    }
    
    public Comparator<? super d0<C>> comparator()
    {
      return a2.g();
    }
    
    public boolean containsKey(@NullableDecl Object paramObject)
    {
      boolean bool;
      if (e(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @NullableDecl
    public Range<C> e(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof d0)) {}
      try
      {
        paramObject = (d0)paramObject;
        if ((this.c.contains((Comparable)paramObject)) && (((d0)paramObject).h(this.d.lowerBound) >= 0) && (((d0)paramObject).h(this.d.upperBound) < 0)) {
          if (((d0)paramObject).equals(this.d.lowerBound))
          {
            paramObject = (Range)q1.E(this.f.floorEntry(paramObject));
            if ((paramObject != null) && (((Range)paramObject).upperBound.h(this.d.lowerBound) > 0)) {
              return ((Range)paramObject).intersection(this.d);
            }
          }
          else
          {
            paramObject = (Range)this.f.get(paramObject);
            if (paramObject != null)
            {
              paramObject = ((Range)paramObject).intersection(this.d);
              return (Range<C>)paramObject;
            }
          }
        }
      }
      catch (ClassCastException paramObject)
      {
        for (;;) {}
      }
      return null;
    }
    
    public NavigableMap<d0<C>, Range<C>> f(d0<C> paramd0, boolean paramBoolean)
    {
      return h(Range.upTo(paramd0, BoundType.forBoolean(paramBoolean)));
    }
    
    public NavigableMap<d0<C>, Range<C>> g(d0<C> paramd01, boolean paramBoolean1, d0<C> paramd02, boolean paramBoolean2)
    {
      return h(Range.range(paramd01, BoundType.forBoolean(paramBoolean1), paramd02, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableMap<d0<C>, Range<C>> i(d0<C> paramd0, boolean paramBoolean)
    {
      return h(Range.downTo(paramd0, BoundType.forBoolean(paramBoolean)));
    }
    
    public int size()
    {
      return k1.v(a());
    }
    
    class a
      extends c<Map.Entry<d0<C>, Range<C>>>
    {
      a(Iterator paramIterator, d0 paramd0) {}
      
      protected Map.Entry<d0<C>, Range<C>> d()
      {
        if (!localObject.hasNext()) {
          return (Map.Entry)b();
        }
        Range localRange = (Range)localObject.next();
        if (this.q.m(localRange.lowerBound)) {
          return (Map.Entry)b();
        }
        localRange = localRange.intersection(TreeRangeSet.g.c(TreeRangeSet.g.this));
        return q1.i(localRange.lowerBound, localRange);
      }
    }
    
    class b
      extends c<Map.Entry<d0<C>, Range<C>>>
    {
      b(Iterator paramIterator) {}
      
      protected Map.Entry<d0<C>, Range<C>> d()
      {
        if (!this.f.hasNext()) {
          return (Map.Entry)b();
        }
        Range localRange = (Range)this.f.next();
        if (TreeRangeSet.g.c(TreeRangeSet.g.this).lowerBound.h(localRange.upperBound) >= 0) {
          return (Map.Entry)b();
        }
        localRange = localRange.intersection(TreeRangeSet.g.c(TreeRangeSet.g.this));
        if (TreeRangeSet.g.d(TreeRangeSet.g.this).contains(localRange.lowerBound)) {
          return q1.i(localRange.lowerBound, localRange);
        }
        return (Map.Entry)b();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\TreeRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */