package io.reactivex.internal.operators.flowable;

import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.n;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class k<T, R>
  extends a<T, R>
{
  final j<? super T, ? extends o<? extends R>> f;
  final boolean q;
  final int x;
  
  public k(h<T> paramh, j<? super T, ? extends o<? extends R>> paramj, boolean paramBoolean, int paramInt)
  {
    super(paramh);
    this.f = paramj;
    this.q = paramBoolean;
    this.x = paramInt;
  }
  
  protected void H(e.b.b<? super R> paramb)
  {
    this.d.G(new a(paramb, this.f, this.q, this.x));
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements io.reactivex.k<T>, e.b.c
  {
    final e.b.b<? super R> c;
    final boolean d;
    final int f;
    final j<? super T, ? extends o<? extends R>> p0;
    final AtomicReference<io.reactivex.internal.queue.b<R>> p1;
    e.b.c p2;
    volatile boolean p3;
    final AtomicLong q;
    final io.reactivex.e0.b x;
    final AtomicInteger y;
    final AtomicThrowable z;
    
    a(e.b.b<? super R> paramb, j<? super T, ? extends o<? extends R>> paramj, boolean paramBoolean, int paramInt)
    {
      this.c = paramb;
      this.p0 = paramj;
      this.d = paramBoolean;
      this.f = paramInt;
      this.q = new AtomicLong();
      this.x = new io.reactivex.e0.b();
      this.z = new AtomicThrowable();
      this.y = new AtomicInteger(1);
      this.p1 = new AtomicReference();
    }
    
    void a()
    {
      io.reactivex.internal.queue.b localb = (io.reactivex.internal.queue.b)this.p1.get();
      if (localb != null) {
        localb.clear();
      }
    }
    
    public void cancel()
    {
      this.p3 = true;
      this.p2.cancel();
      this.x.dispose();
    }
    
    void d()
    {
      if (getAndIncrement() == 0) {
        f();
      }
    }
    
    void f()
    {
      e.b.b localb = this.c;
      AtomicInteger localAtomicInteger = this.y;
      AtomicReference localAtomicReference = this.p1;
      int i = 1;
      int k;
      do
      {
        long l1 = this.q.get();
        int j;
        boolean bool;
        Object localObject;
        int m;
        for (long l2 = 0L;; l2 += 1L)
        {
          j = 0;
          bool = l2 < l1;
          if (!bool) {
            break;
          }
          if (this.p3)
          {
            a();
            return;
          }
          if ((!this.d) && ((Throwable)this.z.get() != null))
          {
            localObject = this.z.terminate();
            a();
            localb.onError((Throwable)localObject);
            return;
          }
          if (localAtomicInteger.get() == 0) {
            k = 1;
          } else {
            k = 0;
          }
          localObject = (io.reactivex.internal.queue.b)localAtomicReference.get();
          if (localObject != null) {
            localObject = ((io.reactivex.internal.queue.b)localObject).poll();
          } else {
            localObject = null;
          }
          if (localObject == null) {
            m = 1;
          } else {
            m = 0;
          }
          if ((k != 0) && (m != 0))
          {
            localObject = this.z.terminate();
            if (localObject != null) {
              localb.onError((Throwable)localObject);
            } else {
              localb.onComplete();
            }
            return;
          }
          if (m != 0) {
            break;
          }
          localb.onNext(localObject);
        }
        if (!bool)
        {
          if (this.p3)
          {
            a();
            return;
          }
          if ((!this.d) && ((Throwable)this.z.get() != null))
          {
            localObject = this.z.terminate();
            a();
            localb.onError((Throwable)localObject);
            return;
          }
          if (localAtomicInteger.get() == 0) {
            k = 1;
          } else {
            k = 0;
          }
          localObject = (io.reactivex.internal.queue.b)localAtomicReference.get();
          if (localObject != null)
          {
            m = j;
            if (!((io.reactivex.internal.queue.b)localObject).isEmpty()) {}
          }
          else
          {
            m = 1;
          }
          if ((k != 0) && (m != 0))
          {
            localObject = this.z.terminate();
            if (localObject != null) {
              localb.onError((Throwable)localObject);
            } else {
              localb.onComplete();
            }
            return;
          }
        }
        if (l2 != 0L)
        {
          io.reactivex.internal.util.b.c(this.q, l2);
          if (this.f != Integer.MAX_VALUE) {
            this.p2.request(l2);
          }
        }
        k = addAndGet(-i);
        i = k;
      } while (k != 0);
    }
    
    io.reactivex.internal.queue.b<R> g()
    {
      io.reactivex.internal.queue.b localb;
      do
      {
        localb = (io.reactivex.internal.queue.b)this.p1.get();
        if (localb != null) {
          return localb;
        }
        localb = new io.reactivex.internal.queue.b(h.c());
      } while (!this.p1.compareAndSet(null, localb));
      return localb;
    }
    
    void h(a<T, R>.a parama)
    {
      this.x.c(parama);
      if (get() == 0)
      {
        int i = 0;
        if (compareAndSet(0, 1))
        {
          if (this.y.decrementAndGet() == 0) {
            i = 1;
          }
          parama = (io.reactivex.internal.queue.b)this.p1.get();
          if ((i != 0) && ((parama == null) || (parama.isEmpty())))
          {
            parama = this.z.terminate();
            if (parama != null) {
              this.c.onError(parama);
            } else {
              this.c.onComplete();
            }
            return;
          }
          if (this.f != Integer.MAX_VALUE) {
            this.p2.request(1L);
          }
          if (decrementAndGet() == 0) {
            return;
          }
          f();
          return;
        }
      }
      this.y.decrementAndGet();
      if (this.f != Integer.MAX_VALUE) {
        this.p2.request(1L);
      }
      d();
    }
    
    void i(a<T, R>.a parama, Throwable paramThrowable)
    {
      this.x.c(parama);
      if (this.z.addThrowable(paramThrowable))
      {
        if (!this.d)
        {
          this.p2.cancel();
          this.x.dispose();
        }
        else if (this.f != Integer.MAX_VALUE)
        {
          this.p2.request(1L);
        }
        this.y.decrementAndGet();
        d();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    void j(a<T, R>.a arg1, R paramR)
    {
      this.x.c(???);
      if (get() == 0)
      {
        int i = 0;
        if (compareAndSet(0, 1))
        {
          if (this.y.decrementAndGet() == 0) {
            i = 1;
          }
          if (this.q.get() != 0L)
          {
            this.c.onNext(paramR);
            ??? = (io.reactivex.internal.queue.b)this.p1.get();
            if ((i != 0) && ((??? == null) || (???.isEmpty())))
            {
              ??? = this.z.terminate();
              if (??? != null) {
                this.c.onError(???);
              } else {
                this.c.onComplete();
              }
              return;
            }
            io.reactivex.internal.util.b.c(this.q, 1L);
            if (this.f == Integer.MAX_VALUE) {
              break label168;
            }
            this.p2.request(1L);
          }
          synchronized (g())
          {
            ???.offer(paramR);
            label168:
            if (decrementAndGet() == 0) {
              return;
            }
          }
        }
      }
      synchronized (g())
      {
        ???.offer(paramR);
        this.y.decrementAndGet();
        if (getAndIncrement() != 0) {
          return;
        }
        f();
        return;
      }
    }
    
    public void onComplete()
    {
      this.y.decrementAndGet();
      d();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.y.decrementAndGet();
      if (this.z.addThrowable(paramThrowable))
      {
        if (!this.d) {
          this.x.dispose();
        }
        d();
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
        paramT = (o)io.reactivex.h0.a.b.e(this.p0.apply(paramT), "The mapper returned a null MaybeSource");
        this.y.getAndIncrement();
        a locala = new a();
        if ((!this.p3) && (this.x.b(locala))) {
          paramT.a(locala);
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.p2.cancel();
        onError(paramT);
      }
    }
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.validate(this.p2, paramc))
      {
        this.p2 = paramc;
        this.c.onSubscribe(this);
        int i = this.f;
        if (i == Integer.MAX_VALUE) {
          paramc.request(Long.MAX_VALUE);
        } else {
          paramc.request(i);
        }
      }
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        io.reactivex.internal.util.b.a(this.q, paramLong);
        d();
      }
    }
    
    final class a
      extends AtomicReference<io.reactivex.e0.c>
      implements n<R>, io.reactivex.e0.c
    {
      a() {}
      
      public void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return DisposableHelper.isDisposed((io.reactivex.e0.c)get());
      }
      
      public void onComplete()
      {
        k.a.this.h(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        k.a.this.i(this, paramThrowable);
      }
      
      public void onSubscribe(io.reactivex.e0.c paramc)
      {
        DisposableHelper.setOnce(this, paramc);
      }
      
      public void onSuccess(R paramR)
      {
        k.a.this.j(this, paramR);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */