package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;

class p<Z>
  implements u<Z>
{
  private final boolean c;
  private final boolean d;
  private final u<Z> f;
  private final a q;
  private final c x;
  private int y;
  private boolean z;
  
  p(u<Z> paramu, boolean paramBoolean1, boolean paramBoolean2, c paramc, a parama)
  {
    this.f = ((u)i.d(paramu));
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.x = paramc;
    this.q = ((a)i.d(parama));
  }
  
  public int a()
  {
    return this.f.a();
  }
  
  void b()
  {
    try
    {
      if (!this.z)
      {
        this.y += 1;
        return;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Cannot acquire a recycled resource");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.y <= 0)
      {
        if (!this.z)
        {
          this.z = true;
          if (this.d) {
            this.f.c();
          }
          return;
        }
        localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>("Cannot recycle a resource that has already been recycled");
        throw localIllegalStateException;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Cannot recycle a resource while it is still acquired");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  u<Z> d()
  {
    return this.f;
  }
  
  @NonNull
  public Class<Z> e()
  {
    return this.f.e();
  }
  
  boolean f()
  {
    return this.c;
  }
  
  void g()
  {
    try
    {
      int i = this.y;
      if (i > 0)
      {
        int j = 1;
        i--;
        this.y = i;
        if (i != 0) {
          j = 0;
        }
        if (j != 0) {
          this.q.d(this.x, this);
        }
        return;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Cannot release a recycled or not yet acquired resource");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  @NonNull
  public Z get()
  {
    return (Z)this.f.get();
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("EngineResource{isMemoryCacheable=");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(", listener=");
      ((StringBuilder)localObject1).append(this.q);
      ((StringBuilder)localObject1).append(", key=");
      ((StringBuilder)localObject1).append(this.x);
      ((StringBuilder)localObject1).append(", acquired=");
      ((StringBuilder)localObject1).append(this.y);
      ((StringBuilder)localObject1).append(", isRecycled=");
      ((StringBuilder)localObject1).append(this.z);
      ((StringBuilder)localObject1).append(", resource=");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append('}');
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  static abstract interface a
  {
    public abstract void d(c paramc, p<?> paramp);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */