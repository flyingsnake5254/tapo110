package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
{
  private final List<String> a = new ArrayList();
  private final Map<String, List<a<?, ?>>> b = new HashMap();
  
  @NonNull
  private List<a<?, ?>> c(@NonNull String paramString)
  {
    try
    {
      if (!this.a.contains(paramString)) {
        this.a.add(paramString);
      }
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new java/util/ArrayList;
        ((ArrayList)localObject).<init>();
        this.b.put(paramString, localObject);
      }
      return (List<a<?, ?>>)localObject;
    }
    finally {}
  }
  
  public <T, R> void a(@NonNull String paramString, @NonNull g<T, R> paramg, @NonNull Class<T> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      List localList = c(paramString);
      paramString = new com/bumptech/glide/n/e$a;
      paramString.<init>(paramClass, paramClass1, paramg);
      localList.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @NonNull
  public <T, R> List<g<T, R>> b(@NonNull Class<T> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator1 = this.a.iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          Iterator localIterator2 = ((List)localObject).iterator();
          while (localIterator2.hasNext())
          {
            localObject = (a)localIterator2.next();
            if (((a)localObject).a(paramClass, paramClass1)) {
              localArrayList.add(((a)localObject).c);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  @NonNull
  public <T, R> List<Class<R>> d(@NonNull Class<T> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator1 = this.a.iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          Iterator localIterator2 = ((List)localObject).iterator();
          while (localIterator2.hasNext())
          {
            localObject = (a)localIterator2.next();
            if ((((a)localObject).a(paramClass, paramClass1)) && (!localArrayList.contains(((a)localObject).b))) {
              localArrayList.add(((a)localObject).b);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public void e(@NonNull List<String> paramList)
  {
    try
    {
      Object localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>(this.a);
      this.a.clear();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        this.a.add(localObject2);
      }
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if (!paramList.contains(localObject1)) {
          this.a.add(localObject1);
        }
      }
      return;
    }
    finally {}
  }
  
  private static class a<T, R>
  {
    private final Class<T> a;
    final Class<R> b;
    final g<T, R> c;
    
    public a(@NonNull Class<T> paramClass, @NonNull Class<R> paramClass1, g<T, R> paramg)
    {
      this.a = paramClass;
      this.b = paramClass1;
      this.c = paramg;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\n\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */