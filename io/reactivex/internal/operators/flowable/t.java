package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicLong;

public final class t<T>
  extends a<T, T>
{
  public t(h<T> paramh)
  {
    super(paramh);
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    this.d.G(new a(paramb));
  }
  
  static final class a<T>
    extends AtomicLong
    implements k<T>, c
  {
    final e.b.b<? super T> c;
    c d;
    boolean f;
    
    a(e.b.b<? super T> paramb)
    {
      this.c = paramb;
    }
    
    public void cancel()
    {
      this.d.cancel();
    }
    
    public void onComplete()
    {
      if (this.f) {
        return;
      }
      this.f = true;
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.f = true;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.f) {
        return;
      }
      if (get() != 0L)
      {
        this.c.onNext(paramT);
        io.reactivex.internal.util.b.c(this, 1L);
      }
      else
      {
        this.d.cancel();
        onError(new MissingBackpressureException("could not emit value due to lack of requests"));
      }
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
      if (SubscriptionHelper.validate(paramLong)) {
        io.reactivex.internal.util.b.a(this, paramLong);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */