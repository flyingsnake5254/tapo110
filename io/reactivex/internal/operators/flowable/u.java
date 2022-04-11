package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class u<T>
  extends a<T, T>
{
  public u(h<T> paramh)
  {
    super(paramh);
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    this.d.G(new a(paramb));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements k<T>, c
  {
    final e.b.b<? super T> c;
    c d;
    volatile boolean f;
    Throwable q;
    volatile boolean x;
    final AtomicLong y = new AtomicLong();
    final AtomicReference<T> z = new AtomicReference();
    
    a(e.b.b<? super T> paramb)
    {
      this.c = paramb;
    }
    
    boolean a(boolean paramBoolean1, boolean paramBoolean2, e.b.b<?> paramb, AtomicReference<T> paramAtomicReference)
    {
      if (this.x)
      {
        paramAtomicReference.lazySet(null);
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable = this.q;
        if (localThrowable != null)
        {
          paramAtomicReference.lazySet(null);
          paramb.onError(localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          paramb.onComplete();
          return true;
        }
      }
      return false;
    }
    
    public void cancel()
    {
      if (!this.x)
      {
        this.x = true;
        this.d.cancel();
        if (getAndIncrement() == 0) {
          this.z.lazySet(null);
        }
      }
    }
    
    void d()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      e.b.b localb = this.c;
      AtomicLong localAtomicLong = this.y;
      AtomicReference localAtomicReference = this.z;
      int i = 1;
      int j;
      do
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        for (long l1 = 0L;; l1 += 1L)
        {
          long l2 = localAtomicLong.get();
          bool1 = false;
          if (l1 == l2) {
            break;
          }
          bool2 = this.f;
          Object localObject = localAtomicReference.getAndSet(null);
          if (localObject == null) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          if (a(bool2, bool3, localb, localAtomicReference)) {
            return;
          }
          if (bool3) {
            break;
          }
          localb.onNext(localObject);
        }
        if (l1 == localAtomicLong.get())
        {
          bool2 = this.f;
          bool3 = bool1;
          if (localAtomicReference.get() == null) {
            bool3 = true;
          }
          if (a(bool2, bool3, localb, localAtomicReference)) {
            return;
          }
        }
        if (l1 != 0L) {
          io.reactivex.internal.util.b.c(localAtomicLong, l1);
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void onComplete()
    {
      this.f = true;
      d();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.q = paramThrowable;
      this.f = true;
      d();
    }
    
    public void onNext(T paramT)
    {
      this.z.lazySet(paramT);
      d();
    }
    
    public void onSubscribe(c paramc)
    {
      if (SubscriptionHelper.validate(this.d, paramc))
      {
        this.d = paramc;
        this.c.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        io.reactivex.internal.util.b.a(this.y, paramLong);
        d();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */