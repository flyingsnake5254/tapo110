package com.bumptech.glide.load.k.g;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
{
  private final List<a<?, ?>> a = new ArrayList();
  
  @NonNull
  public <Z, R> e<Z, R> a(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      if (paramClass1.isAssignableFrom(paramClass))
      {
        paramClass = g.b();
        return paramClass;
      }
      Object localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).a(paramClass, paramClass1))
        {
          paramClass = ((a)localObject2).c;
          return paramClass;
        }
      }
      localObject1 = new java/lang/IllegalArgumentException;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("No transcoder registered to transcode from ");
      ((StringBuilder)localObject2).append(paramClass);
      ((StringBuilder)localObject2).append(" to ");
      ((StringBuilder)localObject2).append(paramClass1);
      ((IllegalArgumentException)localObject1).<init>(((StringBuilder)localObject2).toString());
      throw ((Throwable)localObject1);
    }
    finally {}
  }
  
  @NonNull
  public <Z, R> List<Class<R>> b(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      if (paramClass1.isAssignableFrom(paramClass))
      {
        localArrayList.add(paramClass1);
        return localArrayList;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).a(paramClass, paramClass1)) {
          localArrayList.add(paramClass1);
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public <Z, R> void c(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1, @NonNull e<Z, R> parame)
  {
    try
    {
      List localList = this.a;
      a locala = new com/bumptech/glide/load/k/g/f$a;
      locala.<init>(paramClass, paramClass1, parame);
      localList.add(locala);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  private static final class a<Z, R>
  {
    private final Class<Z> a;
    private final Class<R> b;
    final e<Z, R> c;
    
    a(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1, @NonNull e<Z, R> parame)
    {
      this.a = paramClass;
      this.b = paramClass1;
      this.c = parame;
    }
    
    public boolean a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
    {
      boolean bool;
      if ((this.a.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.b))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */