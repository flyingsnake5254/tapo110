package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class u<T, R>
  extends a<T, R>
{
  final j<? super T, ? extends o<? extends R>> d;
  final boolean f;
  
  public u(t<T> paramt, j<? super T, ? extends o<? extends R>> paramj, boolean paramBoolean)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramBoolean;
  }
  
  protected void K0(v<? super R> paramv)
  {
    this.c.a(new a(paramv, this.d, this.f));
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements v<T>, c
  {
    final v<? super R> c;
    final boolean d;
    final io.reactivex.e0.b f;
    c p0;
    volatile boolean p1;
    final AtomicInteger q;
    final AtomicThrowable x;
    final j<? super T, ? extends o<? extends R>> y;
    final AtomicReference<io.reactivex.internal.queue.b<R>> z;
    
    a(v<? super R> paramv, j<? super T, ? extends o<? extends R>> paramj, boolean paramBoolean)
    {
      this.c = paramv;
      this.y = paramj;
      this.d = paramBoolean;
      this.f = new io.reactivex.e0.b();
      this.x = new AtomicThrowable();
      this.q = new AtomicInteger(1);
      this.z = new AtomicReference();
    }
    
    void a()
    {
      io.reactivex.internal.queue.b localb = (io.reactivex.internal.queue.b)this.z.get();
      if (localb != null) {
        localb.clear();
      }
    }
    
    void b()
    {
      if (getAndIncrement() == 0) {
        d();
      }
    }
    
    void d()
    {
      v localv = this.c;
      AtomicInteger localAtomicInteger = this.q;
      AtomicReference localAtomicReference = this.z;
      int i = 1;
      for (;;)
      {
        if (this.p1)
        {
          a();
          return;
        }
        if ((!this.d) && ((Throwable)this.x.get() != null))
        {
          localObject = this.x.terminate();
          a();
          localv.onError((Throwable)localObject);
          return;
        }
        int j = localAtomicInteger.get();
        int k = 0;
        if (j == 0) {
          j = 1;
        } else {
          j = 0;
        }
        Object localObject = (io.reactivex.internal.queue.b)localAtomicReference.get();
        if (localObject != null) {
          localObject = ((io.reactivex.internal.queue.b)localObject).poll();
        } else {
          localObject = null;
        }
        if (localObject == null) {
          k = 1;
        }
        if ((j != 0) && (k != 0))
        {
          localObject = this.x.terminate();
          if (localObject != null) {
            localv.onError((Throwable)localObject);
          } else {
            localv.onComplete();
          }
          return;
        }
        if (k != 0)
        {
          j = addAndGet(-i);
          i = j;
          if (j != 0) {}
        }
        else
        {
          localv.onNext(localObject);
        }
      }
    }
    
    public void dispose()
    {
      this.p1 = true;
      this.p0.dispose();
      this.f.dispose();
    }
    
    io.reactivex.internal.queue.b<R> f()
    {
      io.reactivex.internal.queue.b localb;
      do
      {
        localb = (io.reactivex.internal.queue.b)this.z.get();
        if (localb != null) {
          return localb;
        }
        localb = new io.reactivex.internal.queue.b(q.d());
      } while (!this.z.compareAndSet(null, localb));
      return localb;
    }
    
    void g(a<T, R>.a parama)
    {
      this.f.c(parama);
      if (get() == 0)
      {
        int i = 0;
        if (compareAndSet(0, 1))
        {
          if (this.q.decrementAndGet() == 0) {
            i = 1;
          }
          parama = (io.reactivex.internal.queue.b)this.z.get();
          if ((i != 0) && ((parama == null) || (parama.isEmpty())))
          {
            parama = this.x.terminate();
            if (parama != null) {
              this.c.onError(parama);
            } else {
              this.c.onComplete();
            }
            return;
          }
          if (decrementAndGet() == 0) {
            return;
          }
          d();
          return;
        }
      }
      this.q.decrementAndGet();
      b();
    }
    
    void h(a<T, R>.a parama, Throwable paramThrowable)
    {
      this.f.c(parama);
      if (this.x.addThrowable(paramThrowable))
      {
        if (!this.d)
        {
          this.p0.dispose();
          this.f.dispose();
        }
        this.q.decrementAndGet();
        b();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    void i(a<T, R>.a arg1, R paramR)
    {
      this.f.c(???);
      if (get() == 0)
      {
        int i = 0;
        if (compareAndSet(0, 1))
        {
          this.c.onNext(paramR);
          if (this.q.decrementAndGet() == 0) {
            i = 1;
          }
          ??? = (io.reactivex.internal.queue.b)this.z.get();
          if ((i != 0) && ((??? == null) || (???.isEmpty())))
          {
            ??? = this.x.terminate();
            if (??? != null) {
              this.c.onError(???);
            } else {
              this.c.onComplete();
            }
            return;
          }
          if (decrementAndGet() != 0) {
            break label149;
          }
          return;
        }
      }
      synchronized (f())
      {
        ???.offer(paramR);
        this.q.decrementAndGet();
        if (getAndIncrement() != 0) {
          return;
        }
        label149:
        d();
        return;
      }
    }
    
    public boolean isDisposed()
    {
      return this.p1;
    }
    
    public void onComplete()
    {
      this.q.decrementAndGet();
      b();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.q.decrementAndGet();
      if (this.x.addThrowable(paramThrowable))
      {
        if (!this.d) {
          this.f.dispose();
        }
        b();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      try
      {
        paramT = (o)io.reactivex.h0.a.b.e(this.y.apply(paramT), "The mapper returned a null MaybeSource");
        this.q.getAndIncrement();
        a locala = new a();
        if ((!this.p1) && (this.f.b(locala))) {
          paramT.a(locala);
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.p0.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.p0, paramc))
      {
        this.p0 = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    final class a
      extends AtomicReference<c>
      implements n<R>, c
    {
      a() {}
      
      public void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return DisposableHelper.isDisposed((c)get());
      }
      
      public void onComplete()
      {
        u.a.this.g(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        u.a.this.h(this, paramThrowable);
      }
      
      public void onSubscribe(c paramc)
      {
        DisposableHelper.setOnce(this, paramc);
      }
      
      public void onSuccess(R paramR)
      {
        u.a.this.i(this, paramR);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */