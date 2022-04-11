package io.reactivex.internal.operators.flowable;

import e.b.a;
import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

final class w<T, U>
  extends AtomicInteger
  implements k<Object>, c
{
  final a<T> c;
  final AtomicReference<c> d;
  final AtomicLong f;
  x<T, U> q;
  
  w(a<T> parama)
  {
    this.c = parama;
    this.d = new AtomicReference();
    this.f = new AtomicLong();
  }
  
  public void cancel()
  {
    SubscriptionHelper.cancel(this.d);
  }
  
  public void onComplete()
  {
    this.q.cancel();
    this.q.c.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.q.cancel();
    this.q.c.onError(paramThrowable);
  }
  
  public void onNext(Object paramObject)
  {
    if (getAndIncrement() == 0) {
      do
      {
        if (this.d.get() == SubscriptionHelper.CANCELLED) {
          return;
        }
        this.c.a(this.q);
      } while (decrementAndGet() != 0);
    }
  }
  
  public void onSubscribe(c paramc)
  {
    SubscriptionHelper.deferredSetOnce(this.d, this.f, paramc);
  }
  
  public void request(long paramLong)
  {
    SubscriptionHelper.deferredRequest(this.d, this.f, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */