package io.reactivex.internal.operators.observable;

import e.b.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.q;
import io.reactivex.v;

public final class z<T>
  extends q<T>
{
  final a<? extends T> c;
  
  public z(a<? extends T> parama)
  {
    this.c = parama;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv));
  }
  
  static final class a<T>
    implements k<T>, io.reactivex.e0.c
  {
    final v<? super T> c;
    e.b.c d;
    
    a(v<? super T> paramv)
    {
      this.c = paramv;
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
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */