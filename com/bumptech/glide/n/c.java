package com.bumptech.glide.n;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.k.g.g;
import com.bumptech.glide.util.h;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class c
{
  private static final s<?, ?, ?> a = new s(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);
  private final ArrayMap<h, s<?, ?, ?>> b = new ArrayMap();
  private final AtomicReference<h> c = new AtomicReference();
  
  private h b(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    h localh1 = (h)this.c.getAndSet(null);
    h localh2 = localh1;
    if (localh1 == null) {
      localh2 = new h();
    }
    localh2.a(paramClass1, paramClass2, paramClass3);
    return localh2;
  }
  
  @Nullable
  public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> arg1, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    paramClass1 = b(???, paramClass1, paramClass2);
    synchronized (this.b)
    {
      paramClass2 = (s)this.b.get(paramClass1);
      this.c.set(paramClass1);
      return paramClass2;
    }
  }
  
  public boolean c(@Nullable s<?, ?, ?> params)
  {
    return a.equals(params);
  }
  
  public void d(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3, @Nullable s<?, ?, ?> params)
  {
    synchronized (this.b)
    {
      ArrayMap localArrayMap2 = this.b;
      h localh = new com/bumptech/glide/util/h;
      localh.<init>(paramClass1, paramClass2, paramClass3);
      if (params == null) {
        params = a;
      }
      localArrayMap2.put(localh, params);
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\n\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */