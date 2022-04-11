package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class d
{
  private final AtomicReference<h> a = new AtomicReference();
  private final ArrayMap<h, List<Class<?>>> b = new ArrayMap();
  
  @Nullable
  public List<Class<?>> a(@NonNull Class<?> paramClass1, @NonNull Class<?> arg2, @NonNull Class<?> paramClass3)
  {
    h localh = (h)this.a.getAndSet(null);
    if (localh == null)
    {
      paramClass1 = new h(paramClass1, ???, paramClass3);
    }
    else
    {
      localh.a(paramClass1, ???, paramClass3);
      paramClass1 = localh;
    }
    synchronized (this.b)
    {
      paramClass3 = (List)this.b.get(paramClass1);
      this.a.set(paramClass1);
      return paramClass3;
    }
  }
  
  public void b(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2, @NonNull Class<?> paramClass3, @NonNull List<Class<?>> paramList)
  {
    synchronized (this.b)
    {
      ArrayMap localArrayMap2 = this.b;
      h localh = new com/bumptech/glide/util/h;
      localh.<init>(paramClass1, paramClass2, paramClass3);
      localArrayMap2.put(localh, paramList);
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\n\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */