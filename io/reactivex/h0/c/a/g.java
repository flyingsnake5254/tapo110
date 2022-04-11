package io.reactivex.h0.c.a;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;

public final class g<T>
  extends io.reactivex.a
{
  final e.b.a<T> c;
  
  public g(e.b.a<T> parama)
  {
    this.c = parama;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc));
  }
  
  static final class a<T>
    implements k<T>, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    e.b.c d;
    
    a(io.reactivex.c paramc)
    {
      this.c = paramc;
    }
    
    public void dispose()
    {
      this.d.cancel();
      this.d = SubscriptionHelper.CANCELLED;
    }
    
    public boolean isDisposed()
    {
      boolean bool;
      if (this.d == SubscriptionHelper.CANCELLED) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT) {}
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.validate(this.d, paramc))
      {
        this.d = paramc;
        this.c.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */