package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.e;
import com.google.gson.internal.k.b;
import com.google.gson.r.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c
{
  private final Map<Type, e<?>> a;
  private final b b = b.a();
  
  public c(Map<Type, e<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  private <T> f<T> b(final Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        this.b.b(paramClass);
      }
      paramClass = new h(paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  private <T> f<T> c(final Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        return new i();
      }
      if (EnumSet.class.isAssignableFrom(paramClass)) {
        return new j(paramType);
      }
      if (Set.class.isAssignableFrom(paramClass)) {
        return new k();
      }
      if (Queue.class.isAssignableFrom(paramClass)) {
        return new l();
      }
      return new m();
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (ConcurrentNavigableMap.class.isAssignableFrom(paramClass)) {
        return new n();
      }
      if (ConcurrentMap.class.isAssignableFrom(paramClass)) {
        return new a();
      }
      if (SortedMap.class.isAssignableFrom(paramClass)) {
        return new b();
      }
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.get(((ParameterizedType)paramType).getActualTypeArguments()[0]).getRawType()))) {
        return new c();
      }
      return new d();
    }
    return null;
  }
  
  private <T> f<T> d(final Type paramType, final Class<? super T> paramClass)
  {
    return new e(paramClass, paramType);
  }
  
  public <T> f<T> a(a<T> parama)
  {
    final Type localType = parama.getType();
    parama = parama.getRawType();
    final Object localObject = (e)this.a.get(localType);
    if (localObject != null) {
      return new f((e)localObject, localType);
    }
    localObject = (e)this.a.get(parama);
    if (localObject != null) {
      return new g((e)localObject, localType);
    }
    localObject = b(parama);
    if (localObject != null) {
      return (f<T>)localObject;
    }
    localObject = c(localType, parama);
    if (localObject != null) {
      return (f<T>)localObject;
    }
    return d(localType, parama);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  class a
    implements f<T>
  {
    a() {}
    
    public T a()
    {
      return new ConcurrentHashMap();
    }
  }
  
  class b
    implements f<T>
  {
    b() {}
    
    public T a()
    {
      return new TreeMap();
    }
  }
  
  class c
    implements f<T>
  {
    c() {}
    
    public T a()
    {
      return new LinkedHashMap();
    }
  }
  
  class d
    implements f<T>
  {
    d() {}
    
    public T a()
    {
      return new LinkedTreeMap();
    }
  }
  
  class e
    implements f<T>
  {
    private final j a = j.b();
    
    e(Class paramClass, Type paramType) {}
    
    public T a()
    {
      try
      {
        Object localObject = this.a.c(paramClass);
        return (T)localObject;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to invoke no-args constructor for ");
        localStringBuilder.append(paramType);
        localStringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
        throw new RuntimeException(localStringBuilder.toString(), localException);
      }
    }
  }
  
  class f
    implements f<T>
  {
    f(e parame, Type paramType) {}
    
    public T a()
    {
      return (T)localObject.a(localType);
    }
  }
  
  class g
    implements f<T>
  {
    g(e parame, Type paramType) {}
    
    public T a()
    {
      return (T)localObject.a(localType);
    }
  }
  
  class h
    implements f<T>
  {
    h(Constructor paramConstructor) {}
    
    public T a()
    {
      try
      {
        Object localObject = paramClass.newInstance(null);
        return (T)localObject;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Failed to invoke ");
        localStringBuilder2.append(paramClass);
        localStringBuilder2.append(" with no args");
        throw new RuntimeException(localStringBuilder2.toString(), localInvocationTargetException.getTargetException());
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Failed to invoke ");
        localStringBuilder1.append(paramClass);
        localStringBuilder1.append(" with no args");
        throw new RuntimeException(localStringBuilder1.toString(), localInstantiationException);
      }
    }
  }
  
  class i
    implements f<T>
  {
    i() {}
    
    public T a()
    {
      return new TreeSet();
    }
  }
  
  class j
    implements f<T>
  {
    j(Type paramType) {}
    
    public T a()
    {
      Object localObject = paramType;
      if ((localObject instanceof ParameterizedType))
      {
        localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
        if ((localObject instanceof Class)) {
          return EnumSet.noneOf((Class)localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid EnumSet type: ");
        ((StringBuilder)localObject).append(paramType.toString());
        throw new JsonIOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid EnumSet type: ");
      ((StringBuilder)localObject).append(paramType.toString());
      throw new JsonIOException(((StringBuilder)localObject).toString());
    }
  }
  
  class k
    implements f<T>
  {
    k() {}
    
    public T a()
    {
      return new LinkedHashSet();
    }
  }
  
  class l
    implements f<T>
  {
    l() {}
    
    public T a()
    {
      return new ArrayDeque();
    }
  }
  
  class m
    implements f<T>
  {
    m() {}
    
    public T a()
    {
      return new ArrayList();
    }
  }
  
  class n
    implements f<T>
  {
    n() {}
    
    public T a()
    {
      return new ConcurrentSkipListMap();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */