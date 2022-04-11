package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.h0.b.i;

public final class d<T, K>
  extends a<T, T>
{
  final j<? super T, K> f;
  final io.reactivex.g0.d<? super K, ? super K> q;
  
  public d(h<T> paramh, j<? super T, K> paramj, io.reactivex.g0.d<? super K, ? super K> paramd)
  {
    super(paramh);
    this.f = paramj;
    this.q = paramd;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    if ((paramb instanceof io.reactivex.h0.b.a))
    {
      paramb = (io.reactivex.h0.b.a)paramb;
      this.d.G(new a(paramb, this.f, this.q));
    }
    else
    {
      this.d.G(new b(paramb, this.f, this.q));
    }
  }
  
  static final class a<T, K>
    extends io.reactivex.internal.subscribers.a<T, T>
  {
    K p0;
    boolean p1;
    final j<? super T, K> y;
    final io.reactivex.g0.d<? super K, ? super K> z;
    
    a(io.reactivex.h0.b.a<? super T> parama, j<? super T, K> paramj, io.reactivex.g0.d<? super K, ? super K> paramd)
    {
      super();
      this.y = paramj;
      this.z = paramd;
    }
    
    public boolean b(T paramT)
    {
      if (this.q) {
        return false;
      }
      if (this.x != 0) {
        return this.c.b(paramT);
      }
      try
      {
        Object localObject = this.y.apply(paramT);
        if (this.p1)
        {
          boolean bool = this.z.a(this.p0, localObject);
          this.p0 = localObject;
          if (bool) {
            return false;
          }
        }
        else
        {
          this.p1 = true;
          this.p0 = localObject;
        }
        this.c.onNext(paramT);
        return true;
      }
      finally
      {
        d(paramT);
      }
      return true;
    }
    
    public void onNext(T paramT)
    {
      if (!b(paramT)) {
        this.d.request(1L);
      }
    }
    
    public T poll()
      throws Exception
    {
      for (;;)
      {
        Object localObject1 = this.f.poll();
        if (localObject1 == null) {
          return null;
        }
        Object localObject2 = this.y.apply(localObject1);
        if (!this.p1)
        {
          this.p1 = true;
          this.p0 = localObject2;
          return (T)localObject1;
        }
        if (!this.z.a(this.p0, localObject2))
        {
          this.p0 = localObject2;
          return (T)localObject1;
        }
        this.p0 = localObject2;
        if (this.x != 1) {
          this.d.request(1L);
        }
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return e(paramInt);
    }
  }
  
  static final class b<T, K>
    extends io.reactivex.internal.subscribers.b<T, T>
    implements io.reactivex.h0.b.a<T>
  {
    K p0;
    boolean p1;
    final j<? super T, K> y;
    final io.reactivex.g0.d<? super K, ? super K> z;
    
    b(e.b.b<? super T> paramb, j<? super T, K> paramj, io.reactivex.g0.d<? super K, ? super K> paramd)
    {
      super();
      this.y = paramj;
      this.z = paramd;
    }
    
    public boolean b(T paramT)
    {
      if (this.q) {
        return false;
      }
      if (this.x != 0)
      {
        this.c.onNext(paramT);
        return true;
      }
      try
      {
        Object localObject = this.y.apply(paramT);
        if (this.p1)
        {
          boolean bool = this.z.a(this.p0, localObject);
          this.p0 = localObject;
          if (bool) {
            return false;
          }
        }
        else
        {
          this.p1 = true;
          this.p0 = localObject;
        }
        this.c.onNext(paramT);
        return true;
      }
      finally
      {
        d(paramT);
      }
      return true;
    }
    
    public void onNext(T paramT)
    {
      if (!b(paramT)) {
        this.d.request(1L);
      }
    }
    
    public T poll()
      throws Exception
    {
      for (;;)
      {
        Object localObject1 = this.f.poll();
        if (localObject1 == null) {
          return null;
        }
        Object localObject2 = this.y.apply(localObject1);
        if (!this.p1)
        {
          this.p1 = true;
          this.p0 = localObject2;
          return (T)localObject1;
        }
        if (!this.z.a(this.p0, localObject2))
        {
          this.p0 = localObject2;
          return (T)localObject1;
        }
        this.p0 = localObject2;
        if (this.x != 1) {
          this.d.request(1L);
        }
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return e(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */