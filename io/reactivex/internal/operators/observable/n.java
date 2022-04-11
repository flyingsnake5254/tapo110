package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

public final class n<T>
  extends io.reactivex.m<T>
  implements io.reactivex.h0.b.c<T>
{
  final t<T> c;
  final long d;
  
  public n(t<T> paramt, long paramLong)
  {
    this.c = paramt;
    this.d = paramLong;
  }
  
  public q<T> b()
  {
    return a.n(new m(this.c, this.d, null, false));
  }
  
  public void n(io.reactivex.n<? super T> paramn)
  {
    this.c.a(new a(paramn, this.d));
  }
  
  static final class a<T>
    implements v<T>, io.reactivex.e0.c
  {
    final io.reactivex.n<? super T> c;
    final long d;
    io.reactivex.e0.c f;
    long q;
    boolean x;
    
    a(io.reactivex.n<? super T> paramn, long paramLong)
    {
      this.c = paramn;
      this.d = paramLong;
    }
    
    public void dispose()
    {
      this.f.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.x)
      {
        this.x = true;
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.x)
      {
        a.r(paramThrowable);
        return;
      }
      this.x = true;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.x) {
        return;
      }
      long l = this.q;
      if (l == this.d)
      {
        this.x = true;
        this.f.dispose();
        this.c.onSuccess(paramT);
        return;
      }
      this.q = (l + 1L);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */