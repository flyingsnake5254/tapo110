package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.j0.a;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T>
  extends g<T>
{
  final io.reactivex.internal.queue.b<T> c;
  final AtomicReference<v<? super T>> d;
  final AtomicReference<Runnable> f;
  final AtomicBoolean p0;
  final BasicIntQueueDisposable<T> p1;
  boolean p2;
  final boolean q;
  volatile boolean x;
  volatile boolean y;
  Throwable z;
  
  h(int paramInt, boolean paramBoolean)
  {
    this.c = new io.reactivex.internal.queue.b(io.reactivex.h0.a.b.f(paramInt, "capacityHint"));
    this.f = new AtomicReference();
    this.q = paramBoolean;
    this.d = new AtomicReference();
    this.p0 = new AtomicBoolean();
    this.p1 = new a();
  }
  
  public static <T> h<T> m1()
  {
    return new h(q.d(), true);
  }
  
  protected void K0(v<? super T> paramv)
  {
    if ((!this.p0.get()) && (this.p0.compareAndSet(false, true)))
    {
      paramv.onSubscribe(this.p1);
      this.d.lazySet(paramv);
      if (this.x)
      {
        this.d.lazySet(null);
        return;
      }
      o1();
    }
    else
    {
      EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), paramv);
    }
  }
  
  public boolean j1()
  {
    boolean bool;
    if ((this.y) && (this.z == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k1()
  {
    boolean bool;
    if ((this.y) && (this.z != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void n1()
  {
    Runnable localRunnable = (Runnable)this.f.get();
    if ((localRunnable != null) && (this.f.compareAndSet(localRunnable, null))) {
      localRunnable.run();
    }
  }
  
  void o1()
  {
    if (this.p1.getAndIncrement() != 0) {
      return;
    }
    v localv = (v)this.d.get();
    int i = 1;
    for (;;)
    {
      if (localv != null)
      {
        if (this.p2) {
          p1(localv);
        } else {
          q1(localv);
        }
        return;
      }
      i = this.p1.addAndGet(-i);
      if (i == 0) {
        return;
      }
      localv = (v)this.d.get();
    }
  }
  
  public void onComplete()
  {
    if ((!this.y) && (!this.x))
    {
      this.y = true;
      n1();
      o1();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if ((!this.y) && (!this.x))
    {
      this.z = paramThrowable;
      this.y = true;
      n1();
      o1();
      return;
    }
    a.r(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if ((!this.y) && (!this.x))
    {
      this.c.offer(paramT);
      o1();
    }
  }
  
  public void onSubscribe(c paramc)
  {
    if ((this.y) || (this.x)) {
      paramc.dispose();
    }
  }
  
  void p1(v<? super T> paramv)
  {
    io.reactivex.internal.queue.b localb = this.c;
    boolean bool1 = this.q;
    int i = 1;
    int j;
    do
    {
      if (this.x)
      {
        this.d.lazySet(null);
        return;
      }
      boolean bool2 = this.y;
      if (((bool1 ^ true)) && (bool2) && (s1(localb, paramv))) {
        return;
      }
      paramv.onNext(null);
      if (bool2)
      {
        r1(paramv);
        return;
      }
      j = this.p1.addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  void q1(v<? super T> paramv)
  {
    io.reactivex.internal.queue.b localb = this.c;
    boolean bool1 = this.q;
    int i = 1;
    int j = 1;
    for (;;)
    {
      if (this.x)
      {
        this.d.lazySet(null);
        localb.clear();
        return;
      }
      boolean bool2 = this.y;
      Object localObject = this.c.poll();
      int k;
      if (localObject == null) {
        k = 1;
      } else {
        k = 0;
      }
      int m = i;
      if (bool2)
      {
        m = i;
        if ((bool1 ^ true))
        {
          m = i;
          if (i != 0)
          {
            if (s1(localb, paramv)) {
              return;
            }
            m = 0;
          }
        }
        if (k != 0)
        {
          r1(paramv);
          return;
        }
      }
      if (k != 0)
      {
        k = this.p1.addAndGet(-j);
        i = m;
        j = k;
        if (k != 0) {}
      }
      else
      {
        paramv.onNext(localObject);
        i = m;
      }
    }
  }
  
  void r1(v<? super T> paramv)
  {
    this.d.lazySet(null);
    Throwable localThrowable = this.z;
    if (localThrowable != null) {
      paramv.onError(localThrowable);
    } else {
      paramv.onComplete();
    }
  }
  
  boolean s1(i<T> parami, v<? super T> paramv)
  {
    Throwable localThrowable = this.z;
    if (localThrowable != null)
    {
      this.d.lazySet(null);
      parami.clear();
      paramv.onError(localThrowable);
      return true;
    }
    return false;
  }
  
  final class a
    extends BasicIntQueueDisposable<T>
  {
    a() {}
    
    public void clear()
    {
      h.this.c.clear();
    }
    
    public void dispose()
    {
      if (!h.this.x)
      {
        h.this.x = true;
        h.this.n1();
        h.this.d.lazySet(null);
        if (h.this.p1.getAndIncrement() == 0)
        {
          h.this.d.lazySet(null);
          h localh = h.this;
          if (!localh.p2) {
            localh.c.clear();
          }
        }
      }
    }
    
    public boolean isDisposed()
    {
      return h.this.x;
    }
    
    public boolean isEmpty()
    {
      return h.this.c.isEmpty();
    }
    
    public T poll()
      throws Exception
    {
      return (T)h.this.c.poll();
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        h.this.p2 = true;
        return 2;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */