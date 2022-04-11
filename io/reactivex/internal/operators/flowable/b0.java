package io.reactivex.internal.operators.flowable;

import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class b0<T>
  extends a<T, T>
{
  final w f;
  final boolean q;
  
  public b0(h<T> paramh, w paramw, boolean paramBoolean)
  {
    super(paramh);
    this.f = paramw;
    this.q = paramBoolean;
  }
  
  public void H(e.b.b<? super T> paramb)
  {
    w.c localc = this.f.b();
    a locala = new a(paramb, localc, this.d, this.q);
    paramb.onSubscribe(locala);
    localc.b(locala);
  }
  
  static final class a<T>
    extends AtomicReference<Thread>
    implements k<T>, e.b.c, Runnable
  {
    final e.b.b<? super T> c;
    final w.c d;
    final AtomicReference<e.b.c> f;
    final AtomicLong q;
    final boolean x;
    e.b.a<T> y;
    
    a(e.b.b<? super T> paramb, w.c paramc, e.b.a<T> parama, boolean paramBoolean)
    {
      this.c = paramb;
      this.d = paramc;
      this.y = parama;
      this.f = new AtomicReference();
      this.q = new AtomicLong();
      this.x = (paramBoolean ^ true);
    }
    
    void a(long paramLong, e.b.c paramc)
    {
      if ((!this.x) && (Thread.currentThread() != get())) {
        this.d.b(new a(paramc, paramLong));
      } else {
        paramc.request(paramLong);
      }
    }
    
    public void cancel()
    {
      SubscriptionHelper.cancel(this.f);
      this.d.dispose();
    }
    
    public void onComplete()
    {
      this.c.onComplete();
      this.d.dispose();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
      this.d.dispose();
    }
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.setOnce(this.f, paramc))
      {
        long l = this.q.getAndSet(0L);
        if (l != 0L) {
          a(l, paramc);
        }
      }
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        e.b.c localc = (e.b.c)this.f.get();
        if (localc != null)
        {
          a(paramLong, localc);
        }
        else
        {
          io.reactivex.internal.util.b.a(this.q, paramLong);
          localc = (e.b.c)this.f.get();
          if (localc != null)
          {
            paramLong = this.q.getAndSet(0L);
            if (paramLong != 0L) {
              a(paramLong, localc);
            }
          }
        }
      }
    }
    
    public void run()
    {
      lazySet(Thread.currentThread());
      e.b.a locala = this.y;
      this.y = null;
      locala.a(this);
    }
    
    static final class a
      implements Runnable
    {
      final e.b.c c;
      final long d;
      
      a(e.b.c paramc, long paramLong)
      {
        this.c = paramc;
        this.d = paramLong;
      }
      
      public void run()
      {
        this.c.request(this.d);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */