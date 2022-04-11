package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.l;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;

public final class y<T>
  extends a<T, T>
{
  final l<? super Throwable> f;
  final long q;
  
  public y(h<T> paramh, long paramLong, l<? super Throwable> paraml)
  {
    super(paramh);
    this.f = paraml;
    this.q = paramLong;
  }
  
  public void H(b<? super T> paramb)
  {
    SubscriptionArbiter localSubscriptionArbiter = new SubscriptionArbiter(false);
    paramb.onSubscribe(localSubscriptionArbiter);
    new a(paramb, this.q, this.f, localSubscriptionArbiter, this.d).a();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements k<T>
  {
    final b<? super T> c;
    final SubscriptionArbiter d;
    final e.b.a<? extends T> f;
    final l<? super Throwable> q;
    long x;
    long y;
    
    a(b<? super T> paramb, long paramLong, l<? super Throwable> paraml, SubscriptionArbiter paramSubscriptionArbiter, e.b.a<? extends T> parama)
    {
      this.c = paramb;
      this.d = paramSubscriptionArbiter;
      this.f = parama;
      this.q = paraml;
      this.x = paramLong;
    }
    
    void a()
    {
      if (getAndIncrement() == 0)
      {
        int i = 1;
        int j;
        do
        {
          if (this.d.isCancelled()) {
            return;
          }
          long l = this.y;
          if (l != 0L)
          {
            this.y = 0L;
            this.d.produced(l);
          }
          this.f.a(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      long l = this.x;
      if (l != Long.MAX_VALUE) {
        this.x = (l - 1L);
      }
      if (l == 0L) {
        this.c.onError(paramThrowable);
      }
      try
      {
        boolean bool = this.q.test(paramThrowable);
        if (!bool)
        {
          this.c.onError(paramThrowable);
          return;
        }
        a();
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
      this.y += 1L;
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      this.d.setSubscription(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */