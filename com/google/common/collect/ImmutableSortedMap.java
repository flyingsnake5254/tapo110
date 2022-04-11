package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ImmutableSortedMap<K, V>
  extends f1<K, V>
  implements NavigableMap<K, V>
{
  private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(a2.g()), ImmutableList.of());
  private static final Comparator<Comparable> NATURAL_ORDER = ;
  private static final long serialVersionUID = 0L;
  private transient ImmutableSortedMap<K, V> descendingMap;
  private final transient n2<K> keySet;
  private final transient ImmutableList<V> valueList;
  
  ImmutableSortedMap(n2<K> paramn2, ImmutableList<V> paramImmutableList)
  {
    this(paramn2, paramImmutableList, null);
  }
  
  ImmutableSortedMap(n2<K> paramn2, ImmutableList<V> paramImmutableList, ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    this.keySet = paramn2;
    this.valueList = paramImmutableList;
    this.descendingMap = paramImmutableSortedMap;
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return copyOf(paramIterable, (a2)NATURAL_ORDER);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable, Comparator<? super K> paramComparator)
  {
    return fromEntries((Comparator)n.o(paramComparator), false, paramIterable);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    return copyOfInternal(paramMap, (a2)NATURAL_ORDER);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator)
  {
    return copyOfInternal(paramMap, (Comparator)n.o(paramComparator));
  }
  
  private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator)
  {
    boolean bool1 = paramMap instanceof SortedMap;
    boolean bool2 = false;
    boolean bool3 = bool2;
    Object localObject;
    if (bool1)
    {
      localObject = ((SortedMap)paramMap).comparator();
      if (localObject == null)
      {
        bool3 = bool2;
        if (paramComparator == NATURAL_ORDER) {
          bool3 = true;
        }
      }
      else
      {
        bool3 = paramComparator.equals(localObject);
      }
    }
    if ((bool3) && ((paramMap instanceof ImmutableSortedMap)))
    {
      localObject = (ImmutableSortedMap)paramMap;
      if (!((ImmutableSortedMap)localObject).isPartialView()) {
        return (ImmutableSortedMap<K, V>)localObject;
      }
    }
    return fromEntries(paramComparator, bool3, paramMap.entrySet());
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> paramSortedMap)
  {
    Object localObject1 = paramSortedMap.comparator();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = NATURAL_ORDER;
    }
    if ((paramSortedMap instanceof ImmutableSortedMap))
    {
      localObject1 = (ImmutableSortedMap)paramSortedMap;
      if (!((ImmutableSortedMap)localObject1).isPartialView()) {
        return (ImmutableSortedMap<K, V>)localObject1;
      }
    }
    return fromEntries((Comparator)localObject2, true, paramSortedMap.entrySet());
  }
  
  static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> paramComparator)
  {
    if (a2.g().equals(paramComparator)) {
      return of();
    }
    return new ImmutableSortedMap(ImmutableSortedSet.emptySet(paramComparator), ImmutableList.of());
  }
  
  private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> paramComparator, boolean paramBoolean, Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    paramIterable = (Map.Entry[])j1.m(paramIterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
    return fromEntries(paramComparator, paramBoolean, paramIterable, paramIterable.length);
  }
  
  private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> paramComparator, boolean paramBoolean, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = 0;
      if (paramInt != 1)
      {
        Object[] arrayOfObject1 = new Object[paramInt];
        Object[] arrayOfObject2 = new Object[paramInt];
        Object localObject2;
        if (paramBoolean) {
          while (i < paramInt)
          {
            localObject1 = paramArrayOfEntry[i].getKey();
            localObject2 = paramArrayOfEntry[i].getValue();
            v.a(localObject1, localObject2);
            arrayOfObject1[i] = localObject1;
            arrayOfObject2[i] = localObject2;
            i++;
          }
        }
        Arrays.sort(paramArrayOfEntry, 0, paramInt, new a(paramComparator));
        Object localObject1 = paramArrayOfEntry[0].getKey();
        arrayOfObject1[0] = localObject1;
        arrayOfObject2[0] = paramArrayOfEntry[0].getValue();
        v.a(arrayOfObject1[0], arrayOfObject2[0]);
        i = 1;
        while (i < paramInt)
        {
          localObject2 = paramArrayOfEntry[i].getKey();
          Object localObject3 = paramArrayOfEntry[i].getValue();
          v.a(localObject2, localObject3);
          arrayOfObject1[i] = localObject2;
          arrayOfObject2[i] = localObject3;
          if (paramComparator.compare(localObject1, localObject2) != 0) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          ImmutableMap.checkNoConflict(paramBoolean, "key", paramArrayOfEntry[(i - 1)], paramArrayOfEntry[i]);
          i++;
          localObject1 = localObject2;
        }
        return new ImmutableSortedMap(new n2(ImmutableList.asImmutableList(arrayOfObject1), paramComparator), ImmutableList.asImmutableList(arrayOfObject2));
      }
      return of(paramComparator, paramArrayOfEntry[0].getKey(), paramArrayOfEntry[0].getValue());
    }
    return emptyMap(paramComparator);
  }
  
  private ImmutableSortedMap<K, V> getSubMap(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 == paramInt2) {
      return emptyMap(comparator());
    }
    return new ImmutableSortedMap(this.keySet.a(paramInt1, paramInt2), this.valueList.subList(paramInt1, paramInt2));
  }
  
  public static <K extends Comparable<?>, V> c<K, V> naturalOrder()
  {
    return new c(a2.g());
  }
  
  public static <K, V> ImmutableSortedMap<K, V> of()
  {
    return NATURAL_EMPTY_MAP;
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK, V paramV)
  {
    return of(a2.g(), paramK, paramV);
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return ofEntries(new Map.Entry[] { ImmutableMap.entryOf(paramK1, paramV1), ImmutableMap.entryOf(paramK2, paramV2) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return ofEntries(new Map.Entry[] { ImmutableMap.entryOf(paramK1, paramV1), ImmutableMap.entryOf(paramK2, paramV2), ImmutableMap.entryOf(paramK3, paramV3) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return ofEntries(new Map.Entry[] { ImmutableMap.entryOf(paramK1, paramV1), ImmutableMap.entryOf(paramK2, paramV2), ImmutableMap.entryOf(paramK3, paramV3), ImmutableMap.entryOf(paramK4, paramV4) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return ofEntries(new Map.Entry[] { ImmutableMap.entryOf(paramK1, paramV1), ImmutableMap.entryOf(paramK2, paramV2), ImmutableMap.entryOf(paramK3, paramV3), ImmutableMap.entryOf(paramK4, paramV4), ImmutableMap.entryOf(paramK5, paramV5) });
  }
  
  private static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> paramComparator, K paramK, V paramV)
  {
    return new ImmutableSortedMap(new n2(ImmutableList.of(paramK), (Comparator)n.o(paramComparator)), ImmutableList.of(paramV));
  }
  
  private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<K, V>... paramVarArgs)
  {
    return fromEntries(a2.g(), false, paramVarArgs, paramVarArgs.length);
  }
  
  public static <K, V> c<K, V> orderedBy(Comparator<K> paramComparator)
  {
    return new c(paramComparator);
  }
  
  public static <K extends Comparable<?>, V> c<K, V> reverseOrder()
  {
    return new c(a2.g().j());
  }
  
  public Map.Entry<K, V> ceilingEntry(K paramK)
  {
    return tailMap(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK)
  {
    return (K)q1.m(ceilingEntry(paramK));
  }
  
  public Comparator<? super K> comparator()
  {
    return keySet().comparator();
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    Object localObject;
    if (isEmpty()) {
      localObject = ImmutableSet.of();
    } else {
      localObject = new b();
    }
    return (ImmutableSet<Map.Entry<K, V>>)localObject;
  }
  
  ImmutableSet<K> createKeySet()
  {
    throw new AssertionError("should never be called");
  }
  
  ImmutableCollection<V> createValues()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSortedSet<K> descendingKeySet()
  {
    return this.keySet.descendingSet();
  }
  
  public ImmutableSortedMap<K, V> descendingMap()
  {
    ImmutableSortedMap localImmutableSortedMap1 = this.descendingMap;
    ImmutableSortedMap localImmutableSortedMap2 = localImmutableSortedMap1;
    if (localImmutableSortedMap1 == null)
    {
      if (isEmpty()) {
        return emptyMap(a2.a(comparator()).j());
      }
      localImmutableSortedMap2 = new ImmutableSortedMap((n2)this.keySet.descendingSet(), this.valueList.reverse(), this);
    }
    return localImmutableSortedMap2;
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    return super.entrySet();
  }
  
  public Map.Entry<K, V> firstEntry()
  {
    Map.Entry localEntry;
    if (isEmpty()) {
      localEntry = null;
    } else {
      localEntry = (Map.Entry)entrySet().asList().get(0);
    }
    return localEntry;
  }
  
  public K firstKey()
  {
    return (K)keySet().first();
  }
  
  public Map.Entry<K, V> floorEntry(K paramK)
  {
    return headMap(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK)
  {
    return (K)q1.m(floorEntry(paramK));
  }
  
  public V get(@NullableDecl Object paramObject)
  {
    int i = this.keySet.indexOf(paramObject);
    if (i == -1) {
      paramObject = null;
    } else {
      paramObject = this.valueList.get(i);
    }
    return (V)paramObject;
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK)
  {
    return headMap(paramK, false);
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK, boolean paramBoolean)
  {
    return getSubMap(0, this.keySet.b(n.o(paramK), paramBoolean));
  }
  
  public Map.Entry<K, V> higherEntry(K paramK)
  {
    return tailMap(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK)
  {
    return (K)q1.m(higherEntry(paramK));
  }
  
  boolean isPartialView()
  {
    boolean bool;
    if ((!this.keySet.isPartialView()) && (!this.valueList.isPartialView())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public ImmutableSortedSet<K> keySet()
  {
    return this.keySet;
  }
  
  public Map.Entry<K, V> lastEntry()
  {
    Map.Entry localEntry;
    if (isEmpty()) {
      localEntry = null;
    } else {
      localEntry = (Map.Entry)entrySet().asList().get(size() - 1);
    }
    return localEntry;
  }
  
  public K lastKey()
  {
    return (K)keySet().last();
  }
  
  public Map.Entry<K, V> lowerEntry(K paramK)
  {
    return headMap(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK)
  {
    return (K)q1.m(lowerEntry(paramK));
  }
  
  public ImmutableSortedSet<K> navigableKeySet()
  {
    return this.keySet;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final Map.Entry<K, V> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final Map.Entry<K, V> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.valueList.size();
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return subMap(paramK1, true, paramK2, false);
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
  {
    n.o(paramK1);
    n.o(paramK2);
    boolean bool;
    if (comparator().compare(paramK1, paramK2) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.k(bool, "expected fromKey <= toKey but %s > %s", paramK1, paramK2);
    return headMap(paramK2, paramBoolean2).tailMap(paramK1, paramBoolean1);
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK)
  {
    return tailMap(paramK, true);
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK, boolean paramBoolean)
  {
    return getSubMap(this.keySet.d(n.o(paramK), paramBoolean), size());
  }
  
  public ImmutableCollection<V> values()
  {
    return this.valueList;
  }
  
  Object writeReplace()
  {
    return new d(this);
  }
  
  static final class a
    implements Comparator<Map.Entry<K, V>>
  {
    a(Comparator paramComparator) {}
    
    public int a(Map.Entry<K, V> paramEntry1, Map.Entry<K, V> paramEntry2)
    {
      return this.c.compare(paramEntry1.getKey(), paramEntry2.getKey());
    }
  }
  
  class b
    extends b1<K, V>
  {
    b() {}
    
    ImmutableMap<K, V> a()
    {
      return ImmutableSortedMap.this;
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList()
    {
      return new a();
    }
    
    public j3<Map.Entry<K, V>> iterator()
    {
      return asList().iterator();
    }
    
    class a
      extends ImmutableList<Map.Entry<K, V>>
    {
      a() {}
      
      public Map.Entry<K, V> a(int paramInt)
      {
        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(paramInt), ImmutableSortedMap.this.valueList.get(paramInt));
      }
      
      boolean isPartialView()
      {
        return true;
      }
      
      public int size()
      {
        return ImmutableSortedMap.this.size();
      }
    }
  }
  
  public static class c<K, V>
    extends ImmutableMap.b<K, V>
  {
    private transient Object[] e;
    private transient Object[] f;
    private final Comparator<? super K> g;
    
    public c(Comparator<? super K> paramComparator)
    {
      this(paramComparator, 4);
    }
    
    private c(Comparator<? super K> paramComparator, int paramInt)
    {
      this.g = ((Comparator)n.o(paramComparator));
      this.e = new Object[paramInt];
      this.f = new Object[paramInt];
    }
    
    private void b(int paramInt)
    {
      Object[] arrayOfObject = this.e;
      if (paramInt > arrayOfObject.length)
      {
        paramInt = ImmutableCollection.b.e(arrayOfObject.length, paramInt);
        this.e = Arrays.copyOf(this.e, paramInt);
        this.f = Arrays.copyOf(this.f, paramInt);
      }
    }
    
    public ImmutableSortedMap<K, V> h()
    {
      int i = this.c;
      if (i != 0)
      {
        int j = 0;
        if (i != 1)
        {
          Object[] arrayOfObject = Arrays.copyOf(this.e, i);
          Arrays.sort(arrayOfObject, this.g);
          Object localObject = new Object[this.c];
          while (j < this.c)
          {
            if (j > 0)
            {
              Comparator localComparator = this.g;
              i = j - 1;
              if (localComparator.compare(arrayOfObject[i], arrayOfObject[j]) == 0)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("keys required to be distinct but compared as equal: ");
                ((StringBuilder)localObject).append(arrayOfObject[i]);
                ((StringBuilder)localObject).append(" and ");
                ((StringBuilder)localObject).append(arrayOfObject[j]);
                throw new IllegalArgumentException(((StringBuilder)localObject).toString());
              }
            }
            localObject[Arrays.binarySearch(arrayOfObject, this.e[j], this.g)] = this.f[j];
            j++;
          }
          return new ImmutableSortedMap(new n2(ImmutableList.asImmutableList(arrayOfObject), this.g), ImmutableList.asImmutableList((Object[])localObject));
        }
        return ImmutableSortedMap.of(this.g, this.e[0], this.f[0]);
      }
      return ImmutableSortedMap.emptyMap(this.g);
    }
    
    @CanIgnoreReturnValue
    public c<K, V> i(K paramK, V paramV)
    {
      b(this.c + 1);
      v.a(paramK, paramV);
      Object[] arrayOfObject = this.e;
      int i = this.c;
      arrayOfObject[i] = paramK;
      this.f[i] = paramV;
      this.c = (i + 1);
      return this;
    }
    
    @CanIgnoreReturnValue
    public c<K, V> j(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      super.d(paramEntry);
      return this;
    }
    
    @CanIgnoreReturnValue
    public c<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      super.e(paramIterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public c<K, V> l(Map<? extends K, ? extends V> paramMap)
    {
      super.f(paramMap);
      return this;
    }
  }
  
  private static class d
    extends ImmutableMap.e
  {
    private final Comparator<Object> f;
    
    d(ImmutableSortedMap<?, ?> paramImmutableSortedMap)
    {
      super();
      this.f = paramImmutableSortedMap.comparator();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */