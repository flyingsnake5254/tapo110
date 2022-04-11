package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.k;

public final class v<T>
  extends a<T, T>
{
  final j<? super Throwable, ? extends e.b.a<? extends T>> f;
  final boolean q;
  
  public v(h<T> paramh, j<? super Throwable, ? extends e.b.a<? extends T>> paramj, boolean paramBoolean)
  {
    super(paramh);
    this.f = paramj;
    this.q = paramBoolean;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    a locala = new a(paramb, this.f, this.q);
    paramb.onSubscribe(locala);
    this.d.G(locala);
  }
  
  static final class a<T>
    extends SubscriptionArbiter
    implements k<T>
  {
    final e.b.b<? super T> c;
    final j<? super Throwable, ? extends e.b.a<? extends T>> d;
    final boolean f;
    boolean q;
    boolean x;
    long y;
    
    a(e.b.b<? super T> paramb, j<? super Throwable, ? extends e.b.a<? extends T>> paramj, boolean paramBoolean)
    {
      super();
      this.c = paramb;
      this.d = paramj;
      this.f = paramBoolean;
    }
    
    public void onComplete()
    {
      if (this.x) {
        return;
      }
      this.x = true;
      this.q = true;
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.q)
      {
        if (this.x)
        {
          io.reactivex.j0.a.r(paramThrowable);
          return;
        }
        this.c.onError(paramThrowable);
        return;
      }
      this.q = true;
      if ((this.f) && (!(paramThrowable instanceof Exception)))
      {
        this.c.onError(paramThrowable);
        return;
      }
      try
      {
        e.b.a locala = (e.b.a)io.reactivex.h0.a.b.e(this.d.apply(paramThrowable), "The nextSupplier returned a null Publisher");
        long l = this.y;
        if (l != 0L) {
          produced(l);
        }
        locala.a(this);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.x) {
        return;
      }
      if (!this.q) {
        this.y += 1L;
      }
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      setSubscription(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */