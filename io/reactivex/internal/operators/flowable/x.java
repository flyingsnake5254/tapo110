package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.k;
import io.reactivex.k0.a;

abstract class x<T, U>
  extends SubscriptionArbiter
  implements k<T>
{
  protected final b<? super T> c;
  protected final a<U> d;
  protected final c f;
  private long q;
  
  x(b<? super T> paramb, a<U> parama, c paramc)
  {
    super(false);
    this.c = paramb;
    this.d = parama;
    this.f = paramc;
  }
  
  protected final void a(U paramU)
  {
    setSubscription(EmptySubscription.INSTANCE);
    long l = this.q;
    if (l != 0L)
    {
      this.q = 0L;
      produced(l);
    }
    this.f.request(1L);
    this.d.onNext(paramU);
  }
  
  public final void cancel()
  {
    super.cancel();
    this.f.cancel();
  }
  
  public final void onNext(T paramT)
  {
    this.q += 1L;
    this.c.onNext(paramT);
  }
  
  public final void onSubscribe(c paramc)
  {
    setSubscription(paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */