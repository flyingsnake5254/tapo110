package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableListMultimap<K, V>
  extends ImmutableMultimap<K, V>
  implements m1<K, V>
{
  private static final long serialVersionUID = 0L;
  @LazyInit
  @RetainedWith
  private transient ImmutableListMultimap<V, K> inverse;
  
  ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> paramImmutableMap, int paramInt)
  {
    super(paramImmutableMap, paramInt);
  }
  
  public static <K, V> a<K, V> builder()
  {
    return new a();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> copyOf(r1<? extends K, ? extends V> paramr1)
  {
    if (paramr1.isEmpty()) {
      return of();
    }
    if ((paramr1 instanceof ImmutableListMultimap))
    {
      ImmutableListMultimap localImmutableListMultimap = (ImmutableListMultimap)paramr1;
      if (!localImmutableListMultimap.isPartialView()) {
        return localImmutableListMultimap;
      }
    }
    return fromMapEntries(paramr1.asMap().entrySet(), null);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return new a().k(paramIterable).h();
  }
  
  static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> paramCollection, @NullableDecl Comparator<? super V> paramComparator)
  {
    if (paramCollection.isEmpty()) {
      return of();
    }
    ImmutableMap.b localb = new ImmutableMap.b(paramCollection.size());
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      paramCollection = (Map.Entry)localIterator.next();
      Object localObject = paramCollection.getKey();
      paramCollection = (Collection)paramCollection.getValue();
      if (paramComparator == null) {
        paramCollection = ImmutableList.copyOf(paramCollection);
      } else {
        paramCollection = ImmutableList.sortedCopyOf(paramComparator, paramCollection);
      }
      if (!paramCollection.isEmpty())
      {
        localb.c(localObject, paramCollection);
        i += paramCollection.size();
      }
    }
    return new ImmutableListMultimap(localb.a(), i);
  }
  
  private ImmutableListMultimap<V, K> invert()
  {
    a locala = builder();
    j3 localj3 = entries().iterator();
    while (localj3.hasNext())
    {
      localObject = (Map.Entry)localj3.next();
      locala.i(((Map.Entry)localObject).getValue(), ((Map.Entry)localObject).getKey());
    }
    Object localObject = locala.h();
    ((ImmutableListMultimap)localObject).inverse = this;
    return (ImmutableListMultimap<V, K>)localObject;
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of()
  {
    return k0.c;
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK, V paramV)
  {
    a locala = builder();
    locala.i(paramK, paramV);
    return locala.h();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    return locala.h();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    locala.i(paramK3, paramV3);
    return locala.h();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    a locala = builder();
    locala.i(paramK1, paramV1);
    locala.i(paramK2, paramV2);
    locala.i(paramK3, paramV3);
    locala.i(paramK4, paramV4);
    return locala.h();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
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
    int i = paramObjectInputStream.readInt();
    if (i >= 0)
    {
      ImmutableMap.b localb = ImmutableMap.builder();
      int j = 0;
      int k = 0;
      while (j < i)
      {
        Object localObject = paramObjectInputStream.readObject();
        int m = paramObjectInputStream.readInt();
        if (m > 0)
        {
          ImmutableList.a locala = ImmutableList.builder();
          for (int n = 0; n < m; n++) {
            locala.h(paramObjectInputStream.readObject());
          }
          localb.c(localObject, locala.j());
          k += m;
          j++;
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
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    r2.j(this, paramObjectOutputStream);
  }
  
  public ImmutableList<V> get(@NullableDecl K paramK)
  {
    ImmutableList localImmutableList = (ImmutableList)this.map.get(paramK);
    paramK = localImmutableList;
    if (localImmutableList == null) {
      paramK = ImmutableList.of();
    }
    return paramK;
  }
  
  public ImmutableListMultimap<V, K> inverse()
  {
    ImmutableListMultimap localImmutableListMultimap1 = this.inverse;
    ImmutableListMultimap localImmutableListMultimap2 = localImmutableListMultimap1;
    if (localImmutableListMultimap1 == null)
    {
      localImmutableListMultimap2 = invert();
      this.inverse = localImmutableListMultimap2;
    }
    return localImmutableListMultimap2;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableList<V> removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableList<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class a<K, V>
    extends ImmutableMultimap.c<K, V>
  {
    public ImmutableListMultimap<K, V> h()
    {
      return (ImmutableListMultimap)super.a();
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
    
    @CanIgnoreReturnValue
    public a<K, V> m(K paramK, V... paramVarArgs)
    {
      super.g(paramK, paramVarArgs);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */