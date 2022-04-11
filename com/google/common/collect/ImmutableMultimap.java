package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableMultimap<K, V>
  extends s<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
  final transient int size;
  
  ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> paramImmutableMap, int paramInt)
  {
    this.map = paramImmutableMap;
    this.size = paramInt;
  }
  
  public static <K, V> c<K, V> builder()
  {
    return new c();
  }
  
  public static <K, V> ImmutableMultimap<K, V> copyOf(r1<? extends K, ? extends V> paramr1)
  {
    if ((paramr1 instanceof ImmutableMultimap))
    {
      ImmutableMultimap localImmutableMultimap = (ImmutableMultimap)paramr1;
      if (!localImmutableMultimap.isPartialView()) {
        return localImmutableMultimap;
      }
    }
    return ImmutableListMultimap.copyOf(paramr1);
  }
  
  public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return ImmutableListMultimap.copyOf(paramIterable);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of()
  {
    return ImmutableListMultimap.of();
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK, V paramV)
  {
    return ImmutableListMultimap.of(paramK, paramV);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5);
  }
  
  public ImmutableMap<K, Collection<V>> asMap()
  {
    return this.map;
  }
  
  @Deprecated
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (super.containsValue(paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    throw new AssertionError("should never be called");
  }
  
  ImmutableCollection<Map.Entry<K, V>> createEntries()
  {
    return new d(this);
  }
  
  Set<K> createKeySet()
  {
    throw new AssertionError("unreachable");
  }
  
  ImmutableMultiset<K> createKeys()
  {
    return new f();
  }
  
  ImmutableCollection<V> createValues()
  {
    return new h(this);
  }
  
  public ImmutableCollection<Map.Entry<K, V>> entries()
  {
    return (ImmutableCollection)super.entries();
  }
  
  j3<Map.Entry<K, V>> entryIterator()
  {
    return new a();
  }
  
  public abstract ImmutableCollection<V> get(K paramK);
  
  public abstract ImmutableMultimap<V, K> inverse();
  
  boolean isPartialView()
  {
    return this.map.isPartialView();
  }
  
  public ImmutableSet<K> keySet()
  {
    return this.map.keySet();
  }
  
  public ImmutableMultiset<K> keys()
  {
    return (ImmutableMultiset)super.keys();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean putAll(r1<? extends K, ? extends V> paramr1)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableCollection<V> removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableCollection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.size;
  }
  
  j3<V> valueIterator()
  {
    return new b();
  }
  
  public ImmutableCollection<V> values()
  {
    return (ImmutableCollection)super.values();
  }
  
  class a
    extends j3<Map.Entry<K, V>>
  {
    final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> c = ImmutableMultimap.this.map.entrySet().iterator();
    K d = null;
    Iterator<V> f = k1.h();
    
    a() {}
    
    public Map.Entry<K, V> a()
    {
      if (!this.f.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)this.c.next();
        this.d = localEntry.getKey();
        this.f = ((ImmutableCollection)localEntry.getValue()).iterator();
      }
      return q1.i(this.d, this.f.next());
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if ((!this.f.hasNext()) && (!this.c.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  class b
    extends j3<V>
  {
    Iterator<? extends ImmutableCollection<V>> c = ImmutableMultimap.this.map.values().iterator();
    Iterator<V> d = k1.h();
    
    b() {}
    
    public boolean hasNext()
    {
      boolean bool;
      if ((!this.d.hasNext()) && (!this.c.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public V next()
    {
      if (!this.d.hasNext()) {
        this.d = ((ImmutableCollection)this.c.next()).iterator();
      }
      return (V)this.d.next();
    }
  }
  
  public static class c<K, V>
  {
    Map<K, Collection<V>> a = c2.h();
    @MonotonicNonNullDecl
    Comparator<? super K> b;
    @MonotonicNonNullDecl
    Comparator<? super V> c;
    
    public ImmutableMultimap<K, V> a()
    {
      Set localSet = this.a.entrySet();
      Comparator localComparator = this.b;
      Object localObject = localSet;
      if (localComparator != null) {
        localObject = a2.a(localComparator).h().b(localSet);
      }
      return ImmutableListMultimap.fromMapEntries((Collection)localObject, this.c);
    }
    
    Collection<V> b()
    {
      return new ArrayList();
    }
    
    @CanIgnoreReturnValue
    public c<K, V> c(K paramK, V paramV)
    {
      v.a(paramK, paramV);
      Object localObject1 = (Collection)this.a.get(paramK);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = this.a;
        localObject2 = b();
        ((Map)localObject1).put(paramK, localObject2);
      }
      ((Collection)localObject2).add(paramV);
      return this;
    }
    
    @CanIgnoreReturnValue
    public c<K, V> d(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      return c(paramEntry.getKey(), paramEntry.getValue());
    }
    
    @CanIgnoreReturnValue
    public c<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        d((Map.Entry)paramIterable.next());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public c<K, V> f(K paramK, Iterable<? extends V> paramIterable)
    {
      if (paramK != null)
      {
        Collection localCollection = (Collection)this.a.get(paramK);
        Object localObject;
        if (localCollection != null)
        {
          localObject = paramIterable.iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramIterable = ((Iterator)localObject).next();
            v.a(paramK, paramIterable);
            localCollection.add(paramIterable);
          }
          return this;
        }
        paramIterable = paramIterable.iterator();
        if (!paramIterable.hasNext()) {
          return this;
        }
        localCollection = b();
        while (paramIterable.hasNext())
        {
          localObject = paramIterable.next();
          v.a(paramK, localObject);
          localCollection.add(localObject);
        }
        this.a.put(paramK, localCollection);
        return this;
      }
      paramK = new StringBuilder();
      paramK.append("null key in entry: null=");
      paramK.append(j1.n(paramIterable));
      throw new NullPointerException(paramK.toString());
    }
    
    @CanIgnoreReturnValue
    public c<K, V> g(K paramK, V... paramVarArgs)
    {
      return f(paramK, Arrays.asList(paramVarArgs));
    }
  }
  
  private static class d<K, V>
    extends ImmutableCollection<Map.Entry<K, V>>
  {
    @Weak
    final ImmutableMultimap<K, V> c;
    
    d(ImmutableMultimap<K, V> paramImmutableMultimap)
    {
      this.c = paramImmutableMultimap;
    }
    
    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        return this.c.containsEntry(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
      }
      return false;
    }
    
    boolean isPartialView()
    {
      return this.c.isPartialView();
    }
    
    public j3<Map.Entry<K, V>> iterator()
    {
      return this.c.entryIterator();
    }
    
    public int size()
    {
      return this.c.size();
    }
  }
  
  static class e
  {
    static final r2.b<ImmutableMultimap> a = r2.a(ImmutableMultimap.class, "map");
    static final r2.b<ImmutableMultimap> b = r2.a(ImmutableMultimap.class, "size");
  }
  
  class f
    extends ImmutableMultiset<K>
  {
    f() {}
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return ImmutableMultimap.this.containsKey(paramObject);
    }
    
    public int count(@NullableDecl Object paramObject)
    {
      paramObject = (Collection)ImmutableMultimap.this.map.get(paramObject);
      int i;
      if (paramObject == null) {
        i = 0;
      } else {
        i = ((Collection)paramObject).size();
      }
      return i;
    }
    
    public ImmutableSet<K> elementSet()
    {
      return ImmutableMultimap.this.keySet();
    }
    
    u1.a<K> getEntry(int paramInt)
    {
      Map.Entry localEntry = (Map.Entry)ImmutableMultimap.this.map.entrySet().asList().get(paramInt);
      return v1.g(localEntry.getKey(), ((Collection)localEntry.getValue()).size());
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return ImmutableMultimap.this.size();
    }
    
    Object writeReplace()
    {
      return new ImmutableMultimap.g(ImmutableMultimap.this);
    }
  }
  
  private static final class g
    implements Serializable
  {
    final ImmutableMultimap<?, ?> c;
    
    g(ImmutableMultimap<?, ?> paramImmutableMultimap)
    {
      this.c = paramImmutableMultimap;
    }
  }
  
  private static final class h<K, V>
    extends ImmutableCollection<V>
  {
    @Weak
    private final transient ImmutableMultimap<K, V> c;
    
    h(ImmutableMultimap<K, V> paramImmutableMultimap)
    {
      this.c = paramImmutableMultimap;
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return this.c.containsValue(paramObject);
    }
    
    int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
    {
      j3 localj3 = this.c.map.values().iterator();
      while (localj3.hasNext()) {
        paramInt = ((ImmutableCollection)localj3.next()).copyIntoArray(paramArrayOfObject, paramInt);
      }
      return paramInt;
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public j3<V> iterator()
    {
      return this.c.valueIterator();
    }
    
    public int size()
    {
      return this.c.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */