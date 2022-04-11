package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ImmutableBiMap<K, V>
  extends ImmutableMap<K, V>
  implements t<K, V>
{
  public static <K, V> a<K, V> builder()
  {
    return new a();
  }
  
  public static <K, V> a<K, V> builderWithExpectedSize(int paramInt)
  {
    v.b(paramInt, "expectedSize");
    return new a(paramInt);
  }
  
  public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    int i;
    if ((paramIterable instanceof Collection)) {
      i = ((Collection)paramIterable).size();
    } else {
      i = 4;
    }
    return new a(i).k(paramIterable).h();
  }
  
  public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    if ((paramMap instanceof ImmutableBiMap))
    {
      ImmutableBiMap localImmutableBiMap = (ImmutableBiMap)paramMap;
      if (!localImmutableBiMap.isPartialView()) {
        return localImmutableBiMap;
      }
    }
    return copyOf(paramMap.entrySet());
  }
  
  public static <K, V> ImmutableBiMap<K, V> of()
  {
    return h2.c;
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK, V paramV)
  {
    v.a(paramK, paramV);
    return new h2(new Object[] { paramK, paramV }, 1);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    return new h2(new Object[] { paramK1, paramV1, paramK2, paramV2 }, 2);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    v.a(paramK3, paramV3);
    return new h2(new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3 }, 3);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    v.a(paramK3, paramV3);
    v.a(paramK4, paramV4);
    return new h2(new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4 }, 4);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    v.a(paramK1, paramV1);
    v.a(paramK2, paramV2);
    v.a(paramK3, paramV3);
    v.a(paramK4, paramV4);
    v.a(paramK5, paramV5);
    return new h2(new Object[] { paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5 }, 5);
  }
  
  final ImmutableSet<V> createValues()
  {
    throw new AssertionError("should never be called");
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public V forcePut(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ImmutableBiMap<V, K> inverse();
  
  public ImmutableSet<V> values()
  {
    return inverse().keySet();
  }
  
  Object writeReplace()
  {
    return new b(this);
  }
  
  public static final class a<K, V>
    extends ImmutableMap.b<K, V>
  {
    public a() {}
    
    a(int paramInt)
    {
      super();
    }
    
    public ImmutableBiMap<K, V> h()
    {
      if (this.c == 0) {
        return ImmutableBiMap.of();
      }
      g();
      this.d = true;
      return new h2(this.b, this.c);
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
    public a<K, V> l(Map<? extends K, ? extends V> paramMap)
    {
      super.f(paramMap);
      return this;
    }
  }
  
  private static class b
    extends ImmutableMap.e
  {
    b(ImmutableBiMap<?, ?> paramImmutableBiMap)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */