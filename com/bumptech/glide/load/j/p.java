package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class p
{
  private final r a;
  private final a b = new a();
  
  public p(@NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this(new r(paramPool));
  }
  
  private p(@NonNull r paramr)
  {
    this.a = paramr;
  }
  
  @NonNull
  private static <A> Class<A> b(@NonNull A paramA)
  {
    return paramA.getClass();
  }
  
  @NonNull
  private <A> List<n<A, ?>> e(@NonNull Class<A> paramClass)
  {
    try
    {
      List localList1 = this.b.b(paramClass);
      List localList2 = localList1;
      if (localList1 == null)
      {
        localList2 = Collections.unmodifiableList(this.a.e(paramClass));
        this.b.c(paramClass, localList2);
      }
      return localList2;
    }
    finally {}
  }
  
  private <Model, Data> void g(@NonNull List<o<? extends Model, ? extends Data>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((o)paramList.next()).a();
    }
  }
  
  public <Model, Data> void a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      this.a.b(paramClass, paramClass1, paramo);
      this.b.a();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @NonNull
  public List<Class<?>> c(@NonNull Class<?> paramClass)
  {
    try
    {
      paramClass = this.a.g(paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @NonNull
  public <A> List<n<A, ?>> d(@NonNull A paramA)
  {
    List localList = e(b(paramA));
    if (!localList.isEmpty())
    {
      int i = localList.size();
      Object localObject1 = Collections.emptyList();
      int j = 1;
      int k = 0;
      while (k < i)
      {
        n localn = (n)localList.get(k);
        Object localObject2 = localObject1;
        int m = j;
        if (localn.a(paramA))
        {
          m = j;
          if (j != 0)
          {
            localObject1 = new ArrayList(i - k);
            m = 0;
          }
          ((List)localObject1).add(localn);
          localObject2 = localObject1;
        }
        k++;
        localObject1 = localObject2;
        j = m;
      }
      if (!((List)localObject1).isEmpty()) {
        return (List<n<A, ?>>)localObject1;
      }
      throw new Registry.NoModelLoaderAvailableException(paramA, localList);
    }
    throw new Registry.NoModelLoaderAvailableException(paramA);
  }
  
  public <Model, Data> void f(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      g(this.a.j(paramClass, paramClass1, paramo));
      this.b.a();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  private static class a
  {
    private final Map<Class<?>, a<?>> a = new HashMap();
    
    public void a()
    {
      this.a.clear();
    }
    
    @Nullable
    public <Model> List<n<Model, ?>> b(Class<Model> paramClass)
    {
      paramClass = (a)this.a.get(paramClass);
      if (paramClass == null) {
        paramClass = null;
      } else {
        paramClass = paramClass.a;
      }
      return paramClass;
    }
    
    public <Model> void c(Class<Model> paramClass, List<n<Model, ?>> paramList)
    {
      if ((a)this.a.put(paramClass, new a(paramList)) == null) {
        return;
      }
      paramList = new StringBuilder();
      paramList.append("Already cached loaders for model: ");
      paramList.append(paramClass);
      throw new IllegalStateException(paramList.toString());
    }
    
    private static class a<Model>
    {
      final List<n<Model, ?>> a;
      
      public a(List<n<Model, ?>> paramList)
      {
        this.a = paramList;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */