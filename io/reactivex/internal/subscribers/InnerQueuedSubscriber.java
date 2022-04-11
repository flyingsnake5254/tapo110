package io.reactivex.internal.subscribers;

import io.reactivex.h0.b.e;
import io.reactivex.h0.b.f;
import io.reactivex.h0.b.i;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.j;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedSubscriber<T>
  extends AtomicReference<e.b.c>
  implements k<T>, e.b.c
{
  private static final long serialVersionUID = 22876611072430776L;
  volatile boolean done;
  int fusionMode;
  final int limit;
  final c<T> parent;
  final int prefetch;
  long produced;
  volatile i<T> queue;
  
  public InnerQueuedSubscriber(c<T> paramc, int paramInt)
  {
    this.parent = paramc;
    this.prefetch = paramInt;
    this.limit = (paramInt - (paramInt >> 2));
  }
  
  public void cancel()
  {
    SubscriptionHelper.cancel(this);
  }
  
  public boolean isDone()
  {
    return this.done;
  }
  
  public void onComplete()
  {
    this.parent.c(this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.d(this, paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.fusionMode == 0) {
      this.parent.b(this, paramT);
    } else {
      this.parent.a();
    }
  }
  
  public void onSubscribe(e.b.c paramc)
  {
    if (SubscriptionHelper.setOnce(this, paramc))
    {
      if ((paramc instanceof f))
      {
        f localf = (f)paramc;
        int i = localf.requestFusion(3);
        if (i == 1)
        {
          this.fusionMode = i;
          this.queue = localf;
          this.done = true;
          this.parent.c(this);
          return;
        }
        if (i == 2)
        {
          this.fusionMode = i;
          this.queue = localf;
          j.d(paramc, this.prefetch);
          return;
        }
      }
      this.queue = j.b(this.prefetch);
      j.d(paramc, this.prefetch);
    }
  }
  
  public i<T> queue()
  {
    return this.queue;
  }
  
  public void request(long paramLong)
  {
    if (this.fusionMode != 1)
    {
      paramLong = this.produced + paramLong;
      if (paramLong >= this.limit)
      {
        this.produced = 0L;
        ((e.b.c)get()).request(paramLong);
      }
      else
      {
        this.produced = paramLong;
      }
    }
  }
  
  public void requestOne()
  {
    if (this.fusionMode != 1)
    {
      long l = this.produced + 1L;
      if (l == this.limit)
      {
        this.produced = 0L;
        ((e.b.c)get()).request(l);
      }
      else
      {
        this.produced = l;
      }
    }
  }
  
  public void setDone()
  {
    this.done = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\InnerQueuedSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */