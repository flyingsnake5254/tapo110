package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k.a;
import com.bumptech.glide.util.k.a.d;
import com.bumptech.glide.util.k.a.f;
import com.bumptech.glide.util.k.c;

final class t<Z>
  implements u<Z>, a.f
{
  private static final Pools.Pool<t<?>> c = a.d(20, new a());
  private final c d = c.a();
  private u<Z> f;
  private boolean q;
  private boolean x;
  
  private void b(u<Z> paramu)
  {
    this.x = false;
    this.q = true;
    this.f = paramu;
  }
  
  @NonNull
  static <Z> t<Z> f(u<Z> paramu)
  {
    t localt = (t)i.d((t)c.acquire());
    localt.b(paramu);
    return localt;
  }
  
  private void g()
  {
    this.f = null;
    c.release(this);
  }
  
  public int a()
  {
    return this.f.a();
  }
  
  public void c()
  {
    try
    {
      this.d.c();
      this.x = true;
      if (!this.q)
      {
        this.f.c();
        g();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @NonNull
  public c d()
  {
    return this.d;
  }
  
  @NonNull
  public Class<Z> e()
  {
    return this.f.e();
  }
  
  @NonNull
  public Z get()
  {
    return (Z)this.f.get();
  }
  
  void h()
  {
    try
    {
      this.d.c();
      if (this.q)
      {
        this.q = false;
        if (this.x) {
          c();
        }
        return;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Already unlocked");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  class a
    implements a.d<t<?>>
  {
    public t<?> a()
    {
      return new t();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */