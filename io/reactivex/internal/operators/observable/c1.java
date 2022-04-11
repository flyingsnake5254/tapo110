package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.e;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class c1<T>
  extends a<T, T>
{
  final long d;
  final TimeUnit f;
  final w q;
  final t<? extends T> x;
  
  public c1(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, w paramw, t<? extends T> paramt)
  {
    super(paramq);
    this.d = paramLong;
    this.f = paramTimeUnit;
    this.q = paramw;
    this.x = paramt;
  }
  
  protected void K0(v<? super T> paramv)
  {
    Object localObject;
    if (this.x == null)
    {
      localObject = new c(paramv, this.d, this.f, this.q.b());
      paramv.onSubscribe((c)localObject);
      ((c)localObject).b(0L);
      this.c.a((v)localObject);
    }
    else
    {
      localObject = new b(paramv, this.d, this.f, this.q.b(), this.x);
      paramv.onSubscribe((c)localObject);
      ((b)localObject).b(0L);
      this.c.a((v)localObject);
    }
  }
  
  static final class a<T>
    implements v<T>
  {
    final v<? super T> c;
    final AtomicReference<c> d;
    
    a(v<? super T> paramv, AtomicReference<c> paramAtomicReference)
    {
      this.c = paramv;
      this.d = paramAtomicReference;
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.replace(this.d, paramc);
    }
  }
  
  static final class b<T>
    extends AtomicReference<c>
    implements v<T>, c, c1.d
  {
    final v<? super T> c;
    final long d;
    final TimeUnit f;
    t<? extends T> p0;
    final w.c q;
    final SequentialDisposable x;
    final AtomicLong y;
    final AtomicReference<c> z;
    
    b(v<? super T> paramv, long paramLong, TimeUnit paramTimeUnit, w.c paramc, t<? extends T> paramt)
    {
      this.c = paramv;
      this.d = paramLong;
      this.f = paramTimeUnit;
      this.q = paramc;
      this.p0 = paramt;
      this.x = new SequentialDisposable();
      this.y = new AtomicLong();
      this.z = new AtomicReference();
    }
    
    public void a(long paramLong)
    {
      if (this.y.compareAndSet(paramLong, Long.MAX_VALUE))
      {
        DisposableHelper.dispose(this.z);
        t localt = this.p0;
        this.p0 = null;
        localt.a(new c1.a(this.c, this));
        this.q.dispose();
      }
    }
    
    void b(long paramLong)
    {
      this.x.replace(this.q.c(new c1.e(paramLong, this), this.d, this.f));
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.z);
      DisposableHelper.dispose(this);
      this.q.dispose();
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)get());
    }
    
    public void onComplete()
    {
      if (this.y.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.x.dispose();
        this.c.onComplete();
        this.q.dispose();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.y.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.x.dispose();
        this.c.onError(paramThrowable);
        this.q.dispose();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      long l1 = this.y.get();
      if (l1 != Long.MAX_VALUE)
      {
        AtomicLong localAtomicLong = this.y;
        long l2 = 1L + l1;
        if (localAtomicLong.compareAndSet(l1, l2))
        {
          ((c)this.x.get()).dispose();
          this.c.onNext(paramT);
          b(l2);
        }
      }
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.setOnce(this.z, paramc);
    }
  }
  
  static final class c<T>
    extends AtomicLong
    implements v<T>, c, c1.d
  {
    final v<? super T> c;
    final long d;
    final TimeUnit f;
    final w.c q;
    final SequentialDisposable x;
    final AtomicReference<c> y;
    
    c(v<? super T> paramv, long paramLong, TimeUnit paramTimeUnit, w.c paramc)
    {
      this.c = paramv;
      this.d = paramLong;
      this.f = paramTimeUnit;
      this.q = paramc;
      this.x = new SequentialDisposable();
      this.y = new AtomicReference();
    }
    
    public void a(long paramLong)
    {
      if (compareAndSet(paramLong, Long.MAX_VALUE))
      {
        DisposableHelper.dispose(this.y);
        this.c.onError(new TimeoutException(e.d(this.d, this.f)));
        this.q.dispose();
      }
    }
    
    void b(long paramLong)
    {
      this.x.replace(this.q.c(new c1.e(paramLong, this), this.d, this.f));
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.y);
      this.q.dispose();
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)this.y.get());
    }
    
    public void onComplete()
    {
      if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.x.dispose();
        this.c.onComplete();
        this.q.dispose();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE)
      {
        this.x.dispose();
        this.c.onError(paramThrowable);
        this.q.dispose();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      long l1 = get();
      if (l1 != Long.MAX_VALUE)
      {
        long l2 = 1L + l1;
        if (compareAndSet(l1, l2))
        {
          ((c)this.x.get()).dispose();
          this.c.onNext(paramT);
          b(l2);
        }
      }
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.setOnce(this.y, paramc);
    }
  }
  
  static abstract interface d
  {
    public abstract void a(long paramLong);
  }
  
  static final class e
    implements Runnable
  {
    final c1.d c;
    final long d;
    
    e(long paramLong, c1.d paramd)
    {
      this.d = paramLong;
      this.c = paramd;
    }
    
    public void run()
    {
      this.c.a(this.d);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\c1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */