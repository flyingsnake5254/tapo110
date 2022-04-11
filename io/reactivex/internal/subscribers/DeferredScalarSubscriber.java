package io.reactivex.internal.subscribers;

import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;

public abstract class DeferredScalarSubscriber<T, R>
  extends DeferredScalarSubscription<R>
  implements k<T>
{
  private static final long serialVersionUID = 2984505488220891551L;
  protected boolean hasValue;
  protected c upstream;
  
  public DeferredScalarSubscriber(b<? super R> paramb)
  {
    super(paramb);
  }
  
  public void cancel()
  {
    super.cancel();
    this.upstream.cancel();
  }
  
  public void onComplete()
  {
    if (this.hasValue) {
      complete(this.value);
    } else {
      this.downstream.onComplete();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.value = null;
    this.downstream.onError(paramThrowable);
  }
  
  public void onSubscribe(c paramc)
  {
    if (SubscriptionHelper.validate(this.upstream, paramc))
    {
      this.upstream = paramc;
      this.downstream.onSubscribe(this);
      paramc.request(Long.MAX_VALUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\DeferredScalarSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */