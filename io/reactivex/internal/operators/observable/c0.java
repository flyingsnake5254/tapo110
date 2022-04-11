package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class c0<T, K>
  extends AtomicInteger
  implements c, t<T>
{
  final K c;
  final b<T> d;
  final ObservableGroupBy.GroupByObserver<?, K, T> f;
  final AtomicBoolean p0 = new AtomicBoolean();
  final AtomicReference<v<? super T>> p1 = new AtomicReference();
  final boolean q;
  volatile boolean x;
  Throwable y;
  final AtomicBoolean z = new AtomicBoolean();
  
  c0(int paramInt, ObservableGroupBy.GroupByObserver<?, K, T> paramGroupByObserver, K paramK, boolean paramBoolean)
  {
    this.d = new b(paramInt);
    this.f = paramGroupByObserver;
    this.c = paramK;
    this.q = paramBoolean;
  }
  
  public void a(v<? super T> paramv)
  {
    if (this.p0.compareAndSet(false, true))
    {
      paramv.onSubscribe(this);
      this.p1.lazySet(paramv);
      if (this.z.get()) {
        this.p1.lazySet(null);
      } else {
        d();
      }
    }
    else
    {
      EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), paramv);
    }
  }
  
  boolean b(boolean paramBoolean1, boolean paramBoolean2, v<? super T> paramv, boolean paramBoolean3)
  {
    if (this.z.get())
    {
      this.d.clear();
      this.f.cancel(this.c);
      this.p1.lazySet(null);
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable;
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          localThrowable = this.y;
          this.p1.lazySet(null);
          if (localThrowable != null) {
            paramv.onError(localThrowable);
          } else {
            paramv.onComplete();
          }
          return true;
        }
      }
      else
      {
        localThrowable = this.y;
        if (localThrowable != null)
        {
          this.d.clear();
          this.p1.lazySet(null);
          paramv.onError(localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          this.p1.lazySet(null);
          paramv.onComplete();
          return true;
        }
      }
    }
    return false;
  }
  
  void d()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    b localb = this.d;
    boolean bool1 = this.q;
    v localv = (v)this.p1.get();
    int i = 1;
    for (;;)
    {
      if (localv != null) {
        for (;;)
        {
          boolean bool2 = this.x;
          Object localObject = localb.poll();
          boolean bool3;
          if (localObject == null) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          if (b(bool2, bool3, localv, bool1)) {
            return;
          }
          if (bool3) {
            break;
          }
          localv.onNext(localObject);
        }
      }
      int j = addAndGet(-i);
      if (j == 0) {
        return;
      }
      i = j;
      if (localv == null)
      {
        localv = (v)this.p1.get();
        i = j;
      }
    }
  }
  
  public void dispose()
  {
    if ((this.z.compareAndSet(false, true)) && (getAndIncrement() == 0))
    {
      this.p1.lazySet(null);
      this.f.cancel(this.c);
    }
  }
  
  public void f()
  {
    this.x = true;
    d();
  }
  
  public void g(Throwable paramThrowable)
  {
    this.y = paramThrowable;
    this.x = true;
    d();
  }
  
  public void h(T paramT)
  {
    this.d.offer(paramT);
    d();
  }
  
  public boolean isDisposed()
  {
    return this.z.get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */