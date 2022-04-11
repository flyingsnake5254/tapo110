package com.bumptech.glide.util.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static final g<Object> a = new a();
  
  @NonNull
  private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> paramPool, @NonNull d<T> paramd)
  {
    return b(paramPool, paramd, c());
  }
  
  @NonNull
  private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> paramPool, @NonNull d<T> paramd, @NonNull g<T> paramg)
  {
    return new e(paramPool, paramd, paramg);
  }
  
  @NonNull
  private static <T> g<T> c()
  {
    return a;
  }
  
  @NonNull
  public static <T extends f> Pools.Pool<T> d(int paramInt, @NonNull d<T> paramd)
  {
    return a(new Pools.SynchronizedPool(paramInt), paramd);
  }
  
  @NonNull
  public static <T> Pools.Pool<List<T>> e()
  {
    return f(20);
  }
  
  @NonNull
  public static <T> Pools.Pool<List<T>> f(int paramInt)
  {
    return b(new Pools.SynchronizedPool(paramInt), new b(), new c());
  }
  
  class a
    implements a.g<Object>
  {
    public void a(@NonNull Object paramObject) {}
  }
  
  class b
    implements a.d<List<T>>
  {
    @NonNull
    public List<T> a()
    {
      return new ArrayList();
    }
  }
  
  class c
    implements a.g<List<T>>
  {
    public void b(@NonNull List<T> paramList)
    {
      paramList.clear();
    }
  }
  
  public static abstract interface d<T>
  {
    public abstract T c();
  }
  
  private static final class e<T>
    implements Pools.Pool<T>
  {
    private final a.d<T> a;
    private final a.g<T> b;
    private final Pools.Pool<T> c;
    
    e(@NonNull Pools.Pool<T> paramPool, @NonNull a.d<T> paramd, @NonNull a.g<T> paramg)
    {
      this.c = paramPool;
      this.a = paramd;
      this.b = paramg;
    }
    
    public T acquire()
    {
      Object localObject1 = this.c.acquire();
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = this.a.c();
        localObject2 = localObject1;
        if (Log.isLoggable("FactoryPools", 2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Created new ");
          ((StringBuilder)localObject2).append(localObject1.getClass());
          Log.v("FactoryPools", ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
      }
      if ((localObject2 instanceof a.f)) {
        ((a.f)localObject2).d().b(false);
      }
      return (T)localObject2;
    }
    
    public boolean release(@NonNull T paramT)
    {
      if ((paramT instanceof a.f)) {
        ((a.f)paramT).d().b(true);
      }
      this.b.a(paramT);
      return this.c.release(paramT);
    }
  }
  
  public static abstract interface f
  {
    @NonNull
    public abstract c d();
  }
  
  public static abstract interface g<T>
  {
    public abstract void a(@NonNull T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */