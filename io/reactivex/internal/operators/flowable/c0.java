package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c0<T>
  extends a<T, T>
{
  final w f;
  
  public c0(h<T> paramh, w paramw)
  {
    super(paramh);
    this.f = paramw;
  }
  
  protected void H(b<? super T> paramb)
  {
    this.d.G(new a(paramb, this.f));
  }
  
  static final class a<T>
    extends AtomicBoolean
    implements k<T>, c
  {
    final b<? super T> c;
    final w d;
    c f;
    
    a(b<? super T> paramb, w paramw)
    {
      this.c = paramb;
      this.d = paramw;
    }
    
    public void cancel()
    {
      if (compareAndSet(false, true)) {
        this.d.c(new a());
      }
    }
    
    public void onComplete()
    {
      if (!get()) {
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (get())
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!get()) {
        this.c.onNext(paramT);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (SubscriptionHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    public void request(long paramLong)
    {
      this.f.request(paramLong);
    }
    
    final class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        c0.a.this.f.cancel();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */