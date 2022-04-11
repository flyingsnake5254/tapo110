package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.f;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MutableClassToInstanceMap<B>
  extends p0<Class<? extends B>, B>
  implements Serializable
{
  private final Map<Class<? extends B>, B> delegate;
  
  private MutableClassToInstanceMap(Map<Class<? extends B>, B> paramMap)
  {
    this.delegate = ((Map)n.o(paramMap));
  }
  
  @CanIgnoreReturnValue
  private static <B, T extends B> T cast(Class<T> paramClass, B paramB)
  {
    return (T)f.d(paramClass).cast(paramB);
  }
  
  static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> paramEntry)
  {
    return new a(paramEntry);
  }
  
  public static <B> MutableClassToInstanceMap<B> create()
  {
    return new MutableClassToInstanceMap(new HashMap());
  }
  
  public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> paramMap)
  {
    return new MutableClassToInstanceMap(paramMap);
  }
  
  private Object writeReplace()
  {
    return new c(delegate());
  }
  
  protected Map<Class<? extends B>, B> delegate()
  {
    return this.delegate;
  }
  
  public Set<Map.Entry<Class<? extends B>, B>> entrySet()
  {
    return new b();
  }
  
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return (T)cast(paramClass, get(paramClass));
  }
  
  @CanIgnoreReturnValue
  public B put(Class<? extends B> paramClass, B paramB)
  {
    return (B)super.put(paramClass, cast(paramClass, paramB));
  }
  
  public void putAll(Map<? extends Class<? extends B>, ? extends B> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramMap);
    Iterator localIterator = localLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      cast((Class)paramMap.getKey(), paramMap.getValue());
    }
    super.putAll(localLinkedHashMap);
  }
  
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT)
  {
    return (T)cast(paramClass, put(paramClass, paramT));
  }
  
  static final class a
    extends q0<Class<? extends B>, B>
  {
    a(Map.Entry paramEntry) {}
    
    protected Map.Entry<Class<? extends B>, B> a()
    {
      return this.c;
    }
    
    public B setValue(B paramB)
    {
      return (B)super.setValue(MutableClassToInstanceMap.cast((Class)getKey(), paramB));
    }
  }
  
  class b
    extends u0<Map.Entry<Class<? extends B>, B>>
  {
    b() {}
    
    protected Set<Map.Entry<Class<? extends B>, B>> delegate()
    {
      return MutableClassToInstanceMap.this.delegate().entrySet();
    }
    
    public Iterator<Map.Entry<Class<? extends B>, B>> iterator()
    {
      return new a(delegate().iterator());
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
    
    class a
      extends h3<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>>
    {
      a(Iterator paramIterator)
      {
        super();
      }
      
      Map.Entry<Class<? extends B>, B> b(Map.Entry<Class<? extends B>, B> paramEntry)
      {
        return MutableClassToInstanceMap.checkedEntry(paramEntry);
      }
    }
  }
  
  private static final class c<B>
    implements Serializable
  {
    private final Map<Class<? extends B>, B> c;
    
    c(Map<Class<? extends B>, B> paramMap)
    {
      this.c = paramMap;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\MutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */