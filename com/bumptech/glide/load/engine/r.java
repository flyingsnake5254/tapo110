package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.c;
import java.util.HashMap;
import java.util.Map;

final class r
{
  private final Map<c, l<?>> a = new HashMap();
  private final Map<c, l<?>> b = new HashMap();
  
  private Map<c, l<?>> b(boolean paramBoolean)
  {
    Map localMap;
    if (paramBoolean) {
      localMap = this.b;
    } else {
      localMap = this.a;
    }
    return localMap;
  }
  
  l<?> a(c paramc, boolean paramBoolean)
  {
    return (l)b(paramBoolean).get(paramc);
  }
  
  void c(c paramc, l<?> paraml)
  {
    b(paraml.p()).put(paramc, paraml);
  }
  
  void d(c paramc, l<?> paraml)
  {
    Map localMap = b(paraml.p());
    if (paraml.equals(localMap.get(paramc))) {
      localMap.remove(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */