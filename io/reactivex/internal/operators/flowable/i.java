package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.g0.l;
import io.reactivex.h;
import io.reactivex.h0.b.f;

public final class i<T>
  extends a<T, T>
{
  final l<? super T> f;
  
  public i(h<T> paramh, l<? super T> paraml)
  {
    super(paramh);
    this.f = paraml;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    if ((paramb instanceof io.reactivex.h0.b.a)) {
      this.d.G(new a((io.reactivex.h0.b.a)paramb, this.f));
    } else {
      this.d.G(new b(paramb, this.f));
    }
  }
  
  static final class a<T>
    extends io.reactivex.internal.subscribers.a<T, T>
  {
    final l<? super T> y;
    
    a(io.reactivex.h0.b.a<? super T> parama, l<? super T> paraml)
    {
      super();
      this.y = paraml;
    }
    
    public boolean b(T paramT)
    {
      boolean bool1 = this.q;
      boolean bool2 = false;
      if (bool1) {
        return false;
      }
      if (this.x != 0) {
        return this.c.b(null);
      }
      try
      {
        boolean bool3 = this.y.test(paramT);
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (this.c.b(paramT)) {
            bool1 = true;
          }
        }
        return bool1;
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
      f localf = this.f;
      l locall = this.y;
      for (;;)
      {
        Object localObject = localf.poll();
        if (localObject == null) {
          return null;
        }
        if (locall.test(localObject)) {
          return (T)localObject;
        }
        if (this.x == 2) {
          localf.request(1L);
        }
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return e(paramInt);
    }
  }
  
  static final class b<T>
    extends io.reactivex.internal.subscribers.b<T, T>
    implements io.reactivex.h0.b.a<T>
  {
    final l<? super T> y;
    
    b(e.b.b<? super T> paramb, l<? super T> paraml)
    {
      super();
      this.y = paraml;
    }
    
    public boolean b(T paramT)
    {
      if (this.q) {
        return false;
      }
      if (this.x != 0)
      {
        this.c.onNext(null);
        return true;
      }
      try
      {
        boolean bool = this.y.test(paramT);
        if (bool) {
          this.c.onNext(paramT);
        }
        return bool;
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
      f localf = this.f;
      l locall = this.y;
      for (;;)
      {
        Object localObject = localf.poll();
        if (localObject == null) {
          return null;
        }
        if (locall.test(localObject)) {
          return (T)localObject;
        }
        if (this.x == 2) {
          localf.request(1L);
        }
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return e(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */