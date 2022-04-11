package io.reactivex.internal.operators.flowable;

import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class z<T>
  extends a<T, T>
{
  final j<? super h<Throwable>, ? extends e.b.a<?>> f;
  
  public z(h<T> paramh, j<? super h<Throwable>, ? extends e.b.a<?>> paramj)
  {
    super(paramh);
    this.f = paramj;
  }
  
  public void H(e.b.b<? super T> paramb)
  {
    Object localObject = new io.reactivex.n0.a(paramb);
    io.reactivex.k0.a locala = io.reactivex.k0.c.O(8).M();
    try
    {
      e.b.a locala1 = (e.b.a)io.reactivex.h0.a.b.e(this.f.apply(locala), "handler returned a null Publisher");
      w localw = new w(this.d);
      localObject = new a((e.b.b)localObject, locala, localw);
      localw.q = ((x)localObject);
      paramb.onSubscribe((e.b.c)localObject);
      locala1.a(localw);
      localw.onNext(Integer.valueOf(0));
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      EmptySubscription.error(localThrowable, paramb);
    }
  }
  
  static final class a<T>
    extends x<T, Throwable>
  {
    a(e.b.b<? super T> paramb, io.reactivex.k0.a<Throwable> parama, e.b.c paramc)
    {
      super(parama, paramc);
    }
    
    public void onComplete()
    {
      this.f.cancel();
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      a(paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */