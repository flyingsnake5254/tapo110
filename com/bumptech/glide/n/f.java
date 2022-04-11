package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private final List<a<?>> a = new ArrayList();
  
  public <Z> void a(@NonNull Class<Z> paramClass, @NonNull h<Z> paramh)
  {
    try
    {
      List localList = this.a;
      a locala = new com/bumptech/glide/n/f$a;
      locala.<init>(paramClass, paramh);
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
  public <Z> h<Z> b(@NonNull Class<Z> paramClass)
  {
    int i = 0;
    try
    {
      int j = this.a.size();
      while (i < j)
      {
        a locala = (a)this.a.get(i);
        if (locala.a(paramClass))
        {
          paramClass = locala.b;
          return paramClass;
        }
        i++;
      }
      return null;
    }
    finally {}
  }
  
  private static final class a<T>
  {
    private final Class<T> a;
    final h<T> b;
    
    a(@NonNull Class<T> paramClass, @NonNull h<T> paramh)
    {
      this.a = paramClass;
      this.b = paramh;
    }
    
    boolean a(@NonNull Class<?> paramClass)
    {
      return this.a.isAssignableFrom(paramClass);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\n\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */