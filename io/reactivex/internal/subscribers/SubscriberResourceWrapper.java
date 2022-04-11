package io.reactivex.internal.subscribers;

import e.b.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

public final class SubscriberResourceWrapper<T>
  extends AtomicReference<io.reactivex.e0.c>
  implements k<T>, io.reactivex.e0.c, e.b.c
{
  private static final long serialVersionUID = -8612022020200669122L;
  final b<? super T> downstream;
  final AtomicReference<e.b.c> upstream = new AtomicReference();
  
  public SubscriberResourceWrapper(b<? super T> paramb)
  {
    this.downstream = paramb;
  }
  
  public void cancel()
  {
    dispose();
  }
  
  public void dispose()
  {
    SubscriptionHelper.cancel(this.upstream);
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (this.upstream.get() == SubscriptionHelper.CANCELLED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onComplete()
  {
    DisposableHelper.dispose(this);
    this.downstream.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    DisposableHelper.dispose(this);
    this.downstream.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.downstream.onNext(paramT);
  }
  
  public void onSubscribe(e.b.c paramc)
  {
    if (SubscriptionHelper.setOnce(this.upstream, paramc)) {
      this.downstream.onSubscribe(this);
    }
  }
  
  public void request(long paramLong)
  {
    if (SubscriptionHelper.validate(paramLong)) {
      ((e.b.c)this.upstream.get()).request(paramLong);
    }
  }
  
  public void setResource(io.reactivex.e0.c paramc)
  {
    DisposableHelper.set(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\SubscriberResourceWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */