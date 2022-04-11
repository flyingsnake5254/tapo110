package io.reactivex.k0;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T>
  extends a<T>
{
  boolean H3;
  final io.reactivex.internal.queue.b<T> d;
  final AtomicReference<Runnable> f;
  volatile boolean p0;
  final AtomicBoolean p1;
  final BasicIntQueueSubscription<T> p2;
  final AtomicLong p3;
  final boolean q;
  volatile boolean x;
  Throwable y;
  final AtomicReference<e.b.b<? super T>> z;
  
  c(int paramInt)
  {
    this(paramInt, null, true);
  }
  
  c(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    this.d = new io.reactivex.internal.queue.b(io.reactivex.h0.a.b.f(paramInt, "capacityHint"));
    this.f = new AtomicReference(paramRunnable);
    this.q = paramBoolean;
    this.z = new AtomicReference();
    this.p1 = new AtomicBoolean();
    this.p2 = new a();
    this.p3 = new AtomicLong();
  }
  
  public static <T> c<T> O(int paramInt)
  {
    return new c(paramInt);
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    if ((!this.p1.get()) && (this.p1.compareAndSet(false, true)))
    {
      paramb.onSubscribe(this.p2);
      this.z.set(paramb);
      if (this.p0) {
        this.z.lazySet(null);
      } else {
        Q();
      }
    }
    else
    {
      EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), paramb);
    }
  }
  
  boolean N(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, e.b.b<? super T> paramb, io.reactivex.internal.queue.b<T> paramb1)
  {
    if (this.p0)
    {
      paramb1.clear();
      this.z.lazySet(null);
      return true;
    }
    if (paramBoolean2)
    {
      if ((paramBoolean1) && (this.y != null))
      {
        paramb1.clear();
        this.z.lazySet(null);
        paramb.onError(this.y);
        return true;
      }
      if (paramBoolean3)
      {
        paramb1 = this.y;
        this.z.lazySet(null);
        if (paramb1 != null) {
          paramb.onError(paramb1);
        } else {
          paramb.onComplete();
        }
        return true;
      }
    }
    return false;
  }
  
  void P()
  {
    Runnable localRunnable = (Runnable)this.f.getAndSet(null);
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
  
  void Q()
  {
    if (this.p2.getAndIncrement() != 0) {
      return;
    }
    int i = 1;
    for (e.b.b localb = (e.b.b)this.z.get();; localb = (e.b.b)this.z.get())
    {
      if (localb != null)
      {
        if (this.H3) {
          R(localb);
        } else {
          S(localb);
        }
        return;
      }
      i = this.p2.addAndGet(-i);
      if (i == 0) {
        return;
      }
    }
  }
  
  void R(e.b.b<? super T> paramb)
  {
    Object localObject = this.d;
    boolean bool1 = this.q;
    int i = 1;
    int j;
    do
    {
      if (this.p0)
      {
        this.z.lazySet(null);
        return;
      }
      boolean bool2 = this.x;
      if (((bool1 ^ true)) && (bool2) && (this.y != null))
      {
        ((io.reactivex.internal.queue.b)localObject).clear();
        this.z.lazySet(null);
        paramb.onError(this.y);
        return;
      }
      paramb.onNext(null);
      if (bool2)
      {
        this.z.lazySet(null);
        localObject = this.y;
        if (localObject != null) {
          paramb.onError((Throwable)localObject);
        } else {
          paramb.onComplete();
        }
        return;
      }
      j = this.p2.addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  void S(e.b.b<? super T> paramb)
  {
    io.reactivex.internal.queue.b localb = this.d;
    boolean bool1 = this.q ^ true;
    int i = 1;
    for (;;)
    {
      long l1 = this.p3.get();
      boolean bool2;
      for (long l2 = 0L;; l2 = 1L + l2)
      {
        bool2 = l1 < l2;
        if (!bool2) {
          break;
        }
        boolean bool3 = this.x;
        Object localObject = localb.poll();
        boolean bool4;
        if (localObject == null) {
          bool4 = true;
        } else {
          bool4 = false;
        }
        if (N(bool1, bool3, bool4, paramb, localb)) {
          return;
        }
        if (bool4) {
          break;
        }
        paramb.onNext(localObject);
      }
      if ((!bool2) && (N(bool1, this.x, localb.isEmpty(), paramb, localb))) {
        return;
      }
      if ((l2 != 0L) && (l1 != Long.MAX_VALUE)) {
        this.p3.addAndGet(-l2);
      }
      i = this.p2.addAndGet(-i);
      if (i == 0) {
        return;
      }
    }
  }
  
  public void onComplete()
  {
    if ((!this.x) && (!this.p0))
    {
      this.x = true;
      P();
      Q();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if ((!this.x) && (!this.p0))
    {
      this.y = paramThrowable;
      this.x = true;
      P();
      Q();
      return;
    }
    io.reactivex.j0.a.r(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if ((!this.x) && (!this.p0))
    {
      this.d.offer(paramT);
      Q();
    }
  }
  
  public void onSubscribe(e.b.c paramc)
  {
    if ((!this.x) && (!this.p0)) {
      paramc.request(Long.MAX_VALUE);
    } else {
      paramc.cancel();
    }
  }
  
  final class a
    extends BasicIntQueueSubscription<T>
  {
    a() {}
    
    public void cancel()
    {
      if (c.this.p0) {
        return;
      }
      c.this.p0 = true;
      c.this.P();
      c.this.z.lazySet(null);
      if (c.this.p2.getAndIncrement() == 0)
      {
        c.this.z.lazySet(null);
        c localc = c.this;
        if (!localc.H3) {
          localc.d.clear();
        }
      }
    }
    
    public void clear()
    {
      c.this.d.clear();
    }
    
    public boolean isEmpty()
    {
      return c.this.d.isEmpty();
    }
    
    public T poll()
    {
      return (T)c.this.d.poll();
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        io.reactivex.internal.util.b.a(c.this.p3, paramLong);
        c.this.Q();
      }
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        c.this.H3 = true;
        return 2;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\k0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */