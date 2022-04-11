package io.reactivex.internal.subscriptions;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubscription
  extends AtomicLong
  implements e.b.c, io.reactivex.e0.c
{
  private static final long serialVersionUID = 7028635084060361255L;
  final AtomicReference<e.b.c> actual = new AtomicReference();
  final AtomicReference<io.reactivex.e0.c> resource = new AtomicReference();
  
  public AsyncSubscription() {}
  
  public AsyncSubscription(io.reactivex.e0.c paramc)
  {
    this();
    this.resource.lazySet(paramc);
  }
  
  public void cancel()
  {
    dispose();
  }
  
  public void dispose()
  {
    SubscriptionHelper.cancel(this.actual);
    DisposableHelper.dispose(this.resource);
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (this.actual.get() == SubscriptionHelper.CANCELLED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean replaceResource(io.reactivex.e0.c paramc)
  {
    return DisposableHelper.replace(this.resource, paramc);
  }
  
  public void request(long paramLong)
  {
    SubscriptionHelper.deferredRequest(this.actual, this, paramLong);
  }
  
  public boolean setResource(io.reactivex.e0.c paramc)
  {
    return DisposableHelper.set(this.resource, paramc);
  }
  
  public void setSubscription(e.b.c paramc)
  {
    SubscriptionHelper.deferredSetOnce(this.actual, this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\AsyncSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */