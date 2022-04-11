package com.google.common.collect;

import com.google.common.base.j;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableSetMultimap<K, V>
  extends ImmutableMultimap<K, V>
  implements s2<K, V>
{
  private static final long serialVersionUID = 0L;
  private final transient ImmutableSet<V> emptySet;
  @MonotonicNonNullDecl
  private transient ImmutableSet<Map.Entry<K, V>> entries;
  @LazyInit
  @MonotonicNonNullDecl
  @RetainedWith
  private transient ImmutableSetMultimap<V, K> inverse;
  
  ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> paramImmutableMap, int paramInt, @NullableDecl Comparator<? super V> paramComparator)
  {
    super(paramImmutableMap, paramInt);
    this.emptySet = emptySet(paramComparator);
  }
  
  public static <K, V> a<K, V> builder()
  {
    return new a();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> copyOf(r1<? extends K, ? extends V> paramr1)
  {
    return copyOf(paramr1, null);
  }
  
  private static <K, V> ImmutableSetMultimap<K, V> copyOf(r1<? extends K, ? extends V> paramr1, Comparator<? super V> paramComparator)
  {
    n.o(paramr1);
    if ((paramr1.isEmpty()) && (paramComparator == null)) {
      return of();
    }
    if ((paramr1 instanceof ImmutableSetMultimap))
    {
      ImmutableSetMultimap localImmutableSetMultimap = (ImmutableSetMultimap)paramr1;
      if (!localImmutableSetMultimap.isPartialView()) {
        return localImmutableSetMultimap;
      }
    }
    return fromMapEntries(paramr1.asMap().entrySet(), paramComparator);
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return new a().k(paramIterable).h();
  }
  
  private static <V> ImmutableSet<V> emptySet(@NullableDecl Comparator<? super V> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = ImmutableSet.of();
    } else {
      paramComparator = ImmutableSortedSet.emptySet(paramComparator);
    }
    return paramComparator;
  }
  
  static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> paramCollection, @NullableDecl Comparator<? super V> paramComparator)
  {
    if (paramCollection.isEmpty()) {
      return of();
    }
    ImmutableMap.b localb = new ImmutableMap.b(paramCollection.size());
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramCollection = ((Map.Entry)localObject).getKey();
      localObject = valueSet(paramComparator, (Collection)((Map.Entry)localObject).getValue());
      if (!((AbstractCollection)localObject).isEmpty())
      {
        localb.c(paramCollection, localObject);
        i += ((AbstractCollection)localObject).size();
      }
    }
    return new ImmutableSetMultimap(localb.a(), i, paramComparator);
  }
  
  private ImmutableSetMultimap<V, K> invert()
  {
    a locala = builder();
    Object localObject = entries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      locala.i(localEntry.getValue(), localEntry.getKey());
    }
    localObject = locala.h();
    ((ImmutableSetMultimap)localObject).inverse = this;
    return (ImmutableSetMultimap<V, K>)localObject;
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of()
  {
    return l0.c;
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK, V paramV)
  {
    a locala = builder();
    locala.i(paramK, paramV);
    return locala.h();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    return locala.h();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    locala.i(paramK3, paramV3);
    return locala.h();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    locala.i(paramK3, paramV3);
    locala.i(paramK4, paramV4);
    return locala.h();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    locala.i(paramK3, paramV3);
    locala.i(paramK4, paramV4);
    locala.i(paramK5, paramV5);
    return locala.h();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    Comparator localComparator = (Comparator)paramObjectInputStream.readObject();
    int i = paramObjectInputStream.readInt();
    if (i >= 0)
    {
      ImmutableMap.b localb = ImmutableMap.builder();
      int j = 0;
      int k = 0;
      while (j < i)
      {
        Object localObject1 = paramObjectInputStream.readObject();
        int m = paramObjectInputStream.readInt();
        if (m > 0)
        {
          Object localObject2 = valuesBuilder(localComparator);
          for (int n = 0; n < m; n++) {
            ((ImmutableSet.a)localObject2).h(paramObjectInputStream.readObject());
          }
          localObject2 = ((ImmutableSet.a)localObject2).k();
          if (((AbstractCollection)localObject2).size() == m)
          {
            localb.c(localObject1, localObject2);
            k += m;
            j++;
          }
          else
          {
            paramObjectInputStream = new StringBuilder();
            paramObjectInputStream.append("Duplicate key-value pairs exist for key ");
            paramObjectInputStream.append(localObject1);
            throw new InvalidObjectException(paramObjectInputStream.toString());
          }
        }
        else
        {
          paramObjectInputStream = new StringBuilder();
          paramObjectInputStream.append("Invalid value count ");
          paramObjectInputStream.append(m);
          throw new InvalidObjectException(paramObjectInputStream.toString());
        }
      }
      try
      {
        paramObjectInputStream = localb.a();
        ImmutableMultimap.e.a.b(this, paramObjectInputStream);
        ImmutableMultimap.e.b.a(this, k);
        c.a.b(this, emptySet(localComparator));
        return;
      }
      catch (IllegalArgumentException paramObjectInputStream)
      {
        throw ((InvalidObjectException)new InvalidObjectException(paramObjectInputStream.getMessage()).initCause(paramObjectInputStream));
      }
    }
    paramObjectInputStream = new StringBuilder();
    paramObjectInputStream.append("Invalid key count ");
    paramObjectInputStream.append(i);
    throw new InvalidObjectException(paramObjectInputStream.toString());
  }
  
  private static <V> ImmutableSet<V> valueSet(@NullableDecl Comparator<? super V> paramComparator, Collection<? extends V> paramCollection)
  {
    if (paramComparator == null) {
      paramComparator = ImmutableSet.copyOf(paramCollection);
    } else {
      paramComparator = ImmutableSortedSet.copyOf(paramComparator, paramCollection);
    }
    return paramComparator;
  }
  
  private static <V> ImmutableSet.a<V> valuesBuilder(@NullableDecl Comparator<? super V> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = new ImmutableSet.a();
    } else {
      paramComparator = new ImmutableSortedSet.a(paramComparator);
    }
    return paramComparator;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(valueComparator());
    r2.j(this, paramObjectOutputStream);
  }
  
  public ImmutableSet<Map.Entry<K, V>> entries()
  {
    ImmutableSet localImmutableSet = this.entries;
    Object localObject = localImmutableSet;
    if (localImmutableSet == null)
    {
      localObject = new b(this);
      this.entries = ((ImmutableSet)localObject);
    }
    return (ImmutableSet<Map.Entry<K, V>>)localObject;
  }
  
  public ImmutableSet<V> get(@NullableDecl K paramK)
  {
    return (ImmutableSet)j.a((ImmutableSet)this.map.get(paramK), this.emptySet);
  }
  
  public ImmutableSetMultimap<V, K> inverse()
  {
    ImmutableSetMultimap localImmutableSetMultimap1 = this.inverse;
    ImmutableSetMultimap localImmutableSetMultimap2 = localImmutableSetMultimap1;
    if (localImmutableSetMultimap1 == null)
    {
      localImmutableSetMultimap2 = invert();
      this.inverse = localImmutableSetMultimap2;
    }
    return localImmutableSetMultimap2;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableSet<V> removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  @NullableDecl
  Comparator<? super V> valueComparator()
  {
    Object localObject = this.emptySet;
    if ((localObject instanceof ImmutableSortedSet)) {
      localObject = ((ImmutableSortedSet)localObject).comparator();
    } else {
      localObject = null;
    }
    return (Comparator<? super V>)localObject;
  }
  
  public static final class a<K, V>
    extends ImmutableMultimap.c<K, V>
  {
    Collection<V> b()
    {
      return c2.g();
    }
    
    public ImmutableSetMultimap<K, V> h()
    {
      Set localSet = this.a.entrySet();
      Comparator localComparator = this.b;
      Object localObject = localSet;
      if (localComparator != null) {
        localObject = a2.a(localComparator).h().b(localSet);
      }
      return ImmutableSetMultimap.fromMapEntries((Collection)localObject, this.c);
    }
    
    @CanIgnoreReturnValue
    public a<K, V> i(K paramK, V paramV)
    {
      super.c(paramK, paramV);
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<K, V> j(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      super.d(paramEntry);
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      super.e(paramIterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<K, V> l(K paramK, Iterable<? extends V> paramIterable)
    {
      super.f(paramK, paramIterable);
      return this;
    }
  }
  
  private static final class b<K, V>
    extends ImmutableSet<Map.Entry<K, V>>
  {
    @Weak
    private final transient ImmutableSetMultimap<K, V> c;
    
    b(ImmutableSetMultimap<K, V> paramImmutableSetMultimap)
    {
      this.c = paramImmutableSetMultimap;
    }
    
    public boolean contains(@NullableDecl Object paramObject)
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
      return false;
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
  
  private static final class c
  {
    static final r2.b<ImmutableSetMultimap> a = r2.a(ImmutableSetMultimap.class, "emptySet");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */