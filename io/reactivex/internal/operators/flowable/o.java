package io.reactivex.internal.operators.flowable;

import e.b.a;
import e.b.c;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

final class o<T, K>
  extends BasicIntQueueSubscription<T>
  implements a<T>
{
  int H3;
  final K c;
  final io.reactivex.internal.queue.b<T> d;
  final FlowableGroupBy.GroupBySubscriber<?, K, T> f;
  final AtomicBoolean p0 = new AtomicBoolean();
  final AtomicReference<e.b.b<? super T>> p1 = new AtomicReference();
  final AtomicBoolean p2 = new AtomicBoolean();
  boolean p3;
  final boolean q;
  final AtomicLong x = new AtomicLong();
  volatile boolean y;
  Throwable z;
  
  o(int paramInt, FlowableGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, K paramK, boolean paramBoolean)
  {
    this.d = new io.reactivex.internal.queue.b(paramInt);
    this.f = paramGroupBySubscriber;
    this.c = paramK;
    this.q = paramBoolean;
  }
  
  public void a(e.b.b<? super T> paramb)
  {
    if (this.p2.compareAndSet(false, true))
    {
      paramb.onSubscribe(this);
      this.p1.lazySet(paramb);
      drain();
    }
    else
    {
      EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), paramb);
    }
  }
  
  public void cancel()
  {
    if (this.p0.compareAndSet(false, true))
    {
      this.f.cancel(this.c);
      drain();
    }
  }
  
  public void clear()
  {
    io.reactivex.internal.queue.b localb = this.d;
    while (localb.poll() != null) {
      this.H3 += 1;
    }
    f();
  }
  
  boolean d(boolean paramBoolean1, boolean paramBoolean2, e.b.b<? super T> paramb, boolean paramBoolean3, long paramLong)
  {
    if (this.p0.get())
    {
      while (this.d.poll() != null) {
        paramLong += 1L;
      }
      if (paramLong != 0L) {
        this.f.upstream.request(paramLong);
      }
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable;
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          localThrowable = this.z;
          if (localThrowable != null) {
            paramb.onError(localThrowable);
          } else {
            paramb.onComplete();
          }
          return true;
        }
      }
      else
      {
        localThrowable = this.z;
        if (localThrowable != null)
        {
          this.d.clear();
          paramb.onError(localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          paramb.onComplete();
          return true;
        }
      }
    }
    return false;
  }
  
  void drain()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    if (this.p3) {
      drainFused();
    } else {
      drainNormal();
    }
  }
  
  void drainFused()
  {
    Object localObject = this.d;
    e.b.b localb = (e.b.b)this.p1.get();
    int i = 1;
    for (;;)
    {
      if (localb != null)
      {
        if (this.p0.get()) {
          return;
        }
        boolean bool = this.y;
        if ((bool) && (!this.q))
        {
          Throwable localThrowable = this.z;
          if (localThrowable != null)
          {
            ((io.reactivex.internal.queue.b)localObject).clear();
            localb.onError(localThrowable);
            return;
          }
        }
        localb.onNext(null);
        if (bool)
        {
          localObject = this.z;
          if (localObject != null) {
            localb.onError((Throwable)localObject);
          } else {
            localb.onComplete();
          }
          return;
        }
      }
      int j = addAndGet(-i);
      if (j == 0) {
        return;
      }
      i = j;
      if (localb == null)
      {
        localb = (e.b.b)this.p1.get();
        i = j;
      }
    }
  }
  
  void drainNormal()
  {
    io.reactivex.internal.queue.b localb = this.d;
    boolean bool1 = this.q;
    e.b.b localb1 = (e.b.b)this.p1.get();
    int i = 1;
    for (;;)
    {
      if (localb1 != null)
      {
        long l1 = this.x.get();
        boolean bool2;
        long l3;
        for (long l2 = 0L;; l2 += 1L)
        {
          bool2 = l2 < l1;
          l3 = l2;
          if (!bool2) {
            break;
          }
          boolean bool3 = this.y;
          Object localObject = localb.poll();
          boolean bool4;
          if (localObject == null) {
            bool4 = true;
          } else {
            bool4 = false;
          }
          if (d(bool3, bool4, localb1, bool1, l2)) {
            return;
          }
          if (bool4)
          {
            l3 = l2;
            break;
          }
          localb1.onNext(localObject);
        }
        l2 = l3;
        if (!bool2)
        {
          if (d(this.y, localb.isEmpty(), localb1, bool1, l3)) {
            return;
          }
          l2 = l3;
        }
        if (l2 != 0L)
        {
          if (l1 != Long.MAX_VALUE) {
            this.x.addAndGet(-l2);
          }
          this.f.upstream.request(l2);
        }
      }
      int j = addAndGet(-i);
      if (j == 0) {
        return;
      }
      i = j;
      if (localb1 == null)
      {
        localb1 = (e.b.b)this.p1.get();
        i = j;
      }
    }
  }
  
  void f()
  {
    int i = this.H3;
    if (i != 0)
    {
      this.H3 = 0;
      this.f.upstream.request(i);
    }
  }
  
  public boolean isEmpty()
  {
    if (this.d.isEmpty())
    {
      f();
      return true;
    }
    return false;
  }
  
  public void onComplete()
  {
    this.y = true;
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.z = paramThrowable;
    this.y = true;
    drain();
  }
  
  public void onNext(T paramT)
  {
    this.d.offer(paramT);
    drain();
  }
  
  public T poll()
  {
    Object localObject = this.d.poll();
    if (localObject != null)
    {
      this.H3 += 1;
      return (T)localObject;
    }
    f();
    return null;
  }
  
  public void request(long paramLong)
  {
    if (SubscriptionHelper.validate(paramLong))
    {
      io.reactivex.internal.util.b.a(this.x, paramLong);
      drain();
    }
  }
  
  public int requestFusion(int paramInt)
  {
    if ((paramInt & 0x2) != 0)
    {
      this.p3 = true;
      return 2;
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */