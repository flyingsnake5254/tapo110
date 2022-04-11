package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.base.p;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class q1
{
  public static <K, V1, V2> Map<K, V2> A(Map<K, V1> paramMap, h<? super V1, V2> paramh)
  {
    return y(paramMap, b(paramh));
  }
  
  static <K, V> Map.Entry<K, V> B(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    n.o(paramEntry);
    return new f(paramEntry);
  }
  
  static <V> h<Map.Entry<?, V>, V> C()
  {
    return i.d;
  }
  
  static <K, V> Iterator<V> D(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return new d(paramIterator);
  }
  
  @NullableDecl
  static <V> V E(@NullableDecl Map.Entry<?, V> paramEntry)
  {
    if (paramEntry == null) {
      paramEntry = null;
    } else {
      paramEntry = paramEntry.getValue();
    }
    return paramEntry;
  }
  
  static <V> o<Map.Entry<?, V>> F(o<? super V> paramo)
  {
    return p.b(paramo, C());
  }
  
  static <K, V1, V2> h<Map.Entry<K, V1>, Map.Entry<K, V2>> a(k<? super K, ? super V1, V2> paramk)
  {
    n.o(paramk);
    return new b(paramk);
  }
  
  static <K, V1, V2> k<K, V1, V2> b(h<? super V1, V2> paramh)
  {
    n.o(paramh);
    return new g(paramh);
  }
  
  static <K, V> Iterator<Map.Entry<K, V>> c(Set<K> paramSet, final h<? super K, V> paramh)
  {
    return new e(paramSet.iterator(), paramh);
  }
  
  static int d(int paramInt)
  {
    if (paramInt < 3)
    {
      v.b(paramInt, "expectedSize");
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return Integer.MAX_VALUE;
  }
  
  static <K, V> boolean e(Collection<Map.Entry<K, V>> paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    return paramCollection.contains(B((Map.Entry)paramObject));
  }
  
  static boolean f(Map<?, ?> paramMap, @NullableDecl Object paramObject)
  {
    return k1.f(l(paramMap.entrySet().iterator()), paramObject);
  }
  
  static boolean g(Map<?, ?> paramMap, @NullableDecl Object paramObject)
  {
    return k1.f(D(paramMap.entrySet().iterator()), paramObject);
  }
  
  static boolean h(Map<?, ?> paramMap, Object paramObject)
  {
    if (paramMap == paramObject) {
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      return paramMap.entrySet().equals(((Map)paramObject).entrySet());
    }
    return false;
  }
  
  public static <K, V> Map.Entry<K, V> i(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return new a1(paramK, paramV);
  }
  
  static <E> ImmutableMap<E, Integer> j(Collection<E> paramCollection)
  {
    ImmutableMap.b localb = new ImmutableMap.b(paramCollection.size());
    paramCollection = paramCollection.iterator();
    for (int i = 0; paramCollection.hasNext(); i++) {
      localb.c(paramCollection.next(), Integer.valueOf(i));
    }
    return localb.a();
  }
  
  static <K> h<Map.Entry<K, ?>, K> k()
  {
    return i.c;
  }
  
  static <K, V> Iterator<K> l(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return new c(paramIterator);
  }
  
  @NullableDecl
  static <K> K m(@NullableDecl Map.Entry<K, ?> paramEntry)
  {
    if (paramEntry == null) {
      paramEntry = null;
    } else {
      paramEntry = paramEntry.getKey();
    }
    return paramEntry;
  }
  
  static <K> o<Map.Entry<K, ?>> n(o<? super K> paramo)
  {
    return p.b(paramo, k());
  }
  
  public static <K, V> HashMap<K, V> o()
  {
    return new HashMap();
  }
  
  public static <K, V> HashMap<K, V> p(int paramInt)
  {
    return new HashMap(d(paramInt));
  }
  
  public static <K, V> IdentityHashMap<K, V> q()
  {
    return new IdentityHashMap();
  }
  
  public static <K, V> LinkedHashMap<K, V> r()
  {
    return new LinkedHashMap();
  }
  
  public static <K, V> LinkedHashMap<K, V> s(int paramInt)
  {
    return new LinkedHashMap(d(paramInt));
  }
  
  static <K, V> void t(Map<K, V> paramMap, Map<? extends K, ? extends V> paramMap1)
  {
    Iterator localIterator = paramMap1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap1 = (Map.Entry)localIterator.next();
      paramMap.put(paramMap1.getKey(), paramMap1.getValue());
    }
  }
  
  static boolean u(Map<?, ?> paramMap, Object paramObject)
  {
    n.o(paramMap);
    try
    {
      boolean bool = paramMap.containsKey(paramObject);
      return bool;
    }
    catch (ClassCastException|NullPointerException paramMap) {}
    return false;
  }
  
  static <V> V v(Map<?, V> paramMap, @NullableDecl Object paramObject)
  {
    n.o(paramMap);
    try
    {
      paramMap = paramMap.get(paramObject);
      return paramMap;
    }
    catch (ClassCastException|NullPointerException paramMap) {}
    return null;
  }
  
  static <V> V w(Map<?, V> paramMap, Object paramObject)
  {
    n.o(paramMap);
    try
    {
      paramMap = paramMap.remove(paramObject);
      return paramMap;
    }
    catch (ClassCastException|NullPointerException paramMap) {}
    return null;
  }
  
  static String x(Map<?, ?> paramMap)
  {
    StringBuilder localStringBuilder = w.c(paramMap.size());
    localStringBuilder.append('{');
    paramMap = paramMap.entrySet().iterator();
    int i = 1;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (i == 0) {
        localStringBuilder.append(", ");
      }
      i = 0;
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append('=');
      localStringBuilder.append(localEntry.getValue());
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static <K, V1, V2> Map<K, V2> y(Map<K, V1> paramMap, k<? super K, ? super V1, V2> paramk)
  {
    return new p(paramMap, paramk);
  }
  
  static <V2, K, V1> Map.Entry<K, V2> z(final k<? super K, ? super V1, V2> paramk, Map.Entry<K, V1> paramEntry)
  {
    n.o(paramk);
    n.o(paramEntry);
    return new a(paramEntry, paramk);
  }
  
  static final class a
    extends g<K, V2>
  {
    a(Map.Entry paramEntry, q1.k paramk) {}
    
    public K getKey()
    {
      return (K)this.c.getKey();
    }
    
    public V2 getValue()
    {
      return (V2)paramk.a(this.c.getKey(), this.c.getValue());
    }
  }
  
  static final class b
    implements h<Map.Entry<K, V1>, Map.Entry<K, V2>>
  {
    b(q1.k paramk) {}
    
    public Map.Entry<K, V2> a(Map.Entry<K, V1> paramEntry)
    {
      return q1.z(this.c, paramEntry);
    }
  }
  
  static final class c
    extends h3<Map.Entry<K, V>, K>
  {
    c(Iterator paramIterator)
    {
      super();
    }
    
    K b(Map.Entry<K, V> paramEntry)
    {
      return (K)paramEntry.getKey();
    }
  }
  
  static final class d
    extends h3<Map.Entry<K, V>, V>
  {
    d(Iterator paramIterator)
    {
      super();
    }
    
    V b(Map.Entry<K, V> paramEntry)
    {
      return (V)paramEntry.getValue();
    }
  }
  
  static final class e
    extends h3<K, Map.Entry<K, V>>
  {
    e(Iterator paramIterator, h paramh)
    {
      super();
    }
    
    Map.Entry<K, V> b(K paramK)
    {
      return q1.i(paramK, paramh.apply(paramK));
    }
  }
  
  static final class f
    extends g<K, V>
  {
    f(Map.Entry paramEntry) {}
    
    public K getKey()
    {
      return (K)this.c.getKey();
    }
    
    public V getValue()
    {
      return (V)this.c.getValue();
    }
  }
  
  static final class g
    implements q1.k<K, V1, V2>
  {
    g(h paramh) {}
    
    public V2 a(K paramK, V1 paramV1)
    {
      return (V2)this.a.apply(paramV1);
    }
  }
  
  static abstract class h<K, V>
    extends p0<K, V>
    implements NavigableMap<K, V>
  {
    @MonotonicNonNullDecl
    private transient Comparator<? super K> c;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> d;
    @MonotonicNonNullDecl
    private transient NavigableSet<K> f;
    
    private static <T> a2<T> f(Comparator<T> paramComparator)
    {
      return a2.a(paramComparator).j();
    }
    
    Set<Map.Entry<K, V>> a()
    {
      return new a();
    }
    
    abstract Iterator<Map.Entry<K, V>> b();
    
    public Map.Entry<K, V> ceilingEntry(K paramK)
    {
      return d().floorEntry(paramK);
    }
    
    public K ceilingKey(K paramK)
    {
      return (K)d().floorKey(paramK);
    }
    
    public Comparator<? super K> comparator()
    {
      Comparator localComparator = this.c;
      Object localObject = localComparator;
      if (localComparator == null)
      {
        localComparator = d().comparator();
        localObject = localComparator;
        if (localComparator == null) {
          localObject = a2.g();
        }
        localObject = f((Comparator)localObject);
        this.c = ((Comparator)localObject);
      }
      return (Comparator<? super K>)localObject;
    }
    
    abstract NavigableMap<K, V> d();
    
    protected final Map<K, V> delegate()
    {
      return d();
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      return d().navigableKeySet();
    }
    
    public NavigableMap<K, V> descendingMap()
    {
      return d();
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet1 = this.d;
      Set localSet2 = localSet1;
      if (localSet1 == null)
      {
        localSet2 = a();
        this.d = localSet2;
      }
      return localSet2;
    }
    
    public Map.Entry<K, V> firstEntry()
    {
      return d().lastEntry();
    }
    
    public K firstKey()
    {
      return (K)d().lastKey();
    }
    
    public Map.Entry<K, V> floorEntry(K paramK)
    {
      return d().ceilingEntry(paramK);
    }
    
    public K floorKey(K paramK)
    {
      return (K)d().ceilingKey(paramK);
    }
    
    public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
    {
      return d().tailMap(paramK, paramBoolean).descendingMap();
    }
    
    public SortedMap<K, V> headMap(K paramK)
    {
      return headMap(paramK, false);
    }
    
    public Map.Entry<K, V> higherEntry(K paramK)
    {
      return d().lowerEntry(paramK);
    }
    
    public K higherKey(K paramK)
    {
      return (K)d().lowerKey(paramK);
    }
    
    public Set<K> keySet()
    {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry()
    {
      return d().firstEntry();
    }
    
    public K lastKey()
    {
      return (K)d().firstKey();
    }
    
    public Map.Entry<K, V> lowerEntry(K paramK)
    {
      return d().higherEntry(paramK);
    }
    
    public K lowerKey(K paramK)
    {
      return (K)d().higherKey(paramK);
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      NavigableSet localNavigableSet = this.f;
      Object localObject = localNavigableSet;
      if (localNavigableSet == null)
      {
        localObject = new q1.n(this);
        this.f = ((NavigableSet)localObject);
      }
      return (NavigableSet<K>)localObject;
    }
    
    public Map.Entry<K, V> pollFirstEntry()
    {
      return d().pollLastEntry();
    }
    
    public Map.Entry<K, V> pollLastEntry()
    {
      return d().pollFirstEntry();
    }
    
    public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return d().subMap(paramK2, paramBoolean2, paramK1, paramBoolean1).descendingMap();
    }
    
    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }
    
    public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
    {
      return d().headMap(paramK, paramBoolean).descendingMap();
    }
    
    public SortedMap<K, V> tailMap(K paramK)
    {
      return tailMap(paramK, true);
    }
    
    public String toString()
    {
      return standardToString();
    }
    
    public Collection<V> values()
    {
      return new q1.q(this);
    }
    
    class a
      extends q1.j<K, V>
    {
      a() {}
      
      Map<K, V> c()
      {
        return q1.h.this;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return q1.h.this.b();
      }
    }
  }
  
  private static abstract enum i
    implements h<Map.Entry<?, ?>, Object>
  {
    static
    {
      a locala = new a("KEY", 0);
      c = locala;
      b localb = new b("VALUE", 1);
      d = localb;
      f = new i[] { locala, localb };
    }
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      @NullableDecl
      public Object a(Map.Entry<?, ?> paramEntry)
      {
        return paramEntry.getKey();
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      @NullableDecl
      public Object a(Map.Entry<?, ?> paramEntry)
      {
        return paramEntry.getValue();
      }
    }
  }
  
  static abstract class j<K, V>
    extends u2.b<Map.Entry<K, V>>
  {
    abstract Map<K, V> c();
    
    public void clear()
    {
      c().clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        Map.Entry localEntry = (Map.Entry)paramObject;
        Object localObject = localEntry.getKey();
        paramObject = q1.v(c(), localObject);
        bool3 = bool2;
        if (k.a(paramObject, localEntry.getValue())) {
          if (paramObject == null)
          {
            bool3 = bool2;
            if (!c().containsKey(localObject)) {}
          }
          else
          {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public boolean isEmpty()
    {
      return c().isEmpty();
    }
    
    public boolean remove(Object paramObject)
    {
      if (contains(paramObject))
      {
        paramObject = (Map.Entry)paramObject;
        return c().keySet().remove(((Map.Entry)paramObject).getKey());
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.removeAll((Collection)n.o(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException) {}
      return u2.h(this, paramCollection.iterator());
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.retainAll((Collection)n.o(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = u2.e(paramCollection.size());
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Object localObject = paramCollection.next();
          if (contains(localObject)) {
            localHashSet.add(((Map.Entry)localObject).getKey());
          }
        }
        return c().keySet().retainAll(localHashSet);
      }
    }
    
    public int size()
    {
      return c().size();
    }
  }
  
  public static abstract interface k<K, V1, V2>
  {
    public abstract V2 a(@NullableDecl K paramK, @NullableDecl V1 paramV1);
  }
  
  static abstract class l<K, V>
    extends AbstractMap<K, V>
  {
    abstract Iterator<Map.Entry<K, V>> a();
    
    public void clear()
    {
      k1.d(a());
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      return new a();
    }
    
    class a
      extends q1.j<K, V>
    {
      a() {}
      
      Map<K, V> c()
      {
        return q1.l.this;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return q1.l.this.a();
      }
    }
  }
  
  static class m<K, V>
    extends u2.b<K>
  {
    @Weak
    final Map<K, V> c;
    
    m(Map<K, V> paramMap)
    {
      this.c = ((Map)n.o(paramMap));
    }
    
    Map<K, V> c()
    {
      return this.c;
    }
    
    public void clear()
    {
      c().clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return c().containsKey(paramObject);
    }
    
    public boolean isEmpty()
    {
      return c().isEmpty();
    }
    
    public Iterator<K> iterator()
    {
      return q1.l(c().entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (contains(paramObject))
      {
        c().remove(paramObject);
        return true;
      }
      return false;
    }
    
    public int size()
    {
      return c().size();
    }
  }
  
  static class n<K, V>
    extends q1.o<K, V>
    implements NavigableSet<K>
  {
    n(NavigableMap<K, V> paramNavigableMap)
    {
      super();
    }
    
    public K ceiling(K paramK)
    {
      return (K)g().ceilingKey(paramK);
    }
    
    public Iterator<K> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet()
    {
      return g().descendingKeySet();
    }
    
    public K floor(K paramK)
    {
      return (K)g().floorKey(paramK);
    }
    
    NavigableMap<K, V> g()
    {
      return (NavigableMap)this.c;
    }
    
    public NavigableSet<K> headSet(K paramK, boolean paramBoolean)
    {
      return g().headMap(paramK, paramBoolean).navigableKeySet();
    }
    
    public SortedSet<K> headSet(K paramK)
    {
      return headSet(paramK, false);
    }
    
    public K higher(K paramK)
    {
      return (K)g().higherKey(paramK);
    }
    
    public K lower(K paramK)
    {
      return (K)g().lowerKey(paramK);
    }
    
    public K pollFirst()
    {
      return (K)q1.m(g().pollFirstEntry());
    }
    
    public K pollLast()
    {
      return (K)q1.m(g().pollLastEntry());
    }
    
    public NavigableSet<K> subSet(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return g().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2).navigableKeySet();
    }
    
    public SortedSet<K> subSet(K paramK1, K paramK2)
    {
      return subSet(paramK1, true, paramK2, false);
    }
    
    public NavigableSet<K> tailSet(K paramK, boolean paramBoolean)
    {
      return g().tailMap(paramK, paramBoolean).navigableKeySet();
    }
    
    public SortedSet<K> tailSet(K paramK)
    {
      return tailSet(paramK, true);
    }
  }
  
  static class o<K, V>
    extends q1.m<K, V>
    implements SortedSet<K>
  {
    o(SortedMap<K, V> paramSortedMap)
    {
      super();
    }
    
    public Comparator<? super K> comparator()
    {
      return e().comparator();
    }
    
    SortedMap<K, V> e()
    {
      return (SortedMap)super.c();
    }
    
    public K first()
    {
      return (K)e().firstKey();
    }
    
    public SortedSet<K> headSet(K paramK)
    {
      return new o(e().headMap(paramK));
    }
    
    public K last()
    {
      return (K)e().lastKey();
    }
    
    public SortedSet<K> subSet(K paramK1, K paramK2)
    {
      return new o(e().subMap(paramK1, paramK2));
    }
    
    public SortedSet<K> tailSet(K paramK)
    {
      return new o(e().tailMap(paramK));
    }
  }
  
  static class p<K, V1, V2>
    extends q1.l<K, V2>
  {
    final Map<K, V1> c;
    final q1.k<? super K, ? super V1, V2> d;
    
    p(Map<K, V1> paramMap, q1.k<? super K, ? super V1, V2> paramk)
    {
      this.c = ((Map)n.o(paramMap));
      this.d = ((q1.k)n.o(paramk));
    }
    
    Iterator<Map.Entry<K, V2>> a()
    {
      return k1.x(this.c.entrySet().iterator(), q1.a(this.d));
    }
    
    public void clear()
    {
      this.c.clear();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.c.containsKey(paramObject);
    }
    
    public V2 get(Object paramObject)
    {
      Object localObject = this.c.get(paramObject);
      if ((localObject == null) && (!this.c.containsKey(paramObject))) {
        paramObject = null;
      } else {
        paramObject = this.d.a(paramObject, localObject);
      }
      return (V2)paramObject;
    }
    
    public Set<K> keySet()
    {
      return this.c.keySet();
    }
    
    public V2 remove(Object paramObject)
    {
      if (this.c.containsKey(paramObject)) {
        paramObject = this.d.a(paramObject, this.c.remove(paramObject));
      } else {
        paramObject = null;
      }
      return (V2)paramObject;
    }
    
    public int size()
    {
      return this.c.size();
    }
    
    public Collection<V2> values()
    {
      return new q1.q(this);
    }
  }
  
  static class q<K, V>
    extends AbstractCollection<V>
  {
    @Weak
    final Map<K, V> c;
    
    q(Map<K, V> paramMap)
    {
      this.c = ((Map)n.o(paramMap));
    }
    
    final Map<K, V> a()
    {
      return this.c;
    }
    
    public void clear()
    {
      a().clear();
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return a().containsValue(paramObject);
    }
    
    public boolean isEmpty()
    {
      return a().isEmpty();
    }
    
    public Iterator<V> iterator()
    {
      return q1.D(a().entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      try
      {
        boolean bool = super.remove(paramObject);
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Iterator localIterator = a().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (k.a(paramObject, localEntry.getValue()))
          {
            a().remove(localEntry.getKey());
            return true;
          }
        }
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.removeAll((Collection)n.o(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = u2.d();
        Iterator localIterator = a().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (paramCollection.contains(localEntry.getValue())) {
            localHashSet.add(localEntry.getKey());
          }
        }
        return a().keySet().removeAll(localHashSet);
      }
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.retainAll((Collection)n.o(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = u2.d();
        Iterator localIterator = a().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (paramCollection.contains(localEntry.getValue())) {
            localHashSet.add(localEntry.getKey());
          }
        }
        return a().keySet().retainAll(localHashSet);
      }
    }
    
    public int size()
    {
      return a().size();
    }
  }
  
  static abstract class r<K, V>
    extends AbstractMap<K, V>
  {
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> c;
    @MonotonicNonNullDecl
    private transient Set<K> d;
    @MonotonicNonNullDecl
    private transient Collection<V> f;
    
    abstract Set<Map.Entry<K, V>> a();
    
    Set<K> b()
    {
      return new q1.m(this);
    }
    
    Collection<V> c()
    {
      return new q1.q(this);
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet1 = this.c;
      Set localSet2 = localSet1;
      if (localSet1 == null)
      {
        localSet2 = a();
        this.c = localSet2;
      }
      return localSet2;
    }
    
    public Set<K> keySet()
    {
      Set localSet1 = this.d;
      Set localSet2 = localSet1;
      if (localSet1 == null)
      {
        localSet2 = b();
        this.d = localSet2;
      }
      return localSet2;
    }
    
    public Collection<V> values()
    {
      Collection localCollection1 = this.f;
      Collection localCollection2 = localCollection1;
      if (localCollection1 == null)
      {
        localCollection2 = c();
        this.f = localCollection2;
      }
      return localCollection2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\q1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */