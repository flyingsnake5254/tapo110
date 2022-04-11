package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class e<K, V>
  extends h<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 2447537837011683357L;
  private transient Map<K, Collection<V>> map;
  private transient int totalSize;
  
  protected e(Map<K, Collection<V>> paramMap)
  {
    n.d(paramMap.isEmpty());
    this.map = paramMap;
  }
  
  private Collection<V> getOrCreateCollection(@NullableDecl K paramK)
  {
    Collection localCollection1 = (Collection)this.map.get(paramK);
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null)
    {
      localCollection2 = createCollection(paramK);
      this.map.put(paramK, localCollection2);
    }
    return localCollection2;
  }
  
  private static <E> Iterator<E> iteratorOrListIterator(Collection<E> paramCollection)
  {
    if ((paramCollection instanceof List)) {
      paramCollection = ((List)paramCollection).listIterator();
    } else {
      paramCollection = paramCollection.iterator();
    }
    return paramCollection;
  }
  
  private void removeValuesForKey(Object paramObject)
  {
    paramObject = (Collection)q1.w(this.map, paramObject);
    if (paramObject != null)
    {
      int i = ((Collection)paramObject).size();
      ((Collection)paramObject).clear();
      this.totalSize -= i;
    }
  }
  
  Map<K, Collection<V>> backingMap()
  {
    return this.map;
  }
  
  public void clear()
  {
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      ((Collection)localIterator.next()).clear();
    }
    this.map.clear();
    this.totalSize = 0;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return new c(this.map);
  }
  
  abstract Collection<V> createCollection();
  
  Collection<V> createCollection(@NullableDecl K paramK)
  {
    return createCollection();
  }
  
  Collection<Map.Entry<K, V>> createEntries()
  {
    if ((this instanceof s2)) {
      return new h.b(this);
    }
    return new h.a(this);
  }
  
  Set<K> createKeySet()
  {
    return new e(this.map);
  }
  
  u1<K> createKeys()
  {
    return new t1.d(this);
  }
  
  final Map<K, Collection<V>> createMaybeNavigableAsMap()
  {
    Map localMap = this.map;
    if ((localMap instanceof NavigableMap)) {
      return new f((NavigableMap)this.map);
    }
    if ((localMap instanceof SortedMap)) {
      return new i((SortedMap)this.map);
    }
    return new c(this.map);
  }
  
  final Set<K> createMaybeNavigableKeySet()
  {
    Map localMap = this.map;
    if ((localMap instanceof NavigableMap)) {
      return new g((NavigableMap)this.map);
    }
    if ((localMap instanceof SortedMap)) {
      return new j((SortedMap)this.map);
    }
    return new e(this.map);
  }
  
  abstract Collection<V> createUnmodifiableEmptyCollection();
  
  Collection<V> createValues()
  {
    return new h.c(this);
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    return super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return new b();
  }
  
  public Collection<V> get(@NullableDecl K paramK)
  {
    Collection localCollection1 = (Collection)this.map.get(paramK);
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null) {
      localCollection2 = createCollection(paramK);
    }
    return wrapCollection(paramK, localCollection2);
  }
  
  public boolean put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    Collection localCollection = (Collection)this.map.get(paramK);
    if (localCollection == null)
    {
      localCollection = createCollection(paramK);
      if (localCollection.add(paramV))
      {
        this.totalSize += 1;
        this.map.put(paramK, localCollection);
        return true;
      }
      throw new AssertionError("New Collection violated the Collection spec");
    }
    if (localCollection.add(paramV))
    {
      this.totalSize += 1;
      return true;
    }
    return false;
  }
  
  public Collection<V> removeAll(@NullableDecl Object paramObject)
  {
    paramObject = (Collection)this.map.remove(paramObject);
    if (paramObject == null) {
      return createUnmodifiableEmptyCollection();
    }
    Collection localCollection = createCollection();
    localCollection.addAll((Collection)paramObject);
    this.totalSize -= ((Collection)paramObject).size();
    ((Collection)paramObject).clear();
    return unmodifiableCollectionSubclass(localCollection);
  }
  
  public Collection<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return removeAll(paramK);
    }
    Collection localCollection = getOrCreateCollection(paramK);
    paramK = createCollection();
    paramK.addAll(localCollection);
    this.totalSize -= localCollection.size();
    localCollection.clear();
    while (paramIterable.hasNext()) {
      if (localCollection.add(paramIterable.next())) {
        this.totalSize += 1;
      }
    }
    return unmodifiableCollectionSubclass(paramK);
  }
  
  final void setMap(Map<K, Collection<V>> paramMap)
  {
    this.map = paramMap;
    this.totalSize = 0;
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Collection localCollection = (Collection)paramMap.next();
      n.d(localCollection.isEmpty() ^ true);
      this.totalSize += localCollection.size();
    }
  }
  
  public int size()
  {
    return this.totalSize;
  }
  
  abstract <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> paramCollection);
  
  Iterator<V> valueIterator()
  {
    return new a();
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  abstract Collection<V> wrapCollection(@NullableDecl K paramK, Collection<V> paramCollection);
  
  final List<V> wrapList(@NullableDecl K paramK, List<V> paramList, @NullableDecl e<K, V>.k parame)
  {
    if ((paramList instanceof RandomAccess)) {
      paramK = new h(paramK, paramList, parame);
    } else {
      paramK = new l(paramK, paramList, parame);
    }
    return paramK;
  }
  
  class a
    extends e<K, V>.d<V>
  {
    a()
    {
      super();
    }
    
    V a(K paramK, V paramV)
    {
      return paramV;
    }
  }
  
  class b
    extends e<K, V>.d<Map.Entry<K, V>>
  {
    b()
    {
      super();
    }
    
    Map.Entry<K, V> b(K paramK, V paramV)
    {
      return q1.i(paramK, paramV);
    }
  }
  
  private class c
    extends q1.r<K, Collection<V>>
  {
    final transient Map<K, Collection<V>> q;
    
    c()
    {
      Map localMap;
      this.q = localMap;
    }
    
    protected Set<Map.Entry<K, Collection<V>>> a()
    {
      return new a();
    }
    
    public void clear()
    {
      if (this.q == e.this.map) {
        e.this.clear();
      } else {
        k1.d(new b());
      }
    }
    
    public boolean containsKey(Object paramObject)
    {
      return q1.u(this.q, paramObject);
    }
    
    public Collection<V> d(Object paramObject)
    {
      Collection localCollection = (Collection)q1.v(this.q, paramObject);
      if (localCollection == null) {
        return null;
      }
      return e.this.wrapCollection(paramObject, localCollection);
    }
    
    public Collection<V> e(Object paramObject)
    {
      paramObject = (Collection)this.q.remove(paramObject);
      if (paramObject == null) {
        return null;
      }
      Collection localCollection = e.this.createCollection();
      localCollection.addAll((Collection)paramObject);
      e locale = e.this;
      e.access$202(locale, locale.totalSize - ((Collection)paramObject).size());
      ((Collection)paramObject).clear();
      return localCollection;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      boolean bool;
      if ((this != paramObject) && (!this.q.equals(paramObject))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> paramEntry)
    {
      Object localObject = paramEntry.getKey();
      return q1.i(localObject, e.this.wrapCollection(localObject, (Collection)paramEntry.getValue()));
    }
    
    public int hashCode()
    {
      return this.q.hashCode();
    }
    
    public Set<K> keySet()
    {
      return e.this.keySet();
    }
    
    public int size()
    {
      return this.q.size();
    }
    
    public String toString()
    {
      return this.q.toString();
    }
    
    class a
      extends q1.j<K, Collection<V>>
    {
      a() {}
      
      Map<K, Collection<V>> c()
      {
        return e.c.this;
      }
      
      public boolean contains(Object paramObject)
      {
        return w.d(e.c.this.q.entrySet(), paramObject);
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator()
      {
        return new e.c.b(e.c.this);
      }
      
      public boolean remove(Object paramObject)
      {
        if (!contains(paramObject)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        e.this.removeValuesForKey(((Map.Entry)paramObject).getKey());
        return true;
      }
    }
    
    class b
      implements Iterator<Map.Entry<K, Collection<V>>>
    {
      final Iterator<Map.Entry<K, Collection<V>>> c = e.c.this.q.entrySet().iterator();
      @NullableDecl
      Collection<V> d;
      
      b() {}
      
      public Map.Entry<K, Collection<V>> a()
      {
        Map.Entry localEntry = (Map.Entry)this.c.next();
        this.d = ((Collection)localEntry.getValue());
        return e.c.this.f(localEntry);
      }
      
      public boolean hasNext()
      {
        return this.c.hasNext();
      }
      
      public void remove()
      {
        boolean bool;
        if (this.d != null) {
          bool = true;
        } else {
          bool = false;
        }
        v.e(bool);
        this.c.remove();
        e locale = e.this;
        e.access$202(locale, locale.totalSize - this.d.size());
        this.d.clear();
        this.d = null;
      }
    }
  }
  
  private abstract class d<T>
    implements Iterator<T>
  {
    final Iterator<Map.Entry<K, Collection<V>>> c = e.this.map.entrySet().iterator();
    @NullableDecl
    K d = null;
    @MonotonicNonNullDecl
    Collection<V> f = null;
    Iterator<V> q = k1.j();
    
    d() {}
    
    abstract T a(K paramK, V paramV);
    
    public boolean hasNext()
    {
      boolean bool;
      if ((!this.c.hasNext()) && (!this.q.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public T next()
    {
      if (!this.q.hasNext())
      {
        Object localObject = (Map.Entry)this.c.next();
        this.d = ((Map.Entry)localObject).getKey();
        localObject = (Collection)((Map.Entry)localObject).getValue();
        this.f = ((Collection)localObject);
        this.q = ((Collection)localObject).iterator();
      }
      return (T)a(this.d, this.q.next());
    }
    
    public void remove()
    {
      this.q.remove();
      if (this.f.isEmpty()) {
        this.c.remove();
      }
      e.access$210(e.this);
    }
  }
  
  private class e
    extends q1.m<K, Collection<V>>
  {
    e()
    {
      super();
    }
    
    public void clear()
    {
      k1.d(iterator());
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return c().keySet().containsAll(paramCollection);
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      boolean bool;
      if ((this != paramObject) && (!c().keySet().equals(paramObject))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public int hashCode()
    {
      return c().keySet().hashCode();
    }
    
    public Iterator<K> iterator()
    {
      return new a(c().entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      paramObject = (Collection)c().remove(paramObject);
      boolean bool = false;
      int i;
      if (paramObject != null)
      {
        i = ((Collection)paramObject).size();
        ((Collection)paramObject).clear();
        paramObject = e.this;
        e.access$202((e)paramObject, ((e)paramObject).totalSize - i);
      }
      else
      {
        i = 0;
      }
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    
    class a
      implements Iterator<K>
    {
      @NullableDecl
      Map.Entry<K, Collection<V>> c;
      
      a(Iterator paramIterator) {}
      
      public boolean hasNext()
      {
        return this.d.hasNext();
      }
      
      public K next()
      {
        Map.Entry localEntry = (Map.Entry)this.d.next();
        this.c = localEntry;
        return (K)localEntry.getKey();
      }
      
      public void remove()
      {
        boolean bool;
        if (this.c != null) {
          bool = true;
        } else {
          bool = false;
        }
        v.e(bool);
        Collection localCollection = (Collection)this.c.getValue();
        this.d.remove();
        e locale = e.this;
        e.access$202(locale, locale.totalSize - localCollection.size());
        localCollection.clear();
        this.c = null;
      }
    }
  }
  
  class f
    extends e<K, V>.i
    implements NavigableMap<K, Collection<V>>
  {
    f()
    {
      super(localSortedMap);
    }
    
    public Map.Entry<K, Collection<V>> ceilingEntry(K paramK)
    {
      paramK = n().ceilingEntry(paramK);
      if (paramK == null) {
        paramK = null;
      } else {
        paramK = f(paramK);
      }
      return paramK;
    }
    
    public K ceilingKey(K paramK)
    {
      return (K)n().ceilingKey(paramK);
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      return descendingMap().navigableKeySet();
    }
    
    public NavigableMap<K, Collection<V>> descendingMap()
    {
      return new f(e.this, n().descendingMap());
    }
    
    public Map.Entry<K, Collection<V>> firstEntry()
    {
      Map.Entry localEntry = n().firstEntry();
      if (localEntry == null) {
        localEntry = null;
      } else {
        localEntry = f(localEntry);
      }
      return localEntry;
    }
    
    public Map.Entry<K, Collection<V>> floorEntry(K paramK)
    {
      paramK = n().floorEntry(paramK);
      if (paramK == null) {
        paramK = null;
      } else {
        paramK = f(paramK);
      }
      return paramK;
    }
    
    public K floorKey(K paramK)
    {
      return (K)n().floorKey(paramK);
    }
    
    public NavigableMap<K, Collection<V>> headMap(K paramK, boolean paramBoolean)
    {
      return new f(e.this, n().headMap(paramK, paramBoolean));
    }
    
    public Map.Entry<K, Collection<V>> higherEntry(K paramK)
    {
      paramK = n().higherEntry(paramK);
      if (paramK == null) {
        paramK = null;
      } else {
        paramK = f(paramK);
      }
      return paramK;
    }
    
    public K higherKey(K paramK)
    {
      return (K)n().higherKey(paramK);
    }
    
    NavigableSet<K> j()
    {
      return new e.g(e.this, n());
    }
    
    public NavigableMap<K, Collection<V>> k(K paramK)
    {
      return headMap(paramK, false);
    }
    
    public NavigableSet<K> l()
    {
      return (NavigableSet)super.h();
    }
    
    public Map.Entry<K, Collection<V>> lastEntry()
    {
      Map.Entry localEntry = n().lastEntry();
      if (localEntry == null) {
        localEntry = null;
      } else {
        localEntry = f(localEntry);
      }
      return localEntry;
    }
    
    public Map.Entry<K, Collection<V>> lowerEntry(K paramK)
    {
      paramK = n().lowerEntry(paramK);
      if (paramK == null) {
        paramK = null;
      } else {
        paramK = f(paramK);
      }
      return paramK;
    }
    
    public K lowerKey(K paramK)
    {
      return (K)n().lowerKey(paramK);
    }
    
    Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> paramIterator)
    {
      if (!paramIterator.hasNext()) {
        return null;
      }
      Map.Entry localEntry = (Map.Entry)paramIterator.next();
      Collection localCollection = e.this.createCollection();
      localCollection.addAll((Collection)localEntry.getValue());
      paramIterator.remove();
      return q1.i(localEntry.getKey(), e.this.unmodifiableCollectionSubclass(localCollection));
    }
    
    NavigableMap<K, Collection<V>> n()
    {
      return (NavigableMap)super.i();
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      return l();
    }
    
    public NavigableMap<K, Collection<V>> o(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }
    
    public NavigableMap<K, Collection<V>> p(K paramK)
    {
      return tailMap(paramK, true);
    }
    
    public Map.Entry<K, Collection<V>> pollFirstEntry()
    {
      return m(entrySet().iterator());
    }
    
    public Map.Entry<K, Collection<V>> pollLastEntry()
    {
      return m(descendingMap().entrySet().iterator());
    }
    
    public NavigableMap<K, Collection<V>> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return new f(e.this, n().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2));
    }
    
    public NavigableMap<K, Collection<V>> tailMap(K paramK, boolean paramBoolean)
    {
      return new f(e.this, n().tailMap(paramK, paramBoolean));
    }
  }
  
  class g
    extends e<K, V>.j
    implements NavigableSet<K>
  {
    g()
    {
      super(localSortedMap);
    }
    
    public K ceiling(K paramK)
    {
      return (K)h().ceilingKey(paramK);
    }
    
    public Iterator<K> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet()
    {
      return new g(e.this, h().descendingMap());
    }
    
    public K floor(K paramK)
    {
      return (K)h().floorKey(paramK);
    }
    
    public NavigableSet<K> g(K paramK)
    {
      return headSet(paramK, false);
    }
    
    NavigableMap<K, Collection<V>> h()
    {
      return (NavigableMap)super.e();
    }
    
    public NavigableSet<K> headSet(K paramK, boolean paramBoolean)
    {
      return new g(e.this, h().headMap(paramK, paramBoolean));
    }
    
    public K higher(K paramK)
    {
      return (K)h().higherKey(paramK);
    }
    
    public NavigableSet<K> i(K paramK1, K paramK2)
    {
      return subSet(paramK1, true, paramK2, false);
    }
    
    public NavigableSet<K> j(K paramK)
    {
      return tailSet(paramK, true);
    }
    
    public K lower(K paramK)
    {
      return (K)h().lowerKey(paramK);
    }
    
    public K pollFirst()
    {
      return (K)k1.r(iterator());
    }
    
    public K pollLast()
    {
      return (K)k1.r(descendingIterator());
    }
    
    public NavigableSet<K> subSet(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return new g(e.this, h().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2));
    }
    
    public NavigableSet<K> tailSet(K paramK, boolean paramBoolean)
    {
      return new g(e.this, h().tailMap(paramK, paramBoolean));
    }
  }
  
  private class h
    extends e<K, V>.l
    implements RandomAccess
  {
    h(List<V> paramList, @NullableDecl e<K, V>.k parame)
    {
      super(paramList, parame, localk);
    }
  }
  
  private class i
    extends e<K, V>.c
    implements SortedMap<K, Collection<V>>
  {
    @MonotonicNonNullDecl
    SortedSet<K> y;
    
    i()
    {
      super(localMap);
    }
    
    public Comparator<? super K> comparator()
    {
      return i().comparator();
    }
    
    public K firstKey()
    {
      return (K)i().firstKey();
    }
    
    SortedSet<K> g()
    {
      return new e.j(e.this, i());
    }
    
    public SortedSet<K> h()
    {
      SortedSet localSortedSet1 = this.y;
      SortedSet localSortedSet2 = localSortedSet1;
      if (localSortedSet1 == null)
      {
        localSortedSet2 = g();
        this.y = localSortedSet2;
      }
      return localSortedSet2;
    }
    
    public SortedMap<K, Collection<V>> headMap(K paramK)
    {
      return new i(e.this, i().headMap(paramK));
    }
    
    SortedMap<K, Collection<V>> i()
    {
      return (SortedMap)this.q;
    }
    
    public K lastKey()
    {
      return (K)i().lastKey();
    }
    
    public SortedMap<K, Collection<V>> subMap(K paramK1, K paramK2)
    {
      return new i(e.this, i().subMap(paramK1, paramK2));
    }
    
    public SortedMap<K, Collection<V>> tailMap(K paramK)
    {
      return new i(e.this, i().tailMap(paramK));
    }
  }
  
  private class j
    extends e<K, V>.e
    implements SortedSet<K>
  {
    j()
    {
      super(localMap);
    }
    
    public Comparator<? super K> comparator()
    {
      return e().comparator();
    }
    
    SortedMap<K, Collection<V>> e()
    {
      return (SortedMap)super.c();
    }
    
    public K first()
    {
      return (K)e().firstKey();
    }
    
    public SortedSet<K> headSet(K paramK)
    {
      return new j(e.this, e().headMap(paramK));
    }
    
    public K last()
    {
      return (K)e().lastKey();
    }
    
    public SortedSet<K> subSet(K paramK1, K paramK2)
    {
      return new j(e.this, e().subMap(paramK1, paramK2));
    }
    
    public SortedSet<K> tailSet(K paramK)
    {
      return new j(e.this, e().tailMap(paramK));
    }
  }
  
  class k
    extends AbstractCollection<V>
  {
    @NullableDecl
    final K c;
    Collection<V> d;
    @NullableDecl
    final e<K, V>.k f;
    @NullableDecl
    final Collection<V> q;
    
    k(Collection<V> paramCollection, @NullableDecl e<K, V>.k parame)
    {
      this.c = paramCollection;
      this.d = parame;
      k localk;
      this.f = localk;
      if (localk == null) {
        this$1 = null;
      } else {
        this$1 = localk.c();
      }
      this.q = e.this;
    }
    
    void a()
    {
      k localk = this.f;
      if (localk != null) {
        localk.a();
      } else {
        e.this.map.put(this.c, this.d);
      }
    }
    
    public boolean add(V paramV)
    {
      e();
      boolean bool1 = this.d.isEmpty();
      boolean bool2 = this.d.add(paramV);
      if (bool2)
      {
        e.access$208(e.this);
        if (bool1) {
          a();
        }
      }
      return bool2;
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      if (paramCollection.isEmpty()) {
        return false;
      }
      int i = size();
      boolean bool = this.d.addAll(paramCollection);
      if (bool)
      {
        int j = this.d.size();
        paramCollection = e.this;
        e.access$202(paramCollection, paramCollection.totalSize + (j - i));
        if (i == 0) {
          a();
        }
      }
      return bool;
    }
    
    e<K, V>.k b()
    {
      return this.f;
    }
    
    Collection<V> c()
    {
      return this.d;
    }
    
    public void clear()
    {
      int i = size();
      if (i == 0) {
        return;
      }
      this.d.clear();
      e locale = e.this;
      e.access$202(locale, locale.totalSize - i);
      f();
    }
    
    public boolean contains(Object paramObject)
    {
      e();
      return this.d.contains(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      e();
      return this.d.containsAll(paramCollection);
    }
    
    K d()
    {
      return (K)this.c;
    }
    
    void e()
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        ((k)localObject).e();
        if (this.f.c() != this.q) {
          throw new ConcurrentModificationException();
        }
      }
      else if (this.d.isEmpty())
      {
        localObject = (Collection)e.this.map.get(this.c);
        if (localObject != null) {
          this.d = ((Collection)localObject);
        }
      }
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      e();
      return this.d.equals(paramObject);
    }
    
    void f()
    {
      k localk = this.f;
      if (localk != null) {
        localk.f();
      } else if (this.d.isEmpty()) {
        e.this.map.remove(this.c);
      }
    }
    
    public int hashCode()
    {
      e();
      return this.d.hashCode();
    }
    
    public Iterator<V> iterator()
    {
      e();
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      e();
      boolean bool = this.d.remove(paramObject);
      if (bool)
      {
        e.access$210(e.this);
        f();
      }
      return bool;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      if (paramCollection.isEmpty()) {
        return false;
      }
      int i = size();
      boolean bool = this.d.removeAll(paramCollection);
      if (bool)
      {
        int j = this.d.size();
        paramCollection = e.this;
        e.access$202(paramCollection, paramCollection.totalSize + (j - i));
        f();
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      n.o(paramCollection);
      int i = size();
      boolean bool = this.d.retainAll(paramCollection);
      if (bool)
      {
        int j = this.d.size();
        paramCollection = e.this;
        e.access$202(paramCollection, paramCollection.totalSize + (j - i));
        f();
      }
      return bool;
    }
    
    public int size()
    {
      e();
      return this.d.size();
    }
    
    public String toString()
    {
      e();
      return this.d.toString();
    }
    
    class a
      implements Iterator<V>
    {
      final Iterator<V> c;
      final Collection<V> d;
      
      a()
      {
        this$1 = e.k.this.d;
        this.d = e.k.this;
        this.c = e.iteratorOrListIterator(e.k.this);
      }
      
      a()
      {
        this.d = e.k.this.d;
        Iterator localIterator;
        this.c = localIterator;
      }
      
      Iterator<V> a()
      {
        b();
        return this.c;
      }
      
      void b()
      {
        e.k.this.e();
        if (e.k.this.d == this.d) {
          return;
        }
        throw new ConcurrentModificationException();
      }
      
      public boolean hasNext()
      {
        b();
        return this.c.hasNext();
      }
      
      public V next()
      {
        b();
        return (V)this.c.next();
      }
      
      public void remove()
      {
        this.c.remove();
        e.access$210(e.this);
        e.k.this.f();
      }
    }
  }
  
  class l
    extends e<K, V>.k
    implements List<V>
  {
    l(List<V> paramList, @NullableDecl e<K, V>.k parame)
    {
      super(paramList, parame, localk);
    }
    
    public void add(int paramInt, V paramV)
    {
      e();
      boolean bool = c().isEmpty();
      g().add(paramInt, paramV);
      e.access$208(e.this);
      if (bool) {
        a();
      }
    }
    
    public boolean addAll(int paramInt, Collection<? extends V> paramCollection)
    {
      if (paramCollection.isEmpty()) {
        return false;
      }
      int i = size();
      boolean bool = g().addAll(paramInt, paramCollection);
      if (bool)
      {
        paramInt = c().size();
        paramCollection = e.this;
        e.access$202(paramCollection, paramCollection.totalSize + (paramInt - i));
        if (i == 0) {
          a();
        }
      }
      return bool;
    }
    
    List<V> g()
    {
      return (List)c();
    }
    
    public V get(int paramInt)
    {
      e();
      return (V)g().get(paramInt);
    }
    
    public int indexOf(Object paramObject)
    {
      e();
      return g().indexOf(paramObject);
    }
    
    public int lastIndexOf(Object paramObject)
    {
      e();
      return g().lastIndexOf(paramObject);
    }
    
    public ListIterator<V> listIterator()
    {
      e();
      return new a();
    }
    
    public ListIterator<V> listIterator(int paramInt)
    {
      e();
      return new a(paramInt);
    }
    
    public V remove(int paramInt)
    {
      e();
      Object localObject = g().remove(paramInt);
      e.access$210(e.this);
      f();
      return (V)localObject;
    }
    
    public V set(int paramInt, V paramV)
    {
      e();
      return (V)g().set(paramInt, paramV);
    }
    
    public List<V> subList(int paramInt1, int paramInt2)
    {
      e();
      e locale = e.this;
      Object localObject1 = d();
      List localList = g().subList(paramInt1, paramInt2);
      Object localObject2;
      if (b() == null) {
        localObject2 = this;
      } else {
        localObject2 = b();
      }
      return locale.wrapList(localObject1, localList, (e.k)localObject2);
    }
    
    private class a
      extends e<K, V>.k.a
      implements ListIterator<V>
    {
      a()
      {
        super();
      }
      
      public a(int paramInt)
      {
        super(e.l.this.g().listIterator(paramInt));
      }
      
      private ListIterator<V> c()
      {
        return (ListIterator)a();
      }
      
      public void add(V paramV)
      {
        boolean bool = e.l.this.isEmpty();
        c().add(paramV);
        e.access$208(e.this);
        if (bool) {
          e.l.this.a();
        }
      }
      
      public boolean hasPrevious()
      {
        return c().hasPrevious();
      }
      
      public int nextIndex()
      {
        return c().nextIndex();
      }
      
      public V previous()
      {
        return (V)c().previous();
      }
      
      public int previousIndex()
      {
        return c().previousIndex();
      }
      
      public void set(V paramV)
      {
        c().set(paramV);
      }
    }
  }
  
  class m
    extends e<K, V>.o
    implements NavigableSet<V>
  {
    m(NavigableSet<V> paramNavigableSet, @NullableDecl e<K, V>.k parame)
    {
      super(paramNavigableSet, parame, localk);
    }
    
    private NavigableSet<V> i(NavigableSet<V> paramNavigableSet)
    {
      e locale = e.this;
      Object localObject1 = this.c;
      Object localObject2;
      if (b() == null) {
        localObject2 = this;
      } else {
        localObject2 = b();
      }
      return new m(locale, localObject1, paramNavigableSet, (e.k)localObject2);
    }
    
    public V ceiling(V paramV)
    {
      return (V)h().ceiling(paramV);
    }
    
    public Iterator<V> descendingIterator()
    {
      return new e.k.a(this, h().descendingIterator());
    }
    
    public NavigableSet<V> descendingSet()
    {
      return i(h().descendingSet());
    }
    
    public V floor(V paramV)
    {
      return (V)h().floor(paramV);
    }
    
    NavigableSet<V> h()
    {
      return (NavigableSet)super.g();
    }
    
    public NavigableSet<V> headSet(V paramV, boolean paramBoolean)
    {
      return i(h().headSet(paramV, paramBoolean));
    }
    
    public V higher(V paramV)
    {
      return (V)h().higher(paramV);
    }
    
    public V lower(V paramV)
    {
      return (V)h().lower(paramV);
    }
    
    public V pollFirst()
    {
      return (V)k1.r(iterator());
    }
    
    public V pollLast()
    {
      return (V)k1.r(descendingIterator());
    }
    
    public NavigableSet<V> subSet(V paramV1, boolean paramBoolean1, V paramV2, boolean paramBoolean2)
    {
      return i(h().subSet(paramV1, paramBoolean1, paramV2, paramBoolean2));
    }
    
    public NavigableSet<V> tailSet(V paramV, boolean paramBoolean)
    {
      return i(h().tailSet(paramV, paramBoolean));
    }
  }
  
  class n
    extends e<K, V>.k
    implements Set<V>
  {
    n(Set<V> paramSet)
    {
      super(paramSet, localCollection, null);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      if (paramCollection.isEmpty()) {
        return false;
      }
      int i = size();
      boolean bool = u2.g((Set)this.d, paramCollection);
      if (bool)
      {
        int j = this.d.size();
        paramCollection = e.this;
        e.access$202(paramCollection, paramCollection.totalSize + (j - i));
        f();
      }
      return bool;
    }
  }
  
  class o
    extends e<K, V>.k
    implements SortedSet<V>
  {
    o(SortedSet<V> paramSortedSet, @NullableDecl e<K, V>.k parame)
    {
      super(paramSortedSet, parame, localk);
    }
    
    public Comparator<? super V> comparator()
    {
      return g().comparator();
    }
    
    public V first()
    {
      e();
      return (V)g().first();
    }
    
    SortedSet<V> g()
    {
      return (SortedSet)c();
    }
    
    public SortedSet<V> headSet(V paramV)
    {
      e();
      e locale = e.this;
      Object localObject = d();
      SortedSet localSortedSet = g().headSet(paramV);
      if (b() == null) {
        paramV = this;
      } else {
        paramV = b();
      }
      return new o(locale, localObject, localSortedSet, paramV);
    }
    
    public V last()
    {
      e();
      return (V)g().last();
    }
    
    public SortedSet<V> subSet(V paramV1, V paramV2)
    {
      e();
      e locale = e.this;
      Object localObject = d();
      paramV2 = g().subSet(paramV1, paramV2);
      if (b() == null) {
        paramV1 = this;
      } else {
        paramV1 = b();
      }
      return new o(locale, localObject, paramV2, paramV1);
    }
    
    public SortedSet<V> tailSet(V paramV)
    {
      e();
      e locale = e.this;
      Object localObject = d();
      SortedSet localSortedSet = g().tailSet(paramV);
      if (b() == null) {
        paramV = this;
      } else {
        paramV = b();
      }
      return new o(locale, localObject, localSortedSet, paramV);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */