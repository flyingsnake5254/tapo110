package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.f;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf={"B"})
public final class ImmutableClassToInstanceMap<B>
  extends p0<Class<? extends B>, B>
  implements Serializable
{
  private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
  private final ImmutableMap<Class<? extends B>, B> delegate;
  
  private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> paramImmutableMap)
  {
    this.delegate = paramImmutableMap;
  }
  
  public static <B> b<B> builder()
  {
    return new b();
  }
  
  public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> paramMap)
  {
    if ((paramMap instanceof ImmutableClassToInstanceMap)) {
      return (ImmutableClassToInstanceMap)paramMap;
    }
    return new b().c(paramMap).a();
  }
  
  public static <B> ImmutableClassToInstanceMap<B> of()
  {
    return EMPTY;
  }
  
  public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> paramClass, T paramT)
  {
    return new ImmutableClassToInstanceMap(ImmutableMap.of(paramClass, paramT));
  }
  
  protected Map<Class<? extends B>, B> delegate()
  {
    return this.delegate;
  }
  
  @NullableDecl
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return (T)this.delegate.get(n.o(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  Object readResolve()
  {
    ImmutableClassToInstanceMap localImmutableClassToInstanceMap;
    if (isEmpty()) {
      localImmutableClassToInstanceMap = of();
    } else {
      localImmutableClassToInstanceMap = this;
    }
    return localImmutableClassToInstanceMap;
  }
  
  public static final class b<B>
  {
    private final ImmutableMap.b<Class<? extends B>, B> a = ImmutableMap.builder();
    
    private static <B, T extends B> T b(Class<T> paramClass, B paramB)
    {
      return (T)f.d(paramClass).cast(paramB);
    }
    
    public ImmutableClassToInstanceMap<B> a()
    {
      ImmutableMap localImmutableMap = this.a.a();
      if (localImmutableMap.isEmpty()) {
        return ImmutableClassToInstanceMap.of();
      }
      return new ImmutableClassToInstanceMap(localImmutableMap, null);
    }
    
    @CanIgnoreReturnValue
    public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> paramMap)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        paramMap = (Class)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        this.a.c(paramMap, b(paramMap, localObject));
      }
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */