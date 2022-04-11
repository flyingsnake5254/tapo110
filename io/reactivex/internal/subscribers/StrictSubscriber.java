package io.reactivex.internal.subscribers;

import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class StrictSubscriber<T>
  extends AtomicInteger
  implements k<T>, c
{
  private static final long serialVersionUID = -4945028590049415624L;
  volatile boolean done;
  final b<? super T> downstream;
  final AtomicThrowable error;
  final AtomicBoolean once;
  final AtomicLong requested;
  final AtomicReference<c> upstream;
  
  public StrictSubscriber(b<? super T> paramb)
  {
    this.downstream = paramb;
    this.error = new AtomicThrowable();
    this.requested = new AtomicLong();
    this.upstream = new AtomicReference();
    this.once = new AtomicBoolean();
  }
  
  public void cancel()
  {
    if (!this.done) {
      SubscriptionHelper.cancel(this.upstream);
    }
  }
  
  public void onComplete()
  {
    this.done = true;
    f.b(this.downstream, this, this.error);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.done = true;
    f.d(this.downstream, paramThrowable, this, this.error);
  }
  
  public void onNext(T paramT)
  {
    f.f(this.downstream, paramT, this, this.error);
  }
  
  public void onSubscribe(c paramc)
  {
    if (this.once.compareAndSet(false, true))
    {
      this.downstream.onSubscribe(this);
      SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, paramc);
    }
    else
    {
      paramc.cancel();
      cancel();
      onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong <= 0L)
    {
      cancel();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("§3.9 violated: positive request amount required but it was ");
      localStringBuilder.append(paramLong);
      onError(new IllegalArgumentException(localStringBuilder.toString()));
    }
    else
    {
      SubscriptionHelper.deferredRequest(this.upstream, this.requested, paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\StrictSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */