package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableMap<K, V>
  implements Map<K, V>, Serializable
{
  static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
  @LazyInit
  private transient ImmutableSet<Map.Entry<K, V>> entrySet;
  @LazyInit
  @RetainedWith
  private transient ImmutableSet<K> keySet;
  @LazyInit
  private transient ImmutableSetMultimap<K, V> multimapView;
  @LazyInit
  @RetainedWith
  private transient ImmutableCollection<V> values;
  
  public static <K, V> b<K, V> builder()
  {
    return new b();
  }
  
  public static <K, V> b<K, V> builderWithExpectedSize(int paramInt)
  {
    v.b(paramInt, "expectedSize");
    return new b(paramInt);
  }
  
  static void checkNoConflict(boolean paramBoolean, String paramString, Map.Entry<?, ?> paramEntry1, Map.Entry<?, ?> paramEntry2)
  {
    if (paramBoolean) {
      return;
    }
    throw conflictException(paramString, paramEntry1, paramEntry2);
  }
  
  static IllegalArgumentException conflictException(String paramString, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Multiple entries with same ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append(" and ");
    localStringBuilder.append(paramObject2);
    return new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    int i;
    if ((paramIterable instanceof Collection)) {
      i = ((Collection)paramIterable).size();
    } else {
      i = 4;
    }
    b localb = new b(i);
    localb.e(paramIterable);
    return localb.a();
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    if (((paramMap instanceof ImmutableMap)) && (!(paramMap instanceof SortedMap)))
    {
      ImmutableMap localImmutableMap = (ImmutableMap)paramMap;
      if (!localImmutableMap.isPartialView()) {
        return localImmutableMap;
      }
    }
    return copyOf(paramMap.entrySet());
  }
  
  static <K, V> Map.Entry<K, V> entryOf(K paramK, V paramV)
  {
    v.a(paramK, paramV);
    return new AbstractMap.SimpleImmutableEntry(paramK, paramV);
  }
  
  public static <K, V> ImmutableMap<K, V> of()
  {
    return j2.c;
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK, V paramV)
  {
    v.a(paramK, paramV);
    return j2.a(1, new Object[] { paramK, paramV });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    return j2.a(2, new Object[] { paramK1, paramV1, paramK2, paramV2 });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    v.a(paramK3, paramV3);
    return j2.a(3, new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3 });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    v.a(paramK3, paramV3);
    v.a(paramK4, paramV4);
    return j2.a(4, new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4 });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    v.a(paramK3, paramV3);
    v.a(paramK4, paramV4);
    v.a(paramK5, paramV5);
    return j2.a(5, new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5 });
  }
  
  public ImmutableSetMultimap<K, V> asMultimap()
  {
    if (isEmpty()) {
      return ImmutableSetMultimap.of();
    }
    ImmutableSetMultimap localImmutableSetMultimap1 = this.multimapView;
    ImmutableSetMultimap localImmutableSetMultimap2 = localImmutableSetMultimap1;
    if (localImmutableSetMultimap1 == null)
    {
      localImmutableSetMultimap2 = new ImmutableSetMultimap(new d(null), size(), null);
      this.multimapView = localImmutableSetMultimap2;
    }
    return localImmutableSetMultimap2;
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (get(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();
  
  abstract ImmutableSet<K> createKeySet();
  
  abstract ImmutableCollection<V> createValues();
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    ImmutableSet localImmutableSet1 = this.entrySet;
    ImmutableSet localImmutableSet2 = localImmutableSet1;
    if (localImmutableSet1 == null)
    {
      localImmutableSet2 = createEntrySet();
      this.entrySet = localImmutableSet2;
    }
    return localImmutableSet2;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return q1.h(this, paramObject);
  }
  
  public abstract V get(@NullableDecl Object paramObject);
  
  public final V getOrDefault(@NullableDecl Object paramObject, @NullableDecl V paramV)
  {
    paramObject = get(paramObject);
    if (paramObject != null) {
      paramV = (V)paramObject;
    }
    return paramV;
  }
  
  public int hashCode()
  {
    return u2.b(entrySet());
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isHashCodeFast()
  {
    return false;
  }
  
  abstract boolean isPartialView();
  
  j3<K> keyIterator()
  {
    return new a(entrySet().iterator());
  }
  
  public ImmutableSet<K> keySet()
  {
    ImmutableSet localImmutableSet1 = this.keySet;
    ImmutableSet localImmutableSet2 = localImmutableSet1;
    if (localImmutableSet1 == null)
    {
      localImmutableSet2 = createKeySet();
      this.keySet = localImmutableSet2;
    }
    return localImmutableSet2;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return q1.x(this);
  }
  
  public ImmutableCollection<V> values()
  {
    ImmutableCollection localImmutableCollection1 = this.values;
    ImmutableCollection localImmutableCollection2 = localImmutableCollection1;
    if (localImmutableCollection1 == null)
    {
      localImmutableCollection2 = createValues();
      this.values = localImmutableCollection2;
    }
    return localImmutableCollection2;
  }
  
  Object writeReplace()
  {
    return new e(this);
  }
  
  class a
    extends j3<K>
  {
    a(j3 paramj3) {}
    
    public boolean hasNext()
    {
      return this.c.hasNext();
    }
    
    public K next()
    {
      return (K)((Map.Entry)this.c.next()).getKey();
    }
  }
  
  public static class b<K, V>
  {
    @MonotonicNonNullDecl
    Comparator<? super V> a;
    Object[] b;
    int c;
    boolean d;
    
    public b()
    {
      this(4);
    }
    
    b(int paramInt)
    {
      this.b = new Object[paramInt * 2];
      this.c = 0;
      this.d = false;
    }
    
    private void b(int paramInt)
    {
      paramInt *= 2;
      Object[] arrayOfObject = this.b;
      if (paramInt > arrayOfObject.length)
      {
        this.b = Arrays.copyOf(arrayOfObject, ImmutableCollection.b.e(arrayOfObject.length, paramInt));
        this.d = false;
      }
    }
    
    public ImmutableMap<K, V> a()
    {
      g();
      this.d = true;
      return j2.a(this.c, this.b);
    }
    
    @CanIgnoreReturnValue
    public b<K, V> c(K paramK, V paramV)
    {
      b(this.c + 1);
      v.a(paramK, paramV);
      Object[] arrayOfObject = this.b;
      int i = this.c;
      arrayOfObject[(i * 2)] = paramK;
      arrayOfObject[(i * 2 + 1)] = paramV;
      this.c = (i + 1);
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<K, V> d(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      return c(paramEntry.getKey(), paramEntry.getValue());
    }
    
    @CanIgnoreReturnValue
    public b<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      if ((paramIterable instanceof Collection)) {
        b(this.c + ((Collection)paramIterable).size());
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        d((Map.Entry)paramIterable.next());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<K, V> f(Map<? extends K, ? extends V> paramMap)
    {
      return e(paramMap.entrySet());
    }
    
    void g()
    {
      if (this.a != null)
      {
        if (this.d) {
          this.b = Arrays.copyOf(this.b, this.c * 2);
        }
        Map.Entry[] arrayOfEntry = new Map.Entry[this.c];
        int i = 0;
        int k;
        Object[] arrayOfObject;
        for (int j = 0;; j++)
        {
          k = this.c;
          if (j >= k) {
            break;
          }
          arrayOfObject = this.b;
          k = j * 2;
          arrayOfEntry[j] = new AbstractMap.SimpleImmutableEntry(arrayOfObject[k], arrayOfObject[(k + 1)]);
        }
        Arrays.sort(arrayOfEntry, 0, k, a2.a(this.a).i(q1.C()));
        for (j = i; j < this.c; j++)
        {
          arrayOfObject = this.b;
          i = j * 2;
          arrayOfObject[i] = arrayOfEntry[j].getKey();
          this.b[(i + 1)] = arrayOfEntry[j].getValue();
        }
      }
    }
  }
  
  static abstract class c<K, V>
    extends ImmutableMap<K, V>
  {
    abstract j3<Map.Entry<K, V>> a();
    
    ImmutableSet<Map.Entry<K, V>> createEntrySet()
    {
      return new a();
    }
    
    ImmutableSet<K> createKeySet()
    {
      return new c1(this);
    }
    
    ImmutableCollection<V> createValues()
    {
      return new d1(this);
    }
    
    class a
      extends b1<K, V>
    {
      a() {}
      
      ImmutableMap<K, V> a()
      {
        return ImmutableMap.c.this;
      }
      
      public j3<Map.Entry<K, V>> iterator()
      {
        return ImmutableMap.c.this.a();
      }
    }
  }
  
  private final class d
    extends ImmutableMap.c<K, ImmutableSet<V>>
  {
    private d() {}
    
    j3<Map.Entry<K, ImmutableSet<V>>> a()
    {
      return new a(ImmutableMap.this.entrySet().iterator());
    }
    
    public ImmutableSet<V> b(@NullableDecl Object paramObject)
    {
      paramObject = ImmutableMap.this.get(paramObject);
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = ImmutableSet.of(paramObject);
      }
      return (ImmutableSet<V>)paramObject;
    }
    
    public boolean containsKey(@NullableDecl Object paramObject)
    {
      return ImmutableMap.this.containsKey(paramObject);
    }
    
    ImmutableSet<K> createKeySet()
    {
      return ImmutableMap.this.keySet();
    }
    
    public int hashCode()
    {
      return ImmutableMap.this.hashCode();
    }
    
    boolean isHashCodeFast()
    {
      return ImmutableMap.this.isHashCodeFast();
    }
    
    boolean isPartialView()
    {
      return ImmutableMap.this.isPartialView();
    }
    
    public int size()
    {
      return ImmutableMap.this.size();
    }
    
    class a
      extends j3<Map.Entry<K, ImmutableSet<V>>>
    {
      a(Iterator paramIterator) {}
      
      public Map.Entry<K, ImmutableSet<V>> a()
      {
        return new a((Map.Entry)this.c.next());
      }
      
      public boolean hasNext()
      {
        return this.c.hasNext();
      }
      
      class a
        extends g<K, ImmutableSet<V>>
      {
        a(Map.Entry paramEntry) {}
        
        public ImmutableSet<V> g()
        {
          return ImmutableSet.of(this.c.getValue());
        }
        
        public K getKey()
        {
          return (K)this.c.getKey();
        }
      }
    }
  }
  
  static class e
    implements Serializable
  {
    private final Object[] c;
    private final Object[] d;
    
    e(ImmutableMap<?, ?> paramImmutableMap)
    {
      this.c = new Object[paramImmutableMap.size()];
      this.d = new Object[paramImmutableMap.size()];
      j3 localj3 = paramImmutableMap.entrySet().iterator();
      for (int i = 0; localj3.hasNext(); i++)
      {
        paramImmutableMap = (Map.Entry)localj3.next();
        this.c[i] = paramImmutableMap.getKey();
        this.d[i] = paramImmutableMap.getValue();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */