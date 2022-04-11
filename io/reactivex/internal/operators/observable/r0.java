package io.reactivex.internal.operators.observable;

import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.Callable;

public final class r0<T, R>
  extends a<T, R>
{
  final io.reactivex.g0.c<R, ? super T, R> d;
  final Callable<R> f;
  
  public r0(t<T> paramt, Callable<R> paramCallable, io.reactivex.g0.c<R, ? super T, R> paramc)
  {
    super(paramt);
    this.d = paramc;
    this.f = paramCallable;
  }
  
  public void K0(v<? super R> paramv)
  {
    try
    {
      Object localObject = b.e(this.f.call(), "The seed supplied is null");
      this.c.a(new a(paramv, this.d, localObject));
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      EmptyDisposable.error(localThrowable, paramv);
    }
  }
  
  static final class a<T, R>
    implements v<T>, io.reactivex.e0.c
  {
    final v<? super R> c;
    final io.reactivex.g0.c<R, ? super T, R> d;
    R f;
    io.reactivex.e0.c q;
    boolean x;
    
    a(v<? super R> paramv, io.reactivex.g0.c<R, ? super T, R> paramc, R paramR)
    {
      this.c = paramv;
      this.d = paramc;
      this.f = paramR;
    }
    
    public void dispose()
    {
      this.q.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.q.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.x) {
        return;
      }
      this.x = true;
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.x)
      {
        io.reactivex.j0.a.r(paramThrowable);
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
      Object localObject = this.f;
      try
      {
        paramT = b.e(this.d.apply(localObject, paramT), "The accumulator returned a null value");
        this.f = paramT;
        this.c.onNext(paramT);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.q.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.q, paramc))
      {
        this.q = paramc;
        this.c.onSubscribe(this);
        this.c.onNext(this.f);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */