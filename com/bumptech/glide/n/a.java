package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private final List<a<?>> a = new ArrayList();
  
  public <T> void a(@NonNull Class<T> paramClass, @NonNull com.bumptech.glide.load.a<T> parama)
  {
    try
    {
      List localList = this.a;
      a locala = new com/bumptech/glide/n/a$a;
      locala.<init>(paramClass, parama);
      localList.add(locala);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @Nullable
  public <T> com.bumptech.glide.load.a<T> b(@NonNull Class<T> paramClass)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a(paramClass))
        {
          paramClass = locala.b;
          return paramClass;
        }
      }
      return null;
    }
    finally {}
  }
  
  private static final class a<T>
  {
    private final Class<T> a;
    final com.bumptech.glide.load.a<T> b;
    
    a(@NonNull Class<T> paramClass, @NonNull com.bumptech.glide.load.a<T> parama)
    {
      this.a = paramClass;
      this.b = parama;
    }
    
    boolean a(@NonNull Class<?> paramClass)
    {
      return this.a.isAssignableFrom(paramClass);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\n\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */