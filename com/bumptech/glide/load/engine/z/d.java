package com.bumptech.glide.load.engine.z;

import com.bumptech.glide.util.j;
import java.util.Queue;

abstract class d<T extends m>
{
  private final Queue<T> a = j.f(20);
  
  abstract T a();
  
  T b()
  {
    m localm1 = (m)this.a.poll();
    m localm2 = localm1;
    if (localm1 == null) {
      localm2 = a();
    }
    return localm2;
  }
  
  public void c(T paramT)
  {
    if (this.a.size() < 20) {
      this.a.offer(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\z\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */