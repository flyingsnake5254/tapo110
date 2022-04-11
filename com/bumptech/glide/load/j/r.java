package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.f;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class r
{
  private static final c a = new c();
  private static final n<Object, Object> b = new a();
  private final List<b<?, ?>> c = new ArrayList();
  private final c d;
  private final Set<b<?, ?>> e = new HashSet();
  private final Pools.Pool<List<Throwable>> f;
  
  public r(@NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this(paramPool, a);
  }
  
  @VisibleForTesting
  r(@NonNull Pools.Pool<List<Throwable>> paramPool, @NonNull c paramc)
  {
    this.f = paramPool;
    this.d = paramc;
  }
  
  private <Model, Data> void a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo, boolean paramBoolean)
  {
    paramClass = new b(paramClass, paramClass1, paramo);
    paramClass1 = this.c;
    int i;
    if (paramBoolean) {
      i = paramClass1.size();
    } else {
      i = 0;
    }
    paramClass1.add(i, paramClass);
  }
  
  @NonNull
  private <Model, Data> n<Model, Data> c(@NonNull b<?, ?> paramb)
  {
    return (n)i.d(paramb.c.c(this));
  }
  
  @NonNull
  private static <Model, Data> n<Model, Data> f()
  {
    return b;
  }
  
  @NonNull
  private <Model, Data> o<Model, Data> h(@NonNull b<?, ?> paramb)
  {
    return paramb.c;
  }
  
  <Model, Data> void b(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      a(paramClass, paramClass1, paramo, true);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @NonNull
  public <Model, Data> n<Model, Data> d(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Object localObject = this.c.iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (this.e.contains(localb))
        {
          i = 1;
        }
        else if (localb.b(paramClass, paramClass1))
        {
          this.e.add(localb);
          localArrayList.add(c(localb));
          this.e.remove(localb);
        }
      }
      if (localArrayList.size() > 1)
      {
        paramClass = this.d.a(localArrayList, this.f);
        return paramClass;
      }
      if (localArrayList.size() == 1)
      {
        paramClass = (n)localArrayList.get(0);
        return paramClass;
      }
      if (i != 0)
      {
        paramClass = f();
        return paramClass;
      }
      localObject = new com/bumptech/glide/Registry$NoModelLoaderAvailableException;
      ((Registry.NoModelLoaderAvailableException)localObject).<init>(paramClass, paramClass1);
      throw ((Throwable)localObject);
    }
    finally
    {
      try
      {
        this.e.clear();
        throw paramClass;
      }
      finally {}
    }
  }
  
  @NonNull
  <Model> List<n<Model, ?>> e(@NonNull Class<Model> paramClass)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((!this.e.contains(localb)) && (localb.a(paramClass)))
        {
          this.e.add(localb);
          localArrayList.add(c(localb));
          this.e.remove(localb);
        }
      }
      return localArrayList;
    }
    finally
    {
      try
      {
        this.e.clear();
        throw paramClass;
      }
      finally {}
    }
  }
  
  @NonNull
  List<Class<?>> g(@NonNull Class<?> paramClass)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((!localArrayList.contains(localb.b)) && (localb.a(paramClass))) {
          localArrayList.add(localb.b);
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  @NonNull
  <Model, Data> List<o<? extends Model, ? extends Data>> i(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.b(paramClass, paramClass1))
        {
          localIterator.remove();
          localArrayList.add(h(localb));
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  @NonNull
  <Model, Data> List<o<? extends Model, ? extends Data>> j(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      List localList = i(paramClass, paramClass1);
      b(paramClass, paramClass1, paramo);
      return localList;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  private static class a
    implements n<Object, Object>
  {
    public boolean a(@NonNull Object paramObject)
    {
      return false;
    }
    
    @Nullable
    public n.a<Object> b(@NonNull Object paramObject, int paramInt1, int paramInt2, @NonNull f paramf)
    {
      return null;
    }
  }
  
  private static class b<Model, Data>
  {
    private final Class<Model> a;
    final Class<Data> b;
    final o<? extends Model, ? extends Data> c;
    
    public b(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo)
    {
      this.a = paramClass;
      this.b = paramClass1;
      this.c = paramo;
    }
    
    public boolean a(@NonNull Class<?> paramClass)
    {
      return this.a.isAssignableFrom(paramClass);
    }
    
    public boolean b(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
    {
      boolean bool;
      if ((a(paramClass1)) && (this.b.isAssignableFrom(paramClass2))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  static class c
  {
    @NonNull
    public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> paramList, @NonNull Pools.Pool<List<Throwable>> paramPool)
    {
      return new q(paramList, paramPool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */