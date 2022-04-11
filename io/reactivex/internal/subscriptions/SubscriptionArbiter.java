package io.reactivex.internal.subscriptions;

import e.b.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class SubscriptionArbiter
  extends AtomicInteger
  implements c
{
  private static final long serialVersionUID = -2189523197179400958L;
  c actual;
  final boolean cancelOnReplace;
  volatile boolean cancelled;
  final AtomicLong missedProduced;
  final AtomicLong missedRequested;
  final AtomicReference<c> missedSubscription;
  long requested;
  protected boolean unbounded;
  
  public SubscriptionArbiter(boolean paramBoolean)
  {
    this.cancelOnReplace = paramBoolean;
    this.missedSubscription = new AtomicReference();
    this.missedRequested = new AtomicLong();
    this.missedProduced = new AtomicLong();
  }
  
  public void cancel()
  {
    if (!this.cancelled)
    {
      this.cancelled = true;
      drain();
    }
  }
  
  final void drain()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    drainLoop();
  }
  
  final void drainLoop()
  {
    int i = 1;
    Object localObject1 = null;
    long l1 = 0L;
    Object localObject2;
    long l2;
    int j;
    do
    {
      localObject2 = (c)this.missedSubscription.get();
      Object localObject3 = localObject2;
      if (localObject2 != null) {
        localObject3 = (c)this.missedSubscription.getAndSet(null);
      }
      l2 = this.missedRequested.get();
      long l3 = l2;
      if (l2 != 0L) {
        l3 = this.missedRequested.getAndSet(0L);
      }
      l2 = this.missedProduced.get();
      long l4 = l2;
      if (l2 != 0L) {
        l4 = this.missedProduced.getAndSet(0L);
      }
      c localc = this.actual;
      if (this.cancelled)
      {
        if (localc != null)
        {
          localc.cancel();
          this.actual = null;
        }
        l2 = l1;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((c)localObject3).cancel();
          l2 = l1;
          localObject2 = localObject1;
        }
      }
      else
      {
        l2 = this.requested;
        long l5 = l2;
        if (l2 != Long.MAX_VALUE)
        {
          l5 = io.reactivex.internal.util.b.b(l2, l3);
          l2 = l5;
          if (l5 != Long.MAX_VALUE)
          {
            l4 = l5 - l4;
            l2 = l4;
            if (l4 < 0L)
            {
              SubscriptionHelper.reportMoreProduced(l4);
              l2 = 0L;
            }
          }
          this.requested = l2;
          l5 = l2;
        }
        if (localObject3 != null)
        {
          if ((localc != null) && (this.cancelOnReplace)) {
            localc.cancel();
          }
          this.actual = ((c)localObject3);
          l2 = l1;
          localObject2 = localObject1;
          if (l5 != 0L)
          {
            l2 = io.reactivex.internal.util.b.b(l1, l5);
            localObject2 = localObject3;
          }
        }
        else
        {
          l2 = l1;
          localObject2 = localObject1;
          if (localc != null)
          {
            l2 = l1;
            localObject2 = localObject1;
            if (l3 != 0L)
            {
              l2 = io.reactivex.internal.util.b.b(l1, l3);
              localObject2 = localc;
            }
          }
        }
      }
      j = addAndGet(-i);
      i = j;
      l1 = l2;
      localObject1 = localObject2;
    } while (j != 0);
    if (l2 != 0L) {
      ((c)localObject2).request(l2);
    }
  }
  
  public final boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public final boolean isUnbounded()
  {
    return this.unbounded;
  }
  
  public final void produced(long paramLong)
  {
    if (this.unbounded) {
      return;
    }
    if ((get() == 0) && (compareAndSet(0, 1)))
    {
      long l = this.requested;
      if (l != Long.MAX_VALUE)
      {
        l -= paramLong;
        paramLong = l;
        if (l < 0L)
        {
          SubscriptionHelper.reportMoreProduced(l);
          paramLong = 0L;
        }
        this.requested = paramLong;
      }
      if (decrementAndGet() == 0) {
        return;
      }
      drainLoop();
      return;
    }
    io.reactivex.internal.util.b.a(this.missedProduced, paramLong);
    drain();
  }
  
  public final void request(long paramLong)
  {
    if (SubscriptionHelper.validate(paramLong))
    {
      if (this.unbounded) {
        return;
      }
      if ((get() == 0) && (compareAndSet(0, 1)))
      {
        long l = this.requested;
        if (l != Long.MAX_VALUE)
        {
          l = io.reactivex.internal.util.b.b(l, paramLong);
          this.requested = l;
          if (l == Long.MAX_VALUE) {
            this.unbounded = true;
          }
        }
        c localc = this.actual;
        if (decrementAndGet() != 0) {
          drainLoop();
        }
        if (localc != null) {
          localc.request(paramLong);
        }
        return;
      }
      io.reactivex.internal.util.b.a(this.missedRequested, paramLong);
      drain();
    }
  }
  
  public final void setSubscription(c paramc)
  {
    if (this.cancelled)
    {
      paramc.cancel();
      return;
    }
    io.reactivex.h0.a.b.e(paramc, "s is null");
    if ((get() == 0) && (compareAndSet(0, 1)))
    {
      c localc = this.actual;
      if ((localc != null) && (this.cancelOnReplace)) {
        localc.cancel();
      }
      this.actual = paramc;
      long l = this.requested;
      if (decrementAndGet() != 0) {
        drainLoop();
      }
      if (l != 0L) {
        paramc.request(l);
      }
      return;
    }
    paramc = (c)this.missedSubscription.getAndSet(paramc);
    if ((paramc != null) && (this.cancelOnReplace)) {
      paramc.cancel();
    }
    drain();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\SubscriptionArbiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */